
package acme.entities.sanchezMunozBulletin;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class SanchezMunozBulletin extends DomainEntity {

	//Serialisation identifier---------------------------------

	private static final long	serialVersionUID	= 1L;

	//Attributes-------------------------------------------

	@NotBlank
	private String				author;

	@NotBlank
	private String				country;

	private Integer				quality;

}
