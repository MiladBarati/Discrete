package com.example.milad.discrete;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class R2Fragment extends Fragment {
    static boolean hasReflection, hasSymmetric, hasAntiSymmetric, hasTransitive, hasXY;
    ImageView reflectionImage, symmetricImage, antisymmetricImage, transitiveImage, xyImage;

    public static void setHasAntiSymmetric(boolean hasAntiSymmetric) {
        R2Fragment.hasAntiSymmetric = hasAntiSymmetric;
    }

    public static void setHasTransitive(boolean hasTransitive) {
        R2Fragment.hasTransitive = hasTransitive;
    }

    public static void setHasXY(boolean hasXY) {
        R2Fragment.hasXY = hasXY;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_r2, container, false);

        reflectionImage = v.findViewById(R.id.r2reflection_image);
        symmetricImage = v.findViewById(R.id.r2symmetric_image);
        antisymmetricImage = v.findViewById(R.id.r2antisymmetric_image);
        transitiveImage = v.findViewById(R.id.r2transitive_image);
        xyImage = v.findViewById(R.id.r2xy_image);

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
        R2Fragment.hasReflection = hasReflection;
    }

    public void setHasSymmetric(boolean hasSymmetric) {
        R2Fragment.hasSymmetric = hasSymmetric;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
