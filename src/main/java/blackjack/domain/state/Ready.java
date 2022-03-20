package blackjack.domain.state;

import blackjack.domain.Outcome;
import blackjack.domain.bet.BetMoney;
import blackjack.domain.bet.Profit;
import blackjack.domain.card.Card;
import blackjack.domain.card.PlayerCards;
import java.util.ArrayList;
import java.util.List;

public abstract class Ready implements State {

    protected PlayerCards cards;

    public static State dealToParticipant(Card card1, Card card2) {
        List<Card> cards = new ArrayList<>(List.of(card1, card2));
        PlayerCards playerCards = new PlayerCards(cards);
        if (playerCards.isBlackjack()) {
            return new ParticipantBlackjack(playerCards);
        }
        return new ParticipantHit(playerCards);
    }

    public static State dealToDealer(Card card1, Card card2) {
        List<Card> cards = new ArrayList<>(List.of(card1, card2));
        PlayerCards playerCards = new PlayerCards(cards);
        if (playerCards.isBlackjack()) {
            return new DealerBlackjack(playerCards);
        }
        return DealerHit.from(playerCards);
    }

    @Override
    public PlayerCards getCards() {
        return cards;
    }

    public abstract State draw(Card card);

    public abstract State stay();

    public abstract boolean isFinished();

    public abstract boolean isBust();

    public abstract boolean isBlackjack();

    public abstract Profit profit(Outcome outcome, BetMoney money);
}