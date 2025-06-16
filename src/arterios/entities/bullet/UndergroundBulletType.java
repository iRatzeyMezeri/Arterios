package arterios.entities.bullet;

import arc.graphics.g2d.Draw;
import mindustry.Vars;
import mindustry.content.Fx;
import mindustry.entities.Effect;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.gen.Bullet;
import mindustry.graphics.Layer;

public class UndergroundBulletType extends BasicBulletType {

    Effect undergroundEffect = Fx.breakProp;
    float undergroundInterval = 5f;
    float damageDecreasePercent = 0.6f;

    public UndergroundBulletType(float speed, float damage) {
        super(speed, damage);
        underwater = true;
        layer = Layer.scorch;
        collideFloor = false;
        collidesAir = false;
        collidesGround = true;
    }

    @Override
    public void draw(Bullet b) {
        if(isUnderground(b)){
            if(b.timer(0, undergroundInterval)){
                undergroundEffect.wrap(Vars.world.floor(b.tileX(), b.tileY()).mapColor).at(b.x, b.y);
            }
        }else{
            super.draw(b);
        }
    }



    @Override
    public float damageMultiplier(Bullet b) {
        return super.damageMultiplier(b) * (isUnderground(b) ? damageDecreasePercent : 1f);
    }

    public boolean isUnderground(Bullet b){
        return Vars.world.floor(b.tileX(), b.tileY()).hasSurface();
    }
}
