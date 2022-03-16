package blackjack.domain.bet;

import blackjack.domain.Outcome;
import java.util.Objects;

public class Profit {

    private static final int DRAW_VALUE = 0;

    private final int profit;

    private Profit(int money) {
        this.profit = money;
    }

    public static Profit withOutcome(Outcome outcome, BetMoney money) {
        if (outcome.equals(Outcome.WIN)) {
            return winWith(money);
        }
        if (outcome.equals(Outcome.LOSE)) {
            return loseWith(money);
        }
        return createWithDraw();
    }

    public static Profit winWith(BetMoney money) {
        return new Profit(money.get());
    }

    public static Profit loseWith(BetMoney money) {
        return new Profit(reverseSign(money.get()));
    }

    private static int reverseSign(int money) {
        return money * -1;
    }

    public static Profit createWithDraw() {
        return new Profit(DRAW_VALUE);
    }

    public int get() {
        return profit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Profit profit1 = (Profit) o;
        return profit == profit1.profit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(profit);
    }

    @Override
    public String toString() {
        return "Profit{" +
                "profit=" + profit +
                '}';
    }
}
