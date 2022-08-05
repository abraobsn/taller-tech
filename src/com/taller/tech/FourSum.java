package com.taller.tech;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {

    static Integer[][] fourSum(Integer[] nums, long target) {
        if (nums.length < 4) {
            return new Integer[0][0];
        }

        Arrays.sort(nums);
        Set<Integer> setNums = new HashSet<>();
        setNums.addAll(Arrays.asList(nums));

        List<Integer[]> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 3; i++) {
            // all three ahead numbers are greater than num[i]
            if (nums[i] * 4 >= target) {
                break;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                // the remaining two numbers are greater than the first two sum
                if ((nums[i] + nums[j]) * 2 >= target) {
                    break;
                }
                for (int k = j + 1; k < nums.length - 1; k++) {
                    long sum = nums[i] + nums[j] + nums[k];
                    // the last number is greater than num[k]
                    if (sum + nums[k] >= target) {
                        break;
                    }

                    Long fourth = target - sum;
                    // finding the last number in an O(1) time complexity
                    if (fourth > nums[k] && setNums.contains(fourth.intValue())) {
                        result.add(new Integer[]{nums[i], nums[j], nums[k], fourth.intValue()});
                    }
                }
            }
        }

        return result.toArray(new Integer[][]{});
    }

}
