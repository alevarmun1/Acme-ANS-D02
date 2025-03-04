
package acme.entities.flightCrewMembers;

import javax.persistence.Column;
import javax.validation.Valid;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidMoney;
import acme.client.components.validation.ValidNumber;
import acme.client.components.validation.ValidString;
import acme.entities.airlines.Airline;

public class FlightCrewMember extends AbstractEntity {

	// Serialisation identifier
	private static final long	serialVersionUID	= 1L;

	// Attributes
	@Mandatory
	@ValidString(pattern = "^[A-Z]{2-3}\\d{6}$")
	@Column(unique = true)
	private String				employeeCode;

	@Mandatory
	@ValidString(pattern = "^\\+?\\d{6,15}$")
	@Automapped
	private String				phoneNumber;

	@Mandatory
	@ValidString(max = 255)
	@Automapped
	private String				languageSkills;

	@Mandatory
	@Valid
	@Automapped
	private AvailabilityStatus	availabilityStatus;

	@Mandatory
	@Valid
	@Automapped
	private Airline				airline;

	@Mandatory
	@ValidMoney
	@Automapped
	private Airline				salary;

	@Optional
	@ValidNumber(min = 0)
	@Automapped
	private Integer				yearsOfExperience;

	// Derived attributes

	// Relationships
}
