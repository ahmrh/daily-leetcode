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
