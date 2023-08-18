package models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    int size;
    List<List<Cell>> board;

    public Board(int size) {
        this.size = size;
        this.board = new ArrayList<>();

        for(int i=0;i<this.size;i++){
            this.board.add(new ArrayList<>());
            for(int j=0;j<this.size;j++){
                this.board.get(j).add(new Cell(i,j));
            }
        }
    }

    public void printBoard(){
        for(int i=0;i<this.size;i++) {
            List<Cell> cells = this.board.get(i);
            for (int j = 0; j < this.size; j++) {
                cells.get(j).display();
            }
            System.out.println();
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setCells(List<List<Cell>> board) {
        this.board = board;
    }


}
