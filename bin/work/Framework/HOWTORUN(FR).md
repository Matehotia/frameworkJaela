## PREREQUIS:

    IL FAUT UN PROJET DE TEST OU IL Y A UN PACKAGE POUR METTRE LES CLASS PUIS DEPLOYER VERS TOMCAT.
    APRES CA SUIVEZ LES ETAPES CI-DESSOUS :

## ETAPE 1: 1.1. Importation du Framework.jar dans lib

    Methode manuel (sans script): Mettre dans (chemin vers Tomcat)..\webapps\Test_Sprint\WEB-INF\lib le Framework.jar

## ETAPE 2: 1.2. Creer des class annotes et des methodes

    Les Class Controller qu'on veut etre scanner doit etre annotees par @Controller.
    Les methodes qu'on veut etre scanner doit etre annotees par @Get("/example(suivie de l'url)).
    *Cree des fonctions sans parametres qui retournent un String.
    *Cree des fonctions avec parametres annotes @Param(ex: bye(@Param(name = "userName") String name)) qui retournent un String par exemple.
    NB: la valeur sur l'annotation doit etre inserer sur le name de l'input
    NB: Les class doivent etres dans un package.
    *Cree une Class Manager,et annote chaque attribut par @RequestField("nomAttribut")
    *Cree des fonctions avec parametres annotes @RequestObject si ceci est un Object
    ex: @RequestObject("manager")

## ETAPE 3: 1.3. Configurer le web.xml comme ci dessous:

    <?xml version="1.0" encoding="UTF-8"?>
    <web-app xmlns="http://java.sun.com/xml/ns/j2ee" version="2.4">
        <servlet>
            <servlet-name>FrontServlet</servlet-name>
            <servlet-class>mg.itu.prom16.FrontController</servlet-class>
        </servlet>
        <servlet-mapping>
            <servlet-name>FrontServlet</servlet-name>
            <url-pattern>/</url-pattern>
        </servlet-mapping>
        <context-param>
            <param-name>controllerPackage</param-name>
            <param-value>nom du package a scanner</param-value>
        </context-param>
    </web-app>

## ETAPE 4: Essaye de changer les valeurs

    Ex1: Fausser le nom de package dans webapps -> pour voir erreur de package puis cree un package avec une classe qui n'est pas un controller
    Ex2: Fausser l'url -> erreur no mapping found
    Ex3: Ajoute un meme url pour 2 methodes -> erreur duplicate url method
    Ex4: Change le type de retour en double -> erreur return type not recognized

## ETAPE 4: 1.4. Lancer le serveur Tomcat

    Lancer le projet dans un navigateur web, tapez l'url puis ca retournera le nom de la class avec le nom de la methode si il y a correspondace entre l'url sinon reessayer.
