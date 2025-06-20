package arterios.entities.part;

import arc.Core;
import mindustry.entities.part.RegionPart;

public class SillyPart extends RegionPart {

    public SillyPart(String region){
        super(region);
        layerOffset = 1f;
    }

    @Override
    public void draw(PartParams params) {
        if(Core.settings.getBool("arterios-silly")){
            super.draw(params);
        }
    }
}
