import java.util.concurrent.Semaphore;

public class Player extends Thread {
    private String playerName;
    private Ball ball;
    private boolean run = true;
    private Semaphore in ;
    private Semaphore out;

    public synchronized void stopRunning(){
        run = false;
    }
	
	public synchronized boolean shouldRunning(){
		return run;
	}

    public String getPlayerName (){
		return playerName;
	}

    public Player(String playerName, Ball ball, Semaphore in, Semaphore out){
        this.playerName = playerName;
        this.in = in;
        this.out = out;
        this.ball = ball;
        start();
    }

    @Override
    public void run() {
        while(shouldRunning()){
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
