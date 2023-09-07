override fun guessNumber(n:Int):Int {
        if(guess(1) == 0) return 1
        if(guess(n) == 0) return n

        var number = -1

        var guessed = false
        var a = 1
        var b = n

        while(!guessed){
            val c = ((b - a) / 2) + a
            println("$a $c $b")
            when(guess(c)){
                1 -> {
                    a = c
                }
                -1 -> {
                    b = c
                }
                0 -> {
                    guessed = true
                    number = c
                }
            }
        }

        return number
    }
