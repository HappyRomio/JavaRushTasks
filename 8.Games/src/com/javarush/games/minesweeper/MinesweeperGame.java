package com.javarush.games.minesweeper;
import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class MinesweeperGame extends Game {
    private static final int SIDE = 9;
    private static final String MINE = "\uD83D\uDCA3";
    private static final String FLAG = "\uD83D\uDEA9";

    private GameObject[][] gameField = new GameObject[9][9];

    private int countMinesOnField;
    private int countClosedTiles=SIDE*SIDE;
    private int countFlags;
    private int score;
    private boolean isGameStopped;

    public void initialize() {
        setScreenSize(SIDE,SIDE);
        createGame();

    }

    private void restart() {
        countMinesOnField = 0;
        countClosedTiles = SIDE*SIDE;
        countFlags = 0;
        score = 0;
        setScore(score);
        gameField = new GameObject[9][9];
        isGameStopped= false;
        createGame();
    }
    private void createGame() {
        for(int i = 0; i < SIDE; i++) {
            for(int j =0; j < SIDE; j++) {
                gameField[j][i] = new GameObject(i, j, (getRandomNumber(10) == 1 ? true : false));
                if (gameField[j][i].isMine) {
                    countMinesOnField++;
                }
                setCellColor(i, j, Color.ORANGE);
                setCellValue(i, j, "");
            }
        }
        countFlags = countMinesOnField;
        countMineNeighbors();

    }

    private void countMineNeighbors() {

        for(int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                if (!gameField[j][i].isMine) {
                    int count = 0;
                    for(GameObject cell : getNeighbors(gameField[j][i]) ){
                        if(cell != null && cell.isMine) {
                            count++;
                        }
                    }
                    gameField[j][i].countMineNeighbors = count;
                }
            }
        }

    }

    private List<GameObject> getNeighbors(GameObject targetCell) {
        int x = targetCell.x - 1;
        int y = targetCell.y - 1;
        List<GameObject> neighbors = new ArrayList<>();

        if (x >= 0 && x < SIDE && y >= 0 && y < SIDE) {
            neighbors.add( gameField[y][x]);
        }
        x = x + 1;
        if (x >= 0 && x < SIDE && y >= 0 && y < SIDE) {
            neighbors.add( gameField[y][x]);
        }
        x = x + 1;
        if (x >= 0 && x < SIDE && y >= 0 && y < SIDE) {
            neighbors.add( gameField[y][x]);
        }
        y = y + 1;
        if (x >= 0 && x < SIDE && y >= 0 && y < SIDE) {
            neighbors.add(  gameField[y][x]);
        }
        y = y + 1;
        if (x >= 0 && x < SIDE && y >= 0 && y < SIDE) {
            neighbors.add(  gameField[y][x]);
        }
        x = x - 1;
        if (x >= 0 && x < SIDE && y >= 0 && y < SIDE) {
            neighbors.add( gameField[y][x]);
        }
        x = x - 1;
        if (x >= 0 && x < SIDE && y >= 0 && y < SIDE) {
            neighbors.add( gameField[y][x]);
        }
        y = y - 1;
        if (x >= 0 && x < SIDE && y >= 0 && y < SIDE) {
            neighbors.add(gameField[y][x]);
        }
        y = y - 1;

        return neighbors;
    }

    private void openTile(int x, int y) {

        if (gameField[y][x].isOpen || gameField[y][x].isFlag || isGameStopped){ return;}
        gameField[y][x].isOpen = true;
        countClosedTiles--;
        if(gameField[y][x].isMine){
            setCellValueEx(x, y, Color.RED, MINE);
            gameOver();
            return;
        } else {
            score+=5;
            setScore(score);
            if (gameField[y][x].countMineNeighbors != 0) {
                setCellNumber(x, y, gameField[y][x].countMineNeighbors);
                setCellColor(x, y, Color.GREEN);
            }  else {
                setCellColor(x, y, Color.GREEN);
                setCellValue(x, y, "");

                for (GameObject n : getNeighbors(gameField[y][x])) {
                    openTile(n.x, n.y);
                }
            }
        }
        if(countClosedTiles == countMinesOnField) {
            win();
        }else {

        }


    }

    private void markTile(int x , int y){
        if(!isGameStopped) {
            if (!gameField[y][x].isOpen) {
                if (countFlags != 0) {
                    if (!gameField[y][x].isFlag) {
                        System.out.println(countFlags);
                        countFlags--;
                        gameField[y][x].isFlag = true;
                        setCellColor(x, y, Color.YELLOW);
                        setCellValue(x, y, FLAG);
                    } else {
                        countFlags++;
                        gameField[y][x].isFlag = false;
                        setCellColor(x, y, Color.ORANGE);
                        setCellValue(x, y, "");
                    }

                } else if (gameField[y][x].isFlag) {
                    countFlags++;
                    gameField[y][x].isFlag = false;
                    setCellColor(x, y, Color.ORANGE);
                    setCellValue(x, y, "");
                }
            }
        }
    }

    private void win(){
        isGameStopped = true;
        showMessageDialog(Color.BLACK," You WIN !!!!",Color.WHITE, 30);
    }

    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.RED," Game Over",Color.BLACK, 30);
    }

    public void onMouseRightClick(int x, int y) {

        markTile(x,y);
    }
    public void onMouseLeftClick(int x, int y) {
        if(!isGameStopped) {
            openTile(x, y);
        }else{
            restart();
        }
    }
}
