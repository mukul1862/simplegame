/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facebook;

/**
 *
 * @author User
 */

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicGraphicsUtils;

public class track extends Applet implements Runnable,KeyListener
{
    Image pic1;
    Image pic2;
    
    int y=0;
    Thread t;
      
    int x=150;
       
    int X=100000;
    int Y;
    int now=0;
    
    int timer=10;
    
    Random dice=new Random();

    @Override
    
    public void start()
    {
        setSize(500,500);
        setBackground(Color.green);
        pic1=getImage(getDocumentBase(),"carhero.PNG");
        pic2=getImage(getDocumentBase(),"carvillain.PNG");
        addKeyListener(this);
        t=new Thread(this);
        
        t.start();
    }
    
    @Override
    public void run()
    {
        while(true)
        {
            try
            {
              Thread.sleep(timer);
                y=y+1;
                
                repaint();
                
                if(y==150)
                {
                    y=0;
                    
                    if(now==1)
                    {
                        if(timer>5)
                   timer=timer-1;
                        else
                        {
                            timer=5;
                        }
                 X=dice.nextInt(180);
                X=X+150;
                now=0;
                    }
                    
                    else
                    {
                        now=1;
                        X=100000;
                    }               
                }
                

                System.out.println("y:  "+y);

            }
            catch(Exception e)
            {
                System.out.println(e);
            }
         }
    }
    
    public void paint(Graphics g)
    {
        g.setColor(Color.red);
        g.drawString("HELLO",400,10);
        g.setColor(Color.black);
        g.fillRect(150,0,200,500);
        g.setColor(Color.yellow);
        g.fillRect((150+75+25),y-100,20,100);
        g.fillRect((150+75+25),y+50,20,100);
        g.fillRect((150+75+25),y+200,20,100);
        g.fillRect((150+75+25),y+350,20,100);
        //g.fillRect((150+75+25),y+500,20,100);
        
        g.drawImage(pic1,x,400,30,30,this);
        g.drawImage(pic2,X,(3*y),40,40,this);
        
        if(X<350)
        {
        if(((150<x&&x<X-35)||(X+35<x&&x<350)))
        {          
            System.out.println("if worked");
        }
        
        else
        {
            
            
            if((400-(3*y))<=35)
            {
            System.out.println("else worked");
            t.stop();
            JOptionPane.showMessageDialog(this,"U R OUT");
            }
        }
        }
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if(ke.getKeyCode()==KeyEvent.VK_RIGHT)
        {
            if(x<330)
            x=x+5;
            
            repaint();
            
        }
        
        if(ke.getKeyCode()==KeyEvent.VK_LEFT)
        {
            if(x>155)
            x=x-5;
            repaint();
        }
        
        
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
