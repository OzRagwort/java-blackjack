package blackjack.domain.bet;

import static org.assertj.core.api.Assertions.assertThat;

import blackjack.domain.card.Card;
import blackjack.domain.card.CardNumber;
import blackjack.domain.card.Type;
import blackjack.domain.player.Name;
import blackjack.domain.player.Participant;
import blackjack.domain.player.Player;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ProfitResultsTest {

    @ParameterizedTest(name = "{displayName} : {arguments}")
    @MethodSource("createProfitResultsTestSet")
    @DisplayName("플레이어의 수익 금액을 저장하는 클래스를 생성한다.")
    void create_profit_results() {
        Player player = new Participant(new Name("alien"));
        BetMoney betMoney = new BetMoney(10000);

        Map<Player, Profit> profits = new LinkedHashMap<>();
        Profit profit = Profit.winWith(betMoney);
        profits.put(player, profit);

        ProfitResults profitResults = new ProfitResults(profits);

        Profit resultProfit = profitResults.get(player);
        assertThat(resultProfit.get()).isEqualTo(10000);
    }

    private static Stream<Arguments> createProfitResultsTestSet() {
        Name name = new Name("alien");
        int money = 10000;
        BetMoney betMoney = new BetMoney(money);

        return Stream.of(
                Arguments.of(new Participant(name), Profit.winWith(betMoney), money),
                Arguments.of(new Participant(name), Profit.loseWith(betMoney), money * -1),
                Arguments.of(new Participant(name), Profit.createWithDraw(), 0)
        );
    }
}
