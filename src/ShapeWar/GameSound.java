package ShapeWar;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class GameSound {
	
	public static void music(){
		
		try{
			
			File bgMusic = new File("sounds\\intro.wav");
			AudioInputStream ais = AudioSystem.getAudioInputStream(bgMusic);
			Clip clip = AudioSystem.getClip();
			clip.open(ais);
			clip.start();
		}
		catch(Exception e){
			
		}
		
	}
	
     public static void missileLaunch(){
		
		try{
			
			File bgMusic = new File("sounds\\missilelaunch.wav");
			AudioInputStream ais = AudioSystem.getAudioInputStream(bgMusic);
			Clip clip = AudioSystem.getClip();
			clip.open(ais);
			clip.start();
		}
		catch(Exception e){
			
		}
		
	}
     
     public static void hitEnemy(){
 		
 		try{
 			
 			File bgMusic = new File("sounds\\hitenemy.wav");
 			AudioInputStream ais = AudioSystem.getAudioInputStream(bgMusic);
 			Clip clip = AudioSystem.getClip();
 			clip.open(ais);
 			clip.start();
 		}
 		catch(Exception e){
 			
 		}
 		
 	}
     
     public static void gameOver(){
  		
  		try{
  			
  			File bgMusic = new File("sounds\\gameover.wav");
  			AudioInputStream ais = AudioSystem.getAudioInputStream(bgMusic);
  			Clip clip = AudioSystem.getClip();
  			clip.open(ais);
  			clip.start();
  		}
  		catch(Exception e){
  			
  		}
  		
  	}
	
	

}
