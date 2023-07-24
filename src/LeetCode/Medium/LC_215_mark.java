package LeetCode.Medium;

import org.junit.Test;

import java.util.PriorityQueue;

public class LC_215_mark {
    /*
     * ��С��
     * ʱ�临�Ӷ�nlogn
     * */
    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int num : nums) {
            q.add(num);
            if (q.size() > k) {
                q.poll();
            }
        }
        return q.peek();
    }

    /*
     * ���ڿ�������Ĳ��ң�ʱ�临�Ӷ�n
     * ����ϸ�ڱ�ը
     * */
    public int findKthLargest2(int[] nums, int k) {
        return findK(nums, k, 0, nums.length - 1);
    }

    private int findK(int[] nums, int k, int left, int right) {
        int pos = partition(nums, left, right);
        int rank = right - pos + 1;
        if (rank == k) {
            return nums[pos];
        } else if (rank < k) {
            return findK(nums, k - rank, left, pos - 1);
        } else {
            return findK(nums, k, pos + 1, right);
        }
    }

    /*
     * ���ؽ�pivot�����������������λ��
     * */
    private int partition(int[] nums, int left, int right) {
        int l = left + 1, r = right;
        while (l < r) {
            while (l < right && nums[l] <= nums[left]) l++;
            while (r > left && nums[r] > nums[left]) r--;
            if (r > l) {
                swap(nums, l, r);
            }
        }
        if (nums[r] <= nums[left]) {//����жϴ���ֻ����������Ԫ�ص����������[5,6]���������жϻ��5,6����
            swap(nums, left, r);
            return r;
        } else {
            return left;
        }
    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }


    @Test
    public void s() {
        int i = findKthLargest2(new int[]{-1, -1}, 2);
        System.out.println(i);
    }
}


class redo_215 {
    /*
     * ����ѡ�񣬻��ڿ�������
     * */
    public int findKthLargest(int[] nums, int k) {
        return findK(nums, k, 0, nums.length - 1);
    }

    /**
     * <pre>
     * �ݹ�ѡ�񷽷�
     * ����ѡ��˼·��
     *  ÿ��ѡ��һ��pivot��������ķ���߱ߣ�����С�ķ��ұߣ��жϳ����ǵڼ���
     *  �������k��ֱ�ӷ���
     *  �������k��˵����Ŀ��С����������Ѱ��
     *  ���С��k��˵����Ŀ������Ҳ����Ѱ��
     * ����ѡ�������ǲ�������
     * pivot��������ȡһ����������ȡԭ�������������һ����
     * </pre>
     *
     * @param nums ��ѡ������
     * @param k    ��K���
     * @param l    ��ѡ���������ʼ�±�
     * @param r    ��ѡ�����Ҳ��β�±�
     * @return ѡ������
     */
    private int findK(int[] nums, int k, int l, int r) {
        int pos = partition(nums, l, r); // pivot�ڵ�ǰ�ǵڼ����
        int rank = pos + 1;
        if (rank == k) {
            return nums[pos];
        } else if (rank > k) {
            return findK(nums, k, l, pos - 1);
        } else {
            return findK(nums, k, pos + 1, r);
        }
    }

    // �ҳ��±�l��Ӧ������λ���ĸ��±��
    private int partition(int[] nums, int l, int r) {
        return 0;
    }
}
