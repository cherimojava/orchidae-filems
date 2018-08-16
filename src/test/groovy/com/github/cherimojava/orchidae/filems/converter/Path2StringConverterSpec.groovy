package com.github.cherimojava.orchidae.filems.converter

import spock.lang.Specification
import spock.lang.Subject

import java.nio.file.Paths

class Path2StringConverterSpec
    extends Specification
{

    @Subject
    Path2StringConverter converter

    def setup()
    {
        converter = new Path2StringConverter()
    }

    def convert()
    {
        when:
        def result = converter.convert( source )

        then:
        result == expect

        where:
        expect     | source
        "/var/tmp" | Paths.get( "/var/tmp" )
    }
}
