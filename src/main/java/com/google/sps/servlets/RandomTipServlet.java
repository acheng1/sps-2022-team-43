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
    tips.add("The next time you are in a situation that makes you feel like an impostor, refer back to the facts vs. stories of the situation.");
    tips.add("Instead of internalizing the emotions, recognize them and move on.");
    tips.add("If you often feel like you are not getting your work done on time, go back over your most recent projects. Review the work you have done, to see if these feelings are based in fact. If they are, you have identified something concrete you can work on and improve upon. If they are not, use these facts every time that voice in your brain pipes up to tell you you are not good enough.");
    tips.add("If you often suffer from negative self-talk, start monitoring your mental voice and modifying it where possible.");
    tips.add("To fight impostor syndrome, try actively improving your hard skills and soft skills. That way, whenever that little voice in your head whispers that you are not good enough at something, you can whisper back that you are in the process of getting better.");
    tips.add("The next time you feel tempted to compare yourself to your peers, try to take a step back and instead see what you can learn from them.");
    tips.add("The next time you feel like you did something well, celebrate it! If you are comfortable, share your accomplishment with your team. But if that feels like too much of a step right now, share it with someone outside of work, like a friend or a family member.");
    tips.add("It is possible to feel worthy without feeling entitled, and overcoming impostor syndrome is all about finding a healthy balance between the two.");
    tips.add("Not only can no one do everything perfectly, but holding yourself to that standard can actually be super counterproductive. At some point, you need to take a step back and ask yourself: When is good enough good enough?");
    tips.add("Change the way you talk to yourself in your head by practicing positive self-talk.");
    Gson gson = new Gson(); 
    String json = gson.toJson(tips); 
    
    response.setContentType("application/json;");
    response.getWriter().println(json);
  }
}