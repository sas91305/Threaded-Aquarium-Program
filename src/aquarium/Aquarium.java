/*
 * This prgram allows you to create a JFrame or fishtank to store Fish objects
in. You will need to prvide the necessary parameters needed to create the fish
as well as create your JFrame in which you will store them in.
 */
package aquarium;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;

public class Aquarium 
{

    public static void main(String[] args) 
    {
        //Create JFrame to place fish in
        JFrame jf=new JFrame();
        jf.setTitle("Aquarium - Prject #5");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(10000, 1000);
        jf.getContentPane().setBackground(Color.BLUE);
        jf.setVisible(true);
        jf.setLayout(new GridLayout(3,0));
        

        //Create fish to place in JFrame
        Fish f1=new Fish(1000, 10 ,jf, "orange" ,150);
        Fish f2=new Fish(10, 10, jf, "red" ,50);
        Fish f3=new Fish(500, 10, jf, "green", 75);
        
        
        //Adds fish to JFrame
        jf.add(f1);
        jf.add(f2);
        jf.add(f3);
        
        //Creates Thread
        Thread t1=new Thread(f1);
        Thread t2=new Thread(f2);
        Thread t3=new Thread(f3);

        t1.start();
        t2.start();
        t3.start();
        
        
        
        
    }
    
}
