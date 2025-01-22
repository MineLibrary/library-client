package az.atlacademy.libraryclient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/auth")
public class AuthController 
{
    private static String LOG_TEMPLATE = "{} request to /auth{}";

    @GetMapping(value = "/login")
    public String login(Model model)
    {
        log.info(LOG_TEMPLATE, "GET", "/login");
        return "auth/login";
    }


}
