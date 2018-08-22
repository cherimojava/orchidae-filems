package com.github.cherimojava.orchidae.filems.converter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import com.google.common.collect.Lists;

@Configuration
@ComponentScan
public class cfgConverter
{
    @Bean
    @Primary
    public MongoCustomConversions mongoCustomConversions()
    {
        return new MongoCustomConversions( Lists.newArrayList( new Path2StringConverter(), new String2PathConverter(), new UUID2StringConverter(), new String2UUIDConverter() ) );
    }

}
