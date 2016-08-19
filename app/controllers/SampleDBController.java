package controllers;

import models.Test;
import play.Logger;
import play.db.Database;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.getAllTestData;
import views.html.sampledb;

import javax.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        return ok(getAllTestData.render(Test.find.all()));
    }

    public Result getName()
    {
        String name = "";
        try {

            Connection conn = db.getConnection();
            ResultSet rs;
            PreparedStatement ps = conn.prepareStatement("select name from test where id=? limit 1");
            ps.setInt(1,5);
            rs = ps.executeQuery();
            while (rs.next() ) {
                name = rs.getString("name");
            }

            conn.close();
            return ok(sampledb.render(name));
        } catch (Exception e) {
            Logger.error("Error:" + e.getMessage());
        }


        return ok();
    }
}
