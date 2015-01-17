package pl.nutrivia.home;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.nutrivia.domain.Carbo;
import pl.nutrivia.domain.Mass;
import pl.nutrivia.domain.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RestController
public class HomeController {

	//@PersistenceContext private EntityManager entityManager;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Carbo index() {
		return new Carbo(Mass.g(13));
	}

	//private List<Product> findAll() {
//		return entityManager.createQuery("from Product", Product.class).getResultList();
	//}
}
