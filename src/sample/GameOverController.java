package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.image.ImageView;

public class GameOverController{
    @FXML
    public AnchorPane OverRoot;

    @FXML
    private ImageView circle1,circle2;

    @FXML
    public Label textField;

    @FXML
    public Button button;

    @FXML
    public Label label;

    public DataTable lastGameData;


    public void initialize() {

        Obstacle.imageRotate(circle1,1,true);
        Obstacle.imageRotate(circle2,1,true);

    }

    @FXML
    public void restart(MouseEvent event) throws Exception{
        GameElements.addMusic("/Sound Effects/button.wav");
        AnchorPane pane= FXMLLoader.load(getClass().getResource("GamePlay.fxml"));
        OverRoot.getChildren().setAll(pane);
    }
    @FXML
    public void mainMenu(MouseEvent event) throws Exception{
        GameElements.addMusic("/Sound Effects/button.wav");
        AnchorPane pane= FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        OverRoot.getChildren().setAll(pane);
    }

    @FXML
    public void revive() throws Exception{
        GameElements.addMusic("/Sound Effects/button.wav");
        if(lastGameData.score>=4) {
            FXMLLoader load = new FXMLLoader(getClass().getResource("GamePlay.fxml"));
            AnchorPane Pane = load.load();
            GamePlayController GPobj = load.getController();
            OverRoot.getChildren().setAll(Pane);
            GPobj.initializeData(lastGameData.obstacles, lastGameData.colorSwitch, lastGameData.stars, lastGameData.ballPos, lastGameData.score-4, lastGameData.ballCol, -200, lastGameData.backgroImageID);
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR, "Insuffiecient stars! You must have at least 4 stars.", ButtonType.OK);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
                alert.hide();
            }
        }
    }

    @FXML
    public void exitGame(MouseEvent event) {
        GameElements.addMusic("/Sound Effects/button.wav");
        System.exit(0);
    }



}
