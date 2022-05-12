import java.util.concurrent.Semaphore;

public class Player extends Thread {
    private String playerName;
    private int playerNumber;
    private Ball ball;
    private Semaphore[] s ; // what if less semaphores passed!?

    public int getPlayerNumber(){return  playerNumber;}
    public String getPlayerName (){return playerName;}

    public Player(String playerName,int playerNumber, Ball ball, Semaphore[] s){
        this.playerName = playerName;
        this.playerNumber = playerNumber;
        this.s = s;
        this.ball = ball;
        start();
    }

    @Override
    public void run() {
        while(true){
            try{
                s[0].acquire();
                if(ball.getPlayerNum()!=playerNumber)
                {
                    ball.hit(this);
                   // sleep(1000);
                }
                s[0].release();
            }
            catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }

    }
}
