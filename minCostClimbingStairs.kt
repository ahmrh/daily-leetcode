fun minCostClimbingStairs(cost: IntArray): Int {
    val dp = IntArray(cost.size)

    fun recurse(index: Int): Int{
        if(index >= cost.size) return 0
        if(dp[index] != 0) return dp[index]

        dp[index] = cost[index] + min(recurse(index + 1), recurse(index + 2))

        return dp[index]
    }

    recurse(0)

    return min(dp[0], dp[1])
}
