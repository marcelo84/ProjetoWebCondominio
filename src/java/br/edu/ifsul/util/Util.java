/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Marcelo
 */
public class Util {
    
    public static String getMensagemErro(Exception e){
        while (e.getCause() != null){
            e = (Exception) e.getCause();
         
        }String retorno = e.getMessage();
        if(retorno.contains("viola restrição de chave estrangeira")){
            retorno = "registro não pode ser removido por possuir referencia em outros objetos.";
        }
        return retorno;
    }
    
    public static void mensagemInformacao(String mensagem){
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, "");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public static void mensagemErro(String mensagem){
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, "");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
}
