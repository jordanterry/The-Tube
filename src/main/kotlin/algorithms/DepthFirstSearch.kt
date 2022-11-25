package algorithms

import graphs.Graph

interface DepthFirstSearch<T> {
    fun dfs(from: T, target: T): List<T>
}

/**
 * A recursive implementation of the depth first search algorithm.
 *
 * Will return a ranked list of results from the depth first search.
 */
class DepthFirstSearchImpl<T>(
    private val graph: Graph<T>
) : DepthFirstSearch<T> {

    override fun dfs(from: T, target: T): List<T> {
//        val searchNodes = HashMap<T, DfsNode<T>>()
//        for (node in graph.vertices()) {
//            searchNodes[node] = DfsNode(node)
//        }
//        var time = 0
//
//        /**
//         * Visit a [DfsNode] and search all siblings.
//         *
//         * Responsible for marking:
//         * - Discovery time
//         * - Visited state White -> Grey -> Black
//         * - The predecessor of siblings, if not discovered
//         * - The finish time
//         */
//        fun visit(dfsNode: DfsNode<T>) {
//            println(dfsNode.data)
//            time++
//            dfsNode.visited = DfsNode.VisitedState.GREY
//            dfsNode.start = time
//            for (sibling in graph.edges(dfsNode.data)) {
//                val searchNode = searchNodes[sibling]!!
//                if (searchNode.visited == DfsNode.VisitedState.WHITE){
//                    searchNode.predecessor = dfsNode
//                    visit(searchNode)
//                }
//            }
//            dfsNode.visited = DfsNode.VisitedState.BLACK
//            time++
//            dfsNode.end = time
//        }
//
//        visit(searchNodes[from]!!)

        return emptyList()
    }


    private data class DfsResult<T>(
        val root: DfsTreeNode<T>
    )

    private data class DfsTreeNode<T>(
        val dfsNode: DfsNode<T>,
        var children: List<DfsNode<T>> = emptyList()
    )

    private data class DfsNode<T>(
        val data: T,
        var start: Int = 0,
        var end: Int = 0,
        var predecessor: DfsNode<T>? = null,
        var visited: VisitedState = VisitedState.WHITE
    ) {
        enum class VisitedState {
            WHITE, GREY, BLACK;
        }
    }
}