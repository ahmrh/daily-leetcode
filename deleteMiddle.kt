fun deleteMiddle(head: ListNode?): ListNode? {
    val head = head
    var slow = head
    var fast = head
    var slowPred = head

    while(fast?.next?.next != null && slow?.next != null){
        slowPred = slow
        slow = slow.next
        fast = fast.next?.next
    }

    if(fast == slow){
        if(slow?.next == null) return null

        fast?.next = null
        return fast
    }

    if(fast?.next == null)
        slowPred?.next = slow?.next
    else
        slow?.next = slow?.next?.next
    
    return head
}
