package blackjack.domain.card;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DeckTest {

    @Test
    @DisplayName("Deck에서 정상적으로 카드를 하나 뽑는다.")
    void pick_card() {
        Deck fixDeck = new JustTenSpadeDeck();
        Card pickedCard = fixDeck.pick();
        Card card = Card.of(CardNumber.TEN, Suit.SPADE);

        assertThat(pickedCard).isEqualTo(card);
    }
}
