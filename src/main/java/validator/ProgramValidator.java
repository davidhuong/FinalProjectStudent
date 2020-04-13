package validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.Arrays;
@FacesValidator
public class ProgramValidator implements Validator {
    private String[] programNames = {
            "Computer Pogrammer", "Architechture", "Biotechnology", "Computer Emgineering", "Health Science"};

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object program) {
        if (!Arrays.asList(programNames).contains(program)) {
            FacesMessage msg =
                    new FacesMessage("Program names should be one of these: " + Arrays.toString(programNames));
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
}
