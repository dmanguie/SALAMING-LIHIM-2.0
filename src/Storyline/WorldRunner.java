package Storyline;
import Core.*;
import java.util.List;

public class WorldRunner {

    private record MissionData(
            EnemyType type,
            int count,
            boolean isBoss,
            String intro,
            String outro
    ) {}

    private static final List<MissionData> ALL_MISSIONS = List.of(

            // ── World 1 ──────────────────────────────────────────
            new MissionData(EnemyType.DUWENDE,    2, false,
                    "You enter the dark alleys of Biringan City...",
                    "The small creatures scatter. You move on."),

            new MissionData(EnemyType.TIYANAK,    2, false,
                    "A baby's cry echoes through the night...",
                    "Silence returns to the streets."),

            new MissionData(EnemyType.BUNGISNGIS, 1, true,
                    "⚠ BOSS: A massive laughing giant blocks your path!",
                    "The giant crashes to the ground. World 1 complete."),

            // ── World 2 ──────────────────────────────────────────
            new MissionData(EnemyType.ASWANG,     2, false,
                    "You venture into the cursed forest...",
                    "The Aswang retreats into the shadows."),

            new MissionData(EnemyType.SIGBIN,     2, false,
                    "Shadow-like creatures dart between the trees...",
                    "You press deeper into the forest."),

            new MissionData(EnemyType.BABAYLANS,  1, true,
                    "⚠ BOSS: The Babaylan raises her cursed staff!",
                    "Her curse is broken. World 2 complete."),

            // ── World 3 ──────────────────────────────────────────
            new MissionData(EnemyType.HUMANS,     2, false,
                    "Armed soldiers patrol the city gates...",
                    "You slip past the fallen guards."),

            new MissionData(EnemyType.TRIA,       1, true,
                    "⚠ BOSS: Tria steps out from the shadows, knives ready!",
                    "Tria stumbles back defeated."),

            new MissionData(EnemyType.ERIKA,      1, true,
                    "⚠ FINAL BOSS: Erika smiles coldly. 'You actually made it.'",
                    "Erika falls. It is finally over.")
    );

    public static boolean runAll(PlayerCharacter player) {
        BattleManager bm = new BattleManager();

        for (int i = 0; i < ALL_MISSIONS.size(); i++) {
            MissionData m = ALL_MISSIONS.get(i);
            int world = worldOf(i);
            int missionNum = (i % 3) + 1;

            System.out.println("\n╔══════════════════════════════════╗");
            System.out.println(  "║  World " + world + " — Mission " + missionNum + "                ║");
            System.out.println(  "╚══════════════════════════════════╝");
            System.out.println(m.intro());
            DialogueUtils.pause();

            List<Enemy> enemies = m.isBoss()
                    ? EnemyFactory.spawnBosses(m.type(), m.count())
                    : EnemyFactory.spawnEnemies(m.type(), m.count());

            boolean survived = bm.startBattle(player, enemies, world, m.isBoss());
            if (!survived) return false;

            System.out.println("\n" + m.outro());

            // Rest + Shop after last mission of each world
            if (i == 2 || i == 5 || i == 8) {
                player.rest();
                System.out.println("\n🛒 A shop appears nearby...");
                Shop.enterShop(player);
            }

            DialogueUtils.pause();
        }

        return true;
    }

    private static int worldOf(int missionIndex) {
        if (missionIndex < 3) return 1;
        if (missionIndex < 6) return 2;
        return 3;
    }
}