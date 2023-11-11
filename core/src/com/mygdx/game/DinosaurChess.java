package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;



public class DinosaurChess extends ApplicationAdapter {
    SpriteBatch batch;
    Texture img;

    Music menuMusic;


    @Override
    public void create () {
        batch = new SpriteBatch();
        img = new Texture("titleArt.png");
        menuMusic = Gdx.audio.newMusic(Gdx.files.internal("assets/music/menu.mp3"));
        menuMusic.setLooping(true);
        menuMusic.setVolume(0.5f); // Adjust the volume as needed
        menuMusic.play();
    }

    @Override
    public void render() {
        ScreenUtils.clear(Color.YELLOW); // Set the background color to yellow

        batch.begin();

        // Calculate the new size of the image (half of the screen height and proportional)
        float halfHeight = Gdx.graphics.getHeight() / 2f;
        float aspectRatio = (float) img.getWidth() / img.getHeight();
        float halfWidth = halfHeight * aspectRatio;

        // Center the image on the screen
        float x = (Gdx.graphics.getWidth() - halfWidth) / 2f;
        float y = (Gdx.graphics.getHeight() - halfHeight) / 2f;

        // Print float values to the system console
        System.out.println("x: " + x);
        System.out.println("y: " + y);

        // Draw the resized image
        batch.draw(img, x, y, halfWidth, halfHeight);

        // Set up a BitmapFont for drawing text
        BitmapFont font = new BitmapFont();
        font.setColor(Color.BLACK);
        font.getData().setScale(3); // Adjust the scale as needed (increase for bigger text)

        // Draw the text "Dinosaur Chess" centered below the image
        GlyphLayout layout = new GlyphLayout(font, "Dinosaur Chess");
        float textX = (Gdx.graphics.getWidth() - layout.width) / 2f;
        float textY = y - layout.height * 2; // Adjust this value as needed
        font.draw(batch, layout, textX, textY);

        batch.end();
    }



    @Override
    public void dispose () {
        batch.dispose();
        img.dispose();
        menuMusic.dispose();
    }
}


/*
// TitleScreen.java
public class TitleScreen extends DinosaurChess {

    public TitleScreen(Game game) {
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    @Override
    public void show() {
        // Initialize title screen assets and resources here
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Render title screen here

        if (TimeUtils.timeSinceMillis(startTime) > 4000) {
            game.setScreen(new MenuScreen(game));
        }
    }

    @Override
    public void resize(int width, int height) {
        camera.setToOrtho(false, width, height);
    }

    // Other Screen methods...

}

// MenuScreen.java
public class MenuScreen implements Screen {
    private Game game;
    private Stage stage;
    private TextButton playButton, howToPlayButton, settingsButton;

    public MenuScreen(Game game) {
        this.game = game;
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        // Initialize menu screen assets and resources here

        // Create buttons
        playButton = new TextButton("Play", skin);
        howToPlayButton = new TextButton("How to Play", skin);
        settingsButton = new TextButton("Settings", skin);

        // Set button positions and add them to the stage
        // (You need to set up a skin for the buttons or customize their appearance)

        // Add click listeners to the buttons
        playButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new PlayScreen(game));
            }
        });

        howToPlayButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new HowToPlayScreen(game));
            }
        });

        settingsButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new SettingsScreen(game));
            }
        });

        // Add buttons to the stage
        stage.addActor(playButton);
        stage.addActor(howToPlayButton);
        stage.addActor(settingsButton);
    }

    @Override
    public void show() {
        // Other initialization code
    }

    @Override
    public void render(float delta) {
        // Other rendering code

        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    // Other Screen methods...

}

*/