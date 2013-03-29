package com.redhat.osas.nashville;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

/**
 * User: jottinge
 * Date: 3/29/13
 * Time: 12:25 PM
 */
public class PositiveInteger implements IParameterValidator {
    public void validate(String name, String value)
            throws ParameterException {
        int n = Integer.parseInt(value);
        if (n < 0) {
            throw new ParameterException("Parameter " + name + " should be positive (found " + value +")");
        }
    }
}
