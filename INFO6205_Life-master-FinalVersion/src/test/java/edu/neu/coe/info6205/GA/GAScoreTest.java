package edu.neu.coe.info6205.GA;

import org.junit.Test;

import static org.junit.Assert.*;

public class GAScoreTest {

    @Test
    public void testgetReason() {
        GAScore gs = new GAScore(0,0.3,80);
        int reason = gs.getReason();
        assertEquals(0, reason);
    }

    @Test
    public void testgetGrowthRate() {
        GAScore gs = new GAScore(1,0.7,80);
        double gR = gs.getGrowthRate();
        assertEquals(0.7,gR, 0.01);
    }

    @Test
    public void testgetGenerations() {
        GAScore gs = new GAScore(0,0.3,80);
        long gr = gs.getGenerations();
        assertEquals(80, gr);
    }
}
