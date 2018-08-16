package com.github.cherimojava.orchidae.filems;

import java.nio.file.Path;
import java.util.function.BiConsumer;

import com.github.cherimojava.orchidae.filems.persistence.FileHandle;

public interface FileHandleEnricher extends BiConsumer<FileHandle.FileHandleBuilder, Path>
{
}
