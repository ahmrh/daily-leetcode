package com.ahmrh.test

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.merge
import java.lang.Exception
import kotlin.math.max

class test {

}

fun lengthOfLongestSubstring(s: String): Int {

    var length = 0
    val arr = mutableListOf<Char>()

    var iterator = 0
    while (iterator < s.length) {

        for (i in iterator until s.length) {
            val char = s[i]
            if (char !in arr)
                arr.add(char)
            else {
                arr.clear()
                break
            }

            println(arr)
            if (length < arr.size) length = arr.size
        }

        iterator += 1
    }

    return length
}

fun maxProfit(prices: IntArray): Int {

    var maxProfit = 0
    var minPrice = prices[0]


    for (i in 1 until prices.size) {

        val price = prices[i]
        val profit = price - minPrice

        maxProfit = maxProfit.coerceAtLeast(profit)

        if (price < minPrice) minPrice = price
    }

    return maxProfit

}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    val listNode = ListNode(0)

    var current = listNode
    var listNode1 = l1
    var listNode2 = l2

    var carry = 0
    while (listNode1 != null || listNode2 != null || carry != 0) {
        val v1 = listNode1?.`val` ?: 0
        val v2 = listNode2?.`val` ?: 0

        var sum = v1 + v2 + carry
        println("${listNode1?.`val`} + ${listNode2?.`val`} = $sum")

        println("carry = ${carry}")

        carry = if (sum > 9) 1 else 0
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


fun climbStairs(n: Int): Int {

    //tabulation
    val savedStep = mutableListOf(1, 2)
    return when (n) {
        1 -> 1
        2 -> 2
        else -> {
            for (i in 2..n) {
                savedStep.add(savedStep[i - 1] + savedStep[i - 2])
            }
            savedStep[n - 1]
        }
    }
}

fun longestPalindrome(s: String): String {

    var temp = ""
    var length = 0

    fun iteratePalindrome(startIndex: Int, endIndex: Int) {
        var left = startIndex
        var right = endIndex

        while (left >= 0 && right < s.length && s[left] == s[right]) {
            if ((right - left + 1) > length) {
                temp = s.substring(left, right + 1)
                length = right - left + 1
            }
            left -= 1
            right += 1
        }
    }

    s.forEachIndexed { index, c ->
        iteratePalindrome(index, index + 1)
        iteratePalindrome(index, index)
    }

    return temp

}


fun isValid(s: String): Boolean {
    val stack = mutableListOf<Char>()

    fun check(param: Char): Boolean {
        if (stack.lastOrNull() == param) {
            stack.removeAt(stack.size - 1)
            return true
        }
        return false
    }

    s.forEach {
        when (it) {
            ')' -> if (!check('(')) return false
            '}' -> if (!check('{')) return false
            ']' -> if (!check('[')) return false
            else -> stack.add(it)
        }
    }
    return stack.isEmpty()
}


//fun mergeTwoLists(
//    list1: ListNode?,
//    list2: ListNode?,
//): ListNode? {
//    val result = ListNode(0)
//
//    var currentResult = ListNode(0)
//    var current1 = list1
//    var current2 = list2
//
//    while (current1.`val` != null || current2.`val` != null) {
//        val val1 = current1?.`val`
//        val val2 = current2?.`val`
//
//        if (val1 != null && val1 > val2!!) {
//            currentResult.`val` = val1
//        } else if (val2 != null && val2 > val1!!) {
//            currentResult.`val` = val2
//        }
//
//        currentResult = currentResult.next!!
//        current1 = current1?.next
//        current2 = current2?.next
//    }
//
//    return result
//}

fun convertTemperature(celsius: Double): DoubleArray =
    doubleArrayOf(
        toKelvin(celsius),
        toFahrenheit(celsius)
    )

val toFahrenheit =
    { celsius: Double -> celsius * 1.80 + 32.00 }
val toKelvin = { celsius: Double -> celsius + 273.15 }

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun isSymmetric(root: TreeNode?): Boolean {

    if (root == null) return true

    var leftVal = ""
    var rightVal = ""

    fun dfsLeft(node: TreeNode?) {
        if (node == null) {
            leftVal += "null"
            return
        }

        dfsLeft(node.left)
        leftVal += node.`val`
        dfsLeft(node.right)
    }

    fun dfsRight(node: TreeNode?) {
        if (node == null) {
            rightVal += "null"
            return
        }

        dfsRight(node.right)
        rightVal += node.`val`
        dfsRight(node.left)
    }

    dfsLeft(root.left)
    dfsRight(root.right)

    return leftVal == rightVal

}

fun threeSum(nums: IntArray): List<List<Int>> {
    val sums = mutableListOf<List<Int>>()
    var sum: List<Int>

    var a: Int;
    var b: Int;
    var c: Int


    for (i in nums.indices) {
        a = nums[i]

        for (j in i + 1 until nums.size) {
            b = nums[j]

            for (k in j + 1 until nums.size) {
                c = nums[k]

                sum = listOf(a, b, c)

                val cond1 = a + b + c == 0
                val cond2 = i != j && j != k && i != j
                var cond3 = checkDistinct(sums, sum)



                if (cond1 && cond2 && cond3) {
                    sums.add(sum)
                    break
                }
            }
        }
    }

    return sums
}

fun checkDistinct(
    sums: List<List<Int>>,
    check: List<Int>
): Boolean {
    sums.forEach {
        val sortedSum = it.sorted()
        val sortedCheck = check.sorted()

        if (sortedSum[0] == sortedCheck[0]
            && sortedSum[1] == sortedCheck[1]
            && sortedSum[2] == sortedCheck[2]
        )
            return false
    }

    return true
}


fun plusOne(digits: IntArray): IntArray {
    var sum = digits.clone()

    for (i in sum.size - 1 downTo 0) {
        if (sum[i] < 9) {
            sum[i] += 1
            return sum
        }
        sum[i] = 0
    }

    sum = IntArray(digits.size + 1)

    sum[0] = 1

    return sum
}


fun countDigits(num: Int): Int {

    var count = 0
    var digits = num

    while (digits > 0) {
        val digit = digits % 10
        digits /= 10

        if (num % digit == 0)
            count += 1

    }
    return count
}


fun maxDepth(root: TreeNode?): Int {
    println("${root?.`val`}")

    if (root == null) return 0
    return 1 + max(maxDepth(root.right), maxDepth(root.left))
}

fun searchRange(nums: IntArray, target: Int): IntArray {
    var firstIndex = -1;
    var lastIndex = -1;

    nums.forEachIndexed { index, num ->
        val last = nums.size - index - 1

        if (nums[index] == target && firstIndex == -1) firstIndex = index
        if (nums[last] == target && lastIndex == -1) lastIndex = last
    }

    return intArrayOf(firstIndex, lastIndex)
}

fun makeFlow() = flow {
    println("mengirimkan nilai pertama")
    emit(1)

    println("sudah dapat nilai pertama, kirim nilai kedua")
    emit(2)
    println("sudah dapat nilai kedua, kirim nilai ketiga")
    emit(3)
    println("selesai")
}

fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    val nums = nums1.plus(nums2).sorted()

    return if (nums.size % 2 != 0) nums[nums.size / 2].toDouble()
    else (nums[nums.size / 2] + nums[nums.size / 2 - 1]) / 2.0
}

