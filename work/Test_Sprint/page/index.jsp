<a href="login.jsp">SE CONNECTER</a>
<h1>With Annotation </h1>
<form action="${pageContext.request.contextPath}/insertForm" method="get">
  <input type="text" name="nomdep" placeholder="Nom du departement" />
  <input type="text" name="numerodep" placeholder="Numero du département" />
  <input type="text" name="manager.name" placeholder="Nom du manager" />
  <input type="text" name="manager.age" placeholder="Age du manager" />
  <input type="text" name="manager.prenom" placeholder="Prenom du manager" />
  <input type="submit" value="Submit" />
</form>

<h1>Without Annotation </h1>
<form action="${pageContext.request.contextPath}/insererFormulaire" method="get">
  <input type="text" name="nomdep" placeholder="Nom du departement" />
  <input type="text" name="numerodep" placeholder="Numero du département" />
  <input type="text" name="manager.name" placeholder="Nom du manager" />
  <input type="text" name="manager.age" placeholder="Age du manager" />
  <input type="text" name="manager.prenom" placeholder="Prenom du manager" />
  <input type="submit" value="Submit" />
</form>

<form action="${pageContext.request.contextPath}/bye" method="get">
  <input type="text" name="nom" placeholder="Ton nom" />
  <input type="text" name="prenom" placeholder="Ton prenom" />
  <input type="submit" value="Submit" />
</form>
