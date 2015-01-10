package pl.nutrivia.home;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//TODO oddzielic bloat z quickstartu od tego, co faktycznie jest uzywane w runtime
//TODO uprościć nutriparser - wywalić enuma Vitamin, przenieść to do nutrivia webapp (DRY!)
//TODO zmienić nutrivia-webapp na nutrivia-core z restem.
@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Principal principal) {
		return principal != null ? "home/homeSignedIn" : "home/homeNotSignedIn";
	}
}
