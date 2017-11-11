package com.example.android.miwok;

/**
 * Created by dk-dev on 9/17/17.
 */

public class Word {
    private String mMiwokTranslation = "";
    private String mDefaultTranslation = "";
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private int mSoundResourceId = NO_SOUND_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;
    private static final int NO_SOUND_PROVIDED = -2;

    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId, int soundResourceId){
        mDefaultTranslation= defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;
        mSoundResourceId = soundResourceId;
    }

    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId){
        mDefaultTranslation= defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;
    }

    public Word(String defaultTranslation, String miwokTranslation){
        mDefaultTranslation= defaultTranslation;
        mMiwokTranslation = miwokTranslation;
    }

    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }
    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }
    public int getImageResourceId(){return mImageResourceId;}
    public int getSoundResourceId(){return mSoundResourceId;}
    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
