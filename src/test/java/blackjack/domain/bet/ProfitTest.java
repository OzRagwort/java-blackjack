package blackjack.domain.bet;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProfitTest {

    @Test
    @DisplayName("이기면 배팅 금액만큼 수익이 생긴다.")
    void create_profit_win() {
        int money = 10000;
        BetMoney betMoney = new BetMoney(money);
        Profit profit = Profit.winWith(betMoney);

        assertThat(profit.get()).isEqualTo(betMoney.get());
    }

    @Test
    @DisplayName("지면 배팅 금액만큼 수익을 잃는다.")
    void create_profit_lose() {
        int money = 10000;
        BetMoney betMoney = new BetMoney(money);
        Profit profit = Profit.loseWith(betMoney);

        assertThat(profit.get()).isEqualTo(money * -1);
    }

    @Test
    @DisplayName("비기면 수익은 0이다.")
    void create_profit_draw() {
        Profit profit = Profit.createWithDraw();

        assertThat(profit.get()).isEqualTo(0);
    }
}
