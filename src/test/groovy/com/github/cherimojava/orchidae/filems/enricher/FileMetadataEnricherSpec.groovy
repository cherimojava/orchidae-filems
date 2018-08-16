package com.github.cherimojava.orchidae.filems.enricher

import com.github.cherimojava.orchidae.filems.persistence.FileHandle
import spock.lang.Specification
import spock.lang.Subject

import java.nio.file.Path
import java.nio.file.Paths

class FileMetadataEnricherSpec
    extends Specification
{
    @Subject
    FileMetadataEnricher enricher

    FileHandle.FileHandleBuilder builder

    Path p

    def setup() {
        enricher = new FileMetadataEnricher()
        builder = Mock(FileHandle.FileHandleBuilder)
        p = Paths.get("/")
    }

    def enrich() {
        when:
        enricher.accept( builder,p )

        then:
        1 * builder.path( p )
        0 * _
    }
}
