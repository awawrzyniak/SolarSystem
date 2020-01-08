import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * A class that controls application display using the .fxml file
 */

public class Controller {
    Planet mercuryP = new Planet(0.387,0.2056,"Mercury");
    Planet venusP = new Planet(0.723,0.0068,"Venus");
    Planet earthP = new Planet(1,0.0167,"Earth");
    Planet marsP = new Planet(1.524,0.0934, "Mars");
    Planet jupiterP = new Planet(5.203,0.0484, "Jupiter");
    Planet saturnP = new Planet(9.537,0.0542, "Saturn");
    Planet uranusP = new Planet(19.191,0.0472, "Uranus");
    Planet neptuneP = new Planet(30.069,0.0086, "Neptune");

    ArrayList<XYChart.Series> selectedPlanets = new ArrayList<>();
    ArrayList<String> trajectories = new ArrayList<>();

    static int counter = 1;

    XYChart.Series series (Planet planet, double maxError, Methods method)
    {
        ArrayList<Trajectory> traj = CalculateTrajectory.keplerCalculation(planet, maxError, method);
        trajectories.add(planet.getName() + " " + method);
        XYChart.Series series = new XYChart.Series();
        series.setName(planet.getName()+ " " + method.toString());
        for (int i = 0; i < traj.size(); i++)
        {
            series.getData().add(new XYChart.Data < > (traj.get(i).getX(), traj.get(i).getY()));
            trajectories.add("x=" + traj.get(i).getX() + " y=" + traj.get(i).getY());
        }
        return series;
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox mainVBox;

    @FXML
    private TextField error;

    @FXML
    private ChoiceBox<Methods> methodField;

    @FXML
    private CheckBox mercury;

    @FXML
    private CheckBox venus;

    @FXML
    private CheckBox earth;

    @FXML
    private CheckBox mars;

    @FXML
    private CheckBox jupiter;

    @FXML
    private CheckBox saturn;

    @FXML
    private CheckBox uranus;

    @FXML
    private CheckBox neptune;

    @FXML
    private CheckBox other;

    @FXML
    private TextField dis;

    @FXML
    private TextField ecc;

    @FXML
    private Button addButton;

    @FXML
    private Button drawButton;

    @FXML
    private Button clearButton;

    @FXML
    private Button txtButton;

    @FXML
    private TextArea errorTxtBox;

    @FXML
    private ScatterChart<Number, Number> mainChart;

    @FXML
    void addClicked(ActionEvent event) {
            String blad;
            String distance;
            String eccentricity;
            StringBuilder B = new StringBuilder();
            StringBuilder D = new StringBuilder();
            StringBuilder E = new StringBuilder();
            blad = error.getText();
            distance = dis.getText();
            eccentricity = ecc.getText();
            B.append(blad);
            D.append(distance);
            E.append(eccentricity);
            int error2=0;
            int error3=0;


        if(blad.contains(",")) {
            B.replace(blad.indexOf(","), blad.indexOf(",") + 1, ".");
            error.setText(B.toString());
        }
        int licznik=0;
        for (int i = 0; i < blad.length(); i++) {

            for (int j = 0; j <= 10; j++)
            {
                if("0123456789.".charAt(j) != B.charAt(i))
                    licznik++;
            }
            if(licznik==11) {
                error.setText("0.01");
                error2=1;
            }
            licznik=0;
        }

            if (error2==1 || error.getLength()<=0)
            {
                errorTxtBox.setText("Wprowadzono zla wartosc parametru bledu");
                selectedPlanets.clear();
            }
            else {
                if (mercury.isSelected()) {
                    selectedPlanets.add(series(mercuryP, Double.parseDouble(error.getText()), methodField.getValue()));
                    mercury.setSelected(false);
                }
                if (earth.isSelected()) {
                    selectedPlanets.add(series(earthP, Double.parseDouble(error.getText()), methodField.getValue()));
                    earth.setSelected(false);
                }
                if (venus.isSelected()) {
                    selectedPlanets.add(series(venusP, Double.parseDouble(error.getText()), methodField.getValue()));
                    venus.setSelected(false);
                }
                if (mars.isSelected()) {
                    selectedPlanets.add(series(marsP, Double.parseDouble(error.getText()), methodField.getValue()));
                    mars.setSelected(false);
                }
                if (jupiter.isSelected()) {
                    selectedPlanets.add(series(jupiterP, Double.parseDouble(error.getText()), methodField.getValue()));
                    jupiter.setSelected(false);
                }
                if (neptune.isSelected()) {
                    selectedPlanets.add(series(neptuneP, Double.parseDouble(error.getText()), methodField.getValue()));
                    neptune.setSelected(false);
                }
                if (uranus.isSelected()) {
                    selectedPlanets.add(series(uranusP, Double.parseDouble(error.getText()), methodField.getValue()));
                    uranus.setSelected(false);
                }
                if (saturn.isSelected()) {
                    selectedPlanets.add(series(saturnP, Double.parseDouble(error.getText()), methodField.getValue()));
                    saturn.setSelected(false);
                }
                if (other.isSelected()) {

                    if(distance.contains(",")) {
                        D.replace(distance.indexOf(","), distance.indexOf(",") + 1, ".");
                        dis.setText(D.toString());
                    }
                    int licznik2=0;
                    for (int i = 0; i < distance.length(); i++) {

                        for (int j = 0; j <= 10; j++)
                        {
                            if("0123456789.".charAt(j) != D.charAt(i))
                                licznik2++;
                        }
                        if(licznik2==11) {
                            dis.setText("20");
                            error2=1;
                        }
                        licznik2=0;
                    }

                    if(eccentricity.contains(",")) {
                        E.replace(eccentricity.indexOf(","), eccentricity.indexOf(",") + 1, ".");
                        ecc.setText(E.toString());
                    }
                    int licznik3=0;
                    for (int i = 0; i < eccentricity.length(); i++) {

                        for (int j = 0; j <= 10; j++)
                        {
                            if("0123456789.".charAt(j) != E.charAt(i))
                                licznik3++;
                        }
                        if(licznik3==11) {
                            ecc.setText("0.01");
                            error3=1;
                        }
                        licznik3=0;
                    }

                    if (error2==1 & error3==1 || dis.getLength()<=0 & ecc.getLength()<=0)
                    {
                        errorTxtBox.setText("Wprowadzono zla wartosc parametrow Distance & Eccentricity");
                        selectedPlanets.clear();
                    }
                    else if (error3==1 || ecc.getLength()<=0)
                    {
                        errorTxtBox.setText("Wprowadzono zla wartosc parametru Eccentricity");
                        selectedPlanets.clear();
                    }
                    else if (error2==1 || dis.getLength()<=0)
                    {
                        errorTxtBox.setText("Wprowadzono zla wartosc parametru Distance");
                        selectedPlanets.clear();
                    }

                    Planet otherPlanet = new Planet(Double.parseDouble(dis.getText()), Double.parseDouble(ecc.getText()), "Other");
                    selectedPlanets.add(series(otherPlanet, Double.parseDouble(error.getText()), methodField.getValue()));
                    other.setSelected(false);
                }
            if (selectedPlanets.isEmpty()) {
                errorTxtBox.setText("Nie wybrano planety, sprobuj ponownie");
            }}
    }

    @FXML
    void clearClicked(ActionEvent event) {
        mainChart.getData().clear();
        trajectories.clear();
        selectedPlanets.clear();
        errorTxtBox.clear();
    }

    @FXML
    void drawClicked(ActionEvent event) {
        for(int i=0;i<selectedPlanets.size();i++)
            mainChart.getData().addAll(selectedPlanets.get(i));
                selectedPlanets.clear();
    }

    @FXML
    void txtClicked(ActionEvent event) {
        if (trajectories.isEmpty())
            errorTxtBox.setText("Nie wybrano obiektow, nie mozna zapisac pliku");
        else {
            Saver save = new Saver();
            save.saveToTxt(trajectories, counter);
            counter++;
        }
        }

    @FXML
    void initialize() {
        assert mainVBox != null : "fx:id=\"mainVBox\" was not injected: check your FXML file 'scene.fxml'.";
        assert error != null : "fx:id=\"error\" was not injected: check your FXML file 'scene.fxml'.";
        assert methodField != null : "fx:id=\"methodField\" was not injected: check your FXML file 'scene.fxml'.";
        assert mercury != null : "fx:id=\"mercury\" was not injected: check your FXML file 'scene.fxml'.";
        assert venus != null : "fx:id=\"venus\" was not injected: check your FXML file 'scene.fxml'.";
        assert earth != null : "fx:id=\"earth\" was not injected: check your FXML file 'scene.fxml'.";
        assert mars != null : "fx:id=\"mars\" was not injected: check your FXML file 'scene.fxml'.";
        assert jupiter != null : "fx:id=\"jupiter\" was not injected: check your FXML file 'scene.fxml'.";
        assert saturn != null : "fx:id=\"saturn\" was not injected: check your FXML file 'scene.fxml'.";
        assert uranus != null : "fx:id=\"uran\" was not injected: check your FXML file 'scene.fxml'.";
        assert neptune != null : "fx:id=\"neptun\" was not injected: check your FXML file 'scene.fxml'.";
        assert other != null : "fx:id=\"other\" was not injected: check your FXML file 'scene.fxml'.";
        assert dis != null : "fx:id=\"dis\" was not injected: check your FXML file 'scene.fxml'.";
        assert ecc != null : "fx:id=\"ecc\" was not injected: check your FXML file 'scene.fxml'.";
        assert addButton != null : "fx:id=\"addButton\" was not injected: check your FXML file 'scene.fxml'.";
        assert drawButton != null : "fx:id=\"drawButton\" was not injected: check your FXML file 'scene.fxml'.";
        assert clearButton != null : "fx:id=\"clearButton\" was not injected: check your FXML file 'scene.fxml'.";
        assert txtButton != null : "fx:id=\"txtButton\" was not injected: check your FXML file 'scene.fxml'.";
        assert errorTxtBox != null : "fx:id=\"errorTxtBox\" was not injected: check your FXML file 'scene.fxml'.";
        assert mainChart != null : "fx:id=\"mainChart\" was not injected: check your FXML file 'scene.fxml'.";

        ObservableList<Methods> options = FXCollections.observableArrayList(Methods.Bisection,Methods.FixedPoint,Methods.Newton,Methods.Falsi);
        methodField.setItems(options);
        methodField.setValue(Methods.Bisection);
        error.setText("0.05");
        dis.setText("0.2");
        ecc.setText("0.2");

    }
}
