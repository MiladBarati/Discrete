package com.example.milad.discrete;

import java.util.ArrayList;
import java.util.List;

public class Relations {
    private static List<String> x1;
    private static List<String> x2;
    private static List<String> y1;
    private static List<String> y2;
    private static List<String> xi;
    private static List<String> yi;
    private static List<String> xu;
    private static List<String> yu;
    private static List<String> xs;
    private static List<String> ys;
    private static List<String> xo1;
    private static List<String> yo1;
    private static List<String> xo2;
    private static List<String> yo2;

    static void setX1(List<String> x1) {
        Relations.x1 = x1;
    }

    static void setX2(List<String> x2) {
        Relations.x2 = x2;
    }

    static void setY1(List<String> y1) {
        Relations.y1 = y1;
    }

    static void setY2(List<String> y2) {
        Relations.y2 = y2;
    }

    void buildRelations() {
        xi = new ArrayList<>();
        yi = new ArrayList<>();
        xu = new ArrayList<>();
        yu = new ArrayList<>();
        xs = new ArrayList<>();
        ys = new ArrayList<>();
        xo1 = new ArrayList<>();
        yo1 = new ArrayList<>();
        xo2 = new ArrayList<>();
        yo2 = new ArrayList<>();
        r2Or1();
        r1Or2();
        intersection();
        union();
        minR1R2();
        minR2R1();
        symmetricDifference();
    }

    void intersection() {
        for (int i = 0; i < x1.size(); i++) {
            for (int j = 0; j < x2.size(); j++) {
                if (x1.get(i).equals(x2.get(j)) && y1.get(i).equals(y2.get(j))) {
                    xi.add(x1.get(i));
                    yi.add(y1.get(i));
                }
            }
        }

        RRFragment.setXi(xi);
        RRFragment.setYi(yi);
    }

    private void minR1R2() {
        for (int i = 0; i < x1.size(); i++) {
            for (int j = 0; j < xi.size(); j++) {
                if (x1.get(i).equals(xi.get(j)) && y1.get(i).equals(yi.get(j))) {
                    x1.remove(i);
                    y1.remove(i);

                    break;
                }
            }
        }

        RRFragment.setMx1(x1);
        RRFragment.setMy1(y1);
    }

    private void minR2R1() {
        for (int i = 0; i < x2.size(); i++) {
            for (int j = 0; j < xi.size(); j++) {
                if (x2.get(i).equals(xi.get(j)) && y2.get(i).equals(yi.get(j))) {
                    x2.remove(i);
                    y2.remove(i);

                    break;
                }
            }
        }

        RRFragment.setMx2(x2);
        RRFragment.setMy2(y2);
    }

    private void r1Or2() {
        for (int i = 0; i < x2.size(); i++) {
            for (int j = 0; j < x1.size(); j++) {
                if (y2.get(i).equals(x1.get(j))) {
                    xo2.add(x2.get(i));
                    yo2.add(y1.get(j));
                }
            }
        }

        RRFragment.setXo2(xo2);
        RRFragment.setYo2(yo2);
    }

    private void r2Or1() {
        for (int i = 0; i < x1.size(); i++) {
            for (int j = 0; j < x2.size(); j++) {
                if (y1.get(i).equals(x2.get(j))) {
                    xo1.add(x1.get(i));
                    yo1.add(y2.get(j));
                }
            }
        }

        RRFragment.setXo1(xo1);
        RRFragment.setYo1(yo1);
    }

    private void symmetricDifference() {
        for (int i = 0; i < x1.size(); i++) {
            xs.add(x1.get(i));
            ys.add(y1.get(i));
        }

        for (int i = 0; i < x2.size(); i++) {
            xs.add(x2.get(i));
            ys.add(y2.get(i));
        }

        RRFragment.setXs(xs);
        RRFragment.setYs(ys);
    }

    public void union() {
        for (int i = 0; i < x1.size(); i++) {
            xu.add(x1.get(i));
            yu.add(y1.get(i));
        }

        for (int i = 0; i < x2.size(); i++) {
            xu.add(x2.get(i));
            yu.add(y2.get(i));
        }

        for (int i = 0; i < xi.size(); i++) {
            for (int j = 0; j < xu.size(); i++) {
                if (xi.get(i).equals(xu.get(j)) && yi.get(i).equals(yu.get(j))) {
                    xu.remove(j);
                    yu.remove(j);

                    break;
                }
            }
        }

        RRFragment.setXu(xu);
        RRFragment.setYu(yu);
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
