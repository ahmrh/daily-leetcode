fun maxVowels(s: String, k: Int): Int {
    val vowels = setOf('a', 'e', 'i', 'o', 'u')
    var max = s.substring(0, k).count{ it in vowels}
    var count = max

    for(i in k until s.length){
        if(s[i - k] in vowels){
            count --
        }
        if(s[i] in vowels){
            count ++
        }
        max = maxOf(max, count)
    }

    return max
}
