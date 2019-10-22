
package acme.features.anonymous.camposIglesiaBulletin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.camposIglesiaBulletin.CamposIglesiaBulletin;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousCamposIglesiaBulletinCreateService implements AbstractCreateService<Anonymous, CamposIglesiaBulletin> {

	// Internal state ---------------------------------------------------------

	@Autowired
	AnonymousCamposIglesiaBulletinRepository repository;


	@Override
	public boolean authorise(final Request<CamposIglesiaBulletin> request) {
		assert request != null;

		return true;
	}

	@Override
	public CamposIglesiaBulletin instantiate(final Request<CamposIglesiaBulletin> request) {
		assert request != null;

		CamposIglesiaBulletin result;
		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);

		result = new CamposIglesiaBulletin();
		result.setPatrocinador("Adidas");
		result.setEquipo("SevillaFC");
		result.setNacimiento(moment);
		result.setDorsal(10);

		return result;
	}

	@Override
	public void unbind(final Request<CamposIglesiaBulletin> request, final CamposIglesiaBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "patrocinador", "equipo", "dorsal");
	}

	@Override
	public void bind(final Request<CamposIglesiaBulletin> request, final CamposIglesiaBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void validate(final Request<CamposIglesiaBulletin> request, final CamposIglesiaBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void create(final Request<CamposIglesiaBulletin> request, final CamposIglesiaBulletin entity) {
		assert request != null;
		assert entity != null;

		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		entity.setNacimiento(moment);
		this.repository.save(entity);
	}
}
