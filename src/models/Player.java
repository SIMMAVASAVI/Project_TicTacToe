package models;

import java.util.Scanner;

public class Player {
    private static int idCounter=0;
    private int id;
    private String name;
    private PlayerType playerType;
    private Symbol symbol;
    private Scanner sc;


    public Player(String name, PlayerType playerType, Symbol symbol) {
        this.id=idCounter++;
        this.name = name;
        this.playerType = playerType;
        this.symbol = symbol;
        this.sc=new Scanner(System.in);
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }

    public Move makeMove(Board board){
        System.out.println("Please enter the row to move: ");
        int row = sc.nextInt();
        System.out.println("Please enter the column to move: ");
        int col= sc.nextInt();

        board.getBoard().get(row).get(col).setPlayer(this);
        board.getBoard().get(row).get(col).setCellState(CellState.FILLED);
        return new Move(new Cell(row,col,this),this);

    }
}
