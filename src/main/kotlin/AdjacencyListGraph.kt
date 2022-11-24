class AdjacencyListGraph<T> : Graph<T> {

    private val adjacencyList: MutableMap<T, MutableList<T>> = HashMap()

    override fun addNode(node: T) {
        if (node !in adjacencyList.keys) {
            adjacencyList[node] = arrayListOf()
        }
    }

    override fun removeNode(node: T) {
        if (node in adjacencyList.keys) {
            adjacencyList.remove(node)
            removeEdgesTo(node)
        }
    }

    override fun addEdge(from: T, to: T) {
        addNode(from)
        addNode(to)
        if (to in adjacencyList.keys && from in adjacencyList.keys) {
            adjacencyList[from]!!.add(to)
        }
    }

    override fun removeEdge(from: T, to: T) {
        assert(from in adjacencyList.keys) { "The from node is not in Graph" }
        assert(to in adjacencyList.keys) { "The to node is not in Graph" }
    }

    private fun removeEdgesTo(node: T) {
        for (mutableEntry in adjacencyList) {
            mutableEntry.value.remove(node)
        }
    }

    override fun siblings(node: T): List<T> {
        assert(node in adjacencyList.keys) { "Node is not in Graph" }
        return adjacencyList[node]!!
    }

    override fun nodes(): List<T> = adjacencyList.keys.toList()

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


