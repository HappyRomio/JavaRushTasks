package com.javarush.task.task21.task2101;

/* 
Определяем адрес сети
*/
public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[] net = new byte[4];
        net[0] = (byte) (ip[0]&mask[0]);
                net[1] =(byte)(ip[1]&mask[1]);
                        net[2] =(byte)(ip[2]&mask[2]);
                                net[3] =(byte)(ip[3]&mask[3]);

        return net;
    }

    public static void print(byte[] bytes) {
        byte[] result = new byte[32];
        int size = 31;
        for(int j = 3; j >=0; j--) {
            byte cur = bytes[j];
            for (int i = 0; i < 8; i++) {
                result[size] = (byte)(cur & 1);
                cur = (byte) (cur >> 1);
                size--;
            }
        }
        for(int i = 0 ; i <result.length; i ++){

            System.out.print(result[i]);
            if(i==7 || i==15 || i == 23){
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
