package P.Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Enemy extends GameObject
{
	static float st1semi=1;
	static float st2enemy=4;
	public static float spawnTime=(float) st1semi;
	public static float spawnTime2=(float) st2enemy;
	Handler handler= new Handler();
    public static float i=0;
	Random r = new Random();
	public int j;
	
	
	
	public Enemy(int x, int y, ID id)
	{
		super(x, y, id);
		velY=r.nextInt(7)+2;
	}

	public void tick() 
	{
		y+=velY;
		if()
		st1semi+=0.1;
		st2enemy-=0.5;	
		
	}
	
	public void render(Graphics g)
	{
		if (id==ID.Enemy)
		{
		g.setColor(Color.red);
		g.fillRect(x, y, 36	, 36);
		}
		else if ( id==ID.Semicolon)
		{
			g.setColor(Color.blue);
			g.fillRect(x, y, 36	, 36);
		}
	}

	
	public Rectangle getBounds() {
		return	new Rectangle(x,y,36,36);
	}
       
}
