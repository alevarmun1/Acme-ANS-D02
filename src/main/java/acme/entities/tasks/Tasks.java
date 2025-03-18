
package acme.entities.tasks;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.ValidNumber;
import acme.constraints.ValidLongText;
import acme.realms.Technicians;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Tasks extends AbstractEntity {

	// Serialisation identifier

	private static final long	serialVersionUID	= 1L;

	// Attributes

	@Mandatory
	@Valid
	@Automapped
	private TaskType			taskType;

	@Mandatory
	@ValidLongText
	@Automapped
	private String				description;

	@Mandatory
	@ValidNumber(min = 0, max = 10)
	@Automapped
	private Integer				priority;

	@Mandatory
	@ValidNumber(min = 0, max = 1000)
	@Automapped
	private Integer				estimatedDuration;

	// Relationships

	@Mandatory
	@Valid
	@ManyToOne(optional = false)
	private Technicians			technician;

}
