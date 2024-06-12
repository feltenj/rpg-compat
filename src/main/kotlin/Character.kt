class Character(var health: Int = 1000, var level: Int = 1) {
    fun damage(character: Character, damage: Int) {
        if (character === this) {
            return
        }
        health -= damage
        if (health < 0) {
            health = 0
        }
    }

    fun heal() {
        if (!isAlive) return
        health = if (level > 5) 1500 else 1000

    }

    val isAlive: Boolean
        get() = health > 0
}