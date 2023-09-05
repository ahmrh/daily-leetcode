fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
    
    var tree: TreeNode? = null
    var found = false
    
    fun traverse(node: TreeNode?){
        if(node == null) return
        
        traverse(node.left)
        if(node.`val` == `val` && !found){
            tree = node
            found = true
        }
        
        traverse(node.right)
    }
    traverse(root)
    
    return tree
}

