package com.google.sps.servlets;

import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@WebServlet("/random-tip")
public class RandomTipServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    ArrayList<String> tips = new ArrayList<String>();
    tips.add("Focus on the facts");
    tips.add("Share your feelings");
    tips.add("Celebrate your successes");
    tips.add("Let go of perfectionism");
    tips.add("Share your failures");
    tips.add("Cultivate self-compassion");
    tips.add("Acknowledge, validate, then let go");
    tips.add("Fighting your feelings with the evidence");
    tips.add("Reframe your thoughts");
    tips.add("Learn from your team members");
    tips.add("Toot your own horn");
    tips.add("hello");
    Gson gson = new Gson(); 
    String json = gson.toJson(tips); 
    
    response.setContentType("application/json;");
    response.getWriter().println(json);
  }
}