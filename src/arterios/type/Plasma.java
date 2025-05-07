package arterios.type;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.struct.*;
import arc.util.*;
import mindustry.content.*;
import mindustry.ctype.*;
import mindustry.entities.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.logic.*;
import mindustry.world.*;
import mindustry.world.meta.*;
import arterios.ctype.*;

import static mindustry.entities.bullet.*;

/** A better name for this class would be "fluid", but it's too late for that. */
public class Plasma extends UnlockableContent implements Senseable{
    //must be static and global so conduits don't conflict - DO NOT INTERACT WITH THESE IN MODS OR I WILL PERSONALLY YELL AT YOU
    public static final int animationFrames = 50;
    public static float animationScalePlasma = 140f;

    protected static final Rand rand = new Rand();

    /** Color used in pipes and on the ground. */
    public Color color;
    /** Color used in bars. */
    public @Nullable Color barColor;
    /** Color used to draw lights. Note that the alpha channel is used to dictate brightness. */
    public Color lightColor = Color.clear.cpy();
    /** temperature: 0.5 is 'room' temperature, 0 is very cold, 1 is molten hot */
    public float temperature = 0.5f;
    /** how much heat this plasma can store. 0.4=water (decent), anything lower is probably less dense and bad at cooling. */
    public float heatCapacity = 0.5f;
    /** how violent this plasma is. 0.3=geocharge. */
    public float violence = 0.5f;
    /** how prone to exploding this plasma is, when heated. 0 = nothing, 1 = nuke */
    public float explosiveness;
    /** whether this plasma reacts in blocks at all */
    public boolean blockReactive = true;
    /** if false, this plasma cannot be a coolant */
    public boolean coolant = true;
    /** if true, this plasma can be incinerated in the incinerator block. */
    public boolean incinerable = true;
    /** The associated status effect. */
    public StatusEffect effect = StatusEffects.none;
    /** Effect shown when leaking. */
    public Effect particleEffect = Fx.none;
    /** Particle effect rate spacing in ticks. */
    public float particleSpacing = 60f;
    /** If true, this plasma is hidden in most UI. */
    public boolean hidden;
    /** Projectile created by the plasma when leaking. */
    public BulletType leakEffect = LightningBulletType(){
        damage = 1f;
        speed = 0f;
        lifetime = 1;
        despawnEffect = Fx.none;
        hitEffect = Fx.hitLancer;
        keepVelocity = false;
        hittable = false;
        //for stats
        status = StatusEffects.shocked;
        lightningLength = 25;
        lightningLengthRand = 0;
        lightningColor = Pal.lancerLaser;
    };

    public Plasma(String name, Color color){
        super(name);
        this.color = new Color(color);
    }

    /** For modding only.*/
    public Plasma(String name){
        this(name, new Color(Color.black));
    }

    @Override
    public boolean isHidden(){
        return hidden;
    }

    public int getAnimationFrame(){
        return (int)(Time.time / animationScalePlasma * animationFrames + id*5) % animationFrames;
    }

    public Color barColor(){
        return barColor == null ? color : barColor;
    }

    @Override
    public void setStats(){
        stats.addPercent(Stat.explosiveness, explosiveness);
        stats.addPercent(Stat.temperature, temperature);
        stats.addPercent(Stat.heatCapacity, heatCapacity);
        stats.addPercent(Stat.violence, violence);
    }

    @Override
    public double sense(PAccess sensor){
        if(sensor == PAccess.color) return color.toDoubleBits();
        if(sensor == PAccess.id) return getLogicId();
        return Double.NaN;
    }

    @Override
    public Object senseObject(PAccess sensor){
        if(sensor == PAccess.name) return name;
        return noSensed;
    }

    @Override
    public String toString(){
        return localizedName;
    }

    @Override
    public ContentType getContentType(){
        return ContentType.plasma;
    }
}
