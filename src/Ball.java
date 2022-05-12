public class Ball {
    private int playerNum;
    int var = 1;
    public int getPlayerNum(){return playerNum;}
    public void hit(Player player){

        System.out.print(var==1?"Ping! ":"Pong! ");
        System.out.println(player.getPlayerName());
        playerNum = player.getPlayerNumber();
        var *= -1;

    }
}