package com.pola.explorer.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.pola.explorer.SpaceExplorer;
import com.pola.explorer.layout.BotaoStyle;

public class MainMenu implements Screen {

    final SpaceExplorer game;
    private final Stage stage;
    private final Table table;
    private final TextButton button;

    public MainMenu(final SpaceExplorer game) {
        this.game = game;
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

        //table.setDebug(true);

        table.setSkin(game.skin);

        Label text = new Label("Space Explorer", new LabelStyle(game.font, Color.WHITE));


        button = new TextButton("Jogar", new BotaoStyle(game));

        table.add(text);
        table.row();
        table.add(button);
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
        if (button.isPressed()) {
            game.setScreen(new GameScreen(game));
        }
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
