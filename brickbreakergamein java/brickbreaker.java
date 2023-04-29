

import javax.swing.JButton;
import javax.swing.JFrame;

public class brickbreaker extends JFrame{
    
    
    brickbreaker(String name){

        String n=name;
       
        Gameplay g=new Gameplay(n);
       

        setBounds(10, 10, 710, 600);
        setTitle("Brick Breaker Game");
        setResizable(false);//you caant maxmize
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        add(g);
    }
    public static void main(String[] args) {
        //JFrame obj=new JFrame();//creating a frame
        

    }
}
