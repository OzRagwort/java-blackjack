package blackjack.domain.state;

import static blackjack.domain.CardFixture.SPADE_ACE;
import static blackjack.domain.CardFixture.SPADE_TEN;
import static blackjack.domain.CardFixture.SPADE_THREE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DealerBlackjackTest {

    private State blackjack;

    @BeforeEach
    void setUp() {
        blackjack = Ready.dealToDealer(SPADE_ACE, SPADE_TEN);
    }

    @Test
    @DisplayName("딜러가 blackjack이면 DealerBlackjack이 된다.")
    void dealer_bust() {
        assertThat(blackjack).isInstanceOf(DealerBlackjack.class);
    }

    @Test
    @DisplayName("blackjack일 때 draw를 하면 에러가 발생한다.")
    void draw() {
        assertThatThrownBy(() -> blackjack.draw(SPADE_THREE))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("blackjack일 때 stay를 하면 에러가 발생한다.")
    void stay() {
        assertThatThrownBy(blackjack::stay)
                .isInstanceOf(IllegalStateException.class);
    }
}