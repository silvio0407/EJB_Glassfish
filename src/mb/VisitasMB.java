package mb;

import java.util.ArrayList;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import beans.VisitasBean;

@ManagedBean
@SessionScoped
public class VisitasMB {
	
	@EJB
	VisitasBean visitasBean;
	
	private String visitante;
	
	private DataModel<String> listaVisitantes;
	  
    public void entrouVisita() {
    	
    	boolean isValido = validarNomeVisitante(visitante);
    	
    	if(isValido) {
    		visitasBean.entrouVisita(visitante);  
    		cleanInput();
    	}else {
    		FacesContext.getCurrentInstance().addMessage("NomeVisitanteID", new FacesMessage(FacesMessage.SEVERITY_INFO, "Nome do Visitante deve ser Informado!", null));
    	}
    }      
     
    public DataModel<String> getVisitas(){
    	listaVisitantes = new ListDataModel<String>(new ArrayList<String>(visitasBean.getListaVisitantes()));
           return listaVisitantes;
    }
    
    public void excluirVisitante() {
    	visitasBean.excluirVisitante(listaVisitantes.getRowData());
    }
     
    public String getVisitante() {
          return visitante;
    }

    public void setVisitante(String visitante) {
          this.visitante = visitante;
    }
    
    private void cleanInput() {
    	visitante="";
    }
    
    private boolean validarNomeVisitante(String nome) {
    	if(nome.isEmpty()) {
    		return false;
    	}
    	return true;
    }
}
