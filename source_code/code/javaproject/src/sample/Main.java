package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        if(netOk())
        {
            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            primaryStage.setTitle("Covid Info");
            Scene s = new Scene(root, 700, 500);
            s.getStylesheets().add("style.css");
            primaryStage.setScene(s);
            primaryStage.setResizable(false);
            primaryStage.show();
        }
        else
        {
            BorderPane tmp = new BorderPane();
            Label err = new Label("No Internet Connection!");
            err.setStyle("-fx-font-size: 30px");
            tmp.setCenter(err);
            primaryStage.setScene(new Scene(tmp,300,300));
            primaryStage.show();
        }


    }


    public static void main(String[] args)  {
        launch(args);

    }
    private boolean netOk()
    {
        try {

            Document doc = Jsoup.connect("https://www.worldometers.info/coronavirus/?utm_campaign=homeAdvegas1?").get();
            Elements hold = doc.select(".maincounter-number");
            ArrayList<String> values = new ArrayList<String>();
            for (Element x : hold) {
                String bfr = x.select("span").toString();
                values.add((bfr.substring(bfr.indexOf(">") + 1, bfr.indexOf("</"))).replace(",",""));
            }
            scrap.setData(values);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }

    }


}
