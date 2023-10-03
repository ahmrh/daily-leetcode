fun uniqueOccurrences(arr: IntArray): Boolean {
    var hashMap = HashMap<Int, Int>()

    arr.forEach{
        hashMap.put(it, hashMap.get(it)?.plus(1) ?: 1)
    }

    for(value in hashMap.values){
        val keys = hashMap.filterValues { it == value }.keys
        if(keys.size > 1) return false
    }

    return true
}
