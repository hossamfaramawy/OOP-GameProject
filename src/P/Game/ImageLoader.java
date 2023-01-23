package P.Game;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader 
{
	public static BufferedImage Load(String path)
	{
		try
		{
			return ImageIO.read(ImageLoader.class.getResource(path));
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return null;
		
	}
	public static BufferedImage crop(int x, int y,int w ,int h,BufferedImage img)
	{
		return img.getSubimage(x, y, w, h);
	}

	
}
