package com.test.find;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Find files in path using patterns and min file sizes.
 * 
 * It is extentable.
 * 
 * Example which is implemented using Strategy Pattern. It is just a basic example using Enums
 * It can be made more dynamic at runtime. Please reuse and build on it.
 * 
 * @author aneesh
 */
public class Find {

	public static void main(String[] args) throws URISyntaxException, IOException {

		String folderPath = "/Users/user1/test";

		Path path = Paths.get(folderPath);

		List<Path> files = getFiles(path);

        //Apply all the conditions necessary
		List<ValidationStrategy> validationStrategies = new ArrayList<>();
		validationStrategies.add(ValidationStrategy.JAVA_FILE_PATTERN);
		validationStrategies.add(ValidationStrategy.ONE_KB_MIN_FILE_SIZE);

		for (ValidationStrategy validationStrategy : validationStrategies) {
			validationStrategy.validate(files);
		}
		for (Path file : files) {
			System.out.println(file.getFileName());
		}
	}

    /**
     * Method to get all files in a path
     */
	public static List<Path> getFiles(Path path) throws IOException {

		List<Path> files = new ArrayList<>();

		try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
			for (Path entry : stream) {
				if (Files.isDirectory(entry)) {
					// If you also want to show files under sub directory
					// listFiles(entry, files);
				} else {
					files.add(entry);
				}
			}
		}
		return files;
	}

}
