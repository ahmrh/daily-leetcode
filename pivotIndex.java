 public int pivotIndex(int[] nums) {

        for(int i = 0; i < nums.length; i ++){
            int left = sumOfArray(Arrays.copyOfRange(nums, 0, i));
            int right = sumOfArray(Arrays.copyOfRange(nums, i + 1, nums.length - 1));
            if(left == right) return i;
        }

        return -1;
    }

    int sumOfArray(int[] arr){
        return Arrays.stream(arr).sum();
    }
