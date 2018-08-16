package com.github.cherimojava.orchidae.filems.enricher

import com.github.cherimojava.orchidae.filems.persistence.FileHandle
import spock.lang.Specification
import spock.lang.Subject

import java.nio.file.Path
import java.nio.file.Paths

class UUIDEnricherSpec
    extends Specification
{
    @Subject
    UUIDEnricher enricher

    FileHandle.FileHandleBuilder builder

    Path p

    def setup() {
        enricher = new UUIDEnricher()
        builder = Mock(FileHandle.FileHandleBuilder)
        p = Paths.get("/")
    }

    def enrich() {
        when:
        enricher.accept( builder,p )

        then:
        1 * builder.id( _ )
        0 * _
    }
}
