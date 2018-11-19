import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.*;

public class HomeScreenDesign extends JPanel {

	public HomeScreenDesign()
	{
		super(new BorderLayout());
	}
	
	public void paintComponent (Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		String message = "HOTEL RESERVATION SYSTEM";
		
		Font f = new Font ("Impact", Font.PLAIN, 40);
		g2.setFont(f);
		
		//measure size of message
		FontRenderContext context = g2.getFontRenderContext();
		Rectangle2D bounds = f.getStringBounds(message, context);
		
		//set (x,y) = top left corner of text
		double x = (getWidth() - bounds.getWidth()) / 2;
		double y = (getHeight() - bounds.getHeight()) / 2;
		
		// add ascentleading to y to reach baseline
		double ascentleading = -bounds.getY();
		double baseY = y - ascentleading;
		
		//draw message
		g2.setColor(Color.WHITE);
		g2.drawString(message, (int) x, (int) baseY); 
		
		g2.setColor(new Color(17, 45, 50));
		g2.setStroke(new BasicStroke(8));
		
		//draw bottom rectangle
		g2.draw(new Line2D.Double(x + 10, baseY + 30, x + 10, y * 2));
		g2.draw(new Line2D.Double(x + bounds.getWidth() - 20, baseY + 30, x + bounds.getWidth() - 20, y * 2));
		g2.draw(new Line2D.Double(x + 10, y * 2, x + bounds.getWidth() - 20, y * 2));
		
		//draw top triangle
		g2.draw(new Line2D.Double(x + 10, y - 100, x + bounds.getWidth()/2, 20));
		g2.draw(new Line2D.Double(x + bounds.getWidth()/2, 20, x + bounds.getWidth() - 20, y - 100));
	}
	
}
