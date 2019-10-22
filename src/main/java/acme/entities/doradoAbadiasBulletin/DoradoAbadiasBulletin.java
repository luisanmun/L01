
package acme.entities.doradoAbadiasBulletin;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class DoradoAbadiasBulletin extends DomainEntity {

	//Serialisation identifier---------------------------------

	private static final long	serialVersionUID	= 1L;

	//Attributes-------------------------------------------

	private Integer				oid;

	@NotBlank
	private String				uri;

	@NotBlank
	private String				author;

	@NotBlank
	private String				text;

}
