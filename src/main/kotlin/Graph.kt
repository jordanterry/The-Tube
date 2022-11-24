interface Graph<T> {
    fun addNode(node: T)
    fun removeNode(node: T)

    fun addEdge(from: T, to: T)
    fun removeEdge(from: T, to: T)

    fun siblings(node: T): List<T>
    fun nodes(): List<T>
}
