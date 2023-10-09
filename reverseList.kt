fun reverseList(head: ListNode?): ListNode? {

    val reversedHead = ListNode(-1)
    var reversed: ListNode? = reversedHead

    fun recurse(node: ListNode?){
        if(node == null) return

        recurse(node.next)

        reversed?.next = ListNode(node.`val`)
        reversed = reversed?.next
    }

    recurse(head)

    return reversedHead.next
}
