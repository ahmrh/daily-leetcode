fun sortedArrayToBST(nums: IntArray): TreeNode? {
    fun build(array: IntArray): TreeNode?{
        if(array.size == 1) return TreeNode(array[0])
        if(array.size == 0) return null
        
        val center = array.size / 2
        val node = TreeNode(array[center])
        
        val leftArray = array.copyOfRange(0, center)
        val rightArray = array.copyOfRange(center + 1, array.size)

        node.left = build(leftArray)
        node.right = build(rightArray)
        
        return node
    }
        
    return build(nums)
}
