//package lab7;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by nmenego on 9/29/16.
 */
public class RPG {

    private Random rand;

    // constructor
    public RPG() {
        this.rand = new Random();
    }

    // generate a random monster name..
    public String getRandomMonsterName() {
        String[] adjectives = {"Green", "Pale","Slimy", "Bloody", "Smelly", "Ugly", "Sweaty", "Hungry", "Mad", "Funny"};
        String[] monsters = {"Student", "Ogre", "Elf", "Giant", "Teacher", "Zombie", "Alien", "Elephant", "Man", "Carabao"};
        List<String> adjs = Arrays.asList(adjectives);
        List<String> mons = Arrays.asList(monsters);

        return adjs.get(randInt(0, adjs.size() - 1)) + " " + mons.get(randInt(0, mons.size() - 1));
    }

    // inclusive random integer
    public int randInt(int min, int max) {
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum; 
    }

    // coin toss --> no need na ni later on
    // public boolean coinToss() {
    //     return randInt(0, 1) == 1 ? true : false;
    // }

    // pause the game for awhile for dramatic effect!
    public void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    // duel two characters, one as attacker, one as defender; returns true if someone is killed
    //GAMITON FOR HERO VS. HERO, OR HERO VS. MONSTER
    public boolean duel(RPGCharacter attacker, RPGCharacter defender) {
        Scanner sc = new Scanner(System.in);

        //System.out.println(attacker);
        System.out.print("Choose a move (1=move1, 2=move2, 3=move3, 4=move4): ");
        int move = sc.nextInt();

        while (move != 1 && move != 2 & move != 3 && move!= 4){

            System.out.println("Number invalid! Choose again.");
            System.out.println(attacker);
            System.out.print("Choose a move (1=move1, 2=move2, 3=move3, 4=move4): ");
            move = sc.nextInt();
        }

        if( ((Hero)attacker).getNumTimesMoveCanbeUsed(move) <= 0 ){
            while (((Hero)attacker).getNumTimesMoveCanbeUsed(move) <= 0){
                System.out.println("\nNo available moves for that!! Choose again.");
                System.out.println(attacker);
                System.out.print("Choose a move (1=move1, 2=move2, 3=move3, 4=move4): ");
                move = sc.nextInt();
            }
        }

        ((Hero)attacker).setAttackDamage(move);
        int damage = attacker.attack();
        System.out.println("--> " + attacker.getName() + " ATK " + defender.getName());
        sleep(2000);

        int remHp = defender.takeDamage(damage);
        if (remHp <= 0) {
            System.out.printf("--> %s killed %s!\n", attacker.getName(), defender.getName());
            return true;
        }
        return false;
    }

    //GAMITON FOR MONSTER VS. HERO
    public boolean duel2(RPGCharacter attacker, RPGCharacter defender) {
        int damage = attacker.attack();
        System.out.println("--> " + attacker.getName() + " ATK " + defender.getName());
        sleep(2000);

        int remHp = defender.takeDamage(damage);
        if (remHp <= 0) {
            System.out.printf("--> %s killed %s!\n", attacker.getName(), defender.getName());
            return true;
        }
        
        return false;
    }


