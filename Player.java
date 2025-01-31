public class Player {
    private static String[][] field;
    private static int xCor;
    private static int yCor;
    private static boolean gameFinished;

    public Player (String[][] newField) {
        field = newField;
        gameFinished = false;
        xCor = 1;
        yCor = 1;
    }

    private static boolean isValid(int x, int y) {
        return (x > 0) && (x < Game.getFieldSize() - 1) && (y > 0) && (y < Game.getFieldSize() - 1) && !field[x][y].equals("🟥");
    }

    public static boolean move(String vector) {
        switch (vector) {
            case "left":
                if (!isValid(xCor, yCor - 1))  {
                    return false;
                }
                field[xCor][yCor] = "⬜";

                yCor -= 1;
                field[xCor][yCor] = "🐒";
                break;

            case "right":
                if (!isValid(xCor, yCor + 1))  {
                    return false;
                }
                field[xCor][yCor] = "⬜";

                yCor += 1;
                field[xCor][yCor] = "🐒";
                break;

            case "forward":
                if (!isValid(xCor - 1, yCor))  {
                    return false;
                }
                field[xCor][yCor] = "⬜";

                xCor -= 1;
                field[xCor][yCor] = "🐒";
                break;

            case "back":
                if (!isValid(xCor + 1, yCor))  {
                    return false;
                }
                field[xCor][yCor] = "⬜";

                xCor += 1;
                field[xCor][yCor] = "🐒";
                break;
        }

        if ((xCor == Game.getFieldSize() - 2) && (yCor == Game.getFieldSize() - 2)) {
            gameFinished = true;
        }

        return true;
    }

    public String[][] getField() {
        return field;
    }

    public boolean getStatus() {
        return gameFinished;
    }
}
