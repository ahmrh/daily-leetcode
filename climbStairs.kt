
fun climbStairs(n: Int): Int {

    //tabulation
    val savedStep = mutableListOf(1, 2)
    return when (n) {
        1 -> 1
        2 -> 2
        else -> {
            for (i in 2..n) {
                savedStep.add(savedStep[i - 1] + savedStep[i - 2])
            }
            savedStep[n - 1]
        }
    }
}
