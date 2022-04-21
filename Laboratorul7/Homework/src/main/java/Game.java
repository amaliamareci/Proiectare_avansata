import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Game class having a bag ,a board and a list of players
 */
public class Game {
    private final Bag bag = new Bag();
    private final Board board = new Board();
    private final Dictionary dictionary = new Dictionary();
    static private final List<Player> players = new ArrayList<>();

    public Bag getBag() {
        return bag;
    }

    public Board getBoard() {
        return board;
    }

    public Dictionary getDictionary() {
        return dictionary;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        players.add(player);
        player.setGame(this);
    }

    /**
     * starting a thread for each player
     */
    public void play() {
        List<Thread> threads = new ArrayList<>();
        for (Player player : players) {
            //start a new Thread representing the player;
            threads.add(new Thread(player));
        }

        threads.forEach(Thread::start);


    }

    /**
     * checks who had the biggest number of points
     */
    public static void getWinner() {
        int max = -1;
        Player winner = null;
        for (Player player : players)
            if (player.score > max) {
                max = player.score;
                winner = player;
            }
        assert winner != null;
        System.out.println("The winner is :" + winner.getName() + " get score : " + winner.score);
    }

    public static void main(String args[]) {
        Game game = new Game();
        game.addPlayer(new Player("Player 1"));
        game.addPlayer(new Player("Player 2"));
        game.addPlayer(new Player("Player 3"));

        Timer timer = new Timer(game, 3);
        Thread timerThread = new Thread(timer);
        timerThread.setDaemon(true);
        timerThread.start();
        game.play();
        //t1.start();

        for (Player player : players)
            while (player.isRunning()) {
            }

        timer.getTime();
        getWinner();


    }

}
