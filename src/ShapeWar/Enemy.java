package ShapeWar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Enemy {
	
	private int x,y;
	private String path;
	private String type;
	
	
	public Enemy(int x, int y, String type, String path) {
		
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


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}
	
	
	
	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public void draw(Graphics g){
		
		ImageIcon cross = new ImageIcon(path);
		g.drawImage(cross.getImage(), x, y, null);
	}
	
	
	

}
