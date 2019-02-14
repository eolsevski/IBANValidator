package com.example.IBANValidator.service;


import static com.example.IBANValidator.util.NoNull.requireNonNull;

import java.math.BigInteger;
import java.util.regex.Pattern;

public class IbanValidationService  {

    private static final Pattern IBAN_PATTERN = Pattern.compile("[A-Z]{2}\\d{2} ?\\d{4} ?\\d{4} ?\\d{4} ?\\d{4} ?[\\d]{0,2}");
    private static final String checkDigitsMod  = "97";

    public boolean validate(String iban){
        requireNonNull(iban);
        return validatePattern(normalize(iban));
    }

    private static String normalize(String iban) {
        return iban.trim().replace(" ", "").toUpperCase();
    }

    private boolean validatePattern(String iban) {
        return IBAN_PATTERN.matcher(iban).matches()&&ibanCheckSum(iban);
    }

    private boolean ibanCheckSum ( String iban){
        String ibanModified =
                iban.substring(4)+ charConverter(iban.substring(0,2))+ iban.substring(2,4);

        BigInteger ibanInt = new BigInteger(ibanModified);
        BigInteger dal = new BigInteger(checkDigitsMod);
        return ibanInt.mod(dal).compareTo(BigInteger.ONE)==0;
    }

    private String charConverter (String prefix){
        StringBuilder converted = new StringBuilder(2);
        for (int i = 0; i < prefix.length(); i++)
            converted.append(Character.toUpperCase(prefix.charAt(i))-55);
        return converted.toString();
    }


}