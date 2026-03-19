package io.github.DKICooked.audio;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.audio.Music;
import io.github.DKICooked.Main;
import io.github.DKICooked.Assets;

public class SoundPlayer {

    private final Sound jumpSound;
    private final Sound deathSound;
    private final Sound splatSound;
    private final Music backgroundMusic;

    // We pass in 'Main' so we can access the AssetManager
    public SoundPlayer(Main main) {
        // Grab everything from the manager using the constants in Assets.java
        this.jumpSound = main.manager.get(Assets.JUMP_SOUND, Sound.class);
        this.deathSound = main.manager.get(Assets.DEATH_SOUND, Sound.class);
        this.splatSound = main.manager.get(Assets.SPLAT_SOUND, Sound.class);
        this.backgroundMusic = main.manager.get(Assets.MENU_MUSIC, Music.class);

        // Basic music setup
        this.backgroundMusic.setLooping(true);
        this.backgroundMusic.setVolume(0.5f);
    }

    public void playJump() {
        if (jumpSound != null) jumpSound.play(1.0f);
    }

    public void playDeath() {
        if (deathSound != null) deathSound.play(1.0f);
    }

    public void playSplat() {
        if (splatSound != null) splatSound.play(3.0f);
    }

    public void playMusic() {
        if (backgroundMusic != null && !backgroundMusic.isPlaying()) {
            backgroundMusic.play();
        }
    }

    public void stopMusic() {
        if (backgroundMusic != null) backgroundMusic.stop();
    }

    public void dispose() {
        // Leave this EMPTY!
        // main.manager.dispose() in your Main class handles this now.
    }
}
