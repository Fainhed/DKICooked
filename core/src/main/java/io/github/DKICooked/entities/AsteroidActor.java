package io.github.DKICooked.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class AsteroidActor extends Actor {
    private Texture texture;
    private TextureRegion region;
    private final float fallSpeedY;
    private final float fallSpeedX;

    public AsteroidActor(Texture texture, float startX, float startY) {
        this.region = new TextureRegion(texture);
        setX(startX);
        setY(startY);
        setSize(64, 64);
        setOrigin(getWidth() / 2f, getHeight() / 2f);

        this.fallSpeedY = 300f + (float)Math.random() * 200f;

        this.fallSpeedX = -150f - MathUtils.random(100f);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        // Update both X and Y for the diagonal slide
        setX(getX() + fallSpeedX * delta);
        setY(getY() - fallSpeedY * delta);

        setRotation(getRotation() + 2);

        // Clean up if it leaves the screen (left side or bottom)
        if (getX() < -100 || (getStage() != null && getY() < getStage().getCamera().position.y - 400)) {
            remove();
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        // Draw with rotation centered
        batch.draw(region,
            getX(), getY(),
            getOriginX(), getOriginY(),
            getWidth(), getHeight(),
            getScaleX(), getScaleY(),
            getRotation(), false);
    }
}
