package Storyline;
import Core.CharacterBuilder;
import Core.PlayerCharacter;
import java.util.Scanner;

public class PlayerSelection {

    public static PlayerCharacter createPlayer() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n╔══════════════════════════════╗");
        System.out.println("║       Choose Your Race       ║");
        System.out.println("║  [1] Tikbalang               ║");
        System.out.println("║  [2] Kapre                   ║");
        System.out.println("║  [3] Manananggal             ║");
        System.out.println("╚══════════════════════════════╝");
        System.out.print(">> ");
        int race = sc.nextInt();

        System.out.println("\n╔══════════════════════════════╗");
        if (race == 1) {
            System.out.println("║  [1] Archer  [2] Spearman    ║");
        } else if (race == 2) {
            System.out.println("║  [1] Gunman  [2] Druid        ║");
        } else {
            System.out.println("║  [1] Mage    [2] Assassin     ║");
        }
        System.out.println("╚══════════════════════════════╝");
        System.out.print(">> ");
        int cls = sc.nextInt();
        sc.nextLine();

        System.out.print("\nEnter your name: ");
        String name = sc.nextLine();

        return CharacterBuilder.build(name, race, cls);
    }
}