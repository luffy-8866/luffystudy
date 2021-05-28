package com.luffy.builder;

/**
 * @author luffy
 * @version 1.0
 * @desc
 * @date 2021/5/21 14:20
 */
public class House {
    private String buildeA;
    private String buildeB;
    private String buildeC;
    private String buildeD;

    public House() {
    }

    public House(String buildeA, String buildeB, String buildeC, String buildeD) {
        this.buildeA = buildeA;
        this.buildeB = buildeB;
        this.buildeC = buildeC;
        this.buildeD = buildeD;
    }

    public String getBuildeA() {
        return buildeA;
    }

    public void setBuildeA(String buildeA) {
        this.buildeA = buildeA;
    }

    public String getBuildeB() {
        return buildeB;
    }

    public void setBuildeB(String buildeB) {
        this.buildeB = buildeB;
    }

    public String getBuildeC() {
        return buildeC;
    }

    public void setBuildeC(String buildeC) {
        this.buildeC = buildeC;
    }

    public String getBuildeD() {
        return buildeD;
    }

    public void setBuildeD(String buildeD) {
        this.buildeD = buildeD;
    }
}
