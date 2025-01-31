import java.util.Scanner;

class Menu {
    private static boolean gameFinished = false;
    private static final Scanner scanner = new Scanner(System.in);

    public static void showMenu() {
        Utils.clearConsole();

        System.out.println("█▀▀▄ █▀▀█ █▀▀▄ █▀▀█ █▀▀▄ █▀▀█ 　 █▀▀▀ █▀▀█ █▀▄▀█ █▀▀ ");
        System.out.println("█▀▀▄ █▄▄█ █░░█ █▄▄█ █░░█ █▄▄█ 　 █░▀█ █▄▄█ █░▀░█ █▀▀ ");
        System.out.println("▀▀▀░ ▀░░▀ ▀░░▀ ▀░░▀ ▀░░▀ ▀░░▀ 　 ▀▀▀▀ ▀░░▀ ▀░░░▀ ▀▀▀ ");

        System.out.println("1. Начать игру");
        System.out.println("0. Выход");

        while (!gameFinished) {
            System.out.print("Введите цифру: ");
            int chosenOption = scanner.nextInt();

            switch (chosenOption) {
                case 1:
                    Game.startGame();
                    break;
                case 0:
                    Utils.clearConsole();

                    gameFinished = true;
                    break;
                default:
                    System.out.println("Неправильная цифра, попробуйте еще раз");
            }
        }
    }
}