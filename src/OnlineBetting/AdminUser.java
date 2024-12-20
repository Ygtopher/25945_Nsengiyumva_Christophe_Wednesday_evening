package OnlineBetting;

import java.util.*;

class AdminUser extends User implements Auditable {
    private Map<String, Game> gameCatalog;

    public AdminUser(String username, String password) {
        super(username, password);
        gameCatalog = new HashMap<>();
    }

    // Add Game
    public void addGame(Game game) {
        if (gameCatalog.containsKey(game.getGameId())) {
            throw new InvalidGameException("Game ID already exists.");
        }
        gameCatalog.put(game.getGameId(), game);
        logAction("Game added: " + game.getGameId());
    }

    // Remove Game
    public void removeGame(String gameId) {
        if (!gameCatalog.containsKey(gameId)) {
            throw new InvalidGameException("Game ID not found.");
        }
        gameCatalog.remove(gameId);
        logAction("Game removed: " + gameId);
    }

    // Audit Logging
    @Override
    public void logAction(String action) {
        System.out.println("Admin Action: " + action);
    }

    @Override
    public String generateReport() {
        return "Generated Admin Action Report.";
    }
}

