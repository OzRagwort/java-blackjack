package blackjack.domain;

public class Participant extends AbstractPlayer implements Player {

    public Participant(Name name) {
        super(name);
    }

    @Override
    public boolean isValidRange() {
        return getScore() < MAX_SCORE;
    }

    @Override
    public int compareWinning(Player dealer) {
        if (isBust()) {
            return LOSE;
        }
        if (dealer.isBust()) {
            return WIN;
        }
        return compareScore(dealer);
    }

    private int compareScore(Player dealer) {
        if (isBLACKJACK() && dealer.isBLACKJACK()) {
            return DRAW;
        }
        if (dealer.isBLACKJACK()) {
            return LOSE;
        }
        if (isBLACKJACK()) {
            return WIN;
        }
        return getScore() - dealer.getScore();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
