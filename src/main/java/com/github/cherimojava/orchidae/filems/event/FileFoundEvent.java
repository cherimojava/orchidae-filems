package com.github.cherimojava.orchidae.filems.event;

import java.nio.file.Path;

import lombok.Getter;

/**
 * Event fired if an image is detected(not necessarily a new one)
 */
@Getter
public class FileFoundEvent
{
    private Path path;

    public FileFoundEvent( Path path )
    {
        this.path = path;
    }
}
