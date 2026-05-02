package Core;
import Races.RaceType;
import Classes.CharClass;

public class CharacterBuilder {

    private static final RaceType.Type[] RACES = {
            RaceType.Type.TIKBALANG,
            RaceType.Type.KAPRE,
            RaceType.Type.MANANANGGAL
    };

    private static final CharClass.Type[][] CLASSES = {
            { CharClass.Type.ARCHER,  CharClass.Type.SPEARMAN },
            { CharClass.Type.GUNMAN,  CharClass.Type.DRUID    },
            { CharClass.Type.MAGE,    CharClass.Type.ASSASSIN }
    };

    public static PlayerCharacter build(String name, int raceChoice, int classChoice) {
        RaceType race = new RaceType(RACES[raceChoice - 1]);
        CharClass cls  = new CharClass(CLASSES[raceChoice - 1][classChoice - 1]);
        return new PlayerCharacter(name, race, cls);
    }
}