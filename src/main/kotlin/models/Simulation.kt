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
    fun loadU1(){}
    fun loadU2() {}
    fun runSimulation() {}
}
