package org.example;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


public class ClientApplication {
        private Socket socket;

        private static final int PORT = 8887;
        private static final String STOP_STRING = "stop";
        private DataOutputStream out;
       private DataInputStream in2;
        private Scanner in;

        private boolean does = false;

        public ClientApplication(){
            try{
                socket = new Socket("127.0.0.1", PORT);
                out = new DataOutputStream(socket.getOutputStream());
                in2 = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                in = new Scanner(System.in);
                do{

                        writeReadMessages();

                }while(!in.nextLine().equals(STOP_STRING));
                close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void writeReadMessages() throws IOException {
            String line = "";
            do{
                line = in.nextLine();
                out.writeUTF(line);
                line = in2.readUTF();
                if (line.equals("The game is full")) {
                    System.out.println("Server is full, try again later!");
                    close();
                }
                System.out.println(line);
            }while(!line.equals(STOP_STRING));
        }

        private void close() throws IOException {
            socket.close();
            out.close();
            in.close();
            in2.close();
            System.exit(0);
        }
}
