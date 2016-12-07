package fizzbuzz

/**
 * Implement stage 2 of the coding challenge from here: http://codingdojo.org/cgi-bin/index.pl?KataFizzBuzz
 * Created by junwan on 12/6/16.
 */
class FizzBuzz2 extends FizzBuzz {

    /**
     * determine if a number is fizz
     * @param int i input number
     * @return boolean
     */
    @Override
    public boolean isFizz(int i) {
        return i%3 == 0 || i.toString().contains('3');
    }

    /**
     * determine if a number is buzz
     * @param int i input number
     * @return boolean
     */
    @Override
    public boolean isBuzz(int i) {
        return i%5 == 0 || i.toString().contains('5');
    }

    /**
     * print out first 100 numbers in fizzbuzz representation
     * @param args
     */
    public static void main(String[] args) {
        println "Stage 2";
        FizzBuzz fb = new FizzBuzz2();
        1.upto(100, {println fb.convert(it);});
    }
}
