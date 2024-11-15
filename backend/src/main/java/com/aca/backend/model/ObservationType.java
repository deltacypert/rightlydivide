package com.aca.backend.model;

public enum ObservationType {
    Literal, Moral, Spiritual;

    public static ObservationType convertStringToObType(String value) {
        ObservationType myType = null;

        for (ObservationType type : ObservationType.values()) {
            if (type.toString().equalsIgnoreCase(value)) {
                myType = type;
                break;
            }
        }

        return myType;
    }

}
