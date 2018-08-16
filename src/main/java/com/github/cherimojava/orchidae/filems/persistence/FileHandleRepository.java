package com.github.cherimojava.orchidae.filems.persistence;

import java.nio.file.Path;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileHandleRepository extends MongoRepository<FileHandle,UUID>
{
    Optional<FileHandle> findOneByPath( Path path);
}
