package Compulsory;

import Homework.Game;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer {

        private ServerSocket server;
        private static final int PORT = 8887;
        private static final String STOP_STRING = "stop";
        private static final String caseStop = "Server stopped!";
        private static final String defaultMesssage = "Server received the request!";
        private int index = 0;

        Game game = new Game(this);

        public GameServer(){
            try{
                server = new ServerSocket(PORT);
                while(true) iniConnections();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void iniConnections() throws IOException {
            Socket clientSocket = server.accept();

            if(clientSocket.isConnected())
                new Thread(()->{
                    index++;
                    ClientThread client = new ClientThread(clientSocket,index, this);
                    game.setPlayer(client);
                    client.readMessages();
                    client.close();
                }).start();
        }

        public String getStopString() {
        	return STOP_STRING;
        }

        public String getCaseStop() {
        	return caseStop;
        }

        public String getDefaultMessage() {
        	return defaultMesssage;
        }


}
