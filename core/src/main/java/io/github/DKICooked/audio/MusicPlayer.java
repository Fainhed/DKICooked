package io.github.DKICooked.audio;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class MusicPlayer {

    private Clip clip;

    public void play(String path, boolean loop) {
        stop(); // stop current music first

        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(path));
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();

            if (loop) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }
}
