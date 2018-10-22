package com.sleepyheadsophie.generator.person;

import com.sleepyheadsophie.model.Gender;

public class FactoryGenerator {
    private static MaleGenerator maleGenerator = new MaleGenerator();
    private static FemaleGenerator femaleGenerator = new FemaleGenerator();

    public static PersonGenerator getFactory(Gender gender) {
        if (gender == Gender.MALE) return maleGenerator;
        else return femaleGenerator;
    }
}

