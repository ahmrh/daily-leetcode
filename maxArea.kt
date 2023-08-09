fun maxArea(height: IntArray): Int {
    var i = 0
    var j = height.size - 1
    var area = 0

    fun countArea(a: Int, b: Int) = Math.min(height[a], height[b]) * (b - a)

    while(i < j){
        if(area < countArea(i, j)) area = countArea(i, j)

        if(height[i] > height[j])
            j --
        else
            i ++
    }

    return area
}
