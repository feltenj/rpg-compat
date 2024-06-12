class Character(var health: Int) {
    fun damage(damage: Int) {
        health -= damage
        if (health < 0) {
            health = 0
        }
    }

    val isAlive: Boolean
        get() = health > 0
}