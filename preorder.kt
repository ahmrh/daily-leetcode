fun preorder(root: Node?): List<Int> {
  val list = mutableListOf<Int>()

  fun traverse(node: Node?){
      if(node == null) return

      list.add(node.`val`)

      val childs = node.children
      childs.forEach{
          traverse(it)
      }
  }

  traverse(root)
  return list
}
