package models

interface SpaceShip {
    fun launch(): Boolean
    fun landing(): Boolean
    fun canCarry(item: Item): Boolean
    fun carry(item: Item)
}
