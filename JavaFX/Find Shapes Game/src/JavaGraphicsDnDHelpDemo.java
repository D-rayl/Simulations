/*
 * Daryl Crosbie
 * ID: P453055
 */
package javagraphicsdndhelpdemo;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.*;
import javafx.scene.text.*;
import javafx.scene.Cursor;
import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.application.Application;
import javafx.util.Duration;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.control.Label;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class JavaGraphicsDnDHelpDemo extends Application {
    Timeline timeline;
    Label timerLabel = new Label();
    DoubleProperty timeSeconds = new SimpleDoubleProperty();
    Duration time = Duration.ZERO;
    File html = new File("help.html"); 
    static Random r = new Random();
    double orgSceneX, orgSceneY;
    double orgTranslateX, orgTranslateY;
    Shape t,s,c;
    Text title,sq,tri,cir;
    Button reset, help;
    Group root;
    ImageView back;
    @Override
    public void start(Stage stage) {
        timerLabel.textProperty().bind(timeSeconds.asString());
        timerLabel.setTextFill(Color.RED);
        timerLabel.setStyle("-fx-font-size: 4em;");
        timerLabel.setLayoutX(450);
        timerLabel.setLayoutY(270);
        setShapes();
        setTxt();
        setPos();
        setButtons();
        setActionMethods();
        Image b = null;
        try{
           b = new Image(new FileInputStream("back.jpg")); 
        }catch(FileNotFoundException e){
            System.out.print(e);
        }
        back = new ImageView(b);
        back.setFitWidth(1000);
        back.setFitHeight(600);
        root = new Group();
        root.getChildren().addAll(back,title,timerLabel,s,c,t,sq,tri,cir,reset,help);
        stage.setScene(new Scene(root, 1000, 600));
        stage.setTitle("Find 2D Shapes");
        stage.show();
    }
    
    public void setButtons(){
        reset = new Button("Reset");
        help = new Button("Help!");
        reset.setFont(Font.font(20));
        help.setFont(Font.font(20));
        help.setLayoutX(920);
        help.setLayoutY(550);
        reset.setLayoutY(550);
        reset.setLayoutX(5);
        
        reset.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent a){
                setPos();
                time = Duration.ZERO;
                timeSeconds.set(time.toSeconds());
                timerLabel.setStyle("-fx-font-size: 4em;");
                timerLabel.toBack();
                back.toBack();
            }
        });
        help.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent a){
                try{
                    Desktop.getDesktop().browse(html.toURI());
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        });
    }
    
    public void setShapes(){
        t = new Polygon(0.0, 0.0, 150.0, 50.0, 50.0, 200.0);
        t.setFill(Paint.valueOf("#f4ed16"));
        c = new Circle(70,Paint.valueOf("#ffb900"));
        s = new Rectangle(150,150,Paint.valueOf("#62ff00"));
    }
    
    public void setActionMethods(){
        moveLabel(sq); 
        moveLabel(tri); 
        moveLabel(cir);
        changeOp(c);
        changeOp(s);
        changeOp(t);
    }
    
    public void setTxt(){
        title = new Text(50, 50, "Drag the words to find the shapes");
        sq = new Text(200, 580, "Square");
        tri = new Text(450, 580, "Triangle");
        cir = new Text(700, 580, "Circle");
        title.setFont(new Font(50));
        sq.setFont(new Font(35));
        tri.setFont(new Font(35));
        cir.setFont(new Font(35));
        c.setId("Circle"); 
        t.setId("Triangle"); 
        s.setId("Square");
    }
    
    public void setOp(){
        t.setOpacity(0.0); 
        s.setOpacity(0.0); 
        c.setOpacity(0.0);
    }
    
    public void setPos(){
        setOp();
        s.setLayoutX(r.nextInt(850)); 
        s.setLayoutY(r.nextInt(450)+30);
        t.setLayoutX(r.nextInt(850)); 
        t.setLayoutY(r.nextInt(450)+30);
        c.setLayoutX(r.nextInt(850)); 
        c.setLayoutY(r.nextInt(450)+30);
        
    }
    
    public void moveShape(Shape s){
        s.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
            orgSceneX = t.getSceneX();
            orgSceneY = t.getSceneY();
            orgTranslateX = ((Shape)(t.getSource())).getTranslateX();
            orgTranslateY = ((Shape)(t.getSource())).getTranslateY();
            ((Shape)(t.getSource())).toFront();
            title.setVisible(false);
            }
        });
        s.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
               
                double offsetX = t.getSceneX() - orgSceneX;
                double offsetY = t.getSceneY() - orgSceneY;
                double newTranslateX = orgTranslateX + offsetX;
                double newTranslateY = orgTranslateY + offsetY;
                ((Shape)(t.getSource())).setTranslateX(newTranslateX);
                ((Shape)(t.getSource())).setTranslateY(newTranslateY);
            }
        });
    }
    
    public void moveLabel(Text t){
        t.setOnMousePressed(new EventHandler<MouseEvent>() { 
        public void handle(MouseEvent e){
            t.setCursor(Cursor.OPEN_HAND);
            if(title.isVisible()){
                timeline = new Timeline(
                        new KeyFrame(Duration.millis(100),
                        new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent t) {
                                Duration duration = ((KeyFrame)t.getSource()).getTime();
                                time = time.add(duration);
                                timeSeconds.set(time.toSeconds());
                            }
                        }));
                    timeline.setCycleCount(Timeline.INDEFINITE);
                    timeline.play();
                    }
            title.setVisible(false);
            }
        });
        t.setOnDragDetected(new EventHandler<MouseEvent>() {
        public void handle(MouseEvent e){
            Dragboard db = t.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent content = new ClipboardContent();
            content.putString(t.getText());
            db.setContent(content);
            e.consume();
        }
        });
    }
    
    public void checkOp(){
        if(s.getOpacity() == 1.0 && t.getOpacity() == 1.0 && c.getOpacity() == 1.0){
            timeline.stop();
            timerLabel.setStyle("-fx-font-size: 15em;");
            timerLabel.toFront();
            title.setText("Well done! You can move the shapes");
            title.toFront();
            title.setVisible(true);
            moveShape(c); 
            moveShape(s); 
            moveShape(t);
        }
    }
    
    public void changeOp(Shape s){
        s.setOnDragOver(new EventHandler<DragEvent>(){
        @Override
        public void handle(DragEvent d){
            if(s.getId().equals(d.getDragboard().getString())){
                s.setOpacity(1.0);
                }
            checkOp();
            }
        });
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
