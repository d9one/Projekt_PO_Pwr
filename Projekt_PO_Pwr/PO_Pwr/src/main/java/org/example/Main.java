package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        Map map = new Map(10, 10);
        for(int i=0;i<5;i++)
        {
            map.generateBuffs();
            map.GraphicMap();
            map.moveStudents();
            map.GraphicMap();
        }
        map.end();
    }
}