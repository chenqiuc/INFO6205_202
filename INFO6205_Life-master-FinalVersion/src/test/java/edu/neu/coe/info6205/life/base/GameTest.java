package edu.neu.coe.info6205.life.base;

import edu.neu.coe.info6205.life.library.Library;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    @Test
    public void testRunBlip() {
        String patternName = "Blip";
        System.out.println("Game of Life with starting pattern: " + patternName);
        final String pattern = Library.get(patternName);
        final Game.Behavior generations = Game.run(0L, pattern);
        assertEquals(0, generations.generation);
    }

    @Test
    public void testRunBlip2() {
        String patternName = "Blip2";
        System.out.println("Game of Life with starting pattern: " + patternName);
        final String pattern = Library.get(patternName);
        final Game.Behavior generations = Game.run(0L, pattern);
    }

    @Test
    public void testRunBlock() {
        String patternName = "Block";
        System.out.println("Game of Life with starting pattern: " + patternName);
        final String pattern = Library.get(patternName);
        final Game.Behavior generations = Game.run(0L, pattern);
    }

    @Test
    public void testRunBeehive() {
        String patternName = "Beehive";
        System.out.println("Game of Life with starting pattern: " + patternName);
        final String pattern = Library.get(patternName);
        final Game.Behavior generations = Game.run(0L, pattern);
    }

    @Test
    public void testRunLoaf() {
        String patternName = "Loaf";
        System.out.println("Game of Life with starting pattern: " + patternName);
        final String pattern = Library.get(patternName);
        final Game.Behavior generations = Game.run(0L, pattern);
    }

    @Test
    public void testRunBlinker() {
        String patternName = "Blinker";
        System.out.println("Game of Life with starting pattern: " + patternName);
        final String pattern = Library.get(patternName);
        final Game.Behavior generations = Game.run(0L, pattern);
        assertEquals(new Game.Behavior(2, 0, 1), generations);
    }


    @Test
    public void testRunGlider1() {
        String patternName = "Glider1";
        System.out.println("Game of Life with starting pattern: " + patternName);
        final String pattern = Library.get(patternName);
        final Game.Behavior generations = Game.run(0L, pattern);
//			assertEquals(new Game.Behavior(14, 0, 1), generations);
    }

    @Test
    public void testRunGlider2() {
        String patternName = "Glider2";
        System.out.println("Game of Life with starting pattern: " + patternName);
        final String pattern = Library.get(patternName);
        final Game.Behavior generations = Game.run(0L, pattern);
//			assertEquals(new Game.Behavior(14, 0, 1), generations);
    }

    @Test
    public void testRunGlider3() {
        String patternName = "Glider3";
        System.out.println("Game of Life with starting pattern: " + patternName);
        final String pattern = Library.get(patternName);
        final Game.Behavior generations = Game.run(0L, pattern);
//			assertEquals(new Game.Behavior(14, 0, 1), generations);
    }

    @Test
    public void testRunMyself() {
//        String patternName = "Glider3";
        System.out.println("Game of Life with starting pattern: GA");
//        final String pattern = Library.get(patternName);
        final Game.Behavior generations = Game.run(0L, "4 12, 1 15, 9 15, 0 11, 11 4, 10 10, 0 11, 8 2, 0 15, 2 9, 9 8, 14 7, 11 14, 11 14, 13 8, 15 0, 13 6, 2 8, 8 3, 12 4, 8 0, 12 8, 7 4, 15 11, 7 10, 5 8, 14 12, 1 2, 13 8, 15 9, 10 11, 12 10, 6 7, 7 1, 9 0, 7 15, 14 10, 9 7, 0 3, 12 10, 9 2, 13 0, 14 9, 9 2, 6 11, 4 4, 10 3, 7 6, 8 4, 0 13");
    }

    @Test
    public void generation() {
        // TODO implement test
    }
}