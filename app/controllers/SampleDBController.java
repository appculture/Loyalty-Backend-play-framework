package controllers;

import models.Test;
import models.User;
import play.Logger;
import play.db.Database;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.list_sample_data;

import javax.inject.Inject;
import java.util.List;

public class SampleDBController extends Controller {

    private Database db;

    @Inject
    public SampleDBController(Database db) {
        this.db = db;
    }

    @Security.Authenticated(Secured.class)
    public Result getAllTestData() {

        List<Test> data = Test.find.all();
        //Test firstTest = Test.find.byId(1L);

        Logger.debug("db table size:" + data.size());
        //Logger.debug("name of first entry in db:" + firstTest.name);

        //return ok(sampledb.render("Database sample page."));
        return ok(list_sample_data.render(Test.find.all(), User.find.byId(request().username())));
    }

    public Result getName()
    {


        return ok();
    }
}
