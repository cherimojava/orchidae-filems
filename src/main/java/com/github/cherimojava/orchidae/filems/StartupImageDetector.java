package com.github.cherimojava.orchidae.filems;

import static org.apache.logging.log4j.LogManager.getLogger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.github.cherimojava.orchidae.filems.event.FileFoundEvent;

/**
 * Service running after application startup checking all given directories for images
 */
@Service
public class StartupImageDetector
{
    private static final Logger LOG = getLogger();

    @Value( "${filems.picture.directory:/Users/pknobel/Pictures}" )
    private Set<Path> directories;

    @Autowired
    private ApplicationEventPublisher publisher;

    @EventListener
    public void startupListener( ApplicationReadyEvent e )
    {
        directories.forEach( this::checkDirectory );
    }

    private void checkDirectory( Path p )
    {
        try
        {
            Files.walk( p )
                 .filter( Files::isRegularFile )
                 .map( Path::toAbsolutePath )
                 .forEach( f -> publisher.publishEvent( new FileFoundEvent( f ) ) );
        }
        catch ( IOException e )
        {
            LOG.error( "Failed to scan '{}' for images", p, e );
        }
    }
}
