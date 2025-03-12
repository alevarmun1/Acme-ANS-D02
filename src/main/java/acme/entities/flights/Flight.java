
package acme.entities.flights;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PersistenceContext;
import javax.persistence.Transient;
import javax.persistence.TypedQuery;
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
	private static final long							serialVersionUID	= 1L;

	@PersistenceContext
	private transient javax.persistence.EntityManager	entityManager;

	// Attributes
	@Mandatory
	@ValidString(max = 50)
	@Automapped
	private String										tag;

	@Mandatory
	@Valid
	@Automapped
	private Boolean										selfTransfer;

	@Mandatory
	@ValidMoney
	@Automapped
	private Money										cost;

	@Optional
	@ValidString(max = 255)
	@Automapped
	private String										description;


	// Derived attributes
	@Transient
	public Date getScheduledDeparture() {
		TypedQuery<Date> query = this.entityManager.createQuery("SELECT MIN(l.scheduledDeparture) FROM Leg l WHERE l.flight = :flight", Date.class);
		query.setParameter("flight", this);
		return query.getSingleResult();
	}

	@Transient
	public Date getScheduledArrival() {
		TypedQuery<Date> query = this.entityManager.createQuery("SELECT MAX(l.scheduledArrival) FROM Leg l WHERE l.flight = :flight", Date.class);
		query.setParameter("flight", this);
		return query.getSingleResult();
	}

	@Transient
	public String getOriginCity() {
		TypedQuery<String> query = this.entityManager.createQuery("SELECT l.departureAirport FROM Leg l WHERE l.flight = :flight ORDER BY l.scheduledDeparture ASC", String.class);
		query.setParameter("flight", this);
		return query.setMaxResults(1).getSingleResult();
	}

	@Transient
	public String getDestinationCity() {
		TypedQuery<String> query = this.entityManager.createQuery("SELECT l.arrivalAirport FROM Leg l WHERE l.flight = :flight ORDER BY l.scheduledArrival DESC", String.class);
		query.setParameter("flight", this);
		return query.setMaxResults(1).getSingleResult();
	}

	@Transient
	public int getNumberOfLayovers() {
		TypedQuery<Long> query = this.entityManager.createQuery("SELECT COUNT(l) FROM Leg l WHERE l.flight = :flight", Long.class);
		query.setParameter("flight", this);
		Long count = query.getSingleResult();
		return count != null ? Math.max(count.intValue() - 1, 0) : 0;
	}


	// Relationships
	@Mandatory
	@Valid
	@ManyToOne//(optional = false)
	private Manager manager;

}
