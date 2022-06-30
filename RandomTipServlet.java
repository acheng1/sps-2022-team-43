package com.google.sps.servlets;

import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@WebServlet("/tips")
public class RandomTipServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    ArrayList<String> tips = new ArrayList<String>();
    tips.add("Hello!");
    tips.add("Good evening");
    tips.add("Good morning");
    Gson gson = new Gson(); 
    String json = gson.toJson(tips); 
    
    response.setContentType("application/json;");
    response.getWriter().println(json);
  }
}