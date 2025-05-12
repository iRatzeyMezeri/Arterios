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

public class ArteriosMod extends Mod{

    public ArteriosMod(){
        Log.info("Loaded ArteriosMod constructor.");
    }

    @Override
    public void loadContent(){
        ArteriosItems.load();
        ArteriosBlocks.load();
    }

}
