import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
//import java.util.Timer;
import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
//import javax.swing.JFrame;
import javax.swing.JPanel;

public class Gameplay extends JPanel implements KeyListener,ActionListener {
  //what is jpanel
   
  private boolean play=false;
  public int score=0;
  private int totalbrick=21;
  
  
  private Timer timer;
  private Timer s;
  private int delay=0;
  public int second=0;
  public String xx;

  private int playerx=310;
  private int EXIT=0;

  private int ballposX=120;
  private int ballposY=350;
  private int ballxdir=-1;
  private int ballydir=-2;
  
  private mapgenerator map;


  JButton b1;
  Gameplay(String sname){
    xx=sname;
    map=new mapgenerator(3,7);
    addKeyListener(this);
    setFocusable(true);
    setFocusTraversalKeysEnabled(false);


    
    b1=new JButton("EXIT");
    b1.setForeground(Color.WHITE);
    b1.setBackground(Color.BLUE);
    b1.setBounds(10,10,100,100);
   
    setLayout(null);
    add(b1);
    timer=new Timer(delay,this);

    showtimer();
    s.start();

    
    
    timer.start();
    
    
    

    
  }
 
  public void showtimer(){
        s=new Timer(1000,new ActionListener() {
        public void actionPerformed(ActionEvent e){

            second++;
        }
    });
  }
 
  

  
  
  public void paint(Graphics g1){
    //background 
   
    g1.setColor(Color.BLACK);
    g1.fillRect(1,1,692,582);
    
    


    //drawing map
    map.draw((Graphics2D)g1);
    //borders
    g1.setColor(Color.red);
    g1.fillRect(0,0,3,592);
    g1.fillRect(0,0,692,3);
    g1.fillRect(691,0,3,592);
    

    //timer 
    g1.setColor(Color.white);
    
    g1.setFont(new Font("serif", Font.BOLD, 20));

    g1.drawString("USER: "+xx,20,30);
    g1.setColor(Color.yellow);
    
    g1.setFont(new Font("serif", Font.BOLD, 25));

    g1.drawString("Timer ⏱ "+second,400,30);
    
    
    

    //score
    g1.setColor(Color.white);
    
    g1.setFont(new Font("serif", Font.BOLD, 25));

    g1.drawString("Score "+score,540,30);

    //the padel
    g1.setColor(Color.green);
    g1.fillRect(playerx,550,100,8);
    


    //the ball
    g1.setColor(Color.yellow);
   
    g1.fillOval(ballposX, ballposY,20,20); 

    if(totalbrick<=0){
        play=false;
        ballxdir=0;
        ballydir=0;
        g1.setColor(Color.red);
        g1.setFont(new Font("Verdana", Font.BOLD, 20));

        g1.drawString("YOU WIN ",260,300);
        g1.setFont(new Font("Verdana", Font.BOLD, 15));
       
        
        s.stop();

        g1.drawString("Press enter to restart ",230,350);
        g1.drawString("Press space to Exit ",230,370);
    }
    if(ballposY>570){
        play=false;
        ballxdir=0;
        ballydir=0;
        
        g1.setColor(Color.red);
        g1.setFont(new Font("Verdana", Font.BOLD, 20));

        g1.drawString(" Game over,your score is "+score,190,300);
        g1.setColor(Color.white);
        g1.setFont(new Font("Verdana", Font.BOLD, 20));

        s.stop();

        g1.drawString(" Press enter to restart ",210,350);
        g1.drawString(" Press Space to Exit ",210,380);

        


    }
    
    
    g1.dispose();
  }

    @Override
    public void actionPerformed(ActionEvent e) {
       //timer.start();
      
       if(play){
        if(new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(playerx,550,100,8))){
            ballydir=-ballydir;
        }

        A:for(int i=0;i<map.map.length;i++){
            for(int j=0;j<map.map[0].length;j++){
                if(map.map[i][j]>0){
                    int brickx=j*map.brickwidth+80;
                    int bricky=i*map.brickheight+50;
                    int brickwidth=map.brickwidth;
                    int brickheight=map.brickheight;
                    Rectangle rect=new Rectangle(brickx, bricky, brickwidth, brickheight);
                    Rectangle ballRectangle=new Rectangle(ballposX,ballposY, 20, 20);
                    Rectangle briRectangle=rect;
                    if(ballRectangle.intersects(briRectangle)){

                        map.setbrickvalue(0,i,j);
                        totalbrick--;
                        score+=2;
                        
                        
                        if(ballposX+19<=briRectangle.x||ballposX+1>=briRectangle.x+briRectangle.width){
                            ballxdir=-ballxdir;
                        }
                        else{
                            ballydir=-ballydir;
                        }
                        break A;
                    }
                }
            }
        }

        ballposX+=ballxdir;
        ballposY+=ballydir;
        if(ballposX<0){
            ballxdir=-ballxdir;
        }
        if(ballposY<0){
            ballydir=-ballydir;
        }
        if(ballposX>670){
            ballxdir=-ballxdir;
        }

       }
       repaint();//recall paint method and draw it again 
    }

    @Override
    public void keyTyped(KeyEvent e) {
     
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){

            if(playerx>=600){
                playerx=600;
            }
            else{
                moveright();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){

            if(playerx<10){
                playerx=10;
            }
            else{
                moveleft();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            if(!play){
                play=true;
                ballposX=120;
                ballposY=350;
                ballxdir=-1;

                ballydir=-2;
                playerx=310;
                score=0;
                second=0;
                s.start();
                totalbrick=21;
                map=new mapgenerator(3,7);
                repaint();

            }
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            
            play=false;
        
            System.exit(0);
            setVisible(false);
            
            
        }

    }
    
    public void moveright(){
        play=true;//
        playerx+=20;//if presed right move 20 px right

    }
    public void moveleft(){
        play=true;//
        playerx-=20;//if presed right move 20 px right
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
 public static void main(String[] args) {
    Gameplay game=new Gameplay();
    

  

 }  
  

}
