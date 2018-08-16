package com.github.cherimojava.orchidae.filems.converter

import spock.lang.Specification
import spock.lang.Subject

class String2UUIDConverterSpec
    extends Specification
{

    @Subject
    String2UUIDConverter converter

    def setup()
    {
        converter = new String2UUIDConverter()
    }

    def convert()
    {
        when:
        def result = converter.convert( source )

        then:
        result == expect

        where:
        expect                                                    | source
        UUID.fromString( "931c5f7a-98df-42d3-b3cc-4313eabdc595" ) | "931c5f7a-98df-42d3-b3cc-4313eabdc595"
    }
}
