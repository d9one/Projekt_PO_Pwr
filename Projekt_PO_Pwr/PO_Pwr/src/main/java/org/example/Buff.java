package org.example;

public abstract class Buff {
    public static int buff() {
        return 0;
    }

    public static int deBuff() {
        return 0;
    }


    public static void modify(Student student){};

    public static class Party extends Buff{
        public static int buff(){return 10;}
        public static int deBuff(){return -2;}

        public static void modify(Student student){
            student.setMotivation(student.getStatMotivation() + Buff.buff());
            student.setIntelligence(student.genIntelligence() + Buff.deBuff());
        }
    }
    public static class Library extends Buff{
        public static int buff(){return 5;}
        public static int deBuff(){return -2;}

        public static void modify(Student student){
            student.setIntelligence(student.getStatIntelligence() + Buff.buff());
            student.setMotivation(student.getStatMotivation() + Buff.deBuff());
        }
    }
    public static class Gym extends Buff{
        public static int buff(){return 5;}
        public  static int deBuff(){return 5;}

        public static void modify(Student student){
            student.setStrength(student.getStatStrength() + Buff.buff());
            student.setMotivation(student.getStatMotivation() + Buff.deBuff());
        }
    }
    public static class NULL extends Buff{
        public static int buff(){return 1;}
        public static int deBuff(){return -1;}
    }
}
