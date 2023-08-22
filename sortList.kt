
fun sortList(head: ListNode?): ListNode? {
    data class p(
        var listNode: ListNode? = null
    )

    fun printListNode(head: ListNode?) {

        val pointer = p(head)

        while (pointer.listNode != null) {
            print("${pointer.listNode?.`val`} ")
            pointer.listNode = pointer.listNode?.next
        }
        println()
    }

    fun getMiddlePrec(head: ListNode?): ListNode? {

        if (head == null) return head

        var slow = head
        var fast = head

        while (fast!!.next != null && fast.next!!.next != null) {
            fast = fast.next!!.next
            slow = slow!!.next
        }

        return slow
    }

    fun merge(left: ListNode?, right: ListNode?): ListNode? {
        var leftPointer = left
        var rightPointer = right

        val dummy = ListNode(-1)
        var pointer: ListNode? = dummy

        while (leftPointer != null && rightPointer != null) {
            var listNode: ListNode? = null

            if (leftPointer.`val` < rightPointer.`val`) {
                listNode = leftPointer
                leftPointer = leftPointer.next
            } else {
                listNode = rightPointer
                rightPointer = rightPointer.next
            }
            pointer?.next = listNode
            pointer = listNode
        }

        if (leftPointer != null) pointer?.next = leftPointer
        if (rightPointer != null) pointer?.next = rightPointer

        return dummy.next

    }

    if (head?.next == null) return head
    val middlePrec = getMiddlePrec(head)
    val middle = middlePrec?.next
    middlePrec?.next = null


    val sorted = merge(sortList(head), sortList(middle))
    printListNode(sorted)
    return sorted
}
