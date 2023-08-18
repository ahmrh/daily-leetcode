
fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {

    var a = list1
    var b = list2

    var merged = ListNode(-100)
    val head = merged

    fun mergeB(){
        merged.next = ListNode(b!!.`val`)
        b = b!!.next
    }
    fun mergeA(){
        merged.next = ListNode(a!!.`val`)
        a = a!!.next
    }
    while(a != null || b != null){
        if(a == null) mergeB()
        else if(b == null) mergeA()
        else if(a!!.`val` > b!!.`val`) mergeB()
        else mergeA()

        merged = merged.next!!
    }

    return head.next
}
