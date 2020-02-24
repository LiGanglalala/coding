import java.util.ArrayList;
import java.util.List;

public class Array {
    public static boolean array11(String string) {
        if (string == null || string.length() == 0) {
            return false;
        }
        /**On2**/
//        boolean result = true;
//        for (int i = 0; i < string.length(); i++) {
//            char temp = string.charAt(i);
//            for (int j = i + 1; j < string.length(); j++) {
//                if (temp == string.charAt(j)) {
//                    result = false;
//                    break;
//                }
//            }
//        }
//        return result;

        /**On,ascii一共256个**/
        //1.用boolean[]标记
        //2.用1 << 标记，int（2的31次方 - 1），long(2的63次方 - 1)

        /**nlogn 排序，有无相邻**/
        return false;
    }

    public static char[] array12(char[] chars) {
        if (chars == null || chars.length == 0) {
            return chars;
        }
        for (int i = 0; i < chars.length / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = temp;

        }
        return chars;
    }

    public static boolean array13(char[] chars1, char[] chars2) {
//        if (chars1 == null || chars2 == null || chars1.length != chars2.length) {
//            return false;
//        }
//        for (int i = 0; i < chars1.length; i++) {
//            boolean isMatched = false;
//            for (int j = i; j < chars1.length; j++) {
//                if (chars1[i] == chars2[j]) {
//                    char temp = chars2[j];
//                    chars2[j] = chars2[i];
//                    chars2[i] = temp;
//                    isMatched = true;
//                }
//            }
//            if (!isMatched) {
//                return isMatched;
//            }
//
//        }
        /**On,ascii一共256个,用int[]统计每个字母的次数**/

        /**nlogn, 排序后比较**/
        return true;
    }

    public static char[] array14(char[] chars, int length) {
        if (chars == null || length == 0) {
            return chars;
        }
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (chars[i] == ' ') {
                count++;
            }

        }
        if (count == 0) {
            return chars;
        }
        int temp = length - 1 + count * 2;
        for (int i = length - 1; i >= 0; i--) {
            if (chars[i] == ' ') {
                chars[temp--] = '0';
                chars[temp--] = '2';
                chars[temp] = '%';
            } else {
                chars[temp] = chars[i];
            }
            temp--;
        }
        return chars;
    }

    public static char[] array15(char[] chars) {
        if (chars == null || chars.length == 0 || chars.length == 1) {
            return chars;
        }
//        int j = 0;
//        List<Character> result = new ArrayList<>();
//        for (int i = 0; i < chars.length; i = j) {
//            result.add(chars[i]);
//            int count = 1;
//            for (j = i + 1; j < chars.length; j++) {
//                if (chars[j] != chars[i]) {
//                    break;
//                }
//                count++;
//            }
//            result.add(String.valueOf(count).charAt(0));
//        }

        /**用 StringBuilder，另外for循环重新**/
        StringBuilder builder = new StringBuilder();
        int count = 1;
        char last = chars[0];
        for (int i = 1; i < chars.length; i++) {
            if (last == chars[i]) {
                count++;
            } else {
                builder.append(last);
                builder.append(count);
                last = chars[i];
                count = 1;
            }
        }
        return chars;
    }
}
