package models

open class Rocket(
    val maxWeight: Int,
    val cost: Int,
    val weight: Int,
    val chanceToExplodeOnLaunch: Double,
    val chanceToExplodeOnLand: Double
) : SpaceShip {
    val storage: MutableList<Item> = mutableListOf()
    val maxLoad: Int = maxWeight - weight
    var currentCarryTotal: Int = 0
    override fun launch(): Boolean {
        return true
    }

    override fun landing(): Boolean {
        return true
    }

    override fun canCarry(item: Item): Boolean {
        val remainingStorage: Int = maxLoad - currentCarryTotal
        return remainingStorage > item.weight
    }

    override fun carry(item: Item) {
        storage.add(item)
        currentCarryTotal = storage.sumOf { itemLoaded -> itemLoaded.weight }
    }
}
