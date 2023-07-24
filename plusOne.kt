
fun plusOne(digits: IntArray): IntArray {

    val a : MutableList<Int> = digits.clone().toMutableList()


    var i = a.size - 1
    var carrier = 1

    while(carrier != 0 && i > -2) {


        if(i < 0) a.add(0, carrier)
        else {
            a[i] += carrier

            if(a[i] == 10){
                carrier = 1
                a[i] = 0
            } else
                carrier = 0
        }

        println(a[i])
        i -= 1
    }

    return a.toIntArray()
}

fun plusOneFaster(digits: IntArray): IntArray {
    var sum = digits.clone()

    for(i in sum.size - 1 downTo 0){
        if(sum[i] < 9){
            sum[i] += 1
            return sum
        }
        sum[i] = 0
    }

    sum = IntArray(digits.size + 1)
    
    sum[0] = 1

    return sum
}
