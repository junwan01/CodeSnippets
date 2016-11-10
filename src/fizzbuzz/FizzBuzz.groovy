package fizzbuzz;

/**
 * Implement coding challenge from here: http://codingdojo.org/cgi-bin/index.pl?KataFizzBuzz
 */
class FizzBuzz {
    public static boolean isFizz(int i) {
        return i%3 == 0;
    }

    public static boolean isBuzz(int i) {
        return i%5 == 0;
    }

    public static String printIt(int i) {
        if(isFizz(i)) {
            if(isBuzz(i)) {
                return "FizzBuzz";
            }
            else {
                return "Fizz";
            }
        }
        else if (isBuzz(i)) {
            return "Buzz";
        }
        else {
            return i;
        }
    }

    public static boolean isFizz2(int i) {
        return i%3 == 0 || i.toString().contains('3');
    }

    public static boolean isBuzz2(int i) {
        return i%5 == 0 || i.toString().contains('5');
    }

    public static String printIt2(int i) {
        if(isFizz2(i)) {
            if(isBuzz2(i)) {
                return "FizzBuzz";
            }
            else {
                return "Fizz";
            }
        }
        else if (isBuzz2(i)) {
            return "Buzz";
        }
        else {
            return i;
        }
    }


    public static void main(String[] args) {
        println "Stage 1";
        1.upto(100, {println printIt(it);});
        println "\nStage 2";
        1.upto(100, {println printIt2(it);});
    }
}
