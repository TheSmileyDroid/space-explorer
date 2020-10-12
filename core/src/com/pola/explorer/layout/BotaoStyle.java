package com.pola.explorer.layout;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.pola.explorer.SpaceExplorer;

public class BotaoStyle extends TextButton.TextButtonStyle {
    public BotaoStyle(SpaceExplorer game){
        up = game.skin.getDrawable("button");
        font = game.font;
        down = game.skin.getDrawable("button-over");
        checked = game.skin.getDrawable("button");
        fontColor = Color.BLUE;
    }
}
