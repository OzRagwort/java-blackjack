package blackjack.domain.player;

import java.util.Objects;

public class Name {
    private final String name;

    public Name(String name) {
        name = name.trim();
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("공백인 이름은 사용할 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Name)) {
            return false;
        }
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}