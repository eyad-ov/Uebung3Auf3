import java.util.concurrent.Semaphore;

public class Player extends Thread {
    private String playerName;
    private Ball ball;
    private boolean alive = true;
    private Semaphore in ;
    private Semaphore out;

    public void stopRunning(){ //synchronized!?
        alive = false;
    }

    public String getPlayerName (){return playerName;}

    public Player(String playerName, Ball ball, Semaphore in, Semaphore out){
        this.playerName = playerName;
        this.in = in;
        this.out = out;
        this.ball = ball;
        start();
    }

    @Override
    public void run() {
        while(alive){
            try{
                in.acquire();
                ball.hit(this);
                sleep(1000);
                out.release();
            }
            catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }

    }
}
