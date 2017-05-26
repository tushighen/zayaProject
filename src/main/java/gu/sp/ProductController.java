package gu.sp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.*;



@Controller
public class ProductController {

	private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

	
	@RequestMapping("/product")
    public String greeting(@RequestParam(value="whofather", required=false, defaultValue="World") String myname, Model model) {
        
    	Product p = new Product();
    	p.setTitle("T-Shirt");
    	p.setPrice(10000.0);
    	p.setSize("Small");
    	p.setImage("https://media3.blue-tomato.com/is/image/bluetomato/302702335_front.jpg-tZztv1CvKh8wyTmsB3uvnRnr-Wg/adidas+Originals+Gazelle+Sneakers.jpg?$b1$");
        model.addAttribute("myproduct", p);

        return "product_details";
    }

    @RequestMapping("product/{id}")
    public String showProduct(@PathVariable Integer id, Model model){

        model.addAttribute("product", productRepository.findOne(id));
        return "productshow";
    }

    @RequestMapping("product/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){

        model.addAttribute("product", productRepository.findOne(id));
        return "productform";
    }

    @RequestMapping("product/delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        model.addAttribute("product", productRepository.findOne(id));
        productRepository.delete(id);
        return "redirect:/admin/products";
    }


	@RequestMapping(value="/products", method = RequestMethod.GET)
    public String list(Model model) {
    	// ArrayList<Product> product_list = new ArrayList<Product>();

    	// for (int i=0; i < 12; i++){
    	// 	Product p = new Product();
	    // 	p.setTitle("T-Shirt-" + i);
    	// 	p.setPrice(i*10000);
    	// 	p.setSize("Small");
    	// 	p.setImg("https://media3.blue-tomato.com/is/image/bluetomato/302702335_front.jpg-tZztv1CvKh8wyTmsB3uvnRnr-Wg/adidas+Originals+Gazelle+Sneakers.jpg?$b1$");
  			// product_list.add(p);
    	// }
 
    	// model.addAttribute("products", product_list);
     

        model.addAttribute("products", productRepository.findAll());
 
        //model.addAttribute("products", productService.listAllProducts());
        return "products";
    }

    @RequestMapping("product/new")
    public String newProduct(Model model){
        Product p = new Product();
        model.addAttribute("product",p);
        return "product_add";
    }
    @RequestMapping(value = "productsave", method = RequestMethod.POST)
    public String saveProduct(Product product){
        // System.err.println("--dd--");
        // System.err.println(product);
        productRepository.save(product);

        return "redirect:/product/" + product.getId();
    }
    @RequestMapping ("/home")
    public static String home( Model model) {

    	    Product p = new Product();
    	    p.setTitle("T-Shirt-");
    		p.setPrice(10000);
    		p.setSize("Small");
    		p.setImage("https://media3.blue-tomato.com/is/image/bluetomato/302702335_front.jpg-tZztv1CvKh8wyTmsB3uvnRnr-Wg/adidas+Originals+Gazelle+Sneakers.jpg?$b1$");
  			model.addAttribute("munkhzaya", p);

    	    return "home";
    }

    @RequestMapping(value="/admin/products", method = RequestMethod.GET)
    public String adminList(Model model) {
        
        model.addAttribute("products", productRepository.findAll());
 
        //model.addAttribute("products", productService.listAllProducts());
        return "admin_products";
    }
}
// @Repository
// public class ProductRepository {

// }