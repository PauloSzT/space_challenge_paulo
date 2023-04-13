package models

import java.io.FileReader

class Simulation {
    fun loadItems(textFile: String): ArrayList<Item> {
        val fin = FileReader(textFile)
        val itemsList = fin.readLines().map { value ->
            val splitedItems = value.split("=")
            Item(name = splitedItems[0], weight = splitedItems[1].toInt())
        }
        return itemsList as ArrayList<Item>
    }

    fun loadU1(itemList: MutableList<Item>): ArrayList<Rocket> {
        val u1Rockets = arrayListOf<Rocket>()
        var rocket = U1()
        itemList.forEach { item ->
            if (rocket.canCarry(item)) {
                rocket.carry(item)
            } else {
                u1Rockets.add(rocket)
                rocket = U1()
                rocket.carry(item)
            }
        }
        return u1Rockets
    }

    fun loadU2(itemList: MutableList<Item>): ArrayList<Rocket> {
        val u2Rockets = arrayListOf<Rocket>()
        var rocket = U2()
        itemList.forEach { item ->
            if (rocket.canCarry(item)) {
                rocket.carry(item)
            } else {
                u2Rockets.add(rocket)
                rocket = U2()
                rocket.carry(item)
            }
        }
        return u2Rockets
    }

    fun runSimulation(){}

}
