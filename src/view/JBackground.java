package view;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Image;
import java.io.IOException;
import java.io.File;
import java.awt.Graphics;

public class JBackground extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	protected Image bImage;
	protected String FilePath;
	

	public JBackground(Image background)
	{
		bImage = background;
	}
	
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		g.drawImage(bImage, 0, 0, this.getWidth(), this.getHeight(), this);
	}
	
	public JBackground(String backgroundFilePath)
	{
		this.FilePath = backgroundFilePath;
		
		try
		{
			bImage = ImageIO.read(new File(backgroundFilePath));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}