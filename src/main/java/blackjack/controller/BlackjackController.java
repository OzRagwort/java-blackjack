package blackjack.controller;

import blackjack.domain.Dealer;
import blackjack.domain.Deck;
import blackjack.domain.Gamer;
import blackjack.domain.Gamers;
import blackjack.domain.Name;
import blackjack.domain.Player;
import blackjack.domain.RandomDeck;
import blackjack.view.InputView;
import blackjack.view.ResultView;
import java.util.List;
import java.util.stream.Collectors;

public class BlackjackController {

    private static final String STAY_ANSWER = "n";

    public void run() {
        List<String> names = InputView.requestNames();
        Deck deck = new RandomDeck();
        Gamer dealer = createDealer(deck);
        Gamers players = createPlayers(names, deck);
        ResultView.printInitCard(dealer, players);
        takeTurns(players, deck);
        takeDealerCards(dealer, deck);
    }

    private Gamer createDealer(Deck deck) {
        Gamer dealer = new Dealer();
        dealer.hit(deck.pick());
        dealer.hit(deck.pick());
        return dealer;
    }

    private Gamers createPlayers(List<String> names, Deck deck) {
        Gamers gamers = new Gamers(names.stream()
                .map(Name::new)
                .map(Player::from)
                .collect(Collectors.toList()));
        gamers.initCards(deck);
        return gamers;
    }

    private void takeTurns(Gamers gamers, Deck deck) {
        gamers.get()
                .forEach(gamer -> takePlayerCards(gamer, deck));
    }

    private void takePlayerCards(Gamer gamer, Deck deck) {
        if (!gamer.isValidRange()) {
            return;
        }
        String answer = InputView.requestHitOrStay(gamer.getName());
        if (answer.equals(STAY_ANSWER)) {
            return;
        }
        gamer.hit(deck.pick());
        ResultView.printGamerCard(gamer);
        takePlayerCards(gamer, deck);
    }

    private void takeDealerCards(Gamer gamer, Deck deck) {
        while (gamer.isValidRange()) {
            ResultView.printDealerHitMessage();
            gamer.hit(deck.pick());
        }
    }
}
