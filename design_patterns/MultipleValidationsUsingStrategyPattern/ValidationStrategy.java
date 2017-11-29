package com.test.find;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.util.ArrayList;
import java.util.List;

/**
 * We can use enum if we want to have predefined strategies. Else we can
 * implement several regular classes for each validation strategy and check many
 * conditions runtime.
 * 
 * @author aneesh
 *
 */
public enum ValidationStrategy implements Validation {

	ONE_KB_MIN_FILE_SIZE {
		@Override
		public <T> void validate(List<T> files) throws IOException {

			List<Path> validFiles = new ArrayList<>();
			
			Integer minFileSizeInMegaBytes = 1;
			if (minFileSizeInMegaBytes != null) {
				//2^10 as we want to check one kb
				double denominator = Math.pow(2, 10);
				for (T file : files) {
					Path entry = (Path) file;
					long size = Files.size(entry);
					double actualFileSizeInMegaBytes = size / denominator;
					if (actualFileSizeInMegaBytes > minFileSizeInMegaBytes) {
						validFiles.add(entry);
					}
				}
			}
			// We need to clear current files structure and add all valid files
			// to it.
			files.clear();
			files.addAll((List<T>) validFiles);
		}

	},
	JAVA_FILE_PATTERN {
		@Override
		public <T> void validate(List<T> files) throws IOException {

			List<Path> validFiles = new ArrayList<>();
			String filePattern = "*.java";
			PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:" + filePattern);
			if (matcher != null) {
				for (T file : files) {
					Path entry = (Path) file;
					if (matcher.matches(entry.getFileName())) {
						validFiles.add(entry);
					}
				}
			}
			// We need to clear current files structure and add all valid files
			// to it.
			files.clear();
			files.addAll((List<T>) validFiles);
		}

	};

}
