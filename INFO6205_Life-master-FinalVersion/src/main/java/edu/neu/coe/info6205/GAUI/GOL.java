package edu.neu.coe.info6205.GAUI;


import edu.neu.coe.info6205.GA.Chromosome;
import edu.neu.coe.info6205.GA.GA4Game;
import edu.neu.coe.info6205.GA.GAUtil;

public class GOL {

    /**
     *
     * It is the seed we used
     * reason: 2
     * growthRate: 0.663
     * genotype: 0111001001001100000111111000101000000101101110011000100110011011100010010001110100100000100000011001111000110110100010000001001100110110101000100101011011010111100110011000001111111110000100011000000100000010111111101101011000111010000011111000010111000010110101010001110100001101000111011010101101010001110011000001111110101001000000110111100110100010110010110010001001110010101001110100110000111010
     * phenotype: 7 2, 4 12, 1 15, 8 10, 0 5, 11 9, 8 9, 9 11, 8 9, 1 13, 2 0, 8 1, 9 14, 3 6, 8 8, 1 3, 3 6, 10 2, 5 6, 13 7, 9 9, 8 3, 15 14, 1 1, 8 1, 0 2, 15 14, 13 6, 3 10, 0 15, 8 5, 12 2, 13 5, 1 13, 0 13, 1 13, 10 11, 5 1, 12 12, 1 15, 10 9, 0 3, 7 9, 10 2, 12 11, 2 2, 7 2, 10 7, 4 12, 3 10
     * seed: 1575750427570
     */
    private static final long seed = 1575750427570L;


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GAUtil test = new GAUtil();

        /**
         * It is code which produce the seed.
         * If there is any need to produce new seed, please uncomment them.
         */
//        long seed = System.currentTimeMillis();
//        System.out.println(seed);

        //1. 启动为game of life设计的GA算法
        GA4Game game = new GA4Game(seed);
        //2. 获取该算法的结果，基因型
        Chromosome genotype = game.calculate();
        //3. 将结果基因型转化为结果表现型，也就是String类型的pattern
        String phenotype = genotype.getPattern();
        //4. 将String类型的pattern，转化为UI可以使用的二维数组
        int[][] board = test.transform(phenotype);

        System.out.println("===================================================================");

        System.out.println("reason: " + genotype.getScore().getReason());
        System.out.println("growthRate: " + genotype.getScore().getGrowthRate());
        System.out.println("genotype: " + genotype);
        System.out.println("phenotype: " + phenotype);
        System.out.println("seed: " + seed);

        //5. 启动UI
        GameOfLife life = new GameOfLife();
        //6. 将board传入UI中
        life.setCurrentMove(board);
        life.setLocationRelativeTo(null);
        life.show();
    }

}
