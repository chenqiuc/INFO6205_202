# GA for Life

INFO6205 - Team202

Jianru Wang  001447006

Jing Ren     001447030

Qiuchi Chen  001448400


## Introduction
First of all, the GA for life project obey the rule of genetic algorithm and the principles of the game of life.

### Genetic Algorithm
 A genetic algorithm is a search heuristic that is inspired by Charles Darwin’s theory of natural evolution. This algorithm reflects the process of natural selection where the fittest individuals are select

The process of natural selection starts with the selection of fittest individuals from a population. They produce offspring which inherit the characteristics of the parents and will be added to the next generation. If parents have better fitness, their offspring will be better than parents and have a better chance at surviving. This process keeps on iterating and at the end, a generation with the fittest individuals will be found.

This notion can be applied for a search problem. We consider a set of solutions for a problem and select the set of best ones out of them.

Five phases are considered in a genetic algorithm: 1. Initial population. 2. Fitness function. 3. Selection. 4. Crossover. 5. Mutation(We just used mutation in this project)

### Game of Life
The Game of Life is kind of artificial game played on a two-dimensional rectangular grid of cells. Each cell has two status — alive or dead. The status of each cell changes each turn of the game (also called a generation) depending on the statuses of that cell's 8 neighbors.

The first generation is the initial pattern(produce randomly in the project) . The second generation evolves from applying the rules simultaneously to every cell on the game board. Afterwards, we obey the rules to create future generations iteratively. For each generation of the game, a cell's status in the next generation is determined by a set of rules. These simple rules are as follows:

If the cell is alive, then it stays alive if it has either 2 or 3 live neighbors
If the cell is dead, then it springs to life only in the case that it has 3 live neighbors

### GA for Life Project
Project initializes the first generation of pattern randomly. Then used genetic algorithm to choose the best half of the patterns and mutate their genes to fill another half, these two step is repeated over and over again, util we find a pattern which could exist forever.

We produced Chromosome.java, GA4Game.java, GAScore.java, GAUtil.java, GeneticAlgorithm.java for Genetic Algorithm implementation. And we also produced GameOfLife.java, GOL.java for game of life functions and UI.

### Glossary
Gene/Genotype: The binary representation of a phenotype.

Phenotype: a coordinate on a two-dimensional matrix

Pattern: a series of coordinates.

Chromosome: a series of binary numbers represents Pattern

Growth rate: The ratio of number of points exist on the matrix after several generations to the number of points in the first generation.

Reason: represents the outcome of the point survival.

Generation: the number of times that genetic algorithm iterates to produce new pattern.

Mutation: the process that change the genotype randomly.

Fitness: the total generation which is iterated before the pattern dies.

Evolve: the process to choose the best half of patterns and mutation them to fill another half of population.

### Project Run
We run project through GOL.java, is the entry of the project. After we run it, first we will see the output at the terminal.

Project is choosing the right pattern which can exist forever and produce more points. After about twenty seconds, the pattern we need is produced and UI shows as below.

The pattern shows on the UI will exist forever and obey the rules of game of life.

## Impelementation

### Genetic Algorithm:
#### 1. Chromosome.java
The purpose of Chromosome.java is to generate Genotype(a boolean array), to clone the the optimal chromosome you need, to mutate the Genotype randomly, and to get the pattern needed in Game Of Life(Phenotype) from Genotype. 

##### 1）Generate Genotype:
The Genotype is a boolean array in this class named “gene”, and in order to get 50 points in the first pattern, the initial length of this gene array is 400. 
Also overriding the ‘toString’ function to change the boolean array into a int array which only contains 0 and 1.

##### 2）Clone Genotype:
After using ‘fitness’ function(in ‘evolve’ function of GeneticAlgorithm.java ) to order all of the genotypes, choosing the better half to be the next generation, and then clone them to use the copy ones to do the next ‘mutation’ step.

##### 3) Mutation:

After using ‘fitness’ function(in ‘evolve’ function of GeneticAlgorithm.java ) to order all of the genotypes and choosing the better half to be the next generation and cloning such better genotypes, according to the number of mutation point you hope, finding the mutation positions randomly and then opposing the values, like ‘true’ turns to ‘false’, and  ‘false’ turn to ‘true’.

*：Giving a seed to Random method in GOL class in order to be able to make the behavior of run is repeatable. 


##### 4) Get the pattern needed in Game Of Life:

Turn the genotype(‘gene’ array) to the phenotype(used in Game of Life.java)

#### 2. GeneticAlgorithm.java

