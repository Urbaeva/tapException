package com.company;

public enum EnumEmployee {
    NAME("name"), SURNAME("last name"),
    BIRTHYEAR("birth year"), BEGINWORKYEAR("start work year");

    private String word;
    EnumEmployee(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

//    @Override
//    public String toString() {
//        return word;
//    }
}
