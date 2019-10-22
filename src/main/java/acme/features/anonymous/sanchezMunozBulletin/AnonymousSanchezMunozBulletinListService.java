
package acme.features.anonymous.sanchezMunozBulletin;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.sanchezMunozBulletin.SanchezMunozBulletin;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousSanchezMunozBulletinListService implements AbstractListService<Anonymous, SanchezMunozBulletin> {

	// Internal state ---------------------------------------------------------

	@Autowired
	AnonymousSanchezMunozBulletinRepository repository;


	//AbstractListService<Administrator, SanchezMunozBulletin> interface -----------

	@Override
	public boolean authorise(final Request<SanchezMunozBulletin> request) {

		assert request != null;

		return true;
	}

	@Override
	public Collection<SanchezMunozBulletin> findMany(final Request<SanchezMunozBulletin> request) {
		assert request != null;

		Collection<SanchezMunozBulletin> result;

		result = this.repository.findMany();

		return result;
	}

	@Override
	public void unbind(final Request<SanchezMunozBulletin> request, final SanchezMunozBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "author", "text", "moment");
	}
}
