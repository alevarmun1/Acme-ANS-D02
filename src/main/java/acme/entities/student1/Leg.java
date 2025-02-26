
package acme.entities.student1;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import acme.client.components.basis.AbstractEntity;

public class Leg extends AbstractEntity {

	// Serialisation identifier
	private static final long	serialVersionUID	= 1L;

	// Attributes
	@Column(unique = true)
	@NotBlank
	@Pattern(regexp = "^[A-Z]{2}\\d{4}$", message = "{validation.leg.flightNumber}")
	private String				flightNumber;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date				scheduledDeparture;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date				scheduledArrival;

	@NotNull
	private Status				status;

	@NotBlank
	private String				departureAirport;

	@NotBlank
	private String				arrivalAirport;

	@NotBlank
	private String				aircraft;


	// Derived attributes
	public double duration() {
		if (this.scheduledDeparture != null && this.scheduledArrival != null) {
			long durationInSeconds = Duration.between(Instant.ofEpochMilli(this.scheduledDeparture.getTime()), Instant.ofEpochMilli(this.scheduledArrival.getTime())).toSeconds();
			return durationInSeconds / 3600.0;
		}
		return 0;
	}


	// Relationships
	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private Flight flight;
}
