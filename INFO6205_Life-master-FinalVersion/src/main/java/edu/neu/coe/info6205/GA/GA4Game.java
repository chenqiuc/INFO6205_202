package edu.neu.coe.info6205.GA;

import edu.neu.coe.info6205.life.base.Game;

public class GA4Game extends GeneticAlgorithm{

    private long seed;


    /**
     * @param seed
     * Matrix is 16*16, coordinate can be represented from (0,0) to (15,15).
     * x-axis and y-axis both in the range of 0 to 15, which is from 0000 to 1111 in binary.
     * The length of the pattern is 400, because every point has x-axis number and y-axis number,
     * each number corresponding to a length 4 array of binary.
     *
     * Maximum number of iteration is 10, population size is 4.
     */
    public GA4Game(long seed) {
        super(400, 4, 10, seed);
    }

    /**
     * Calculate the phenotype based on genotype.
     * Invoke getPattern()
     */
    @Override
    public String changeX(Chromosome chro) {
        String pattern = chro.getPattern();
        return pattern;
    }

    /**
     * Calculate fitness based on phenotype.
     * The 3 field, reason, growth rate, generation in the fitness is the behavior of patterns in the game of life
     * All of thee 3 field is pass in an object of GAScore
     */
    @Override
    public GAScore calculateY(String x) {

        String patternName = "Genetic Pattern";
        System.out.println("Game of Life with starting pattern: " + patternName);
        final Game.Behavior generations = Game.run(0L, x);
        GAScore gaScore = new GAScore(generations.getReason(), generations.growth, generations.getGeneration());

        return gaScore;

    }
}