package blackjack.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OutComeTest {

    @Test
    @DisplayName("Outcome의 compare 메서드는 플레이어가 Bust라면 무조건 패배했다고 판단한다.")
    void compare_player_bust() {
        Player dealer = new Dealer();
        dealer.hit(new Card(CardNumber.SEVEN, Type.CLOVER));
        dealer.hit(new Card(CardNumber.TEN, Type.SPADE));

        Player player = new Participant(new Name("aki"));
        player.hit(new Card(CardNumber.TEN, Type.CLOVER));
        player.hit(new Card(CardNumber.TEN, Type.SPADE));
        player.hit(new Card(CardNumber.TEN, Type.DIAMOND));

        assertThat(Outcome.compare(dealer, player)).isEqualTo(Outcome.WIN);
    }

    @Test
    @DisplayName("Outcome의 compare 메서드는 딜러 Bust라면 무조건 패배했다고 판단한다.")
    void compare_dealer_bust() {
        Player dealer = new Dealer();
        dealer.hit(new Card(CardNumber.SEVEN, Type.CLOVER));
        dealer.hit(new Card(CardNumber.FIVE, Type.SPADE));
        dealer.hit(new Card(CardNumber.TEN, Type.DIAMOND));

        Player player = new Participant(new Name("aki"));
        player.hit(new Card(CardNumber.TEN, Type.CLOVER));
        player.hit(new Card(CardNumber.TEN, Type.SPADE));

        assertThat(Outcome.compare(dealer, player)).isEqualTo(Outcome.LOSE);
    }

    @Test
    @DisplayName("Outcome의 compare 메서드는 딜러가 블랙잭이고 플레이어가 블랙잭이 아니라면 승리했다고 판단한다.")
    void compare_dealer_blackjack() {
        Player dealer = new Dealer();
        dealer.hit(new Card(CardNumber.ACE, Type.CLOVER));
        dealer.hit(new Card(CardNumber.KING, Type.SPADE));

        Player player = new Participant(new Name("aki"));
        player.hit(new Card(CardNumber.ACE, Type.CLOVER));
        player.hit(new Card(CardNumber.TEN, Type.DIAMOND));

        assertThat(Outcome.compare(dealer, player)).isEqualTo(Outcome.WIN);
    }

    @Test
    @DisplayName("Outcome의 compare 메서드는 플레이어가 블랙잭이고 딜러가 블랙잭이 아니라면 패배했다고 판단한다.")
    void compare_player_blackjack() {
        Player dealer = new Dealer();
        dealer.hit(new Card(CardNumber.ACE, Type.CLOVER));
        dealer.hit(new Card(CardNumber.TEN, Type.SPADE));

        Player player = new Participant(new Name("aki"));
        player.hit(new Card(CardNumber.ACE, Type.CLOVER));
        player.hit(new Card(CardNumber.JACK, Type.DIAMOND));

        assertThat(Outcome.compare(dealer, player)).isEqualTo(Outcome.LOSE);
    }

    @Test
    @DisplayName("Outcome의 compare 메서드는 딜러와 플레이어 모두 블랙잭이라면 무승부라고 판단한다.")
    void compare_player_and_dealer_blackjack() {
        Player dealer = new Dealer();
        dealer.hit(new Card(CardNumber.ACE, Type.CLOVER));
        dealer.hit(new Card(CardNumber.KING, Type.SPADE));

        Player player = new Participant(new Name("aki"));
        player.hit(new Card(CardNumber.ACE, Type.CLOVER));
        player.hit(new Card(CardNumber.JACK, Type.DIAMOND));

        assertThat(Outcome.compare(dealer, player)).isEqualTo(Outcome.DRAW);
    }

    @Test
    @DisplayName("Outcome의 compare 메서드는 딜러와 플레이어의 점수를 비교하여 승무패를 판단한다.")
    void compare_player_and_dealer() {
        Player dealer = new Dealer();
        dealer.hit(new Card(CardNumber.FIVE, Type.CLOVER));
        dealer.hit(new Card(CardNumber.TEN, Type.SPADE));
        dealer.hit(new Card(CardNumber.THREE, Type.DIAMOND));

        Player player = new Participant(new Name("aki"));
        player.hit(new Card(CardNumber.SEVEN, Type.CLOVER));
        player.hit(new Card(CardNumber.TEN, Type.DIAMOND));

        assertThat(Outcome.compare(dealer, player)).isEqualTo(Outcome.WIN);
    }
}
