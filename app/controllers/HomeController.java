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



   
  

}
