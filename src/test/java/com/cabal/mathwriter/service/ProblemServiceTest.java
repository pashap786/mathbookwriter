package com.cabal.mathwriter.service;


import org.junit.jupiter.api.Test;

public class ProblemServiceTest {

    private ProblemGeneratorService problemGeneratorService = new ProblemGeneratorService();

    @Test
    public void testModulusThree() {
        System.out.println("modulus 1%3 = "+1%3);
    }

    @Test
    public void testWriteBook() {
        problemGeneratorService.makeMathBook(null);
    }
}
