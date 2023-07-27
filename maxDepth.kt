fun maxDepth(root: TreeNode?): Int {
    println("${root?.`val`}")

    if(root == null) return 0
    return 1 + max(maxDepth(root.right), maxDepth(root.left))
}
