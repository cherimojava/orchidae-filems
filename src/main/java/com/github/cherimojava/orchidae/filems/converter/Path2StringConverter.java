package com.github.cherimojava.orchidae.filems.converter;

import java.nio.file.Path;

import org.springframework.core.convert.converter.Converter;

public class Path2StringConverter
    implements Converter<Path, String>
{

    @Override
    public String convert( Path source )
    {
        return source.toString();
    }
}
