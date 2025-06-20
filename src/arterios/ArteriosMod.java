package arterios;

import arc.*;
import arc.util.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import mindustry.mod.*;
import mindustry.ui.dialogs.*;
import arterios.content.*;

import static arc.Core.bundle;
import static mindustry.Vars.ui;

public class ArteriosMod extends Mod{

    public ArteriosMod(){
        Log.info("Loaded ArteriosMod constructor.");
    }

    @Override
    public void init() {
        super.init();
        ui.settings.addCategory(bundle.get("setting.arterios-category"), "arterios-settings-icon", t -> {
            t.checkPref("arterios-silly", false);
        });
    }

    @Override
    public void loadContent(){
        ArteriosItems.load();
        ArteriosAttributes.load();
        ArteriosUnits.load();
        ArteriosBlocks.load();
        ArteriosAttributes.setAttributes();
    }

}
