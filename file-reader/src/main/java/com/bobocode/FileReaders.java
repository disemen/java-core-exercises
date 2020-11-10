package com.bobocode;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * {@link FileReaders} privides an API that allow to read whole file into a {@link String} by file name.
 */
public class FileReaders {

    /**
     * Returns a {@link String} that contains whole text from the file specified by name.
     *
     * @param fileName a name of a text file
     * @return string that holds whole file content
     */
    public static String readWholeFile(String fileName) {
        //todo: done
        try {
            Objects.requireNonNull(fileName);
            URL fileUrl = FileReaders.class.getClassLoader().getResource(fileName);
            Path path = Paths.get(Objects.requireNonNull(fileUrl).toURI());

//            return Files.lines(path).collect(Collectors.joining("\n"));
            return String.join("\n", Files.readAllLines(path));
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }

        return "";
    }
}
