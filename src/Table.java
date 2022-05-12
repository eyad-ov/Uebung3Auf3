import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Table {
    public static void main(String[] args){
        Ball ball = new Ball();
        Semaphore s1 = new Semaphore(1);
        Semaphore s2 = new Semaphore(0);

        System.out.println("Press Enter to stop the game");
        Player tom = new Player("Tom",ball,s1,s2);
        Player jerry = new Player("Jerry",ball,s2,s1);

        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        tom.stopRunning();
        jerry.stopRunning();
        sc.close();
    }
}
