import Core.PlayerCharacter;
import Storyline.DialogueUtils;
import Storyline.Ending;
import Storyline.Opening;
import Storyline.PlayerSelection;
import Storyline.WorldRunner;

public class Main {
    public static void main(String[] args) {
        Opening.opening();

        PlayerCharacter player = PlayerSelection.createPlayer();
        player.displayStats();
        DialogueUtils.pause();

        boolean survived = WorldRunner.runAll(player);

        if (survived) {
            Ending.ending();
        }
    }
}