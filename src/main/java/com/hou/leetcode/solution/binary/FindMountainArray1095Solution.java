package com.hou.leetcode.solution.binary;

/**
 * @Description
 * @auther houwf
 * @create 2020-07-16 9:44
 */
public class FindMountainArray1095Solution {
    /**
     * 笨办法，先找出峰值然后在分开查找
     * @param target
     * @param mountainArr
     * @return
     */
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = findPeak(mountainArr);
        int res = findLeftTarget(mountainArr, 0, peak, target);
        if (res != -1) {
            return res;
        }
        return findRightTarget(mountainArr, peak+1, mountainArr.length()-1, target);
    }

    private int findLeftTarget(MountainArray mountainArray, int left, int right, int target) {
        while (left <= right) {
            int mid = (left+right)/2;
            int midv = mountainArray.get(mid);
            if (midv == target) {
                return mid;
            } else if (target > midv) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return -1;
    }

    private int findRightTarget(MountainArray mountainArray, int left, int right, int target) {
        while (left <= right) {
            int mid = (left+right)/2;
            int midv = mountainArray.get(mid);
            if (midv == target) {
                return mid;
            } else if (target < midv) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return -1;
    }

    private int findPeak(MountainArray mountainArray) {
        int left =0,right=mountainArray.length()-1;
        while (left <= right) {
            int mid = (left+right)/2;
            int leMid = mid!=0?mountainArray.get(mid-1):Integer.MIN_VALUE;
            int midv = mountainArray.get(mid);
            int riMid = mid!=mountainArray.length()?mountainArray.get(mid+1):Integer.MIN_VALUE;
            if (leMid < midv && midv > riMid) {
                return mid;
            } else if (leMid < midv && midv < riMid) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return 0;
    }

    class MountainArray {
        int[] nums = new int[]{3,5,3,2,0};
        int callCount = 0;
        MountainArray(int len, int k) {
//            nums = new int[len];
//            int m=1;
//            for (int i=1; i<=len; i++) {
//                if (i<=k) {
//                    nums[i-1] = i;
//                } else {
//                    nums[i-1] = k-m;
//                    m++;
//                }
//            }
        }
        public int get(int index) {
            callCount++;
            if (callCount > 100) {
                throw new RuntimeException();
            }
            return nums[index];
        }

        public int length() {
            return nums.length;
        }
    }

    public static void main(String[] args) {
        FindMountainArray1095Solution solution = new FindMountainArray1095Solution();
        MountainArray mountainArray = solution.new MountainArray(10000, 10);
        System.out.println(solution.findInMountainArray(0, mountainArray));
    }
}
