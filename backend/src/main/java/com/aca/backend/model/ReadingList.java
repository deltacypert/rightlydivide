package com.aca.backend.model;

import java.util.ArrayList;
import java.util.List;

public enum ReadingList {
    PENTATEUCH,
    GOSPELS,
    NT_HISTORY,
    OT_HISTORY,
    WISDOM,
    PROPHETS,
    PAULINE_EPISTLES,
    GENERAL_LETTERS;

    public static ReadingList convertStringToReadingList(String value) {
        ReadingList myList = null;

        for (ReadingList list : ReadingList.values()) {
            if (list.toString().equalsIgnoreCase(value)) {
                myList = list;
                break;
            }
        }

        return myList;
    }
}
