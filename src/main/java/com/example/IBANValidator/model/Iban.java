package com.example.IBANValidator.model;

public class Iban {

    private String iban;
    private boolean isValid;

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    @Override
    public String toString() {
        return "Iban{" +
                "iban='" + iban + '\'' +
                '}';
    }
}
