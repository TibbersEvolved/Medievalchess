package Tibbers.medievalchess.model;

public class Player {
    private int id;
    private int gold;
    private String name;
    private int turnId;

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

    public String getName() {
        return name;
    }

    public int getTurnId() {
        return turnId;
    }

    public void setTurnId(int turnId) {
        this.turnId = turnId;
    }
}
