import java.util.*;
import java.lang.Math;
public class Main {
    public static void main(String[] args) {
        int[]n={1,8,6,2,5,4,8,3,7};
        int l=0,h=n.length-1;
        System.out.println(Max(l,h,n));



    }

    private static int Max(int l, int h, int[] n) {
         int marea=0;
         for (int i=0; i<n.length; i++) {
             int width=h-l;
             int area=Math.max(n[l],n[h])*width;
             if (area>marea) {
                 marea=area;
             }
             if (n[l]<n[h]){
                 l++;
             }else {
                 h--;
             }
         }


    }
}

