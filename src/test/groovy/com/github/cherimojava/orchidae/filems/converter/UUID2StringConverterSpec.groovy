package com.github.cherimojava.orchidae.filems.converter

import spock.lang.Specification
import spock.lang.Subject

class UUID2StringConverterSpec
    extends Specification
{

    @Subject
    UUID2StringConverter converter

    def setup()
    {
        converter = new UUID2StringConverter()
    }

    def convert()
    {
        when:
        def result = converter.convert( source )

        then:
        result == expect

        where:
        expect                                 | source
        "931c5f7a-98df-42d3-b3cc-4313eabdc595" | UUID.fromString( "931c5f7a-98df-42d3-b3cc-4313eabdc595" )
    }
}
