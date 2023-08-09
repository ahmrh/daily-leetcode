fun longestCommonPrefix(strs: Array<String>): String {
    var prefix = strs[0]

    for(i in strs.indices){
        if(prefix.isEmpty()) break

        val str = strs[i]
        try{
            for(j in 0 until Math.max(prefix.length, str.length)){
                if(str[j] != prefix[j]){
                    prefix = prefix.substring(0, j)
                    break
                }
            }
        } catch(e: Exception){
            prefix = prefix.substring(0, Math.min(prefix.length, str.length))
        }
    }

    return prefix
}
