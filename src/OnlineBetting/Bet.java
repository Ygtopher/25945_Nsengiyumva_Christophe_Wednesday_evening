package OnlineBetting;

class Bet {
    private static int counter = 1;
    private String betId;
    private double amount;
    private String gameId;
    private String outcome;

    public Bet(double amount, String gameId, String outcome) {
        if (amount <= 0) {
            throw new InvalidBetException("Bet amount must be positive.");
        }
        this.betId = "BET" + counter++;
        this.amount = amount;
        this.gameId = gameId;
        this.outcome = outcome;
    }

    public String getBetDetails() {
        return "Bet ID: " + betId + ", Amount: " + amount + ", Game ID: " + gameId + ", Outcome: " + outcome;
    }

    public double getAmount() {
        return amount;
    }
}

