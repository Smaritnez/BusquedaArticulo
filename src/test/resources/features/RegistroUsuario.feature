Feature: Registrar un nuevo usuario


@registroUsuario
 Scenario Outline: Realizar el registro de un nuevo usuario
 Given Clic en el boton registrarse
 When Digite un correo electronico para continuar <correo>
 And Presionar el boton crear cuenta 
 And Favor diligenciar todo los datos del formulario desde la hoja <SheetName> y el numero de fila <RowNumber>
 And  Seleccionar por favor un estado <estado>
 And Hago clic en el boton registrarse 
 Examples:
     | correo|SheetName|RowNumber|estado|
     |bmmarti8@gmail.com|Datos|0|1|