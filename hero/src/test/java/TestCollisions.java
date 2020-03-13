import com.skdgt.hero.arena.Coin;
import com.skdgt.hero.arena.Monster;
import com.skdgt.hero.arena.Position;
import org.junit.Test;

import static org.junit.Assert.*;


public class TestCollisions {
    @Test
    public void testMonsterCoin() {
        Monster monster = new Monster(new Position(10,10), 20);
        Coin coin = new Coin(new Position(10,10), 20);

        assertTrue(monster.getPosition().equals(coin.getPosition()));
    }
}
