package fizzbuzz;

import fizzbuzz.FizzBuzz;
import fizzbuzz.FizzBuzz2;

/**
 * Test FizzBuzz and FizzBuzz2
 * Created by junwan on 11/10/16.
 */
class TestFizzBuzz extends GroovyTestCase {

    /**
     * test fizzbuzz (stage 1)
     */
    void testFizzBuzz() {
        // input : expected output
        def cases = [ '1'  : '1',
                      '2'  : '2',
                      '3'  : 'Fizz',
                      '5'  : 'Buzz',
                      '6'  : 'Fizz',
                      '10' : 'Buzz',
                      '15' : 'FizzBuzz',
                      '30' : 'FizzBuzz'
                    ];
        FizzBuzz fb = new FizzBuzz();
        cases.each { i , expect ->
            assertEquals(fb.convert(i.toInteger()), expect);
        }
    }

    /**
     * test fizzbuzz2 (stage 2)
     */
    void testFizzBuzz2() {
        // input : expected output
        def cases = [ '1'  : '1',
                      '2'  : '2',
                      '3'  : 'Fizz', // divisible
                      '5'  : 'Buzz', // divisible
                      '6'  : 'Fizz', // divisible
                      '10' : 'Buzz', // divisible
                      '15' : 'FizzBuzz', // divisible by 3 and 5
                      '13' : 'Fizz', // contain 3
                      '33' : 'Fizz', // contain & divisible
                      '35' : 'FizzBuzz', // contain 3 and 5
                      '51' : 'FizzBuzz', // contain 5 and divisible by 3
                      '52' : 'Buzz',   // contain 5
                      '53' : 'FizzBuzz', // contain 3 and 5,
                      '30' : 'FizzBuzz' // contain 3 and divisible by 5
                    ];
        FizzBuzz fb = new FizzBuzz2();
        cases.each { i , expect ->
            assertEquals(fb.convert(i.toInteger()), expect);
        }
    }

}
