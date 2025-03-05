
package acme.entities.flights;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.Valid;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.ValidMoment;
import acme.client.components.validation.ValidString;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Leg extends AbstractEntity {

	// Serialisation identifier
	private static final long	serialVersionUID	= 1L;

	// Attributes
	@Mandatory
	@ValidString(pattern = "^[A-Z]{2}\\d{4}$", message = "{validation.leg.flightNumber}")
	@Column(unique = true)
	private String				flightNumber;

	@Mandatory
	@ValidMoment(past = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date				scheduledDeparture;

	@Mandatory
	@ValidMoment
	@Temporal(TemporalType.TIMESTAMP)
	private Date				scheduledArrival;

	@Mandatory
	@Valid
	@Automapped
	private Status				status;

	@Mandatory
	@ValidString
	@Automapped
	private String				departureAirport;

	@Mandatory
	@ValidString
	@Automapped
	private String				arrivalAirport;

	@Mandatory
	@ValidString
	@Automapped
	private String				aircraft;


	// Derived attributes
	@Transient
	public double duration() {
		if (this.scheduledDeparture != null && this.scheduledArrival != null) {
			long durationInSeconds = Duration.between(Instant.ofEpochMilli(this.scheduledDeparture.getTime()), Instant.ofEpochMilli(this.scheduledArrival.getTime())).toSeconds();
			return durationInSeconds / 3600.0;
		}
		return 0;
	}


	// Relationships
	@Mandatory
	@Valid
	@ManyToOne(optional = false)
	private Flight flight;
}
