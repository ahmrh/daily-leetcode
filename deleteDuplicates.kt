fun deleteDuplicates(head: ListNode?): ListNode? {
    if(head == null) return head

    val listNode = ListNode(head.`val`)
    var p0: ListNode? = listNode

    var value = head.`val`
    var p1 = head

    while(p1!!.next != null) {
        p1 = p1.next

        if(value != p1!!.`val`){
            value = p1.`val`
            p0!!.next = ListNode(value)
            p0 = p0.next
        }

    }

    return listNode
}
