package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cell {
    int ID;
    public boolean isBuff(){if(buff instanceof Buff.NULL){return true;} return false;}
    public boolean isStudent(){if(student instanceof Student.NULL){return true;} return false;}
    private Student student;
    private Buff buff;
    private Student getStudent()
    {
        return this.student;
    }
    public char getSign(){
        if(isStudent())
        {
            if(isBuff())
                return ' ';
            else
            {
                if(this.buff instanceof Buff.Gym)
                    return 'G';
                else if (this.buff instanceof Buff.Library)
                    return 'L';
                else
                    return 'P';
            }
        }
        else
            return 'S';
    }
    private int getID(){
        return ID;
    }
    private void copyStudent(Student x){
        student.setIntelligence(x.getStatIntelligence());
        student.setMotivation(x.getStatMotivation());
        student.setStrength(x.getStatStrength());
    }
    public void fight(Cell x)
    {
        if(this.student.fight(x.getStudent()))

            copyStudent(x.getStudent());
        x.removeStudent();

    }
    public Cell(int ID){
        this.ID = ID;
        student = new Student.NULL();
        buff = new Buff.NULL();
    }
    public void removeStudent(){
        this.student= new Student.NULL();
    }
    public void genStudent(){
        this.student = new Student();
    }
    public void upgradeStudent(){
        if(this.buff instanceof Buff.Library){}
        else if(this.buff instanceof Buff.Gym){}
        else{}
        removeBuff();
    }
    public void moveStudent(Cell x){
        copyStudent(x.getStudent());
        x.removeStudent();
        if(isBuff())
            upgradeStudent();
    }
    public void addBuff(){
        switch (genRandom())
        {
            case 1:
                buff = new Buff.Gym();
                break;
            case 2:
                buff = new Buff.Party();
                break;
            case 3:
                buff = new Buff.Library();
        }
    }
    private int genRandom()
    {
        Random r = new Random();
        return r.nextInt(3);
    }
    public void removeBuff(){
        buff = new Buff.NULL();
    }
}