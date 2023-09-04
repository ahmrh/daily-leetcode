fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
    var leaf1 = StringBuilder()
    var leaf2 = StringBuilder()

    fun traverse(node: TreeNode?, leaf: StringBuilder){
        if(node == null) return

        traverse(node?.left, leaf)

        if(node?.left == null && node?.right == null)
            leaf.append("${node?.`val`} ")

        traverse(node?.right, leaf)

    }

    traverse(root1, leaf1)
    traverse(root2, leaf2)

    return leaf1.toString()== leaf2.toString()
}
