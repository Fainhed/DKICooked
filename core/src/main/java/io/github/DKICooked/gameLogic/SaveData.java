package io.github.DKICooked.gameLogic;

import io.github.DKICooked.entities.LBScore;
import com.badlogic.gdx.utils.Array;

public class SaveData {
    // Ensure the array is initialized to prevent NullPointerExceptions
    public Array<LBScore> leaderBoard = new Array<>();

    public boolean isHighScore(int score) {
        if (score <= 0) return false; // Optional: don't count 0 scores
        if (leaderBoard.size < 10) return true;
        return score > leaderBoard.get(leaderBoard.size - 1).score;
    }

    public void addScore(String name, int score) {
        leaderBoard.add(new LBScore(name, score));

        // Sort: Highest score first (b - a)
        leaderBoard.sort((a, b) -> Integer.compare(b.score, a.score));

        // Truncate to keep only the top 10 players
        if (leaderBoard.size > 10) {
            leaderBoard.truncate(10);
        }
    }
}
