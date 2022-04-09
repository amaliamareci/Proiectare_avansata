import java.util.ArrayList;
import java.util.List;

/**
 * Game class having a bag ,a board and a list of players
 */
public class Game {
    private final Bag bag = new Bag();
    private final Board board = new Board();
    private final Dictionary dictionary = new Dictionary();
    private final List<Player> players = new ArrayList<>();

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

    public static void main(String args[]) {
        Game game = new Game();
        game.addPlayer(new Player("Player 1"));
        game.addPlayer(new Player("Player 2"));
        game.addPlayer(new Player("Player 3"));
        game.play();
    }

}
