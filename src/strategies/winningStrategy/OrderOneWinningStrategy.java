package strategies.winningStrategy;

import models.Board;
import models.Move;
import models.Player;
import models.Symbol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderOneWinningStrategy implements WinningStrategy {

    private int dimensions;
    private int symbolsAdded;

    private List<HashMap<Character,Integer>> rowSymbolCount =new ArrayList<>();

    private List<HashMap<Character,Integer>> colSymbolCount = new ArrayList<>();

    private HashMap<Character,Integer> topLeftDiagonalSymbolCount  = new HashMap<>();

    private HashMap<Character,Integer> topRightDiagonalSymbolCount = new HashMap<>();

    private HashMap<Character,Integer> cornerSymbolCount = new HashMap<>();
    public OrderOneWinningStrategy(int dimensions) {
        this.dimensions = dimensions;
        this.symbolsAdded = 0;
        for(int i=0;i<dimensions;i++)
        {
            rowSymbolCount.add(new HashMap<>());
            colSymbolCount.add(new HashMap<>());
        }
    }

    public boolean isCellTopLeftDaigonal(int row,int column){
        return row==column;
    }

    public boolean isCellTopRightDiagonal(int row,int column){
        return (row+column)==dimensions-1;
    }

    public boolean isCornerCell(int row,int column){
        if(row==0 || row==dimensions-1){
            return column==0 || column==dimensions-1;
        }
        return false;
    }

    @Override
    public Player checkWinner(Board board, Move lastMove) {
        symbolsAdded++;
        Player player=lastMove.getPlayer();
        int row= lastMove.getCell().getRow();
        int col=lastMove.getCell().getCol() ;
        char symbol= lastMove.getPlayer().getSymbol().getSymbolChar();

        if(checkForColWin(symbol,row,col,lastMove)!=null){
            return player;
        } else if (checkForColWin(symbol,row,col,lastMove)!=null) {
            return player;
        } else if (checkForDiagonalWin(symbol,row,col,lastMove)!=null) {
            return player;
        } else if (checkForCornerWin(symbol,row,col,lastMove)!=null) {
            return player;
        }
        else{
            return null;
        }
    }

    private Player checkForRowWin(char symbol,int row,int col,Move lastMove){
        if(!rowSymbolCount.get(row).containsKey(symbol)){
            rowSymbolCount.get(row).put(symbol,0);
        }
        rowSymbolCount.get(row).put(symbol,rowSymbolCount.get(row).get(symbol)+1);

        if(rowSymbolCount.get(row).get(symbol)==dimensions){
            return lastMove.getPlayer();
        }
        return null;
    }

    private Player checkForColWin(char symbol,int row,int col,Move lastMove){
        if(!colSymbolCount.get(col).containsKey(symbol)){
            colSymbolCount.get(col).put(symbol,0);
        }
        colSymbolCount.get(col).put(symbol,colSymbolCount.get(col).get(symbol)+1);

        if(colSymbolCount.get(col).get(symbol)==dimensions){
            return lastMove.getPlayer();
        }
        return null;
    }

    private Player checkForDiagonalWin(char symbol,int row,int col,Move lastMove){
        if(isCellTopLeftDaigonal(row,col)){
            if(!topLeftDiagonalSymbolCount.containsKey(symbol)){
                topLeftDiagonalSymbolCount.put(symbol,0);
            }
            topLeftDiagonalSymbolCount.put(symbol,topLeftDiagonalSymbolCount.get(symbol)+1);

            if(topLeftDiagonalSymbolCount.get(symbol)==dimensions){
                return lastMove.getPlayer();
            }
        }
        if(isCellTopRightDiagonal(row,col))
        {
            if(!topRightDiagonalSymbolCount.containsKey(symbol)){
                topRightDiagonalSymbolCount.put(symbol,0);
            }
            topRightDiagonalSymbolCount.put(symbol,topRightDiagonalSymbolCount.get(symbol)+1);

            if(topRightDiagonalSymbolCount.get(symbol)==dimensions){
                return lastMove.getPlayer();
            }
        }
        return null;
    }

    private Player checkForCornerWin(char symbol,int row,int col,Move lastMove){
        if(!cornerSymbolCount.containsKey(symbol)){
            cornerSymbolCount.put(symbol,0);
        }
        cornerSymbolCount.put(symbol,cornerSymbolCount.get(symbol)+1);

        if(cornerSymbolCount.get(symbol)==dimensions){
            return lastMove.getPlayer();
        }
        return null;
    }


}
