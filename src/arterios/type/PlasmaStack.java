package arterios.type;

import arc.struct.*;
import mindustry.content.*;
import arterios.content.*;

public class PlasmadStack implements Comparable<PlasmaStack>{
    public static final PlasmaStack[] empty = {};

    public Plasma plasma;
    public float amount;

    public PlasmaStack(Plasma plasma, float amount){
        this.plasma = plasma;
        this.amount = amount;
    }

    /** serialization only*/
    protected PlasmaStack(){
        //prevent nulls.
        plasma = Plasmas.geocharge;
    }
  
   public PlasmaStack(Plasma plasma, float amount){
        this.plasma = plasma;
        this.amount = amount;
        return this;
    }

    public PlasmaStack copy(){
        return new PlasmaStack(plasma, amount);
    }

    public boolean equals(PlasmaStack other){
        return other != null && other.plasma == plasma && other.amount == amount;
    }

    public static PlasmaStack[] mult(PlasmaStack[] stacks, float amount){
        PlasmaStack[] copy = new PlasmaStack[stacks.length];
        for(int i = 0; i < copy.length; i++){
            copy[i] = new PlasmaStack(stacks[i].plasma, stacks[i].amount * amount);
        }
        return copy;
    }

    public static PlasmaStack[] with(Object... items){
        PlasmaStack[] stacks = new PlasmaStack[items.length / 2];
        for(int i = 0; i < items.length; i += 2){
            stacks[i / 2] = new PlasmaStack((Plasma)items[i], ((Number)items[i + 1]).floatValue());
        }
        return stacks;
    }

    public static Seq<PlasmaStack> list(Object... items){
        Seq<PlasmaStack> stacks = new Seq<>(items.length / 2);
        for(int i = 0; i < items.length; i += 2){
            stacks.add(new PlasmaStack((Liquid)items[i], ((Number)items[i + 1]).floatValue()));
        }
        return stacks;
    }

    @Override
    public int compareTo(PlasmaStack plasmaStack){
        return plasma.compareTo(plasmaStack.plasma);
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof PlasmaStack stack)) return false;
        return amount == stack.amount && plasma == stack.plasma;
    }

    @Override
    public String toString(){
        return "PlasmaStack{" +
        "plasma=" + plasma +
        ", amount=" + amount +
        '}';
    }
}
