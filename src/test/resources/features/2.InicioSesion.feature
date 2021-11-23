Feature: Iniciar sesion en la pagina de compras 


 Background: 

 Given Haga clic en el boton registrarse
   
   @datoserroneos  @smoketest
   Scenario Outline: Iniciar sesion con usuario erroneos
   
   When  Por favor diligencie todo los datos del formulario desde la hoja <SheetName> y el numero de fila <RowNumber>
   And  Para continuar por favor Haga clic en el boton registrarse 
   Then El sistema mostrara el mensaje Authentication failed.

   Examples:
       | SheetName |RowNumber|
       |datosincorrectos|0|


  @datoscorrecto @smoketest
  Scenario Outline: Iniciar sesion con usuario correctos
   When Diligencie por favor  todo los datos del formulario desde la hoja <SheetName> y el numero de fila <RowNumber>
   And  Continuar por favor haga clic en el boton registrarse 
   Then Se ingresa a la pagina de cliente 

   Examples:
       | SheetName |RowNumber|
       |datoscorrectos|0|

    @recuperarContrasena
    Scenario Outline: Recuperar la contraseña de un usuario registrado 
    When Hagá clic en el  link para recuperar su contrasena
    And Ingrese el correo electronico que tiene registrado en el sistema <correo>
    And Presione por favor el boton recuperar contrasena  
    Then Mostrara el mensaje A confirmation email has been sent to your address:
    Examples:
        |correo|
        |bmmarti8@gmail.com| 