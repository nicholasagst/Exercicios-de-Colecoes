package business

import entity.Ship
import entity.Travel
import utils.ShipType
import java.util.concurrent.ExecutionException

class TravelAnalysis private constructor() {

    companion object {

        //RESOLVIDO Quantos navios do tipo Pirata a frota possui?
        fun countPirateShips(ships: List<Ship>): Int {
            // TODO - Implementação
            return ships.count { it.type == ShipType.PIRATE }
        }

        //RESOLVIDO Qual o valor da viagem mais cara?
        fun getMostExpensiveTravel(travels: List<Travel>): Double {
            // TODO - Implementação
            return travels.maxOfOrNull { it.cost }?: throw Exception("Nenhuma viagem encontrada na lista!")
            //poderiamos apenas ter colocado ?: 0.0
        }

        // RESOLVIDO Qual foi o custo médio das viagens para o Black Pearl?
        fun getAverageCostForBlackPearl(ships: List<Ship>, travels: List<Travel>): Double {
            // TODO - Implementação
            val blackPearl = ships.first { it.name == "Black Pearl" }
            return travels.filter { it.ship == blackPearl }
                .map { it.cost }
                .average()


        }

        // RESOLVIDO Qual o nome do navio com a maior capacidade de carga?
        fun getShipWithBiggestCargoCapacity(ships: List<Ship>): String {
            // TODO - Implementação
            return ships.maxByOrNull { it.cargoCapacity }
                ?.name ?: throw Exception("Nenhum navio encontrado na lista!")
        }

        // Qual o nome do navio que fez a viagem mais longa? E qual a duração?
        fun getShipNameForLongestTravelAndDuration(travels: List<Travel>): Map<String, Int> {
            // TODO - Implementação
            val shipWithBigTravel = travels.maxByOrNull { it.durationDays }
            return mapOf((shipWithBigTravel?.ship?.name ?: "Navio não encontrado!") to (shipWithBigTravel?.durationDays ?: 0))
            //em caso como este usamos o ( ) para fechar um pacote para que o Kotlin resolva cada um deles separadamente.
        }

    }

}
