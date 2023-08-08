class ParkingSystem(big: Int, medium: Int, small: Int) {
    private val park = intArrayOf(big, medium, small)

    fun addCar(carType: Int): Boolean {
        if(park[carType - 1] == 0) return false

        park[carType - 1] -= 1
        return true
    }

}
