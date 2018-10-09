package ShapeWar;

import javax.swing.JFrame;

public class EnemyMove extends Thread {
	
	private Enemy[] crosses;
	private Enemy[] squares;
	private Enemy[] circles;
	private Enemy[] triangles;
	private Bullet[] crossesB;
	private Bullet[] squaresB;
	private Bullet[] circlesB;
	private Bullet[] trianglesB;
	private Enemy[] enemySlot = new Enemy[4];
	private GameBoard gb;
	private int life = 10;
	private Others invasionCount;
	private Others pointCount1;
	private Others pointCount2;
	private int killCount = 0;
	private int speed = 20;
	
	
	
	
    public EnemyMove(Enemy[] crosses, Enemy[] squares, Enemy[] circles,
			Enemy[] triangles, Bullet[] crossesB, Bullet[] squaresB,
			Bullet[] circlesB, Bullet[] trianglesB,
			Others invasionCount, Others pointCount1, Others pointCount2, GameBoard gb) {
    	
		this.crosses = crosses;
		this.squares = squares;
		this.circles = circles;
		this.triangles = triangles;
		this.crossesB = crossesB;
		this.squaresB = squaresB;
		this.circlesB = circlesB;
		this.trianglesB = trianglesB;
		this.invasionCount = invasionCount;
		this.pointCount1 = pointCount1;
		this.pointCount2 = pointCount2;
		
		this.gb = gb;
	}









	public void run(){
		
		int slot = (int) (Math.floor(Math.random() * (4-1+1))+1);
		
		for(int i=0; i<4; i++){
			
			slot = (int) (Math.floor(Math.random() * (4-1+1))+1);
			
			if(slot == 2){
				enemySlot[i] = crosses[i];
			}
			else if(slot == 3){
				enemySlot[i] = circles[i];
			}
			
			else if(slot == 1){
				enemySlot[i] = triangles[i];
			}
			else if(slot == 4){
				enemySlot[i] = squares[i];
			}
			
			
		}
		
//		int y = enemySlot[0].getY();
		
		while(life>0){
			
			    
			for(int i=0; i<4; i++){
				
				int y2 = enemySlot[i].getY()+1;
				
				enemySlot[i].setY(y2);
				
				if(collisionCheck(enemySlot[i]) == true){
					
					
					
					enemySlot[i].setY(-100);
					slot = (int) (Math.floor(Math.random() * (4-1+1))+1);
					
					if(slot == 2){
						enemySlot[i] = crosses[i];
					}
					else if(slot == 3){
						enemySlot[i] = circles[i];
					}
					
					else if(slot == 1){
						enemySlot[i] = triangles[i];
					}
					else if(slot == 4){
						enemySlot[i] = squares[i];
					}
					
					enemySlot[i].setY(-100);
					
					
				}
				
				if(y2 == 500){
					life --;
					enemySlot[i].setY(-100);
                   slot = (int) (Math.floor(Math.random() * (4-1+1))+1);
					
					if(slot == 2){
						enemySlot[i] = crosses[i];
					}
					else if(slot == 3){
						enemySlot[i] = circles[i];
					}
					
					else if(slot == 1){
						enemySlot[i] = triangles[i];
					}
					else if(slot == 4){
						enemySlot[i] = squares[i];
					}
					
					enemySlot[i].setY(-100);
				}
			}
				
            
			setLife(life);
			
			try{
				Thread.sleep(speed);
			}
			catch(Exception e){
				
			}
			gb.repaint();
			
			
//			y++;
			
		}
		
//         if(life == 0){
//        	 
//         }
	}
	
	public boolean collisionCheck(Enemy enemy){
		
		String type = enemy.getType();
		
		for(int i=0; i<10; i++){
			
			if(crossesB[i].getY() >= 0 && crossesB[i].getX() >= enemy.getX() && crossesB[i].getX() <= (enemy.getX()+44) && crossesB[i].getY() >= enemy.getY() && crossesB[i].getY() <= (enemy.getY()+44) && crossesB[i].getType().equals(type)){
				crossesB[i].setY(-100);
				GameSound.hitEnemy();
				killCount++;
				if(speed>=8 && killCount >15)
					speed--;
				upScore(killCount, pointCount1, pointCount2);
				return true;
			}
			else if(circlesB[i].getY() >= 0 && circlesB[i].getX() >= enemy.getX() && circlesB[i].getX() <= (enemy.getX()+44) && circlesB[i].getY() >= enemy.getY() && circlesB[i].getY() <= (enemy.getY()+44) && circlesB[i].getType().equals(type)){
				circlesB[i].setY(-100);
				GameSound.hitEnemy();
				killCount++;
				if(speed>=8 && killCount >15)
					speed--;
				upScore(killCount, pointCount1, pointCount2);
				return true;
			}
			else if(squaresB[i].getY() >= 0 && squaresB[i].getX() >= enemy.getX() && squaresB[i].getX() <= (enemy.getX()+44) && squaresB[i].getY() >= enemy.getY() && squaresB[i].getY() <= (enemy.getY()+44) && squaresB[i].getType().equals(type)){
				squaresB[i].setY(-100);
				GameSound.hitEnemy();
				killCount++;
				if(speed>=8 && killCount >15)
					speed--;
				upScore(killCount, pointCount1, pointCount2);
				return true;
			}
			else if(trianglesB[i].getY() >= 0 && trianglesB[i].getX() >= enemy.getX() && trianglesB[i].getX() <= (enemy.getX()+44) && trianglesB[i].getY() >= enemy.getY() && trianglesB[i].getY() <= (enemy.getY()+44) && trianglesB[i].getType().equals(type)){
				trianglesB[i].setY(-100);
				GameSound.hitEnemy();
				killCount++;
				if(speed>=8 && killCount >15)
					speed--;
				upScore(killCount, pointCount1, pointCount2);
				return true;
			}
		}
		
		return false;
	}
	
	public void setLife(int life){
		
		if(life == 9){
			invasionCount.setPath("images\\invasion1.png");
		}
		else if(life == 8){
			invasionCount.setPath("images\\invasion2.png");
		}
		else if(life == 7){
			invasionCount.setPath("images\\invasion3.png");
		}
		else if(life == 6){
			invasionCount.setPath("images\\invasion4.png");
		}
		else if(life == 5){
			invasionCount.setPath("images\\invasion5.png");
		}
		else if(life == 4){
			invasionCount.setPath("images\\invasion6.png");
		}
		else if(life == 3){
			invasionCount.setPath("images\\invasion7.png");
		}
		else if(life == 2){
			invasionCount.setPath("images\\invasion8.png");
		}
		else if(life == 1){
			invasionCount.setPath("images\\invasion9.png");
		}
		else if(life <= 0){
			invasionCount.setPath("images\\gameover.png");
			GameSound.gameOver();
			
			enemySlot[0].setY(-100);
			enemySlot[1].setY(-100);
			enemySlot[2].setY(-100);
			enemySlot[3].setY(-100);
		}
	}
	
	public void upScore(int killCount, Others pointCount1, Others pointCount2){
		
		if(killCount < 10 && killCount >0){
			
			int num = killCount%10;
			pointCount1.setPath("images\\" + num + ".png");
		}
		
		else if(killCount >= 10){
			
			int num1 = killCount/10;
			pointCount1.setPath("images\\" + num1 + ".png");
			
			int num2 = killCount%10;
			pointCount2.setPath("images\\" + num2 + ".png");
		}
	}
	
	
	
	
	

}
