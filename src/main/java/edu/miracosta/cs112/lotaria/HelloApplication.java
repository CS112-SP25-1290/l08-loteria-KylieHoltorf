package edu.miracosta.cs112.lotaria;

//IMPORTED PACKAGES (first 3 are imports you will have for every javafx project)
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

import javafx.scene.control.Label; //components
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;

import javafx.scene.layout.VBox; //layout
import javafx.geometry.Pos;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.Font;

import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class HelloApplication extends Application {
    // CONSTANTS
    private static final LoteriaCard[] LOTERIA_CARDS = {
            new LoteriaCard("Las matematicas", "1.png", 1),
            new LoteriaCard("Las ciencias", "2.png", 2),
            new LoteriaCard("La Tecnología", "8.png", 8),
            new LoteriaCard("La ingeniería", "9.png", 9),
    };

    // CLASS-LEVEL VARIABLES
    private Label messageLabel, titleLabel;
    private ImageView cardImageView;
    private Button drawCardButton;
    //private ProgressBar gameProgressBar;
    private int count = 0;

    //GUI METHODS
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        //INSTANTIATE COMPONENTS
        titleLabel = new Label("Welcome to EChALE STEM Loteria!");
        cardImageView = new ImageView();
        messageLabel = new Label("Click the button to randomly draw a card.");
        drawCardButton = new Button("Draw Random Card.");
        //gameProgressBar = new ProgressBar(");

        //SET COMPONENT PROPERTIES
        titleLabel.setFont(new Font(18.0));

        LoteriaCard tempCard = new LoteriaCard();
        cardImageView.setImage(tempCard.getImage());
        cardImageView.setFitWidth(300);
        cardImageView.setPreserveRatio(true);

        messageLabel.setWrapText(true);
        messageLabel.setTextAlignment(TextAlignment.CENTER);

        //SETUP LAYOUT
        VBox mainLayout = new VBox();
        mainLayout.getChildren().addAll(titleLabel, cardImageView, messageLabel, drawCardButton); //gameProgressBar add

            mainLayout.setAlignment(Pos.CENTER);

        //SETUP SCENE AND SHOW
        Scene scene = new Scene(mainLayout, 350, 500);
        stage.setScene(scene);
        stage.setTitle("EChALE STEM Loteria");
        stage.show();

        //ADD EVENT HANDLING
        drawCardButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    //count++;

                    int cardNum = (int) (Math.random() * LOTERIA_CARDS.length); //range 0-3

                    LoteriaCard drawnCard = LOTERIA_CARDS[cardNum];

                    cardImageView.setImage(drawnCard.getImage());
                    messageLabel.setText(drawnCard.getCardName());

                }
            }
        );
    }



}
