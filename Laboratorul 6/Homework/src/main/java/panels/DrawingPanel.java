package panels;
import frame.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.*;
import java.util.logging.Logger;

/**
 * The drawing panel where the game board and logistics are implemented
 */
public class DrawingPanel extends JPanel implements MouseListener {
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private final MainFrame frame;
    private int rows, cols;
    private int canvasWidth, canvasHeight;
    private int boardWidth, boardHeight;
    private int cellWidth, cellHeight;
    private int padX, padY; // padX represents the right and left padding and
    // padY represents the top and left padding for the canvas
    private final static int stoneSize = 20;
    private final Map<String, String> sticks =new HashMap<String,String>();
    private int first=0;
    private String last="";
    private int round;

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        addMouseListener(this);
        init(frame.configPanel.getRows(), frame.configPanel.getCols());
    }

    final void init(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        canvasWidth = cols * 60;
        canvasHeight = rows * 60;
        this.padX = stoneSize + 10;
        this.padY = stoneSize + 10;
        this.cellWidth = (canvasWidth - 2 * padX) / (cols - 1);
        this.cellHeight = (canvasHeight - 2 * padY) / (rows - 1);
        this.boardWidth = (cols - 1) * cellWidth;
        this.boardHeight = (rows - 1) * cellHeight;
        setPreferredSize(new Dimension(canvasWidth, canvasHeight));
    }

    /**
     * Used for creating the main grid
     */
    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, canvasWidth, canvasHeight);
        paintGrid(g);
        paintSticks(g);
    }

    /**
     * creates the lines and nodes for the main grid
     */
    private void paintGrid(Graphics2D g) {
        g.setColor(Color.DARK_GRAY);
        //horizontal lines
        for (int row = 0; row < rows; row++) {
            int x1 = padX;
            int y1 = padY + row * cellHeight;
            int x2 = padX + boardWidth;
            int y2 = y1;
            g.drawLine(x1, y1, x2, y2);
        }
        //vertical lines
        for (int col = 0; col < cols; col++) {
            int x1 = padX + col * cellWidth;
            int y1 = padY;
            int x2 = x1;
            int y2 = padY + boardHeight;
            g.drawLine(x1, y1, x2, y2);
        }
        //intersections
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int x = padX + col * cellWidth;
                int y = padY + row * cellHeight;
                g.setColor(Color.LIGHT_GRAY);
                g.drawOval(x - stoneSize / 2, y - stoneSize / 2, stoneSize, stoneSize);
            }
        }
    }


    /**
     * draws a stone at coordinates x, y, on the canvas using the color "color"
     */
    void drawStone(Graphics2D g, int x, int y, Color color) {
        //int i = padX + x * cellWidth;
        //int j = padY + y * cellHeight;
        first++;
        if(first==1){
            round=1;
            last= String.valueOf(x+stoneSize/2)+String.valueOf(y+stoneSize/2);
            g.setColor(color);
            g.fillOval(x, y, stoneSize, stoneSize);}
        else
        {
            String find =String.valueOf(x+stoneSize/2)+String.valueOf(y+stoneSize/2);
            if(sticks.containsKey(find)&&(sticks.get(last).toString().contains(find)))
            {g.setColor(color);
                g.fillOval(x, y, stoneSize, stoneSize);
                last=String.valueOf(x+stoneSize/2)+String.valueOf(y+stoneSize/2);
                round++;
                if(noMoreOptions(find))
                {
                    if (round%2==0) {
                        LOGGER.info("the winner is blue");
                    } else {
                        LOGGER.info("the winner is red");
                    }
                }
            }
        }
    }

    /**
     * Function for painting random sticks on the grid
     */
    private void paintSticks(Graphics2D g) {
        double prob = 0.7;
        Random rand = new Random();
        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(5));
        for (int row = 0; row < this.rows; row++) {
            for (int col = 0; col < this.cols; col++) {
                for (int dx = 0; dx <= 1; dx++) {
                    for (int dy = 0; dy <= 1; dy++) {
                        if ((dx == dy)
                                || (row + dy >= rows)
                                || (col + dx >= cols)) {
                            continue;
                        }
                        if (rand.nextDouble() < prob) {
                            int x1 = padX + col * cellWidth;
                            int y1 = padY + row * cellHeight;
                            int x2 = x1 + dx * cellWidth;
                            int y2 = y1 + dy * cellHeight;
                            g.drawLine(x1, y1, x2, y2);
                            String first = String.valueOf(x1)+String.valueOf(y1);
                            String second = String.valueOf(x2)+String.valueOf(y2);
                            if(sticks.get(first)==null)
                                sticks.put(first, second);
                                //sticks.put(second, first);}
                            else{
                                String get=sticks.get(first).toString();
                                get+=" "+second;
                                sticks.put(first,get);

                            }
                            if(sticks.get(second)==null){
                                sticks.put(second, first);
                            }
                            else{
                                String get2=sticks.get(second).toString();
                                get2+=" "+first;
                                sticks.put(second,first);
                            }
                        }
                    }
                }
            }
        }

    }

    public void mouseClicked(MouseEvent e) {
        Graphics2D g = (Graphics2D) getGraphics();

        int row = e.getX() / cellWidth;
        int col = e.getY() / cellHeight;

        // center stone coordinates: padX + row * cellWidth, padY + col * cellHeight

        int x = padX + row * cellWidth - stoneSize / 2;
        int y = padY + col * cellHeight - stoneSize / 2;

        // check if the mouse is within a circle
        if (e.getX() >= x && e.getX() <= x + stoneSize
                && e.getY() >= y && e.getY() <= y + stoneSize) {
            Color color = Color.blue;
            if (round%2==0) {
                color = Color.red;
            } else {
                color=Color.blue;
            }

            drawStone(g, x, y, color);

        }

    }

    public void mouseEntered(MouseEvent e) {
    }


    /**
     * function for making ss of the current game
     */
    public void getImage() {
        Dimension d = new Dimension(this.getWidth(), this.getHeight());
        Point i=this.getLocationOnScreen();
        BufferedImage image;
        File file=new File("save.png");
        try {
            image = new Robot().createScreenCapture(new Rectangle(i, d));
            ImageIO.write(image, "PNG", file);
        } catch (Exception e) {
            LOGGER.warning("Write Exception");
            e.printStackTrace();
        }

    }

    /**
     * Checks if after the find coordinates aren't any options
     * @return true -if the next player doesn't have any option
     * false-otherwise
     */
    public boolean noMoreOptions(String find )
    {
        if(!sticks.get(last).toString().contains(" "))
            return true;
        else
            return false;
    }
    public void mouseExited(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }
}