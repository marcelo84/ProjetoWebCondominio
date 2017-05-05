package br.edu.ifsul.controle;

import br.edu.ifsul.dao.CondominioDAO;
import br.edu.ifsul.modelo.Condominio;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Marcelo
 */
@ManagedBean(name = "controleCondominio")
@SessionScoped
public class ControleCondominio implements Serializable {
    
    private CondominioDAO dao;
    private Condominio objeto;
    
    public ControleCondominio(){
        dao = new CondominioDAO();
    }
    
    public String listar(){
        return "/privado/condominio/listar?faces-redirect=true";
    }

    public String novo(){
        objeto = new Condominio();
        return "formulario";
    }
    
    public String salvar(){
        if(dao.salvar(objeto)){
            Util.mensagemInformacao(dao.getMensagem());
            return "listar";
        }else{
            Util.mensagemErro(dao.getMensagem());
            return "formulario";
        }
    }
    
    public String cancelar(){
        return "listar";
    }
    
    public String editar(Integer id){
      try{
          objeto = dao.localizar(id);
          return "formulario";
      } catch(Exception e){
          Util.mensagemErro(dao.getMensagem());
          return "formulario";
      }
    }
    
    public void remover(Integer id){
      objeto= dao.localizar(id);
      if(dao.remover(objeto)){
          Util.mensagemInformacao(dao.getMensagem());
      } else{
          Util.mensagemErro(dao.getMensagem());
      }
    }
    
    public CondominioDAO getDao() {
        return dao;
    }

    public void setDao(CondominioDAO dao) {
        this.dao = dao;
    }

    public Condominio getObjeto() {
        return objeto;
    }

    public void setObjeto(Condominio objeto) {
        this.objeto = objeto;
    }
    
    
}
