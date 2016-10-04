//package ourlab7;

/**
 * Created by nmenego on 9/29/16. Revised by Arniel, Daniel, and Frank
 */

public class Thief extends Hero {

    private int move;
    private int attackDamage;
    private static final String[] thiefMoves = {"", "ilad", "dunggab", "specialSagpa", "murderKill!!"};

    public Thief(String name, int level) {
        super(name, 25, level);
        setMoveDamageIncrease(8); //Thief has the lowest hp and attack damage
    }

    public Thief(String name) {
        super(name, 125, 20);
        setMoveDamageIncrease(8);
    }

    //mura ra siya'g nag-getAttackDamage so no need na i-implement ang getAttackDamage
    public int attack(){
        return attackDamage;
    }

    public void setAttackDamage(int chosenMove) {
        setNumTimesMoveCanbeUsed(chosenMove, getNumTimesMoveCanbeUsed(chosenMove) - 1);
        attackDamage = getMoveDamage(chosenMove);
    }

    public int takeDamage(int damage) {
        //damage na matake sa Thief kay ang original damage sa kakontra
        return super.takeDamage(damage);
        //super calls RPGCharacter class in this case
    }

    public String toString(){
        return super.toString() + ';' + " AvailableMoves{" +
                thiefMoves[1] + '=' + getNumTimesMoveCanbeUsed(1) + ", " +
                thiefMoves[2] + '=' + getNumTimesMoveCanbeUsed(2) + ", " +
                thiefMoves[3] + '=' + getNumTimesMoveCanbeUsed(3) + ", " +
                thiefMoves[4] + '=' + getNumTimesMoveCanbeUsed(4) + "} }";
    }
}