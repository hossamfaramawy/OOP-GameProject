package P.Game;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Player extends GameObject
{

	Random s= new Random();
	private int j=0;
	private final int anim=45;
	BufferedImage Player=ImageLoader.Load("/textures/Character2.jpg");
	BufferedImage PlayerMirror=ImageLoader.Load("/textures/Character3.jpg");
	Handler handler;
	int changex=1;
//    private final int MAX_SPEED=10;
//    private float gravity = 0.04f;
    
	public Player(int x, int y, ID id,Handler handler) 
	{
		super ( x , y , id);
		this.handler=handler;
	}
	

	public void tick()
	{
	   x+=velX;
	  x=Game.setLimits(x,0, Game.w-95);

		collision();
	}

	
	private void collision()
	{
		for(int i=0;i<handler.list.size();i++)
		{
			
			GameObject tempObject=handler.list.get(i);
			if(tempObject.getId() == ID.Enemy)
			{
				if(getBounds().intersects(tempObject.getBounds()))
				{
					
					HUD.hp -=changex;
					handler.removeObject(tempObject);		
				
				}
				
			}	
			else if(tempObject.getId() == ID.Semicolon)
			{
				if(getBounds().intersects(tempObject.getBounds()))
				{
					
					HUD.scoreIncr +=changex;
					handler.removeObject(tempObject);		

				
				}
				
			}	
			
		}
		
		
	}
	 
	 
	
	
	public void render(Graphics g) 
	{

		if(KeyInput.aPressed)
	{
		j++;
		if(j%(anim*5)<=anim)
		 g.drawImage(ImageLoader.crop(407, 140, 80, 95, Player),x,y,null);
		else if(j%(anim*5)<=anim*2 && j%(anim*5)>anim)
		 g.drawImage(ImageLoader.crop(305, 120, 100, 99, Player),x,y, null);
		else if(j%(anim*5)<=anim*3 && j%(anim*5)>anim*2)
		  g.drawImage(ImageLoader.crop(222, 140, 83, 95, Player),x,y, null);
		else if(j%(anim*5)<=anim*4 && j%(anim*5)>anim*3)
		  g.drawImage(ImageLoader.crop(122, 120, 100, 99, Player),x,y, null);
		else if(j%(anim*5)<=anim*5 && j%(anim*5)>anim*4)
		   g.drawImage(ImageLoader.crop(10, 120, 110, 99, Player),x,y, null);
	}
		else if (KeyInput.dPressed)
		{
			j++;
			if(j%(anim*5)<=anim)
			 g.drawImage(ImageLoader.crop(17, 140, 80, 95, PlayerMirror),x,y,null);
			else if(j%(anim*5)<=anim*2 && j%(anim*5)>anim)
			 g.drawImage(ImageLoader.crop(97, 120, 100, 99, PlayerMirror),x,y, null);
			else if(j%(anim*5)<=anim*3 && j%(anim*5)>anim*2)
			  g.drawImage(ImageLoader.crop(199, 140, 83, 95, PlayerMirror),x,y, null);
			else if(j%(anim*5)<=anim*4 && j%(anim*5)>anim*3)
			  g.drawImage(ImageLoader.crop(282, 120, 100, 99, PlayerMirror),x,y, null);
			else if(j%(anim*5)<=anim*5 && j%(anim*5)>anim*4)
			   g.drawImage(ImageLoader.crop(384, 120, 110, 99, PlayerMirror),x,y, null);
		}
		else 
			g.drawImage(ImageLoader.crop(407, 140, 80, 95, Player),x,y,null);
   }

	
	public Rectangle getBounds() {

		
		return new Rectangle(x,y,100,95);
	}
	

}
	