fun isValidSudoku(board: Array<CharArray>): Boolean {
    val stack = mutableListOf<Char>()

    for (i in 0 until 9) {
        for (j in 0 until 9) {
            if (board[i][j] == '.') continue

            if (stack.contains(board[i][j])) return false
            else stack.add(board[i][j])
        }

        stack.clear()
    }


    for (i in 0 until 9) {
        for (j in 0 until 9) {
            if (board[j][i] == '.') continue

            if (stack.contains(board[j][i])) return false
            else stack.add(board[j][i])
        }

        stack.clear()
    }

    for (i in 0 until 9 step 3)
        for (j in 0 until 9 step 3) {
            for (k in i until i + 3) {
                for (l in j until j + 3) {
                    if (board[k][l] == '.') continue

                    if (stack.contains(board[k][l])) return false
                    else stack.add(board[k][l])
                }
            }
            stack.clear()
        }

    return true

}


fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {

    if (p == null && q == null) return true
    if (p?.`val` != q?.`val`) return false

    return isSameTree(p?.left, q?.left) && isSameTree(p?.right, q?.right)

}


fun inorderTraversal(root: TreeNode?): List<Int> {
    val list = mutableListOf<Int>()
    fun traverse(node: TreeNode?) {
        if (node == null) return

        list.add(node.`val`)
        traverse(node.left)
        traverse(node.right)

    }
    traverse(root)
    return list
}


