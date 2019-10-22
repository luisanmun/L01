
package acme.features.anonymous.gananGarciaBulletin;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.gananGarciaBulletin.GananGarciaBulletin;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousGananGarciaBulletinListService implements AbstractListService<Anonymous, GananGarciaBulletin> {

	// Internal state ---------------------------------------------------------

	@Autowired
	AnonymousGananGarciaBulletinRepository repository;


	//AbstractListService<Administrator, SanchezMunozBulletin> interface -----------

	@Override
	public boolean authorise(final Request<GananGarciaBulletin> request) {

		assert request != null;

		return true;
	}

	@Override
	public Collection<GananGarciaBulletin> findMany(final Request<GananGarciaBulletin> request) {
		assert request != null;

		Collection<GananGarciaBulletin> result;

		result = this.repository.findMany();

		return result;
	}

	@Override
	public void unbind(final Request<GananGarciaBulletin> request, final GananGarciaBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "nombre", "dorsal", "goles", "partidosJugados", "fechaInscripcion");
	}
}
