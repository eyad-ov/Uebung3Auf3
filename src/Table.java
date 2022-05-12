import java.util.concurrent.Semaphore;

public class Table {
    public static void main(String[] args){
        Ball ball = new Ball();
        Semaphore[] s = new Semaphore[2];
        s[0] = new Semaphore(1);
        s[1] = new Semaphore(1);
        Player tom = new Player("Tom",1, ball,s);
        Player jerry = new Player("Jerry",2,ball,s);
    }
}
