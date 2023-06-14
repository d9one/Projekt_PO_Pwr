package org.example;
import java.util.Random;

public class Student extends Object{
    private int intelligence;
    private int strength;
    private int motivation;

    public Student(){
        this.intelligence = genIntelligence();
        this.strength = genStrength();
        this.motivation = genMotivation();
    }
    public Student(Student s)
    {
        intelligence = s.intelligence;
        strength = s.strength;
        motivation = s.motivation;
    }
    public  int genIntelligence(){
        Random liczba = new Random();
        return intelligence = liczba.nextInt(11) +10;
    }
    public int genStrength(){
        Random liczba = new Random();
        return strength = liczba.nextInt(31) + 20;
    }
    public int genMotivation(){
        Random liczba = new Random();
        return motivation = liczba.nextInt(21) + 80;
    }

    public int getStatIntelligence() {
        return this.intelligence;
    }
    public int getStatStrength(){
        return this.strength;
    }
    public int getStatMotivation(){
        return this.motivation;
    }

    public static class NULL extends Student{
        NULL(){
        };

    }
    private int getRandom()
    {
        Random r = new Random();
        return r.nextInt(2)+1;
    }
    public  int setIntelligence(int x){
        return intelligence = x ;
    }
    public int setStrength(int x){
        return strength = x ;
    }
    public int setMotivation(int x){
        return motivation = x ;
    }
    public boolean fight(Student x)
    {
        switch (getRandom()) {
            case 1:
                return this.intelligence<x.getStatIntelligence();
            case 2:
                return this.strength<x.getStatStrength();
            case 3:
                return this.motivation<x.getStatMotivation();
        }
        return false;
    }
}
