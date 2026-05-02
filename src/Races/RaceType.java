package Races;
import Core.Race;
import java.util.Random;

public class RaceType extends Race {

    public enum Type {
        TIKBALANG   (95,  80,  "charges with thunderous hooves!"),
        KAPRE       (100, 70,  "engulfs the enemy with smoke!"),
        MANANANGGAL (90,  100, "swoops down with razor-sharp claws!");

        final int baseHp, baseMana;
        final String attackDesc;

        Type(int hp, int mana, String desc) {
            this.baseHp = hp;
            this.baseMana = mana;
            this.attackDesc = desc;
        }
    }

    private final Type type;

    public RaceType(Type type) {
        this.type = type;
    }

    @Override
    public int getBaseHp() { return type.baseHp; }

    @Override
    public int getBaseMana() { return type.baseMana; }

    @Override
    public String getRaceName() {
        String name = type.name();
        return name.charAt(0) + name.substring(1).toLowerCase();
    }

    @Override
    public String getAttackDesc() { return type.attackDesc; }

    @Override
    public int attack() { return new Random().nextInt(11) + 5; }
}