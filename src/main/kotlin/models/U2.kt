package models

class U2 : Rocket(
    maxWeight = 29000,
    cost = 120,
    weight = 18000,
    chanceToExplodeOnLaunch = 0.04,
    chanceToExplodeOnLand = 0.08
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