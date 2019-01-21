package com.example.milad.discrete;

import java.util.ArrayList;
import java.util.List;

class Collection {
    String collection;
    private int index = 0;

    Collection(String collection) {
        this.collection = collection;
    }

    void buildCollection() {
        List<String> coll = new ArrayList<>();

        while (index != -1) {
            int openCurly = collection.indexOf('{', index);
            int comma = collection.indexOf(',', index);
            int comma1 = collection.indexOf(',', comma + 1);

            if (index == 0) {
                coll.add(collection.substring(openCurly + 1, comma));
            }

            int closeCurly = collection.indexOf('}', index);

            index = comma + 1;

            if (comma1 >= 0) {
                coll.add(collection.substring(comma + 1, comma1));
            } else {
                coll.add(collection.substring(comma + 1, closeCurly));

                break;
            }
        }

        RelationOne.setColl(coll);
        RelationTwo.setColl(coll);
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
