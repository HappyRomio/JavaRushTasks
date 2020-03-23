package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.net.Socket;

public class Client {

    protected Connection connection;
    private volatile boolean clientConnected;

    protected String getServerAddress() {
        ConsoleHelper.writeMessage("Please, enter server address: ");
        return ConsoleHelper.readString();
    }

    protected int getServerPort() {
        ConsoleHelper.writeMessage("Please, enter server port: ");
        return ConsoleHelper.readInt();
    }

    protected String getUserName() {
        ConsoleHelper.writeMessage("Please, enter username: ");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSendTextFromConsole() {
        return true;
    }

    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    protected void sendTextMessage(String text) {

        try {
            Message message = new Message(MessageType.TEXT,text);
            connection.send(message);
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Message didnt send.");
            clientConnected = false;
        }
    }

    public void run(){
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();
        synchronized (this){
            try {
                wait();
            } catch (InterruptedException e) {
                ConsoleHelper.writeMessage("Error when was waiting");
            }
            if(clientConnected){
                ConsoleHelper.writeMessage("Соединение установлено.Для выхода наберите команду 'exit'.");
            } else {
                ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
            }


            while (clientConnected){
                String text = ConsoleHelper.readString();
                if(text.equalsIgnoreCase("exit")){
                    break;
                }
                if(shouldSendTextFromConsole())
                    sendTextMessage(text);
            }
        }
    }

    public class SocketThread extends Thread {

        protected void processIncomingMessage(String message){
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName) {
            ConsoleHelper.writeMessage(userName + " connected to chat.");
        }

       protected void informAboutDeletingNewUser(String userName) {
           ConsoleHelper.writeMessage(userName + " leave chat.");
       }

       protected  void notifyConnectionStatusChanged(boolean clientConnected) {
            synchronized (Client.this) {
                Client.this.clientConnected = clientConnected;
                Client.this.notify();
            }
       }

        protected void clientHandshake() throws IOException, ClassNotFoundException {
            String userName = "";
            while (!clientConnected) {
                Message message = connection.receive();
                if (message.getType() == MessageType.NAME_REQUEST) {
                    userName = getUserName();
                    Message answer = new Message(MessageType.USER_NAME, userName);
                    connection.send(answer);
                } else if (message.getType() == MessageType.NAME_ACCEPTED) {
                    notifyConnectionStatusChanged(true);
                } else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException {

            String userName = "";
            while (!clientConnected) {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT) {
                    processIncomingMessage(message.getData());
                } else if (message.getType() == MessageType.USER_ADDED) {
                    informAboutAddingNewUser(message.getData());
                } else if (message.getType() == MessageType.USER_REMOVED) {
                    informAboutDeletingNewUser(message.getData());
                } else {
                    throw new IOException("Unexpected MessageType");
                }
            }

        }

        @Override
        public void run() {
                String host = getServerAddress();
                int port = getServerPort();

            try {
                Socket socket = new Socket(host,port);
                connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();
            } catch (IOException | ClassNotFoundException e) {
                notifyConnectionStatusChanged(false);
                e.printStackTrace();
            }


        }
    }


    public static void main(String[] args){
        Client client = new Client();
        client.run();
    }
}
