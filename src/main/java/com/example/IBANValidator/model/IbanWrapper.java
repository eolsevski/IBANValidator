package com.example.IBANValidator.model;

import java.util.List;

public class IbanWrapper {
    private List<Iban> ibanNumbers;

    public List<Iban> getIbanNumbers(){
        return  ibanNumbers;
    }
    public void setIbanNumbers(List<Iban> ibanNumbers){
        this.ibanNumbers = ibanNumbers;
    }
}
