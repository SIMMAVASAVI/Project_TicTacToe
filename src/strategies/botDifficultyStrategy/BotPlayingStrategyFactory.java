package strategies.botDifficultyStrategy;

import models.BotDifficultyLevel;

public class BotPlayingStrategyFactory {

    public static BotPlayingStrategy getBotPlayingDifficultyLevel(BotDifficultyLevel difficultyLevel){
        return switch (difficultyLevel){
            case EASY -> new RandomBotPlayingStrategy();
            case MEDIUM -> new RandomBotPlayingStrategy();
            case DIFFICULT -> new RandomBotPlayingStrategy();
        };

    }

}
