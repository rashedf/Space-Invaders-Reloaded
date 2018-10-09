package ShapeWar;

public class BulletFiring extends Thread{
	
	private GameBoard gb;
	private Bullet bullet;
	private int direction;
	
	public BulletFiring(GameBoard gb, Bullet bullet, int direction) {
		
		this.gb = gb;
		this.bullet = bullet;
		this.direction = direction;
	}
	
	public void run(){
		
		
		
		int x = bullet.getX();
		int y = bullet.getY();
		
		while(bullet.getY() > -70){
			
			
			
			if(direction == 1){
				String path = newPath(direction, bullet);
				bullet.setPath(path);
				bullet.setX(x-1);
			    bullet.setY(y);
			    
			    y-=6;
			    x+=1;
			}
			else if(direction == 2){
				String path = newPath(direction, bullet);
				bullet.setPath(path);
				bullet.setX(x-1);
			    bullet.setY(y);
			    
			    y-=4;
			    x+=2;
			}
			else if(direction == 3){
				String path = newPath(direction, bullet);
				bullet.setPath(path);
				bullet.setX(x-1);
			    bullet.setY(y);
			    
			    y-=3;
			    x+=4;
			}
			else if(direction == 4){
				String path = newPath(direction, bullet);
				bullet.setPath(path);
				bullet.setX(x-1);
			    bullet.setY(y);
			    
			    y-=1;
			    x+=4;
			}
			else if(direction == 0){
				String path = newPath(direction, bullet);
				bullet.setPath(path);
				bullet.setX(x-1);
			    bullet.setY(y);
			    
			    y-=5;
			    
			}
			else if(direction == 11){
				String path = newPath(direction, bullet);
				bullet.setPath(path);
				bullet.setX(x-1);
			    bullet.setY(y);
			    
			    y-=6;
			    x-=1;
			}
			else if(direction == 12){
				String path = newPath(direction, bullet);
				bullet.setPath(path);
				bullet.setX(x-1);
			    bullet.setY(y);
			    
			    y-=4;
			    x-=2;
			}
			else if(direction == 13){
				String path = newPath(direction, bullet);
				bullet.setPath(path);
				bullet.setX(x-1);
			    bullet.setY(y);
			    
			    y-=3;
			    x-=4;
			}
			else if(direction == 14){
				String path = newPath(direction, bullet);
				bullet.setPath(path);
				bullet.setX(x-1);
			    bullet.setY(y);
			    
			    y-=1;
			    x-=4;
			}
			
			
			
			
			
			try{
				Thread.sleep(10);
			}
			catch(Exception e){}
			
			gb.repaint();
			
			
		}
	}
	
	public String newPath(int direction, Bullet bullet){
		
		String out = "images\\";
		
		if(bullet.getType().equals("cross")){
			
			if(direction == 1){
				out += "CrossBulletRight.png";
			}
			else if(direction == 2){
				out += "CrossBulletRight1.png";
			}
			else if(direction == 3){
				out += "CrossBulletRight2.png";
			}
			else if(direction == 4){
				out += "CrossBulletRight22.png";
			}
			else if(direction == 0){
				out += "CrossBullet.png";
			}
			else if(direction == 11){
				out += "CrossBulletLeft.png";
			}
			else if(direction == 12){
				out += "CrossBulletLeft1.png";
			}
			else if(direction == 13){
				out += "CrossBulletLeft2.png";
			}
			else if(direction == 14){
				out += "CrossBulletLeft22.png";
			}
		}
		
		else if(bullet.getType().equals("square")){
			
			if(direction == 1){
				out += "SquareBulletRight.png";
			}
			else if(direction == 2){
				out += "SquareBulletRight1.png";
			}
			else if(direction == 3){
				out += "SquareBulletRight2.png";
			}
			else if(direction == 4){
				out += "SquareBulletRight22.png";
			}
			else if(direction == 0){
				out += "SquareBullet.png";
			}
			else if(direction == 11){
				out += "SquareBulletLeft.png";
			}
			else if(direction == 12){
				out += "SquareBulletLeft1.png";
			}
			else if(direction == 13){
				out += "SquareBulletLeft2.png";
			}
			else if(direction == 14){
				out += "SquareBulletLeft22.png";
			}
		}
		
		else if(bullet.getType().equals("circle")){
			
			if(direction == 1){
				out += "CircleBulletRight.png";
			}
			else if(direction == 2){
				out += "CircleBulletRight1.png";
			}
			else if(direction == 3){
				out += "CircleBulletRight2.png";
			}
			else if(direction == 4){
				out += "CircleBulletRight22.png";
			}
			else if(direction == 0){
				out += "CircleBullet.png";
			}
			else if(direction == 11){
				out += "CircleBulletLeft.png";
			}
			else if(direction == 12){
				out += "CircleBulletLeft1.png";
			}
			else if(direction == 13){
				out += "CircleBulletLeft2.png";
			}
			else if(direction == 14){
				out += "CircleBulletLeft22.png";
			}
		}
		
		else if(bullet.getType().equals("triangle")){
			
			if(direction == 1){
				out += "TriangleBulletRight.png";
			}
			else if(direction == 2){
				out += "TriangleBulletRight1.png";
			}
			else if(direction == 3){
				out += "TriangleBulletRight2.png";
			}
			else if(direction == 4){
				out += "TriangleBulletRight22.png";
			}
			else if(direction == 0){
				out += "TriangleBullet.png";
			}
			else if(direction == 11){
				out += "TriangleBulletLeft.png";
			}
			else if(direction == 12){
				out += "TriangleBulletLeft1.png";
			}
			else if(direction == 13){
				out += "TriangleBulletLeft2.png";
			}
			else if(direction == 14){
				out += "TriangleBulletLeft22.png";
			}
		}
		
		return out;
	}
	
}	


