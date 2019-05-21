package item.s67;

/**
 * created by zhangzhiyuan in 2019/5/7
 */
public class Solution {
    public String addBinary(String a, String b) {

        StringBuilder result = new StringBuilder();

        int al = a.length()-1;
        int bl = b.length()-1;
        int carry = 0;

        while( al >=0  || bl >=0 )
        {
            int sum = carry;
            if(al >= 0)
            {
                sum += (a.charAt(al) - '0');
                al--;
            }
            if(bl >= 0)
            {
                sum += (b.charAt(bl) - '0');
                bl--;
            }
            //相加结果
            result.insert(0, sum % 2);
            //进位，如果是1那么carry=0，如果是2则要进位给下面一位+1
            carry = sum /2;
        }

        if (carry != 0) {
            result.insert(0,1);
        }
        return result.toString();
    }
}
