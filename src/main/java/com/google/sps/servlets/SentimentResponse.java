package com.google.sps.servlets;

public class SentimentResponse {
    String quote;
    float score;

    public SentimentResponse(String _quote, float _score) {
        this.quote = _quote;
        this.score = _score;
    }
}
