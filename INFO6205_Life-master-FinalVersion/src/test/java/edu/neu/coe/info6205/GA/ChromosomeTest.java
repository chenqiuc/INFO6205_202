package edu.neu.coe.info6205.GA;

import org.junit.Test;

import static org.junit.Assert.*;

public class ChromosomeTest {

    // testing GetPattern Function
    @Test
    public void testGetPattern1() {
        Chromosome chromosome = new Chromosome(System.currentTimeMillis());
        chromosome.setGene(new boolean[] {true, true, true, false, false, true, false, false});
        String pattern = chromosome.getPattern();
        assertEquals("14 4", pattern);

    }
    @Test
    public void testGetPattern2() {
        Chromosome chromosome = new Chromosome(System.currentTimeMillis());
        chromosome.setGene(new boolean[] {false, true, false, true, false, false, true, true});
        String pattern = chromosome.getPattern();
        assertEquals("5 3", pattern);
    }

    // testing initGeneSize Function
//    @Test
//    public void testinitGeneSize() {
//        Chromosome chromosome = new Chromosome();
//        chromosome.initGeneSize(8);
//        assertEquals(8, chromosome.getGene().length);
//    }

    // testing clone Function
    @Test
    public void testclone() {
        Chromosome chromosome = new Chromosome(System.currentTimeMillis());
        chromosome.setGene(new boolean[] {true, true, true, false, false, true, false, false});
        Chromosome chromosome2 = chromosome.clone(chromosome, System.currentTimeMillis());
        String pattern = chromosome2.getPattern();
        assertEquals("14 4", pattern);
    }

    // testing mutation Function
    @Test
    public void testmutation() {
        Chromosome chromosome = new Chromosome(System.currentTimeMillis());
        chromosome.setGene(new boolean[] {true, true, true, false, false, true, false, false});
        Chromosome chromosome2 = chromosome.clone(chromosome, System.currentTimeMillis());
        chromosome2.mutation(10);
        assertFalse(chromosome.getPattern().equals(chromosome2.getPattern()));
    }
}

