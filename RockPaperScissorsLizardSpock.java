// package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by nmenego on 10/24/16.
 */
public class RockPaperScissorsLizardSpock extends Frame {
    RockPaperScissorsLizardSpock kani;
    private Label urChoice;
    private CheckboxGroup handChoices;
    private Checkbox rock;
    private Checkbox paper;
    private Checkbox scissors;
    private Checkbox lizard;
    private Checkbox spock;
    private Button rpsls;
    private Label besidesPlayerScr;
    private TextField playerScr;
    private Label besidesCompScr;
    private TextField compScr;
    private TextArea resultArea;
    private Font myFont = new Font("Serif", Font.BOLD, 15);
    private Dialog dialog;
    private Button dialogBtn;
    // private Button dialogBtn;
    // private Button dialogBtn2;
    int compChoice;
    int playerChoice;
    String toSetInResultArea;
    protected int compScore = 0;
    protected int playerScore = 0;
    boolean playerWins;


    public RockPaperScissorsLizardSpock() {
        setLayout(new FlowLayout());
        // "super" Frame (a Container) sets its layout to FlowLayout, which arranges
        // the components from left-to-right, and flow to next row from top-to-bottom.

        urChoice = new Label("Your choice:");
        urChoice.setBackground(Color.ORANGE);
        urChoice.setSize(25, 10);
        handChoices = new CheckboxGroup();
        rock = new Checkbox("Rock", handChoices, true);
        paper = new Checkbox("Paper", handChoices, false);
        scissors = new Checkbox("Scissors", handChoices, false);
        lizard = new Checkbox("Lizard", handChoices, false);
        spock = new Checkbox("Spock", handChoices, false);
        rpsls = new Button("RockPaperScissorsLizardSpock!");
        rpsls.setBackground(Color.GREEN);
        rpsls.setFont(myFont);
        rpsls.setSize(new Dimension(200, 60));
        besidesPlayerScr = new Label("Player's score:");
        besidesPlayerScr.setSize(50, 10);
        besidesPlayerScr.setBackground(Color.ORANGE);
        playerScr = new TextField("0", 15);
        besidesCompScr = new Label("Computer's score:");
        besidesCompScr.setSize(50, 10);
        besidesCompScr.setBackground(Color.ORANGE);
        compScr = new TextField("0", 15);
        resultArea = new TextArea("Results:\n");
        resultArea.setSize(60, 60);
        setBackground(Color.PINK);

        rpsls.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              if (compScore != 5 && playerScore != 5){
                game(); //generate the game loop
                // setVisible(true);
              }

              if (compScore == 5 || playerScore == 5){
                displayDialog(); //display dialog
              }
            }
        });

        // add them to container
        add(urChoice);
        setLayout(new GridLayout());
        //add(handChoices);
        add(rock);
        add(paper);
        add(scissors);
        add(lizard);
        add(spock);
        setLayout(new FlowLayout());
        add(rpsls);
        add(besidesPlayerScr);
        add(playerScr);
        add(besidesCompScr);
        add(compScr);
        add(resultArea);

        setTitle("RockPaperScissorsLizardSpock");
        setSize(800, 500);
        setVisible(true);

        // close window
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public void displayDialog(){
      dialog = new Dialog(this, "Game over");
      dialogBtn = new Button(whoWon() + " Click HERE to play again. Exit if not.");
      // dialogBtn = new Button("ok.");
      // dialogBtn2 = new Button("no.");

      dialogBtn.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            compScore = 0;
            playerScore = 0;
            playerScr.setText("0");
            compScr.setText("0");
            resultArea.setText("Results:\n");
            dialog.setVisible(false);
            setVisible(false);
            kani = new RockPaperScissorsLizardSpock();
          }
      });

      dialog.addWindowListener(new WindowAdapter() {
          public void windowClosing(WindowEvent we) {
              System.exit(0);
          }
      });

      dialog.add(dialogBtn);
      dialog.setBackground(Color.YELLOW);
      // dialog.add(dialogBtn);
      // dialog.add(dialogBtn2);
      dialog.setSize(400, 100);
      dialog.setVisible(true);
    }

    public String whoWon(){
      if (playerScore == 5){
        return "PLAYER WON.";
      }

      return "COMPUTER WON.";
    }

    public int convertplayerChoice(Checkbox given){
      if (given.getLabel() == "Rock")
        return 1;
      else if (given.getLabel() == "Paper")
        return 2;
      else if (given.getLabel() == "Scissors")
        return 3;
      else if (given.getLabel() == "Lizard")
        return 4;
      else
        return 5;
    }

    public String stringChoice(int given){
      if (given == 1)
        return "ROCK";
      else if (given == 2)
        return "PAPER";
      else if (given == 3)
        return "SCISSORS";
      else if (given == 4)
        return "LIZARD";
      else
        return "SPOCK";
    }

    public boolean isPlayerWinner(int playerChoice, int compChoice){
      if (playerChoice == 1){
        //rock defeats lizard and scissors
        if (compChoice == 4 || compChoice == 3){
          return true;
        }
      } else if (playerChoice == 2){
        //paper defeats rock and spock
        if (compChoice == 1 || compChoice == 5){
          return true;
        }
      } else if (playerChoice == 3){
        //scissors defeat lizard and paper
        if (compChoice == 4 || compChoice == 2){
          return true;
        }
      } else if (playerChoice == 4){
        //lizard defeats spock and paper
        if (compChoice == 5 || compChoice == 2){
          return true;
        }
      } else{
        if (playerChoice == 5){
          //spock defeats rock and scissors
          if (compChoice == 1 || compChoice == 3){
            return true;
          }
        }
      }

      return false;
    }

    public void game(){
      compChoice = 1 + (int)(Math.random() * 5); //generate a random num from 1 to 5
      playerChoice = convertplayerChoice(handChoices.getSelectedCheckbox());
      playerWins = isPlayerWinner(playerChoice, compChoice);
      toSetInResultArea = ("Results:\n" + String.format("Player chose %s\n", stringChoice(playerChoice))
                        + String.format("Computer chose %s\n\n", stringChoice(compChoice)));

      if (compChoice == playerChoice){
         toSetInResultArea += "NO ONE WINS THIS ROUND.";
      }else if (playerWins){
        toSetInResultArea += "YOU WIN THIS ROUND.";
        playerScore++;
        playerScr.setText(String.valueOf(playerScore));
      } else {
        toSetInResultArea += "COMPUTER WINS THIS ROUND.";
        compScore++;
        compScr.setText(String.valueOf(compScore));
      }

      resultArea.setText(toSetInResultArea);

    }

    public static void main(String[] args) {
        RockPaperScissorsLizardSpock something = new RockPaperScissorsLizardSpock();
    }
}
