package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {

    private static final Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String... args) throws IOException {

        ConsoleHelper.writeMessage("Port vvedi syka!:");
        int port = ConsoleHelper.readInt();
        ConsoleHelper.writeMessage("Server started!!!");
        try(ServerSocket serverSocket = new ServerSocket(port);) {
        while(true){
             new Handler(serverSocket.accept()).start();
        }
        }catch (Exception e){
            ConsoleHelper.writeMessage(e.getMessage());
        }
    }

    private static class Handler extends Thread {
        private final Socket socket;


        private Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            ConsoleHelper.writeMessage("Connected with " + socket.getRemoteSocketAddress());
            String username = null;
            try (Connection connection = new Connection(socket)){
               username = serverHandshake(connection);
               sendBroadcastMessage(new Message(MessageType.USER_ADDED, username));
               notifyUsers(connection,username);
               serverMainLoop(connection,username);
            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Error while changing messages with server");
                if(username!=null){
                    connectionMap.remove(username);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED,username));
                }
            }

            if(username!=null){
                connectionMap.remove(username);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED,username));
            }


        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message received = connection.receive();
                if (received.getType() == MessageType.USER_NAME && received.getData()!="") {
                    Connection connectionToUser = connectionMap.get(received.getData());
                    if (connectionToUser == null) {
                        connectionMap.put(received.getData(), connection);
                        connection.send(new Message(MessageType.NAME_ACCEPTED, "Your name accepted"));
                        return received.getData();
                    }
                }
            }
        }

        private void notifyUsers(Connection connection, String userName) throws IOException{
            for(Map.Entry<String, Connection> entry : connectionMap.entrySet()){
                if(!entry.getKey().equals(userName)){
                    connection.send(new Message(MessageType.USER_ADDED,entry.getKey()));
                    entry.getValue().send(new Message(MessageType.USER_ADDED,userName));
                }
            }

        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException{
            while (true){
                Message recived = connection.receive();
                if(recived.getType() == MessageType.TEXT){
                    String message = userName + ": " + recived.getData();
                    sendBroadcastMessage(new Message(MessageType.TEXT, message));
                } else {
                    ConsoleHelper.writeMessage("Wrong MessageType");
                }
            }
        }
    }



    public static void sendBroadcastMessage(Message message) {
            connectionMap.forEach((s, con) -> {
                try {
                    con.send(message);
                } catch (IOException e) {
                    ConsoleHelper.writeMessage("Can't send message");
                }
            });
    }
}
