package com.example.milad.discrete;

import java.util.ArrayList;
import java.util.List;

class RelationOne {
    private static List<String> coll;
    String collection;
    private int counter = 0;
    private int index = 0;
    private List<String> x;
    private List<String> y;
    private String xy;

    RelationOne(String collection, String xy) {
        this.collection = collection;
        this.xy = xy;

    }

    static void setColl(List<String> coll) {
        RelationOne.coll = coll;
    }

    void buildROne() {
        x = new ArrayList<>();
        y = new ArrayList<>();

        while (index != -1) {
            int openBrace = collection.indexOf('(', index);
            int closeBrace = collection.indexOf(')', index);
            int comma = collection.indexOf(',', openBrace);

            if (openBrace >= 0) {
                x.add(collection.substring(openBrace + 1, comma));
                y.add(collection.substring(comma + 1, closeBrace));
            } else {
                break;
            }

            index = closeBrace + 1;
        }
        checkXY();
        Relations.setX1(x);
        Relations.setY1(y);
        checkReflection();
        checkSymmetric();
        R1Fragment.setHasAntiSymmetric(checkAntiSymmetric());
        R1Fragment.setHasTransitive(checkTransitive());
    }

    private boolean checkAntiSymmetric() {
        counter = 0;

        for (int i = 0; i < x.size(); i++) {
            String x1 = x.get(i);
            String y1 = y.get(i);

            if (!x1.equals(y1)) {
                for (int j = 0; j < x.size(); j++) {
                    if (x.get(j).equals(y1) && y.get(j).equals(x1)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private void checkReflection() {
        for (int i = 0; i < coll.size(); i++) {
            for (int j = 0; j < x.size(); j++) {
                String a1 = coll.get(i);
                String x1 = x.get(j);
                String y1 = y.get(j);

                if (x1.equals(a1) && y1.equals(a1)) {
                    counter++;

                    break;
                }
            }
        }

        R1Fragment r1Fragment = new R1Fragment();

        if (counter == coll.size()) {
            r1Fragment.setHasReflection(true);
        } else {
            r1Fragment.setHasReflection(false);
        }
    }

    private void checkSymmetric() {
        counter = 0;

        for (int i = 0; i < x.size(); i++) {
            String x1 = x.get(i);
            String y1 = y.get(i);

            for (int j = 0; j < x.size(); j++) {
                if (x.get(j).equals(y1) && y.get(j).equals(x1)) {
                    counter++;

                    break;
                }
            }
        }

        if (counter >= x.size()) {
            R1Fragment.setHasSymmetric(true);
        } else {
            R1Fragment.setHasSymmetric(false);
        }
    }

    private boolean checkTransitive() {
        for (int i = 0; i < x.size(); i++) {
            String x1 = x.get(i);
            String y1 = y.get(i);

            counter = 1;

            for (int j = i; j < x.size(); j++) {
                if (counter == 0) {
                    break;
                }

                if (x.get(j).equals(y1)) {
                    String y2 = y.get(j);

                    for (int k = 0; k < x.size(); k++) {
                        if (x.get(k).equals(x1) && y.get(k).equals(y2)) {
                            counter = 0;

                            break;
                        } else if (k == x.size() - 1) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    private void checkXY() {
        if (collection.contains(xy)) {
            R1Fragment.setHasXY(true);
        } else
            R1Fragment.setHasXY(false);
    }

    List<String> getX() {
        return x;
    }

    List<String> getY() {
        return y;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
