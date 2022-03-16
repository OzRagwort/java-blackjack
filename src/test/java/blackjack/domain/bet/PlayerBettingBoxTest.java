package blackjack.domain.bet;

import static org.assertj.core.api.Assertions.assertThat;

import blackjack.domain.player.Name;
import blackjack.domain.player.Participant;
import blackjack.domain.player.Player;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerBettingBoxTest {

    @Test
    @DisplayName("플레이어들의 배팅 금액을 저장하는 일급 컬렉션을 생성한다.")
    void create_bet_money() {
        int money = 10000;
        BetMoney betMoney = new BetMoney(money);
        Player player = new Participant(new Name("alien"));

        Map<Player, BetMoney> betMonies = new LinkedHashMap<>();
        betMonies.put(player, betMoney);
        PlayerBettingBox playerBettingBox = new PlayerBettingBox(betMonies);

        assertThat(playerBettingBox.get(player).get()).isEqualTo(money);
    }
}
