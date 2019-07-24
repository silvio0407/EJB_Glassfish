package mb;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import beans.ContadorBean;

@ManagedBean
public class ContadorMB {

	@EJB
	ContadorBean contadorBean;

	public void incrementar() {
		contadorBean.incrementar();
	}

	public int getContador() {
		return contadorBean.getContador();
	}
}
