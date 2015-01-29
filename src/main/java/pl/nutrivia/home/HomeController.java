package pl.nutrivia.home;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.nutrivia.domain.Carbo;
import pl.nutrivia.domain.Mass;

@RestController
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Carbo index() {
		return new Carbo(Mass.g(13));
	}
}
