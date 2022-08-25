package CrackCodeInterview.V_BitOperation;

public class Interview_05_04 {
    /*
    * 求较大和较小思路一致，以较小为例
    *   从低位往高位搜索，找到当前为0但下一位为1的位置，
    *   将0和1交换，同时统计路上1的数量，交换后用统计的1填上紧邻着交换之后的位置
    *   其余再用0覆盖此后直至第一位
    * */
    public int[] findClosedNumbers(int num) {
        return new int[]{higher(num), lower(num)};
    }

    /*
     * 低位至高位找0和左边紧挨着的1，交换位置
     * */
    private int lower(int num) {
        if (num > 1) {
            int mark = num, count = 0, one = 0;
            while (mark != 0) {
                if ((mark & 1) == 0 && (mark & 2) == 2) {
                    int semi = setZero(setOne(num, count), count + 1);
                    for (int i = count - 1; i >= count - one; i--) {
                        semi = setOne(semi, i);
                    }
                    for (int i = count - one - 1; i >= 0; i--) {
                        semi = setZero(semi, i);
                    }
                    return semi;
                } else {
                    if ((mark & 1) == 1) {
                        one++;
                    }
                    mark >>= 1;
                    count++;
                }
            }
        }
        return -1;
    }

    /*
     * 低位至高位找1和左边紧挨着的0,交换位置
     * */
    private int higher(int num) {
        if (num < 2147483647) {
            int mark = num, count = 0, zero = 0;
            while (mark != 0) {
                if ((mark & 1) == 1 && (mark & 2) != 2) {
                    int semi = setOne(setZero(num, count), count + 1);
                    for (int i = count - 1; i >= count - zero; i--) {
                        semi = setZero(semi, i);
                    }
                    for (int i = count - zero - 1; i >= 0; i--) {
                        semi = setOne(semi, i);
                    }
                    return semi;
                } else {
                    if ((mark & 1) == 0) {
                        zero++;
                    }
                    mark >>= 1;
                    count++;
                }
            }
        }
        return -1;
    }

    /*
     * 指定位值设定为0
     * */
    private int setZero(int num, int i) {
        return num & (~(1 << i));
    }

    /*
     * 指定位值设定为1
     * */
    private int setOne(int num, int i) {
        return num | (1 << i);
    }

}
