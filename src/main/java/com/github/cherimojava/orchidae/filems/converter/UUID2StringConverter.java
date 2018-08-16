package com.github.cherimojava.orchidae.filems.converter;

import java.util.UUID;

import org.springframework.core.convert.converter.Converter;

public class UUID2StringConverter
    implements Converter<UUID, String>
{

    @Override
    public String convert( UUID source )
    {
        return source.toString();
    }
}
