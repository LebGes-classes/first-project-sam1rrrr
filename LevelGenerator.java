import java.util.Random;

class LevelGenerator {
    public static final int fieldSize = Game.getFieldSize();
    public static String[][] field = new String[fieldSize][fieldSize];

    public static Random rand = new Random();

    private static final int[][] vectors = {
            {-2, 0}, // forward
            {2, 0},  // back
            {0, -2}, // left
            {0, 2}   // right
    };

    public static String[][] generateLevel() {
        // заполняем все стенками
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                field[i][j] = "🟥";
            }
        }

        int startX = rand.nextInt(fieldSize / 2) * 2 + 1;
        int startY = rand.nextInt(fieldSize / 2) * 2 + 1;
        dfs(startX, startY);

        field[1][1] = "🐒"; // игрок
        field[fieldSize - 2][fieldSize - 2] = "🍌"; // бананчик

        return field;
    }

    private static void dfs(int x, int y) {
        field[x][y] = "⬜";

        int[][] shuffledDirections = vectors.clone();
        shuffleArray(shuffledDirections);

        for (int[] dir : shuffledDirections) {
            int newX = x + dir[0];
            int newY = y + dir[1];

            if (isValid(newX, newY)) {
                field[x + dir[0] / 2][y + dir[1] / 2] = "⬜";
                dfs(newX, newY);
            }
        }
    }

    private static boolean isValid(int x, int y) {
        return (x > 0) && (x < fieldSize - 1) && (y > 0) && (y < fieldSize - 1) && field[x][y].equals("🟥");
    }

    private static void shuffleArray(int[][] array) {
        for (int i = array.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            int[] temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

}
