
package acme.features.anonymous.doradoAbadiasBulletin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.doradoAbadiasBulletin.DoradoAbadiasBulletin;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousDoradoAbadiasBulletinCreateService implements AbstractCreateService<Anonymous, DoradoAbadiasBulletin> {

	// Internal state ---------------------------------------------------------

	@Autowired
	AnonymousDoradoAbadiasBulletinRepository repository;


	@Override
	public boolean authorise(final Request<DoradoAbadiasBulletin> request) {
		assert request != null;

		return true;
	}

	@Override
	public DoradoAbadiasBulletin instantiate(final Request<DoradoAbadiasBulletin> request) {
		assert request != null;

		DoradoAbadiasBulletin result;

		result = new DoradoAbadiasBulletin();
		result.setAuthor("Oscar Dorado");
		result.setText("Biografia de Oscar!");
		result.setOid(100);
		result.setUri("www.ejemplo.com");

		return result;
	}

	@Override
	public void unbind(final Request<DoradoAbadiasBulletin> request, final DoradoAbadiasBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "oid", "uri", "author", "text");
	}

	@Override
	public void bind(final Request<DoradoAbadiasBulletin> request, final DoradoAbadiasBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void validate(final Request<DoradoAbadiasBulletin> request, final DoradoAbadiasBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void create(final Request<DoradoAbadiasBulletin> request, final DoradoAbadiasBulletin entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}
}
