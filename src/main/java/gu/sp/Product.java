package gu.sp;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	String title;
	double price;
	String size;
	String img;
	String description;

   public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
	public String getTitle(){

		return title;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public double getPrice(){
		return price;
	}
	public void setPrice(double price){
		this.price = price;
	}
	public String getSize(){
		return size;
	}
	public void setSize(String size){
		this.size = size;
	}
	public String getImage(){
		return img;
	}
	public void setImage(String img){
		this.img = img;
	}

	public String getDescription(){
		return description;
	}
	public void setDescription(String description){
		this.description = description;
	}
}

