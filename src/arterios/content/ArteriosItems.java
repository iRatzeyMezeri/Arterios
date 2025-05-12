package arterios.content;

import arc.graphics.*;
import arc.struct.*;
import mindustry.content.Items;
import mindustry.type.*;

public class ArteriosItems {
    public static Item
    tin, cadmium, gunmetal;

    public static final Seq<Item> arteriosItems = new Seq<>();

    public static void load() {
        tin = new Item("tin", Color.valueOf("#50b2aa")) {{
            hardness = 2;
            cost = 0.5f;
        }};

        cadmium = new Item("cadmium", Color.valueOf("#865a87")){{
            hardness = 2;
            cost = 0.5f;
        }};

        gunmetal = new Item("gunmetal", Color.valueOf("#d2ae42")){{
            cost = 0.5f;
        }};

        arteriosItems.addAll(
                tin, cadmium, gunmetal
        );
    }
}
