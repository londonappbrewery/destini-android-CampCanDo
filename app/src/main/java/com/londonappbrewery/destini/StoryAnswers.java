package com.londonappbrewery.destini;

public class StoryAnswers {

    //Declare member variables
    private int mStoryID;
    private int mTopAnswerID;
    private int mButtomAnswerID;

    public StoryAnswers(int questionResourceNo, int topBAnswer, int lowBAnswer) {
        mStoryID = questionResourceNo;
        mTopAnswerID = topBAnswer;
        mButtomAnswerID = lowBAnswer;

    }

    public int getStoryID() {
        return mStoryID;
    }

    public void setStoryID(int storyID) {
        mStoryID = storyID;
    }

    public int getTopAnswerID() {
        return mTopAnswerID;
    }

    public void setTopAnswerID(int topAnswerID) {
        mTopAnswerID = topAnswerID;
    }

    public int getButtomAnswerID() {
        return mButtomAnswerID;
    }

    public void setButtomAnswerID(int buttomAnswerID) {
        mButtomAnswerID = buttomAnswerID;
    }
}