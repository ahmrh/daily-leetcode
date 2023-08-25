fun moveZeroes(nums: IntArray): Unit {
    if(!nums.contains(0)) return

    var j = nums.indexOf(0)

    for(i in j + 1 until nums.size){

        if(nums[i] != 0){
            j = nums.indexOf(0)
            nums[j] = nums[i]
            nums[i] = 0
        }

    }
}
