package controllers;

import play.api.Environment;
import play.mvc.*;
import play.data.*;
import play.db.ebean.Transactional;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;


import views.html.*;

import services.Users.*;

public class LoginController extends Controller {



    private FormFactory formFactory;


    private Environment env;


  @Inject
  public LoginController(Environment e,FormFactory f){

      this.env = e;
      this.formFactory = f;
  }

public Result login() {


    Form<Login> loginForm = formFactory.form(Login.class);


      return ok(login.render(loginForm));
}

public Result loginSubmit() {

    Form<Login> loginForm = FormFactory.form(Login.class).bindFromRequest();


    if(loginForm.hasErrors()) {
        return badRequest(login.render(loginForm,User.getUserById(session().get("email"))));
    }
    else {

        session().clear();

        session("email",loginForm.get().getEmail());
          }
       return redirect(controllers.routes.HomeController.index());

}

  //logout

  public Result logout() {

      session().clear();
      flash("success","you have been logged out");
      return redirect(routes.LoginController.login());
  }
}
