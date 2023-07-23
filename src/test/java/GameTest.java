import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    public void shouldCompareTwoPlayers() {
        Game game = new Game();

        Player sasha = new Player(1, "Саша", 80);
        Player pasha = new Player(1, "Паша", 70);

        game.register(sasha);
        game.register(pasha);

        int expected = 1;
        int actual = game.round("Саша", "Паша");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareTwoPlayersWinSecond() {
        Game game = new Game();

        Player sasha = new Player(1, "Саша", 80);
        Player pasha = new Player(1, "Паша", 90);

        game.register(sasha);
        game.register(pasha);

        int expected = 2;
        int actual = game.round("Саша", "Паша");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareTwoPlayersDraw() {
        Game game = new Game();

        Player sasha = new Player(1, "Саша", 80);
        Player pasha = new Player(1, "Паша", 80);

        game.register(sasha);
        game.register(pasha);

        int expected = 0;
        int actual = game.round("Саша", "Паша");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareOnePlayerNotRegistered() {
        Game game = new Game();

        Player sasha = new Player(1, "Саша", 80);
        Player pasha = new Player(1, "Паша", 80);

        game.register(sasha);
        game.register(pasha);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Вова", "Паша");
        });
    }

    @Test
    public void shouldCompareSecondPlayerNotRegistered() {
        Game game = new Game();

        Player sasha = new Player(1, "Саша", 80);
        Player pasha = new Player(1, "Паша", 80);

        game.register(sasha);
        game.register(pasha);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Саша", "Дима");
        });
    }

    @Test
    public void shouldCompareBothPlayersNotRegistered() {
        Game game = new Game();

        Player sasha = new Player(1, "Саша", 80);
        Player pasha = new Player(1, "Паша", 80);

        game.register(sasha);
        game.register(pasha);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Вова", "Дима");
        });
    }

}