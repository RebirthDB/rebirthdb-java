// Autogenerated by metajava.py.
// Do not edit this file directly.
// The template for this file is located at:
// ../../../../../../../templates/Enum.java
package com.rethinkdb.proto;

public enum FrameType {

    POS(1),
    OPT(2);

    public final int value;

    private FrameType(int value){
        this.value = value;
    }

    public static FrameType fromValue(int value) {
        switch (value) {
            case 1: return FrameType.POS;
            case 2: return FrameType.OPT;
            default:
                throw new IllegalArgumentException(String.format(
                "%s is not a legal value for FrameType", value));
        }
    }

}
