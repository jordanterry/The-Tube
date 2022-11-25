package graphs

import java.lang.AssertionError

class AdjacencyGraph<T> : Graph<T> {

    private val adjacencyList: MutableMap<Vertex<T>, MutableList<Edge<T>>> = HashMap()

    override fun addVertex(data: T, attributes: Set<Pair<String, *>>): Vertex<T> {
        val vertex = Vertex(
            data = data,
            attributes = attributes
        )
        if (vertex !in adjacencyList) adjacencyList[vertex] = arrayListOf()
        return vertex
    }

    private fun getVertexOrNull(data: T): Vertex<T>? {
        return adjacencyList.keys.firstOrNull { vertex -> vertex.data == data }
    }

    private fun getVertex(data: T): Vertex<T> {
        return getVertexOrNull(data) ?: throw AssertionError("Vertex for $data is not found in the Graph.")
    }

    override fun addEdge(origin: T, destination: T, attributes: Set<Pair<String, *>>): Edge<T> {
        return Edge(
            origin = getVertex(origin),
            to = getVertex(destination),
            attributes = attributes
        ).also { edge ->
            adjacencyList.getValue(edge.origin).add(edge)
        }
    }

    override fun edges(origin: T): List<Edge<T>> {
        return adjacencyList.getValue(getVertex(origin))
    }

    override fun vertices(): List<Vertex<T>> = adjacencyList.keys.toList()

    override fun toString(): String {
        val stringBuilder = StringBuilder()
        for (node in adjacencyList.keys) {
            stringBuilder.append(node.toString())
            if (adjacencyList.containsKey(node)) {
                val edges = adjacencyList[node]
                if (edges?.isNotEmpty() == true) {
                    stringBuilder.append(" -> ")
                    stringBuilder.append(edges.joinToString(", ") { it.toString() })
                }
            }
            stringBuilder.appendLine()
        }
        return stringBuilder.toString()
    }
}


