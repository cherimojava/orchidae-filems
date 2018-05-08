package com.github.cherimojava.orchidae.filems.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication( scanBasePackageClasses = {} )
@Import( {} )
public class Application
{
    public static void main( String[] args )
    {
        SpringApplication.run( Application.class, args );
    }
}
