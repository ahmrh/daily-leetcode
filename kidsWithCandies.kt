fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> {
    val max = candies.max()
    val boolArray = mutableListOf<Boolean>()

    candies.forEach{ candy ->
        boolArray.add(candy + extraCandies >= max)
    }

    return boolArray
}
