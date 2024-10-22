package controlleurs;

import mg.itu.prom16.Annotations.*;
import controlleurs.Manager;

// Importations omises pour des raisons de concision

@Controller
public class DeptController {
    // Méthode de mapping annotée avec @Get et prenant des paramètres
    @Get("/insertForm")
    public String insertForm(@Param(name = "nomdep") String nomdep,
            @Param(name = "numerodep") int numerodep,
            @RequestObject(value = "manager") Manager manager) {
        System.out.println(nomdep);
        System.out.println(String.valueOf(numerodep));
        System.out.println(manager.name);

        return "success: " + nomdep + " / " + String.valueOf(numerodep) + " / Manager:" + manager.name + "/"+ String.valueOf(manager.age); // Retourne une vue ou
                                                                                                // un message de succès
    }

    @Get("/insererFormulaire")
    public String insererFormulaire(String nomdep,
            @Param(name = "numerodep") int numerodep,
            @RequestObject(value = "manager") Manager manager) {
        System.out.println(nomdep);
        System.out.println(String.valueOf(numerodep));
        System.out.println(manager.name);

        return "success: " + nomdep + " / " + String.valueOf(numerodep) + " / Manager:" + manager.name + "/"+ String.valueOf(manager.age); // Retourne une vue ou
                                                                                                // un message de succès
    }
}
