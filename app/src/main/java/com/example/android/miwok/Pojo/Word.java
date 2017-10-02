package com.example.android.miwok.Pojo;

/**
 * Created by Ashish on 9/29/2017.
 */

public class Word {

    private String mEnglishWord;
    private String mMiwokWord;
    private int mImageResource = NO_IMAGE_PROVIDED;
    private int mAudioResource;
    private static final int NO_IMAGE_PROVIDED = -1;

    public Word(String englishWord, String miwokWord, int audioResource) {
        mEnglishWord = englishWord;
        mMiwokWord = miwokWord;
        mAudioResource = audioResource;
    }

    public Word(String englishWord, String miwokWord, int imageResource, int audioResource) {
        mEnglishWord = englishWord;
        mMiwokWord = miwokWord;
        mImageResource = imageResource;
        mAudioResource = audioResource;
    }

    public String getDefaultTranslation() {
        return mEnglishWord;
    }

    public String getMiwokTranslation() {
        return mMiwokWord;
    }

    public int getImageResource() {
        return mImageResource;
    }

    public boolean hasImage() {
        return mImageResource != NO_IMAGE_PROVIDED;
    }

    public int getAudioResource() {
        return mAudioResource;
    }
}
