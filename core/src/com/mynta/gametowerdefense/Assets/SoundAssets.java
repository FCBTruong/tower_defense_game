package com.mynta.gametowerdefense.Assets;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.mynta.gametowerdefense.MyGame;

public class SoundAssets extends Assets{
    public static Sound touchSound;
    public static Sound arrowSound;
    public static Music music;
    public static Sound swordSound;
    public static Sound loseSound;
    public static Sound thunderSound;
    public static Sound fireSound;

    public static void LoadToProject() {
      touchSound = MyGame.manager.get("Sound/touchSound.mp3");
      arrowSound = MyGame.manager.get("Sound/arrowSound.wav");
      music = MyGame.manager.get("Sound/music.mp3");
      swordSound = MyGame.manager.get("Sound/swordSound.wav");
      loseSound = MyGame.manager.get("Sound/lose.mp3");
      thunderSound = MyGame.manager.get("Sound/thunderSound.mp3");
      fireSound = MyGame.manager.get("Sound/fireSound.mp3");
    }

    public static void ManagerLoad() {
      MyGame.manager.load("Sound/touchSound.mp3", Sound.class);
      MyGame.manager.load("Sound/music.mp3", Music.class);
      MyGame.manager.load("Sound/arrowSound.wav",Sound.class);
      MyGame.manager.load("Sound/swordSound.wav",Sound.class);
      MyGame.manager.load("Sound/lose.mp3",Sound.class);
      MyGame.manager.load("Sound/thunderSound.mp3",Sound.class);
      MyGame.manager.load("Sound/fireSound.mp3",Sound.class);
    }

    public static void Clean(){
        touchSound.dispose();
        arrowSound.dispose();
        music.dispose();
        swordSound.dispose();
        loseSound.dispose();
        thunderSound.dispose();
        fireSound.dispose();
    }
}
