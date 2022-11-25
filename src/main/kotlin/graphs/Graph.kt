package graphs

/**
 * Definition of functions allowing us to interact with a Graph.
 */
interface Graph<T> {

    /**
     * Add a new vertex to the Graph, the parameter [data] will be added to the vertex.
     *
     * @param data the data to store in the vertex
     * @param attributes optional data describing a vertex
     * @return the created Vertex.
     */
    fun addVertex(
        data: T,
        attributes: Set<Pair<String, *>> = emptySet()
    ): Vertex<T>

    /**
     * Add an Edge to the graph. Attributes can also be added to describe the edges.
     *
     * @param origin the origin of the edge
     * @param destination the destination of the edge
     * @return the created Edge
     */
    fun addEdge(
        origin: T,
        destination: T,
        attributes: Set<Pair<String, *>> = emptySet()
    ): Edge<T>

    /**
     * Return the Edges for a given piece of data.
     */
    fun edges(origin: T): List<Edge<T>>

    /**
     * Return all verticies from the Graph.
     */
    fun vertices(): List<Vertex<T>>
}

data class Vertex<T>(
    val data: T,
    val attributes: Set<Pair<String, *>>
)

data class Edge<T>(
    val origin: Vertex<T>,
    val to: Vertex<T>,
    val attributes: Set<Pair<String, *>>
)

fun <T> Graph(): Graph<T> = AdjacencyGraph()