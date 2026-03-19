package io.github.DKICooked;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public class Assets {
    // MUSIC
    public static final String MENU_MUSIC = "audio/music/menuMusic.wav";

    // SOUNDS
    public static final String JUMP_SOUND = "audio/sfx/jump.wav";
    public static final String SPLAT_SOUND = "audio/sfx/splat.wav";
    public static final String DEATH_SOUND = "audio/sfx/death.wav";

    // --- UI TEXTURES ---
    public static final String START_BTN = "Start.png";
    public static final String START_BTN_HOV = "Start_pressed.png";
    public static final String TUT_BTN = "tutorial.png";
    public static final String TUT_BTN_HOV = "Tutorial_pressed.png";
    public static final String SET_BTN = "settings.png";
    public static final String SET_BTN_HOV = "Setting_pressed.png";
    public static final String EXIT_BTN = "exit.png";
    public static final String EXIT_BTN_HOV = "exit_pressed.png";

    // --- GAME TEXTURES ---
    public static final String TITLE_LOGO = "toyour.png";
    public static final String SUBTITLE_LOGO = "Infinity.png";
    public static final String WALL_TILE = "wallTile.png";
    public static final String PLAYER_DEAD = "dead.png";
    public static final String PAUSE_BTN = "Pause.png";
    public static final String RETRY_BTN = "retry.png";
    public static final String GAMEOVER_TITLE = "GO.png";


    // Add the rest of your textures (tutorial, settings, etc.) here...

    public static void load(AssetManager am) {
        am.load(MENU_MUSIC, Music.class);
        am.load(JUMP_SOUND, Sound.class);
        am.load(DEATH_SOUND, Sound.class);
        am.load(START_BTN, Texture.class);
        am.load(SPLAT_SOUND, Sound.class);
        am.load(START_BTN_HOV, Texture.class);
        am.load(EXIT_BTN, Texture.class);
        am.load(EXIT_BTN_HOV, Texture.class);
        am.load(PLAYER_DEAD, Texture.class);
        am.load(TITLE_LOGO, Texture.class);
        am.load(TUT_BTN, Texture.class);
        am.load(TUT_BTN_HOV, Texture.class);
        am.load(SET_BTN, Texture.class);
        am.load(SET_BTN_HOV, Texture.class);
        am.load(SUBTITLE_LOGO, Texture.class);
        am.load(WALL_TILE, Texture.class);
        am.load(PAUSE_BTN, Texture.class);
        am.load(RETRY_BTN, Texture.class);
        am.load(GAMEOVER_TITLE, Texture.class);
    }
}
