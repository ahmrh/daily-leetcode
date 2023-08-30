fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
    var flowers = n
    fun canPlant(index: Int): Boolean{
        return if(flowerbed.size == 1) flowerbed[index] == 0
        else{
            if(index == 0)
                flowerbed[1] == 0
            else if(index == flowerbed.size - 1)
                flowerbed[index - 1] == 0
            else
                flowerbed[index - 1] == 0 && flowerbed[index + 1] == 0
        }
    }

    for(i in flowerbed.indices){
        if(flowerbed[i] == 0 && canPlant(i)){
            flowerbed[i] = 1
            flowers -= 1
        }
    }

    return flowers <= 0
}
