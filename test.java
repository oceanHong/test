import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

public class test {

    public static void main(String[] args) {
        System.out.println(extractNumbers("abcd123.456"));
        System.out.println(extractNumbers("abcd123"));
    }
    public static String extractNumbers(String input) {
        // 使用正则表达式提取字符串中的数字部分
        Pattern pattern = compile("(\\d+(\\.\\d+)?)");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            String number = matcher.group(1);
            // 分离整数部分和小数部分
            if (number.contains(".")) {
                String[] parts = number.split("\\.");
                String integerPart = parts[0];
                String decimalPart = parts[1];
                // 保留小数点后两位，不四舍五入
                if (decimalPart.length() > 2) {
                    decimalPart = decimalPart.substring(0, 2);
                } else if (decimalPart.length() < 2) {
                    decimalPart = String.format("%-2s", decimalPart).replace(' ', '0');
                }
                return integerPart + "." + decimalPart;
            } else {
                return number + ".00";
            }
        } else {
            return null;
        }
    }
}

