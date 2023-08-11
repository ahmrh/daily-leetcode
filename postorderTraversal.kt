fun postorderTraversal(root: TreeNode?): List<Int> {
    val list = mutableListOf<Int>()

    fun traverse(node: TreeNode?){
        if(node == null) return 
        
        traverse(node.left)
        traverse(node.right)
        list.add(node.`val`)
    }

    traverse(root)

    return list
}
