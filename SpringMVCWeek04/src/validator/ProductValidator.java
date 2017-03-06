package validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import domain.Product;

@Component
public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Product product = (Product) target;
		
		if(product.getProductId() == null || product.getProductId().length()<5) {
			//required.productId= Invalid product id. It should be minimum 5 characters
			errors.rejectValue("productId", "required.productId");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required.name");
		
		if (product.getUnitPrice() <= 0) {
			errors.rejectValue("unitPrice", "required.unitPrice");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "required.description");

		if (product.getUnitsInStock() <= 0) {
			errors.rejectValue("unitsInStock", "required.unitsInStock");
		}
	}

}
