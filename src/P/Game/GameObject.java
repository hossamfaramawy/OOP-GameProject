package P.Game;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject
{
      protected int x,y;
      protected ID id;
      protected int velX, velY;
      protected int level=1;
      
      public GameObject(int x , int y , ID id)
      {
    	  this.x=x;
    	  this.y=y;
    	  this.id=id;	  
      }

   


    public abstract Rectangle getBounds();	//We using this class to detect if any rects are instsected

	public abstract void tick ();
      public abstract void render (Graphics g);
      
      public void setX (int x)
  	  {
  		this.x=x;
  	  }
      public void setY(int y )
      {
      	this.y=y;
      }
      public void setId(ID id )
      {
      	this.id=id;
      }
      public int getX()
      {
      	return x;
      }
      public int getY()
      {
      	return y;
      }
      public ID getId()
      {
      	return id;
      }
      public void setVelX(int velX)
      {
    	  this.velX=velX;
      }
      public void setVelY(int velY)
      {
    	  this.velY=velY;
      }
      public int getVelX()
      {
    	  return velX;
      }
      public int getVelY()
      {
    	  return velY;
      }



      
}
