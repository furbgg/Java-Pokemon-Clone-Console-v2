package Javamonv1;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;


public class SoundManager  {
    public void playSound(String soundFileName) {
        try {
            File soundFile = new File(soundFileName);
            if (soundFile.exists()) {
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                Clip clip = AudioSystem.getClip();
                clip.open(audioIn);
                clip.start();
            } else {
                System.out.println("File hat nicht gefunden" + soundFileName);
            }
    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }


}}
