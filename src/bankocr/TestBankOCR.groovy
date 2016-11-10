package bankocr;

import bankocr.BankOCR;

/**
 * Test BankOCR
 * Created by junwan on 11/10/16.
 */
class TestBankOCR extends GroovyTestCase  {

    void testParseFile() {
        def cases = ["src/bankocr/BankOCR_Test.txt" : ["123456789","712345678","213456798","000000000","111111111",
                                                "222222222","333333333","444444444","555555555",
                                                "666666666","777777777","888888888","999999999"]];

        cases.each { file, expect ->
            assertEquals(BankOCR.parseFile(file), expect);
        }
    }

    void testChecksum() {
        def cases = [ "345882865" : true,
                      "345882864" : false];
        cases.each { acct, expect ->
            assertEquals( BankOCR.checksum(acct),expect);
        }
    }

}
