package com.example.myatmapplication;

public class atm {
    int _id;
    String entryhundred;
    String entrytwohundred;
    String entryfivehundred;
    String entrytwothousand;
    String withdrawlamount;

    public atm() {

    }

    public atm(int _id, String entryhundred, String entrytwohundred, String entryfivehundred,
               String entrytwothousand, String withdrawlamount) {
        this._id = _id;
        this.entryhundred = entryhundred;
        this.entrytwohundred = entrytwohundred;
        this.entryfivehundred = entryfivehundred;
        this.entrytwothousand = entrytwothousand;
        this.withdrawlamount = withdrawlamount;
    }

    public atm(String entryhundred, String entrytwohundred, String entryfivehundred,
               String entrytwothousand, String withdrawlamount) {
        this.entryhundred = entryhundred;
        this.entrytwohundred = entrytwohundred;
        this.entryfivehundred = entryfivehundred;
        this.entrytwothousand = entrytwothousand;
        this.withdrawlamount = withdrawlamount;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getEntryhundred() {
        return entryhundred;
    }

    public void setEntryhundred(String entryhundred) {
        this.entryhundred = entryhundred;
    }

    public String getEntrytwohundred() {
        return entrytwohundred;
    }

    public void setEntrytwohundred(String entrytwohundred) {
        this.entrytwohundred = entrytwohundred;
    }

    public String getEntryfivehundred() {
        return entryfivehundred;
    }

    public void setEntryfivehundred(String entryfivehundred) {
        this.entryfivehundred = entryfivehundred;
    }

    public String getEntrytwothousand() {
        return entrytwothousand;
    }

    public void setEntrytwothousand(String entrytwothousand) {
        this.entrytwothousand = entrytwothousand;
    }

    public String getWithdrawlamount() {
        return withdrawlamount;
    }

    public void setWithdrawlamount(String withdrawlamount) {
        this.withdrawlamount = withdrawlamount;
    }
}
