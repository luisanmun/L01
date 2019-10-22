
package acme.features.anonymous.callePerezBulletin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.callePerezBulletin.CallePerezBulletin;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousCallePerezBulletinCreateService implements AbstractCreateService<Anonymous, CallePerezBulletin> {

	// Internal state ---------------------------------------------------------

	@Autowired
	AnonymousCallePerezBulletinRepository repository;


	@Override
	public boolean authorise(final Request<CallePerezBulletin> request) {
		assert request != null;

		return true;
	}

	@Override
	public CallePerezBulletin instantiate(final Request<CallePerezBulletin> request) {
		assert request != null;

		CallePerezBulletin result;
		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);

		result = new CallePerezBulletin();
		result.setAuthor("Pablo Calle Perez");
		result.setTitle("Otra vez");
		result.setMoment(moment);
		result.setBody("Otra vez, quiero estar bien sin ti, quiero ser tallo sin raiz");

		return result;
	}

	@Override
	public void unbind(final Request<CallePerezBulletin> request, final CallePerezBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "author", "title", "body");
	}

	@Override
	public void bind(final Request<CallePerezBulletin> request, final CallePerezBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void validate(final Request<CallePerezBulletin> request, final CallePerezBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void create(final Request<CallePerezBulletin> request, final CallePerezBulletin entity) {
		assert request != null;
		assert entity != null;

		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);
		this.repository.save(entity);
	}
}
