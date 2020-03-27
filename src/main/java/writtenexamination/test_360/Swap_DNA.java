package writtenexamination.test_360;

import java.util.Scanner;

/**
 * @Program: LeetCode
 * @ClassName Swap_DNA
 * @Description: DNA匹配.有一种特殊的DNA，仅仅由核酸A和T组成，长度为n，顺次连接  科学家有一种新的手段，可以改变这种DNA。每一次，科学家可以交换该DNA上两个核酸的位置，也可以将某个特定位置的核酸修改为另一种核酸。  现在有一个DNA，科学家希望将其改造成另一种DNA，希望你计算最少的操作次数。
 * @Version 1.0
 * @Author: Mr.Liu
 * @Create: 2020-03-24 20:02
 */
public class Swap_DNA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String o = scanner.nextLine();
        String r = scanner.nextLine();
        char[] original = o.toCharArray();
        char[] result = r.toCharArray();
        int oriA = 0, resA = 0; //A的数量。
        int operate = 0;
        for (int i = 0; i < original.length; i++) {
            if (original[i] == 'A' && result[i] == 'A') {
                continue;
            } else {
                if (original[i] == 'A') oriA++;
                if (result[i] == 'A') resA++;
            }
        }
        operate=oriA>resA?oriA:resA;
        System.out.println(operate);
    }
}
