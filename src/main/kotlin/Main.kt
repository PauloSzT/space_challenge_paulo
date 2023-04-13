import models.Rocket
import models.Simulation

fun main() {
    val main: Main = Main()
    main.runAllSimulations()
}

class Main {
    fun runAllSimulations() {
        val simulation: Simulation = Simulation()
        val simulationLoadedItemsPhase1 = simulation.loadItems("src/main/resources/Phase-1.txt")
        val simulationLoadedItemsPhase2 = simulation.loadItems("src/main/resources/Phase-2.txt")
        val u1rocketFleetFinal =
            (simulation.loadU1(simulationLoadedItemsPhase1)
                    + simulation.loadU1(simulationLoadedItemsPhase2)) as ArrayList<Rocket>
        val u2rocketFleetFinal =
            (simulation.loadU2(simulationLoadedItemsPhase1)
                    + simulation.loadU2(simulationLoadedItemsPhase2)) as ArrayList<Rocket>
        val simulationResultU1 = simulation.runSimulation(u1rocketFleetFinal)
        println("The Total Budget spent in U1s for this mission is $ $simulationResultU1")
        val simulationResultU2 = simulation.runSimulation(u2rocketFleetFinal)
        println("The Total Budget spent in U2s for this mission is $ $simulationResultU2")
    }
}
