// naive and ordinary
fun numIdenticalPairs(nums: IntArray): Int {
    var count = 0

    for(i in nums.indices){
        for(j in i + 1 until nums.size){
            if(nums[i] == nums[j]) count += 1
        }
    }

    return count
}

// interesting solution
fun numIdenticalPairsInteresting(nums: IntArray): Int {
    val count = nums.mapIndexed { i, n ->
        nums.slice(i + 1..nums.lastIndex).count { it == n }
    }.sum()

    return count
}
