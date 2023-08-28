class RecentCounter() {
    val counter = mutableListOf<Int>()
    fun ping(t: Int): Int {

        counter.add(t)

        while(t - counter[0] > 3000) counter.removeAt(0)
        
        return counter.size
    }
}
