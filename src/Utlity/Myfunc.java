package Utlity;

public class Myfunc {
    public static void Wait(int wait){
        try {
            Thread.sleep(wait*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static int RandomSayıVer(int min,int max){
        return (int)(Math.random()*(max-min))+min;
    }
    public static int RandomSayıVer(int max){
        return (int)(Math.random()*max);
    }
}