fun sortColors(nums: IntArray): Unit {

    for (i in 0 until nums.size) {
        for (j in i + 1 until nums.size) {
            if (nums[i] > nums[j]) {
                val temp = nums[i]
                nums[i] = nums[j]
                nums[j] = temp
            }
        }
    }
}

fun replaceWords(dictionary: List<String>, sentence: String): String {
    val words = sentence.split(" ").toMutableList()

    words.forEachIndexed { index, word ->
        var dictionaryWord = ""

        for (d in dictionary) {
            if (word.length <= d.length) continue

            if (word.substring(0, d.length) == d) {
                words[index] = d
//                count += 1
            }

        }
    }

    return words.joinToString(" ")
}


fun canJump(nums: IntArray): Boolean {

    val table = BooleanArray(nums.size)

    fun recursion(index: Int): Boolean {
        if (index >= nums.size - 1) return true
        if (nums[index] == 0) return false

        for (i in index + 1..index + nums[index]) {

            if (i < nums.size) {
                table[index] = recursion(i)
            }
        }

        return false
    }

    table[0] = recursion(0)


    return table[0]
}


//fun canJump(nums: IntArray): Boolean {
//    if(nums.size == 1) return true
//
//    for(i in nums.indices)
//        if(nums[i] == 0)
//            for(j in i downTo 0){
//                if(nums[j] + j > i || nums[j] + j >= nums.size - 1) break
//                if(j == 0) return false
//            }
//
//    return true
//}

fun isBalanced(root: TreeNode?): Boolean {
    var isBalanced = true

    fun checkBalance(node: TreeNode?): Int {
        if (node == null) return 0

        val left = checkBalance(node.left)
        val right = checkBalance(node.right)

        if (Math.abs(left - right) > 1) isBalanced = false

        if (left > right)
            return left + 1
        else
            return right + 1
    }
    checkBalance(root)

    return isBalanced
}

fun canCross(stones: IntArray): Boolean {
    // tabulation
    val table = BooleanArray(stones.size)

    fun cross(index: Int, k: Int): Boolean {
        if (index == stones.size - 1) return true

        if (index == 0 && stones[0] + 1 == stones[1])
            table[index] =
                cross(1, 1) ||
                        cross(1, 0) ||
                        cross(1, 2)

        if (table[index]) return true

        var jump = 1
        for (i in index + 1 until stones.size) {
            if (stones[index] + k == stones[i]) {
                jump = i - index
                break
            }

            if (i == stones.size - 1) return false
        }

        table[index] =
            cross(index + jump, k) ||
                    cross(index + jump, k - 1) ||
                    cross(index + jump, k + 1)

        return table[index]
    }

    cross(0, 1)

    return table[0]
}

class ParkingSystem(big: Int, medium: Int, small: Int) {
    private val park = intArrayOf(big, medium, small)

    fun addCar(carType: Int): Boolean {
        if (park[carType - 1] == 0) return false

        park[carType - 1] -= 1
        return true
    }

}


fun maxArea(height: IntArray): Int {
    var i = 0
    var j = height.size - 1
    var area = 0

    fun countArea(a: Int, b: Int) = Math.min(height[a], height[b]) * (b - a)

    while (i < j) {
        if (area < countArea(i, j)) area = countArea(i, j)

        if (height[i] > height[j])
            j--
        else
            i++
    }

    return area
}


fun longestCommonPrefix(strs: Array<String>): String {
    var prefix = strs[0]

    for (i in strs.indices) {
        if (prefix.isEmpty()) break

        val str = strs[i]
        try {
            for (j in 0 until Math.max(prefix.length, str.length)) {
                if (str[j] != prefix[j]) {
                    prefix = prefix.substring(0, j)
                    break
                }
            }
        } catch (e: Exception) {
            prefix = prefix.substring(0, Math.min(prefix.length, str.length))
        }
    }

    return prefix
}

fun longestCommonPrefixFaster(strs: Array<String>): String {
    val sorted = strs.sorted()
    val first = sorted[0]
    val last = sorted[sorted.size - 1]

    var prefix = ""

    for (i in 0 until Math.min(first.length, last.length)) {
        if (first[i] != last[i])
            return prefix
        prefix += first[i]
    }

    return prefix
}


