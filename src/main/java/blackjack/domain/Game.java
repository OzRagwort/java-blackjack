package blackjack.domain;

import blackjack.domain.card.Cards;
import blackjack.domain.player.Gamers;
import blackjack.domain.player.Player;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

public class Game {

    public static final int WINNING_NUMBER = 21;
    private static final int CARD_INIT_COUNT = 2;

    private final Cards shuffledCards;
    private final Player dealer;
    private final Gamers gamers;

    public Game(Cards shuffledCards, Player dealer, Gamers gamers) {
        initialize(shuffledCards, dealer, gamers);

        this.shuffledCards = shuffledCards;
        this.dealer = dealer;
        this.gamers = gamers;
    }

    private void initialize(Cards cards, Player dealer, Gamers gamers) {
        for (int i = 0; i < CARD_INIT_COUNT; i++) {
            dealer.addCardToDeck(cards.next());
            gamers.drawToGamers(cards);
        }
    }

    public boolean isGamerDrawable(String name) {
        return findGamerByName(name).isDrawable();
    }

    public boolean isDealerDrawable() {
        return dealer.isDrawable();
    }

    public void drawCardToDealer() {
        drawCardToPlayer(dealer.getName());
    }

    public void drawCardToPlayer(String name) {
        if (dealer.getName().equals(name)) {
            dealer.addCardToDeck(shuffledCards.next());
            return;
        }

        findGamerByName(name).addCardToDeck(shuffledCards.next());
    }

    private Map<String, GameResult> calculateGamerResult() {
        return gamers.getGamers().stream()
                .collect(toMap(Player::getName, this::calculateWinning));
    }

    public Map<String, String> getGamerResult() {
        return calculateGamerResult().entrySet().stream()
                .collect(toMap(Map.Entry::getKey, e -> e.getValue().getMessage()));
    }

    private GameResult calculateWinning(Player player) {
        return GameResult.calculate(dealer, player);
    }

    public List<String> getDealerResult() {
        return calculateGamerResult().values().stream()
                .map(GameResult::reverse)
                .map(GameResult::getMessage)
                .collect(toList());
    }

    public Player findGamerByName(String name) {
        return gamers.findGamer(name);
    }

    public Player getDealer() {
        return dealer;
    }

    public List<Player> getGamersAsList() {
        return Collections.unmodifiableList(gamers.getGamers());
    }

    public List<String> getGamerNames() {
        return gamers.getGamerNames();
    }
}