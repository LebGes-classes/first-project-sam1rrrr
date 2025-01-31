import java.util.Scanner;

class Game {
    private static String[][] field;
    private static final Scanner scanner = new Scanner(System.in);
    private static final int fieldSize = 21;

    public static void startGame() {
        field = LevelGenerator.generateLevel();
        Player player = new Player(field);

        String chosenOption;
        boolean gameFinished = false;

        while (!gameFinished) {
            printField();
            chosenOption = scanner.nextLine();

            switch (chosenOption) {
                case "w":
                    if (player.move("forward")) {
                        field = player.getField();
                    }
                    break;
                case "s":
                    if (player.move("back")) {
                        field = player.getField();
                    }
                    break;
                case "a":
                    if (player.move("left")) {
                        field = player.getField();
                    }
                    break;
                case "d":
                    if (player.move("right")) {
                        field = player.getField();
                    }
                    break;
            }
            gameFinished = player.getStatus();
        }

        printField();
        System.out.print("Вы выиграли! Нажмите любую клавишу, чтобы вернуться в меню: ");
        scanner.nextLine();

        Menu.showMenu();
    }

    public static void printField() {
        Utils.clearConsole();

        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }

    public static int getFieldSize() {
        return fieldSize;
    }
}