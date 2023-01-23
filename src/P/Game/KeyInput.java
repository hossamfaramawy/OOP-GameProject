package P.Game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter
{
	private Handler handler;
	static boolean aPressed;
	static boolean dPressed;
	public static final int spd=20;
	public KeyInput(Handler handler)
	{
	 this.handler=handler;
	 aPressed=false;
	 dPressed=false;
	}
   public void keyPressed (KeyEvent e)
   {
	    int key=e.getKeyCode();
	   for ( int i=0; i<handler.list.size();i++)
	   {
		   GameObject tempObject=handler.list.get(i);
		   
		   if (tempObject.getId()==ID.Player)
		   {
			 //  if ( key==KeyEvent.VK_W)
		//	   {  tempObject.setVelY(-spd) ; }
			   if ( key==KeyEvent.VK_A)
			   { tempObject.setVelX(-spd); aPressed=true;}
			  
			   else if ( key==KeyEvent.VK_D)
			   {  tempObject.setVelX(spd); dPressed=true;}
		   }
		 
	   }
   }
   public void keyReleased (KeyEvent e)
   {
	   int key=e.getKeyCode();
	   
	   for ( int i=0; i<handler.list.size();i++)
	   {
		   GameObject tempObject=handler.list.get(i);
		   
		   if (tempObject.getId()==ID.Player)
		   {
	//		   if ( key==KeyEvent.VK_W)  wPressed=false;
//			      
//			   else if ( key==KeyEvent.VK_S)  sPressed=false;
				
			    if ( key==KeyEvent.VK_A) aPressed=false;  
				   
			   else if ( key==KeyEvent.VK_D)   dPressed=false;
			   
			   //vertical movement
//			   if (!wPressed && !sPressed)    tempObject.setVelY(0); 
//			   else if (!wPressed && sPressed)    tempObject.setVelY(spd); 
//			   else if (wPressed && !sPressed)    tempObject.setVelY(-spd); 
			   //horizontal movement
			  if (!aPressed && !dPressed)    tempObject.setVelX(0); 
			   else if (!aPressed && dPressed)    tempObject.setVelX(spd); 
			   else if (aPressed && !dPressed)    tempObject.setVelX(-spd); 
			
		   }
	   }
   }
   
   
}
