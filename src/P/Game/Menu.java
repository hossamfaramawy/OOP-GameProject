package P.Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class Menu extends JComponent
{
	private static final long serialVersionUID = 1L;
	public static final int sh3=490;
	public static final int sh2=320;
	public static final int sh1=150;
	public static final int sw=490;
	public static final int h=105;
	public static final int w=425;

	

    public void  render(Graphics g) 
    {
    	
    
      
     	g.drawImage(Game.img,0,0,null);
     	
    	g.setColor(Color.BLACK);
    	g.fillRect(sw, sh1, w, h);
    	g.fillRect(sw, sh2, w, h);
    	g.fillRect(sw, sh3, w, h);
    	g.setColor(Color.yellow);
    	g.drawRect(sw, sh1, w, h);
    	g.drawRect(sw, sh2, w, h);
    	g.drawRect(sw, sh3, w, h);
 	
    	Graphics2D g2= (Graphics2D) g;
    	
    	g2.setColor(Color.yellow);
    	g2.setFont(new Font("Times New Roman",Font.ITALIC, 80));
    	
    	g2.drawString("Play",sw+137,sh1+73);
    	g2.drawString("Help",sw+137,sh2+72);
    	g2.drawString("Quit",sw+137,sh3+70);
    	
    	//this.addMouseListener(MouseEvent e);
    		
    }



	
}
