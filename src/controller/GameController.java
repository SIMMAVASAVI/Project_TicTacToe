package controller;

import models.Game;
import models.GameStatus;
import models.Player;
import strategies.winningStrategy.WinningStrategy;

import java.util.List;

public class GameController {
    public Game createGame(int dimension, List<Player> playersList, List<WinningStrategy> winningStrategies){
        try{
            return Game.builder()
                    .setBoard(dimension)
                    .setPlayers(playersList)
                    .setWinningStrategies(winningStrategies)
                    .build();
        }
        catch (Exception e){
            System.out.println("Could not start game something went wrong");
        }
        return null;
    }

    public void printBoard(Game game){
        game.getBoard().printBoard();
    }

    public GameStatus printGameState(Game game){
        return game.getGameState();
    }

    public void makeMove(Game game){

    }

    public String getWinner(Game game){
        return game.getWinner().getName();
    }
}
