 import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class mapgenerator {
    
    public int map[][];
    public int brickwidth;
    public int brickheight;
    public mapgenerator(int row,int col){
        map=new int[row][col];
        
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++){
                map[i][j]=1;//not intercesected with the ball
            }
        }
        brickwidth=540/col;
        brickheight=150/row;

    }
    public void draw(Graphics g){

        Graphics2D g1=(Graphics2D)g;
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++){
               
            if(map[i][j]>0){
                g1.setColor(Color.white);
                g1.fillRect(j*brickwidth+80,i*brickheight+50,brickwidth,brickheight);

                g1.setStroke(new BasicStroke(4));
                
                g1.setColor(Color.black);
                g1.drawRect(j*brickwidth+80,i*brickheight+50,brickwidth,brickheight);

            }
        }
    }
    

    
}
public void setbrickvalue(int value,int row,int col){
    map[row][col]=value;
}
}
