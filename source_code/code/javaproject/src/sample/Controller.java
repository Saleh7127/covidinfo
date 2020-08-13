package sample;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    PieChart chart;
    @FXML
    Label rate;


    public void first()
    {
        double x,y;
        x = Double.parseDouble(scrap.getData(0));
        y = Double.parseDouble(scrap.getData(1));
        ObservableList<PieChart.Data> hold = FXCollections.observableArrayList(
                new PieChart.Data("Total case: "+ scrap.getData(0),x),
                new PieChart.Data("Death: "+ scrap.getData(1),y),
                new PieChart.Data("Recovered: "+ scrap.getData(2),Double.parseDouble(scrap.getData(2)))
        );
        this.chart.setData(hold);
        rate.setText("Death Rate : "+ Integer.toString((int) ((y/x)*100))+"%");
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        first();
    }
}
