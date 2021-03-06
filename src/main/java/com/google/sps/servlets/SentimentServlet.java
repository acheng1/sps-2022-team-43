// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.sps.servlets;

import com.google.cloud.language.v1.Document;
import com.google.cloud.language.v1.LanguageServiceClient;
import com.google.cloud.language.v1.Sentiment;
import com.google.gson.Gson;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Handles the sentiment score on submitted text */
@WebServlet("/sentiment-analysis")
public class SentimentServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    Gson gson = new Gson();
    
    String message = request.getParameter("text-input");

    Document doc =
        Document.newBuilder().setContent(message).setType(Document.Type.PLAIN_TEXT).build();
    LanguageServiceClient languageService = LanguageServiceClient.create();
    Sentiment sentiment = languageService.analyzeSentiment(doc).getDocumentSentiment();
    float score = sentiment.getScore();
    languageService.close();

    String quote;

    if (score < -0.5) {
        quote = "“It doesn't matter how slowly you go, as long as you're moving”";
    } else if (score < 0.5) {
        quote = "“A little progress each day adds up to big results”";
    } else {
        quote = "“We are what we repeatedly do. Excellence then is not an act but a habit”";
    }

    // Output the sentiment score as HTML.
    // A real project would probably store the score alongside the content.
    response.setContentType("application/json;");
    response.setCharacterEncoding("UTF-8");
    SentimentResponse sr = new SentimentResponse(quote, score);
    response.getWriter().print(gson.toJson(sr));
    response.getWriter().flush();
  }
}
