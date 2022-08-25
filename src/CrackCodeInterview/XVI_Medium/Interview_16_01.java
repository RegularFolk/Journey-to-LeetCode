package CrackCodeInterview.XVI_Medium;

public class Interview_16_01 {
    /*
    * 利用diff
    * */
    public int[] swapNumbers1(int[] numbers) {
        numbers[0] = numbers[0] - numbers[1];
        numbers[1] = numbers[0] + numbers[1];
        numbers[0] = numbers[1] - numbers[0];
        return numbers;
    }

    /*
    * 三重异或
    * */
    public int[] swapNumbers2(int[] numbers) {
        numbers[0] = numbers[1] ^ numbers[0];
        numbers[1] = numbers[1] ^ numbers[0];
        numbers[0] = numbers[1] ^ numbers[0];
        return numbers;
    }
}
