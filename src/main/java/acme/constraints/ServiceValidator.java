
package acme.constraints;

import javax.validation.ConstraintValidatorContext;

import acme.client.components.validation.AbstractValidator;
import acme.client.components.validation.Validator;
import acme.client.helpers.MomentHelper;
import acme.entities.service.Service;

@Validator
public class ServiceValidator extends AbstractValidator<ValidService, Service> {

	// ConstraintValidator interface

	@Override
	protected void initialise(final ValidService annotation) {
		assert annotation != null;
	}

	@Override
	public boolean isValid(final Service service, final ConstraintValidatorContext context) {

		assert context != null;

		boolean result;

		if (service == null)
			super.state(context, false, "*", "javax.validation.constraints.NotNull.message");
		else {
			String promotionCode = service.getPromotionCode();
			String lastTwoDigits = promotionCode.substring(5);
			String currentYear = String.valueOf(MomentHelper.getCurrentMoment()).substring(2);
			boolean promotionCodeHasCurrentYear = lastTwoDigits == currentYear;

			super.state(context, promotionCodeHasCurrentYear, "promotionCode", "validation.service.promotionCode");
		}

		result = !super.hasErrors(context);

		return result;

	}

}
