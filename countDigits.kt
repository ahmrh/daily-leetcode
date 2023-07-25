fun countDigits(num: Int): Int {

    var count = 0
    var digits = num

    while(digits > 0){
        val digit = digits % 10
        digits /= 10

        if(num % digit == 0)
            count += 1

    }
    return count
}
