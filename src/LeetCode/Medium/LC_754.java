package LeetCode.Medium;

public class LC_754 {
    /*
     * ��ѧ��
     * ����target�������Զ���Ŀ��ӡ��
     * ���������ߣ��������target���鿴���������Ƿ���ż���������ż�������ͨ����תǰ��һ�������Ž��
     * ���������,�򿴵�ǰ�Ѿ����˼����ˣ������ǰ����ż����������һ���������������������ͨ����ת֮ǰĳ�������˵�tar-(ans+1),����һ���ִ
     * �����ǰ����������������һ����ż������Ҫ��������
     * */
    public int reachNumber(int target) {
        if (target < 0) return reachNumber(Math.abs(target));
        int ans = 0, l = 0, r = target + 2;
        while (l <= r) {//�Ҵ��ڵ���target����Сֵ
            int mid = (l + r) >> 1;
            long dis = ((long) (1 + mid) * (long) mid) >> 1;
            if (dis == target) return mid;
            else if (dis > target) {
                ans = mid;
                r = mid - 1;
            } else l = mid + 1;
        }
        int dis = (((1 + ans) * ans) >> 1) - target;
        return (dis & 1) == 0 ? ans : ans + ((ans & 1) == 0 ? 1 : 2);
    }

}
