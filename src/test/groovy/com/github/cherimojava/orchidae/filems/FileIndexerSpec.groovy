package com.github.cherimojava.orchidae.filems

import com.github.cherimojava.orchidae.filems.event.FileFoundEvent
import com.github.cherimojava.orchidae.filems.persistence.FileHandle
import com.github.cherimojava.orchidae.filems.persistence.FileHandleRepository
import com.google.common.collect.Sets
import spock.lang.Specification
import spock.lang.Subject

import java.nio.file.Paths

class FileIndexerSpec
    extends Specification
{
    @Subject
    FileIndexer indexer

    FileHandleRepository repository

    FileHandleEnricher enricher

    def setup()
    {
        indexer = new FileIndexer()
        repository = Mock( FileHandleRepository )
        indexer.repository = repository
        enricher = Mock( FileHandleEnricher )
        indexer.enricher = Optional.of( Sets.newHashSet( enricher ) )
    }

    def lookupExistingFile()
    {
        when:
        indexer.checkFile( e )

        then:
        1 * repository.findOneByPath( p ) >> Optional.of( FileHandle.builder().build() )
        0 * _

        where:
        p = Paths.get( "." )
        e = new FileFoundEvent( p )
    }

    def createNewFile()
    {
        given:
        indexer.enricher
        when:
        indexer.checkFile( e )

        then:
        1 * repository.findOneByPath( p ) >> Optional.empty()
        1 * repository.insert( _ )
        1 * enricher.accept( _, p )

        where:
        p = Paths.get( "." )
        e = new FileFoundEvent( p )
    }
}
