package OnlineBetting;

class Game {
    private String gameId;
    private String gameName;
    private double odds;

    public Game(String gameId, String gameName, double odds) {
        this.gameId = gameId;
        this.gameName = gameName;
        this.odds = odds;
    }

    public String getGameDetails() {
        return "Game ID: " + gameId + ", Name: " + gameName + ", Odds: " + odds;
    }

    public String getGameId() {
        return gameId;
    }
}

