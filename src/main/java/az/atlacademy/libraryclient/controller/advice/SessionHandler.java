package az.atlacademy.libraryclient.controller.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import jakarta.servlet.http.HttpSession;

@ControllerAdvice
public class SessionHandler 
{
    @ModelAttribute("token")
    public String getToken(HttpSession session) 
    {
        return (String) session.getAttribute("token");
    }
}
