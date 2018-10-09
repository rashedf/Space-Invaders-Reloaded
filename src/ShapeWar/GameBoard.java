package ShapeWar;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class GameBoard extends JPanel implements MouseMotionListener, KeyListener {
	
	private Triangle tri;
	private Enemy[] enemyCrosses = new Enemy[4];
	private Enemy[] enemyCircles = new Enemy[4];
	private Enemy[] enemySquares = new Enemy[4];
	private Enemy[] enemyTriangles = new Enemy[4];
	private Background bg;
	private Background bg2;
	private Background surface;
	private Bullet[] crosses = new Bullet[10];
	private Bullet[] triangles = new Bullet[10];
	private Bullet[] circles = new Bullet[10];
	private Bullet[] squares = new Bullet[10];
	private int direction = 0;
	private Others invasionCount;
	private Others scoreCount1;
	private Others scoreCount2;
	private Others splash;
	private int gameCount = 0;
	
	
	public GameBoard(){
		
		bg = new Background(0, 0, "images\\background.jpg");
		bg2 = new Background(999, 0, "images\\background.jpg");
		surface = new Background(0, 20, "images\\surface2.png");
		scoreCount1 = new Others(20, 20, "images\\0.png");
		scoreCount2 = new Others(55, 20, "");
		splash = new Others(0, 0, "images\\splash.png");
		
		
		for(int i=0; i<10; i++){
			
			crosses[i] = new Bullet(-100, -100, "cross", "images\\CrossBullet.png");
			triangles[i] = new Bullet(-100, -100, "triangle", "images\\TriangleBullet.png");
			circles[i] = new Bullet(-100, -100, "circle", "images\\CircleBullet.png");
			squares[i] = new Bullet(-100, -100, "square", "images\\SquareBullet.png");
					
		}
		
		tri = new Triangle(455, 490, "images\\triangle.png");
		
		super.setFocusable(true);
		super.addMouseMotionListener(this);
		super.addKeyListener(this);
		
		int xpos = 200;
		
		for(int i=0; i<4; i++){
			
			enemyCircles[i] = new Enemy(xpos, -100, "circle", "images\\CircleEnemy.png");
			enemyCrosses[i] = new Enemy(xpos, -100, "cross", "images\\CrossEnemy.png");
			enemySquares[i] = new Enemy(xpos, -100, "square", "images\\SquareEnemy.png");
			enemyTriangles[i] = new Enemy(xpos, -100, "triangle", "images\\TriangleEnemy.png");
			
			xpos += 180;
		}
		
		invasionCount = new Others(700, 490, "images\\invasion0.png");
		
	}
	
	
	
	
	
	public void paint(Graphics g){
		
		
		bg.draw(g);
		bg2.draw(g);
		surface.draw(g);
		
		for(int i=0; i<10; i++){
			
			crosses[i].draw(g);
			squares[i].draw(g);
			circles[i].draw(g);
			triangles[i].draw(g);
		}

		
		tri.draw(g);
		
        for(int i=0; i<4; i++){
			
			enemyCircles[i].draw(g);
			enemySquares[i].draw(g);
			enemyTriangles[i].draw(g);
			enemyCrosses[i].draw(g);
			
		}
        
        
        invasionCount.draw(g);
        scoreCount1.draw(g);
        scoreCount2.draw(g);
        splash.draw(g);

	}
	
	public void startGame(){
		
        
		   
		
		    BackgroundMove bgMove = new BackgroundMove(this, bg, bg2);
		    bgMove.start();
		    bgMove.music();
        	
        	EnemyMove move = new EnemyMove(enemyCrosses, enemySquares, enemyCircles, enemyTriangles, crosses, squares, circles, triangles,invasionCount, scoreCount1, scoreCount2, this);
            move.start();
        
           super.repaint();
		
        
	}
	
	
	

	

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
		
	    if(e.getX() > 480 && e.getX() < 520){
			tri.setImagePath("images\\triangle.png");
			direction = 0;
		}
		
		if(e.getX() > 400 && e.getX() < 480){
			tri.setImagePath("images\\triangleleft.png");
			direction = 11;
		}
		
		if(e.getX() < 400 && e.getX() > 300){
			tri.setImagePath("images\\triangleleft1.png");
			direction = 12;
		}
	    
	    if(e.getX() < 300 && e.getX() > 100){
			tri.setImagePath("images\\triangleleft2.png");
			direction = 13;
	    }
	    
	    if(e.getX() > 0 && e.getX() < 100){
			tri.setImagePath("images\\triangleleft22.png");
			direction = 14;
		}
	    
	    if(e.getX() > 520 && e.getX() < 600){
			tri.setImagePath("images\\triangleright.png");
			direction = 1;
		}
	    
	    if(e.getX() > 600 && e.getX() < 700){
			tri.setImagePath("images\\triangleright1.png");
			direction = 2;
		}
	    
	    if(e.getX() > 700 && e.getX() < 900){
			tri.setImagePath("images\\triangleright2.png");
			direction = 3;
		}
	    if(e.getX() > 900 && e.getX() < 1001){
			tri.setImagePath("images\\triangleright22.png");
			direction = 4;
		}
	  
		super.repaint();
			
		
	}

	

	

	@Override
	public void keyPressed(KeyEvent e) {
		
		
		if(e.getKeyCode() == e.VK_ENTER){
			
			splash.setPath("");
			
			if(gameCount==0){
			startGame();
			}
			
			gameCount++;
		}
		
		
		if(e.getKeyCode() == e.VK_W){
			
			GameSound.missileLaunch();
			
			int n = triangles[0].getCount();
			
			if(triangles[0].getCount() < 9){
				
				triangles[0].setCount(n+1);
			}
			else {
				triangles[0].setCount(0);
			}
			
			triangles[n].setX(480);
			triangles[n].setY(490);
			
			super.repaint();
			
			try {
				Thread.sleep(10);
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
			
			BulletFiring bf = new BulletFiring(this, triangles[n],direction);
			bf.start();
			super.repaint();
		}
		
		if(e.getKeyCode() == e.VK_A){
			
			GameSound.missileLaunch();
			
			int n = circles[0].getCount();
			
			if(circles[0].getCount() < 9){
				
				circles[0].setCount(n+1);
			}
			else {
				circles[0].setCount(0);
			}
			
			circles[n].setX(480);
			circles[n].setY(490);
			
			super.repaint();
			
			try {
				Thread.sleep(10);
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
			
			BulletFiring bf = new BulletFiring(this, circles[n],direction);
			bf.start();
			super.repaint();
		}
		
		if(e.getKeyCode() == e.VK_S){
			
			GameSound.missileLaunch();
			
			int n = squares[0].getCount();
			
			if(squares[0].getCount() < 9){
				
				squares[0].setCount(n+1);
			}
			else {
				squares[0].setCount(0);
			}
			
			squares[n].setX(480);
			squares[n].setY(490);
			
			super.repaint();
			
			try {
				Thread.sleep(10);
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
			
			BulletFiring bf = new BulletFiring(this, squares[n],direction);
			bf.start();
			super.repaint();
		}
		
		if(e.getKeyCode() == e.VK_D){
			
			GameSound.missileLaunch();
			
			int n = crosses[0].getCount();
			
			if(crosses[0].getCount() < 9){
				
				crosses[0].setCount(n+1);
			}
			else {
				crosses[0].setCount(0);
			}
			
			crosses[n].setX(480);
			crosses[n].setY(490);
			
			super.repaint();
			
			try {
				Thread.sleep(10);
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
			
			BulletFiring bf = new BulletFiring(this, crosses[n],direction);
			bf.start();
			super.repaint();
		}
		
      
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
		
		//super.repaint();
		
	}
	
	

}
