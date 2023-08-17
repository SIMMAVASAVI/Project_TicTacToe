package models;

public class Bot extends Player{
    BotDifficultyLevel botDifficultyLevel;

    public Bot(String name, PlayerType playerType, Symbol symbol) {
        super(name, playerType, symbol);
    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }
}
