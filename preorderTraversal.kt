    fun preorderTraversal(root: TreeNode?): List<Int> {
        val list = mutableListOf<Int>()

        fun traverse(node: TreeNode?){
            if(node == null) return

            list.add(node.`val`)
            traverse(node.left)
            traverse(node.right)
            
        }

        traverse(root)

        return list
    }
