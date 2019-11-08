package com.mynta.gametowerdefense.Assets;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.mynta.gametowerdefense.MyGame;

public class SoundAssets extends Assets{
    public static Sound touchSound;
    public static Sound arrowSound;
    public static Music music;

    public static void LoadToProject() {
      touchSound = MyGame.manager.get("Sound/touchSound.mp3");
      arrowSound = MyGame.manager.get("Sound/arrowSound.wav");
      music = MyGame.manager.get("Sound/music.mp3");
    }

    public static void ManagerLoad() {
      MyGame.manager.load("Sound/touchSound.mp3", Sound.class);
      MyGame.manager.load("Sound/music.mp3", Music.class);
      MyGame.manager.load("Sound/arrowSound.wav",Sound.class);
    }

    public static void Clean(){
        touchSound.dispose();
        arrowSound.dispose();
        music.dispose();
    }
}
