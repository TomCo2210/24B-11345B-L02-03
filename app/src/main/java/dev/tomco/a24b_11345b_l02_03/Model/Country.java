package dev.tomco.a24b_11345b_l02_03.Model;

public class Country {

    private String name;
    private boolean canEnter;
    private int flagImage;

    public Country() {
    }

    public String getName() {
        return name;
    }

    public Country setName(String name) {
        this.name = name;
        return this;
    }

    public boolean isCanEnter() {
        return canEnter;
    }

    public Country setCanEnter(boolean canEnter) {
        this.canEnter = canEnter;
        return this;
    }

    public int getFlagImage() {
        return flagImage;
    }

    public Country setFlagImage(int flagImage) {
        this.flagImage = flagImage;
        return this;
    }
}
