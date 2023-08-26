fun findMaxAverage(nums: IntArray, k: Int): Double {

    var sum = 0.0
    for(i in 0 until k)
        sum += nums[i]


    var maxAverage = sum / k

    for(i in k until nums.size){

        sum += nums[i]
        sum -= nums[i - k]

        val average = sum / k
        if(maxAverage < average) maxAverage = average
    }

    return maxAverage
}
