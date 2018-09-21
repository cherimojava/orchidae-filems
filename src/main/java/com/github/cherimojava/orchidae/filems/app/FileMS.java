package com.github.cherimojava.orchidae.filems.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.github.cherimojava.orchidae.filems.FileIndexer;
import com.github.cherimojava.orchidae.filems.converter.cfgConverter;
import com.github.cherimojava.orchidae.filems.enricher.cfgEnricher;
import com.github.cherimojava.orchidae.filems.persistence.FileHandleRepository;

/**
 * Entry point into the application
 */
@SpringBootApplication( scanBasePackageClasses = { FileIndexer.class } )
@EnableMongoRepositories( basePackageClasses = { FileHandleRepository.class } )
@EnableDiscoveryClient
@Import( { cfgConverter.class, cfgEnricher.class } )
public class FileMS
{
    public static void main( String[] args )
    {
        SpringApplication.run( FileMS.class, args );
    }
}
