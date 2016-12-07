package fizzbuzz;

/**
 * Implement stage 1 of the coding challenge from here: http://codingdojo.org/cgi-bin/index.pl?KataFizzBuzz
 */
class FizzBuzz {

    /**
     * determine if a number is a fizz
     * @param int i the input number
     * @return boolean
     */
    public boolean isFizz(int i) {
        return i%3 == 0;
    }


    /**
     * determine if a number is a buzz
     * @param int i the input number
     * @return boolean
     */
    public boolean isBuzz(int i) {
        return i%5 == 0;
    }


    /**
     * given a number, convert it to the fizzbuzz representation.
     * @param int i the input number
     * @return String the fizzbuzz representation
     */
    public String convert(int i) {
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
            return i.toString();
        }
    }


    /**
     * print out first 100 numbers in fizzbuzz representation
     * @param args
     */
    public static void main(String[] args) {
        println "Stage 1";
        FizzBuzz fb = new FizzBuzz();
        1.upto(100, {println fb.convert(it);});
    }
}
