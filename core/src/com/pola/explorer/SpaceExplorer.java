package com.pola.explorer;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.pola.explorer.scenes.MainMenu;

public class SpaceExplorer extends Game {

    public Skin skin;
    public BitmapFont font;

    @Override
    public void create() {
        TextureAtlas atlas = new TextureAtlas("skin/neon-ui.atlas");
        font = new BitmapFont();
        skin = new Skin(atlas);
        this.setScreen(new MainMenu(this));
    }


    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {

    }
}
