package edu.neu.coe.info6205.GA;

import io.jenetics.util.RandomRegistry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public abstract class GeneticAlgorithm {
    private List<Chromosome> population = new ArrayList<>();
    private int popSize;//种群数量
    private int geneSize;//基因最大长度
    private int maxIterNum;//最大迭代次数
    private int maxMutationNum = 400;//最大变异步长
    private long seed;
    private Random random;

    private int generation = 1;//当前遗传到第几代

    public GeneticAlgorithm(int geneSize, int popSize, int maxIterNum, long seed) {
        this.geneSize = geneSize;
        this.popSize = popSize;
        this.maxIterNum = maxIterNum;
        this.seed = seed;
        this.random = new Random(seed);
    }

    /**
     * This function is the core function of Genetic Algorithm
     * To generate each generations(iteration) according to the max number of generations we set
     */
    public Chromosome calculate() {
        //初始化种群
        generation = 1;
        init();
        while (generation < maxIterNum) {
            //种群遗传
            evolve();
            print();
            generation++;
        }
        return population.get(0);
    }

    /**
     * To print each generation's properties
     */
    private void print() {
        System.out.println("--------------------------------");
        System.out.println("the generation is: " + generation);
        System.out.println("the population size is: " + population.size());
        if(!population.isEmpty()) {
            System.out.println("the individual who has the best fitness: " + population.get(0).getPattern());
        }
    }


    /**
     * Initialize the population
     * Initialize each one (each chromosome) of the population according to the size of population, and then put these
     * chromosome to the population pool
     * population means a list which contains the chromosomes of this times
     */
    private void init() {
        population = new ArrayList<>();
        for (int i = 0; i < popSize; i++) {
            Chromosome chro = new Chromosome(geneSize, seed);
            population.add(chro);
        }
        calculateScore();
    }

    /**
     * Inheritance
     * 1. To generate a new List to hold the chromosomes of next generation
     * 2. With fitness to order all the chromosomes of this generation
     * 2-1. fitness is to score each chromosome (by getScore function)
     * 2-2. Score of fitness is the object of GAScore class, which contains three fields: reason, generations, growthRate
     * 2-3. The ordering standard is: If Reason is 2; Which generations is bigger; which growthRate is better
     * 3. After ordering the chromosomes of this generation, the better half(having the higher score of fitness) will be
     * saved and passed to the next generation
     * 4. At the same time, next generation should conclude such better half and mutation ones from the clone ones of such better half
     * 5. So we can guarantee the number of chromosomes of each generation is same. And in each generation, using fitness
     * to order all the chromosomes and using mutation to adding new genotypes, to find the best genotypes(highest score of fitness)
     */
    private void evolve() {
        List<Chromosome> nextPopulation = new ArrayList<>();

        Collections.sort(population, (o1, o2) -> {
            if(o1.getScore().getReason() != 2 && o2.getScore().getReason() != 2) {
                return 0;
            } else if(o1.getScore().getReason() == 2 && o2.getScore().getReason() != 2) {
                return -1;
            } else if(o1.getScore().getReason() != 2 && o2.getScore().getReason() == 2) {
                return 1;
            } else {
                if(o1.getScore().getGenerations() == o2.getScore().getGenerations()) {
                    if(o1.getScore().getGrowthRate() == o2.getScore().getGrowthRate()) {
                        return 0;
                    }
                    return o1.getScore().getGrowthRate() > o2.getScore().getGrowthRate() ? -1 : 1;
                } else {
                    return o1.getScore().getGenerations() > o2.getScore().getGenerations() ? -1 : 1;
                }
            }
        });

        for(int i = 0; i < population.size() / 2; i++) {
            nextPopulation.add(population.get(i));
        }

        List<Chromosome> temp = new ArrayList<>();
        for(Chromosome chro : nextPopulation) {
            int mutationNum = (int) (this.random.nextDouble() * maxMutationNum);
            Chromosome clone = Chromosome.clone(chro, seed);
            clone.mutation(mutationNum);
            temp.add(clone);
        }
        nextPopulation.addAll(temp);

        population.clear();
        population.addAll(nextPopulation);

        calculateScore();
    }

    /**
     * Calculate the fitness of each chromosomes of this current generation
     */
    private void calculateScore() {
        for (Chromosome chro : population) {
            setChromosomeScore(chro);
        }
    }


    /**
     * Set score of each chromosome
     * calculate the fitness score for each chromosome of current generation
     * The calculation method is :
     * 1. Get phenotype (String pattern) from the genotype (01001111010011011)
     * 2. Calculate the fitness score/ GAScore (Y) according to the phenotype
     */
    private void setChromosomeScore(Chromosome chro) {
        if (chro == null) {
            return;
        }
        String x = changeX(chro);
        GAScore y = calculateY(x);
        chro.setScore(y);

    }


    /**
     * Get the phenotype from genotype
     */

    /**
     * Changing the binary system to the relative X
     */

    public abstract String changeX(Chromosome chro);


    /**
     * Y = F(X)
     */
    public abstract GAScore calculateY(String x);

}