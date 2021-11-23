package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pages.PaginaPruebaPage;

public class PaginaPruebaSteps {

    PaginaPruebaPage paginaPrueba=new PaginaPruebaPage();
    
    
    @Given("Se abrira la pagina para el registro del nuevo usuario")
    public void clic_abrir_pagina_para_pruebas(){
        paginaPrueba.abrirNavegador();

    }
   
    @Then("el sistema mostrara la pagina para el registro de un nuevo usuario")
    public void clic_se_abre_la_pagina_de_registro(){
        
    }
    
}
