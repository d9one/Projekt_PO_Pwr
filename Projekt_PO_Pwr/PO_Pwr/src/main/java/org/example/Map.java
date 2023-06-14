package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.lang.invoke.WrongMethodTypeException;


public class Map {
    static File f;
    static FileWriter output;
    private static int WIDTH;
    private static int HEIGHT;
    final static int BuffCount=10;
    final static int StudentCount = 20;
    private static Cell[][] cells;
    private ArrayList<Integer> list;

    public Map(int x, int y) throws IOException {
        WIDTH= x;
        HEIGHT = y;
        cells = new Cell[x][y];
        list = new ArrayList<Integer>();
        initializeCells();
        f = new File("out.txt");
        output = new FileWriter(f);
    }
    public static void end() throws IOException
    {
        output.close();
    }
    private void initializeCells() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                cells[i][j] = new Cell(i*WIDTH+j);
            }
        }
        if(StudentCount<HEIGHT*WIDTH)
        {
            for(int i=0;i<StudentCount;)
            {
                Random random = new Random();
                int x = random.nextInt(WIDTH-1);
                int y = random.nextInt(HEIGHT-1);
                if(!cells[x][y].isStudent()) {
                    cells[x][y].genStudent();
                    i++;
                    list.add(x*WIDTH+y);
                }
            }
            /*cells[1][2].genStudent();
            cells[4][4].genStudent();
            list.add((1*WIDTH+2));
            list.add(4*WIDTH+4);*/
        }
        else
            throw new WrongMethodTypeException();
    }

    private boolean isInRange(int x, int y) {
        return x >=0 && x <WIDTH && y >=0 && y <HEIGHT;
    }

    public static void GraphicMap() throws IOException {
        for(int x=0;x<HEIGHT;x++)
        {
            String s = String.format("%2d:|", x+1);
            output.write(s);
            for(int y=0;y<WIDTH;y++)
            {
                output.write(cells[x][y].getSign());
            }
            output.write("|\n");
        }
        for(int i =0;i<WIDTH+5;i++)
        {
            output.write("-");
        }
        output.write("\n");
    }
    public void generateBuffs(){
        for(int i=0;i<BuffCount;i++)
        {
            Random random = new Random();
            int x = random.nextInt(WIDTH-1); int y = random.nextInt(HEIGHT-1);
            if(!cells[x][y].isBuff())
                cells[x][y].addBuff();
        }
    }
    public void moveStudents() {
        Random random = new Random();
        //System.out.print(list.size());
        ArrayList<Integer> Holder = new ArrayList<>();
        for(int ID:list)
        {
            int xMove = random.nextInt(2)-1; int yMove = random.nextInt(2)-1;

            int x = ID/WIDTH, y = ID%WIDTH;
//            System.out.println("PolPocz : "+ x+", " + y+ "  v:["+ xMove+", "+yMove+"]");
            if(xMove!=0 && yMove!=0){
                if(isInRange(x+xMove, y+yMove)) {
                    if(cells[x+xMove][y+yMove].isStudent())
                    {
                        cells[x][y].removeStudent();
                        Holder.add((x+xMove)*WIDTH+y+yMove);
                    }
                    else {
                        cells[x + xMove][y + yMove].moveStudent(cells[x][y]);
                        //list.remove(list.indexOf(x * WIDTH + y));
                        Holder.add((x + xMove) * WIDTH + y + yMove);
                    }
                }
                else{
                    cells[x][y].removeStudent();
                }
            }
            else
                Holder.add((x) * WIDTH + y);
        }
        list = Holder;
    }

}