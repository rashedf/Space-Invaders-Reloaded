package ShapeWar;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		
		JFrame window = new JFrame();
		
		GameBoard game = new GameBoard();
		
			
		    window.add(game);
			window.setSize(1001, 600);
			window.setLocation(180, 50);
			window.setTitle("Shape War");
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			window.setVisible(true);
			
			
			//game.startGame();
			

	}

}
