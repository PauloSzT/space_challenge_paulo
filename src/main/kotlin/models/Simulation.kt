package models

import java.io.FileReader

open class Simulation {
    fun loadItems(textFile: String): ArrayList<Item> {
        val fin = FileReader(textFile)
        val itemsList = fin.readLines().map { value ->
            val splitItems = value.split("=")
            Item(name = splitItems[0], weight = splitItems[1].toInt())
        }
        return itemsList as ArrayList<Item>
    }

    fun loadU1(itemList: MutableList<Item>): ArrayList<Rocket> {
        val u1RocketsFleet = arrayListOf<Rocket>()
        var rocket = U1()
        itemList.forEach { item ->
            if (rocket.canCarry(item)) {
                rocket.carry(item)
            } else {
                u1RocketsFleet.add(rocket)
                rocket = U1()
                rocket.carry(item)
            }
        }
        u1RocketsFleet.add(rocket)
        return u1RocketsFleet
    }

    fun loadU2(itemList: MutableList<Item>): ArrayList<Rocket> {
        val u2RocketsFleet = arrayListOf<Rocket>()
        var rocket = U2()
        itemList.forEach { item ->
            if (rocket.canCarry(item)) {
                rocket.carry(item)
            } else {
                u2RocketsFleet.add(rocket)
                rocket = U2()
                rocket.carry(item)
            }
        }
        u2RocketsFleet.add(rocket)
        return u2RocketsFleet
    }

    fun runSimulation(rockets: ArrayList<Rocket>): Int {
        var rocketId = 0
        var totalBudget = 0
        fun tryLaunch(rocket: Rocket) {
            rocketId++
            totalBudget += rocket.cost
            if (rocket.launch()) {
                if (!rocket.landing()) {
                    println("Rocket $rocketId failed on landing")
                    tryLaunch(rocket)
                }else{
                    println("Rocket $rocketId landed Complete with:")
                    rocket.storage.forEach{item -> println(item.name)}
                }
            } else {
                println("Rocket $rocketId failed on launch")
                tryLaunch(rocket)
            }
        }
        rockets.forEach { rocket -> tryLaunch(rocket)}
        return totalBudget.times(1000000)
    }
}
