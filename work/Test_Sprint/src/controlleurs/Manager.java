package controlleurs;

import mg.itu.prom16.Annotations.*;

// Classe définissant un objet Manager
public class Manager {
    @RequestField("name")
    public String name;

    @RequestField("age")
    public int age;

    @RequestField("prenom")
    public String prenom;

}
