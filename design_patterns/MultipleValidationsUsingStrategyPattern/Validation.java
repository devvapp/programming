package com.test.find;

import java.io.IOException;
import java.util.List;

/**
 * Validation is a base interface to implement various validations like size check, pattern check etc
 * 
 * @author aneesh
 */
public interface Validation {

	public <T> void validate(List<T> input) throws IOException;

}
