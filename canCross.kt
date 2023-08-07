fun canCross(stones: IntArray): Boolean {

    // tabulation
    val table = BooleanArray(stones.size)

    fun cross(index: Int, k: Int): Boolean{
        if(index == stones.size - 1)  return true

        if(index == 0 && stones[0] + 1 == stones[1])
            table[index] =
                cross( 1, 1) ||
                        cross( 1, 0) ||
                        cross( 1, 2)

        if(table[index]) return true

        var jump = 1
        for(i in index + 1 until stones.size) {
            if (stones[index] + k == stones[i]) {
                jump = i - index
                break
            }

            if (i == stones.size - 1) return false
        }

        table[index] =
            cross(index + jump, k ) ||
                    cross(index + jump, k - 1 ) ||
                    cross(index + jump, k + 1)

        return table[index]
    }

    cross(0, 1)

    return table[0]
}
