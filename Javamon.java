package Javamonv1;

import java.util.ArrayList;
import java.util.List;

public class Javamon {
    private int id;
    private String name;
    private String type;
    private String type2;
    private int hp;
    private int attack;
    private int defense;
    private int spAtk;
    private int spDef;
    private int speed;
    private String asciiArt;
    private List<PokAttacke> attacken = new ArrayList<>();
    private int maxHp;

    public Javamon(Javamon original) {
        this.id = original.id;
        this.name = original.name;
        this.type = original.type;
        this.type2 = original.type2;
        this.hp = original.hp;
        this.attack = original.attack;
        this.defense = original.defense;
        this.speed = original.speed;
        this.asciiArt = original.asciiArt;
        this.attacken = new ArrayList<>();
        this.spAtk = original.spAtk;
        this.spDef = original.spDef;
        this.maxHp = original.maxHp;

    }
    public Javamon() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpAtk() {
        return spAtk;
    }

    public void setSpAtk(int spAtk) {
        this.spAtk = spAtk;
    }

    public int getSpDef() {
        return spDef;
    }

    public void setSpDef(int spDef) {
        this.spDef = spDef;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getAsciiArt() {
        return asciiArt;
    }

    public void setAsciiArt(String asciiArt) {
        this.asciiArt = asciiArt;
    }

    public List<PokAttacke> getAttacken() {
        return this.attacken;
    }

    public void setAttacken(List<PokAttacke> attacken) {
        this.attacken = attacken;
    }

        public int getMaxHp() {
            return maxHp;
        }

        public void setMaxHp(int maxHp) {
            this.maxHp = maxHp;
        }
    }


