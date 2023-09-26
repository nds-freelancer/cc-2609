package net.user;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import net.user.entity.Cake;
import net.user.entity.CakeDto;
import net.user.entity.OrderCa;
import net.user.entity.OrderCaView;
import net.user.entity.OrderDto;
import net.user.service.CakeService;
import net.user.service.OrderCakeService;

@Controller
public class CakeController {
	
@Autowired
  private CakeService cakeService;

@Autowired 
private OrderCakeService orderCakeService;


	@GetMapping("/home")
	public String home(ModelMap model) {
		
		List<Cake> listCake = cakeService.getAllCakes();
		List<CakeDto> listCakeDto = new ArrayList<CakeDto>(); 
		
		for(int i =0 ; i< listCake.size();i++) {
			CakeDto cakeDto = new CakeDto();
			Cake cake = listCake.get(i);
			cakeDto.setCakeid(cake.getCakeid());
			cakeDto.setCakename(cake.getCakename());
			listCakeDto.add(cakeDto);
		}
		
		OrderDto order = new OrderDto();
		
		model.addAttribute("listCake",listCakeDto);
		model.addAttribute("MSG","ZZZZZZZZZZZZZ");
		model.addAttribute("order",order);
		System.out.println("Size:");
		return "index";
	}
  
	@GetMapping("/service.html")
	public String service(ModelMap model) {
		
		OrderDto order = new OrderDto();
		
//		List<CakeDto> listCake = cakeDao.listCake(2);
		List<CakeDto> listCake = new ArrayList<CakeDto>();
		model.addAttribute("listCake",listCake);
		model.addAttribute("MSG","ZZZZZZZZZZZZZ");
		model.addAttribute("order",order);
		
		return "service";
	}
	
@GetMapping("/testimonial.html")
public String testimonial(ModelMap model) {
	return "testimonial";
}

@RequestMapping("/about.html")
public String about(ModelMap model) {
		System.out.println("Size:");
	return "about";
}
	
//@GetMapping(value={"", "/index.html"})
//public String index(ModelMap model) {
//	System.out.println("Size:");
//	OrderDto order = new OrderDto();
//	
////	List<CakeDto> listCake = new ArrayList<>();
//
//	List<Cake> listCake = cakeService.getAllCakes();
//	
//	System.out.println("Size:"+listCake.size());
//	
//	model.addAttribute("listCake",listCake);
//	
//	model.addAttribute("order",order);
//		
//	return "index";
//}
//	
@GetMapping("/menu.html")
public String menu(ModelMap model) {
	return "menu";
}
	
@GetMapping("/team.html")
public String team(ModelMap model) {
	return "team";
}
	
@GetMapping("/contact.html")
public String contact(ModelMap model) {
	return "contact";
}
	
  @PostMapping("/save-order")
  public String saveProduct(@ModelAttribute OrderDto orderDto,  Model model) {
	  orderDto.setStatus("inprogress");
	  
	  System.out.println("Save1:"+orderDto.getCakename()+orderDto.getNumber()
	  +orderDto.getCustomer()+orderDto.getAddress()+orderDto.getDateorder()+orderDto.getDateship());
	  
	  OrderCa orCa = new OrderCa();
	  
	  orCa.setCakeid(orderDto.getCakeid());
	  orCa.setNumber(orderDto.getNumber());
	  orCa.setCustomer(orderDto.getCustomer());
	  orCa.setDatecreate(orderDto.getDateorder());
	  orCa.setDateship(orderDto.getDateship());
	  orCa.setPhone(orderDto.getPhone());
	  orCa.setAddress(orderDto.getAddress());
	  orCa.setStatus("0");
	  orderCakeService.updateOrderCake(orCa);
	  
	  System.out.println("Save1:"+orderDto.getCakename()+orderDto.getNumber()
	  +orderDto.getCustomer()+orderDto.getAddress()+orderDto.getDateorder()+orderDto.getDateship());
	//List<CakeDto> listPro = cakeDao.listProduct(1);
	// model.addAttribute("listPro",listPro);
	OrderDto order = new OrderDto();
	model.addAttribute("order",order);
	model.addAttribute("msg","Thêm mới thành công! Chúng tôi sẽ liên hệ với "+orderDto.getCustomer()+" sớm theo sdt trên!");
    return "service";
  }
  
  @GetMapping("/import.html")
	public String importProduct(ModelMap model) {
		// List<CakeDto> listPro = cakeDao.listProduct(1);
		// model.addAttribute("listPro",listPro);
		CakeDto cake = new CakeDto();
		model.addAttribute("cake",cake);
		return "import";
	}
  	
  @GetMapping(value = "/reloadOrderList")
	public @ResponseBody byte[] reloadOrderList(String phone, String password) throws Exception {
  		
  		System.out.print(phone+":"+password);
  		
  		ObjectMapper objectMapper = new ObjectMapper();
  		
  		List<OrderCa> listOrderCa = orderCakeService.getAllOrderCake(phone);
  		List<Cake> listCake = cakeService.getAllCakes();
  		List<OrderCaView> listOcView = new ArrayList<OrderCaView>();
  		
  		for(int i=0; i< listOrderCa.size();i++) {
  			OrderCaView caView = new OrderCaView();
  			caView.setCakeid(listOrderCa.get(i).getCakeid());
  			caView.setNumber(listOrderCa.get(i).getNumber());
  			caView.setPhone(listOrderCa.get(i).getPhone());
  			caView.setCustomer(listOrderCa.get(i).getCustomer());
  			caView.setDateship(listOrderCa.get(i).getDateship());
  			caView.setDatecreate(listOrderCa.get(i).getDatecreate());
 			caView.setAddress(listOrderCa.get(i).getAddress());
  			caView.setStatus(listOrderCa.get(i).getStatus());
  			
  			for(int j=0; j< listCake.size();j++) {
  				if(listOrderCa.get(i).getCakeid() == listCake.get(j).getCakeid())
  					caView.setCakename(listCake.get(j).getCakename());
  			}
  			
  			if(listOrderCa.get(i).getStatus().equals("1")) {
  				caView.setStatusor("Da giao");
  			}else {
  				caView.setStatusor("Chua giao");
  			}
  			
  			listOcView.add(caView);
  		}
  		
  		ArrayNode listData = objectMapper.valueToTree(listOcView);
  		byte[] byteText =listData.toString().getBytes(Charset.forName("UTF-8"));
  		System.out.print("byteText:"+byteText);

  		return byteText;
}
  	
}
