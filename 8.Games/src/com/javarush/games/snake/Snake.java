package com.javarush.games.snake;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Snake {

    private static final String HEAD_SIGN= "\uD83D\uDC7E";
    private static final String BODY_SIGN = "\u26AB";
    public  boolean isAlive = true;
    private Direction direction = Direction.LEFT;


    private List<GameObject> snakeParts = new ArrayList<>();

    public Snake(int x, int y){

        snakeParts.add(new GameObject(x,y));
        snakeParts.add(new GameObject(x+1,y));
        snakeParts.add(new GameObject(x+2,y));
    }

    public void draw(Game game){


        if(isAlive) {
            game.setCellValueEx(snakeParts.get(0).x,snakeParts.get(0).y,Color.NONE,HEAD_SIGN,Color.GREEN,75);
            for (int i = 1; i < snakeParts.size(); i++) {
                game.setCellValueEx(snakeParts.get(i).x,snakeParts.get(i).y,Color.NONE,BODY_SIGN,Color.GREEN,75);
            }
        }else{
            game.setCellValueEx(snakeParts.get(0).x,snakeParts.get(0).y,Color.NONE,HEAD_SIGN,Color.RED,75);
            for (int i = 1; i < snakeParts.size(); i++) {
                game.setCellValueEx(snakeParts.get(i).x,snakeParts.get(i).y,Color.NONE,BODY_SIGN,Color.RED,75);
            }
        }

    }

    public void setDirection(Direction di) {
        if ((di == Direction.RIGHT && direction != Direction.LEFT) ||
                (di == Direction.LEFT && direction != Direction.RIGHT) ||
                (di == Direction.UP && direction != Direction.DOWN) ||
                (di == Direction.DOWN && direction != Direction.UP)
        ) {

            if (this.direction == Direction.LEFT && snakeParts.get(0).x == snakeParts.get(1).x) {
            } else if(this.direction == Direction.RIGHT && snakeParts.get(0).x == snakeParts.get(1).x){
            }else if(this.direction == Direction.UP && snakeParts.get(0).y == snakeParts.get(1).y){
            }else if(this.direction == Direction.DOWN && snakeParts.get(0).y == snakeParts.get(1).y){
            }else {
                direction = di;

            }
        }
    }

    public void move(Apple apple){
        GameObject head = createNewHead();
            if (checkCollision(head)) {
                this.isAlive = false;
                return;
            }
            if (head.x >= 0 && head.x < SnakeGame.HEIGHT && head.y >= 0 && head.y < SnakeGame.WIDTH) {
                snakeParts.add(0, head);
                if (head.x == apple.x && head.y == apple.y) {
                    apple.isAlive = false;
                } else {
                    removeTail();
                }

            } else {
                this.isAlive = false;
            }
    }

    public GameObject createNewHead (){

        int x = snakeParts.get(0).x;
        int y = snakeParts.get(0).y;
        GameObject head = null;
        switch (direction){
            case UP:
                head = new GameObject(x,y-1);
                break;
            case DOWN:
                head = new GameObject(x,y+1);
                break;
            case LEFT:
                head = new GameObject(x-1,y);
                break;
            case RIGHT:
                head = new GameObject(x+1,y);
                break;
        }
        return head;
    }

    public void removeTail(){
        snakeParts.remove(snakeParts.size()-1);
    }

    public boolean checkCollision(GameObject gameObject){
        for(int i=0; i<snakeParts.size();i++){
            if(snakeParts.get(i).x == gameObject.x && snakeParts.get(i).y == gameObject.y){
                return true;
            }
        }
        return false;
    }


    public int getLength() {
        return snakeParts.size();
    }

}
