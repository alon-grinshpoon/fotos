package com.fotos.fotos.cardHandling;

import android.graphics.Bitmap;

public class Card {
    int imageDrawable;
    Bitmap imageBitmap = null;
    String name;
    String question;
    String option1;
    String option2;
    boolean sponsored = false;
    String sponsorLogo;

    public Card(int imageDrawable, String name, String question, String option1, String option2, boolean sponsored, String sponsorLogo) {
        this.imageDrawable = imageDrawable;
        this.name = name;
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.sponsored = sponsored;
        this.sponsorLogo = sponsorLogo;
    }

    public Card(Bitmap imageBitmap, String name, String question, String option1, String option2, boolean sponsored, String sponsorLogo) {
        this.imageBitmap = imageBitmap;
        this.name = name;
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.sponsored = sponsored;
        this.sponsorLogo = sponsorLogo;
    }
}


