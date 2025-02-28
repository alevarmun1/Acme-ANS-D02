
package acme.entities.bookings;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidMoment;
import acme.client.components.validation.ValidNumber;
import acme.client.components.validation.ValidString;
import acme.entities.passengers.Passenger;
import acme.entities.student1.Flight;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Booking extends AbstractEntity {

	private static final long	serialVersionUID	= 1L;

	// Attributes
	@Mandatory
	@Column(unique = true)
	@ValidString(pattern = "^[A-Z0-9]{6,8}$")
	private String				locatorCode;

	@Mandatory
	@Temporal(TemporalType.TIMESTAMP)
	@ValidMoment(past = true)
	private Date				purchaseMoment;

	@Mandatory
	@Valid
	private TravelClass			travelClass;

	@Mandatory
	@ValidNumber(min = 0)
	private Double				price;

	@Optional
	@ValidNumber(min = 4, max = 4)
	private Integer				lastCreditCardDigits;

	// Relationships

	@Mandatory
	@Valid
	@ManyToOne
	private Passenger			passenger;

	@Mandatory
	@Valid
	@ManyToOne
	private Flight				flight;

}
