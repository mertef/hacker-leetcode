# Big Number Add
 add two big string input number.
 e.g: String a = "11111133333333333333"
      String b = "22222222222222222222222222"
	  ```
	  package aijoy;

import java.util.ArrayList;
import java.util.List;

public class BigNumberAdd {
    /*

     1
   1234
   + 56
   ----
   1290


"12903812047102948192083120938120983129084109284109284109248209412......."

  a = "1234"
+ b = "1237"
s = "1461"



*/
//c + "46" it's my func print

    public static boolean normalize(String a) {
        boolean flag = true;
        if(null == a || a.isEmpty())  {
            flag = false;
        }
        return flag;
    }
    public static String add(String a, String b) {
        //seperate the string into pieces
        if(!(normalize(a) && normalize(b))){
            return "";
        }
        char[] arrayA = a.toCharArray();
        char[] arrayB = b.toCharArray();
        //1 inner for loop count should  less than the outer loop count. solve the incorrect result
        char[] array = arrayA.length > arrayB.length ? arrayB : arrayA;
        char[] arrayWhile = arrayA.length > arrayB.length ? arrayA : arrayB;
        int d = arrayWhile.length - array.length;

        List<Integer> sum = new ArrayList(arrayA.length + arrayB.length + 1);
        int j = 0;
        for(j = array.length - 1; j >= 0; j --) {
            int aa = Integer.parseInt(Character.toString(array[j]));
            int bb = Integer.parseInt(Character.toString(arrayWhile[j + d]));
            int c = aa + bb;
            if(c >= 10) {
                int overflowPrevious = 0 ;
                if(sum.size() > 0) {
                    overflowPrevious = sum.get(0);
                    sum.remove(0);
                }
                int remainder = c + overflowPrevious - 10;
                //how to solve the over add 1
                //get top number of the overflow number, sometimes may be zero or one
                if (remainder >= 0) {
                    sum.add(0, remainder);
                    overflowPrevious = 1;
                } else {
                    sum.add(0, c);
                }
                //sum.insert(reamainder,0);
                sum.add(0,overflowPrevious);
                //sum.insert(1,0);
            } else {
                int num = -1;
                if (sum.size() > 0) {
                    num = sum.get(0);
                    sum.remove(0);
                }

                if (num > 0) {
                    c = c + num;
                }
                int n = c - 10;
                if (n >= 0) {
                    sum.add(0,n);
                    sum.add(0,1);
                } else {
                    sum.add(0,c);
                    sum.add(0,0);
                }


                //sum.insert(c,0);
                //sum.insert(0,0);
            }
        }
        ///


        j = d;
        while(j > 0) {
            int n = sum.get(0);
            sum.remove(0);
            int n2 = Integer.parseInt(Character.toString(arrayWhile[j - 1]))  + n;
            int n3 = n2 - 10;
            if (n3 > 0) {
                sum.add(0, n3);
            } else {
                sum.add(0,n2);
            }
            if (n3 > 0) {
                n = 1;
            }
            sum.add(0,n);
            j --;
        }
        sum.remove(0);
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < sum.size(); i ++) {
            s.append(sum.get(i));
        }
        return s.toString();
    }

    public static void main(String[] args) {
        String a = "110000000000000000001";
        String b = "11000000000000000009";
        System.out.println(a);
        System.out.println(b);
        String c = add(a,b);

        System.out.println(c);
    }
}


	  ```
