fun removeStars(s: String): String {
    val stack: ArrayDeque<Char> = ArrayDeque()
    s.forEach{
        if(it == '*') stack.removeLast()
        else stack.addLast(it)
    }
    return stack.joinToString(separator = "")
}

