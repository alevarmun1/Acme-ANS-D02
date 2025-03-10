
package acme.entities.flights;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.Valid;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.datatypes.Money;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidMoney;
import acme.client.components.validation.ValidString;
import acme.realms.managers.Manager;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Flight extends AbstractEntity {

	// Serialisation identifier
	private static final long	serialVersionUID	= 1L;

	// Attributes
	@Mandatory
	@ValidString(max = 50)
	@Automapped
	private String				tag;

	@Mandatory
	@Valid
	@Automapped
	private Boolean				indication;

	@Mandatory
	@ValidMoney
	@Automapped
	private Money				cost;

	@Optional
	@ValidString(max = 255)
	@Automapped
	private String				description;

	//	@Mandatory
	//	@ValidMoment(past = true)
	//	@Temporal(TemporalType.TIMESTAMP)
	//	private Date				scheduledDeparture;
	//
	//	@Mandatory
	//	@ValidMoment
	//	@Temporal(TemporalType.TIMESTAMP)
	//	private Date				scheduledArrival;
	//
	//	@Mandatory
	//	@ValidString
	//	@Automapped
	//	private String				originCity;
	//
	//	@Mandatory
	//	@ValidString
	//	@Automapped
	//	private String				destinationCity;
	//
	//	@Mandatory
	//	@ValidNumber
	//	@Automapped
	//	private int					numberOfLayovers;


	// Derived attributes
	//	@Transient
	//	public LocalDateTime getScheduledDeparture() {
	//		return legs != null && !legs.isEmpty() ? legs.stream().map(Leg::getScheduledDeparture).min(LocalDateTime::compareTo).orElse(null) : null;
	//	}
	//
	//	@Transient
	//	public LocalDateTime getScheduledArrival() {
	//		return legs != null && !legs.isEmpty() ? legs.stream().map(Leg::getScheduledArrival).max(LocalDateTime::compareTo).orElse(null) : null;
	//	}
	//
	//	@Transient
	//	public String getOriginCity() {
	//		return legs != null && !legs.isEmpty() ? legs.get(0).getDepartureAirport() : null;
	//	}
	//
	//	@Transient
	//	public String getDestinationCity() {
	//		return legs != null && !legs.isEmpty() ? legs.get(legs.size() - 1).getArrivalAirport() : null;
	//	}
	//
	//	@Transient
	//	public int getNumberOfLayovers() {
	//		return legs != null && !legs.isEmpty() ? legs.size() - 1 : 0;
	//	}
	@Transient
	public Date getScheduledDeparture() {
		return this.legs.stream().min(Comparator.comparing(Leg::getScheduledDeparture)).map(Leg::getScheduledDeparture).orElse(null);
	}

	@Transient
	public Date getScheduledArrival() {
		return this.legs.stream().max(Comparator.comparing(Leg::getScheduledArrival)).map(Leg::getScheduledArrival).orElse(null);
	}

	@Transient
	public String getOriginCity() {
		return this.legs.stream().min(Comparator.comparing(Leg::getScheduledDeparture)).map(Leg::getDepartureAirport).orElse(null);
	}

	@Transient
	public String getDestinationCity() {
		return this.legs.stream().max(Comparator.comparing(Leg::getScheduledArrival)).map(Leg::getArrivalAirport).orElse(null);
	}

	@Transient
	public int getNumberOfLayovers() {
		return Math.max(this.legs.size() - 1, 0);
	}


	// Relationships
	@Mandatory
	@Valid
	@ManyToOne//(optional = false)
	private Manager		manager;

	@Mandatory
	@Valid
	@OneToMany
	private List<Leg>	legs;
}
