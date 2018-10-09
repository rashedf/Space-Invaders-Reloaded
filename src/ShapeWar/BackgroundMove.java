package ShapeWar;

public class BackgroundMove extends Thread {
	
	private GameBoard gb;
	private Background bg;
	private Background bg2;
	
	public BackgroundMove(GameBoard gb, Background bg, Background bg2) {
		
		this.gb = gb;
		this.bg = bg;
		this.bg2 = bg2;
	}
	
	public void run(){
		
		
		int x = bg.getX();
		int x2 = bg2.getX();
		
		while(bg.getX() > -999){
			
			bg.setX(x);
			bg2.setX(x2);
			
			try{
				Thread.sleep(50);
			}
			catch(Exception e){}
			
			gb.repaint();
			
			x--;
			x2--;
		}
		
		if(bg.getX() == -999){
			
			bg.setX(0);
			bg2.setX(999);
			
			gb.repaint();
			run();
		}
	}
	
	public void music(){
		
		GameSound.music();
	}
	
	

}
