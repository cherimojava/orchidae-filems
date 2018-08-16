package com.github.cherimojava.orchidae.filems;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.github.cherimojava.orchidae.filems.event.FileFoundEvent;
import com.github.cherimojava.orchidae.filems.persistence.FileHandle;
import com.github.cherimojava.orchidae.filems.persistence.FileHandleRepository;

/**
 * Service checking if the given file is already known to the service
 */
@Service
public class FileIndexer
{
    @Autowired
    FileHandleRepository repository;

    @Autowired
    Optional<Set<FileHandleEnricher>> enricher;

    @EventListener
    public void checkFile( FileFoundEvent e )
    {
        Optional<FileHandle> oneByPath = repository.findOneByPath( e.getPath() );

        if ( !oneByPath.isPresent() )
        {
            FileHandle.FileHandleBuilder builder = FileHandle.builder();
            enricher.orElse( Collections.emptySet() )
                    .forEach( fileHandleEnricher -> fileHandleEnricher.accept( builder, e.getPath() ) );
            repository.insert( builder.build() );
        }
    }
}
