package slotmachine.gamemode.sequence;

import slotmachine.gamemode.GameMode;

import java.util.ArrayList;
import java.util.List;

public class Sequence extends GameMode {
    private List<Integer> reelSize;
    private List<List<Integer>> sequence;
    private int index;

    public Sequence (List<Integer> reelSize, int quantity) {
        this.reelSize = reelSize;
        sequence = new ArrayList<List<Integer>>();
        index = 0;

        for(int i = 0; i  < quantity; i++) {
            for(int j : reelSize) {
                sequence.add(getRandoms(reelSize));
            }
        }
    }

    @Override
    public List<Integer> getNextValues() {
        List<Integer> result;

        result = sequence.get(index);
        index = ++index%sequence.size();

        return result;
    }
}
