package Homework;

import Compulsory.ClientThread;
import Compulsory.GameServer;

public class Game {
    Board board = new Board();
    GameServer gameServer;
    ClientThread player1;
    ClientThread player2;
    int numberOfPlayers = 0;

    public Game(GameServer gameServer) {
        this.gameServer = gameServer;
    }

    public void setPlayer(ClientThread player) {
        if(this.player1 == null) {
            this.player1 = player;
            player1.setName("Player1");
            player1.setSign(1);
        }
        else{
            this.player2 = player;
            player2.setName("Player2");
            player2.setSign(2);
        }
    }

    public void resetGame(){
        board = new Board();
    }

    public boolean joinGame(){
        numberOfPlayers++;
        if(numberOfPlayers <= 2) return true;
        else return false;
    }

    public Board getBoard() {
        return board;
    }
}
