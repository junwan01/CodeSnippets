package bankocr

/**
 * Exception when BankOCR input file has format errors.
 * Created by junwan on 12/6/16.
 */
class BankOCRMalformatException extends Exception {

    public BankOCRMalformatException(String msg) {
        super(msg);
    }
}
