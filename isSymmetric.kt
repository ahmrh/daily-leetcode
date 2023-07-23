
fun isSymmetric(root: TreeNode?): Boolean {

    if(root == null) return true

    var leftVal = ""
    var rightVal = ""

    fun dfsLeft(node: TreeNode?){
        if(node == null) {
            leftVal += "null"
            return
        }

        dfsLeft(node.left)
        leftVal += node.`val`
        dfsLeft(node.right)
    }

    fun dfsRight(node: TreeNode?){
        if(node == null) {
            rightVal += "null"
            return
        }

        dfsRight(node.right)
        rightVal += node.`val`
        dfsRight(node.left)
    }

    dfsLeft(root.left)
    dfsRight(root.right)

    return  leftVal == rightVal

}

