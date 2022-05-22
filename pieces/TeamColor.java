package pieces;

public enum TeamColor {
    BLACK(1),
    WHITE(-1);
    TeamColor(int x) {
        this.value = x;
    }
    private final int value;

    public int getValue() {
        return value;
    }
}
