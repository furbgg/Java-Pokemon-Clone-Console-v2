package Javamonv1;

import java.util.*;

public class JavamonRepository {
    private Map<String, Javamon> pokemonName = new HashMap<>();
    private Map<Integer, Javamon> pokemonById = new HashMap<>();
    ArrayList<Javamon> ListvonPoke = new ArrayList<>();


    public JavamonRepository() {

    }
    //Ich habe die init-Methode geschrieben, damit sie regelmäßig und nahezu fehlerfrei funktioniert.
    public void init (List<Javamon> javamonsList) {
        System.out.println(javamonsList.size() + "Pokemon Reporitory");
        for (Javamon ja: javamonsList) {
            pokemonById.put(ja.getId(), ja);
            this.pokemonName.put(ja.getName().toLowerCase(), ja);
            ListvonPoke.add(ja);
        }
    }

        public Javamon getPokemonById (Integer id){
            return pokemonById.get(id);
        }


        public Javamon getPokemonByName (String name){
            return pokemonName.get(name.toLowerCase());
        }


        public Javamon getRandomPokemon () {
            Random r = new Random();
            return ListvonPoke.get(r.nextInt(ListvonPoke.size()));
        }


        public List<Javamon> getAllPoke () {
            return ListvonPoke;
        }

}
