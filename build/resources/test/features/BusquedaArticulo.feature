@buscarproducto
Feature: Realizar la busqueda de prenda de vestir 


#Background: 

    @articulo
   Scenario Outline: Realizar la busqueda de una prenda de vestir 
   Given  Hacer clic en el recuadro  de busqueda de prendas
   When Diligencie todo los datos del formulario desde la hoja <SheetName> y el numero de fila <RowNumber>
   And  Hacer clic en el boton buscar 
   And  Presionar en el carrito para continuar con la compra 
   And  Continuar con el proceso de compra

   Examples:
       |SheetName|RowNumber|
       |buscar|0|
       |buscar|1|
       |buscar|2|
