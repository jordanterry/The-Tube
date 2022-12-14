import algorithms.DepthFirstSearchImpl
import graphs.AdjacencyGraph
import graphs.Graph

fun main(args: Array<String>) {

    val graph = Graph<Station>().apply {
        districtLine(this)
    }

    println(graph)

    val dfs = DepthFirstSearchImpl(graph)
    dfs.dfs("Wimbledon".toStation(), "Victoria".toStation())
}

fun districtLine(graph: Graph<Station>) {
    with(graph) {
        val districtLineStations = listOf(
            "Wimbledon",
            "Wimbledon Park",
            "Southfields",
            "East Putney",
            "Putney Bridge",
            "Parsons Green",
            "Fulham Broadway",
            "West Brompton",
            "Earls Court",
            "Gloucester Road",
            "South Kensington",
            "Sloane Square",
            "Victoria",
            "St James's Park",
            "Westminster",
            "West Kensington",
            "Ravenscourt Park",
            "Stamford Brook",
            "Turnham Green",
            "Gunnersby",
            "Kew Gardens",
            "Richmond",
            "High Street Kensington",
            "Olympia"
        ).forEach { station ->
            addVertex(station.toStation())
        }
        addEdge("Wimbledon".toStation(), "Wimbledon Park".toStation())
        addEdge("Wimbledon Park".toStation(), "Southfields".toStation())
        addEdge("Southfields".toStation(), "East Putney".toStation())
        addEdge("East Putney".toStation(), "Putney Bridge".toStation())
        addEdge("Putney Bridge".toStation(), "Parsons Green".toStation())
        addEdge("Parsons Green".toStation(), "Fulham Broadway".toStation())
        addEdge("Fulham Broadway".toStation(), "West Brompton".toStation())
        addEdge("West Brompton".toStation(), "Earls Court".toStation())
        addEdge("Earls Court".toStation(), "Gloucester Road".toStation())
        addEdge("Gloucester Road".toStation(), "South Kensington".toStation())
        addEdge("South Kensington".toStation(), "Sloane Square".toStation())
        addEdge("Sloane Square".toStation(), "Victoria".toStation())
        addEdge("Victoria".toStation(), "St James's Park".toStation())
        addEdge("St James's Park".toStation(), "Westminster".toStation())

        // Earls Court to Richmond
        addEdge("Earls Court".toStation(), "West Kensington".toStation())
        addEdge("West Kensington".toStation(), "Ravenscourt Park".toStation())
        addEdge("Ravenscourt Park".toStation(), "Stamford Brook".toStation())
        addEdge("Stamford Brook".toStation(), "Turnham Green".toStation())
        addEdge("Turnham Green".toStation(), "Gunnersby".toStation())
        addEdge("Gunnersby".toStation(), "Kew Gardens".toStation())
        addEdge("Kew Gardens".toStation(), "Richmond".toStation())

        // Paddington
        addEdge("Earls Court".toStation(), "High Street Kensington".toStation())

        // Paddington
        addEdge("Earls Court".toStation(), "Olympia".toStation())
    }
}


fun String.toStation(): Station = Station(this)
data class Station(
    val name: String
) {
    override fun toString(): String {
        return name
    }
}
