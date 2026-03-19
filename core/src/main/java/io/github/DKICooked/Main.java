package io.github.DKICooked;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import io.github.DKICooked.screen.main.MainMenuScreen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture image;
    private Screen currentScreen;

    public AssetManager manager;

    @Override
    public void create() {
        batch = new SpriteBatch();
        manager = new AssetManager();
        Assets.load(manager);

        manager.finishLoading();

        setScreen(new MainMenuScreen(this));
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);

        float delta = Gdx.graphics.getDeltaTime();
        currentScreen.render(delta);

        batch.begin();
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        currentScreen.resize(width, height);
    }

    public void setScreen(Screen newScreen) {
        if (currentScreen != null) currentScreen.hide();
        // Note: We DON'T call dispose() here anymore if assets are in the manager!
        currentScreen = newScreen;
        if (currentScreen != null) {
            currentScreen.show();
            currentScreen.resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        }
    }

    @Override
    public void dispose() {
        if (currentScreen != null) currentScreen.dispose();
        manager.dispose();
    }


}
