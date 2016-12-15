package controllers;

import play.mvc.*;

import views.html.*;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        return ok(index.render());
    }

     public Result UsedCars() {
        return ok(UsedCars.render());
    }

     public Result Service() {
        return ok(Service.render());
    }

     public Result Contact() {
        return ok(Contact.render());
    }


     public Result Enquiry() {
        return ok(Enquiry.render());
    }

     public Result AskOurTeam() {
        return ok(AskOurTeam.render());
    }

     public Result LocateUs() {
        return ok(LocateUs.render());
    }


 @Security.Authenticated(Secured.class)
@Transactional

 public Result deleteProduct(Long id) {

  product.find.ref(id).delete();

  flash("succes","product has been deleted");

  return redirect(controllers.routes.HomeController.products(0));

  } 

 private User getUserFromSession() {

 return User.getUserById(session().get("email"));

}
public Result index() {
  
  return ok(index.render(getUserFromSession()));

   
  
}

@Security.Authenticated(Secured.class){

public Result addProduct() {

  Form<Product>addProductForm = formFactory.form(Product.class);

  return ok(addProduct.render(addProductForm,getUserFromSession()));


}
}

@Transactional
 @Security.Authenticated(Secured.class)
public Result addProductSubmit() {

 Form<Product>newProductForm = formFactory.form(Product.class).bindFromRequest();

 if(newProductForm.hasErrors()) {

 return badRequest(addProduct.render(newProductForm,getUserFRomSession()));

}

  Product p = newProductForm.get();

 if(p.getId() == null) {
 p.save();

}
 else if (p.getId()!=null) {
 p.update();

}

 flash("succes","product" +p.getName()+"has been created/updated");

 return redirect(controllers.routes.HomeController.product(0));

}
  
  //update a product by id
  //called when edit button is pressed

@Security.Authenticated(Secured.class)
@Transactional

 public Result updateProduct(LOng id) {

 Product p;
 Form<Product>productForm;

try{

   p = Product.find.byId(id);

   productForm = formFactory.form(Product.class).fill(p);
  } catch (Exception ex) {
      
   return badRequest("error");

}

   return ok(addProduct.render(productForm,getUserFromSession()));

}


@Security.Authenticated(Secured.class)

@With(AuthAdmin.class)

@Transactional

public Result deleteProduct(Long id) {

    
} 


}



