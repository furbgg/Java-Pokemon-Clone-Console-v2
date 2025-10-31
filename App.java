package Javamonv1;

import Javamonv1.persistence.CsvDataManager;

import java.io.IOException;
import java.sql.Time;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class App {
    private static final String POKE_CSV_PATH = "Pokemon.csv";
    private static final String ATTACKS_CSV_PATH = "Attacks.csv";
    private static final String EFF_CSV_PATH = "Effectiveness.csv";
    private static final String WELCOME_SOUND_PATH = "resources/aa.wav";

    private static void startBattle(Javamon playerMon, Javamon computerMon, SpielLogik logic, KonsolenIU iu, Scanner sc, PokAttackeRepository pok) throws InterruptedException {
        boolean playerTurn;
        if (playerMon.getSpeed() >= computerMon.getSpeed()) {
            System.out.println(ConsoleColors.GREEN + playerMon.getName() + "ist schneller und beginnt");
            playerTurn = true;
        } else {
            System.out.println(ConsoleColors.RED + computerMon.getName() + "ist schneller und beginnt");
            playerTurn = false;
        }
        System.out.flush();
        TimeUnit.SECONDS.sleep(3);
        while (playerMon.getHp() > 0 && computerMon.getHp() > 0) {
            iu.clearConsole();
            iu.drawHealthBar(playerMon.getName() + "(Du)", playerMon.getHp(), playerMon.getMaxHp());
            iu.drawHealthBar(computerMon.getName() + "( GEGNER ) ", computerMon.getHp(), computerMon.getMaxHp());
            System.out.println();

            Javamon attacker = playerTurn ? playerMon : computerMon;
            Javamon defender = playerTurn ? computerMon : playerMon;
            PokAttacke chosenAttack;

            if (playerTurn) {
                chosenAttack = iu.askForAttack(attacker, sc);
            } else {
                System.out.println(ConsoleColors.YELLOW + "\n Der Gegner ist am  Zug....." + ConsoleColors.RESET);
                System.out.flush();
                TimeUnit.MILLISECONDS.sleep(1500);
                chosenAttack = logic.attackenRepository.getRandomAtt();
            }
            int damage = logic.calculateDamage(chosenAttack, attacker, defender);
            defender.setHp(defender.getHp() - damage);
            iu.displayAttackAnimation(attacker, defender, chosenAttack, damage);

            System.out.flush();
            TimeUnit.SECONDS.sleep(3);


            playerTurn = !playerTurn;

        }


    }

    private static SpielLogik initializeDAta() throws IOException {
        System.out.println("Lade CSV_DAteien");
        CsvDataManager dataManager = new CsvDataManager();
        JavamonRepository javamonRepo = new JavamonRepository();
        PokAttackeRepository attackRepo = new PokAttackeRepository();
        EffectivenessRepository effRepo = new EffectivenessRepository();
        List<Javamon> pokemonData =  dataManager.loadPokemon(POKE_CSV_PATH);
        Map<String, Map<String,Double>> effData = dataManager.loadEffectiveness(EFF_CSV_PATH);
        List<PokAttacke> attackData = dataManager.loadPokAttacke(ATTACKS_CSV_PATH);
        javamonRepo.init(pokemonData);
        attackRepo.init(attackData);
        effRepo.init(effData);

        System.out.println("...Dateien erfolgreich geladen.");

        return new SpielLogik(javamonRepo, attackRepo, effRepo);

    }

    private static void runGameLoop(PokAttackeRepository pok, SpielLogik logic, KonsolenIU iu, Scanner sc) throws IOException, InterruptedException {
        CsvDataManager csv = new CsvDataManager();
        boolean again;
        do {
            iu.clearConsole();
            iu.displayPokemonList(csv.loadPokemon(POKE_CSV_PATH));
            Javamon playerMon = null;
            while (playerMon == null) {
                String playerInout = iu.tryReadString("Wähle dein Javamon(ID oder NAME):", sc);
                playerMon = logic.selectPlayer(playerInout);
                if (playerMon == null) {
                    System.out.println(ConsoleColors.RED + "ungultige auswahl.Bitte erneut versuchen " + ConsoleColors.RESET);
                }
            }
            Javamon computerMon = logic.selectComp();

            logic.Attackkings(playerMon, 4);
            logic.Attackkings(computerMon, 4);
            iu.displaySelections(playerMon, computerMon);
            TimeUnit.SECONDS.sleep(4);

            startBattle(playerMon, computerMon, logic, iu, sc,pok);
            iu.clearConsole();
            Javamon winner = (playerMon.getHp()>0 ) ? playerMon : computerMon;
            Javamon loser = (playerMon.getHp()>0) ? computerMon :playerMon;
            iu.displayWinnerAnimation(winner,loser);
            TimeUnit.SECONDS.sleep(4);
            again = iu.playAgain("Möchtest du noch einmal spielen? (Ja/Nein)" ,sc);
        } while (again) ;

    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        KonsolenIU iu = new KonsolenIU();
        SoundManager sm = new SoundManager();
        JavamonRepository ja = new JavamonRepository();
        PokAttackeRepository pok = new PokAttackeRepository();

        SpielLogik logic = initializeDAta();

        iu.displayWelcomeAnimation();
        sm.playSound(WELCOME_SOUND_PATH);
        System.out.println("Zum Starten Enter Drücken");
sc.nextLine();

runGameLoop(pok,logic,iu,sc);
iu.displayClosingAnimation();
sc.close();
        System.out.println("App wird beendet");

    }

}


