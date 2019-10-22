
package acme.features.anonymous.doradoAbadiasBulletin;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.doradoAbadiasBulletin.DoradoAbadiasBulletin;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousDoradoAbadiasBulletinListService implements AbstractListService<Anonymous, DoradoAbadiasBulletin> {

	// Internal state ---------------------------------------------------------

	@Autowired
	AnonymousDoradoAbadiasBulletinRepository repository;


	//AbstractListService<Administrator, DoradoAbadiasBulletin> interface -----------

	@Override
	public boolean authorise(final Request<DoradoAbadiasBulletin> request) {

		assert request != null;

		return true;
	}

	@Override
	public Collection<DoradoAbadiasBulletin> findMany(final Request<DoradoAbadiasBulletin> request) {
		assert request != null;

		Collection<DoradoAbadiasBulletin> result;

		result = this.repository.findMany();

		return result;
	}

	@Override
	public void unbind(final Request<DoradoAbadiasBulletin> request, final DoradoAbadiasBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "oid", "uri", "author", "text");
	}
}
