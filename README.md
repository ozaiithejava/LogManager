# LogManager
gelistirilneye musait bir loglama sistemi

## Usage:
```java
public class Main {
    public static void main(String[] args) {
        LogManager logManager = new LogManager();

        // Oyuncu giriş-çıkış işlemleri
        logManager.playerJoined("Player1");
        logManager.playerJoined("Player2");
        logManager.playerLeft("Player1");
        logManager.playerJoined("Player3");

        // Logları kaydet
        logManager.saveLogs();

        // Logları ekrana bas
        for (PlayerLog log : logManager.getPlayerLogs()) {
            System.out.println("Player: " + log.getPlayerName() +
                    ", Joined: " + log.isJoined() +
                    ", Timestamp: " + log.getTimestamp());
        }
    }
}

```
