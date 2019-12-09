package edu.neu.coe.info6205.GA;


/**
 * GAScore.java is the class which contains the score of patterns
 * There are 3 fields, reason, growth rate, generation.
 *
 * Reason represents the cause of patterns' suspension.
 * 0 represents all points died.
 * 1 represents repeated forever.
 * 2 represents unrepeated over 1000 times.
 *
 * Growth rate represents the changing of the points during game processing.
 * GrowthRate = points exist / points initialized.
 * The bigger growthRate, the better.
 *
 * Generation represents the iteration times of pattern
 */
public class GAScore {

    int reason;
    double growthRate;
    long generations;

    public GAScore(int reason, double growthRate, long generations) {
        this.reason = reason;
        this.growthRate = growthRate;
        this.generations = generations;
    }

    public int getReason() {
        return reason;
    }

    public double getGrowthRate() {
        return growthRate;
    }

    public long getGenerations() {
        return generations;
    }

}
