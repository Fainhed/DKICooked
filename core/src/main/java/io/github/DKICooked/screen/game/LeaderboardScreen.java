package io.github.DKICooked.screen.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;
import io.github.DKICooked.Main;
import io.github.DKICooked.entities.LBScore;
import io.github.DKICooked.gameLogic.SaveData;
import io.github.DKICooked.gameLogic.SaveManager;
import io.github.DKICooked.screen.BaseScreen;
import io.github.DKICooked.screen.main.MainMenuScreen;

public class LeaderboardScreen extends BaseScreen {
    private final Main main;
    private BitmapFont customFont; // Declared here for class-wide use
    private Texture lbPic;

    public LeaderboardScreen(Main main) {
        this.main = main;

        // 1. Initialize assets
        createFonts();
        this.lbPic = new Texture(Gdx.files.internal("LB.png"));

        // 2. Set input processor so buttons work
        Gdx.input.setInputProcessor(stage);

        setupUI();
    }

    private void createFonts() {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("new_font.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();

        parameter.size = 22; // Adjusted size for list readability
        parameter.color = Color.WHITE;
        parameter.shadowOffsetX = 2;
        parameter.shadowOffsetY = 2;
        parameter.shadowColor = new Color(0, 0, 0, 0.5f);

        customFont = generator.generateFont(parameter);
        generator.dispose();
    }

    private void setupUI() {
        Table root = new Table();
        root.setFillParent(true);
        stage.addActor(root);

        // --- Header ---
        Image titleImage = new Image(lbPic);
        root.add(titleImage).size(500, 155).padBottom(-10).row();

        // --- Leaderboard Table ---
        Table scoreTable = new Table();
        // scoreTable.debug(); // Uncomment this line to see the grid lines for alignment debugging

        titleImage.addAction(
            Actions.forever(
                Actions.sequence(
                    // Move UP 10 pixels over 0.7 seconds
                    Actions.moveBy(0, 10, 0.7f),
                    // Move DOWN 10 pixels over 0.7 seconds
                    Actions.moveBy(0, -10, 0.7f)
                )
            )
        );

        SaveData data = SaveManager.load();
        Label.LabelStyle whiteStyle = new Label.LabelStyle(customFont, Color.WHITE);
        Label.LabelStyle goldStyle = new Label.LabelStyle(customFont, Color.valueOf("fed546"));

        for (int i = 0; i < data.leaderBoard.size; i++) {
            LBScore entry = data.leaderBoard.get(i);
            Label.LabelStyle currentStyle = (i == 0) ? goldStyle : whiteStyle;

            // 1. Rank + Name (Combined or separate)
            scoreTable.add(new Label((i + 1) + ". " + entry.name, currentStyle)).left();

            // 2. The Dots
            // Use a smaller string of dots and tell it to expand to fill the middle
            Label dots = new Label(". . . . . . . . .", currentStyle);
            dots.setAlignment(Align.center);

            // expandX() is the magic—it pushes the name left and the score right
            scoreTable.add(dots).expandX().fillX().padRight(10);

            // 3. The Score
            scoreTable.add(new Label(entry.score + "m", currentStyle)).right();

            // 4. Move to the next line for the next player
            scoreTable.row().padBottom(10);
        }

        // Add the score list to the root with some side padding
        root.add(scoreTable).width(500).padTop(-20).padBottom(-10).row();

        // --- Navigation ---
        TextButton.TextButtonStyle btnStyle = new TextButton.TextButtonStyle();
        btnStyle.font = customFont;
        btnStyle.fontColor = Color.WHITE;
        btnStyle.overFontColor = Color.valueOf("fed546");

        TextButton backBtn = new TextButton("BACK TO MENU", btnStyle);
        backBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                main.setScreen(new MainMenuScreen(main));
            }
        });
        root.add(backBtn).size(250, 60);
    }

    @Override
    public void render(float delta) {
        // Dark space theme background
        ScreenUtils.clear(0.05f, 0.05f, 0.08f, 1f);
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void dispose() {
        if (customFont != null) customFont.dispose();
        if (lbPic != null) lbPic.dispose();
        super.dispose();
    }
}
