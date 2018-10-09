package ShapeWar;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Background {
	
	private int x,y;
	private String path;
	
	public Background(int x, int y, String path) {
		
		this.x = x;
		this.y = y;
		this.path = path;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	public void draw(Graphics g){
		
		ImageIcon background = new ImageIcon(path);
        g.drawImage(background.getImage() , x, y, null);
	}
	
	
	
	
	

}
