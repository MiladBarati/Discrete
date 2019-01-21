package com.example.milad.discrete;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RRFragment extends Fragment {
    static List<String> xi, xu, yi, yu, mx1, my1, mx2, my2, xs, ys, xo1, yo1, xo2, yo2;
    TextView intersectionText, unionText, minR1R2Text, minR2R1Text, symmetricDifferenceText, r2Or1Text,
            r1Or2Text;

    public static void setMx1(List<String> mx1) {
        RRFragment.mx1 = mx1;
    }

    public static void setMx2(List<String> mx2) {
        RRFragment.mx2 = mx2;
    }

    public static void setMy1(List<String> my1) {
        RRFragment.my1 = my1;
    }

    public static void setMy2(List<String> my2) {
        RRFragment.my2 = my2;
    }

    public static void setXi(List<String> xi) {
        RRFragment.xi = xi;
    }

    public static void setXo1(List<String> xo1) {
        RRFragment.xo1 = xo1;
    }

    public static void setXo2(List<String> xo2) {
        RRFragment.xo2 = xo2;
    }

    public static void setXs(List<String> xs) {
        RRFragment.xs = xs;
    }

    public static void setXu(List<String> xu) {
        RRFragment.xu = xu;
    }

    public static void setYi(List<String> yi) {
        RRFragment.yi = yi;
    }

    public static void setYo1(List<String> yo1) {
        RRFragment.yo1 = yo1;
    }

    public static void setYo2(List<String> yo2) {
        RRFragment.yo2 = yo2;
    }

    public static void setYs(List<String> ys) {
        RRFragment.ys = ys;
    }

    public static void setYu(List<String> yu) {
        RRFragment.yu = yu;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_rr, container, false);

        intersectionText = v.findViewById(R.id.intersection);
        unionText = v.findViewById(R.id.union);
        minR1R2Text = v.findViewById(R.id.min_r1_r2);
        minR2R1Text = v.findViewById(R.id.min_r2_r1);
        symmetricDifferenceText = v.findViewById(R.id.symmetric_difference);
        r2Or1Text = v.findViewById(R.id.r2or1);
        r1Or2Text = v.findViewById(R.id.r1or2);

        StringBuilder s1 = new StringBuilder();

        for (int i = 0; i < xi.size(); i++) {
            s1.append("(").append(xi.get(i)).append(",").append(yi.get(i)).append(")");
        }

        intersectionText.setText("{" + s1 + "}");
        s1 = new StringBuilder();

        for (int i = 0; i < xu.size(); i++) {
            s1.append("(").append(xu.get(i)).append(",").append(yu.get(i)).append(")");
        }

        unionText.setText("{" + s1 + "}");
        s1 = new StringBuilder();

        for (int i = 0; i < mx1.size(); i++) {
            s1.append("(").append(mx1.get(i)).append(",").append(my1.get(i)).append(")");
        }

        minR1R2Text.setText("{" + s1 + "}");
        s1 = new StringBuilder();

        for (int i = 0; i < mx2.size(); i++) {
            s1.append("(").append(mx2.get(i)).append(",").append(my2.get(i)).append(")");
        }

        minR2R1Text.setText("{" + s1 + "}");
        s1 = new StringBuilder();

        for (int i = 0; i < xs.size(); i++) {
            s1.append("(").append(xs.get(i)).append(",").append(ys.get(i)).append(")");
        }

        symmetricDifferenceText.setText("{" + s1 + "}");
        s1 = new StringBuilder();

        for (int i = 0; i < xo1.size(); i++) {
            s1.append("(").append(xo1.get(i)).append(",").append(yo1.get(i)).append(")");
        }

        r2Or1Text.setText("{" + s1 + "}");
        s1 = new StringBuilder();

        for (int i = 0; i < xo2.size(); i++) {
            s1.append("(").append(xo2.get(i)).append(",").append(yo2.get(i)).append(")");
        }

        r1Or2Text.setText("{" + s1 + "}");

        return v;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
