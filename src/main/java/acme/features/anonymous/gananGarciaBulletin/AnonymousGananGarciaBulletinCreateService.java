
package acme.features.anonymous.gananGarciaBulletin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.gananGarciaBulletin.GananGarciaBulletin;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousGananGarciaBulletinCreateService implements AbstractCreateService<Anonymous, GananGarciaBulletin> {

	// Internal state ---------------------------------------------------------

	@Autowired
	AnonymousGananGarciaBulletinRepository repository;


	@Override
	public boolean authorise(final Request<GananGarciaBulletin> request) {
		assert request != null;

		return true;
	}

	@Override
	public GananGarciaBulletin instantiate(final Request<GananGarciaBulletin> request) {
		assert request != null;

		GananGarciaBulletin result;
		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);

		result = new GananGarciaBulletin();
		result.setNombre("David Ganan");
		result.setDorsal(10);
		result.setGoles(250);
		result.setPartidosJugados(200);
		result.setFechaInscripcion(moment);

		return result;
	}

	@Override
	public void unbind(final Request<GananGarciaBulletin> request, final GananGarciaBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "nombre", "dorsal", "goles", "partidosJugados");
	}

	@Override
	public void bind(final Request<GananGarciaBulletin> request, final GananGarciaBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void validate(final Request<GananGarciaBulletin> request, final GananGarciaBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void create(final Request<GananGarciaBulletin> request, final GananGarciaBulletin entity) {
		assert request != null;
		assert entity != null;

		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		entity.setFechaInscripcion(moment);
		this.repository.save(entity);
	}
}
