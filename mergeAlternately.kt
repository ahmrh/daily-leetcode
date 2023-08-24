fun mergeAlternately(word1: String, word2: String): String {
    var s = ""

    val s1 = word1.toMutableList()
    val s2 = word2.toMutableList()

    while(s1.size != 0 && s2.size != 0){
        if(s.length % 2 == 0) {
            s += s1[0]
            s1.removeAt(0)
        }
        else {
            s += s2[0]
            s2.removeAt(0)
        }
    }

    if(s1.size != 0){
        s += s1.joinToString(separator = "")
    }
    if(s2.size != 0){
        s += s2.joinToString(separator = "")
    }

    return s
}

fun mergeAlternatelyWithStringBuilder(word1: String, word2: String): String {
    val sb = StringBuilder()

    for(i in 0 until Math.min(word1.length, word2.length)){
        sb.append(word1[i])
        sb.append(word2[i])
    }

    if(word1.length > word2.length)
        sb.append(word1.substring(word2.length))

    else if(word1.length < word2.length)
        sb.append(word2.substring(word1.length))

    return sb.toString()
}

