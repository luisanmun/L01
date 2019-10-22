
package acme.features.anonymous.sanchezMunozBulletin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.sanchezMunozBulletin.SanchezMunozBulletin;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousSanchezMunozBulletinCreateService implements AbstractCreateService<Anonymous, SanchezMunozBulletin> {

	// Internal state ---------------------------------------------------------

	@Autowired
	AnonymousSanchezMunozBulletinRepository repository;


	@Override
	public boolean authorise(final Request<SanchezMunozBulletin> request) {
		assert request != null;

		return true;
	}

	@Override
	public SanchezMunozBulletin instantiate(final Request<SanchezMunozBulletin> request) {
		assert request != null;

		SanchezMunozBulletin result;

		result = new SanchezMunozBulletin();
		result.setAuthor("Jhon Doe");
		result.setCountry("UK");
		result.setQuality(3);

		return result;
	}

	@Override
	public void unbind(final Request<SanchezMunozBulletin> request, final SanchezMunozBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "author", "country", "quality");
	}

	@Override
	public void bind(final Request<SanchezMunozBulletin> request, final SanchezMunozBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void validate(final Request<SanchezMunozBulletin> request, final SanchezMunozBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void create(final Request<SanchezMunozBulletin> request, final SanchezMunozBulletin entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}
}
