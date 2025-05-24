package arterios.content;

import mindustry.world.meta.*;
import arterios.content.ArteriosBlocks;

public class ArteriosAttributes {
    public static void load(){
        Attribute.add("geocharge");
    }

    public static void setAttributes(){
        ArteriosBlocks.geochargedObsidian.attributes.set(Attribute.get("geocharge"), 1);
        ArteriosBlocks.geochargedTachylite.attributes.set(Attribute.get("geocharge"), 1);
        ArteriosBlocks.geochargedSodalite.attributes.set(Attribute.get("geocharge"), 1);
        ArteriosBlocks.geochargedCassiterite.attributes.set(Attribute.get("geocharge"), 1);
        ArteriosBlocks.geochargedPurpurite.attributes.set(Attribute.get("geocharge"), 1);
    }
}
