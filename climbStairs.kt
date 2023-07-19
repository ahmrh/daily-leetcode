
fun climbStairs(n: Int): Int {

    //tabulation
    val savedStep = mutableListOf(1, 2)
    when (n) {
        1 -> return 1
        2 -> return 2
        else -> {
            for (i in 2..n) {
                savedStep.add(savedStep[i - 1] + savedStep[i - 2])
            }
            return savedStep[n - 1]
        }
    }
}
