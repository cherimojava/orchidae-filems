package com.github.cherimojava.orchidae.filems.converter

import spock.lang.Specification
import spock.lang.Subject

import java.nio.file.Paths

class String2PathConverterSpec
    extends Specification
{

    @Subject
    String2PathConverter converter

    def setup()
    {
        converter = new String2PathConverter()
    }

    def convert()
    {
        when:
        def result = converter.convert( source )

        then:
        result == expect

        where:
        expect                  | source
        Paths.get( "/var/tmp" ) | "/var/tmp"
    }
}
