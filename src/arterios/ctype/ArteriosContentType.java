package arterios.ctype;

import arc.util.*;
import mindustry.ai.*;
import mindustry.entities.bullet.*;
import mindustry.type.*;
import mindustry.world.*;

/** Do not rearrange, ever! */
public enum ArteriosContentType{
    plasma(Plasma.class),

    public static final ArteriosContentType[] all = values();

    public final @Nullable Class<? extends Content> contentClass;

    ArteriosContentType(Class<? extends Content> contentClass){
        this.contentClass = contentClass;
    }
}
