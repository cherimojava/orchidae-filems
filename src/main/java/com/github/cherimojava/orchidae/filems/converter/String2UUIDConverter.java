package com.github.cherimojava.orchidae.filems.converter;

import java.util.UUID;

import org.springframework.core.convert.converter.Converter;

public class String2UUIDConverter
    implements Converter<String, UUID>
{

    @Override
    public UUID convert( String source )
    {
        return UUID.fromString( source );
    }
}
