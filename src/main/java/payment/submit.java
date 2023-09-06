package payment;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class submit {
	@GetMapping("/")
	public String home() {
		return "NewFile";
	}
	@GetMapping("/submit")
	public String submit(@RequestParam(name="ten") String ten,
			@RequestParam(name="kieu") String kieu,
			@RequestParam(name="so") String so,
			@RequestParam(name="cvc") String cvc,
			Model model) {
		RestTemplate restTemplate = new RestTemplate();
		String serverUrl = "http://localhost:9090/chiphi?ten=" + ten + "&kieu=" + kieu + "&so=" + so + "&cvc=" + cvc;
	    String response = restTemplate.getForObject(serverUrl, String.class);
		model.addAttribute("input", response);
		return "NewFile1";
	}
	@PostMapping()
	public String Test(){
		return "Test";
	}
}
