//package ourlab7;

/**
 * Created by nmenego on 9/29/16. Revised by Arniel, Daniel, and Frank
 */

public class Swordsman extends Hero {

    private int move;
    private int attackDamage;
    private static final String[] swordsmanMoves = {"", "luba", "duslakMachete", "gulgol", "espadaNiPanday!!"};

    public Swordsman(String name, int level) {
        //naay highest na hp above the 3 heroes, but gamay ang damage
        super(name, 30 , level);
        setMoveDamageIncrease(5);
    }

    public Swordsman(String name) {
        super(name, 125 + 8, 20);
        setMoveDamageIncrease(5);
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
        //reduce the damage by 5 bcoz of imaginary armor!!
        return super.takeDamage(damage - 7);
        //super calls RPGCharacter class in this case
    }

    public String toString(){
        return super.toString() + ';' + " AvailableMoves{" +
                swordsmanMoves[1] + '=' + getNumTimesMoveCanbeUsed(1) + ", " +
                swordsmanMoves[2] + '=' + getNumTimesMoveCanbeUsed(2) + ", " +
                swordsmanMoves[3] + '=' + getNumTimesMoveCanbeUsed(3) + ", " +
                swordsmanMoves[4] + '=' + getNumTimesMoveCanbeUsed(4) + "} }";
    }
}