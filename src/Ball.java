public class Ball {
    int var = 1;
    public void hit(Player player){
        System.out.print(var==1?"Ping! ":"Pong! ");
        System.out.println(player.getPlayerName());
        var *= -1;

    }
}