package edu.neu.coe.info6205.GA;

import edu.neu.coe.info6205.life.base.Game;
import edu.neu.coe.info6205.life.base.Group;
import edu.neu.coe.info6205.life.base.Point;

public class Test {

    public int[][] transform(Pack pack) {
        Game game = pack.getGame();
        Pair pair = pack.getPair();
        Group group = game.getGroup();
        Point origin = group.getOrigin();
        Point extent1 = group.getExtent1();
        Point extent2 = group.getExtent2();

        int[][] board = new int[48][48];


        String pattern = pair.getPattern();
        String[] split = pattern.split(", ");
        for(String str : split) {
            String[] s = str.split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            board[x + 8][y + 8] = 1;
        }

        return board;
    }

    public Pack findPattern() {

        int count = 0;
        while(true) {
            count++;
            Pair res = random();
            if(res.getReason() == 1 && res.rate >= -1) {
                System.out.println(res.getPattern());
                System.out.println("numbers of tries: " + count);
                Game game = Game.create(0L, Point.points(res.getPattern()));
                return new Pack(res, game);
            }
        }
    }

    private Pair random() {
        boolean[] gene = new boolean[900];
        for(int i = 0; i < 900; i++) {
            gene[i] = Math.random() >= 0.5;
        }
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for(boolean g : gene) {
//            System.out.print(g ? 1 : 0);
            sb.append(g ? 1 : 0);
            count++;
            if(count == 10) {
                sb.append(",");
                count = 0;
            }
        }
        System.out.println(sb);
        String tempS = sb.substring(0, sb.lastIndexOf(","));
        String[] strArr = tempS.split(",");
//        System.out.println();
        sb = new StringBuilder();
        for(String str : strArr) {
            String strX = str.substring(0, 5);
            String strY = str.substring(5);
            int x = Integer.parseInt(strX, 2);
            int y = Integer.parseInt(strY, 2);
            sb.append("" + x + " " + y + ", ");
        }
        String pattern = sb.substring(0, sb.lastIndexOf(","));
        System.out.println(pattern);
        System.out.println();

        String patternName = "Random";
        System.out.println("Game of Life with starting pattern: " + patternName);
        final Game.Behavior generations = Game.run(0L, pattern);
        System.out.println();
        System.out.println("generation: " + generations.generation);
        System.out.println("growth: " + generations.growth);
        System.out.println("reason: " + generations.getReason());
        return new Pair(generations.getReason(), generations.generation, generations.growth, pattern);
    }

    class Pack {
        Pair pair;
        Game game;

        public Pack(Pair pair, Game game) {
            this.pair = pair;
            this.game = game;
        }

        public Pair getPair() {
            return pair;
        }

        public Game getGame() {
            return game;
        }
    }

    class Pair {
        int reason;
        long generation;
        double rate;
        String Pattern;

        public Pair(int reason, long generation, double rate, String pattern) {
            this.reason = reason;
            this.generation = generation;
            this.rate = rate;
            Pattern = pattern;
        }

        public int getReason() {
            return reason;
        }

        public double getRate() {
            return rate;
        }

        public long getGeneration() {
            return generation;
        }

        public String getPattern() {
            return Pattern;
        }
    }
}
