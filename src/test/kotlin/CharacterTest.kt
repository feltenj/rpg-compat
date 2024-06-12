import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CharacterTest {

    @Test
    fun testCharacterCreation() {
        val character = Character(100)
        assertNotNull(character, "Character should not be null")
    }

    @Test
    fun `character should be created with default health 100`() {
        val character = Character(health = 100)
        assertEquals(100, character.health)
    }

    @Test
    fun `character should be alive when initialized`() {
        val character = Character(health = 100)
        assertTrue(character.isAlive)
    }

    @Test
    fun `damage() should substract health of character `() {
        val character = Character(health = 100)
        character.damage(10)
        assertEquals(90, character.health)
    }

    @Test
    fun `isAlive should return false when health is 0`() {
        val character = Character(health = 0)
        assertFalse(character.isAlive)
    }

    @Test
    fun `isAlive should return false when health is negative`() {
        val character = Character(health = -1)
        assertFalse(character.isAlive)
    }

    @Test
    fun `isAlive should return true when health is positive`() {
        val character = Character(health = 1)
        assertTrue(character.isAlive)
    }

    @Test
    fun `damage() should set health not smaller than 0`() {
        val character = Character(health = 10)
        character.damage(20)
        assertEquals(0, character.health)
    }

//    @Test
//    fun `damage() cannot damage character itself`() {
//        val character = Character(health = 100)
//        character.damage(character, 10)
//        assertEquals(100, character.health)
//    }
}