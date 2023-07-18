
fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    val listNode = ListNode(0)

    var current = listNode
    var listNode1 = l1
    var listNode2 = l2

    var carry = 0
    while(listNode1 != null || listNode2 != null || carry != 0){
        val v1 = listNode1?.`val` ?: 0
        val v2 = listNode2?.`val` ?: 0

        var sum = v1 + v2 + carry
        println("${listNode1?.`val`} + ${listNode2?.`val`} = $sum")

        println("carry = ${carry}")

        carry = if(sum > 9) 1 else 0
        sum %= 10
        current.next = ListNode(sum)

        current = current.next!!
        listNode1 = listNode1?.next
        listNode2 = listNode2?.next
    }

    return listNode.next

}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}
