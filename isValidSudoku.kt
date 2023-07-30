
fun isValidSudoku(board: Array<CharArray>): Boolean {
    val stack = mutableListOf<Char>()

    for(i in 0 until 9){
        for(j in 0 until 9){
            if(board[i][j] == '.') continue

            if(stack.contains(board[i][j])) return false
            else stack.add(board[i][j])
        }

        stack.clear()
    }


    for(i in 0 until 9){
        for(j in 0 until 9){
            if(board[j][i] == '.') continue

            if(stack.contains(board[j][i])) return false
            else stack.add(board[j][i])
        }

        stack.clear()
    }

    for(i in 0 until 9 step 3)
        for(j in 0 until 9 step 3){
            for(k in i until i + 3){
                for(l in j until j + 3){
                    if(board[k][l] == '.') continue

                    if(stack.contains(board[k][l])) return false
                    else stack.add(board[k][l])
                }
            }
            stack.clear()
        }

    return true

}
