package com.github.cherimojava.orchidae.filems.enricher;

import java.nio.file.Path;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.github.cherimojava.orchidae.filems.FileHandleEnricher;
import com.github.cherimojava.orchidae.filems.persistence.FileHandle;

/**
 * adds a generated UUID to the FileHandle
 */
@Component
public class UUIDEnricher implements FileHandleEnricher
{
    @Override
    public void accept( FileHandle.FileHandleBuilder fileHandleBuilder, Path path )
    {
        fileHandleBuilder.id( UUID.randomUUID() );
    }
}
