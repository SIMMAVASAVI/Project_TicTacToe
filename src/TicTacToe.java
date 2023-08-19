import controller.GameController;
import models.*;
import strategies.botDifficultyStrategy.BotPlayingStrategy;
import strategies.botDifficultyStrategy.BotPlayingStrategyFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GameController gameController = new GameController();

        System.out.println("Please enter the dimension of the board");
        int size = sc.nextInt();
        System.out.println("Will there be any Bot in the game: Y/N ");
        String isBot = sc.next();

        List<Player> playersList = new ArrayList<>();
        int playerCount = size - 1;
        if (isBot == "Y") {
            playerCount = size - 2;
        }

        for (int i = 0; i < playerCount; i++) {
            System.out.println("Please enter name of player " + i + " : ");
            String name = sc.next();
            System.out.println("Please enter symbol for player " + i + " :");
            String symbol = sc.next();
            Player player = new Player(name, PlayerType.HUMAN, new Symbol(symbol.charAt(0)));
        }

        if (isBot == "Y") {
            System.out.println("Please enter name of BOT : ");
            String name = sc.next();
            System.out.println("Please enter symbol for BOT : ");
            String symbol = sc.next();

            Bot bot = new Bot(name, PlayerType.BOT, new Symbol(symbol.charAt(0)), BotDifficultyLevel.EASY,
                    BotPlayingStrategyFactory.getBotPlayingDifficultyLevel(BotDifficultyLevel.EASY));

            playersList.add(bot);
        }

        Collections.shuffle(playersList);

        Game game = gameController.createGame(size,playersList);
        int playerIndex=0;
        while(game.getGameState().equals(GameStatus.IN_PROGRESS)){
            System.out.println("Current Board Status: ");
            gameController.printBoard(game);
            playerIndex++;
            playerIndex=playerIndex%playersList.size();
            Move movePlayed= gameController.makeMove(game,playersList.get(playerIndex));
            Player winner= gameController.checkWinner(game,movePlayed);
            if(winner!=null){
                System.out.println("Winner is player : ");
                break;
            }
        }
    }
}
