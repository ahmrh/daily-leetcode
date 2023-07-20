
fun isValid(s: String): Boolean {
    val stack = mutableListOf<Char>()

    fun check(param: Char) : Boolean{
        if(stack.lastOrNull() == param){
            stack.removeAt(stack.size - 1)
            return true
        }
        return false
    }

    s.forEach{
        when(it){
            ')' -> if(!check('(')) return false
            '}' -> if(!check('{')) return false
            ']' -> if(!check('[')) return false
            else -> stack.add(it)
        }
    }
    return stack.isEmpty()
}
