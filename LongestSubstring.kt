class Solution {
    fun lengthOfLongestSubstring(s: String): Int {  
    var length = 0
    val arr = mutableListOf<Char>()

    var iterator = 0
    while(iterator < s.length){

        for(i in iterator until s.length){
            val char = s[i]
            if(char !in arr)
                arr.add(char)

            else{
                arr.clear()
                break
            }

            if(length < arr.size) length = arr.size
        }

        iterator += 1
    }

    return length
    }
}