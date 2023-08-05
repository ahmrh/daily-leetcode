fun canJump(nums: IntArray): Boolean {
    if(nums.size == 1) return true

    for(i in nums.indices)
        if(nums[i] == 0)
            for(j in i downTo 0){
                if(nums[j] + j > i || nums[j] + j >= nums.size - 1) break
                if(j == 0) return false
            }

    return true
}
