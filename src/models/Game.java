package models;

import exceptions.DuplicateSymbolException;
import exceptions.InvalidBotCountException;
import exceptions.InvalidDimensionException;
import exceptions.InvalidPlayerCountException;
import strategies.winningStrategy.WinningStrategy;

import java.util.*;

public class Game {
    private List<Player>  players;
    private Board board;
    private List<Move> moves;
    private Player winner;
    private GameStatus gameStatus;
    private int nextPlayerToMove;
    private List<WinningStrategy> winningStrategies;
    private Game(Builder builder) {
        this.players = builder.players;
        this.board = new Board(builder.dimension);
        this.moves=new ArrayList<Move>();
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.nextPlayerToMove = 0;
        this.winningStrategies = builder.winningStrategies;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Board getBoard() {
        return board;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public Player getWinner() {
        return winner;
    }

    public GameStatus getGameState() {
        return gameStatus;
    }

    public int getNextPlayerToMove() {
        return nextPlayerToMove;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public static Builder builder(){
        return(new Builder());
    }
    public static class Builder{
        List<Player>  players;
        int dimension;
        List<WinningStrategy> winningStrategies;

        public Builder() {
            this.players = new ArrayList<Player>();
            this.dimension=0;
            this.winningStrategies = new ArrayList<WinningStrategy>();
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setBoard(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        public void addPlayer(Player player){
            this.players.add(player);
        }

        public void addWinningStrategy(WinningStrategy winningStrategy){
            this.winningStrategies.add(winningStrategy);
        }

        private void validateNoOfPlayers(){
            if(this.players.size()<dimension-1){
                throw new InvalidPlayerCountException("Players should be 1 less than dimension");
            }
        }

        private void validateNoOfBots(){
            int botCount=0;
            for(Player player: players){
                if(player.getPlayerType().equals(PlayerType.BOT)){
                    botCount+=1;
                }
            }
            if(botCount>1){
                throw new InvalidBotCountException("Only 1 Bot is allowed");
            }
        }

        private void validatePlayerSymbols(){
            HashSet<Character> set = new HashSet<>();
            for(Player player: players){
                set.add(player.getSymbol().getSymbolChar());
            }
            if(players.size()!=set.size()){
                throw new DuplicateSymbolException("Each Player Should have unique Symbol");
            }
        }

        private void validateDimension(){
            if(this.dimension<3 || this.dimension>10){
                throw new InvalidDimensionException("Dimension should be grater than 2 and less than 10");
            }
        }

        private void validate(){
            this.validateNoOfPlayers();
            this.validateNoOfBots();
            this.validatePlayerSymbols();
            this.validateDimension();

        }
        public Game build(){
            this.validate();
            Game game= new Game(this);
            return game;
        }

    }



}
