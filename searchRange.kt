fun searchRange(nums: IntArray, target: Int): IntArray {
    var firstIndex = -1; var lastIndex = -1;

    nums.forEachIndexed{ index, num ->
        val last = nums.size - index - 1

        if (nums[index] == target && firstIndex == -1) firstIndex = index
        if(nums[last] == target && lastIndex == -1) lastIndex = last
    }

    return intArrayOf(firstIndex, lastIndex)
}
