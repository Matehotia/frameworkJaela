package controlleurs;

import mg.itu.prom16.Annotations.*;
import mg.itu.prom16.ModelView;

@Controller
public class MyController {
    @Get("/example")
    public String salut() {
        // System.out.println("salut");
        return "SLT A VOUS MES ESCLAVES";
    }

    @Get("/bye")
    public String bye(@Param(name = "nom") String name, @Param(name = "prenom") String lastname) {
        return "CHAOU " + name + "" + lastname;
        // System.out.println("Chaou");
    }

    @Get("/bjr")
    public void bjr() {
        // System.out.println("Chaou");
        return;
    }

    @Get("/model")
    public ModelView modelExample() {
        ModelView mv = new ModelView();
        mv.setUrl("/WEB-INF/views/example.jsp");
        mv.addObject("message", "Hello from ModelView");
        return mv;
    }

    @Get("/handleForm")
    public String handleSubmitForm(String age) {
        return "Received age: " + age;
    }

}