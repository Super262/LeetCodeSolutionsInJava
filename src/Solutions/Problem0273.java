package Solutions;

public class Problem0273 {
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuilder res = new StringBuilder();
        for (int i = 1000000000, j = 0; i >= 1; i /= 1000,++j) {
            if (num >= i) {
                res.append(convert1000(num / i));
                if (j < 3) {
                    res.append(nums1000[j]);
                    res.append(' ');
                }
                num %= i;
            }
        }
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }

    private final String[] nums1To19 = new String[]{"One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    private final String[] nums20To90 = new String[]{"Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    private final String[] nums1000 = new String[]{"Billion","Million","Thousand"};

    private String convert1000(int x) {
        StringBuilder res = new StringBuilder();
        if (x >= 100) {
            res.append(nums1To19[x / 100 - 1]);
            res.append(' ');
            res.append("Hundred ");
            x %= 100;
        }
        if (x >= 20) {
            res.append(nums20To90[x / 10 - 2]);
            res.append(' ');
            x %= 10;
        }
        if (x > 0) {
            res.append(nums1To19[x - 1]);
            res.append(' ');
        }
        return res.toString();
    }
}
