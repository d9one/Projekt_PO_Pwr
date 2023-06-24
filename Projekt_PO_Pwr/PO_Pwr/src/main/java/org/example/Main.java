package org.example;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;




public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("podaj wysokosc mapy");
        Scanner scx = new Scanner(System.in);
        int x = scx.nextInt();
        System.out.println("podaj szerokosc mapy");
        Scanner scy = new Scanner(System.in);
        int y = scy.nextInt();
        Map map = new Map(x, y);
        map.generateBuffs();
        System.out.println("podaj dlugosc semestru");
        Scanner sctime = new Scanner(System.in);
        int time = sctime.nextInt();
        for(int i=0;i<time;i++)
        {
            map.moveStudents();
            map.GraphicMap();
        }
        map.end();
    }
}