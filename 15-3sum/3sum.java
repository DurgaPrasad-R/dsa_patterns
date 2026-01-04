class Solution {
    List<List<Integer>> result = new ArrayList<>();
    Set<List<Integer>> found = new HashSet<>();

    public void findTwoSum(int[] nums, int target, int left, int right) {
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                List<Integer> temp = Arrays.asList(-target, nums[left], nums[right]);
                if (!found.contains(temp)) {
                    result.add(temp);
                    found.add(temp);
                }

                left += 1;
            }

            else if (nums[left] + nums[right] > target) {
                right -= 1;
            } else {
                left += 1;
            }
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            findTwoSum(nums, -nums[i], i+1, n-1);
        }

        return result;
    }
}