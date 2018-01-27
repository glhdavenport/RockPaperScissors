package rockpaperscissors;
import javax.swing.ImageIcon;

public enum RockPaperScissors
{
    ROCK(new ImageIcon(RockPaperScissors.class.getResource("rock.png"))), 
    PAPER(new ImageIcon(RockPaperScissors.class.getResource("paper.png"))), 
    SCISSORS(new ImageIcon(RockPaperScissors.class.getResource("scissors.png")));

    public ImageIcon icon;
   
   
    private RockPaperScissors(ImageIcon icon) 
    {
    this.icon = icon;
    }

    public void setIcon(ImageIcon icon) 
    {
        this.icon = icon;
    }

    public ImageIcon getIcon() 
    {
        return icon;
    }
}


