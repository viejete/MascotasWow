package com.example.a53639858v.mascotaswow;

import java.io.Serializable;
import java.util.ArrayList;

public class Pet implements Serializable {

    private boolean canBattle;
    private int id;
    private String name;
    private String family;
    private String icon;
    private Stats stats;
    private ArrayList<String> strongAgainst;
    private int typeId;
    private ArrayList<String> weakAgainst;


    public boolean isCanBattle() {
        return canBattle;
    }

    public void setCanBattle(boolean canBattle) {
        this.canBattle = canBattle;
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

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public ArrayList<String> getStrongAgainst() {
        return strongAgainst;
    }

    public void setStrongAgainst(ArrayList<String> strongAgainst) {
        this.strongAgainst = strongAgainst;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public ArrayList<String> getWeakAgainst() {
        return weakAgainst;
    }

    public void setWeakAgainst(ArrayList<String> weakAgainst) {
        this.weakAgainst = weakAgainst;
    }
}
