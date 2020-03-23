package com.javarush.games.snake;

import com.javarush.engine.cell.*;

import javax.swing.*;

public class SnakeGame extends Game {
    public static final int WIDTH = 15;
    public static final int HEIGHT = 15;
    private static final int GOAL = 28;
    private int score;
    private Snake snake;
    private int turnDelay;
    private boolean isGameStopped;
    private Apple apple;

    @Override
    public void initialize(){
        setScreenSize(WIDTH,HEIGHT);
        createGame();

    }
    private void createGame(){
        turnDelay = 300;
        score = 0;
        isGameStopped = false;
        snake = new Snake(WIDTH/2,HEIGHT/2);
        setScore(score);
        setTurnTimer(turnDelay);
        createNewApple();
        drawScene();

    }
    @Override
    public void onTurn(int a){
        snake.move(apple);
        if(!snake.isAlive){
            gameOver();
        }
        if(snake.getLength()>GOAL){
            win();
        }
        if(!apple.isAlive){
            score+=5;
            setScore(score);
            turnDelay-=10;
            setTurnTimer(turnDelay);
            createNewApple();
        }
        drawScene();
    }
    @Override
    public void onKeyPress(Key key) {

        switch (key) {
           case LEFT:
               snake.setDirection(Direction.LEFT);
               break;
            case RIGHT:
                snake.setDirection(Direction.RIGHT);
                break;
            case UP:
                snake.setDirection(Direction.UP);
                break;
            case DOWN:
                snake.setDirection(Direction.DOWN);
                break;
            case SPACE:
                if(isGameStopped) {
                    createGame();
                }
                break;

        }

    }



    private void drawScene(){

        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                setCellValueEx(x, y, Color.DARKBLUE, "");
            }
        }

        snake.draw(this);
        apple.draw(this);
        setScore(score);
    }

    private void createNewApple(){
        boolean isOk = true;
        while(isOk) {
            apple = new Apple(getRandomNumber(WIDTH), getRandomNumber(HEIGHT));
            if(!snake.checkCollision(apple)){
                isOk=false;
            }
        }
    }

    private void gameOver(){
        isGameStopped = true;
        stopTurnTimer();
        showMessageDialog(Color.WHITE, "GAME OVER", Color.CORAL, 46);
    }
    private void win(){
        isGameStopped = true;
        stopTurnTimer();
        showMessageDialog(Color.WHITE, "YOU WIN", Color.CORAL, 46);
    }

}
