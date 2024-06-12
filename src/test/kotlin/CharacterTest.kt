import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CharacterTest {

    @Test
    fun `character should be created with default health 1000`() {
        val character = Character()
        assertEquals(1000, character.health)
    }

    @Test
    fun `character should be alive when initialized`() {
        val character = Character()
        assertTrue(character.isAlive)
    }

    @Test
    fun `isAlive should return false when health is 0`() {
        val character = Character(health = 0, level = 1)
        assertFalse(character.isAlive)
    }

    @Test
    fun `isAlive should return false when health is negative`() {
        val character = Character(health = -1, level = 1)
        assertFalse(character.isAlive)
    }

    @Test
    fun `isAlive should return true when health is positive`() {
        val character = Character(health = 1, level = 1)
        assertTrue(character.isAlive)
    }

    @Test
    fun `damage() should subtract health of character2`() {
        val character = Character()
        val character2 = Character()
        character2.damage(character, 100)
        assertEquals(900, character2.health)
    }

    @Test
    fun `damage() should set character2 health not smaller than 0`() {
        val character = Character()
        val character2 = Character()
        character2.damage(character, 1200)
        assertEquals(0, character2.health)
    }

    @Test
    fun `damage() cannot damage character2 itself`() {
        val character2 = Character()
        character2.damage(character2, 100)
        assertEquals(1000, character2.health)
    }

    @Test
    fun `heal() sets health to initial value`() {
        val character = Character(health = 10, level = 1)
        character.heal()
        assertEquals(1000, character.health)
    }

    @Test
    fun `heal() should not heal when dead`() {
        val character = Character(health = 0, level = 1)
        character.heal()
        assertEquals(0, character.health)
    }

    @Test
    fun `character should be created with level 1`() {
        val character = Character()
        assertEquals(1, character.level)
    }

    @Test
    fun `heal() sets health to 1500 when greater than level 5`() {
        val character = Character(health = 10, level = 6)
        character.heal()
        assertEquals(1500, character.health)
    }
}