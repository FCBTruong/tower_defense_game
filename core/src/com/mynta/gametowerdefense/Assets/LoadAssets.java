package com.mynta.gametowerdefense.Assets;

public class LoadAssets {
    public static boolean LoadToProject() {
        WitchAssets.LoadToProject();
        BirdAssets.LoadToProject();
        WindmillAssets.LoadToProject();
        FlyMonsterAssets.LoadToProject();
        TowerAssets.LoadToProject();
        Weapons.LoadToProject();
        CommonAssets.LoadToProject();
        ArcherAssets.LoadToProject();
        BigEnemyAssets.LoadToProject();
        FlagsLevelAssets.LoadToProject();
        MapAssets.ManagerLoad();
        MapAssets.LoadToProject();
        ApprenticeMageAssets.LoadToProject();
        SoundAssets.LoadToProject();
        ArmyInfantryAssets.LoadToProject();
        return true;
    }

    public static void ManagerLoad(){
        MapAssets.ManagerLoad();
        ArcherAssets.ManagerLoad();
        BigEnemyAssets.ManagerLoad();
        BirdAssets.ManagerLoad();
        FlyMonsterAssets.ManagerLoad();
        CommonAssets.ManagerLoad();
        TowerAssets.ManagerLoad();
        Weapons.ManagerLoad();
        WindmillAssets.ManagerLoad();
        WitchAssets.ManagerLoad();
        FlagsLevelAssets.ManagerLoad();
        ApprenticeMageAssets.ManagerLoad();
        SoundAssets.ManagerLoad();
        ArmyInfantryAssets.ManagerLoad();
    }
}
