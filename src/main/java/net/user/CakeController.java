package net.user;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import net.user.entity.Cake;
import net.user.entity.CakeDto;
import net.user.entity.Cart;
import net.user.entity.OrderCa;
import net.user.entity.OrderCaView;
import net.user.entity.OrderDto;
import net.user.entity.Product;
import net.user.service.CakeService;
import net.user.service.OrderCakeService;
import net.user.service.ProductService;


@Controller
public class CakeController {
	
@Autowired
private CakeService cakeService;

@Autowired 
private OrderCakeService orderCakeService;

@Autowired 
private ProductService productService;

@RequestMapping("/view")
public String view(HttpSession session, Model model) {
    if (session.getAttribute("cart") == null) {
    	
        return "redirect:/";
    }
    Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
    model.addAttribute("cart", cart);
    model.addAttribute("notCartViewPage", true);
    
    return "cart";
}


@RequestMapping("/add/{id}")
public String add(@PathVariable int id, HttpSession session, Model model, @RequestParam(value = "cartPage", required = false) String cartPage) {
    Product product = productService.findById(id).get();
    
    if (session.getAttribute("cart") == null) {
        Map<Integer, Cart> cart = new HashMap<>();
        cart.put(id, new Cart(id, product.getName(), product.getPrice(), 1, product.getImage()));
        session.setAttribute("cart", cart);
    } else {
        Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
        if (cart.containsKey(id)) {
            int qty = cart.get(id).getQuantity();
            cart.put(id, new Cart(id, product.getName(), product.getPrice(), ++qty, product.getImage()));
        } else {
            cart.put(id, new Cart(id, product.getName(), product.getPrice(), 1, product.getImage()));
            session.setAttribute("cart", cart);
        }
    }
    
    Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");

    int size = 0;
    double total = 0;
    boolean cartActive = false;
    for (Cart value : cart.values()) {
        size += value.getQuantity();
        total += value.getQuantity() * Double.parseDouble(value.getPrice());
        cartActive= true;
    }
    model.addAttribute("cartActive", cartActive);
    model.addAttribute("csize", size);
    model.addAttribute("ctotal", total);
    

    if (cartPage != null) {
        return "redirect:/view";
    }
    
    return "cart_view";
}


@RequestMapping("/category")
public String category( Model model, @RequestParam(value="page", required = false) Integer p) {
    int perPage = 20;
    int page = (p != null) ? p: 0;

    Pageable pageable = PageRequest.of(page, perPage);
    long count = 0;

    List<Product> products = productService.findAllByCategoryId("4", pageable);
        count = productService.countByCategoryId("4");
        model.addAttribute("products", products);

    double pageCount = Math.ceil((double) count / (double) perPage);

    model.addAttribute("pageCount", (int) pageCount);
    model.addAttribute("perPage", perPage);
    model.addAttribute("count", 10);
    model.addAttribute("page", page);

    return "products";
}

@RequestMapping("/bds")
public String bds( Model model, @RequestParam(value="page", required = false) Integer p) {
    int perPage = 20;
    int page = (p != null) ? p: 0;

    Pageable pageable = PageRequest.of(page, perPage);
    long count = 0;

        List<Product> products = productService.findAllByCategoryId("7", pageable);
        count = productService.countByCategoryId("4");
        model.addAttribute("products", products);

    double pageCount = Math.ceil((double) count / (double) perPage);

    model.addAttribute("pageCount", (int) pageCount);
    model.addAttribute("perPage", perPage);
    model.addAttribute("count", 10);
    model.addAttribute("page", page);

    return "bds";
}

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

@RequestMapping(value = {"/about"}, method = RequestMethod.GET)
public String about(ModelMap model,  @RequestParam(value="page",required = false) String p) {

	List<OrderCa> listOrderCa = new ArrayList<OrderCa>();
	
	String requestedValue = p;
	
	if(requestedValue.contains("basic")) {
		requestedValue = "basic" ;
	} else if(requestedValue.contains("oop")) {
		requestedValue = "oop" ;
	} else if(requestedValue.contains("string")) {
		requestedValue = "string" ;
	} else if(requestedValue.contains("thread")) {
		requestedValue = "thread" ;
	} else if(requestedValue.contains("io")) {
		requestedValue = "io" ;
	} else if(requestedValue.contains("collection")) {
		requestedValue = "collection" ;
	}
	
	listOrderCa = orderCakeService.getAllOrderCake(requestedValue);

	model.addAttribute("lstQ",listOrderCa);
	System.out.println("Size:"+listOrderCa.size());
	
	return "about";
}

@RequestMapping("/eng.html")
public String eng(ModelMap model) {
	
	List<OrderCa> listOrderCa = orderCakeService.getAllOrderCake("eng");
	model.addAttribute("lstQ",listOrderCa);
		System.out.println("Size:"+listOrderCa.size());
	return "eng";
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
	return "index";
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
 

  @GetMapping("/subtract/{id}")
  public String subtract(@PathVariable int id, HttpSession session, Model model, HttpServletRequest httpServletRequest) {
      Optional<Product> product = productService.findById(id);
      Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");

      int qty = cart.get(id).getQuantity();
      if (qty == 1) {
          cart.remove(id);
          if (cart.size() == 0) {
              session.removeAttribute("cart");
          }
      } else {
          cart.put(id, new Cart(id, product.get().getName(), product.get().getPrice(), --qty, product.get().getImage()));
      }

      String refererLink = httpServletRequest.getHeader("referer");
      return "redirect:" + refererLink;
  }

  @GetMapping("/remove/{id}")
  public String remove(@PathVariable int id, HttpSession session, Model model, HttpServletRequest httpServletRequest) {
      
      Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
      cart.remove(id);
      if (cart.size() == 0) {
          session.removeAttribute("cart");
      }

      String refererLink = httpServletRequest.getHeader("referer");
      return "redirect:" + refererLink;
  }

  @GetMapping("/clear")
  public String clear(HttpSession session, HttpServletRequest httpServletRequest) {
      session.removeAttribute("cart");

      String refererLink = httpServletRequest.getHeader("referer");
      return "redirect:" + refererLink;
  }
  
}
