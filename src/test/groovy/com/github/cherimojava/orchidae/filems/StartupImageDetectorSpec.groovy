package com.github.cherimojava.orchidae.filems

import com.github.cherimojava.orchidae.filems.event.FileFoundEvent
import org.assertj.core.util.Sets
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.ApplicationEventPublisher
import org.springframework.core.io.DefaultResourceLoader
import spock.lang.Specification
import spock.lang.Subject

import java.nio.file.Paths

class StartupImageDetectorSpec
    extends Specification
{
@Subject
    StartupImageDetector detector

    ApplicationEventPublisher publisher

    String testBase = DefaultResourceLoader.getResource( "/detectionTest/test.txt" ).getPath(  )

    def setup() {
        detector = new StartupImageDetector()
        publisher = Mock(ApplicationEventPublisher)
        detector.publisher = publisher
        detector.directories = Sets.newLinkedHashSet(Paths.get(testBase).getParent(  ))
    }

    def detectImagesAndSendNotification() {
        when:
        detector.startupListener( Stub( ApplicationReadyEvent) )

        then:
        1 * publisher.publishEvent( _ ) >> {FileFoundEvent e ->
            assert e.getPath() == Paths.get( testBase )
        }
    }
}
