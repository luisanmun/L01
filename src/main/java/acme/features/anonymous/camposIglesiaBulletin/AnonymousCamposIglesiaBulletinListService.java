
package acme.features.anonymous.camposIglesiaBulletin;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.camposIglesiaBulletin.CamposIglesiaBulletin;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousCamposIglesiaBulletinListService implements AbstractListService<Anonymous, CamposIglesiaBulletin> {

	// Internal state ---------------------------------------------------------

	@Autowired
	AnonymousCamposIglesiaBulletinRepository repository;


	//AbstractListService<Administrator, SanchezMunozBulletin> interface -----------

	@Override
	public boolean authorise(final Request<CamposIglesiaBulletin> request) {

		assert request != null;

		return true;
	}

	@Override
	public Collection<CamposIglesiaBulletin> findMany(final Request<CamposIglesiaBulletin> request) {
		assert request != null;

		Collection<CamposIglesiaBulletin> result;

		result = this.repository.findMany();

		return result;
	}

	@Override
	public void unbind(final Request<CamposIglesiaBulletin> request, final CamposIglesiaBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "patrocinador", "equipo", "dorsal", "nacimiento");
	}
}
