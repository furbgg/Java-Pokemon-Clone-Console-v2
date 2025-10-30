package Javamonv1;

import Javamonv1.persistence.CsvDataManager;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class App {
    private static final String POKE_CVS_PATH = "Pokemon.csv";
    private static final String ATTACKS_CVS_PATH = "Attacks.csv";
    private static final String EFF_CVS_PATH = "Effectiveness.csv";
    private static final String WELCOME_SOUND_PATH = "resources/aa.wav";
    public static void main(String[] args) throws IOException , InterruptedException {
        Scanner sc = new Scanner(System.in);
        CsvDataManager csv = new CsvDataManager();
        JavamonRepository javamonRepo = new JavamonRepository();
        PokAttackeRepository attackRepo = new PokAttackeRepository();
        EffectivenessRepository effRepo = new EffectivenessRepository();
        KonsolenIU iu = new KonsolenIU();
        SoundManager sm = new SoundManager();
        SpielLogik logic;

        System.out.printf("Lade CSV_Dateien ");
        List<Javamon> javamonData = csv.loadPokemon(POKE_CVS_PATH);
        List<PokAttacke> attackData = csv.loadPokAttacke(ATTACKS_CVS_PATH);
        Map<String, Map<String,Double>> effData = csv.loadEffectiveness(EFF_CVS_PATH);
        System.out.printf("Dateien erfolgreich geladen!");

        javamonRepo.init(javamonData);
        attackRepo.init(attackData);
        effRepo.init(effData);
        logic = new SpielLogik(javamonRepo,attackRepo,effRepo);
        iu.displayWelcomeAnimation();;
        sm.playSound(WELCOME_SOUND_PATH);
        boolean again;
        do {
            System.out.flush();
            TimeUnit.SECONDS.sleep(3);
            iu.clearConsole();
            iu.displayPokemonList(javamonRepo.getAllPoke());
            Javamon playermon = null;
            while (playermon == null) {
                String playerInput = iu.tryReadString("Wahle dein Javamon!",sc);
                playermon = logic.selectPlayer(playerInput);
                if (playermon == null) {
                    System.out.println(ConsoleColors.RED + "Ungultige Auswahl...Bitte erneut versuchen" + ConsoleColors.RESET);
                }
            }
            Javamon computerMon = logic.selectComp();
            logic.Attackkings(playermon,4);
            logic.Attackkings(computerMon,4);
            iu.displaySelections(playermon,computerMon);
            System.out.flush();
            TimeUnit.SECONDS.sleep(2);
            boolean playerTurn = playermon.getSpeed() >= computerMon.getSpeed();
            if (playerTurn) {
                System.out.println(ConsoleColors.GREEN + playermon.getName() + "ist schneller und beginnt!" + ConsoleColors.RESET);
            }else {
                System.out.println(ConsoleColors.GREEN + computerMon.getName() + "ist schneller und beginnt!" + ConsoleColors.RESET);
            }
            System.out.flush();
            TimeUnit.SECONDS.sleep(2);

            while (playermon.getHp()> 0 && computerMon.getHp()> 0 ) {
                iu.clearConsole();
                ;
                iu.drawHealthBar(playermon.getName() + "DU", playermon.getHp(), playermon.getMaxHp());
                iu.drawHealthBar(computerMon.getName() + "GEGNER", computerMon.getHp(), computerMon.getMaxHp());
                System.out.println();

                Javamon attacker = playerTurn ? playermon : computerMon;
                Javamon defender = playerTurn ? computerMon : playermon;
                   PokAttacke chosenAttack;

                if (playerTurn) {
                    chosenAttack = iu.askForAttack(attacker,sc);
                } else{
                    System.out.println(ConsoleColors.YELLOW + "\nDer Gegner ist am Zug...." + ConsoleColors.RESET);
                    System.out.flush();
                    TimeUnit.SECONDS.sleep(2);
                    chosenAttack = attackRepo.getRandomAtt();

                }

                int damage = logic.calculateDamage(chosenAttack,attacker,defender);
                defender.setHp(defender.getHp() - damage);
                iu.displayAttackAnimation(attacker,defender,chosenAttack,damage);
                TimeUnit.SECONDS.sleep(3);
                playerTurn  = !playerTurn;

            }

            iu.clearConsole();
            Javamon winner = (playermon.getHp()>0) ? playermon:computerMon;
            Javamon loser = (playermon.getHp()>0) ? computerMon : playermon;

            iu.displayWinnerAnimation(winner,loser);
            System.out.flush();
            TimeUnit.SECONDS.sleep(3);
            again = iu.playAgain("Mochtest du noch einmal spielen?(Ja/Nein)",sc);

        } while (again);


        iu.displayClosingAnimation();
        System.out.println("Scanner wird geschlossen... App wird beendet.");
        sc.close();


    }
}