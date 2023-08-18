package models;

import strategies.botDifficultyStrategy.BotPlayingStrategy;

public class Bot extends Player{
    BotDifficultyLevel botDifficultyLevel;
    BotPlayingStrategy botPlayingStrategy;

    public Bot(String name, PlayerType playerType, Symbol symbol,BotDifficultyLevel botDifficultyLevel,BotPlayingStrategy botPlayingStrategy) {
        super(name, playerType, symbol);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy = botPlayingStrategy;
    }

    public Move makeMove(Board board){
        Move move= botPlayingStrategy.makeMove(board,this);
        move.setPlayer(this);
        return move;
    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }

    public BotPlayingStrategy getBotPlayingStrategy() {
        return botPlayingStrategy;
    }

    public void setBotPlayingStrategy(BotPlayingStrategy botPlayingStrategy) {
        this.botPlayingStrategy = botPlayingStrategy;
    }
}
