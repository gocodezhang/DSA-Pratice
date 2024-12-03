public class MedianOfTwoSortedArrs {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int count = 0;
        int left = 0;
        int right = 0;

        int length = nums1.length + nums2.length;
        boolean isEven = length % 2 == 0;
        int sum = 0;

        while (left < nums1.length || right < nums2.length) {
            int numLeft = left < nums1.length ? nums1[left] : Integer.MAX_VALUE;
            int numRight = right < nums2.length ? nums2[right] : Integer.MAX_VALUE;
            count++;

            if (numLeft < numRight) {
                left++;
            } else {
                right++;
            }

            if (length / 2 + 1 == count || (isEven && length / 2 == count)) {
                sum += numLeft < numRight ? numLeft : numRight;
            }
        }

        return isEven ? (double) sum / 2 : (double) sum;
    }

    public double findMedianSortedArraysBSIndex(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        boolean isEven = n % 2 == 0;

        if (isEven) {
            int first = binarySearchHelper(n / 2, nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1);
            int second = binarySearchHelper(n / 2 - 1, nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1);

            return (double) (first + second) / 2;
        } else {
            return (double) binarySearchHelper(n / 2, nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1);
        }

    }
    public int binarySearchHelper(int targetIndex, int[] nums1, int left1, int right1, int[] nums2, int left2, int right2) {
        // base case
        if (left1 > right1) {
            return nums2[targetIndex - left1];
        }
        if (left2 > right2) {
            return nums1[targetIndex - left2];
        }

        // recursive case
        int mid1 = (left1 + right1) / 2;
        int mid2 = (left2 + right2) / 2;

        if (mid1 + mid2 < targetIndex) {
            if (nums1[mid1] < nums2[mid2]) {
                return binarySearchHelper(targetIndex, nums1, mid1 + 1, right1, nums2, left2, right2);
            } else {
                return binarySearchHelper(targetIndex, nums1, left1, right1, nums2, mid2 + 1, right2);
            }
        } else {
            if (nums1[mid1] < nums2[mid2]) {
                return binarySearchHelper(targetIndex, nums1, left1, right1, nums2, left2, mid2 - 1);
            } else {
                return binarySearchHelper(targetIndex, nums1, left1, mid1 - 1, nums2, left2, right2);
            }
        }
    }
    public double findMedianSortedArraysPivotSort(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArraysPivotSort(nums2, nums1);
        }
        // find the short array
        int length1 = nums1.length;
        int length2 = nums2.length;
        // determine num of elements in left pivot
        int desiredNum = (length1 + length2 + 1) / 2;

        int left = 0;
        int right = nums1.length;
        // binary search the short array
        // note: pointer is exclusive to curr position; so curr number = nums[pointer - 1]
        // Having exclusive pointer is programming trick where we don't have to handle pointer < 0
        while (left <= right) {
            int mid = (left + right) / 2;
            int indexLong = desiredNum - mid;

            int currShort = mid == 0 ? Integer.MIN_VALUE : nums1[mid - 1];
            int currLong = indexLong == 0 ? Integer.MIN_VALUE : nums2[indexLong - 1];
            int nextInLong = indexLong < nums2.length ? nums2[indexLong] : Integer.MAX_VALUE;
            int nextInShort = mid < nums1.length ? nums1[mid] : Integer.MAX_VALUE;
            // when two pointers are smaller in next position in diff array, return result
            if (currShort <= nextInLong && currLong <= nextInShort) {
                if ((length1 + length2) % 2 == 0) {
                    return (Math.max(currShort, currLong) + Math.min(nextInShort, nextInLong)) / 2.0;
                } else {
                    return Math.max(currShort, currLong);
                }
            } else if (currShort > nextInLong) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        MedianOfTwoSortedArrs medianOfTwoSortedArrs = new MedianOfTwoSortedArrs();
        System.out.println(medianOfTwoSortedArrs.findMedianSortedArraysPivotSort(nums1, nums2));
    }
}
