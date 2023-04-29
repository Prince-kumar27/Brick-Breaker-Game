import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.*;
import javax.swing.*;
//import java.awt.*;

//import javax.swing.*;
class Register extends JFrame{
    JTextField t1,t2;
    JButton b1;
    JLabel l1;
    Register(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        t1=new JTextField(60);
        t2=new JTextField(60);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("l4.jpg"));
        //addfun to pace over frame
        JLabel img1=new JLabel(i1);
        
        img1.setBounds(0, 0, 200, 300);
        add(img1);
        b1=new JButton("Submit");
        l1=new JLabel("Register");
        l1.setFont(new Font("Times New Roman",Font.BOLD,30));
        l1.setForeground(Color.BLUE);
        l1.setBounds(300,10,300,40);
        add(l1);
        

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                try{

                    FileWriter f=new FileWriter("login.txt",true);
                    if(t1.getText().toString().equals("") && t2.getText().toString().equals("") ){

                        JFrame con =new JFrame();
                        JOptionPane.showMessageDialog(con,"Enter valid username and Pass");

                    }
                    else{

                    f.write(t1.getText()+"\t"+t2.getText()+"\n"); 
                    f.close();
                    JFrame con =new JFrame();
                    JOptionPane.showMessageDialog(con,"Registration scucessfull");
                    dispose();
                    }
                    
                    
                }catch(Exception e){}
                
            }
        } );
        JLabel username=new JLabel("User_name");
        username.setBounds(210,60,100,25);
        username.setFont(new Font("Verdana",Font.BOLD,14));
        username.setForeground(Color.BLACK);

        add(username);
        
        t1.setBounds(350,60,120,23);
        JLabel Password=new JLabel("Password");
        Password.setBounds(210,100,100,25);
        Password.setFont(new Font("Verdana",Font.BOLD,14));
        Password.setForeground(Color.BLACK);

        add(Password);


        
        t2.setBounds(350, 100, 120, 23);

        b1.setBounds(300,140,80,30);
        b1.setFont(new Font("Verdana",Font.BOLD,12));

        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLUE);
        add(t1);
        add(t2);
        add(b1);
        

    }
}
class logincod extends JFrame{
JTextField t1,t2;
JButton b1,b2;
JLabel l1,l2;
    logincod(){
        
        setLayout(null);//after that you can set the bounds
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        l1=new JLabel("Login");
        l1.setFont(new Font("Times New Roman",Font.BOLD,30));
        l1.setForeground(Color.BLUE);
        l1.setBounds(300,10,300,40);
        add(l1);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("login.jpg"));
        //addfun to pace over frame
        JLabel img1=new JLabel(i1);
        
        img1.setBounds(0, 0, 200, 300);
        add(img1);
        t1=new JTextField(60);
        t2=new JPasswordField(60);
        b1=new JButton("SignIn");
        b2=new JButton("Register");
        JLabel username=new JLabel("User_name");
        username.setBounds(210,60,100,25);
        username.setFont(new Font("Verdana",Font.BOLD,14));
        username.setForeground(Color.BLACK);

        add(username);
        JLabel Password=new JLabel("Password");
        Password.setBounds(210,100,100,25);
        Password.setFont(new Font("Verdana",Font.BOLD,14));
        Password.setForeground(Color.BLACK);

        add(Password);

        t1.setBounds(350,60,120,23);
        t2.setBounds(350, 100, 120, 23);

        b1.setBounds(250,140,80,30);
        b1.setFont(new Font("Verdana",Font.BOLD,12));

        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLUE);
        b2.setBounds(340,140,90,30);
        b2.setFont(new Font("Verdana",Font.BOLD,12));

        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLUE);
        l2=new JLabel(" ");
        l2.setBounds(250,190,700,30);
        add(l2);
        add(t1);
        add(t2);
        add(b1);
        add(b2);
        
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                boolean matched=false;
                String uname=t1.getText().toString();
                String pass=t2.getText().toString();

                String line;
                try{

                        FileReader f=new FileReader("login.txt");
                        BufferedReader br=new BufferedReader(f);
                        
                        while((line=br.readLine())!=null){
                            if(line.equals(uname+"\t"+pass)){
                                matched=true;
                                break;
                            }
                        }
                        f.close();
                        if(matched){
                            dispose();
                            String username=t1.getText().toString();
                            //opean a file and append the score with user name and time 
                            //using file handeling 
                            
                            brickbreaker b=new brickbreaker(username);
                            b.setVisible(true);
                            
                           
                            
                        }
                        else{
                            JFrame con =new JFrame();
                            JOptionPane.showMessageDialog(con,"Enter valid username and Pass");


                            l2.setText("Invalid username or Password");
                        }
                    }catch(Exception e){}
                
                    
                
                
                
                
                
                
                
                
                
                /*if(t1.getText().toString().equals("admin") && t2.getText().toString().equals("admin")){

                    l2.setText("Welcome");
                    dispose();
                }
                else{
                    l2.setText("Invalid username and Password");
                }*/
            }
            
        } );
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                
                Register r=new Register();
               
                r.setResizable(false);
                r.setTitle("REGISTER");
                r.setBounds(400, 200, 500, 300);
                r.setVisible(true);

            }
        } );
        
    
    
    }
}
class login{
public static void main(String[] args) {
    logincod l=new logincod();
   
    l.setResizable(false);
    l.setTitle("LOGIN PAGE");
    l.setBounds(400, 200, 500, 300);
    l.setVisible(true);
   

}
}