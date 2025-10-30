package Javamonv1;

import java.util.Random;

public class SpielLogik {

    private final JavamonRepository javamonRepository;
    private final PokAttackeRepository attackenRepository;
    private EffectivenessRepository  effectivenessRepository;
    private final Random random = new Random(); // Rnd değeri için

    public SpielLogik(JavamonRepository repo, PokAttackeRepository attackRepo,EffectivenessRepository effRepo) {
        this.javamonRepository = repo;
        this.attackenRepository = attackRepo;
        this.effectivenessRepository = effRepo;
    }

    public Javamon selectPlayer(String eingabe) {
        Javamon foundJavamon = null;
        try {
            int id = Integer.parseInt(eingabe);
            foundJavamon = this.javamonRepository.getPokemonById(id);
        } catch (NumberFormatException e) {
            foundJavamon = this.javamonRepository.getPokemonByName(eingabe);
        }
        if (foundJavamon == null) {
            System.out.println("Fehler!");
            return  null;
        }
        return new Javamon(foundJavamon);
    }

    public Javamon selectComp() {
        Javamon foundJavamonforComp = javamonRepository.getRandomPokemon();
        return new Javamon(foundJavamonforComp);
    }

    public int calculateDamage(PokAttacke attacke, Javamon attacking, Javamon attacked) {
        double levelMultiplier = (50.0 / 50.0);


        int atkPw = attacke.getPower();


        int apkA;
        int dpkD;

        if (attacke.getKind().equalsIgnoreCase("Physical")) {
            apkA = attacking.getAttack();
            dpkD = attacked.getDefense();
        } else if (attacke.getKind().equalsIgnoreCase("Special")) {
            apkA = attacking.getSpAtk();
            dpkD = attacked.getSpDef();
        } else {
            apkA = 1;
            dpkD = 1;
            atkPw = 0;
        }

        if (dpkD == 0) dpkD = 1;
        double rnd = 0.85 + (1.0 - 0.85) * random.nextDouble();
        double stab = 1.0;
        String attackType = attacke.getType();
        if (attackType.equalsIgnoreCase(attacking.getType()) ||
                (attacking.getType2() != null && attackType.equalsIgnoreCase(attacking.getType2()))) {
            stab = 1.5;
        }
        double eff1 = effectivenessRepository.getEffectiveness(attackType, attacked.getType());
        double eff2 = effectivenessRepository.getEffectiveness(attackType, attacked.getType2());
        double schaden = (atkPw) * ((double) apkA / dpkD) * levelMultiplier * rnd * stab * eff1 * eff2;
        return (int) Math.round(schaden);
    }

    public void Attackkings(Javamon javamon, int anzahl) {
        javamon.getAttacken().clear();

        for (int i = 0; i < anzahl; i++) {
            PokAttacke randomattacke = attackenRepository.getRandomAtt();
            javamon.getAttacken().add(randomattacke);
        }
    }

    public void startFight(Javamon spieler, Javamon computer) {
        System.out.println("Kampf startet : " + spieler.getName() + " v s " + computer.getName());
        Attackkings(spieler, 2);
        Attackkings(computer, 2);
        System.out.println(spieler.getName() + " hat die Attacken " + spieler.getAttacken().get(0).getName() + "und " + spieler.getAttacken().get(1).getName());
        System.out.println(computer.getName() + " hat die Attacken " + computer.getAttacken().get(0).getName() + "und" + computer.getAttacken().get(1).getName());

        boolean turn = true;

        if (spieler.getSpeed() >= computer.getSpeed()) {
            turn = true;

            System.out.println(spieler.getName() + " ist schneller und greift zuerst an!");

        } else {
            turn = false;
            System.out.println(computer.getName() + " ist schneller und greift zuerst an!");
        }

        while (spieler.getHp() > 0 && computer.getHp() > 0) {
            if (turn) {
                System.out.println("Du bist dran");
                PokAttacke useratt = spieler.getAttacken().get(0);
                int schaden = calculateDamage(useratt, spieler, computer);
                computer.setHp(computer.getHp() - schaden);
                System.out.println(spieler.getName() + " greift mit " + useratt.getName() + " an und verursacht " + schaden + "Schaden !");
                System.out.println("Computer" + computer.getName() + "hat noch " + computer.getHp() + "HP");
            } else {
                System.out.println("Computer ist dran");
                PokAttacke attackeChoseC = computer.getAttacken().get(new Random().nextInt(2));
                int schadenC = calculateDamage(attackeChoseC, computer, spieler);
                spieler.setHp(spieler.getHp() - schadenC);
                System.out.println(computer.getName() + "greift mit " + attackeChoseC.getName() + " an und verursachtr " + schadenC + "Schadeb!!!");
                System.out.println("Du" + spieler.getName() + "hast noch " + spieler.getHp() + "HP");
            }
            turn = !turn;
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {

            }

        }
        if (spieler.getHp()>0){
            System.out.println("Du hast gewonnen...");
        } else {
            System.out.println("Computer hat gewonnen....");
        }
    }
}



