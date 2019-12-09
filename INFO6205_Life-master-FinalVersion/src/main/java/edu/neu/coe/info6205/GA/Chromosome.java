package edu.neu.coe.info6205.GA;

import io.jenetics.util.RandomRegistry;

import java.util.Random;

/**
 *@Description: Genetic Chromosome
 */
public class Chromosome {

    /**
     * using boolean array to act as genotype, such as 00010110011101
     * The length of array is 400 [(4+4)*50]
     * Because we want to show 50 points in the pattern, and each point will contain 8 numbers in an array, and range is from (0,0) to (15,15)
     */
    private boolean[] gene;
    /**
     * Using score to represents fitness, including reason and growth rate.
     */
    private GAScore score;

    private Random random;

    public GAScore getScore() {
        return score;
    }

    public void setScore(GAScore score) {
        this.score = score;
    }


    /**
     * Generate genotype randomly
     * This size is 400
     * Using 400 as the length to initialize the boolean array, and then assign values for each elements with foreach
     * For this boolean array, the value of each element is true or false, true = 1, false = 0
     */
    public Chromosome(int size, long seed) {
        this.random = new Random(seed);
        if (size <= 0) {
            return;
        }
        initGeneSize(size);
        for (int i = 0; i < size; i++) {
            gene[i] = this.random.nextDouble() >= 0.5;
        }
    }

    /**
     * Generate a new gene
     */
    public Chromosome(long seed) {
        this.random = new Random(seed);
    }

    /**
     * Generate a same gene according to the given gene
     */
    public static Chromosome clone(final Chromosome c, long seed) {
        if (c == null || c.gene == null) {
            return null;
        }
        Chromosome copy = new Chromosome(seed);
        copy.initGeneSize(c.gene.length);
        for (int i = 0; i < c.gene.length; i++) {
            copy.gene[i] = c.gene[i];
        }
        return copy;
    }

    /**
     * Initialize a genotype/ a boolean array
     * The length/size of this array is 400
     */
    private void initGeneSize(int size) {
        if (size <= 0) {
            return;
        }
        gene = new boolean[size];
    }

    /**
     * @param num
     * This function is to mutate the current genotype
     * Different with crossing. Crossing means to give two different genotypes and then cross some elements of them to generate new two chromosomes
     * This mutation means to mutate the value of some positions of one genotype
     * If you give the num is 10, this means the computer will find randomly 10 positions of this genotype (the whole size is 400) to mutate
     * The specific value mutation means opposite the value, such as true turns to false
     */
    public void mutation(int num) {
        //允许变异
        int size = gene.length;
        for (int i = 0; i < num; i++) {
            //寻找变异位置
//            System.out.println(this.getPattern());
//            System.out.println(random);
            int at = ((int)(this.random.nextDouble() * size)) % size;
            //变异后的值
            boolean bool = !gene[at];
            gene[at] = bool;
        }
    }


    /**
     * Change the genotype to the phenotype we want
     * Genotype is an array like this 0101100011010110100101
     * Phenotype is the pattern we will use in the Game of Life
     * 4 and 8 means the range of each point is from (0,0) to (15,15) in a 16*16 board
     * The binary form of (0,0) and (15,15) is (0000,0000) and (1111,1111)
     * In genotype, every 8 numbers means one point, top 4 means X and tail 4 means Y.
     */
    public String getPattern() {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for(boolean g : gene) {
            sb.append(g ? 1 : 0);
            count++;
            if (count - 8 == 0) {
                sb.append(",");
                count = 0;
            }
        }
        String bitStr = sb.substring(0, sb.lastIndexOf(","));
        String[] splitBitStr = bitStr.split(",");
        sb = new StringBuilder();
        for(String str : splitBitStr) {
            String strX = str.substring(0, 4);
            String strY = str.substring(4);
            int x = Integer.parseInt(strX, 2);
            int y = Integer.parseInt(strY, 2);
            sb.append(x + " " + y + ", ");
        }
        String pattern = sb.substring(0, sb.lastIndexOf(","));
        return pattern;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(boolean b : gene) {
            sb.append(b ? "1" : "0");
        }
        return sb.toString();
    }

    public void setGene(boolean[] gene) {
        this.gene = gene;
    }

    public boolean[] getGene() {
        return gene;
    }
}