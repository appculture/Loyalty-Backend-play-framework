package controllers;

import models.Test;
import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.sampledb;

import java.util.List;

public class SampleDBController extends Controller {

    public Result showDBSamplePage() {


        List<Test> data = Test.find.all();
        Test firstTest = Test.find.byId(1L);

        Logger.debug("db table size:" + data.size());
        //Logger.debug("name of first entry in db:" + firstTest.name);

        return ok(sampledb.render("Database sample page."));
    }
}
