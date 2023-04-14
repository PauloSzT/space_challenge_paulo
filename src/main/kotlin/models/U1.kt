package models

class U1 : Rocket(
    maxWeight = 18000,
    cost = 100,
    weight = 10000,
    chanceToExplodeOnLaunch = 0.05,
    chanceToExplodeOnLand = 0.01
) {
    override fun launch(): Boolean {
        val randomNumber: Float = (0..100).random().toFloat()
        return randomNumber > ((chanceToExplodeOnLaunch * (currentCarryTotal / maxLoad)) * 100)
    }

    override fun landing(): Boolean {
        val randomNumber: Float = (0..100).random().toFloat()
        return randomNumber > ((chanceToExplodeOnLand * (currentCarryTotal / maxLoad)) * 100)
    }
}
