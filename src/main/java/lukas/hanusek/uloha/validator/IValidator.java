package lukas.hanusek.uloha.validator;

import lukas.hanusek.uloha.validator.objects.ValidatorResult;

/**
 *
 * @author Lukas Hanusek
 */
public interface IValidator {
    
    /**
     * Validate given object
     * @param object
     * @return 
     */
    public ValidatorResult validate(Object object);
    
    
    
}
