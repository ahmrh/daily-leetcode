fun isBalanced(root: TreeNode?): Boolean {
    var isBalanced = true

    fun checkBalance(node: TreeNode?) : Int{
        if(node == null) return 0

        val left = checkBalance(node.left)
        val right = checkBalance(node.right)

        if(Math.abs(left - right) > 1) isBalanced = false

        if(left > right)
            return left + 1
        else
            return right + 1
    }
    checkBalance(root)

    return isBalanced
}
