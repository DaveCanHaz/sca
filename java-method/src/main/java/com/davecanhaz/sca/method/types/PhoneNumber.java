package com.davecanhaz.sca.method.types;

abstract class PhoneNumber {
    public int areaCode;
    public int local;

    public PhoneNumber() {
    }

    public PhoneNumber(int areaCode, int local) {
        this.areaCode = areaCode;
        this.local = local;
    }

    public int getAreaCode() {
        return this.areaCode;
    }

    public void setAreaCode(int areaCode) {
        this.areaCode = areaCode;
    }

    public int getLocal() {
        return this.local;
    }

    public void setLocal(int local) {
        this.local = local;
    }

    public PhoneNumber areaCode(int areaCode) {
        this.areaCode = areaCode;
        return this;
    }

    public PhoneNumber local(int local) {
        this.local = local;
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " areaCode='" + getAreaCode() + "'" +
            ", local='" + getLocal() + "'" +
            "}";
    }
}