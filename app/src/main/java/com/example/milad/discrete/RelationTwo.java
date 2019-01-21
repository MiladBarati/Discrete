package com.example.milad.discrete;

import java.util.ArrayList;
import java.util.List;

class RelationTwo {
    private static List<String> coll;
    private String collection, xy;
    private int index = 0;
    private int counter = 0;
    private List<String> x, y;
    private R2Fragment r2Fragment;

    RelationTwo(String collection, String xy) {
        this.collection = collection;
        this.xy = xy;
    }

    static void setColl(List<String> coll) {
        RelationTwo.coll = coll;
    }

    void buildRTwo() {
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
        Relations.setX2(x);
        Relations.setY2(y);
        checkReflection();
        hasSymmetric();
        R2Fragment.setHasAntiSymmetric(checkAntiSymmetric());
        R2Fragment.setHasTransitive(checkTransitive());
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

        r2Fragment = new R2Fragment();

        if (counter == coll.size()) {
            r2Fragment.setHasReflection(true);
        } else {
            r2Fragment.setHasReflection(false);
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

    private void hasSymmetric() {
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
            r2Fragment.setHasSymmetric(true);
        } else {
            r2Fragment.setHasSymmetric(false);
        }
    }

    private void checkXY() {
        if (collection.contains(xy)) {
            R2Fragment.setHasXY(true);
        } else
            R2Fragment.setHasXY(false);
    }

    List<String> getX() {
        return x;
    }

    List<String> getY() {
        return y;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
