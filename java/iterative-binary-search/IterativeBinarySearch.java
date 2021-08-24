/**
 * ---------ITERATIVE BINARY SEARCH---------
 * 
 * A search algorithm that finds the position of a target value within a sorted
 * array. Binary search compares the target value to the middle element of the
 * array.
 * 
 * NOTE: For Java, this approach has better space complexity than recursive
 * binary search because only one array is used and there is only one call to
 * the stack
 * 
 * Data Structure: Array
 * 
 * Prerequisite: In order for a binary search to work, the target array HAS TO
 * BE SORTED
 * 
 * Average complexity: O(log n)
 * 
 * Worst complexity: O(log n)
 * 
 * Best complexity: O(1)
 * 
 * Space complexity: O(1)
 * 
 * -----------------------------------------
 */
public class IterativeBinarySearch {
    public static void main(String[] args) {
        int[] nums = { 1, 5, 8, 9, 11, 13, 15, 19, 21 };
        // int[] nums = { 1, 2 };
        int low = 0;
        int high = nums.length - 1;

        iterBinarySearch(nums, low, high, 8); // Average case: sorted array - O(log n)
        iterBinarySearch(nums, low, high, 21); // Worst case: target is first or last element - O(log n)
        iterBinarySearch(nums, low, high, 11); // Best case: target is first midpoint - O(1)
        iterBinarySearch(nums, low, high, 10); // Another case: target is not found - O(log n)
    }

    public static void iterBinarySearch(int[] nums, int low, int high, int x) {
        while (high >= low) {
            int mid = low + ((high - low) / 2);
            // If midpoint is equal to target, return
            if (nums[mid] == x) {
                System.out.println("Found " + x + " at index " + mid);
                return;
                // If midpoint is greater than target, search left subarray
            } else if (nums[mid] > x) {
                high = mid - 1;
                // If midpoint is less than target, search right subarray
            } else if (nums[mid] < x) {
                low = mid + 1;
            }
        }
        // If this point is reached, the target is not in the array
        System.out.println(x + " not found");
    }
}
