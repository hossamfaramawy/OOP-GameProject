package P.Game;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseInput implements MouseListener ,MouseMotionListener
{
	boolean LMB=false;
	boolean RMB=false;
	boolean mouseIN=false;
	int mx,my;
	
	public void mouseDragged(MouseEvent e)
	{
		
	}

	public void mouseMoved(MouseEvent e) 
	{
		
	}

	public void mouseClicked(MouseEvent e) 
	{
		
	}

	public void mouseEntered(MouseEvent e)
    {
		
	}

	public void mouseExited(MouseEvent e) 
	{
		
	}

	public void mousePressed(MouseEvent e) 
	{
		if (e.getButton()==MouseEvent.BUTTON1)
			LMB= true;
		else if (e.getButton()==MouseEvent.BUTTON3)
			RMB=true;
		mx=e.getX();
		my=e.getY();
		if (LMB==true)
		{
		  if(mx>=Menu.sw && mx <=Menu.sw+Menu.w && my>=Menu.sh1 && my<=Menu.sh1+Menu.h)
		  {
			Game.currScreen=CurrentScreen.GAME;
             new Game (Game.currScreen);
		  }
		  else if (mx>=Menu.sw && mx <=Menu.sw+Menu.w && my>=Menu.sh3 && my<=Menu.sh3+Menu.h)
		  {
			System.exit(0);
		  }
		}
		
	}

	public void mouseReleased(MouseEvent e) 
	{
		if (e.getButton()==MouseEvent.BUTTON1)
			LMB= false;
		else if (e.getButton()==MouseEvent.BUTTON3)
			RMB=false;
	}

}
