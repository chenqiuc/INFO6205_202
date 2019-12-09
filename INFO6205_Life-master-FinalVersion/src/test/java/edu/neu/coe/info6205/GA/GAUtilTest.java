package edu.neu.coe.info6205.GA;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class GAUtilTest {

    @Test
    public void testtransform() {
        Chromosome chromosome = new Chromosome(System.currentTimeMillis());
        chromosome.setGene(new boolean[] {true, true, true, false, false, true, false, false});
        String pattern = chromosome.getPattern();
        GAUtil gt = new GAUtil();
        int[][] result = gt.transform(pattern);
        int[][]testing = new int[32][32];
        testing[23][13] = 1;
        assertFalse(Arrays.equals(testing,result));
    }
}
