
package acme.entities.maintenanceRecords;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.datatypes.Money;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidMoment;
import acme.client.components.validation.ValidMoney;
import acme.client.components.validation.ValidString;
import acme.entities.aircrafts.Aircraft;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class MaintenanceRecords extends AbstractEntity {

	// Serialisation identifier
	private static final long	serialVersionUID	= 1L;

	// Attributes
	@Mandatory
	@ValidMoment
	@Temporal(TemporalType.TIMESTAMP)
	private Date				maintenanceMoment;

	@Mandatory
	@Valid
	@Automapped
	private MaintenanceStatus	maintenanceStatus;

	@Mandatory
	@ValidMoment(past = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date				nextInspectionDate;

	@Mandatory
	@ValidMoney
	@Automapped
	private Money				estimatedCost;

	@Optional
	@ValidString(max = 255)
	@Automapped
	private String				notes;

	// Relationships
	@Mandatory
	@Valid
	@ManyToOne(optional = false)
	private Aircraft			aircraft;

}
