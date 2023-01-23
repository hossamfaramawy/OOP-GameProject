package P.Game;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Display extends Canvas
{
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	
	public Display(String title , int width,int height, Game game)
	{
	
		frame= new JFrame(title);
		frame.setPreferredSize(new Dimension (width,height));
		frame.setMaximumSize(new Dimension (width,height));
		frame.setMinimumSize(new Dimension (width,height));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);	
		frame.add(game);
		game.start();
    }

	
}