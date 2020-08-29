package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Grid extends JFrame {

private int clickCounter;
private Container grid;
private ArrayList<Square> clickedSquares;
private Square[] buttonArray;
//List other private

    public Grid()
    {
        clickCounter = 0;
        clickedSquares = new ArrayList<Square>();

        setPreferredSize(new Dimension(500,500));


        Container grid = new Container();
        grid.setLayout(new GridLayout(4, 4));

        //Create array of Buttons
        buttonArray = new Square [16];



        int[] arrayOfColourNumbers = {1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8};
        int[] arrayOfRandomizedColourNumbers = genRandomColourNumArray(arrayOfColourNumbers);



        //Add action listeners to all arrays, then add to array
        for (int i = 0; i < 16; i++)
        {
            Square newSquare = new Square();
            newSquare.assignColorNumber(arrayOfRandomizedColourNumbers[i]);
            newSquare.addActionListener(e -> {newSquare.turnIntoColour(); newSquare.setEnabled(false); clickedSquares.add(newSquare); clickCounter += 1; checkIfTwoClicked(); checkForWinner();});
            buttonArray[i] = newSquare;
        }

        //Add buttons to container
        for (int i= 0; i < 16; i++)
        {
            grid.add(buttonArray[i]);
        }

        add(grid);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

private int[] genRandomColourNumArray(int[] array) {
    int arraySize = array.length;

    int[] arrayToReturn = new int[arraySize];

    int randomPosition;

        for (int i = 0; i < arraySize; i++)
        {
            boolean freePositionNotFound = true;
            while (freePositionNotFound) {
                int tempNumberToMove = array[i];
                randomPosition = ThreadLocalRandom.current().nextInt(0, 16);
                if (!(array[randomPosition] == -1)) {
                    freePositionNotFound = false;
                    arrayToReturn[i] = array[randomPosition];
                    array[randomPosition] = -1;
                }
            }

        }


return arrayToReturn;
}

private void checkIfTwoClicked(){
        if (clickCounter != 2)
        {
            return;

        }
        if (doSquareColorsMatch() != true)
        {
            JOptionPane.showMessageDialog(new JFrame(), "Sorry, they do not match. Try again!");

            //Here, reset the buttons clicked.
            resetClickedSquares();

            clickedSquares.clear();
            clickCounter = 0; //Reset
            return;
        }
        JOptionPane.showMessageDialog(new JFrame(), "Good job!");
        clickedSquares.clear();
        clickCounter = 0;
        return;
}

private boolean doSquareColorsMatch(){
        boolean answerToReturn;
        if (clickedSquares.get(0).getColorNumber() != clickedSquares.get(1).getColorNumber())
        {
            answerToReturn = false;
        }
        else
        {
            answerToReturn = true;
        }
        return answerToReturn;
}

private void resetClickedSquares(){
        clickedSquares.get(0).resetSquare();
        clickedSquares.get(1).resetSquare();
        return;
}

private void checkForWinner(){
        for (int i = 0; i < 16; i++)
        {
            if (buttonArray[i].isEnabled() == true)
            {
                return;
            }
        }

        Object[] theOptions ={"Yes!", "No and exit"};
        int n = JOptionPane.showOptionDialog(new JFrame(), "Congratulations, you won! Play again?", "Congratulations and Reset Game Option", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, theOptions,theOptions[2]);
        //JOptionPane.showMessageDialog(new JFrame(), "Congratulations! You won!");

    }

}
