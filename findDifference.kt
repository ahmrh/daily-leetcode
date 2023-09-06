fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {
       val diff1 = mutableListOf<Int>()

        nums1.forEach{
            if(!nums2.contains(it) && !diff1.contains(it))
                diff1.add(it)
        }

        val diff2 = mutableListOf<Int>()
        nums2.forEach{
            if(!nums1.contains(it) && !diff2.contains(it))
                diff2.add(it)
        }

        return listOf(diff1, diff2)
    }
