package pl.nutrivia.home;

import com.google.common.collect.ImmutableMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.nutrivia.nutriparser.dto.Mineral;
import pl.nutrivia.nutriparser.dto.ProductDto;
import pl.nutrivia.nutriparser.dto.Vitamin;

@RestController
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ProductDto index() {
		return new ProductDto("jakiś name", ImmutableMap.of(Vitamin.B1, 54.3), ImmutableMap.of(Mineral.Fe, 22.1)) ;
	}
}
