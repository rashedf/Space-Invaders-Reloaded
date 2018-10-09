package ShapeWar;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Bullet {
	
	private int x,y;
	private String path;
	private int count = 0;
	private String type;
	
	public Bullet(int x, int y, String type, String path) {

		this.x = x;
		this.y = y;
		this.type = type;
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
	
	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void draw(Graphics g){
		
		ImageIcon bullet = new ImageIcon(path);
		
		g.drawImage(bullet.getImage(), x, y, null);
	}
	
	

}
