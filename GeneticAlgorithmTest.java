package edu.neu.coe.info6205.GA;

public class GeneticAlgorithmTest extends GeneticAlgorithm{

    /**
     * 在8 * 8的格子上，从(0,0)到(7,7)，x和y均取0~7的范围，即000到111的范围
     * pattern为8个点，每个点(x,y)，x、y坐标均由000到111表示
     * 每个点的表示方法为x、y坐标拼接，故每个点长度为6，一共8个点，pattern长度为24
     */
    public static final long NUM = 1 << 48;

    public GeneticAlgorithmTest() {
        super(48);
    }

    @Override
    public double changeX(Chromosome chro) {
        // TODO Auto-generated method stub

        int count = 0;
        StringBuilder sb = new StringBuilder();
        for(boolean gene : chro.getGene()) {
            if(gene) {
                sb.append("0");
            } else {
                sb.append("1");
            }
            count++;
            if(count == 5) {
                sb.append(",");
            }
        }



        return ((1.0 * chro.getNum() / NUM) * 100) + 6;
    }

    @Override
    public double caculateY(double x) {
        // TODO Auto-generated method stub
        return 100 - Math.log(x);
    }

    public static void main(String[] args) {
        GeneticAlgorithmTest test = new GeneticAlgorithmTest();
        test.caculte();
    }
}