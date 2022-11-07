package LeetCode.Medium;

import java.util.Arrays;

public class LC_31 {
    /*
     * ��һ������
     * ˼·
     *   ���������ҵ���һ�����ұߴ��ڱ�������nums[cursor]��
     *   ���ұ�sort������sort���һ������nums[cursor]��������
     * û��ʵ�ֳ����ռ临�Ӷ�
     * */
    public void nextPermutation1(int[] nums) {
        if (nums != null && nums.length > 1) {
            int cursor = nums.length - 2, max = nums[nums.length - 1];
            while (cursor >= 0) {
                if (nums[cursor] < max) {
                    break;
                }
                max = Math.max(max, nums[cursor]);
                cursor--;
            }
            if (cursor == -1) {
                Arrays.sort(nums);
                return;
            }
            int[] arr = new int[nums.length - cursor - 1];
            for (int i = 0; i + cursor + 1 < nums.length; i++) {
                arr[i] = nums[i + cursor + 1];
            }
            Arrays.sort(arr);
            boolean flag = false;
            for (int i = cursor + 1; i < nums.length; i++) {
                if (!flag && arr[i - cursor - 1] > nums[cursor]) {
                    nums[i] = nums[cursor];
                    nums[cursor] = arr[i - cursor - 1];
                    flag = true;
                } else {
                    nums[i] = arr[i - cursor - 1];
                }
            }
        }
    }

    /*
     * �Ż���ʵ�ֳ����ռ�
     *  ͨ��ð�ݵķ�ʽ�Ż�containBigger���پֲ��������
     * */
    public void nextPermutation2(int[] nums) {
        if (nums != null && nums.length > 1) {
            int cursor = nums.length - 1;
            while (cursor > 0) {
                if (nums[cursor - 1] >= nums[cursor]) {
                    swap(nums, cursor - 1, cursor);
                } else {
                    swap(nums, cursor - 1, cursor);
                    Arrays.sort(nums, cursor + 1, nums.length);
                    break;
                }
                cursor--;
            }
            if (cursor == 0) {
                Arrays.sort(nums);
            }
        }
    }

    private void swap(int[] nums, int cursor, int i) {
        int temp = nums[cursor];
        nums[cursor] = nums[i];
        nums[i] = temp;
    }


}
