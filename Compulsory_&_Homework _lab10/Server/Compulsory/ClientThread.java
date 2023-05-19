package Compulsory;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.io.DataOutputStream;

public class ClientThread {

    private String name;
    private Socket clientSocket;
    private DataInputStream in;
    private DataOutputStream out;
    private int id;
    private String line = "";
    private String gameReset = "reset game";

    private String gameJoin = "join game";
    int sign; //this is the sign of the player, his symbol for complete the five in a row on the table

    GameServer gameServer;

    public ClientThread(Socket clientSocket, int index, GameServer gameServer) {
           this.clientSocket = clientSocket;
           this.id = index;
           this.gameServer = gameServer;
        try {
            System.out.println("Player "+id+ ": Player Connected");
            this.in = new DataInputStream(new BufferedInputStream(clientSocket.getInputStream()));
            this.out = new DataOutputStream(clientSocket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readMessages() {

        do{
            try {
                line = in.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(line.equals(gameServer.getStopString())) {
                writeMessage(gameServer.getCaseStop());
                close();
            }
            else if (line.equals(gameReset)) {
                writeMessage("Game reseted");
                gameServer.game.resetGame();
            }
            else if (line.equals(gameJoin)) {
                if(gameServer.game.joinGame()) {
                    writeMessage("You joined the game, which is your move?");
                    do {
                        try {
                            line = in.readUTF();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        int x = Integer.parseInt(line.split(",")[0]);
                        int y = Integer.parseInt(line.split(",")[1]);
                        gameServer.game.getBoard().set(x, y, sign);
                        writeMessage("You moved to " + x + "," + y);
                    }while(!line.equals("game"));
                }
                else {
                    writeMessage("The game is full");
                }
            }
        }while(!line.equals(gameServer.getStopString()));
        System.out.println("Player "+id+ ": Client Disconnected");
    }

    public void writeMessage(String message) {
        try {
            out.writeUTF(message);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try{
            clientSocket.close();
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSign(int sign) {
        this.sign = sign;
    }

    public int getSign() {
        return sign;
    }
}
