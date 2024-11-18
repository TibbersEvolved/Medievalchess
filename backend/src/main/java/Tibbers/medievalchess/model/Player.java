package Tibbers.medievalchess.model;

public class Player {
    private int id;
    private int gold;
    private String name;

    public Player(String name) {
        this.name = name;
        gold = 0;
    }

    public void gainIncome(int income) {
        gold += income;
    }

    public int getGold() {
        return gold;
    }
}
