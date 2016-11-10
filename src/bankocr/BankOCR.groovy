package bankocr;

/**
 * Implement coding challenge from here: http://codingdojo.org/cgi-bin/index.pl?KataBankOCR
 * Created by junwan on 11/10/16.
 */
class BankOCR {

    /**
     * parse a single row of numbers, consists of 3 lines of characters
     * @param String l1
     * @param String l2
     * @param String l3
     * @return String the string representation of the numbers
     */
    public static String lineOCR(String l1, String l2, String l3) {
        if(l1.length() != l2.length() || l1.length() != l3.length() ) {
            throw new Exception("Character line shifted.  Line 1: "+l1.length() + " line 2: " + l2.length() + " line 3: " + l3.length() + ".");
        }
        if(l1.length() %3 != 0 || l2.length() %3 != 0 || l3.length() %3 != 0 ) {
            throw new Exception("Line length should be multiple of 3.");
        }
        StringBuffer number = new StringBuffer();
        for(int i=0; i< l1.length(); i+=3) {
            int n = numberOCR(l1.substring(i,i+3),l2.substring(i,i+3), l3.substring(i,i+3)) ;
            number.append(n);
        }
        return number.toString();
    }

    /**
     * Parse the 3 lines of text, each line contains only 3 characters, together they represent a single number.
     * For example:
     * **** _ ****
     * **** _|****
     * ****|_ ****
     * The above is a 2, and the '*' surrounding it mark the boundary of the 3 by 3 space.
     *
     * @param w1
     * @param w2
     * @param w3
     * @return
     */
    public static int numberOCR(String w1, String w2, String w3 ) {
        if(w1.length() != 3 || w2.length() != 3 || w3.length() != 3) {
            throw new Exception("wrong input size. should be 3 character per line. Line 1: '${w1}', line 2: '${w2}', line 3: '${w3}'.");
        }

        if(w1 == " _ " && w2 == "| |" && w3 == "|_|") {
            return 0;
        }
        else if (w1 == "   " && w2 == "  |" && w3 == "  |") {
            return 1;
        }
        else if (w1 == " _ " && w2 == " _|" && w3 == "|_ ") {
            return 2;
        }
        else if (w1 == " _ " && w2 == " _|" && w3 == " _|") {
            return 3;
        }
        else if (w1 == "   " && w2 == "|_|" && w3 == "  |") {
            return 4;
        }
        else if (w1 == " _ " && w2 == "|_ " && w3 == " _|") {
            return 5;
        }
        else if (w1 == " _ " && w2 == "|_ " && w3 == "|_|") {
            return 6;
        }
        else if (w1 == " _ " && w2 == "  |" && w3 == "  |") {
            return 7;
        }
        else if (w1 == " _ " && w2 == "|_|" && w3 == "|_|") {
            return 8;
        }
        else if (w1 == " _ " && w2 == "|_|" && w3 == " _|") {
            return 9;
        }
        else {
            throw new Exception("Unrecognizable character. Line 1: '${w1}', line 2: '${w2}', line 3: '${w3}'.");
        }

    }


    public static boolean checksum(String acct) {
        if(acct.length() != 9) {
            throw new Exception("Account number length should be 9.");
        }
        int cksum = 0;
        for(int i = 0; i < 9; i++) {
            cksum += Integer.parseInt(acct.charAt(i).toString()) * (9-i);
        }
        return (cksum % 11 == 0);
    }

    /**
     * parse the text file.
     * each four lines of text represent a row of account numbers, with 3 lines for the actual number and an empty line
     * to separate the rows.
     * @param file
     * @return
     */
    public static List<String> parseFile (String file) {
        File f = new File(file);
        int lineNo = 0;
        String line;
        List numbers = new ArrayList<String>();
        String[] quartet = new String[4];
        f.withReader { reader ->
            while ((line = reader.readLine())!=null) {
                int i = lineNo % 4;
                quartet[i] = line;
                // OCR the first 3 lines once we get there
                if(i == 2) {
                    numbers.add(lineOCR(quartet[0],quartet[1],quartet[2]));
                }
                lineNo++;
            }
        }
        return numbers;
    }
}
