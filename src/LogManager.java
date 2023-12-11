import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LogManager {
    private static final String LOGS_DIRECTORY = "logs";
    private static final String PLAYERS_LOG = "players.json";

    private final JsonManager jsonManager;
    private final List<PlayerLog> playerLogs;

    public LogManager() {
        this.jsonManager = new JsonManager();
        this.playerLogs = jsonManager.loadFromFile(LOGS_DIRECTORY + "/" + PLAYERS_LOG, ArrayList.class);
        if (playerLogs == null) {
            // Eğer dosya yoksa yeni bir liste oluştur
            this.playerLogs = new ArrayList<>();
        }
    }

    public void playerJoined(String playerName) {
        logPlayer(playerName, true);
    }

    public void playerLeft(String playerName) {
        logPlayer(playerName, false);
    }

    public void saveLogs() {
        jsonManager.saveToFile(LOGS_DIRECTORY + "/" + PLAYERS_LOG, playerLogs);
    }

    private void createLogsDirectory() {
        File logsDirectory = new File(LOGS_DIRECTORY);
        if (!logsDirectory.exists()) {
            logsDirectory.mkdir();
        }
    }

    private void logPlayer(String playerName, boolean joined) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = dateFormat.format(new Date());
        PlayerLog log = new PlayerLog(playerName, timestamp, joined);
        playerLogs.add(log);
        saveLogs();
    }
}
