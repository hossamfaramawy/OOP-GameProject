package P.Game;

import java.awt.Color;
import java.awt.Graphics;

public class HUD 
{
    public static int hp=200;
    public static int maxscore=250;
    public static int scoreIncr=0;
	
    
	public void tick()
	{	
	
		hp=Game.setLimits(hp, 0, 200);
		maxscore=Game.setLimits(maxscore, 200, 250);
		scoreIncr=Game.setLimits(scoreIncr, 0, 250);
		if(hp==0)
			hu
	}

	public void render(Graphics g) 
	{
		//HP
		g.setColor(Color.gray);
		g.fillRect(15, 15, 200, 32);
		g.setColor(Color.green);
		g.fillRect(15, 15, hp, 32);
		g.setColor(Color.white);
		g.drawRect(15, 15, 200, 32);
		//Score
		g.setColor(Color.gray);
		g.fillRect(15, 200, 45, 250);
		g.setColor(Color.red);
		g.fillRect(15, 450, 45, -scoreIncr);
		g.setColor(Color.black);
		g.drawRect(15, 200,45 , 250);
		
	}
    
}
