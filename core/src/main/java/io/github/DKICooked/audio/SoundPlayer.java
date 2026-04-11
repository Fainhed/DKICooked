package io.github.DKICooked.audio;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class SoundPlayer {
    public static float bgmVolume = 0.5f;
    public static float sfxVolume = 0.8f;

    private Music music;
    private Sound jumpSound;
    private Sound meteorSound;
    private Sound ufoSound;
    private Sound staticSound;


    public SoundPlayer() {
        staticSound = Gdx.audio.newSound(Gdx.files.internal("sounds/static.wav"));
        meteorSound = Gdx.audio.newSound(Gdx.files.internal("sounds/meteor.wav"));
        ufoSound = Gdx.audio.newSound(Gdx.files.internal("sounds/alien.wav"));
        music = Gdx.audio.newMusic(Gdx.files.internal("sounds/music8bit.mp3"));
        jumpSound = Gdx.audio.newSound(Gdx.files.internal("sounds/jump.wav"));
    }

    public void playMusic() {
        if (music != null) {
            music.setVolume(bgmVolume);
            music.setLooping(true);
            music.play();
        }
    }
    public void playMeteor() {
        if (meteorSound != null) meteorSound.play(sfxVolume);
    }

    public void playUFO() {
        if (ufoSound != null) ufoSound.play(sfxVolume);
    }

    public void playStatic() {
        if (staticSound != null) staticSound.play(sfxVolume);
    }

    public void stopMusic() {
        if (music != null) music.stop();
    }

    public void updateVolume() {
        if (music != null) music.setVolume(bgmVolume);
    }

    public void playJump() {
        if (jumpSound != null) {
            jumpSound.play(sfxVolume);
        }
    }

    // MEMORY OPTIMIZATION: Call this when the game closes
    public void dispose() {
        if (music != null) music.dispose();
        if (jumpSound != null) jumpSound.dispose();
        if (meteorSound != null) meteorSound.dispose();
        if (ufoSound != null) ufoSound.dispose();
        if (staticSound != null) staticSound.dispose();
    }
}
