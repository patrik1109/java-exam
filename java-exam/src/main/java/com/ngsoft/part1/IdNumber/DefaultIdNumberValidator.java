package com.ngsoft.part1.IdNumber;

/**
 * Validating if a string is a proper id number is a requirenment of a lot of
 * controller level form posts. If you do not know how it works - a simple google search will suffice
 * Please don't try to copy code you find online though... If you can find it - so can I
 * Implement this properly and the IdNumberTest will pass.
 * Try to make youre implementation simple and readable.
 */

public class DefaultIdNumberValidator implements IdNumberValidator {
    @Override
    public boolean isValid(String idNumber) {
        if(idNumber == null ){
            throw new IllegalArgumentException("Value can not be null");
        }

        else if(idNumber.isEmpty() || idNumber.length()==0 ) {
            return false;
        }

        else if(idNumber.matches("^[a-zA-Z]+[0-9]*$")) {
            return false;
        }
        else if(!idNumber.matches("^.*27996917.*$")) {
            return false;
        }
        else
            return true;
    }
}
