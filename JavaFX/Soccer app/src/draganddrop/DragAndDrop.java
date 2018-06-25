/*
 * Daryl Crosbie
 * ID: P453055
 */
package draganddrop;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.input.*;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Button;
/**
 *
 * @author Daryl
 */
public class DragAndDrop extends Application {
    double orgSceneX, orgSceneY;
    double orgTranslateX, orgTranslateY;
    ImageView ball, goal, pitch, before, after, scored;
    File html = new File("help.html");   
    @Override
    public void start(Stage stage) {
        Image b=null,g=null, back=null, be=null, af=null,s=null;
        try {
            b = new Image(new FileInputStream("img//ball.png"));
            g = new Image(new FileInputStream("img//goal.png"));
            back = new Image(new FileInputStream("img//pitch.jpg"));
            be = new Image(new FileInputStream("img//before.jpg"));
            af = new Image(new FileInputStream("img//after.jpg"));
            s = new Image(new FileInputStream("img//scored.jpg"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DragAndDrop.class.getName()).log(Level.SEVERE, null, ex);
        }
        ball = new ImageView(b);
        goal = new ImageView(g);
        pitch = new ImageView(back);
        before = new ImageView(be);
        after = new ImageView(af);
        scored = new ImageView(s);
        ball.setX(100); ball.setY(450);
        ball.setCursor(Cursor.CROSSHAIR);
        ball.setFitHeight(120); ball.setFitWidth(120);
        //ball.setOnMousePressed(ballOnMousePressedEventHandler);
        //ball.setOnMouseDragged(ballOnMouseDraggedEventHandler);
        ball.setOnDragDetected(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent e) {
                after.setOpacity(0.0);
                scored.setOpacity(0.0);
                Dragboard db = ball.startDragAndDrop(TransferMode.MOVE);
                ClipboardContent content = new ClipboardContent();
                content.putImage(ball.getImage());
                db.setContent(content);
                e.consume();
            }
        });
        ball.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent e){
                after.setOpacity(0.0);
                scored.setOpacity(0.0);
                e.consume();
            }
        });
        goal.setX(600); goal.setY(50);
        goal.setFitHeight(350); goal.setFitWidth(550);
        before.setX(50);before.setY(50);
        before.setFitHeight(280);before.setFitWidth(400);
        after.setX(50);after.setY(50);
        after.setFitHeight(280);after.setFitWidth(400);
        before.setOpacity(0.0);
        after.setOpacity(0.0);
        scored.setX(650);scored.setY(370);
        scored.setFitHeight(200);scored.setFitWidth(300);
        scored.setOpacity(0.0);
        Rectangle r = new Rectangle(650,140,280,190);
        r.setFill(Color.TRANSPARENT);
        pitch.setFitHeight(600); pitch.setFitWidth(1200);
        
        Button help = new Button("help!");
        help.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e){
                try{
                    Desktop.getDesktop().browse(html.toURI());
                }
                catch(IOException ex){
                   System.out.println(ex);
                }
            }
        });
        help.setLayoutY(570.0);
        help.setLayoutX(1150.0);
        Group p = new Group();
        p.getChildren().addAll(pitch,goal,r,ball,before,after,scored,help);
        
        Scene sc = new Scene(p, 1200,600);
        stage.setTitle("Back of the net");
        stage.setScene(sc);
        stage.show();
        
        r.setOnDragOver(new EventHandler<DragEvent>(){
            @Override
            public void handle(DragEvent e) {
                e.acceptTransferModes(TransferMode.MOVE);
                before.setOpacity(1.0);
                e.consume();
            }
        });
        r.setOnDragDropped(new EventHandler<DragEvent>(){
            @Override
            public void handle(DragEvent e){
                Dragboard db = e.getDragboard();
                if(db.hasImage()){
                   before.setOpacity(0.0);
                   after.setOpacity(1.0);
                   scored.setOpacity(1.0);
                }
                e.consume();
            }
        });
    }
    EventHandler<MouseEvent> ballOnMousePressedEventHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent t) {
            orgSceneX = t.getSceneX();
            orgSceneY = t.getSceneY();
            orgTranslateX = ((ImageView)(t.getSource())).getTranslateX();
            orgTranslateY = ((ImageView)(t.getSource())).getTranslateY();
        }
    };
    EventHandler<MouseEvent> ballOnMouseDraggedEventHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent t) {
            double offsetX = t.getSceneX() - orgSceneX;
            double offsetY = t.getSceneY() - orgSceneY;
            double newTranslateX = orgTranslateX + offsetX;
            double newTranslateY = orgTranslateY + offsetY;
            ((ImageView)(t.getSource())).setTranslateX(newTranslateX);
            ((ImageView)(t.getSource())).setTranslateY(newTranslateY);
        }
    };
    public static void main(String[] args) {
        launch(args);
    } 
}
