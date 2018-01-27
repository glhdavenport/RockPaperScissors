package rockpaperscissors;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class RockPaperScissorsApp extends JFrame implements ActionListener
{
    JPanel topPanel;
    JPanel centerPanel;
    JPanel userPanel;
    JPanel computerPanel;
    JPanel bottomPanel;
    
    JButton btnRock;
    JButton btnPaper;
    JButton btnScissors;
    
    ImageIcon rockImg;
    ImageIcon paperImg;
    ImageIcon scissorsImg;
    ImageIcon rockImgLrg;

    ImageIcon paperImgLrg;
    ImageIcon scissorsImgLrg;
    
    JLabel result;
    JLabel choose;
    
    JLabel lblComputerChoice;
    JLabel lblUserChoice;
   
    
    Random rand = new Random();
    private final ArrayList compChoices = new ArrayList<>();
    int computerChoice;
    int userChoice;
   

    public static void main(String[] args)
    {
        RockPaperScissorsApp frame = new RockPaperScissorsApp();
        frame.setSize(800,400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    public RockPaperScissorsApp()
    {
     rockImgLrg = new ImageIcon(RockPaperScissors.class.getResource("rock.png")); 
     paperImgLrg = new ImageIcon(RockPaperScissors.class.getResource("paper.png")); 
     scissorsImgLrg = new ImageIcon(RockPaperScissors.class.getResource("scissors.png")); 
     
     topPanel = new JPanel();
     result = new JLabel("Rock 0   |   Paper []   |   Scissors 8< ");
     result.setFont(new Font("Ariel", Font.PLAIN, 25));
     topPanel.add(result);
     
     userPanel = new JPanel();
     userPanel.setBackground(Color.WHITE);
     lblUserChoice = new JLabel();
     lblUserChoice.setHorizontalAlignment(SwingConstants.CENTER);
     lblUserChoice.setVerticalAlignment(SwingConstants.CENTER);
     userPanel.add(lblUserChoice);
    
     computerPanel = new JPanel();
     computerPanel.setBackground(Color.WHITE);     
     lblComputerChoice = new JLabel();
     lblComputerChoice.setHorizontalAlignment(SwingConstants.CENTER);
     lblComputerChoice.setVerticalAlignment(SwingConstants.CENTER);
     computerPanel.add(lblComputerChoice);
     
     centerPanel = new JPanel(new GridLayout(1,2));
     centerPanel.add(userPanel);
     centerPanel.add(computerPanel);
     
     bottomPanel = new JPanel(new GridLayout (1,4));
     rockImg = new ImageIcon(RockPaperScissors.class.getResource("xsrock.png")); 
     btnRock = new JButton(rockImg);
     btnRock.addActionListener(this);
     paperImg = new ImageIcon(RockPaperScissors.class.getResource("xspaper.png")); 
     btnPaper = new JButton(paperImg);
     btnPaper.addActionListener(this);
     scissorsImg = new ImageIcon(RockPaperScissors.class.getResource("xsscissors.png")); 
     btnScissors = new JButton(scissorsImg);
     btnScissors.addActionListener(this);
     choose = new JLabel("Make a selection: ");
     choose.setFont(new Font ("Ariel", Font.PLAIN, 20));
     choose.setHorizontalAlignment(SwingConstants.CENTER);

     bottomPanel.add(choose);
     bottomPanel.add(btnRock);
     bottomPanel.add(btnPaper);
     bottomPanel.add(btnScissors);
     
     
    add(topPanel, BorderLayout.NORTH); 
    add(centerPanel, BorderLayout.CENTER);
    add(bottomPanel, BorderLayout.SOUTH);
    
    }
    
    public int computerChoice() 
    {    
    Random rand = new Random();    
    computerChoice = rand.nextInt(3);
    
    return computerChoice;
    }
    
    
   
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == btnRock)
        {
           lblUserChoice.setIcon(rockImgLrg);
           userChoice = 0;
           computerChoice();
           setCompImage(computerChoice);
           result.setText(evaluate(userChoice, computerChoice));
        }
        else if(e.getSource() == btnPaper)
        {
           lblUserChoice.setIcon(paperImgLrg);
           userChoice = 1;
           computerChoice();
           setCompImage(computerChoice);
           result.setText(evaluate(userChoice, computerChoice));
        }
        else if (e.getSource() == btnScissors)
        {
           lblUserChoice.setIcon(scissorsImgLrg);
           userChoice = 2;
           computerChoice();
           setCompImage(computerChoice);
           result.setText(evaluate(userChoice, computerChoice));
        }
    }

    private void setCompImage(int computerChoice)
    {
        this.computerChoice = computerChoice;
        switch (computerChoice)
        {
            case 0:
                lblComputerChoice.setIcon(rockImgLrg);
                break;
            case 1:
                lblComputerChoice.setIcon(paperImgLrg);
                break;
            case 2:
                lblComputerChoice.setIcon(scissorsImgLrg);
                break;
            default:
                break;
        }
    }
    
    public String evaluate(int userChoice, int computerChoice ) 
    {
        String eval = null;
        if ((userChoice == 0 && computerChoice == 1)
                ||(userChoice == 1 && computerChoice == 2)
                ||(userChoice == 2 && computerChoice == 0)) 
        {
            eval = "You Lose!";
            return eval;
        } 
        else if ((userChoice == 1 && computerChoice == 0)
                ||(userChoice == 2 && computerChoice == 1)
                ||(userChoice == 0 && computerChoice == 2)) 
        {
            eval = "You Win!";
            return eval;
        } 
        else if((userChoice == 0 && computerChoice == 0)
                ||(userChoice == 1 && computerChoice == 1)
                ||(userChoice == 2 && computerChoice == 2)) 
        {
            eval = "Tie!";
            return eval;
        }
        return eval;
    }
 
}
