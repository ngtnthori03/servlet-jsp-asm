package tigi.servlet.util.tigi.http;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

public class FormRequest {

  public static void setform(HttpServletRequest req, String formAction, HttpMethod method) {
    req.setAttribute("form_action", formAction);
    req.setAttribute("form_method", method.getValue());
  }
}
