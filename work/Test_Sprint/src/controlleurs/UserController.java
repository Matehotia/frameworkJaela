package controlleurs;

import java.util.List;

import mg.itu.prom16.Annotations.*;
import mg.itu.prom16.*;

@Controller
public class UserController {

    @Get("/userData")
    public ModelView userData(MySession session) {
        String username = (String) session.get("username");
        List<String> data = (List<String>) session.get("data");
        ModelView mv = new ModelView("userData.jsp");
        mv.addObject("username", username);
        mv.addObject("data", data);
        return mv;
    }
}
