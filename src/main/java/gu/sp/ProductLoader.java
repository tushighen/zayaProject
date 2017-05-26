package gu.sp;

import gu.sp.Product;
import gu.sp.ProductRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class ProductLoader implements ApplicationListener<ContextRefreshedEvent> {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        for (int i=0; i < 10; i++){

            Product shirt = new Product();
            shirt.setDescription("Spring Framework_" + i);
            shirt.setPrice(i * 10000);
            shirt.setImage("https://springframework.com/wp-content/uploads/2015/04/rf412049699c14ba5b68bb1c09182bfa2_8nax2_512.jpg");
            // shirt.setProductId("235268845711068308");
            productRepository.save(shirt);
        }
 
    }
}
