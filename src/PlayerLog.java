public class PlayerLog {
    private final String playerName;
    private final String timestamp;
    private final boolean joined;

    public PlayerLog(String playerName, String timestamp, boolean joined) {
        this.playerName = playerName;
        this.timestamp = timestamp;
        this.joined = joined;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public boolean isJoined() {
        return joined;
    }
}
