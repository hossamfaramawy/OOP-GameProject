package P.Game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Random;



 enum CurrentScreen
{
	GAME,MENU;
}

public class Game extends Canvas implements Runnable
{   //LOCALS
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6748825286695667688L;
	Thread thread;

	private boolean Running= false;
	private Handler handler;
	public static final int w=1366;
	public static final int h=780;
    private HUD hud;
	private Menu menu;
	static CurrentScreen currScreen=CurrentScreen.MENU;
	Random r = new Random();
    BufferedImage bg1,bg2,bg3,bg4;
    public static BufferedImage img;
 	public static Enemy enemy[]=new Enemy[450];
    int j=0;
  
	 
	
	// CONSTRUCTOR

	 public Game (CurrentScreen curr)
	 {

		 img=ImageLoader.Load("/textures/Bg1.png");
		 new Display ("Evil code",w,h,this);  
        
		 menu = new Menu ();
		 if (curr==CurrentScreen.MENU)
		 {
		     this.addMouseListener(new MouseInput());
			 this.addMouseMotionListener(new MouseInput());
		 }
		 else if (curr==CurrentScreen.GAME)
		 {
		 
			 handler = new Handler();
			 this.addKeyListener(new KeyInput(handler));
			 hud=new HUD();
			 handler.addObject(new Player (w/2,h-150,ID.Player,handler));
			 //handler.addObject(new Enemy(r.nextInt(Game.w-100),0,ID.Enemy));
			 bg1=ImageLoader.Load("/textures/Normal.png");
		     bg2=ImageLoader.Load("textures/LemDrgat.png");
		     bg3=ImageLoader.Load("textures/3ash.png");
		     bg4=ImageLoader.Load("textures/TeachMe.png");
			 
			 
		 }
	 }
	 
	 //METHODS
	 
	 
     public synchronized void start ()
     {   
    	 if (Running)
    		 return; 
    	 thread = new Thread(this);
    	 thread.start();
    	
    	 Running=true;
     }
     public void run ()
     {
    	
    	
    	 long lastTime=System.nanoTime();
    	 double fps=60.0;
    	 double timePerTick=1000000000/fps;
    	 double passedTime=0;
    	 long timer=System.currentTimeMillis();
    	 int frames=0;
    	 while(Running)
    	 {

    		 long now=System.nanoTime();
    		 passedTime+=(now-lastTime)/timePerTick;
    		 lastTime=now;
    		 while (passedTime>=1)
    		 {
    			 tick();
    			 passedTime--;
    		 }
    		 if(Running)
    		 {
    			 render();
    			 frames++;
    		 }
    		 if (System.currentTimeMillis()-timer>1000)
    		 {
    			 timer+=1000;
    			 System.out.println("FPS: " + frames);
    			 frames=0;
    		 }
    	 }
     }
     
     private void tick ()
     {

		// System.out.println(System.currentTimeMillis());
		 if (currScreen==CurrentScreen.GAME)
		 {
			  Enemy.i++;
				if (Enemy.i%(60*Enemy.spawnTime)==0)
				{
						enemy[j]=new Enemy (r.nextInt(w-100),0,ID.Semicolon);
						handler.addObject(enemy[j]);
						j++;
					
		        }
				if (Enemy.i%(60*Enemy.spawnTime2)==0)
				{
					enemy[j]=new Enemy (r.nextInt(w-100),0,ID.Enemy);
					handler.addObject(enemy[j]);
					j++;
				}
				for(int s=0;s<j;s++)
				{
			    	if(enemy[s].getY()>h-90)
					handler.removeObject(enemy[s]);
				}
				 handler.tick();
		    	 hud.tick();
	      }
    	
	 }
     
     private void render () 
     {
    	
    	 this.requestFocus();
    	 BufferStrategy bs=this.getBufferStrategy();
    	 if (bs==null)
    	 {
    		 this.createBufferStrategy(3);
    		 return;
    	 }
    	Graphics g = bs.getDrawGraphics();
       g.setColor(Color.BLACK);
       g.fillRect(0, 0, w, h);
     	 // /////// ASSETS HERE !
       
		   	 g.drawImage(bg1, 0, 0, null);
     		
     	
    	////////// END OF ASSETS
    	 if (currScreen==CurrentScreen.GAME)
		 {

        	 hud.render(g);
    	 handler.render(g);
    	 
		 }
    	 else if (currScreen==CurrentScreen.MENU)
    	 {
    		  
    		 menu.render(g);
    	 }
    	 g.dispose();
    	 bs.show();
     }
     
     public static int setLimits(int comp,int min, int max)
     {
    	 if (comp<=min)
    	 
    		return comp=min;
    	 
    	 else if (comp >=max)
    		 
    		return comp=max;
    	 
    	 else 
    		 
    		 return comp;
     }
     
     public synchronized void stop ()
     {
    	 try
         {
			thread.join();
			Running=false;
         } 
    	 catch (InterruptedException e)
    	 {
			e.printStackTrace();
		 }
    	 
     }
     
     public static void main (String args [])
     {
    	  new Game (currScreen);
    	 
     }
}
