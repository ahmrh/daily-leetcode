fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    val nums = nums1.plus(nums2).sorted()

    return if(nums.size % 2 != 0) nums[nums.size / 2].toDouble()
    else (nums[nums.size / 2] + nums[nums.size / 2 - 1]) / 2.0
}
