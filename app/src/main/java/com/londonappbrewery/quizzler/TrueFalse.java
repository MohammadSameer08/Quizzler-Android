package com.londonappbrewery.quizzler;

import android.content.SyncStatusObserver;

public class TrueFalse
{
   int questionId;
   boolean ans;


    public TrueFalse(int questionId, boolean ans) {
        this.questionId = questionId;
        this.ans = ans;
    }

    public int getQuestionId() {
        return questionId;
    }

    public boolean isAns() {
        return ans;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public void setAns(boolean ans) {
        this.ans = ans;
    }
}
