package Arrays;

import java.util.List;

public class MedianOfTwoSortedArrays {


    // O(log(m+n))
    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        int length = a.size() + b.size();
        if(length % 2 == 0)
            return (findkth(length/2, a, 0, b, 0) + findkth(length/2 + 1, a, 0, b, 0)) / 2.0;
        else
            return findkth(length/2 + 1, a, 0, b, 0);
    }

    private int findkth(int k, List<Integer> a, int aStart, List<Integer> b, int bStart){
        if(aStart >= a.size())
            return b.get(bStart + k - 1);

        if(bStart >= b.size())
            return a.get(aStart + k - 1);

        if(k == 1)
            return Math.min(a.get(aStart), b.get(bStart));

        int akey = aStart + k/2 -1 < a.size() ? a.get(aStart + k/2 -1) : Integer.MAX_VALUE;
        int bkey = bStart + k/2 -1 < b.size() ? b.get(bStart + k/2 -1) : Integer.MAX_VALUE;


        if(akey < bkey)
            return findkth(k - k/2, a, aStart + k/2, b, bStart);
        else
            return findkth(k - k/2, a, aStart, b, bStart + k/2);
    }
}
