package actions;

import java.util.*;

import javax.faces.application.Application;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
 
import sun.awt.AppContext;


	    private String price;
	    public String gettittle() {
	        return tittle;
	    }
	    public void settittle(String tittle) {
	        this.tittle = tittle;
	    }
	    public String getname() {
	        return name;
	    }
	    public void setname(String name) {
	        this.name =name;
	    }
	    public String getauthorid() {
	        return authorid;
	    }
	    public void setauthorid(String authorid) {
	    	this.authorid = authorid;
	    }
	    public String getage() {
	        return age;
	    }
	    public void setage(String age) {
	    	this.age = age;
	    }
	    public String getcountry() {
	        return country;
	    }
	    public void setcountry(String country) {
	        this.country =country;
	    }
	    public String getisbn() {
	        return isbn;
	    }
	    public void setisbn(String isbn) {
	    	this.isbn = isbn;
	    }
	    public String getpublisher() {
	        return publisher;
	    }
	    public void setpublisher(String publisher) {
	    	this.publisher = publisher;
	    }
	    public String getpublishdate() {
	        return publishdate;
	    }
	    public void setpublishdate(String publishdate) {
	        this.publishdate =publishdate;
	    }
	    public String getprice() {
	        return price;
	    }
	    public void setprice(String price) {
	    	this.price = price;
	    }
    public String add()
    {
        bookModel model=new bookModel();
        model.save(isbn, tittle, authorid);
        return "add";
    }
    public String select()
    {
        bookModel blogModel=new bookModel();
        ArrayList list=blogModel.getList();
        ActionContext.getContext().put("list", list);
        return "list";
    }
    
    public String delete()
    {
        bookModel model=new bookModel();
        model.delete(isbn);
        return this.select();
    }
   
    public String updateOne()
    {
        bookModel model=new bookModel();
        model.update(authorid, name, country,age);
        return this.select();
    }
}
