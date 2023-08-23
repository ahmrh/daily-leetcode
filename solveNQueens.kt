
fun solveNQueens(n: Int): List<List<String>> {

    val solutions = mutableListOf<List<String>>()
    val queenIndices = mutableListOf<Pair<Int, Int>>()

    fun buildString(index: Pair<Int, Int>): String{
        var s = ""
        for(i in 0 until n)
            s += if(i == index.second) "Q" else "."
        return s
    }
    fun isSafe(index: Pair<Int, Int>): Boolean {

        queenIndices.forEach { queenIndex ->
            if (Math.abs(queenIndex.second - index.second) == Math.abs(queenIndex.first - index.first)
                || queenIndex.second == index.second
                || queenIndex.first == index.first
            ) return false
        }

        return true
    }

    fun nQueen(x: Int) {
        if (x == n) {
            val solution = queenIndices.map{
                buildString(it)
            }
            solutions.add(solution)
            return
        }

        for (y in 0 until n) {
            if (isSafe(Pair(x, y))) {
                queenIndices.add(Pair(x, y))
                nQueen(x + 1)
                queenIndices.removeAt(queenIndices.lastIndex)
            }
        }
    }

    nQueen(0)

    return solutions
}
