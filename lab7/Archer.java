//package lab7;

/**
 * Created by nmenego on 9/29/16. Revised by Arniel, Daniel, and Frank
 */

public class Archer extends Hero {

    private int move;
    private int attackDamage;
    private static final String[] archerMoves = {"", "usaKaArrow", "longRangeAttack", "rapidFire", "rainOfPoisonArrows"};

    public Archer(String name, int level) {
        //ang level na i-accept sa pag-initialize kay 5 lang
        super(name, 25, level);
        setMoveDamageIncrease(10); //Archer has 10 more attack/move damage compared to Thief and Swordsman
    }

    public Archer(String name) {
        super(name, 125, 20);
        setMoveDamageIncrease(10);
    }

    public int attack(){
        return attackDamage;
    }

    public void setAttackDamage(int chosenMove) {
        setNumTimesMoveCanbeUsed(chosenMove, getNumTimesMoveCanbeUsed(chosenMove) - 1);
        attackDamage = getMoveDamage(chosenMove);
    }

    public int takeDamage(int damage) {
        //ALWAYS DAKO ANG MA-TAKE NGA DAMAGE SA ARCHER BY 10
        return super.takeDamage(damage + 10);
        //super calls RPGCharacter class in this case
    }

    public String toString(){
        return super.toString() + ';' + " AvailableMoves{" +
                archerMoves[1] + '=' + getNumTimesMoveCanbeUsed(1) + "(move1)" + ", " +
                archerMoves[2] + '=' + getNumTimesMoveCanbeUsed(2) + "(move2)" + ", " +
                archerMoves[3] + '=' + getNumTimesMoveCanbeUsed(3) + "(move3)" + ", " +
                archerMoves[4] + '=' + getNumTimesMoveCanbeUsed(4) + "(move4)" + "} }";
    }
}