package cn.boxfish.thinking.interfaces;

/**
 * Created by LuoLiBing on 16/12/16.
 * 生成遵循某个接口的对象典型的方式就是工厂模式
 */
public class FactoryDemo {

    // 生成对象接口
    interface Game {
        boolean move();
    }

    // 工厂接口
    interface GameFactory {
        Game getGame();
    }

    static class Checker implements Game {

        private int moves = 0;

        private static final int MOVES = 3;

        @Override
        public boolean move() {
            System.out.println("Checkers move " + moves);
            return ++ moves != MOVES;
        }
    }

    static class CheckerFactory implements GameFactory {

        @Override
        public Game getGame() {
            return new Checker();
        }
    }


    static class Chess implements Game {

        private int moves = 0;

        private final static int MOVES = 4;

        @Override
        public boolean move() {
            System.out.println("Chess move " + moves);
            return ++ moves != MOVES;
        }
    }

    static class ChessFactory implements GameFactory {

        @Override
        public Game getGame() {
            return new Chess();
        }
    }

    static class Games {
        // 传入一个工厂接口
        public static void playGame(GameFactory factory) {
            // 返回的也是一个接口
            Game game = factory.getGame();
            while (game.move()) ;
        }

        public static void main(String[] args) {
            playGame(new ChessFactory());
            playGame(new CheckerFactory());
        }
    }
}
