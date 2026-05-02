package Classes;
import Core.Enemy;
import Core.ClassArchetype;
import java.util.Random;

public class CharClass implements ClassArchetype {

    public enum Type {
        ARCHER   (70,  85),
        SPEARMAN (90,  75),
        GUNMAN   (80,  70),
        DRUID    (100, 85),
        MAGE     (75,  100),
        ASSASSIN (85,  80);

        final int bonusHp, bonusMana;
        Type(int hp, int mana) {
            this.bonusHp = hp;
            this.bonusMana = mana;
        }
    }

    private final Type type;
    private int specialBonusDamage = 0;

    public CharClass(Type type) {
        this.type = type;
    }

    @Override
    public int getBonusHp() { return type.bonusHp; }

    @Override
    public int getBonusMana() { return type.bonusMana; }

    @Override
    public String getClassName() {
        String name = type.name();
        return name.charAt(0) + name.substring(1).toLowerCase();
    }

    @Override
    public void useSkill(String playerName, Enemy target) {
        int dmg = new Random().nextInt(11) + 15;
        int net = Math.max(1, dmg - target.defense);
        target.hp -= net;
        System.out.println(playerName + " uses " + getClassName() + " Skill! Deals " + net + " damage!");
    }

    @Override
    public void useSpecial(String playerName, Enemy target) {
        int dmg = new Random().nextInt(31) + 25 + specialBonusDamage;
        int net = Math.max(1, dmg - target.defense);
        target.hp -= net;
        System.out.println(playerName + " uses " + getClassName() + " Special! Deals " + net + " damage!");
    }

    @Override
    public int getSkillManaCost()   { return 20; }

    @Override
    public int getSpecialManaCost() { return 40; }

    @Override
    public int getSkillCooldown()   { return 2; }

    @Override
    public int getSpecialCooldown() { return 3; }

    @Override
    public void increaseSpecialDamage(int amount) { specialBonusDamage += amount; }
}