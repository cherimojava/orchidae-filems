package com.github.cherimojava.orchidae.filems.persistence;

import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Document( collection = "files" )
@Data
@Builder
public class FileHandle
{
    @Id
    private UUID id;

    private Path path;

    private LocalDateTime creationTime;
}
