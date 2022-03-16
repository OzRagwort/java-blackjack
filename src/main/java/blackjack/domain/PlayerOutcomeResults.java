package blackjack.domain;

import blackjack.domain.player.Player;
import java.util.Collections;
import java.util.Map;

public class PlayerOutcomeResults {

    private final Map<Player, Outcome> results;

    public PlayerOutcomeResults(Map<Player, Outcome> results) {
        this.results = results;
    }

    public Map<Player, Outcome> getResults() {
        return Collections.unmodifiableMap(results);
    }
}