    //THE GAME!!! EXCITED?!
    public static void main(String[] args){
        RPG rpg = new RPG();
        Scanner sc = new Scanner(System.in);

        System.out.println("\n\n~~~~~ HEROES ARE SUMMONED ~~~~~");
        System.out.print("Are you ready to play? (1=yes, 2=no): ");
        int x = sc.nextInt();

        //continue to scan until x is valid (1 or 2)
        while ( x != 1 && x != 2 ){
            System.out.println("Number invalid! Try again\n");
            System.out.print("Are you ready to play? (1=yes, 2=no): ");
            x = sc.nextInt();
        }

        if ( x == 1 ){
            System.out.print("Choose (1=single player, 2=2 players): ");
            int y = sc.nextInt();

            //continue to scan until y is valid
            while ( y != 1 && y != 2 ){
                System.out.println("Number invalid! Choose again!\n");
                System.out.print("Choose (1=single player, 2=2 players): ");
                y = sc.nextInt();
            }

            //PLAYER AGAINST MONSTER
            if ( y == 1 ){
                String player1 = "";
                RPGCharacter playerOne = new Archer("dummyVal");


                //SCANS INFORMATION FOR PLAYER 1
                System.out.println("Mighty warrior, choose your Hero:");
                System.out.print("\t(1=Swordsman, 2=Thief, 3=Archer): ");
                int z = sc.nextInt();

                //continue to scan until z is valid
                while ( z != 1 && z != 2 && z != 3 ){
                    System.out.println("Number invalid! Choose again!\n");
                    System.out.print("\t(1=Swordsman, 2=Thief, 3=Archer): ");
                    z = sc.nextInt();
                }

                System.out.print("Player 1, provide a name for your Hero: ");
                player1 = sc.next();

                //level 5 is the base level
                if ( z == 1 ){
                    playerOne = new Swordsman(player1, 5); //level 5
                } else if ( z == 2 ){
                    playerOne = new Thief(player1, 5); //level 5
                } else {
                    //if z == 3
                    playerOne = new Archer(player1, 5); //level 5, base level
                }

                //Dako ug 10 hp ang monster kaysa sa Player, then ang iya damage kay randomized from 10 to 20
                RPGCharacter monster = new Monster(rpg.getRandomMonsterName(), playerOne.getHp() + 10, rpg.randInt(10, 15));

                System.out.println("====== GAME START =====\n");
                //System.out.printf("%s\n%s\n", playerOne, playerTwo);
                System.out.printf("%s%s\n", "Your opponent: " , monster + " }");

                //Hero will attack first
                int count = 0;
                int life = playerOne.getHp();
                while (true) {
                    System.out.println("== round " + ++count);
                    // Player 1 turn

                    System.out.println("It's your turn, " + playerOne.getName());
                    System.out.printf("%s\n", playerOne);
                    boolean monsterIsDead = rpg.duel(playerOne, monster);
                    
                    if (monsterIsDead){
                        System.out.println( playerOne.getName() + " wins!!");
                        System.out.println("level++, move damages++\n");
                        ((Hero)playerOne).setLevel( ((Hero)playerOne).getLevel() + 1);
                        playerOne.setHp( (life +=  5) );
                        ((Hero)playerOne).setNumTimesMoveCanbeUsed(1, 20 );
                        ((Hero)playerOne).setNumTimesMoveCanbeUsed(2, 15 );
                        ((Hero)playerOne).setNumTimesMoveCanbeUsed(3, 10 );
                        ((Hero)playerOne).setNumTimesMoveCanbeUsed(4, 1 );
                        ((Hero)playerOne).setMoveDamageIncrease(2);

                        monster = new Monster(rpg.getRandomMonsterName(), playerOne.getHp()+10, playerOne.attack() + rpg.randInt(1, 5));
                        System.out.println("New monster: " + monster + " }");
                        System.out.println("== round " + ++count);

                        System.out.println("It's your turn, " + playerOne.getName());
                        System.out.printf("%s\n", playerOne);
                        monsterIsDead = rpg.duel(playerOne, monster);
                    }

                    System.out.printf("\n%s%s\n", "Monster: " , monster + " }");
                    boolean player1IsDead = rpg.duel2(monster, playerOne);

                    if (player1IsDead){
                        System.out.println("GAME OVER!!");
                        System.out.println("LEVEL REACHED: " + ((Hero)playerOne).getLevel());
                        break;
                    }
                }
            } else{
                //y == 2, FOR TWO PLAYERS AGAINST EACH OTHER
                String player1 = "";
                String player2 = "";
                RPGCharacter playerOne = new Archer("dummyVal");
                RPGCharacter playerTwo = new Swordsman("dummyVal");

                //SCANS INFORMATION FOR PLAYER 1
                System.out.println("Player 1, choose your Hero:");
                System.out.print("\t(1=Swordsman, 2=Thief, 3=Archer): ");
                int z = sc.nextInt();

                //continue to scan until z is valid
                while ( z != 1 && z != 2 && z != 3 ){
                    System.out.println("Number invalid! Choose again!\n");
                    System.out.print("\t(1=Swordsman, 2=Thief, 3=Archer): ");
                    z = sc.nextInt();
                }

                System.out.print("Player 1, provide a name for your Hero: ");
                player1 = sc.next();

                if ( z == 1 ){
                    playerOne = new Swordsman(player1);
                } else if ( z == 2 ){
                    playerOne = new Thief(player1);
                } else {
                    //if z == 3
                    playerOne = new Archer(player1);
                }


                //SCANS INFORMATION FOR PLAYER 2
                System.out.println("Player 2, choose your Hero:");
                System.out.print("\t(1=Swordsman, 2=Thief, 3=Archer): ");
                int a = sc.nextInt();

                //continue to scan until a is valid
                while ( a != 1 && a != 2 && a != 3 ){
                    System.out.println("Number invalid! Choose again!\n");
                    System.out.print("\t(1=Swordsman, 2=Thief, 3=Archer): ");
                    a = sc.nextInt();
                }

                System.out.print("Player 2, provide a name for your Hero: ");
                player2 = sc.next();

                if ( a == 1 ){
                    playerTwo = new Swordsman(player2);
                } else if ( a == 2 ){
                    playerTwo = new Thief(player2);
                } else {
                    //if a == 3
                    playerTwo = new Archer(player2);
                }

                System.out.println("====== GAME START =====\n");


                int count = 0;
                while (true) {
                    System.out.println("== round " + ++count);

                    //Player 1 will attack first
                    System.out.println("It's your turn, " + playerOne.getName());
                    System.out.printf("%s\n", playerOne);
                    boolean player1IsDead = rpg.duel(playerOne, playerTwo);

                    if (player1IsDead){
                        System.out.println("Player 2 wins!!");
                        break;
                    }

                    // Player 2 turn
                    System.out.println("It's your turn, " + playerTwo.getName());
                    System.out.printf("%s\n", playerTwo);
                    boolean player2IsDead = rpg.duel(playerTwo, playerOne);

                    if (player2IsDead){
                        System.out.println("Player 1 wins!!");
                        break;
                    }
                }
            } //inner if-else
        } //outer if-else
    }
}