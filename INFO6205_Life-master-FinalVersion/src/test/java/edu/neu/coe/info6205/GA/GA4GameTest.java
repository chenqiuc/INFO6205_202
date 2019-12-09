package edu.neu.coe.info6205.GA;

import org.junit.Test;

import static org.junit.Assert.*;

public class GA4GameTest {


    /**
     * Use gene length to test calculate() function
     */

    @Test
    public void testCalculate1() {
        GA4Game g4g = new GA4Game(System.currentTimeMillis());
        Chromosome chromosome = g4g.calculate();
        int i = chromosome.getGene().length;
        assertEquals(400, i);
    }

    @Test
    public void testCalculate2() {
        GA4Game g4g = new GA4Game(System.currentTimeMillis());
        Chromosome chromosome = g4g.calculate();
        int i = chromosome.getGene().length;
        assertEquals(400, i);
    }


    @Test
    public void changeX1() {
        GA4Game g4g = new GA4Game(System.currentTimeMillis());
        Chromosome chromosome = new Chromosome(System.currentTimeMillis());
        chromosome.setGene(new boolean[]{false,true,true,true,true,false,true,false});
        assertEquals("7 10",g4g.changeX(chromosome));
    }

    @Test
    public void changeX2() {
        GA4Game g4g = new GA4Game(System.currentTimeMillis());
        Chromosome chromosome = new Chromosome(System.currentTimeMillis());
        chromosome.setGene(new boolean[]{true,true,true,true,false,false,false,false});
        assertEquals("15 0",g4g.changeX(chromosome));
    }


    @Test
    public void calculateY1() {

        GA4Game g4g = new GA4Game(System.currentTimeMillis());
        String x = "1 3, 2 4, 3 4, 4 3, 4 2, 3 1, 2 2";
        GAScore score = g4g.calculateY(x);
        assertFalse(score.generations==0);
        assertTrue(score.reason==0||score.reason==1||score.reason==2);
        assertTrue(score.growthRate>=0);

    }

    @Test
    public void calculateY2() {

        GA4Game g4g = new GA4Game(System.currentTimeMillis());
        String x = "1 2, 2 1, 3 1, 4 2, 3 3, 2 3";
        GAScore score = g4g.calculateY(x);
        assertFalse(score.generations==0);
        assertTrue(score.reason==0||score.reason==1||score.reason==2);
        assertTrue(score.growthRate>=-1);

    }
}