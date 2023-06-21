package org.example;

public abstract class Buff {
    public static int buff() {
        return 0;
    }

    public static int deBuff() {
        return 0;
    }

    public static class Party extends Buff{
        public static int buff(){return 10;}
        public static int deBuff(){return -2;}
    }
    public static class Library extends Buff{
        public static int buff(){return 5;}
        public static int deBuff(){return -2;}
    }
    public static class Gym extends Buff{
        public static int buff(){return 5;}
        public  static int deBuff(){return 5;}
    }
    public static class NULL extends Buff{
        public static int buff(){return 1;}
        public static int deBuff(){return -1;}
    }
}
