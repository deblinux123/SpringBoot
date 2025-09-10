package com.example.ValidationDemo.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CurseCodeConstraintValidator implements ConstraintValidator<CourseCode, String>
{
    private String coursePrefix;

    @Override
    public void initialize(CourseCode theCourseCode)
    {
        coursePrefix = theCourseCode.value();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext thConstraintValidatorContext) {

        boolean result;

        if (theCode != null)
            result = theCode.startsWith(coursePrefix);
        else
            return result = true;

        return result;
    }
}
