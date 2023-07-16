fun maxProfit(prices: IntArray): Int {
    
    var maxProfit = 0
    var minPrice = prices[0]


    for(i in 1 until prices.size){

        val price = prices[i]
        val profit = price - minPrice

        maxProfit = maxProfit.coerceAtLeast(profit)

        if(price < minPrice) minPrice = price
    }

    return maxProfit

}