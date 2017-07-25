package face.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	@RequestMapping("/")
	public String tests() {
		return "/index";
	}

	@RequestMapping(value = "/page/{pageName}", method = RequestMethod.GET)
	public ModelAndView toIndex(@PathVariable String pageName) {
		ModelAndView mv = new ModelAndView(pageName);
		return mv;
	}
}
