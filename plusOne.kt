
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

