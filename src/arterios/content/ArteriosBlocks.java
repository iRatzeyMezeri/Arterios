package arterios.content;

import arc.graphics.*;
import mindustry.content.*;
import mindustry.entities.bullet.*;
import mindustry.entities.part.*;
import mindustry.entities.pattern.*;
import mindustry.gen.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.environment.*;
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
      obsidianMagmaI, obsidianMagmaII, obsidian, tachylite, roughTachylite, sodalite, tealite, cassiterite, sphalerite, purpurite,
      // Walls
      obsidianWall, tachyliteWall, sodaliteWall, tealiteWall, cassiteriteWall, sphaleriteWall, purpuriteWall, geochargedObsidian, geochargedTachylite, geochargedSodalite, geochargedCassiterite, geochargedPurpurite,
      // Boulders
      obsidianBoulder, tachyliteBoulder, sodaliteBoulder, cassiteriteBoulder, purpuriteBoulder,
      // Tall Blocks
      crystalSodalite,
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
      
        obsidianMagmaI = new Floor("obsidian-magma-i"){{
            variants = 2;
            attributes.set(Attribute.heat, 0.66f); 
        }};
      
        obsidianMagmaII = new Floor("obsidian-magma-ii"){{
            variants = 3;
            attributes.set(Attribute.heat, 1f); 
        }};
      
        obsidian = new Floor("obsidian"){{
            variants = 4;
        }};
      
        tachylite = new Floor("tachylite"){{
            variants = 3;
        }};
      
        roughTachylite = new Floor("rough-tachylite"){{
            variants = 3;
        }};
      
        sodalite = new Floor("sodalite"){{
            variants = 3;
        }};
      
        tealite = new Floor("tealite"){{
            variants = 3;
        }};
      
        cassiterite = new Floor("cassiterite"){{
            variants = 4;
        }};
      
        sphalerite = new Floor("sphalerite"){{
            variants = 4;
        }};
      
        purpurite = new Floor("purpurite"){{
            variants = 3;
        }};
      
        obsidianWall = new StaticWall("obsidian-wall"){{
            variants = 2;
        }};
      
        tachyliteWall = new StaticWall("tachylite-wall"){{
            variants = 2;
        }};
      
        sodaliteWall = new StaticWall("sodalite-wall"){{
            variants = 2;
        }};
      
        tealiteWall = new StaticWall("tealite-wall"){{
            variants = 3;
        }};
      
        cassiteriteWall = new StaticWall("cassiterite-wall"){{
            variants = 3;
        }};
      
        sphaleriteWall = new StaticWall("sphalerite-wall"){{
            variants = 2;
        }};
      
        purpuriteWall = new StaticWall("purpurite-wall"){{
            variants = 2;
        }};

        geochargedObsidian = new StaticWall("geocharged-obsidian"){{
            variants = 2;
        }};

        geochargedTachylite = new StaticWall("geocharged-tachylite"){{
            variants = 2;
        }};

        geochargedSodalite = new StaticWall("geocharged-sodalite"){{
            variants = 2;
        }};

        geochargedCassiterite = new StaticWall("geocharged-cassiterite"){{
            variants = 2;
        }};

        geochargedPurpurite = new StaticWall("geocharged-purpurite"){{
            variants = 2;
        }};
      
        obsidianBoulder = new Prop("obsidian-boulder"){{
            variants = 2;
            obsidian.asFloor().decoration = this;
            breakSound = Sounds.rockBreak;
        }};
      
        tachyliteBoulder = new Prop("tachylite-boulder"){{
            variants = 2;
            tachylite.asFloor().decoration = this;
            roughTachylite.asFloor().decoration = this;
            breakSound = Sounds.rockBreak;
        }};
      
        sodaliteBoulder = new Prop("sodalite-boulder"){{
            variants = 2;
            sodalite.asFloor().decoration = this;
            breakSound = Sounds.rockBreak;
        }};
      
        cassiteriteBoulder = new Prop("cassiterite-boulder"){{
            variants = 2;
            cassiterite.asFloor().decoration = this;
            breakSound = Sounds.rockBreak;
        }};
      
        purpuriteBoulder = new Prop("purpurite-boulder"){{
            variants = 2;
            purpurite.asFloor().decoration = this;
            breakSound = Sounds.rockBreak;
        }};

        crystalSodalite = new TallBlock("crystal-sodalite"){{
            variants = 2;
            clipSize = 128f;
        }};

        // Turrets
        jolt = new ItemTurret("jolt"){{
            requirements(Category.turret, with(ArteriosItems.cadmium, 60, ArteriosItems.tin, 30, ArteriosItems.gunmetal, 30));
            shootSound = Sounds.lasershoot;
            size = 2;
            outlineColor = APal.darkOutline;
            shootY = 2;
            reload = 50f;
            scaledHealth = 140;
            rotateSpeed = 4;
            researchCostMultiplier = 0.05f;
            targetUnderBlocks = false;

            shoot = new ShootBarrel(){{
                barrels = new float[]{
                        -3, 0, 0,
                        3, 0, 0
                };
                shots = 2;
                shotDelay = 0;
            }};

            ammo(
                ArteriosItems.cadmium, new BasicBulletType(5f,20){{
                    width = 6f;
                    hitSize = 7f;
                    height = 16f;
                    pierceCap = 3;
                    pierce = true;
                    pierceBuilding = true;
                    hitColor = backColor = trailColor = Color.valueOf("#aa7aaa");
                    shootEffect = Fx.shootSmallColor.wrap(Color.valueOf("#aa7aaa"));
                    frontColor = Color.white;

                    intervalBullet = new LightningBulletType(){{
                        damage = 5;
                        lightningColor = Color.valueOf("#aa7aaa");
                        lightningLength = 8;

                        lightningType = new BulletType(0.0001f, 0f){{
                            lifetime = Fx.lightning.lifetime;
                            despawnEffect = Fx.none;
                            status = StatusEffects.shocked;
                            statusDuration = 10f;
                            hittable = false;
                            lightColor = Color.white;
                        }};
                    }};
                    bulletInterval = 4f;
                    intervalAngle = 180;
                    intervalRandomSpread = 0;
                }}
            );

            drawer = new DrawTurret("cadmium-"){{
                parts.addAll(
                        new RegionPart("-blade"){{
                            progress = PartProgress.recoil;
                            moveY = -3;
                            mirror = true;
                            turretShading = true;
                            layerOffset = -0.01f;
                        }},
                        new RegionPart("-panel"){{
                            progress = PartProgress.recoil;
                            moveX = 0.5f;
                            moveY = -0.5f;
                            mirror = true;
                            turretShading = true;
                        }}
                );
            }};;
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
