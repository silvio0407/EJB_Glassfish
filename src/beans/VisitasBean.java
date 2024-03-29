package beans;

import java.util.HashSet;
import java.util.Set;

import javax.ejb.Stateful;

@Stateful
public class VisitasBean {

	private Set<String> listaVisitantes = new HashSet<String>();

	public Set<String> getListaVisitantes() {
		return listaVisitantes;
	}

	public void entrouVisita(String visitante) {
		listaVisitantes.add(visitante);
	}
	
	public void excluirVisitante(String visitante) {
		listaVisitantes.remove(visitante);
	}
}
