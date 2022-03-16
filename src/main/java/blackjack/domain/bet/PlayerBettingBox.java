package blackjack.domain.bet;

import blackjack.domain.player.Player;
import java.util.Map;
import java.util.Objects;

public class PlayerBettingBox {

    private final Map<Player, BetMoney> bettingBox;

    public PlayerBettingBox(Map<Player, BetMoney> bettingBox) {
        this.bettingBox = bettingBox;
    }

    public BetMoney get(Player player) {
        return bettingBox.get(player);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PlayerBettingBox that = (PlayerBettingBox) o;
        return Objects.equals(bettingBox, that.bettingBox);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bettingBox);
    }

    @Override
    public String toString() {
        return "PlayerBettingBox{" +
                "bettingBox=" + bettingBox +
                '}';
    }
}
