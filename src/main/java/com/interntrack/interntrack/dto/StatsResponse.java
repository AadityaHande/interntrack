package com.interntrack.interntrack.dto;

public class StatsResponse {
    private long total;
    private long applied;
    private long onlineAssessment;
    private long interview;
    private long offer;
    private long rejected;

    public StatsResponse(long total, long applied, long onlineAssessment, long interview, long offer, long rejected) {
        this.total = total;
        this.applied = applied;
        this.onlineAssessment = onlineAssessment;
        this.interview = interview;
        this.offer = offer;
        this.rejected = rejected;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getApplied() {
        return applied;
    }

    public void setApplied(long applied) {
        this.applied = applied;
    }

    public long getOnlineAssessment() {
        return onlineAssessment;
    }

    public void setOnlineAssessment(long onlineAssessment) {
        this.onlineAssessment = onlineAssessment;
    }

    public long getInterview() {
        return interview;
    }

    public void setInterview(long interview) {
        this.interview = interview;
    }

    public long getOffer() {
        return offer;
    }

    public void setOffer(long offer) {
        this.offer = offer;
    }

    public long getRejected() {
        return rejected;
    }

    public void setRejected(long rejected) {
        this.rejected = rejected;
    }

}
