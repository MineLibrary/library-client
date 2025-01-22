package az.atlacademy.libraryclient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import az.atlacademy.libraryclient.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/auth")
@SessionAttributes(value = "token")
public class AuthController 
{
    private static String LOG_TEMPLATE = "{} request to /auth{}";

    private final AuthService authService; 

    @GetMapping(value = "/login")
    public String getLoginPage(Model model)
    {
        log.info(LOG_TEMPLATE, "GET", "/login");
        return "auth/login";
    }

    @PostMapping(value = "/login")
    public String loginAdminUser(
        Model model, 
        @RequestParam(value = "username", required = true) String username, 
        @RequestParam(value = "password", required = true) String password
    ){
        log.info(LOG_TEMPLATE, "POST", "/login");

        String token = authService.authenticate(username, password);
        model.addAttribute("token", token);

        return "redirect:/admin"; 
    }

}