The meaning of this class is to inherit(the generation numbers cannot be larger than maximum of Iteration times. And then get the most optimal pattern to pass to the Game of Life as Pattern.
 
##### 1）Calculate(The core function of whole class)
##### 2) Init
In order to complete the above function, at first we need to initialize the whole population.
##### 3) Evolve(The core is to using fitness to )
###### 3.1 Every time we create a new list to hold the next generation
###### 3.2 Ordering all of the genotypes of this population by fitness. The score of fitness includes ‘reason’, ’generations’, ’growthRate’
###### The ordering standard is :
	If Reason is larger than 2;
	Which Generations is bigger;
	Which GrowthRate is better;
###### 3.3 Choosing the better half(the half of higher fitness score) as next generations
###### 3.4 Clone the better half in order to make mutation.
###### 3.5 The better half of last generation and the new mutations of them consist the next generation

#### 3. GA4Game.java

GA4Game implements the abstract class ‘GeneticAlgorithm’, to get the phenotype from genotype, and to generate behavior(reason, growthRate, generations) bu ‘Run’ function. Of ‘Game’ class.

Setting the range of each point is from (0, 0) to (15, 15), which means from 00000000 to 11111111. The pattern contains 50 points. And because each point contains 8 numbers, so the max length of genotype is 400.

Setting Iteration times as 10 and the number of chromosomes in one population as  4. 

##### 1) changeX

Using ‘getPattern’ function of Chromosome.java class to get phenotype from gentype

##### 2) calculateY

Passing the results of ‘Reason', ‘GrowthRate’, ‘Generations’ of a pattern using fitness function into the GAScore class.

#### 4. GAScore.java

GAScore.java is kind of the class which return the score of current pattern.

There are three fields in it, “reason”, “growthRate” and “generation”. Reason describes the cause of the  pattern dies, 0 represents all of the points die, 1 represents cells’ activity repeats forever, 2 represents pattern keeps produce new points and unrepeated over 1000 times. GrowthRate describes the changing of the points during game processing.

GrowthRate = points exist / points initialized

Due to the equation above, the bigger growthRate, the better.

Generation represents the iteration times of pattern.

We calculate the three score every time when we invoke calculateY function in the GA4Game.java. CalculateY function will return a GAScore object to save the score for every patterns. 

#### 5. GAUtil.java

GAUtil.java use to transform the starting pattern into a two-dimensional array, in order to pass array in the GameOfLife object creation in the GOL.java.

Every 8 position in the pattern represents a coordinates for a pint, they are splited by comma, moreover, x coordinate and y coordinate are splited by blank space.

### UI

### GameOf Life.java

GameOfLife.java includes functions which can be used for game of life and UI button actions. These functions are setCurrentMove, GameOfLife, decide, repain, jPanel1ComponentResized, jButton1ActionPerformed.

#### GameOfLife:
GameOfLife function is used to reference other functions to decide the next moving of every position and implement the game.

#### Decide:
Decide function is aimed to calculate the number of neighbors for every point and decide if the point will exist for the next round .

Function checks the left three position of current position first, and then checks the right three position of current position. For the next two step, function checks the bottom position and the upper position of the current position. After these checking, return the number of neighbors.

#### Repain：
Repain function is aimed to repaint the jpanel after every round.

#### JPanel1ComponentResized:
JPanel1ComponentResized function is aimed to resize jPanel

### Run / Implement

#### GOL.java
GOL.java is aimed to avtivate the UI.

In order to reproduce the same pattern, we pass parameter “seed” in the creation of GA4Game object, then seed will be passed to the initialization of chromosome, at the end, we will produce genotype randomly with the seed. With the same seed, all of our random processes are drawing from the same generator, the behavior of our project should be repeatable.

Our fixed seed value is shown in the picture, “1575750427570L”.

If we need different seed value, just uncomment this line of code, “long seed = System.currentTimeMillis();”.

After producing the seed, we activate the GA4Game, the implement class of Genetic Algorithm, get the genotype for the project, change the genotype to phenotype, transform the shape of phenotype which name is “borad” in order to use them in the UI. At the end, we will activate the UI class by creating object of GameOfLife class and passing “board” in the object.  

## Unit Test
### ChromosomeTest.java
The purpose of ChromosomeTest is to test the ‘getPattern’, ‘clone’ and ‘mutation’ these three functions.

#### ‘getPatternTest’:
#### ‘cloneTest’:
#### ‘mutationTest’:

### GAScoreTest.java
The purpose of GAScoreTest is to test the ‘getReason’, ‘getGrowthRate’ and ‘getGenerations’ these three functions.

#### ‘getReason Test’:
#### ‘getGeneration Test’:
#### ‘getGrowthRate Test’：

### GAUtilTest.java
The purpose of GATestTest is to test the ‘transform’ function.

### GA4GameTest.java
GA4GameTest.java test functions which implement in the GA4Game.java and GeneticAlgorithm.java due to GA4Game.java is the implementation class of the GeneticAlgorithm.java.

#### TestCalculate1 and testCalculate2:
These two functions are aimed to test calculate function, if the length of the gene of the return chromosome is 400, we consider the function runs well.

#### ChangeX1 and changeX2:
These two functions are aimed to test changeX function. If the return value equals the target phenotype value, we consider the function runs well.

#### CalculateY1 and calculateY2:
These two functions are aimed to test calculateY function. If the fields in the return GAScore object is not null, we consider the function runs well. 

## Reference
https://www.youtube.com/watch?v=FWSR_7kZuYg&vl=en

https://www.geeksforgeeks.org/program-for-conways-game-of-life/

https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life

https://www.geeksforgeeks.org/genetic-algorithms/

https://www.youtube.com/watch?v=1i8muvzZkPw

https://blog.csdn.net/f641385712/article/details/81115164

https://www.analyticsvidhya.com/blog/2017/07/introduction-to-genetic-algorithm/

https://codereview.stackexchange.com/questions/139125/game-of-life-basic-java-gui-implementation
