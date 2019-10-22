
package acme.features.anonymous.callePerezBulletin;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.callePerezBulletin.CallePerezBulletin;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousCallePerezBulletinListService implements AbstractListService<Anonymous, CallePerezBulletin> {

	// Internal state ---------------------------------------------------------

	@Autowired
	AnonymousCallePerezBulletinRepository repository;


	//AbstractListService<Administrator, CallePerezBulletin> interface -----------

	@Override
	public boolean authorise(final Request<CallePerezBulletin> request) {

		assert request != null;

		return true;
	}

	@Override
	public Collection<CallePerezBulletin> findMany(final Request<CallePerezBulletin> request) {
		assert request != null;

		Collection<CallePerezBulletin> result;

		result = this.repository.findMany();

		return result;
	}

	@Override
	public void unbind(final Request<CallePerezBulletin> request, final CallePerezBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "author", "title", "body", "moment");
	}
}
