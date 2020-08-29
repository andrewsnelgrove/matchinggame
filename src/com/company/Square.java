package com.company;
import javax.swing.JButton;
import java.awt.*;

public class Square extends JButton{
    private String squareStatus;
    private int colorNumber;
    //private colour;

    public Square()
    {
        this.squareStatus = "b";
    }

    //Methods

    public void assignColorNumber(int number)
    {
        this.colorNumber = number;
    }

    public int getColorNumber(){
        return this.colorNumber;
    }

    public void turnRed()
    {
        setBackground(Color.red);
    }

    public void turnIntoColour()
    {
        if (colorNumber == 1)
        {
            this.setBackground(Color.red);
        }
        else if (colorNumber == 2)
        {
            this.setBackground(Color.yellow);
        }
        else if (colorNumber == 3)
        {
            this.setBackground(Color.green);
        }
        else if (colorNumber == 4)
        {
            this.setBackground(Color.orange);
        }
        else if (colorNumber == 5)
        {
            this.setBackground(Color.blue);
        }
        else if (colorNumber == 6)
        {
            this.setBackground(Color.cyan);
        }
        else if (colorNumber == 7)
        {
            this.setBackground(Color.black);
        }
        else if (colorNumber == 8)
        {
            this.setBackground(Color.darkGray);
        }

    }

public void resetSquare(){
        this.setBackground(new Square().getBackground());
        this.setEnabled(true);
}


}
