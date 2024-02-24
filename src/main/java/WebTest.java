import com.codeborne.selenide.ElementsCollection;
import org.testng.annotations.BeforeSuite;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class WebTest {

    @BeforeSuite
    public void beforeSuite() {
         Configuration.baseUrl = "https://www.google.com/";
         Configuration.browser = "chrome";
    }
    @Test
    public void webTest(){

        //open "google.com"
        open("/");
        $(byId("L2AGLb")).click();

        //search for "imdb"
        $(byName("q")).val("imdb").pressEnter();

        //click on correct search result that redirects to "imdb.com"
        $$(".tF2Cxc").first().find("a").click();

        //click on Menu button
        $(".ipc-responsive-button__text").click();

        //click on "Born Today"
        $(".ipc-list-item__text").click();

        // Get the first 5 celebrities who are born today
        ElementsCollection celebrities = $$(".ipc-title__text").first(5);

        // Print out the names of the first 5 celebrities
        for (int i = 0; i < celebrities.size(); i++) {
            java.lang.String celebrityName = celebrities.get(i).getText();
            System.out.println((String) celebrityName);
        }

    }

}



