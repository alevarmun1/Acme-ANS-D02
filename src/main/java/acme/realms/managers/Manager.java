
package acme.realms.managers;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import acme.client.components.basis.AbstractRole;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.ValidMoment;
import acme.client.components.validation.ValidNumber;
import acme.client.components.validation.ValidString;
import acme.client.components.validation.ValidUrl;
import acme.constraints.ValidManager;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@ValidManager
public class Manager extends AbstractRole {

	// Serialisation identifier
	private static final long	serialVersionUID	= 1L;

	// Attributes
	@Mandatory
	@ValidString(pattern = "^[A-Z]{2,3}\\d{6}$", message = "{validation.manager.identifierNumber}")
	@Column(unique = true)
	private String				identifierNumber;

	@Mandatory
	@ValidNumber
	@Automapped
	private int					years;

	@Mandatory
	@ValidMoment(past = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date				dateOfBirth;

	@Mandatory
	@ValidUrl
	@Automapped
	private String				link;

	// Derived attributes

	// Relationships

}
