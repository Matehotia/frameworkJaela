package controlleurs;

import java.util.ArrayList;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mg.itu.prom16.Annotations.*;
import mg.itu.prom16.*;

@Controller
public class LoginController {

    @Get("/login")
    public String login(@Param(name = "username") String username, @Param(name = "password") String password,
            MySession session) {
        // Vérifier les informations d'identification de l'utilisateur
        if ("user".equals(username) && "pass".equals(password)) {
            session.add("username", username);
            session.add("data", new ArrayList<>()); 
            return "redirect:/userData";
        } else {
            return "login.jsp";
        }
    }

    @Get("/logout")
    public String logout(MySession session) {
        session.getSession().invalidate(); // Invalidate the session
        return "redirect:/login.jsp";
    }
}
