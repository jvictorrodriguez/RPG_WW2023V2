package com.ironhack.model;

public abstract class Character {
    private static int idCounter=1;
    private final int id;
    private String name;
    private int hp;
    private boolean isAlive;




    /** CONSTRUCTORS
     *  a default/empty constructor sets
     * id and autoincrements it
     * isAlive set to true
     */
    public Character() {
        id=idCounter++;
        isAlive=true;
    }

    //This constructor calls in first place the default constructor
    //*to set id and isAlive
    public Character(String name, int hp) {
        this();
        this.name = name;
        setHp(hp);
    }

    // ********* GETTERS *********
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public boolean isAlive() {
        return isAlive;
    }

    // ********* SETTERS *********
    public void setName(String name) {
        this.name = name;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    // ********* TO STRING *********
    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hp=" + hp +
                ", isAlive=" + isAlive +
                '}';
    }
}
