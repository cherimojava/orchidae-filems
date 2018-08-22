package com.github.cherimojava.orchidae.filems.enricher;

import java.nio.file.Path;

import org.springframework.stereotype.Component;

import com.github.cherimojava.orchidae.filems.FileHandleEnricher;
import com.github.cherimojava.orchidae.filems.persistence.FileHandle;

/**
 * Adds the path to the FileHandle
 */
@Component
public class PathEnricher
    implements FileHandleEnricher
{
    @Override
    public void accept( FileHandle.FileHandleBuilder fileHandleBuilder, Path path )
    {
        fileHandleBuilder.path( path );
    }
}
