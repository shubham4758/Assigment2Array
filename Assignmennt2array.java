// 1. Solution 

//Time= O(n log n)
//Space=O(1)

import java.util.Arrays;

public class ArrayPairSum {
    public int arrayPairSum(int[] nums) {
        // Sort the array in ascending order
        Arrays.sort(nums);

        int sum = 0;
        // Iterate through the sorted array and add every second element to the sum
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 2};
        ArrayPairSum solution = new ArrayPairSum();
        int maxSum = solution.arrayPairSum(nums);
        System.out.println("Maximum sum: " + maxSum);
    }
}


// 2. Solution 

//Time= O(n)
//Space=O(n)

import java.util.HashSet;

public class MaxCandies {
    public int maxCandies(int[] candyType) {
        int maxAllowed = candyType.length / 2;
        HashSet<Integer> uniqueCandyTypes = new HashSet<>();

        for (int candy : candyType) {
            uniqueCandyTypes.add(candy);

            if (uniqueCandyTypes.size() == maxAllowed) {
                break;
            }
        }

        return uniqueCandyTypes.size();
    }

    public static void main(String[] args) {
        int[] candyType = {1, 1, 2, 2, 3, 3};
        MaxCandies solution = new MaxCandies();
        int maxTypes = solution.maxCandies(candyType);
        System.out.println("Maximum number of different types of candies: " + maxTypes);
    }
}


// 3. Solution 

//Time= O(n)
//Space=O(n)

import java.util.HashMap;

public class LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        // Count the frequencies of each number
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int longestSubsequenceLength = 0;

        // Iterate through the numbers and check for both num and num + 1
        for (int num : frequencyMap.keySet()) {
            if (frequencyMap.containsKey(num + 1)) {
                int currentSubsequenceLength = frequencyMap.get(num) + frequencyMap.get(num + 1);
                longestSubsequenceLength = Math.max(longestSubsequenceLength, currentSubsequenceLength);
            }
        }

        return longestSubsequenceLength;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 2, 5, 2, 3, 7};
        LongestHarmoniousSubsequence solution = new LongestHarmoniousSubsequence();
        int longestSubsequence = solution.findLHS(nums);
        System.out.println("Length of the longest harmonious subsequence: " + longestSubsequence);
    }
}


// 4. Solution 

//Time= O(n)
//Space=O(1)

public class FlowerPlanting {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int length = flowerbed.length;
        
        for (int i = 0; i < length; i++) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                count++;
            }
        }
        
        return count >= n;
    }

    public static void main(String[] args) {
        int[] flowerbed = {1, 0, 0, 0, 1};
        int n = 1;
        FlowerPlanting solution = new FlowerPlanting();
        boolean canPlace = solution.canPlaceFlowers(flowerbed, n);
        System.out.println("Can place " + n + " flowers: " + canPlace);
    }
}


// 5. Solution 

//Time= O(n log n)
//Space=O(log n)

import java.util.Arrays;

public class MaximumProduct {
    public int maximumProduct(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        // Calculate the two possible products
        int product1 = nums[n - 1] * nums[n - 2] * nums[n - 3]; // Product of three maximum numbers
        int product2 = nums[0] * nums[1] * nums[n - 1]; // Product of two minimum numbers with the maximum number

        // Return the maximum product
        return Math.max(product1, product2);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        MaximumProduct solution = new MaximumProduct();
        int maxProduct = solution.maximumProduct(nums);
        System.out.println("Maximum product: " + maxProduct);
    }
}


// 6. Solution 

//Time= O(log n)
//Space=O(1)


public class BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        BinarySearch solution = new BinarySearch();
        int index = solution.search(nums, target);
        System.out.println("Index of target " + target + ": " + index);
    }
}



// 7. Solution 

//Time= O(n)
//Space=O(1)


public class MonotonicArray {
    public boolean isMonotonic(int[] nums) {
        boolean increasing = true;
        boolean decreasing = true;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                decreasing = false;
            } else if (nums[i] < nums[i - 1]) {
                increasing = false;
            }
        }
        
        return increasing || decreasing;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3};
        MonotonicArray solution = new MonotonicArray();
        boolean isMonotonic = solution.isMonotonic(nums);
        System.out.println("Is the array monotonic? " + isMonotonic);
    }
}


// 8. Solution 

//Time= O(n log n)
//Space=O(1)

import java.util.Arrays;

public class MinimumScore {
    public int minimumScore(int[] nums, int k) {
        Arrays.sort(nums);
        
        int n = nums.length;
        int minScore = nums[n - 1] - nums[0];
        
        for (int i = 1; i < n; i++) {
            int min = Math.min(nums[0] + k, nums[i] - k);
            int max = Math.max(nums[n - 1] - k, nums[i - 1] + k);
            minScore = Math.min(minScore, max - min);
        }
        
        return minScore;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        int k = 0;
        MinimumScore solution = new MinimumScore();
        int minScore = solution.minimumScore(nums, k);
        System.out.println("Minimum score: " + minScore);
    }
}











