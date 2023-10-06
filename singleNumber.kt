fun singleNumber(nums: IntArray): Int {
    var number = 0

    nums.forEach{
        number = number xor it
    }

    return number
}
