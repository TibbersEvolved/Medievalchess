package Tibbers.medievalchess.model;

public class Player {
    private int id;
    private int gold;

    public Player() {
        gold = 0;
    }

    public void gainIncome(int income) {
        gold += income;
    }

    public int getGold() {
        return gold;
    }
}
