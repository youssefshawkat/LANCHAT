package client;

// Java program to play an Audio
// file using Clip Object
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SimpleAudioPlayer {

    // to store current position

    Clip clip;

    URL SoundPath;

    // constructor to initialize streams and clip
    public SimpleAudioPlayer()
            throws UnsupportedAudioFileException,
            IOException, LineUnavailableException {
        try{
        SoundPath = getClass().getResource("/sound.wav");
        
        // create AudioInputStream object
          AudioInputStream audioInputStream=
                AudioSystem.getAudioInputStream(SoundPath);

        // create clip reference
        clip = AudioSystem.getClip();

        // open audioInputStream to the clip
        clip.open(audioInputStream);

        } catch(Exception e){
            
            e.printStackTrace();
        }

    }


    // Work as the user enters his choice


    // Method to play the audio
    public void play() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        //start the clip
        clip.start();

       

    }



}