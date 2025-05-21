package arterios.content;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import arc.struct.*;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.part.*;
import mindustry.entities.pattern.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.type.unit.MissileUnitType;
import mindustry.world.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.heat.*;
import mindustry.world.blocks.liquid.*;
import mindustry.world.blocks.logic.*;
import mindustry.world.blocks.payloads.*;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.storage.*;
import mindustry.world.blocks.units.*;
import mindustry.world.consumers.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;
import static mindustry.type.ItemStack.*;
import arterios.*;

public class ArteriosBlocks {
    public static Block
    // Environment
      // Ores
      wallTinOre, cadmiumOre,
      // Floors
      tealite, obsidian, obsidianMagmaI, obsidianMagmaII,
      // Walls
      tealiteWall, obsidianWall,
    // Turrets
    jolt, kindle,
    // Walls
    tinWall, tinWallLarge;

  
  public static void load(){
      // Environment
        wallTinOre = new StaticWall("wall-tin-ore"){{
            itemDrop = ArteriosItems.tin;
            variants = 3;
        }};

        cadmiumOre = new OreBlock("cadmium-ore", ArteriosItems.cadmium){{
         variants = 3;
        }};
      
        tealite = new Floor("tealite"){{
            variants = 3;
        }};
      
        obsidian = new Floor("obsidian"){{
            variants = 4;
        }};

        obsidianMagmaI = new Floor("obsidian-magma-i"){{
            variants = 2;
            attributes.set(Attribute.heat, 0.66f); 
        }};
      
        obsidianMagmaII = new Floor("obsidian-magma-ii"){{
            variants = 2;
            attributes.set(Attribute.heat, 1f); 
        }};

        tealiteWall = new StaticWall("tealite-wall"){{
            variants = 3;
        }};
      
        obsidianWall = new StaticWall("obsidian-wall"){{
            variants = 2;
        }};
      // Turrets
      jolt = new ItemTurret("jolt"){{
          requirements(Category.turret, with(ArteriosItems.cadmium, 60, ArteriosItems.tin, 30, ArteriosItems.gunmetal, 30));
          shootSound = Sounds.lasershoot;
          drawer = new DrawTurret("cadmium-");
          size = 2;
          outlineColor = Color.valueOf("#100f13");
          shootY = -2;
          reload = 50f;
          shootCone = 0;
          scaledHealth = 140;
          rotateSpeed = 4;
          researchCostMultiplier = 0.05f;
          targetUnderBlocks = false;
          ammo(
                  ArteriosItems.cadmium, new BasicBulletType(6.5f,20){{
                      width = 6f;
                      hitSize = 7f;
                      height = 16f;
                      pierceCap = 3;
                      pierce = true;
                      pierceBuilding = true;
                      hitColor = backColor = trailColor = Color.valueOf("#865a87");

                  }},
          );

      }};
      
      // Walls
      tinWall = new Wall("tin-wall"){{
        requirements(Category.defense, with(ArteriosItems.tin, 6));
        researchCost = with(ArteriosItems.tin, 50);
        health = 320;
        armor = 3;
      }};
    
      tinWallLarge = new Wall("tin-wall-large"){{
        requirements(Category.defense, with(ArteriosItems.tin, 24));
        size = 2;
        researchCost = with(ArteriosItems.tin, 200);
        health = 1280;
        armor = 3;
      }};
    }
}
