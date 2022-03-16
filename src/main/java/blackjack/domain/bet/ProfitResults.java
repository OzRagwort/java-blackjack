package blackjack.domain.bet;

import blackjack.domain.player.Player;
import java.util.List;
import java.util.Map;

public class ProfitResults {

    private final Map<Player, Profit> results;

    public ProfitResults(Map<Player, Profit> results) {
        this.results = results;
    }

    public Profit get(Player player) {
        return results.get(player);
    }

    public int getDealerProfit() {
        int participantTotalProfit = results.values().stream()
                .mapToInt(Profit::get)
                .sum();

        return participantTotalProfit * -1;
    }

    public List<Player> getPlayers() {
        return List.copyOf(results.keySet());
    }

    @Override
    public String toString() {
        return "ProfitResults{" +
                "results=" + results +
                '}';
    }
}
