package net.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootRApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRApplication.class, args);
	}
//    private CakeService cakeService;

//	@GetMapping("/service.html")
//	public String service(ModelMap model) {
//		
//		OrderDto order = new OrderDto();
//		
////		List<CakeDto> listCake = cakeDao.listCake(2);
//		List<CakeDto> listCake = new ArrayList<>();
//		model.addAttribute("listCake",listCake);
//		model.addAttribute("MSG","ZZZZZZZZZZZZZ");
//		model.addAttribute("order",order);
//		
//		return "service.html";
//		
//	}
//	
////	@GetMapping("/testimonial.html")
////	public String testimonial(ModelMap model) {
////		return "testimonial";
////	}
//	
//  	@RequestMapping("/testimonial.html")
//	public String testimonial(ModelMap model) {
//		return "testimonial";
//	}
//  	
//  	@RequestMapping("/about.html")
//	public String about(ModelMap model) {
//  		System.out.println("Size:");
//		return "about.html";
//	}
//  	
//	@GetMapping(value={"", "/index.html"})
//	public String index(ModelMap model) {
//		System.out.println("Size:");
//		OrderDto order = new OrderDto();
//		
////		List<CakeDto> listCake = new ArrayList<>();
//
//		List<Cake> listCake = cakeService.getAllCakes();
//		
//		System.out.println("Size:"+listCake.size());
//		
//		model.addAttribute("listCake",listCake);
//		
//		model.addAttribute("order",order);
//  		
//		return "index111";
//	}
//  	
//	@GetMapping("/menu.html")
//	public String menu(ModelMap model) {
//		return "menu.html";
//	}
//  	
//	@GetMapping("/team.html")
//	public String team(ModelMap model) {
//		return "team";
//	}
//  	
//	@GetMapping("/contact.html")
//	public String contact(ModelMap model) {
//		return "contact";
//	}
//  	
//	  @PostMapping("/save-order")
//	  public String saveProduct(@ModelAttribute OrderDto orderDto,  Model model) {
//		  orderDto.setStatus("inprogress");
//		  
////		  orderDao.updateOrder(orderDto);
//		  
//		//List<CakeDto> listPro = cakeDao.listProduct(1);
//		// model.addAttribute("listPro",listPro);
//		  OrderDto order = new OrderDto();
//		model.addAttribute("order",order);
//		model.addAttribute("msg","Thêm mới thành công! Chúng tôi sẽ liên hệ với "+orderDto.getCustomer()+" sớm theo sdt trên!");
//	    return "service";
//	  }
//	  
//	  @GetMapping("/import.html")
//		public String importProduct(ModelMap model) {
//			// List<CakeDto> listPro = cakeDao.listProduct(1);
//			// model.addAttribute("listPro",listPro);
//			CakeDto cake = new CakeDto();
//			model.addAttribute("cake",cake);
//			return "import";
//		}
//	  	
//	  @GetMapping(value = "/reloadOrderList")
//		public @ResponseBody byte[] reloadOrderList(String phone, String password) throws Exception {
//	  		
//	  		System.out.print(phone+":"+password);
//	  		
//	  		ObjectMapper objectMapper = new ObjectMapper();
//	  		
//	  		byte[] byteText = null;
//
//	  		return byteText;
//	}
//	  	
}
