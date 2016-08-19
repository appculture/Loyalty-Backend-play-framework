package controllers;

import models.Test;
import play.Logger;
import play.db.Database;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.List;

public class SampleDBController extends Controller {

    private Database db;

    @Inject
    public SampleDBController(Database db) {
        this.db = db;
    }

    public Result getAllTestData() {


        List<Test> data = Test.find.all();
        Test firstTest = Test.find.byId(1L);

        Logger.debug("db table size:" + data.size());
        //Logger.debug("name of first entry in db:" + firstTest.name);

        //return ok(sampledb.render("Database sample page."));
        return ok();
    }

    public Result getName()
    {


        return ok();
    }
}
