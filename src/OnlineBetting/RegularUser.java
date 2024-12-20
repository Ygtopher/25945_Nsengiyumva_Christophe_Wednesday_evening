package OnlineBetting;

import java.util.*;

class RegularUser extends User implements Notifiable {
    private List<Bet> betHistory;

    public RegularUser(String username, String password) {
        super(username, password);
        betHistory = new ArrayList<>();
    }

    // Place Bet Method
    public void placeBet(Bet bet) {
        if (getBalance() < bet.getAmount()) {
            throw new InsufficientBalanceException("Not enough balance to place the bet.");
        }
        betHistory.add(bet);
        deposit(-bet.getAmount()); // Deduct the bet amount from balance
        sendNotification("Bet placed successfully!");
    }

    // View Bet History
    public List<Bet> viewBetHistory() {
        return betHistory;
    }

    // Notification for the user
    @Override
    public void sendNotification(String message) {
        System.out.println("Notification: " + message);
    }
}

