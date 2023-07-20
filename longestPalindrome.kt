
fun longestPalindrome(s: String): String {

    var temp = ""
    var length = 0

    fun iteratePalindrome(startIndex: Int, endIndex: Int){
        var left = startIndex
        var right = endIndex

        while(left >= 0 && right < s.length && s[left] == s[right]){
            if((right - left + 1) > length){
                temp = s.substring(left, right + 1)
                length = right - left + 1
            }
            left -= 1
            right += 1
        }
    }

    s.forEachIndexed{ index, c ->
        iteratePalindrome(index, index + 1)
        iteratePalindrome(index, index)
    }

    return temp

}
