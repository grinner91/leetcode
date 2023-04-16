import java.util.*;

class Program {

  /*

https://www.algoexpert.io/questions/numbers-in-pi

time: O(n^2), space: O ( n + m), n is digits in pi, m is numbers 

String[] nums = new String[]{"314159265358979323846", "26433", "8", "3279", "314159265", "35897932384626433832", "79"};
var result = numbersInPi("3141592653589793238462643383279", nums); //result: 2 

DP

*/
  public static int numbersInPi(String pi, String[] numbers) {
        int[] spacesDp = new int[pi.length() + 1];
        Arrays.fill(spacesDp, Integer.MAX_VALUE);
    
        spacesDp[0] = 0;

        for (int i = 0; i < pi.length(); i++) {
            if (spacesDp[i] == Integer.MAX_VALUE)
                continue;

            var subs = pi.substring(i);

            for (var num : numbers) {
                if (subs.startsWith(num)) {
                    var idx = i + num.length();
                    spacesDp[idx] = Math.min(spacesDp[idx], spacesDp[i] + 1);
                }
            }

        }

        if (spacesDp[pi.length()] == Integer.MAX_VALUE)
            return -1;
        else
            return spacesDp[pi.length()] - 1;

    }
}

