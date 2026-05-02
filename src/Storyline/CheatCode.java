package Storyline;
import Core.*;
import java.util.Scanner;

public class CheatCode {

    private static final String MAX_CODE   = "BIRINGAN999";
    private static final String SKIP1_CODE = "SW1";
    private static final String SKIP2_CODE = "SW2";

    private static int startFromMission = 0;

    public static void prompt(PlayerCharacter player) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║   Enter cheat code or press ENTER    ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.print(">> ");
        String input = sc.nextLine().trim().toUpperCase();

        if (input.isEmpty()) return;

        switch (input) {
            case MAX_CODE:
                applyMax(player);
                System.out.println("\n💀 CHEAT ACTIVATED: MAX EVERYTHING");
                System.out.println("   ✓ HP & Mana maxed");
                System.out.println("   ✓ 9999 Barya");
                System.out.println("   ✓ Max armor");
                System.out.println("   ✓ Pet with max healing");
                System.out.println("   ✓ Level 99");
                System.out.println("   ✓ Starting from World 1\n");
                break;

            case SKIP1_CODE:
                applyMax(player);
                startFromMission = 3;
                System.out.println("\n⏩ CHEAT ACTIVATED: SKIP TO WORLD 2");
                System.out.println("   ✓ All stats maxed");
                System.out.println("   ✓ Skipping World 1\n");
                break;

            case SKIP2_CODE:
                applyMax(player);
                startFromMission = 6;
                System.out.println("\n⏩ CHEAT ACTIVATED: SKIP TO WORLD 3");
                System.out.println("   ✓ All stats maxed");
                System.out.println("   ✓ Skipping World 1 & 2\n");
                break;

            default:
                System.out.println("\n❌ Invalid cheat code. Continuing normally.\n");
                break;
        }

        DialogueUtils.pause();
    }

    private static void applyMax(PlayerCharacter player) {
        // level up 98 times (from level 1 to 99)
        for (int i = 0; i < 98; i++) {
            player.levelUp();
        }

        // max barya
        player.setBarya(9999);

        // max armor (3 upgrades)
        int currentArmor = player.getArmorLevel();
        for (int i = currentArmor; i < 3; i++) {
            player.buyArmor();
        }

        // give pet + max food
        if (!player.hasPet()) {
            player.setPet(new Pet(5));
        }
        int currentFood = player.getPetFoodUsed();
        for (int i = currentFood; i < 4; i++) {
            player.getPet().increaseHealingPower(5);
            player.incrementPetFoodUsed();
        }

        // max special damage bonus
        player.classType.increaseSpecialDamage(999);

        // restore to full
        player.setHp(player.maxHp);
        player.setMana(player.maxMana);
    }

    public static int getStartFromMission() {
        return startFromMission;
    }
}