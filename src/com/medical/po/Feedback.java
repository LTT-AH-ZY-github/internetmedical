package com.medical.po;

import java.util.Date;

public class Feedback {
    private Integer feedbackid;

    private String feedbackidea;

    private Date feedbacktime;

    private Boolean feedbackischeck;

    public Integer getFeedbackid() {
        return feedbackid;
    }

    public void setFeedbackid(Integer feedbackid) {
        this.feedbackid = feedbackid;
    }

    public String getFeedbackidea() {
        return feedbackidea;
    }

    public void setFeedbackidea(String feedbackidea) {
        this.feedbackidea = feedbackidea == null ? null : feedbackidea.trim();
    }

    public Date getFeedbacktime() {
        return feedbacktime;
    }

    public void setFeedbacktime(Date feedbacktime) {
        this.feedbacktime = feedbacktime;
    }

    public Boolean getFeedbackischeck() {
        return feedbackischeck;
    }

    public void setFeedbackischeck(Boolean feedbackischeck) {
        this.feedbackischeck = feedbackischeck;
    }
}