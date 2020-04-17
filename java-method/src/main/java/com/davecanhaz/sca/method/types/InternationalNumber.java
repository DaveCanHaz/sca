package com.davecanhaz.sca.method.types;

public class InternationalNumber extends PhoneNumber {
    public int countryCode;
    public InternationalNumber() {
    }

    public InternationalNumber(int countryCode) {
        this.countryCode = countryCode;
    }

    public int getCountryCode() {
        return this.countryCode;
    }

    public void setCountryCode(int countryCode) {
        this.countryCode = countryCode;
    }

    public InternationalNumber countryCode(int countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " countryCode='" + getCountryCode() + "'" +
            "}";
    }
}
