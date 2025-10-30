package Javamonv1;

import java.util.*;

public class PokAttackeRepository {
    private Map<Integer, PokAttacke> attackenbyId = new HashMap<>();
    private ArrayList<PokAttacke> attackenList = new ArrayList<>();



    public PokAttackeRepository() {

    }
//Ich habe die init-Methode geschrieben, damit sie regelmäßig und nahezu fehlerfrei funktioniert.
    public void init(List<PokAttacke> attacksType) {
        System.out.println(attacksType.size() + "Attacks laden Repository herunter");
        for (PokAttacke pa : attacksType) {
            attackenbyId.put(pa.getId(),pa);
            attackenList.add(pa);
        }
    }



    public  PokAttacke getRandomAtt () {
        Random r = new Random();
        int list = attackenList.size();
        int randomindex =r.nextInt(list);
        return attackenList.get(randomindex);
    }
}

