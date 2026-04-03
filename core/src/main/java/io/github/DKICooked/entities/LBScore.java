package io.github.DKICooked.entities;

public class LBScore {
    public String name = "---";
    public int score = 0;

    // LibGDX Json needs an empty constructor
    public LBScore() {}

    public LBScore(String name, int score) {
        this.name = name;
        this.score = score;
    }
}
