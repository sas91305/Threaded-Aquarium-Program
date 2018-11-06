/*
 * This class allows you to create a fish object by supplying the polygon
cordinates along with the JFrame it will be located in and the Thread sleep time.
This class also Implements Runnable so it needs to contain the method run().
 */
package aquarium;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class Fish extends JComponent implements Runnable
{
    private JFrame j;
    private String color;
    private int x;
    private int y;
    private int wait; //sleep time
    private boolean back = false;
    
    //explicit constructor
    public Fish(int x, int y, JFrame j, String color, int wait)
    {
        this.j=j;
        this.color=color;
        this.x=x;
        this.y=y;
        this.wait=wait;
    }
    
    /**createFish method creates the fish depending on the way it is swimming
     * using the graphics2D class. Also uses the drawPolygon and fillPolygon
     * method to draw and color the fish. The boolean back is used to determine
     * what happens when the fish hits the wall.
     * 
     * Attempted to use Graphics2D in the parameters but would not work unless
     * it is Graphics
     *
     * @param g which is the graphics class that is used
     */
    public void paintComponent(Graphics g)
    {
        Graphics2D g1 = (Graphics2D)g;
        
        if(back == true)
        {
            //x cordinates for fish swimming right
            int[] x1 = new int[]{x, x-25, x-75, x-175, x-75, x-25, x};
            //y cordinates for fish swimming left
            int[] y1 = new int[]{y, y+25, y+10, y+45, y+65, y+50, y+75};
            fishColor(g1);
            g1.drawPolygon(x1, y1, x1.length);
            g1.fillPolygon(x1, y1, x1.length);
        }
        
        else
        {
            //x cordinates for fish swimming left
            int[] x1 = new int[]{x, x+25, x+75, x+175, x+75, x+25, x};
            //x cordinates for fish swimming right
            int[] y1 = new int[]{y, y+25, y+10, y+45, y+65, y+50, y+75};
            fishColor(g1);
            g1.drawPolygon(x1, y1, x1.length);
            g1.fillPolygon(x1, y1, x1.length);

        }
        
    }
    
    /**setfishColor method sets the color of the graphic depending on the color
     * that is provided when creating the fish
     * 
     * There are more color possibilities but I only used orange and red.
     *
     * @param g which is the graphics class that is used
     */
    public void fishColor(Graphics2D g)
    {
        if(color.equals("yellow"))
            g.setColor(Color.yellow);
        if(color.equals("red"))
            g.setColor(Color.red);
        if(color.equals("blue"))
            g.setColor(Color.blue);
        if(color.equals("orange"))
            g.setColor(Color.orange);
        if(color.equals("green"))
            g.setColor(Color.green);
    }
    
    /**run method is used since the class implements runnable. This method first
     * checks to see if the JFrame has been created then checks to see what
     * direction the fish should be going by changing the x and y
     * when the fish reaches each wall.
     */
    public void run()
    {
        try
        {
            while(j.isEnabled())
            {
                while((x+100) < j.getWidth())
                {
                    back=false;
                    x+=20;
                    repaint();
                    Thread.sleep(wait);
                }
                while((x-100) > 0)
                {
                    back=true;
                    x-=20;
                    repaint();
                    Thread.sleep(wait);
                }
            }
        }
        catch(InterruptedException e)
        {
            e.printStackTrace(); //if it does not work it will print out information on why it didn't
        }
    }
}
