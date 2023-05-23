package zuo.intermediate.class07;

public class Problem01_EnglishExpression1 {
    public static String num1To19(int num) {
        if (num < 1 || num > 19) {
            return "";
        }
        String[] names = {
                "One", "two", "three", "four", "five", "six", "seven", "eight",
                "Nine", "Ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen",
                "sixteen", "seventeen", "eighteen", "nineteen"
        };
        return names[num - 1];
    }

    public static String num1To99(int num) {
        if (num < 1 || num > 99) {
            return " ";
        }
        if (num < 20) {
            return num1To19(num);
        }
        int high = num / 10;
        String[] tyNames = {
                "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
        };
        return tyNames[high - 2] + num1To19(num - high * 10);
    }

    public static String num1To999(int num) {
        if (num < 1 || num > 999) {
            return "";
        }
        if (num <= 99) {
            return num1To99(num);
        }
        int high = num / 100;
        int low = num % 100;
        if (low == 0) {
            return high + "hundred";
        } else if (1 <= low && low <= 9) {
            return high + "hundred\t zero " + num;
        } else if (low <= 19) {
            return high + "hundred\t " + num1To19(num);
        } else {
            return high + "hundred\t " + num1To99(num);
        }
    }

    public static String num1To9999(int num) {
        if (num < 1 || num > 9999) {
            return "";
        }
        if (num <= 999) {
            return num1To999(num);
        }
        int high = num / 1000;
        int low = num % 1000;
        if (low == 0) {
            return high + "thousand";
        } else if (1 <= low && low <= 99) {
            return high + "thousand\t zero\t" + num1To99(low);
        } else {
            return high + "thousand\t " + num1To999(low);
        }
    }

    public static String getNumEngExp(int num) {
        if (num == 0) {
            return "Zero";
        }
        String res = "";
        if (num < 0) {
            res = "Negative";
        }
        if (num == Integer.MIN_VALUE) {
            res += "Two Billion";
            num %= -200000000;
        }
        num = Math.abs(num);
        int high = 1000000000;
        int highIndex = 0;
        String[] names = {"Billion", "Million", "thousand"};
        while (num != 0) {
            int cur = num / high;
            num %= high;
            if (cur != 0) {
                res += num1To999(cur);
                res += names[highIndex] + (num == 0 ? " " : ", ");
            }
            high /= 1000;
            highIndex++;
        }
        return res;
    }

    //-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2019.1.4\bin\jetbrains-agent.jar

}
