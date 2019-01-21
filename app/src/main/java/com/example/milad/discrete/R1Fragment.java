package com.example.milad.discrete;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class R1Fragment extends Fragment {
    static boolean hasReflection, hasAntiSymmetric, hasSymmetric, hasTransitive, hasXY;
    ImageView reflectionImage, symmetricImage, antisymmetricImage, transitiveImage, xyImage;

    public static void setHasAntiSymmetric(boolean hasAntiSymmetric) {
        R1Fragment.hasAntiSymmetric = hasAntiSymmetric;
    }

    public static void setHasSymmetric(boolean hasSymmetric) {
        R1Fragment.hasSymmetric = hasSymmetric;
    }

    public static void setHasTransitive(boolean hasTransitive) {
        R1Fragment.hasTransitive = hasTransitive;
    }

    public static void setHasXY(boolean hasXY) {
        R1Fragment.hasXY = hasXY;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_r1, container, false);

        reflectionImage = v.findViewById(R.id.r1reflection_image);
        symmetricImage = v.findViewById(R.id.r1symmetric_image);
        antisymmetricImage = v.findViewById(R.id.r1antisymmetric_image);
        transitiveImage = v.findViewById(R.id.r1transitive_image);
        xyImage = v.findViewById(R.id.r1xy_image);

        // set icon related to reflexive
        if (hasReflection) {
            reflectionImage.setImageResource(R.drawable.ic_done_black_24dp);
        } else {
            reflectionImage.setImageResource(R.drawable.ic_wrong_24dp);
        }

        // set icon related to symmetric
        if (hasSymmetric) {
            symmetricImage.setImageResource(R.drawable.ic_done_black_24dp);
        } else {
            symmetricImage.setImageResource(R.drawable.ic_wrong_24dp);
        }

        // set icon related to antisymmetric
        if (hasAntiSymmetric) {
            antisymmetricImage.setImageResource(R.drawable.ic_done_black_24dp);
        } else {
            antisymmetricImage.setImageResource(R.drawable.ic_wrong_24dp);
        }

        // set icon related to transitive
        if (hasTransitive) {
            transitiveImage.setImageResource(R.drawable.ic_done_black_24dp);
        } else {
            transitiveImage.setImageResource(R.drawable.ic_wrong_24dp);
        }

        //set icon related to (x,y) existence
        if (hasXY) {
            xyImage.setImageResource(R.drawable.ic_done_black_24dp);
        } else {
            xyImage.setImageResource(R.drawable.ic_wrong_24dp);
        }

        return v;
    }

    public void setHasReflection(boolean hasReflection) {
        R1Fragment.hasReflection = hasReflection;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