fun deleteDuplicates(head: ListNode?): ListNode? {
    if (head == null) return head

    val listNode = ListNode(head.`val`)
    var p0: ListNode? = listNode

    var value = head.`val`
    var p1 = head

    while (p1!!.next != null) {
        p1 = p1.next

        if (value != p1!!.`val`) {
            value = p1.`val`
            p0!!.next = ListNode(value)
            p0 = p0.next
        }

    }

    return listNode
}

fun removeDuplicates(nums: IntArray): Int {
    return nums.sorted().distinct().size
}


fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {

    var a = list1
    var b = list2

    var merged = ListNode(-100)
    val head = merged

    fun mergeB() {
        merged.next = ListNode(b!!.`val`)
        b = b!!.next
    }

    fun mergeA() {
        merged.next = ListNode(a!!.`val`)
        a = a!!.next
    }
    while (a != null || b != null) {
        if (a == null) mergeB()
        else if (b == null) mergeA()
        else if (a!!.`val` > b!!.`val`) mergeB()
        else mergeA()

        merged = merged.next!!
    }

    return head.next
}

fun mergeTrees(root1: TreeNode?, root2: TreeNode?): TreeNode? {
    if (root1 == null) return root2
    if (root2 == null) return root1

    val merged = TreeNode(root1.`val` + root2.`val`)

    fun merge(node: TreeNode?, node1: TreeNode?, node2: TreeNode?): TreeNode? {

        if (node1 == null) return node2
        if (node2 == null) return node1

        node?.left = merge(node?.left, node1?.left, node2.left)
        node?.right = merge(node?.right, node1?.right, node2.right)


        return TreeNode(node1.`val` + node2.`val`)
    }


    return merge(merged, root1, root2)
}

// naive and ordinary
fun numIdenticalPairs(nums: IntArray): Int {
    var count = 0

    for (i in nums.indices) {
        for (j in i + 1 until nums.size) {
            if (nums[i] == nums[j]) count += 1
        }
    }

    return count
}

// interesting solution
fun numIdenticalPairsInteresting(nums: IntArray): Int {
    val count = nums.mapIndexed { i, n ->
        nums.slice(i + 1..nums.lastIndex).count { it == n }
    }.sum()

    return count
}

fun strStr(haystack: String, needle: String): Int {
    for (i in 0..haystack.length - needle.length) {
        if (haystack.substring(i, i + needle.length) == needle)
            return i
    }

    return -1
}

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



@OptIn(DelicateCoroutinesApi::class)
fun main(args: Array<String>) {


    val listNode = ListNode(3)
    listNode.next = ListNode(4)
    listNode.next!!.next = ListNode(1)

    sortList(listNode)
//    var nums = intArrayOf(1, 2, 3, 1, 1, 3)
//    numIdenticalPairs(nums)
//
//    val root1 = TreeNode(1)
//    root1.left = TreeNode(3)


//    val strs = arrayOf("ab", "a")
//
//    println(longestCommonPrefix(strs))

//    var arr = intArrayOf(1,8,6,2,5,4,8,3,7)
//    println(maxArea(arr))

//    val b = intArrayOf(0,1,3,5,6,8,12,17)
//    println("Can Cross = ${
//        canCross(b)
//    }")
//    val nums = intArrayOf(1,1,2)
//    println(removeDuplicates(nums))

//    val p = TreeNode(1)
//    p.left = TreeNode(2)
//    p.right = TreeNode(3)
//
//    val q = TreeNode(1)
//    q.left = TreeNode(2)
//    q.right = TreeNode(4)
//
//    println(isSameTree(p, q))


//    runBlocking {
//        launch {
//            makeFlow().collect { value ->
//                println("dapat nilai $value")
//            }
//            println("flow sudah selesai")
//        }
//    }


//    val nums = intArrayOf(5,7,7,8,8,10)
//    val target = 8
//
//    val searched = searchRange(nums, target)
//    searched.forEach{ print(it)}


//    val num = 1248ums.size - index - 1
//    println(countDigits(num))
//
//    val digits = intArrayOf(9,9,9,9,9,9)
//    var a = plusOne(digits)
//
//    a.forEach{
//        print(it)
//    }

//    val s = "{[]}"
//    print(isValid(s))

//    val s = "cbbd"
//    print(longestPalindrome(s))

//    val n = 7
//    println(climbStairs(n))

//    val prices: IntArray = intArrayOf(7, 1, 5, 3, 6, 4)
//
//    println(maxProfit(prices))

//    val s = "jbpnbwwd"
//
//    print(lengthOfLongestSubstring(s))


}