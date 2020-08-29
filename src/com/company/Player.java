package com.company;

public class Player {
    private int score;
    private int turn;
    private String name;


    public Player(){
        score = 0;
        turn = -1;
        name = "";
    }

    public void addScore(){
        score += 1;
    }

    public void assignTurn(int turnNumber){
        turn = turnNumber;
    }

    public void assignName(String newName){
        this.name = newName;
    }

    public int getTurn(){
        return this.turn;
    }

    public String getName(){
        return this.name;
    }

    public int getScore(){
        return this.score;
    }



}
