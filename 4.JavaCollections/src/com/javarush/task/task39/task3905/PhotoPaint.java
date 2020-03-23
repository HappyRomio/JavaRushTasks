package com.javarush.task.task39.task3905;

public class PhotoPaint {
    public boolean paintFill(Color[][] image, int x, int y, Color desiredColor) {
        if(image == null){
            return false;
        }
        if( x < 0 || x >=image[0].length){
            return false;
        }
        if( y < 0 || y >=image.length){
            return false;
        }

        if(image[y][x].equals(desiredColor)){
            return  false;
        }


                image[y][x] = desiredColor;

        return true;
    }
}
