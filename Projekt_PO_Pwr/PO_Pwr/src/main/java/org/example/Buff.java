package org.example;

public abstract class Buff {
    public abstract int buff();
    public abstract int deBuff();
    public static class Party extends Buff{
        public int buff(){return 10;}
        public int deBuff(){return -2;}
    }
    public static class Library extends Buff{
        public int buff(){return 5;}
        public int deBuff(){return -2;}
    }
    public static class Gym extends Buff{
        public int buff(){return 5;}
        public int deBuff(){return 5;}
    }
    public static class NULL extends Buff{
        public int buff(){return 1;}
        public int deBuff(){return -1;}
    }
}
