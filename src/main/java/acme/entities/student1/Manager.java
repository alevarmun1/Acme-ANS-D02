
package acme.entities.student1;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.client.components.basis.AbstractEntity;

public class Manager extends AbstractEntity {

	// Serialisation identifier
	private static final long	serialVersionUID	= 1L;

	// Attributes
	@Column(unique = true)
	@NotBlank
	@Pattern(regexp = "^[A-Z]{2,3}\\d{6}$", message = "{validation.manager.identifierNumber}")
	private String				identifierNumber;

	@NotNull
	@Positive
	@Min(0)
	private int					years;

	@NotNull
	@PastOrPresent
	@Temporal(TemporalType.DATE)
	private Date				dateOfBirth;

	@URL
	@Length(max = 255)
	private String				link;

	// Derived attributes

	// Relationships

}
