/*package Utils;

import Modelo.Articulo;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.event.FlowEvent;

public class UserWizard { 
	private Articulo p1 = new Articulo();
	private boolean skip;
	
	private static Logger logger = Logger.getLogger(UserWizard.class.getName());

    public static Logger getLogger() {
        return logger;
    }

    public static void setLogger(Logger logger) {
        UserWizard.logger = logger;
    }

    public Articulo getP1() {
        return p1;
    }

    public void setP1(Articulo p1) {
        this.p1 = p1;
    }

	

	public void save(ActionEvent actionEvent) {
		//Persist user
		
		FacesMessage msg = new FacesMessage("Successful", "Welcome");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public boolean isSkip() {
		return skip;
	}

	public void setSkip(boolean skip) {
		this.skip = skip;
	}
	
	public String onFlowProcess(FlowEvent event) {
		logger.info("Current wizard step:" + event.getOldStep());
		logger.info("Next step:" + event.getNewStep());
		
		if(skip) {
			skip = false;	//reset in case user goes back
			return "confirm";
		}
		else {
			return event.getNewStep();
		}
	}

}
*/