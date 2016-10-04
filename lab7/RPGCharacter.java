//package lab7;

import java.util.Random;

/**
 * Created by nmenego on 9/29/16. Revised by Arniel, Daniel, and Frank
 */
public abstract class RPGCharacter {

    private String name;
    private int hp;

    public RPGCharacter(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    // implement in subclass
    public abstract int attack();
    public abstract void setAttackDamage(int chosenMove);

    // checks to see if character is still alive
    public boolean isAlive() {
        return hp > 0 ? true : false;
    }

    // inclusive random integer
    public int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    // may be overriden in subclass, damage is dependent on hero type
    public int takeDamage(int damage) {
        int randNum = randInt(1, 10);

        //Flee/Dodge/Accuracy method is implemented here, as suggested
        if ( randNum == 1 || randNum == 2 || randNum == 3 ){
            hp -= 0;
            System.out.println("--> MISSED!\n");
        } else if ( randNum == 4 || randNum == 5 || randNum == 10){
            hp -= damage;
            System.out.println("\nDAMAGE INFLICTED IS " + damage + "hp !!!\n");
        } else{
            //inflected damage could be 60-90 percent, depende sa randNum from [6, 9]
            int someVar = (int)(( randNum / 10.0 ) * damage);
            hp -= someVar;
            System.out.println("\nDAMAGE INFLICTED IS " + someVar + "hp !!!\n");
        }

        return hp;
    }

    // getters setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public String toString() {
        return "RPGCharacter{ " +
                "name='" + name + '\'' +
                ", hp=" + hp;
                //+ '}'; gipala nako for some reasons
    }
}