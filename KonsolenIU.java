package Javamonv1;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.Random;

public class KonsolenIU {
    public  void clearConsole() {
        for (int i = 0; i < 15; i++) {
            System.out.println();
        }
    }

    public int tryRead(String promt, int min, int max, Scanner scanner) {
        while (true) {
            System.out.println(promt);
            try {
                String line = scanner.nextLine();
                int choice = Integer.parseInt(line);
                if (choice >= min && choice <= max) {
                    return choice;
                } else {
                    System.out.println("„Fehler: Bitte geben Sie eine Zahl zwischen “ + min + „ und “ + max + „ ein.“");
                }
            } catch (NumberFormatException e) {
                System.out.println("Fehler! Bitte geben sie eine ZAHL!");
            }

        }
    }

    public String tryReadString(String promt, Scanner scanner) {
        while (true) {
            System.out.println(promt);
            String input = scanner.nextLine();
            if (!input.trim().isEmpty()) {
                return input;
            } else {
                System.out.println("Fehler! Bitte machen Sie keine leere Eingabe");
            }
        }
    }


    public void displayWelcomeAnimation() {

        clearConsole();
        String welcomeText = """
        $P_╔════════════════════════════════════════════════════════════════════════════════════════════════════════════╗$X$
        $P_║$X$ $R_⠈⣷⣿⣿⣶⣶⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣴⢰⣶⣷⣿⣿$X$ $P_║$X$
        $P_║$X$ $R_⠀⠹⣿⣿⣿⡄⠀⠈⠓⠦⣄⢀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡤⠖⠊⠉⠀⣸⣿⣿⣽⠃$X$ $P_║$X$
        $P_║$X$ $R_⠀⠀⠘⣿⣿⣇⠀⠀⠀⠀⠀⠘⠶⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⠞⠁⠀⠀⠀⠀⠀⣿⣿⣿⠃⠀$X$ $P_║$X$
        $P_║$X$ $R_⠀⠀⠀⠈⢻⣿⠄⠀⠀⠀⠀⠀⠀⠈⠳⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡤⠙⠁⠀⠀⠀⠀⠀⠀⡸⣿⠟⠁⠀⠀$X$ $P_║$X$
        $P_║$X$ ⠀⠀⠀⠀⠀⠁⢾⡄⠀⠀⠀⠀⠀⠀⠀⠈⠱⣦⠀⠀⠀⠀⠀⠀⢀⣀⣀⣀⣀⡀⠀⠀⠀⠀⠀⢀⡴⠋⠀⠀⠀⠀⠀⠀⠀⠀⣠⠟⠁⡀⠀⠀⠀ $P_║$X$
        $P_║$X$ ⠀⠀⠀⠀⠀⠀⠀⠉⠳⡄⠀⠀⠀⠀⠀⠀⠀⠈⠳⡆⣤⠴⠞⠛⠉⠉⠉⠉⠉⠉⠉⠳⠆⣤⣤⠞⠁⠀⠀⠀⠀⠀⠀⢀⣠⠖⠁⠀⠀⠁⠀⠀⠀ $P_║$X$
        $P_║$X$ ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠦⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡠⠖⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀ $P_║$X$
        $P_║$X$ ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⢳⡞⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢇⠞⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ $P_║$X$
        $P_║$X$ ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡾⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ $P_║$X$
        $P_║$X$ ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ $P_║$X$
        $P_║$X$ ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠀⠀⠀$YB_⣠⣶⠖⢤⡀$X$⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀$YB_⢠⠴⠶⣦⡄$X$⠀⠀⢈⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ $P_║$X$
        $P_║$X$ ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠾⠀⠀⠀$YB_⣾⣿⣀⣰⡧$X$⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀$YB_⣿⣀⣠⣾⣿$X$⠀⠀⠀⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ $P_║$X$
        $P_║$X$ ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡟⠀⠀⠀$C_⠻⣍⡩⠜⠃$X$⠀⠀⠀⠠⣤⡤⠀⠀⠀⠀$C_⠹⠭⣉⠽⠏$X$⠀⠀⠀⡷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ $P_║$X$
        $P_║$X$ ⠀⠀⠀⠀⠀⠀⠀⢀⣤⠴⠴⣤⣠⣇⣤⣤⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⣤⣤⣼⣀⡴⢴⢦⣄⠀⠀⠀⠀⠀⠀⠀ $P_║$X$
        $P_║$X$ ⠀⠀⠀⠀⠀⠀⢸⠃⠀⠀⠀⠀⢹⡁⣀⡀⠙⣱⡀⠀⠀⠀⠲⣄⣠⡴⣒⢒⣤⣤⠴⠂⠀⠀⠀⢠⡞⢁⣀⡀⢨⠃⠀⠀⠀⠀⢹⠀⠀⠀⠀⠀⠀ $P_║$X$
        $P_║$X$ ⠀⠀⠀⠀⠀⠀⠈⠉⠀⠉⠀⠈⠈⠉⠉⠉⠉⠉⠉⠉⠉⠉⠈⠀⠉⠉⠉⠉⠉⠉⠀⠀⠀⠀⠈⠉⠉⠉⠉⠉⠉⠁⠈⠈⠈⠀⠉⠀⠀⠀⠀⠀⠀ $P_║$X$
        $P_║$X$        $RB_ __       ___   ____    ____  ___      .___  ___.   ______   .__   __.$X$ $P_║$X$
        $P_║$X$       $RB_|  |     /   \\  \\   \\  /   / /   \\     |   \\/   |  /  __  \\  |  \\ |  |$X$ $P_║$X$
        $P_║$X$       $RB_|  |    /  ^  \\  \\   \\/   / /  ^  \\    |  \\  /  | |  |  |  | |   \\|  |$X$ $P_║$X$
        $P_║$X$ $RB_ .--.  |  |   /  /_\\  \\  \\      / /  /_\\  \\   |  |\\/|  | |  |  |  | |  . `  |$X$ $P_║$X$
        $P_║$X$ $RB_ |  `--'  |  /  _____  \\  \\    / /  _____  \\  |  |  |  | |  `--'  | |  |\\   |$X$ $P_║$X$
        $P_║$X$ $RB_  \\______/  /__/     \\__\\  \\__/ /__/     \\__\\ |__|  |__|  \\______/  |__| \\__|$X$ $P_║$X$
        $P_║$X$                                                                                                     $P_║$X$
        $P_╚════════════════════════════════════════════════════════════════════════════════════════════════════════════╝$X$
        """;


        String coloredText = welcomeText
                .replace("$P_", ConsoleColors.PURPLE)
                .replace("$R_", ConsoleColors.RED)
                .replace("$RB_", ConsoleColors.RED_BOLD)
                .replace("$YB_", ConsoleColors.YELLOW_BOLD)
                .replace("$C_", ConsoleColors.CYAN)
                .replace("$X$", ConsoleColors.RESET);



        try {
            for (char c : coloredText.toCharArray()) {
                System.out.print(c);
                TimeUnit.MILLISECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("\n\nZum Starten ENTER drücken...");

    }

    public void displayAttackAnimation(Javamon attacker, Javamon defender, PokAttacke attack, int damage) {

        try {
            clearConsole();
            System.out.println(attacker.getName() + ", \"" + attack.getName() + "\" \n");
            int distance = 40;
            for (int i = 0; i < distance; i++) {
                System.out.print("\r");
                for (int j = 0; j < i; j++) System.out.print(" ");
                System.out.print(ConsoleColors.YELLOW_BOLD + "»»----►" + ConsoleColors.RESET);
                TimeUnit.MILLISECONDS.sleep(20);
            }
            System.out.println();
            TimeUnit.MILLISECONDS.sleep(500);


            clearConsole();
            System.out.println(ConsoleColors.RED_BOLD + "!!! " + defender.getName() + " " + damage + " HAT SCHADEN GENOMMEN!!!" + ConsoleColors.RESET);


            String[] effects = {"BAM!", "POW!", "GÜM!"};
            String randomEffect = effects[new Random().nextInt(effects.length)];

            String impactCloud = """
                  .-.
                ( (%s) )
                  '-'
                """;

            String impactArt = String.format(impactCloud, randomEffect);


            printSideBySide(defender.getAsciiArt(), ConsoleColors.YELLOW_BOLD + impactArt + ConsoleColors.RESET);
            System.out.println("\n");
            drawHealthBar(defender.getName(), defender.getHp(), defender.getMaxHp());
            drawHealthBar(attacker.getName(), attacker.getHp(), attacker.getMaxHp());

            System.out.println("\n");
            drawHealthBar(defender.getName(), defender.getHp(), defender.getMaxHp());


            TimeUnit.SECONDS.sleep(4);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }




    private void printSideBySide(String leftArt, String rightArt) {
        String[] leftLines = leftArt.split("\n");
        String[] rightLines = rightArt.split("\n");

        int maxLines = Math.max(leftLines.length, rightLines.length);

        int maxLeftWidth = 0;
        for (String line : leftLines) {
            if (line.length() > maxLeftWidth) {
                maxLeftWidth = line.length();
            }
        }

        for (int i = 0; i < maxLines; i++) {
            String leftLine = (i < leftLines.length) ? leftLines[i] : "";
            String rightLine = (i < rightLines.length) ? rightLines[i] : "";


            System.out.printf("%-" + maxLeftWidth + "s", leftLine);


            System.out.println("   " + rightLine);
        }
    }

    public void displayWinnerAnimation(Javamon winner, Javamon loser) {

        clearConsole();
        String winnerText = """
        $YB_⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀$X$
        $YB_⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣄⢲⣏⢨⣽⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀$X$
        $YB_⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠰⣾⠃⢙⢴⣞⡟⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀$X$
        $YB_⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢻⣿⣻⠡⣀⣄⡀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀$X$
        $YB_⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣜⠉⣷⣿⢠⣍⣉⠉⠐⠲⠤⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀$X$
        $YB_⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠏⠏⠸⡄⢻⡏⣏⠀⠂⠄⠀⣈⠒⢠⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀$X$
        $YB_⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠱⡈⠁⠹⠆⠄⢀⣼⠻⣠⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀$X$
        $YB_⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠠⠀⢈⣳⠆⣀⣄⣼⠴⠚⠁⠀⠀⢀⣤⣶⣶⣤⣀⠀⠀⠀⠀⠀⠀⠀⠀⣴⡁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀$X$
        $YB_⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣖⠊⠉⠸⣿⣷⡄⠀⠀⠀⠀⢀⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⣠⣾⣿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀$X$
        $YB_⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠑⠲⠬⢿⣿⣦⣤⣄⠀⠈⣿⣿⣟⣛⣩⢿⠀⠀⠀⣠⣴⣿⡿⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀$X$
        $YB_⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠛⢿⣿⣿⣤⣏⢻⣭⣿⡝⢹⣤⣶⣿⡿⠟⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀$X$
        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠹⢻⣿⡄⢿⣿⢁⣿⣿⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣾⣿⣿⣿⣿⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⡘⠇⣾⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⣿⣿⠗⠚⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣈⣛⠿⢿⡫⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣦⣤⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
        ⠀⠀⠀⠀⠀⠀⠀⢠⣦⣾⣇⢹⣶⣿⢁⣿⣷⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣴⣶⣿⣿⣶⣦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
        ⠀⠀⠀⠀⠀⠀⢰⣿⣿⣿⣿⡄⣿⡇⣼⣿⣿⣿⣆⡀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⡏⢹⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀
        ⠀⠀⠀⠀⠀⠀⣾⣿⣿⣿⣿⣿⣜⣸⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⡇⢸⣿⣿⣿⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠻⣿⣿⣿⣿⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀
        ⠀⠀⠀⠀⠀⢠⣿⣿⣿⣿⣿⣟⠉⢙⣿⣿⣿⢻⣿⣇⠀⠀⠀⠀⠀⠀⠀⢠⣿⣿⣿⡇⠈⣿⣿⣿⡅⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣿⢻⣭⣭⡿⣻⣧⡀⠀⠀⠀⠀⠀⠀⠀⠀
        ⠀⠀⠀⠀⠀⢸⣿⣿⢿⣿⣿⣿⣿⣿⣿⣿⣿⢸⣿⡿⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⡇⠀⣿⣿⣿⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⣿⣿⣿⡞⣿⣿⢳⣿⣿⣿⡆⠀⠀⠀⠀⠀⠀⠀
        ⠀⠀⠀⠀⠀⢸⣿⣿⢾⣿⣿⣿⣿⣿⣿⣿⣿⢸⣿⡇⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⠁⠀⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⢰⣿⣿⢻⣿⣿⡸⣏⣾⣿⡟⣿⣷⣀⠀⠀⠀⠀⠀⠀
        ⠀⠀⠀⠀⠀⠘⠿⠿⢻⣿⣿⣿⡇⣿⣿⣿⡿⠸⠿⠇⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⡏⠀⠀⢿⣿⣿⣏⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⡟⣾⣿⣿⠷⠺⣿⣿⡇⢸⣿⣿⠀⠀⠀⠀⠀⠀
        ⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⡇⣿⣿⣿⡿⠀⠀⠀⠀⠀⡞⠉⠉⠉⠉⣽⣿⣿⡏⠉⠉⢹⣿⣿⣿⠉⠉⠉⠉⢹⡀⠀⠀⢸⣿⡇⣿⣿⣿⣦⣴⣿⣿⡇⢸⣿⡷⠀⠀⠀⠀⠀⠀
        ⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⡇⣿⣿⣿⣿⠀⠀⠀⠀⣼⠁⠀⠀⠀⠀⠈⠛⠟⠃⠀⠀⠀⠛⠛⠋⠀⠀⠀⠀⠈⣇⠀⠀⢸⣿⡇⣿⣿⣿⣿⣿⣿⣿⣧⠰⣿⡏⠀⠀⠀⠀⠀⠀
        ⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⡇⣿⣿⣿⣿⠀⠀⠀⠀⣏⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣹⠀⠀⢸⣿⡇⣿⣿⣿⡏⢹⣿⣿⣯⠸⣿⡇⠀⠀⠀⠀⠀⠀
        ⠀⠀⠀⠀⠀⠀⠀⠀⠸⣿⣿⣿⡇⣿⣿⣿⡿⠀⠀⠀⠀⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⠀⠀⣿⣿⣿⡇⢸⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀
        ⠀⠀⠀⢀⡤⠤⠤⠤⠤⣿⣿⣿⡧⣿⣿⣿⡧⠤⠤⠤⠤⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⠀⠀⣿⣿⣿⡇⢸⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀
        ⠀⠀⣰⠋⠀⠀⠀⠀⠀⠻⣿⣿⠇⠻⣿⣿⠃⠀⠀⠀⠀⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⠀⠀⣿⣿⣿⡇⢸⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀
        ⢀⠔⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⠀⠀⣿⣿⣿⡇⢸⣿⣿⡿⠀⠀⠀⠀⠀⠀⠀⠀⠀
        ⡟⠒⠒⠒⠒⠒⠒⠒⠒⠒⠒⠒⠒⠒⠒⠒⠒⠒⠒⠒⠒⠛⠀⠀⠀⠀⠀⠀⠀⠀⡴⢿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣀⣀⣀⣀⣀⣽⣿⣿⣧⣸⣿⣿⣧⣀⣀⣀⣀⠀⠀⠀⠀⠀
        ⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⣷⠀⠀⠀⠀⠀⢸⣿⣿⡏⢸⣿⣿⡿⠀⠀⠀⠈⠣⡀⠀⠀⠀
        ⡇⠀⠀⠀⠀⠀⠀⠀⠀⣀⣤⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⡷⠀⠀⠀⠀⠀⠀⠉⠋⠁⠀⠉⠋⠀⠀⠀⠀⠀⠀⠙⢄⠀⠀
        ⡇⠀⠀⠀⠀⠀⠀⠀⠀⠟⠉⣹⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⠿⠿⠿⠇⠀⠀⠀⠀⠀⠀⠀⠿⠤⠤⠤⠤⠤⠤⠤⠤⠤⠤⠤⠤⠤⠤⠤⠤⠤⠤⠤⠬⢷⠀
        ⡇⠀⠀⠀⠀⠀⠀⠀⠀⢠⣾⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣤⣤⡀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠀
        ⡇⠀⠀⠀⠀⠀⠀⠀⠀⠿⠿⠿⠾⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣤⣽⡋⠀⠀⠀⠀⠀⠀⠀⠀⢸⠀
        ⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠰⣦⡾⠟⠀⠀⠀⠀⠀⠀⠀⠀⢸⠀
        ⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠀
        $P_⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉$X$
        """;


String coloredTrophy = winnerText
        .replace("$YB_", ConsoleColors.YELLOW_BOLD)
        .replace("$P_", ConsoleColors.PURPLE)
        .replace("$X$", ConsoleColors.RESET);


System.out.println(coloredTrophy);


System.out.println(ConsoleColors.RED_BOLD + "GAME OVER !!!!! WINNER ->>>>>>>>>>" + ConsoleColors.RESET);
System.out.println();

String winnerArt = winner.getAsciiArt();
System.out.println(ConsoleColors.CYAN + winnerArt + ConsoleColors.RESET);
    }

    public void displayClosingAnimation() {
        try {


            clearConsole();
            String closingText = """
                    $P_⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡀⠀$X$
                    $P_⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⠀⠀⠀⣶⡆⠀⣰⣿⠇⣾⡿⠛⠉⠁$X$
                    $P_⠀⣠⣴⠾⠿⠿⠀⢀⣾⣿⣆⣀⣸⣿⣷⣾⣿⡿⢸⣿⠟⢓⠀⠀$X$
                    $P_⣴⡟⠁⣀⣠⣤⠀⣼⣿⠾⣿⣻⣿⠃⠙⢫⣿⠃⣿⡿⠟⠛⠁⠀$X$
                    $P_⢿⣝⣻⣿⡿⠋⠾⠟⠁⠀⠹⠟⠛⠀⠀⠈⠉⠀⠉⠀⠀⠀⠀⠀$X$
                    $P_⠀⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⠀⠀⣀⢀⣠⣤⣴⣤⣄⠀$X$
                    $P_⠀⠀⠀⠀⣀⣤⣤⢶⣤⠀⠀⢀⣴⢃⣿⠟⠋⢹⣿⣣⣴⡿⠋⠀$X$
                    $P_⠀⠀⣰⣾⠟⠉⣿⡜⣿⡆⣴⡿⠁⣼⡿⠛⢃⣾⡿⠋⢻⣇⠀⠀$X$
                    $P_⠀⠐⣿⡁⢀⣠⣿⡇⢹⣿⡿⠁⢠⣿⠷⠟⠻⠟⠀⠀⠈⠛⠀⠀$X$
                    $P_⠀⠀⠙⠻⠿⠟⠋⠀⠀⠙⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀$X$
                    
                    
                    """;


            String coloredClosingText = closingText
                    .replace("$P_", ConsoleColors.PURPLE)
                    .replace("$X$", ConsoleColors.RESET);


            System.out.println(coloredClosingText);
            System.out.println(ConsoleColors.CYAN + "Danke fürs Spielen!" + ConsoleColors.RESET);
            System.out.println();

            for (int i = 3; i > 0; i--) {

                String sekundeText = (i == 1) ? "Sekunde" : "Sekunden";

                System.out.print(ConsoleColors.YELLOW + "App schließt sich in " + i + " " + sekundeText + "...\r" + ConsoleColors.RESET);

                TimeUnit.SECONDS.sleep(1);
            }


            System.out.println();
            clearConsole();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    public boolean playAgain(String promt, Scanner scanner) {
        System.out.println("\n Mochtest du nochmal spielen? ( JA // NEIN)");
        String answer = tryReadString(promt, scanner);
        return answer.equalsIgnoreCase("ja") || answer.equalsIgnoreCase("j");
    }

    public PokAttacke askForAttack(Javamon attacker, Scanner scanner) {
        System.out.println("\n----" + attacker.getName() + "Angriff auswählen ---");
        List<PokAttacke> listeatt = attacker.getAttacken();
        for (int i = 0; i < listeatt.size(); i++) {
            System.out.println((i + 1) + ": " + listeatt.get(i).getName() + " (POwer : " + listeatt.get(i).getPower() + ")");
        }
        int choice = tryRead("Angriffsauswahl (1-" + listeatt.size() + ") :", 1, listeatt.size(), scanner);
        return listeatt.get(choice - 1);
    }


    public void displayPokemonList(List<Javamon> pokemonList) {
        System.out.println("\n---  Bitte wählen Sie einen Javamon aus. ---");
        for (Javamon p : pokemonList) {
            System.out.println("ID: " + p.getId() + " - " + p.getName());
        }

    }

    public void displaySelections(Javamon playerMon, Javamon computerMon) {
        try {
            clearConsole();


            System.out.println("Deine Wahl:");
            System.out.println(playerMon.getAsciiArt());
            System.out.println("==> " + playerMon.getName());


            TimeUnit.SECONDS.sleep(2);


            clearConsole();
            System.out.println("Wahl deines Gegners:");
            System.out.println(computerMon.getAsciiArt());
            System.out.println("==> " + computerMon.getName());


            TimeUnit.SECONDS.sleep(2);


            System.out.println("\n----- DER KAMPF BEGINNT! -----");
            TimeUnit.SECONDS.sleep(2);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }


    public void drawHealthBar(String name, int currentHp, int maxHp) {
        System.out.println(name + ":");
        int barLength = 20;


        int currentHealth = Math.max(currentHp, 0);

        int filledLength = (int) (((double)currentHealth / maxHp) * barLength);


        String barColor = ConsoleColors.GREEN_BOLD;
        if ((double)currentHealth / maxHp < 0.5) {
            barColor = ConsoleColors.YELLOW_BOLD;
        }
        if ((double)currentHealth / maxHp < 0.2) {
            barColor = ConsoleColors.RED_BOLD;
        }

        System.out.print("[");
        for (int i = 0; i < barLength; i++) {
            if (i < filledLength) {
                System.out.print(barColor + "█" + ConsoleColors.RESET);
            } else {
                System.out.print("-");
            }
        }
        System.out.println("] " + currentHealth + "/" + maxHp);
    }

}
