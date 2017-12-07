package thebr;

import java.awt.Desktop;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.collections.*;

import static java.lang.Math.random;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.Date;
import javafx.animation.AnimationTimer;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.FontWeight;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathElement;
import javafx.scene.shape.StrokeLineCap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import javafx.animation.Animation;
import javafx.animation.ScaleTransition;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.MediaView;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.transform.Rotate;
import javafx.stage.StageStyle;







public class TheBr extends Application {
                        static int nright=0;
                        static int nwrong=0;
                        static double mrk = 0.0;
                        Label response;
                        final static int SCENE_WIDTH=800;
                        final static int SCENE_HEIGHT=600;
                        static double marks=0.0; //for marks
                        private int btnPressed=0;
                        private static int admin=0;
                        


   Media backsound = new Media(TheBr.class.getResource("sound/background.mp3").toString());
   MediaPlayer backgroundPlayer = new MediaPlayer(backsound);
   
   
 //Media Player Right
   Media rightsound = new Media(TheBr.class.getResource("sound/right.mp3").toString());
   MediaPlayer rightPlayer = new MediaPlayer(rightsound);  
   
 //Media Player Wrong
   Media wrongsound = new Media(TheBr.class.getResource("sound/wrong.mp3").toString());
   MediaPlayer wrongPlayer = new MediaPlayer(wrongsound);  
                 
    
    public static void main(String[] args)
            {     
                launch(args);
            }
    
  
@Override   
public void start(Stage primaryStage) {
    
    
Group root = new Group();
FlowPane rootNode= new FlowPane();
rootNode.setAlignment(Pos.CENTER);
Scene scene = new Scene(root, 800, 600, Color.BLACK);
primaryStage.setScene(scene);
primaryStage.setTitle("The Brainify App");

//Media Player on begin
  // String musicFileBegin= "src\\thebr\\sound\\begin.mp3";
   Media soundbegin = new Media(TheBr.class.getResource("sound/begin.mp3").toString());
   MediaPlayer beginPlay = new MediaPlayer(soundbegin);
        beginPlay.setOnEndOfMedia(new Runnable(){
        public void run() {
        beginPlay.seek(Duration.ZERO);
                           }
                });
   beginPlay.play();
  
    Group logo = new Group();
      for(int i=0;i<1;i++)
    {
    Button btntext = new Button("The Brainify App");
    btntext.setId("btntext");
    logo.getChildren().add(btntext);
    }
    Timeline timeline2 = new Timeline();
for (Node ltext: logo.getChildren()) {
timeline2.getKeyFrames().addAll(
new KeyFrame(Duration.ZERO, // set start position at 0
        new KeyValue(ltext.translateXProperty(), 800),
        new KeyValue(ltext.translateYProperty(), -10)
            ),
 
        new KeyFrame(new Duration(2000), // set end position at 40s
        new KeyValue(ltext.translateXProperty(), 800),
        new KeyValue(ltext.translateYProperty(), -10)
                ),
        
                new KeyFrame(new Duration(3000), // set end position at 40s
        new KeyValue(ltext.translateXProperty(), 300),
        new KeyValue(ltext.translateYProperty(), -10)
                )
);
}
timeline2.play();

//Circle Background
Group circles = new Group();
for (int i = 0; i < 30; i++) {
Circle circle = new Circle(150, Color.web("white", 0.05));
circle.setStrokeType(StrokeType.OUTSIDE);
circle.setStroke(Color.web("white", 0.16));
circle.setStrokeWidth(4);
circles.getChildren().add(circle);
}
Rectangle colors = new Rectangle(scene.getWidth(), scene.getHeight(),
new LinearGradient(0f, 1f, 1f, 0f, true, CycleMethod.NO_CYCLE, new
Stop[]{
new Stop(0, Color.web("#FFFFFF")),
new Stop(0.14, Color.web("#FFFFFF")),
new Stop(0.28, Color.web("#FFFFFF")),
new Stop(0.43, Color.web("#FFFFFF")),
new Stop(0.57, Color.web("#FFFFFF")),
new Stop(0.71, Color.web("#FFFFFF")),
new Stop(0.85, Color.web("#FFFFFF")),
new Stop(1, Color.web("#FFFFFF")),}));
colors.widthProperty().bind(scene.widthProperty());
colors.heightProperty().bind(scene.heightProperty());
Group blendModeGroup =
new Group(new Group(new Rectangle(scene.getWidth(), scene.getHeight(),Color.BLACK), circles), colors);
colors.setBlendMode(BlendMode.OVERLAY);
root.getChildren().add(blendModeGroup);
circles.setEffect(new BoxBlur(10, 10, 3));
Timeline timeline = new Timeline();
for (Node circle: circles.getChildren()) {
timeline.getKeyFrames().addAll(
new KeyFrame(Duration.ZERO, // set start position at 0
new KeyValue(circle.translateXProperty(), random() * 800),
        new KeyValue(circle.translateYProperty(), random() * 600)
),
new KeyFrame(new Duration(20000), // set end position at 40s
new KeyValue(circle.translateXProperty(), random() * 800),
new KeyValue(circle.translateYProperty(), random() * 600)
),
new KeyFrame(new Duration(40000), // set end position at 40s
new KeyValue(circle.translateXProperty(), random() * 800),
new KeyValue(circle.translateYProperty(), random() * 600)
)
);
}
// play 40s of animation
timeline.setCycleCount(Timeline.INDEFINITE);
timeline.play();
//Circle Background End

 //Submit Form
 GridPane grid = new GridPane();
 grid.setAlignment(Pos.CENTER);
 grid.setHgap(10);
 grid.setVgap(10);
 grid.setId("gridc");
 grid.setPadding(new Insets(10,10,10,10));
 Text scenetitle= new Text("Please enter the details:-");
 scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
 scenetitle.setFill( Color.web("WHITE", 0.50) );
 grid.add(scenetitle,0,0,2,1);
 
 
Label name= new Label("Name:");
grid.add(name,0,1);
TextField nameTextField = new TextField();
nameTextField.setPromptText("Upto 15 chars:");
grid.add(nameTextField, 1 ,1);

Label mob = new Label("Mobile:");
grid.add(mob, 0,2);
TextField mobTextField= new TextField();
mobTextField.setPromptText("[0-9] 10 digits only:");
grid.add(mobTextField,1,2);

Label email= new Label("Email:");
grid.add(email, 0,3);
TextField emailTextField= new TextField();
emailTextField.setPromptText("email@example.com");
grid.add(emailTextField,1,3);

Button btn= new Button("Submit");
HBox hbBtn= new HBox(10);
hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
hbBtn.getChildren().add(btn);
grid.add(hbBtn,1,5);

btn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){  
    beginPlay.stop();    
    String nm = nameTextField.getText();
    String mb = mobTextField.getText();
    String eml = emailTextField.getText();
    System.out.println("The data is= "+nm+"  "+mb+"   "+eml);
    Date date = new Date();
    if((nm.length()==0&&nm.length()>=15)||mb.length()<10||eml.length()==0)
    {
        Text text = new Text("Invalid Entry!");
        text.setFont(Font.font("Tahoma", FontWeight.BOLD, 10));
        text.setFill( Color.web("RED", 0.70) );
        text.setX(458);
        text.setY(337);
        root.getChildren().add(text);
         try {       
                PauseTransition wait=new PauseTransition(Duration.seconds(1));
                wait.setOnFinished((e)->{
                TheBr obj = new TheBr();
                obj.start(primaryStage);
                });
                wait.play();
                }
                catch(Exception e){
		System.out.println("Error....in start!");
                }
    } 

    else
    {
    //Stroring data
    try(DataOutputStream dout = new DataOutputStream(new FileOutputStream("details.txt",true)))
    {
        
        dout.writeChars(nm+"\n");
        dout.writeChars(mb+"\n");
        dout.writeChars(eml+"\n");
        dout.writeChars(date+"\n");
        dout.close();
    }
    catch(IOException e)
    {
        System.out.println("I/O Error Occured");
    }  
    
    TheBr obj= new TheBr();
  // obj.ShowMarks(primaryStage, marks);
  timeline.stop();
   obj.LevelSelect(primaryStage, marks);
    }
    }
    });


    Group gridtrans = new Group();
    for(int i=0;i<1;i++)
    {
        GridPane grid2= new GridPane();
        grid2.setAlignment(Pos.CENTER);
        grid2.setHgap(0);
        grid2.setVgap(0);
        grid2.setPadding(new Insets(0,0,0,0));
        grid2.add(grid,0,0);
        gridtrans.getChildren().add(grid2);
    }
    Timeline timeline3 = new Timeline();
for (Node grid2: gridtrans.getChildren()) {
timeline3.getKeyFrames().addAll(
new KeyFrame(Duration.ZERO, // set start position at 0
        new KeyValue(grid2.translateXProperty(), 300),
        new KeyValue(grid2.translateYProperty(), 600)
),
        
        new KeyFrame(new Duration(2000), // still at 0,0 for 2 sec
        new KeyValue(grid2.translateXProperty(), 300),
        new KeyValue(grid2.translateYProperty(), 600)
),
new KeyFrame(new Duration(3000), // set end position at 3s
        new KeyValue(grid2.translateXProperty(), 300),
        new KeyValue(grid2.translateYProperty(),170)
)
);
}
timeline3.play();


//Form End
    
Button brand = new Button("\t\t© The Tortuous Inc\t\t");
brand.setId("btnbrand");
brand.setLayoutX(575);
brand.setLayoutY(550);
    brand.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
try{
    Desktop.getDesktop().browse(new URI("https://www.thetortuous.ueuo.com"));
    }
catch(IOException e1)
{
    e1.printStackTrace();
}
catch(URISyntaxException e1){
    e1.printStackTrace();
        }
    }
    });


Button devbtn = new Button("", new ImageView("/thebr/AdminControl/link.png"));

    devbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
try{
    Desktop.getDesktop().browse(new URI("https://web.facebook.com/mohd.shamweel"));
    }
catch(IOException e1)
{
    e1.printStackTrace();
}
catch(URISyntaxException e1){
    e1.printStackTrace();
        }
    }
    });
devbtn.setTranslateX(580);
devbtn.setTranslateY(500);

Button helpbtn = new Button("", new ImageView("/thebr/AdminControl/drop.png"));
    helpbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    beginPlay.stop();
    TheBr obj= new TheBr();
    obj.Info(primaryStage,marks);
    }
    });
helpbtn.setTranslateX(640);
helpbtn.setTranslateY(500);

//Inducing admin login logic
Button admn = new Button("",new ImageView("/thebr/AdminControl/admin.png"));
admn.setTranslateX(700);
admn.setTranslateY(500);
    admn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    beginPlay.stop();
    TheBr obj= new TheBr();
    obj.AdminLogin(primaryStage,marks);
    timeline.stop();
    beginPlay.stop();
    }
    });
//primaryStage.initStyle(StageStyle.UNIFIED);
primaryStage.getIcons().add(new Image("/thebr/TheBrainifyApp.jpg"));
primaryStage.setResizable(false);
root.getChildren().addAll(devbtn,admn,helpbtn,brand);
root.getChildren().add(gridtrans);
root.getChildren().add(logo);
//root.getChildren().add(texts);
scene.getStylesheets().add(TheBr.class.getResource("TheBr.css").toExternalForm());
primaryStage.show();

}

//..........Admin Login......
public void AdminLogin(Stage primaryStage, double marks)
{
    Group root = new Group();
FlowPane rootNode= new FlowPane();
Image imgb = new Image("/thebr/interback.jpg");
ImageView imgb1 = new ImageView(imgb);  
Scene scene = new Scene(root, 800, 600);
primaryStage.setResizable(false);
primaryStage.setScene(scene);
scene.getStylesheets().add(TheBr.class.getResource("inter.css").toExternalForm());

primaryStage.setTitle("The Brainify App: Admin Login:");  

        GridPane grid1= new GridPane();
        grid1.setId("gridadmin");
        grid1.setAlignment(Pos.CENTER);
        grid1.setHgap(10);
        grid1.setVgap(10);
        grid1.setPadding(new Insets(25,25,25,25));
        grid1.setLayoutX(225);
        grid1.setLayoutY(200);
        
        Text head = new Text("Admin Login:-");
        head.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        head.setFill( Color.web("white", 0.50) );
        grid1.add(head,0,0,2,1);
        
        
        Label username= new Label("Username:  ");
        username.setId("lbl");
        grid1.add(username, 0,1);
        TextField usernameTextField= new TextField();
        grid1.add(usernameTextField,1,1);
        
        Label password= new Label("Password:  ");
        password.setId("lbl");
        grid1.add(password, 0,2);
        PasswordField pw= new PasswordField();
        grid1.add(pw,1,2);
        
        Button login = new Button("\t\t\t\tLogin\t\t\t\t");
        grid1.add(login,1,3);
        
        Button home = new Button("\tHome\t");
        grid1.add(home,0,3);
        
        
    login.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
        String usrnm ="samuel";
        String pwd= "shamweel";
        if((usrnm.equals(usernameTextField.getText())&&(pwd.equals(pw.getText()))))
        {
          admin=1;
          TheBr obj = new TheBr();
          obj.Page2(primaryStage,marks);
        }
        else
        {
            Text fail = new Text("Login Failure");
            grid1.add(fail,0,4,2,1);
        }
    }
    });
    
    home.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
        TheBr obj = new TheBr();
        obj.start(primaryStage);
    }
    });
root.getChildren().addAll(imgb1,grid1);
primaryStage.setScene(scene);
primaryStage.setResizable(false);
scene.getStylesheets().add(TheBr.class.getResource("inter.css").toExternalForm());			
primaryStage.getIcons().add(new Image("/thebr/TheBrainifyApp.jpg"));
primaryStage.show();
}

//Information
public void Info(Stage primaryStage, double marks)
{
Group root = new Group();
FlowPane rootNode= new FlowPane();
primaryStage.setTitle("The Brainify App:-"); 

     MediaPlayer info = new MediaPlayer(new Media(TheBr.class.getResource("sound/info.mp3").toString()));
             info.setOnEndOfMedia(new Runnable(){
        public void run() {
        info.seek(Duration.ZERO);
                           }
                });
     info.play();
     
/*Button codebtn= new Button("", new ImageView("/thebr/AdminControl/coding.gif"));
codebtn.setTranslateX(150);
codebtn.setTranslateY(247); */

Button strbtn = new Button("\tPlay\t\t", new ImageView("/thebr/AdminControl/help.png"));
strbtn.setContentDisplay(ContentDisplay.TOP);
    strbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
        info.stop();
        TheBr obj = new TheBr();
        obj.start(primaryStage);
    }
    });

    Button adminbtn = new Button("Admin Login", new ImageView("/thebr/AdminControl/admin.png"));
    adminbtn.setContentDisplay(ContentDisplay.TOP);
    adminbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
        TheBr obj = new TheBr();
        info.stop();
        obj.AdminLogin(primaryStage,marks);
    }
    });

Button infobtn = new Button("How to Play", new ImageView("/thebr/AdminControl/info.png"));
infobtn.setContentDisplay(ContentDisplay.TOP);
    infobtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
        info.stop();
        TheBr obj = new TheBr();
        obj.Information(primaryStage,marks);
    }
    });

    Button creditbtn = new Button("\tCredits\t",new ImageView("/thebr/AdminControl/credits.png"));
    creditbtn.setContentDisplay(ContentDisplay.TOP);
    creditbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
        info.stop();
        TheBr obj = new TheBr();
        obj.Credits(primaryStage,marks);
    }
    });
    
    Button highscrbtn = new Button("High Score",new ImageView("/thebr/AdminControl/hscore.png"));
    highscrbtn.setContentDisplay(ContentDisplay.TOP);
    highscrbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
        info.stop();
        TheBr obj = new TheBr();
        obj.ShowMarks(primaryStage,marks);
    }
    });
    
    Button backbtn = new Button("",new ImageView("/thebr/AdminControl/back.png"));
    backbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
        info.stop();
        TheBr obj = new TheBr();
        obj.start(primaryStage);
    }
    });
    
        GridPane grid1= new GridPane();
        grid1.setAlignment(Pos.CENTER);
        grid1.setHgap(10);
        grid1.setVgap(10);
        grid1.setPadding(new Insets(25,25,25,25));
        grid1.setTranslateX(175);
        grid1.setTranslateY(225);
        
        grid1.add(strbtn,0,0);
        grid1.add(adminbtn,1,0);
        grid1.add(infobtn,2,0);
        grid1.add(highscrbtn,3,0);
        grid1.add(creditbtn,4,0);
        grid1.add(backbtn,2,10);
        

Image imgb = new Image("/thebr/info.jpg");
ImageView imgb1 = new ImageView(imgb);  
root.getChildren().addAll(imgb1,grid1);
Scene scene = new Scene(root, 800, 600, Color.GRAY);
primaryStage.setResizable(false);
primaryStage.setScene(scene);
scene.getStylesheets().add(TheBr.class.getResource("TheBr.css").toExternalForm());						
primaryStage.getIcons().add(new Image("/thebr/TheBrainifyApp.jpg"));
primaryStage.show();
}

//Credits
public void Credits(Stage primaryStage, double marks)
{
Group root = new Group();
FlowPane rootNode= new FlowPane();
primaryStage.setTitle("The Brainify App:- Credits:"); 

    //Virtual Assistant
     MediaPlayer voice = new MediaPlayer(new Media(TheBr.class.getResource("virtualAssistant/credit.mp3").toString())); 
     voice.play();
        
    Button backbtn = new Button("\t\t\t\t Back\t\t\t\t");
    backbtn.setTranslateX(300);
    backbtn.setTranslateY(550);
    backbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
        TheBr obj = new TheBr();
        obj.Info(primaryStage,marks);
        voice.stop();
    }
    });

Image imgb = new Image("/thebr/credits.jpg");
ImageView imgb1 = new ImageView(imgb);  
root.getChildren().addAll(imgb1,backbtn);
Scene scene = new Scene(root, 800, 600, Color.GRAY);
primaryStage.setResizable(false);
primaryStage.setScene(scene);
scene.getStylesheets().add(TheBr.class.getResource("TheBr.css").toExternalForm());						
primaryStage.getIcons().add(new Image("/thebr/TheBrainifyApp.jpg"));
primaryStage.show();
}

//Information or About the Game
public void Information(Stage primaryStage, double marks)
{
Group root = new Group();
FlowPane rootNode= new FlowPane();
primaryStage.setTitle("The Brainify App:- Information:"); 

Image imgb = new Image("/thebr/interback.jpg");
ImageView imgb1 = new ImageView(imgb);  
Scene scene = new Scene(root, 800, 600, Color.GRAY);
primaryStage.setResizable(false);
primaryStage.setScene(scene);
scene.getStylesheets().add(TheBr.class.getResource("inter.css").toExternalForm());			
primaryStage.show();

        GridPane grid1=new GridPane();
        grid1.setId("gridlevel");
        grid1.setAlignment(Pos.CENTER);
        grid1.setHgap(10);
        grid1.setVgap(10);
        grid1.setPadding(new Insets(25,25,25,25));
                       
Text easy = new Text("Easy Mode:");
easy.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
easy.setId("3D");
easy.setFill( Color.web("BLACK", 0.50) );
grid1.add(easy,0,0);

Text info = new Text(
          "This mode shows the various ways,\n"
        + "How the questions could be asked?\n"
        + "and how to answer them.\n"
        + "There is time period of 30 sec,\n"
        + "before it expires the player needs\n"
        + "to answer the choice.The player will\n"
        + "score +1 for right answer and -0.5 \n"
        + "for wrong one."
         );
info.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
info.setFill( Color.web("WHITE", 0.50) );
grid1.add(info,0,1);


        GridPane grid2=new GridPane();
        grid2.setId("gridlevel");
        grid2.setAlignment(Pos.CENTER);
        grid2.setHgap(10);
        grid2.setVgap(10);
        grid2.setPadding(new Insets(25,25,25,25));
                       
Text inter = new Text("Intermediate Mode:");
inter.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
inter.setId("3D");
inter.setFill( Color.web("BLACK", 0.50) );
grid2.add(inter,0,0);

Text info2 = new Text(
          "This mode is generally based on,\n"
        + "animation and How the questions ?\n"
        + "could be framed via animation.\n"
        + "There is time period of 30 sec,\n"
        + "before it expires the player needs\n"
        + "to answer the choice.The player will\n"
        + "score +1 for right answer and -0.5 \n"
        + "for wrong one."
        );
info2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
info2.setFill( Color.web("WHITE", 0.50) );
grid2.add(info2,0,1);

        GridPane grid3=new GridPane();
        grid3.setId("gridlevel");
        grid3.setAlignment(Pos.CENTER);
        grid3.setHgap(10);
        grid3.setVgap(10);
        grid3.setPadding(new Insets(25,25,25,25));
                       
Text adv = new Text("Advance Mode:");
adv.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
adv.setId("3D");
adv.setFill( Color.web("BLACK", 0.50) );
grid3.add(adv,0,0);

Text info3 = new Text(
          "In this mode the user needs to ,\n"
        + "interact via input methods such as\n"
        + "mouse and keyboard keys.\n"
        + "There is time period of 30 sec,\n"
        + "before it expires the player needs\n"
        + "to answer the choice.The player will\n"
        + "score +1 for right answer and -0.5 \n"
        + "for wrong one."
        );
info3.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
info3.setFill( Color.web("WHITE", 0.50) );
grid3.add(info3,0,1);

Text head = new Text("\t\t\tHow to Play:");
head.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
head.setFill( Color.web("WHITE", 0.50) );


Button homebtn = new Button("\t\t\t\t\t\t\t\t\t\t\t\tBack\t\t\t\t\t\t\t\t\t\t\t\t\t");
homebtn.setId("levelSelectBtn");
    homebtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
        TheBr obj = new TheBr();
        obj.Info(primaryStage,marks);
    }
    });


        GridPane grid=new GridPane();
        grid.setId("gridinfo");
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setPadding(new Insets(0,0,0,0));
        grid.setLayoutX(100);
        grid.setLayoutY(10);
        grid.add(head,0,0,2,1);
        grid.add(grid1,0,1);
        grid.add(grid2,1,1);
        grid.add(grid3,0,2,2,1);
        grid.add(homebtn,0,3,2,1);


root.getChildren().addAll(imgb1,grid); 
primaryStage.getIcons().add(new Image("/thebr/TheBrainifyApp.jpg"));

}  


//Admin page2 for open levels/ Admin
public void Page2(Stage primaryStage, double marks)
{
Group root = new Group();
FlowPane rootNode= new FlowPane();
primaryStage.setTitle("The Brainify App");  

   Media sound = new Media(TheBr.class.getResource("sound/level.mp3").toString());
   MediaPlayer levelPlay = new MediaPlayer(sound);
   levelPlay.play(); 
   
ImageView s1 = new ImageView("/thebr/AdminControl/starW.png");
ImageView s2 = new ImageView("/thebr/AdminControl/starW.png");
ImageView s3 = new ImageView("/thebr/AdminControl/starW.png");
ImageView s4 = new ImageView("/thebr/AdminControl/starW.png");
ImageView s5 = new ImageView("/thebr/AdminControl/starW.png");
ImageView s6 = new ImageView("/thebr/AdminControl/starW.png");
ImageView s7 = new ImageView("/thebr/AdminControl/starW.png");
ImageView s8 = new ImageView("/thebr/AdminControl/starW.png");
ImageView s9 = new ImageView("/thebr/AdminControl/starW.png");
ImageView s10 = new ImageView("/thebr/AdminControl/starW.png");
ImageView s11 = new ImageView("/thebr/AdminControl/starW.png");
ImageView s12 = new ImageView("/thebr/AdminControl/starW.png");
ImageView sb1 = new ImageView("/thebr/AdminControl/starB.png");
ImageView sb2 = new ImageView("/thebr/AdminControl/starB.png");
ImageView sb3 = new ImageView("/thebr/AdminControl/starB.png");


//Easy Level
        GridPane grid1=new GridPane();
        grid1.setId("gridlevel");
        grid1.setAlignment(Pos.CENTER);
        grid1.setHgap(10);
        grid1.setVgap(10);
        grid1.setPadding(new Insets(25,25,25,25));
                       
Text easy = new Text("\tEasy Mode:");
easy.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
easy.setId("3D");
easy.setFill( Color.web("BLACK", 0.50) );
grid1.add(easy,0,0,5,1);

Button btn1= new Button("1");
btn1.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){ 
    levelPlay.stop();
    TheBr obj= new TheBr();
    obj.Emq1(primaryStage, marks);
    }
    });
grid1.add(btn1,0,1);
Button btn2= new Button("2");
                btn2.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent ae){ 
                levelPlay.stop();    
                TheBr obj= new TheBr();
                obj.Emq2(primaryStage, marks);
                }
                });
grid1.add(btn2,1,1);
Button btn3= new Button("3");
                btn3.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent ae){ 
                levelPlay.stop();    
                TheBr obj= new TheBr();
                obj.Emq3(primaryStage, marks);
                }
                });
grid1.add(btn3,2,1);
Button btn4= new Button("4");
                btn4.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent ae){ 
                levelPlay.stop();    
                TheBr obj= new TheBr();
                obj.Emq4(primaryStage, marks);
                }
                });
grid1.add(btn4,3,1);
Button btn5= new Button("5");
btn5.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    levelPlay.stop();
    TheBr obj= new TheBr();
    obj.Emq5(primaryStage, marks);
    }
    });
grid1.add(btn5,4,1);
Button btn6= new Button("6");
                btn6.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent ae){ 
                levelPlay.stop();    
                TheBr obj= new TheBr();
                obj.Emq6(primaryStage, marks);
                }
                });
grid1.add(btn6,0,2);
Button btn7= new Button("7");
                btn7.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent ae){ 
                levelPlay.stop();    
                TheBr obj= new TheBr();
                obj.Emq7(primaryStage, marks);
                }
                });
grid1.add(btn7,1,2);
Button btn8= new Button("8");
            btn8.setOnAction(new EventHandler<ActionEvent>() {
             public void handle(ActionEvent ae){  
             levelPlay.stop();
             TheBr obj= new TheBr();
             obj.Emq8(primaryStage, marks);
             }
             });
grid1.add(btn8,2,2);
Button btn9= new Button("9");
                btn9.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent ae){ 
                levelPlay.stop();    
                TheBr obj= new TheBr();
                obj.Emq9(primaryStage, marks);
                }
                });
grid1.add(btn9,3,2);
Button btn10= new Button("10");
				btn10.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent ae){ 
                levelPlay.stop();    
                TheBr obj= new TheBr();
                obj.Emq10(primaryStage, marks);
                }
                });
grid1.add(btn10,4,2);

//Adding star
grid1.add(s1,0,3);
grid1.add(s2,1,3);
grid1.add(s3,2,3);
grid1.add(sb1,3,3);
grid1.add(sb2,4,3);
 
//Intermediate Level
        GridPane grid2=new GridPane();
        grid2.setId("gridlevel");
        grid2.setAlignment(Pos.CENTER);
        grid2.setHgap(10);
        grid2.setVgap(10);
        grid2.setPadding(new Insets(25,25,25,25));

Text inter = new Text("  Intermediate Mode:");
inter.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
inter.setId("3D");
inter.setFill( Color.web("BLACK", 0.50) );
grid2.add(inter,0,0,5,1);

 Button btn11= new Button("1");
        btn11.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent ae){ 
                levelPlay.stop();    
                TheBr obj= new TheBr();
                obj.Imq1(primaryStage, marks);
                }
                });
 grid2.add(btn11,0,1);
Button btn12= new Button("2");
                        btn12.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent ae){ 
                levelPlay.stop();    
                TheBr obj= new TheBr();
                obj.Imq2(primaryStage, marks);
                }
                });
grid2.add(btn12,1,1);
Button btn13= new Button("3");
                        btn13.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent ae){ 
                levelPlay.stop();    
                TheBr obj= new TheBr();
                obj.Imq3(primaryStage, marks);
                }
                });
grid2.add(btn13,2,1);
Button btn14= new Button("4");
        btn14.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent ae){ 
                levelPlay.stop();    
                TheBr obj= new TheBr();
                obj.Imq4(primaryStage, marks);
                }
                });
grid2.add(btn14,3,1);
Button btn15= new Button("5");
                btn15.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent ae){ 
                levelPlay.stop();    
                TheBr obj= new TheBr();
                obj.Imq5(primaryStage, marks);
                }
                });
grid2.add(btn15,4,1);
Button btn16= new Button("6");
                btn16.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent ae){ 
                levelPlay.stop();    
                TheBr obj= new TheBr();
                obj.Imq6(primaryStage, marks);
                }
                });
grid2.add(btn16,0,2);
Button btn17= new Button("7");
                btn17.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent ae){ 
                levelPlay.stop();    
                TheBr obj= new TheBr();
                obj.Imq7(primaryStage, marks);
                }
                });
grid2.add(btn17,1,2);
Button btn18= new Button("8");
                btn18.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent ae){ 
                levelPlay.stop();    
                TheBr obj= new TheBr();
                obj.Imq8(primaryStage, marks);
                }
                });
grid2.add(btn18,2,2);
Button btn19= new Button("9");
                btn19.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent ae){ 
                levelPlay.stop();    
                TheBr obj= new TheBr();
                obj.Imq9(primaryStage, marks);
                }
                });
grid2.add(btn19,3,2);
Button btn20= new Button("10");
                btn20.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent ae){ 
                levelPlay.stop();    
                TheBr obj= new TheBr();
                obj.Imq10(primaryStage, marks);
                }
                });
grid2.add(btn20,4,2);

//adding star
grid2.add(s4,0,3);
grid2.add(s5,1,3);
grid2.add(s6,2,3);
grid2.add(s7,3,3);
grid2.add(sb3,4,3);

 //Advance Mode:
         GridPane grid3=new GridPane();
         grid3.setId("gridlevel");
        grid3.setAlignment(Pos.CENTER);
        grid3.setHgap(10);
        grid3.setVgap(10);
        grid3.setPadding(new Insets(25,25,25,25));

Text adv = new Text("    Advance Mode:");
adv.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
adv.setId("3D");
adv.setFill( Color.web("BLACK", 0.50) );
grid3.add(adv,0,0,5,1);

Button btn21= new Button("1");
                btn21.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent ae){ 
                levelPlay.stop();    
                TheBr obj= new TheBr();
                obj.Amq1(primaryStage, marks);
                }
                });
grid3.add(btn21,0,1);
Button btn22= new Button("2");
grid3.add(btn22,1,1);
Button btn23= new Button("3");
                btn23.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent ae){ 
                levelPlay.stop();    
                TheBr obj= new TheBr();
                obj.Amq3(primaryStage, marks);
                }
                });
grid3.add(btn23,2,1);
Button btn24= new Button("4");
                btn24.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent ae){ 
                levelPlay.stop();    
                TheBr obj= new TheBr();
                obj.Amq4(primaryStage, marks);
                }
                });
grid3.add(btn24,3,1);
Button btn25= new Button("5");
                btn25.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent ae){ 
                levelPlay.stop();    
                TheBr obj= new TheBr();
                obj.Amq5(primaryStage, marks);
                }
                });
grid3.add(btn25,4,1);
Button btn26= new Button("6");
                btn26.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent ae){ 
                levelPlay.stop();    
                TheBr obj= new TheBr();
                obj.Amq6(primaryStage, marks);
                }
                });
grid3.add(btn26,0,2);
Button btn27= new Button("7");
                btn27.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent ae){ 
                levelPlay.stop();    
                TheBr obj= new TheBr();
                obj.Amq7(primaryStage, marks);
                }
                });
grid3.add(btn27,1,2);
Button btn28= new Button("8");
                btn28.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent ae){ 
                levelPlay.stop();    
                TheBr obj= new TheBr();
                obj.Amq8(primaryStage, marks);
                }
                });
grid3.add(btn28,2,2);
Button btn29= new Button("9");
                btn29.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent ae){ 
                levelPlay.stop();    
                TheBr obj= new TheBr();
                obj.Amq9(primaryStage, marks);
                }
                });
grid3.add(btn29,3,2);
Button btn30= new Button("10");
                btn30.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent ae){ 
                levelPlay.stop();    
                TheBr obj= new TheBr();
                obj.Amq10(primaryStage, marks);
                }
                });
grid3.add(btn30,4,2);
//Adding star
grid3.add(s8,0,3);
grid3.add(s9,1,3);
grid3.add(s10,2,3);
grid3.add(s11,3,3);
grid3.add(s12,4,3);
  
        GridPane grid=new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));
        grid.setLayoutX(25);
        grid.setLayoutY(25);
        grid.add(grid1,0,0);
        grid.add(grid2,1,0);
        grid.add(grid3,0,1,2,1);
   
ScaleTransition st1 = new ScaleTransition(Duration.millis(500),grid1);
st1.setByX(0.2f);
st1.setByY(0.2f);
st1.setAutoReverse(true);
st1.setCycleCount(2);
grid1.setOnMouseEntered(e->
{
st1.play();   
});

ScaleTransition st2 = new ScaleTransition(Duration.millis(500),grid2);
st2.setByX(0.2f);
st2.setByY(0.2f);
st2.setAutoReverse(true);
st2.setCycleCount(2);
grid2.setOnMouseEntered(e->
{
st2.play();   
});

ScaleTransition st3 = new ScaleTransition(Duration.millis(500),grid3);
st3.setByX(0.2f);
st3.setByY(0.2f);
st3.setAutoReverse(true);
st3.setCycleCount(2);
grid3.setOnMouseEntered(e->
{
st3.play();   
});

//Return btn
    Button returnbtn = new Button("\tLOGOUT!\t", new ImageView("/thebr/AdminControl/return.png"));
    returnbtn.setContentDisplay(ContentDisplay.RIGHT);
    returnbtn.setTranslateX(615);
    returnbtn.setTranslateY(553);
    returnbtn.setId("levelExitbtn");
    returnbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
        TheBr obj = new TheBr();
        admin=0;
        levelPlay.stop();
        obj.start(primaryStage);
    }
    });


Image imgb = new Image("/thebr/interback.jpg");
ImageView imgb1 = new ImageView(imgb);
root.getChildren().addAll(imgb1,grid,returnbtn);        

Scene scene = new Scene(root, 800, 600, Color.GRAY);
primaryStage.setResizable(false);
primaryStage.setScene(scene);
primaryStage.setResizable(false);
scene.getStylesheets().add(TheBr.class.getResource("Page2.css").toExternalForm());			
primaryStage.getIcons().add(new Image("/thebr/TheBrainifyApp.jpg"));
primaryStage.show();
} 

//Level Page for User
public void LevelSelect(Stage primaryStage, double marks)
{
Group root = new Group();
FlowPane rootNode= new FlowPane();
primaryStage.setTitle("The Brainify App: Levels");  

   Media sound = new Media(TheBr.class.getResource("sound/level.mp3").toString());
   MediaPlayer levelPlay = new MediaPlayer(sound);
   levelPlay.play(); 
   
ImageView s1 = new ImageView("/thebr/AdminControl/starW.png");
ImageView s2 = new ImageView("/thebr/AdminControl/starW.png");
ImageView s3 = new ImageView("/thebr/AdminControl/starW.png");
ImageView s4 = new ImageView("/thebr/AdminControl/starW.png");
ImageView s5 = new ImageView("/thebr/AdminControl/starW.png");
ImageView s6 = new ImageView("/thebr/AdminControl/starW.png");
ImageView s7 = new ImageView("/thebr/AdminControl/starW.png");
ImageView s8 = new ImageView("/thebr/AdminControl/starW.png");
ImageView s9 = new ImageView("/thebr/AdminControl/starW.png");
ImageView s10 = new ImageView("/thebr/AdminControl/starW.png");
ImageView s11 = new ImageView("/thebr/AdminControl/starW.png");
ImageView s12 = new ImageView("/thebr/AdminControl/starW.png");
ImageView sb1 = new ImageView("/thebr/AdminControl/starB.png");
ImageView sb2 = new ImageView("/thebr/AdminControl/starB.png");
ImageView sb3 = new ImageView("/thebr/AdminControl/starB.png");


//Easy Level
        GridPane grid1=new GridPane();
        grid1.setId("gridlevel");
        grid1.setAlignment(Pos.CENTER);
        grid1.setHgap(10);
        grid1.setVgap(10);
        grid1.setPadding(new Insets(25,25,25,25));
                       
Text easy = new Text("\tEasy Mode:");
easy.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
easy.setId("3D");
easy.setFill( Color.web("BLACK", 0.50) );
grid1.add(easy,0,0,5,1);

Button e1btn = new Button("1");
e1btn.setId("levelSbtn");
    e1btn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){ 
    levelPlay.stop();
    TheBr obj= new TheBr();
    obj.Emq1(primaryStage, marks);
    }
    });
grid1.add(e1btn,0,1);
       
String[] kEasy = {"2","3","4","5","6","7","8","9","10"};

for(int i=0;i<9;i++)
{
Button btn = new Button(kEasy[i]);
btn.setId("levelSelectBtn");
if(i<=3)
grid1.add(btn, i+1, 1);   
if(i>3)
grid1.add(btn, i-4,2);   
}
//Adding star
grid1.add(s1,0,3);
grid1.add(s2,1,3);
grid1.add(s3,2,3);
grid1.add(sb1,3,3);
grid1.add(sb2,4,3);
 
//Intermediate Level
        GridPane grid2=new GridPane();
        grid2.setId("gridlevel");
        grid2.setAlignment(Pos.CENTER);
        grid2.setHgap(10);
        grid2.setVgap(10);
        grid2.setPadding(new Insets(25,25,25,25));

Text inter = new Text("  Intermediate Mode:");
inter.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
inter.setId("3D");
inter.setFill( Color.web("BLACK", 0.50) );
grid2.add(inter,0,0,5,1);

Button i1btn = new Button("1");
i1btn.setId("levelSbtn");
    i1btn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){ 
    levelPlay.stop();
    TheBr obj= new TheBr();
    obj.Imq1(primaryStage, marks);
    }
    });
grid2.add(i1btn,0,1);
       
String[] kInter = {"2","3","4","5","6","7","8","9","10"};

for(int i=0;i<9;i++)
{
Button btn = new Button(kEasy[i]);
btn.setId("levelSelectBtn");
if(i<=3)
grid2.add(btn, i+1, 1);   
if(i>3)
grid2.add(btn, i-4,2);   
}
//adding star
grid2.add(s4,0,3);
grid2.add(s5,1,3);
grid2.add(s6,2,3);
grid2.add(s7,3,3);
grid2.add(sb3,4,3);

 //Advance Mode:
         GridPane grid3=new GridPane();
         grid3.setId("gridlevel");
        grid3.setAlignment(Pos.CENTER);
        grid3.setHgap(10);
        grid3.setVgap(10);
        grid3.setPadding(new Insets(25,25,25,25));

Text adv = new Text("    Advance Mode:");
adv.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
adv.setId("3D");
adv.setFill( Color.web("BLACK", 0.50) );
grid3.add(adv,0,0,5,1);

Button a1btn = new Button("1");
a1btn.setId("levelSbtn");
    a1btn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){ 
    levelPlay.stop();
    TheBr obj= new TheBr();
    obj.Amq1(primaryStage, marks);
    }
    });
grid3.add(a1btn,0,1);
       
String[] kAdv = {"2","3","4","5","6","7","8","9","10"};

for(int i=0;i<9;i++)
{
Button btn = new Button(kAdv[i]);
btn.setId("levelSelectBtn");
if(i<=3)
grid3.add(btn, i+1, 1);   
if(i>3)
grid3.add(btn, i-4,2);   
}
//Adding star
grid3.add(s8,0,3);
grid3.add(s9,1,3);
grid3.add(s10,2,3);
grid3.add(s11,3,3);
grid3.add(s12,4,3);
  
        GridPane grid=new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));
        grid.setLayoutX(25);
        grid.setLayoutY(25);
        grid.add(grid1,0,0);
        grid.add(grid2,1,0);
        grid.add(grid3,0,1,2,1);
   
ScaleTransition st1 = new ScaleTransition(Duration.millis(500),grid1);
st1.setByX(0.2f);
st1.setByY(0.2f);
st1.setAutoReverse(true);
st1.setCycleCount(2);
grid1.setOnMouseEntered(e->
{
st1.play();   
});

ScaleTransition st2 = new ScaleTransition(Duration.millis(500),grid2);
st2.setByX(0.2f);
st2.setByY(0.2f);
st2.setAutoReverse(true);
st2.setCycleCount(2);
grid2.setOnMouseEntered(e->
{
st2.play();   
});

ScaleTransition st3 = new ScaleTransition(Duration.millis(500),grid3);
st3.setByX(0.2f);
st3.setByY(0.2f);
st3.setAutoReverse(true);
st3.setCycleCount(2);
grid3.setOnMouseEntered(e->
{
st3.play();   
});
//Return btn
    Button returnbtn = new Button("\tRETURN\t", new ImageView("/thebr/AdminControl/return.png"));
    returnbtn.setContentDisplay(ContentDisplay.RIGHT);
    returnbtn.setTranslateX(636);
    returnbtn.setTranslateY(553);
    returnbtn.setId("levelExitbtn");
    returnbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
        TheBr obj = new TheBr();
        levelPlay.stop();
        obj.MarksAdv(primaryStage,marks);
    }
    });


Image imgb = new Image("/thebr/interback.jpg");
ImageView imgb1 = new ImageView(imgb);
root.getChildren().addAll(imgb1,grid,returnbtn);        

Scene scene = new Scene(root, 800, 600, Color.GRAY);
primaryStage.setResizable(false);
primaryStage.setScene(scene);
primaryStage.getIcons().add(new Image("/thebr/TheBrainifyApp.jpg"));
scene.getStylesheets().add(TheBr.class.getResource("inter.css").toExternalForm());			
primaryStage.show();
} 

//...........EasyMode Q1......
public void Emq1(Stage primaryStage, double marks)
{
   //playing repeated background audio
  /*     backgroundPlayer.setOnEndOfMedia(new Runnable(){
       public void run() {
           backgroundPlayer.seek(Duration.ZERO);
       }
   });
      backgroundPlayer.play(); */
    
    //Virtual Assistant
     MediaPlayer voice = new MediaPlayer(new Media(TheBr.class.getResource("virtualAssistant/emq1.mp3").toString())); 
     voice.play(); 
     
    System.out.println("Reached EMq1");
    
FlowPane rootNode= new FlowPane();
primaryStage.setTitle("The Brainify App- Easy Mode:");  
    
//Timer Line       
        Group linesW = new Group();
        for(int i=0;i<1;i++)
        {
        Line whiteLine = new Line(0, 0, 780, 0);
        whiteLine.setStroke(Color.web("#4EFF00", 0.5));
        whiteLine.setStrokeWidth(40);
        whiteLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesW.getChildren().add(whiteLine);
        }
      
        Group linesO = new Group();
        for(int i=0;i<1;i++)
        {
        Line orangeLine = new Line(0, 0, 780, 0);
        orangeLine.setStroke(Color.web("#FF9900", 1.0));
        orangeLine.setStrokeWidth(40);
        orangeLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesO.getChildren().add(orangeLine);
        }
            
        Group linesR = new Group();
        for(int i=0;i<1;i++)
        {
        Line redLine = new Line(0, 0, 780, 0);
        redLine.setStroke(Color.web("#FF0000", 1.0));
        redLine.setStrokeWidth(40);
        redLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesR.getChildren().add(redLine);
        }
 
        
        Timeline timeline = new Timeline();
        for (Node whiteLine: linesW.getChildren()) 
        {
        timeline.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(whiteLine.translateXProperty(), -800),
        new KeyValue(whiteLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(18040), 
        new KeyValue(whiteLine.translateXProperty(), -320),
        new KeyValue(whiteLine.translateYProperty(), 0)
                )
                );
        }
        timeline.play();

        Timeline timeline1 = new Timeline();
        for (Node orangeLine: linesO.getChildren())
        {
        timeline1.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(18040), 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),        
        new KeyFrame(new Duration(18040), 
        new KeyValue(orangeLine.translateXProperty(), -320),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ), 
        
        new KeyFrame(new Duration(25550), 
        new KeyValue(orangeLine.translateXProperty(), -120),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    )
                    );
        }
        timeline1.play();

        Timeline timeline2 = new Timeline();
        for (Node redLine: linesR.getChildren())
        {
        timeline2.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(redLine.translateXProperty(), -800),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(25550),
        new KeyValue(redLine.translateXProperty(), -800),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),   
        new KeyFrame(new Duration(25550), 
        new KeyValue(redLine.translateXProperty(), -120),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),       
 
        new KeyFrame(new Duration(30000),
        new KeyValue(redLine.translateXProperty(), 0),
        new KeyValue(redLine.translateYProperty(), 0)
                    )
                    );
        }
        timeline2.play();  
        
        //Timer Lines END

 GridPane grid1 = new GridPane();
 
 GridPane grid2 = new GridPane();
 grid2.setAlignment(Pos.CENTER);
 grid2.setHgap(10);
 grid2.setVgap(10);
 grid2.setPadding(new Insets(125,25,25,125));
 Text scenetitle1= new Text("Q1. Which is not a social network site? ");
 scenetitle1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
 grid2.add(scenetitle1,0,0);
 
 grid1.setAlignment(Pos.CENTER);
 grid1.setHgap(10);
 grid1.setVgap(10);
 grid1.setPadding(new Insets(25,25,25,25));
 Button btnop1 = new Button("", new ImageView("/thebr/Brainify/fb.png"));
 btnop1.setId("btnq1");

 //Grid to align the action Event in centre
 GridPane grid3 = new GridPane();
 grid3.setAlignment(Pos.CENTER);
 grid3.setHgap(10);
 grid3.setVgap(10);
 grid3.setPadding(new Insets(1,1,1,1));
 final Text actiontarget = new Text();
 actiontarget.setId("actiontarget");
 grid3.add(actiontarget,0,0);
 grid2.add(grid3,0,2);
 //Fixed Action Align End
 
 
  //Timer Start
            System.out.println("btn pressed before timeline = "+ btnPressed);
            Timeline autoSlide = new Timeline(new KeyFrame(
            Duration.millis(30000),
            ae-> 
            { 
                if(btnPressed==0)
                {//Time out
                TheBr obj = new TheBr();
                obj.Emq2(primaryStage, marks);
                System.out.println("Q1 marks time out = "+ marks);
                System.out.println("btn pressed in timeline 0 = "+ btnPressed);
                }
            }     
            ));
            autoSlide.play();
            

 
 //Buttons Action
    btnop1.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    actiontarget.setText("OOPS!");
    btnPressed=1;
    TheBr obj= new TheBr();
    obj.Wrong(marks);
    if(btnPressed==1)
            {
                try {       
                PauseTransition wait=new PauseTransition(Duration.seconds(1));
                wait.setOnFinished((e)->{
                obj.Emq2(primaryStage, marks);
                System.out.println("btn pressed in timeline 1 = "+ btnPressed);
                System.out.println("Q1 marks = "+ marks);    
                });
                wait.play();
                }
                catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
                autoSlide.stop();
           }
    }
    });
 grid1.add(btnop1, 1,4);
 
 Button btnop2 = new Button("", new ImageView("/thebr/Brainify/tw.png"));
 btnop2.setId("btnq1");
    btnop2.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){   
   actiontarget.setText("OOPS!");
    btnPressed=1;
    TheBr obj= new TheBr();
    obj.Wrong(marks);
    if(btnPressed==1)
            {
                autoSlide.stop();
                try {       
                PauseTransition wait=new PauseTransition(Duration.seconds(1));
                wait.setOnFinished((e)->{
                obj.Emq2(primaryStage, marks);
                System.out.println("btn pressed in timeline 1 = "+ btnPressed);
                System.out.println("Q1 marks = "+ marks);    
                });
                wait.play();
                }
                catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
                
           }
    }
    });
 grid1.add(btnop2, 2,4);
 
    Button btnop3 = new Button("", new ImageView("/thebr/Brainify/ins.png"));
    btnop3.setId("btnq1");
    btnop3.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){  
    actiontarget.setText("OOPS!");
    btnPressed=1;
    TheBr obj= new TheBr();
    obj.Wrong(marks); 
    if(btnPressed==1)
            {
                try {       
                PauseTransition wait=new PauseTransition(Duration.seconds(1));
                wait.setOnFinished((e)->{
                obj.Emq2(primaryStage, marks);
                System.out.println("btn pressed in timeline 1 = "+ btnPressed);
                System.out.println("Q1 marks = "+ marks);    
                });
                wait.play();
                }
                catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
                autoSlide.stop();
           }
    }
    });
 grid1.add(btnop3, 3,4);
 
 Button btnop4 = new Button("", new ImageView("/thebr/Brainify/chr.png"));
 btnop4.setId("btnq1");
    final Text actiontargetR = new Text();
    actiontargetR.setId("actiontargetR");
    grid3.add(actiontargetR,0,0);
    btnop4.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    actiontargetR.setText("RIGHT!");
    btnPressed=1;
    TheBr obj= new TheBr();
    obj.Right(marks);
if(btnPressed==1)
            {
                try {       
                PauseTransition wait=new PauseTransition(Duration.seconds(1));
                wait.setOnFinished((e)->{
                obj.Emq2(primaryStage, marks);
                System.out.println("btn pressed in timeline 1 = "+ btnPressed);
                System.out.println("Q1 marks = "+ marks);    
                });
                wait.play();
                }
                catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
                autoSlide.stop();
           }    
    }
    });
 grid1.add(btnop4, 4,4);  
 grid2.add(grid1,0,1);
 
 //Admin control
 GridPane gridadmin = new GridPane();
 gridadmin.setAlignment(Pos.CENTER);
 gridadmin.setHgap(10);
 gridadmin.setVgap(10);
 gridadmin.setPadding(new Insets(0,0,0,0));
 gridadmin.setLayoutX(275);
 gridadmin.setLayoutY(550);
 TheBr obj = new TheBr();
if(admin==1)
{  
 autoSlide.stop();   
 Button prevbtn =new Button("", new ImageView("/thebr/AdminControl/previous.png"));
 gridadmin.add(prevbtn,0,0);
    prevbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Emq1(primaryStage,marks);
    }
    });

 Button relbtn =new Button("", new ImageView("/thebr/AdminControl/reload.png"));
 gridadmin.add(relbtn,1,0);
    relbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Emq1(primaryStage,marks);
    }
    });
 
 Button nextbtn = new Button("", new ImageView("/thebr/AdminControl/next.png"));
 gridadmin.add(nextbtn,2,0);
     nextbtn.setOnAction(new EventHandler<ActionEvent>() {
     public void handle(ActionEvent ae){
     obj.Emq2(primaryStage,marks);
     }
     });
     
 Button levelbtn =new Button("", new ImageView("/thebr/AdminControl/level.png"));
 gridadmin.add(levelbtn,3,0);
    levelbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Page2(primaryStage,marks);
    }
    });
}
 //Admin Control Ends
 
 //Adding Score View
        Text scrLbl = new Text("Score: ");
        scrLbl.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        scrLbl.setFill( Color.web("BLACK", 0.50) );
        scrLbl.setX(5);
        scrLbl.setY(595);
        
        String myscore= Double.toString(mrk);
        Text scrView= new Text();
        scrView.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
        scrView.setFill( Color.web("WHITE", 0.50) );
        scrView.setText(myscore);
        scrView.setX(63);
        scrView.setY(595);

//Adding close button
Button btnclose = new Button("",new ImageView("/thebr/AdminControl/close.png"));
btnclose.setId("btnclose");
btnclose.setTranslateX(750);
btnclose.setTranslateY(550);
    btnclose.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
        TheBr obj = new TheBr();
        obj.Marks(primaryStage,marks);
        voice.stop();
        autoSlide.stop();
    }
    });

 
 
Group root = new Group();
Image imgb = new Image("/thebr/background.jpg");
ImageView imgb1 = new ImageView(imgb);
root.getChildren().addAll(imgb1,linesW,linesO,linesR,grid2,gridadmin,btnclose,scrLbl,scrView);
 
Scene scene = new Scene(root, 800, 600, Color.GRAY);
primaryStage.setScene(scene);
primaryStage.setResizable(false);
scene.getStylesheets().add(TheBr.class.getResource("imgb.css").toExternalForm());			
primaryStage.getIcons().add(new Image("/thebr/TheBrainifyApp.jpg"));
primaryStage.show();


}


//Easy Mode Q2
public void Emq2(Stage primaryStage, double marks)
{
  System.out.println("Reached EMq2");
    
Group root = new Group();
FlowPane rootNode= new FlowPane();
primaryStage.setTitle("The Brainify App- Easy Mode:");  

    //Virtual Assistant
     MediaPlayer voice = new MediaPlayer(new Media(TheBr.class.getResource("virtualAssistant/emq2.mp3").toString())); 
     voice.play();

//Timer Line       
        Group linesW = new Group();
        for(int i=0;i<1;i++)
        {
        Line whiteLine = new Line(0, 0, 780, 0);
        whiteLine.setStroke(Color.web("#4EFF00", 0.5));
        whiteLine.setStrokeWidth(40);
        whiteLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesW.getChildren().add(whiteLine);
        }
      
        Group linesO = new Group();
        for(int i=0;i<1;i++)
        {
        Line orangeLine = new Line(0, 0, 780, 0);
        orangeLine.setStroke(Color.web("#FF9900", 1.0));
        orangeLine.setStrokeWidth(40);
        orangeLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesO.getChildren().add(orangeLine);
        }
            
        Group linesR = new Group();
        for(int i=0;i<1;i++)
        {
        Line redLine = new Line(0, 0, 780, 0);
        redLine.setStroke(Color.web("#FF0000", 1.0));
        redLine.setStrokeWidth(40);
        redLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesR.getChildren().add(redLine);
        }
 
        
        Timeline timeline = new Timeline();
        for (Node whiteLine: linesW.getChildren()) 
        {
        timeline.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(whiteLine.translateXProperty(), -800),
        new KeyValue(whiteLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(18040), 
        new KeyValue(whiteLine.translateXProperty(), -320),
        new KeyValue(whiteLine.translateYProperty(), 0)
                )
                );
        }
        timeline.play();

        Timeline timeline1 = new Timeline();
        for (Node orangeLine: linesO.getChildren())
        {
        timeline1.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(18040), 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),        
        new KeyFrame(new Duration(18040), 
        new KeyValue(orangeLine.translateXProperty(), -320),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ), 
        
        new KeyFrame(new Duration(25550), 
        new KeyValue(orangeLine.translateXProperty(), -120),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    )
                    );
        }
        timeline1.play();

        Timeline timeline2 = new Timeline();
        for (Node redLine: linesR.getChildren())
        {
        timeline2.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(redLine.translateXProperty(), -800),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(25550),
        new KeyValue(redLine.translateXProperty(), -800),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),   
        new KeyFrame(new Duration(25550), 
        new KeyValue(redLine.translateXProperty(), -120),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),       
 
        new KeyFrame(new Duration(30000),
        new KeyValue(redLine.translateXProperty(), 0),
        new KeyValue(redLine.translateYProperty(), 0)
                    )
                    );
        }
        timeline2.play();  
        
        //Timer Lines END

 GridPane grid1=new GridPane();
 grid1.setAlignment(Pos.CENTER);
 grid1.setHgap(10);
 grid1.setVgap(10);
 grid1.setPadding(new Insets(125,25,25,175));
 Text queE2=new Text("Q2. Which Brand's logo is this?");
 queE2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
 grid1.add(queE2,0,0,2,1);
 
 Image q2img= new Image("/thebr/Brainify/q2img.png");
 ImageView q2imgV = new ImageView(q2img);
 grid1.add(q2imgV,0,1);
 
 GridPane grid2= new GridPane();
 grid2.setAlignment(Pos.CENTER);
 grid2.setHgap(10);
 grid2.setVgap(10);
 grid2.setPadding(new Insets(25,25,25,25));
 
Label eq2= new Label("Enter brand: ");
eq2.setFont(new Font("Candara Bold",20));
grid2.add(eq2,0,0);
TextField eq2TextField = new TextField();
grid2.add(eq2TextField,0,1);
Button btn= new Button("Okay");
btn.setAlignment(Pos.BOTTOM_RIGHT);
grid2.add(btn,0,2);
grid1.add(grid2,1,1);

GridPane grid3= new GridPane();
 grid3.setAlignment(Pos.CENTER);
 grid3.setHgap(10);
 grid3.setVgap(10);
 grid3.setPadding(new Insets(1,1,1,1));
 
 final Text actiontargetR = new Text();
 actiontargetR.setId("actiontargetR");
 grid3.add(actiontargetR,0,0);
 grid1.add(grid3,0,2,2,1);
 
  //Timer start, will to skip if no button pressed
            System.out.println("btn pressed before timeline = "+ btnPressed);
            Timeline autoSlide = new Timeline(new KeyFrame(
            Duration.millis(30000),
            ae-> 
            { 
                if(btnPressed==0)
                {//Time out
                System.out.println("Q1 marks time out = "+ marks);
                System.out.println("btn pressed in timeline 0 = "+ btnPressed);
                TheBr obj = new TheBr();
                obj.Emq3(primaryStage, marks);
                }
            }     
            ));
            autoSlide.play();      
//End of auto Timer

btn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){ 
    btnPressed=1;
    String eqs = eq2TextField.getText();
    System.out.println("brand  = "+eqs);
    String ans ="bing";
    if(ans.equalsIgnoreCase(eqs))
    {
    System.out.println("Right");
    actiontargetR.setText("RIGHT!");
    TheBr obj= new TheBr();
    System.out.println("Q3_1 marks = "+ marks);
    obj.Right(marks);
   
    
    if(btnPressed==1)
            {
                try {       
                PauseTransition wait=new PauseTransition(Duration.seconds(1));
                wait.setOnFinished((e)->{
                System.out.println("btn pressed in timeline 1 = "+ btnPressed);
                System.out.println("Q1 marks = "+ marks);  
                obj.Emq3(primaryStage, marks);
                });
                wait.play();
                }
                catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
                autoSlide.stop();
           }
    }
    
    else
    {
        System.out.println("Wrong");
        final Text actiontarget = new Text();
    actiontarget.setId("actiontarget");
    grid3.add(actiontarget,0,0);
    actiontarget.setText("OOPS!");
    TheBr obj= new TheBr();
    obj.Wrong(marks);
    System.out.println("Q1 marks = "+ marks);
    
 if(btnPressed==1)
            {
                try {       
                PauseTransition wait=new PauseTransition(Duration.seconds(1));
                wait.setOnFinished((e)->{
                System.out.println("btn pressed in timeline 1 = "+ btnPressed);
                System.out.println("Q1 marks = "+ marks);  
                obj.Emq3(primaryStage, marks);
                });
                wait.play();
                }
                catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
                autoSlide.stop();
           }
    }
    
    }
    });


                 //Admin control
 GridPane gridadmin = new GridPane();
 gridadmin.setAlignment(Pos.CENTER);
 gridadmin.setHgap(10);
 gridadmin.setVgap(10);
 gridadmin.setPadding(new Insets(0,0,0,0));
 gridadmin.setLayoutX(275);
 gridadmin.setLayoutY(550);
 TheBr obj = new TheBr();
if(admin==1)
{  
 autoSlide.stop();   
 Button prevbtn =new Button("", new ImageView("/thebr/AdminControl/previous.png"));
 gridadmin.add(prevbtn,0,0);
    prevbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Emq1(primaryStage,marks);
    }
    });

 Button relbtn =new Button("", new ImageView("/thebr/AdminControl/reload.png"));
 gridadmin.add(relbtn,1,0);
    relbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Emq2(primaryStage,marks);
    }
    });
 
 Button nextbtn = new Button("", new ImageView("/thebr/AdminControl/next.png"));
 gridadmin.add(nextbtn,2,0);
     nextbtn.setOnAction(new EventHandler<ActionEvent>() {
     public void handle(ActionEvent ae){
     obj.Emq3(primaryStage,marks);
     }
     });
     
 Button levelbtn =new Button("", new ImageView("/thebr/AdminControl/level.png"));
 gridadmin.add(levelbtn,3,0);
    levelbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Page2(primaryStage,marks);
    }
    });
}
 //Admin Control Ends
 
  //Adding Score View
        Text scrLbl = new Text("Score: ");
        scrLbl.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        scrLbl.setFill( Color.web("BLACK", 0.50) );
        scrLbl.setX(5);
        scrLbl.setY(595);
        
        String myscore= Double.toString(mrk);
        Text scrView= new Text();
        scrView.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
        scrView.setFill( Color.web("WHITE", 0.50) );
        scrView.setText(myscore);
        scrView.setX(63);
        scrView.setY(595);

//Adding close button
Button btnclose = new Button("",new ImageView("/thebr/AdminControl/close.png"));
btnclose.setId("btnclose");
btnclose.setTranslateX(750);
btnclose.setTranslateY(550);
    btnclose.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
        TheBr obj = new TheBr();
        obj.Marks(primaryStage,marks);
        voice.stop();
        autoSlide.stop();
    }
    });

Image imgb = new Image("/thebr/background.jpg");
ImageView imgb1 = new ImageView(imgb);
root.getChildren().addAll(imgb1,linesW,linesO,linesR,grid1,gridadmin,btnclose,scrLbl,scrView);

Scene scene = new Scene(root, 800, 600, Color.GRAY);
primaryStage.setScene(scene);
primaryStage.setResizable(false);
scene.getStylesheets().add(TheBr.class.getResource("imgb.css").toExternalForm());			
primaryStage.getIcons().add(new Image("/thebr/TheBrainifyApp.jpg"));
primaryStage.show();

}

//Easy Mode Q3:
public void Emq3(Stage primaryStage, double marks)
{
System.out.println("Reached EMq3");
    
Group root = new Group();
FlowPane rootNode= new FlowPane();
primaryStage.setTitle("The Brainify App- Easy Mode:"); 

    //Virtual Assistant
     MediaPlayer voice = new MediaPlayer(new Media(TheBr.class.getResource("virtualAssistant/emq3.mp3").toString())); 
     voice.play();

//Timer Line       
        Group linesW = new Group();
        for(int i=0;i<1;i++)
        {
        Line whiteLine = new Line(0, 0, 780, 0);
        whiteLine.setStroke(Color.web("#4EFF00", 0.5));
        whiteLine.setStrokeWidth(40);
        whiteLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesW.getChildren().add(whiteLine);
        }
      
        Group linesO = new Group();
        for(int i=0;i<1;i++)
        {
        Line orangeLine = new Line(0, 0, 780, 0);
        orangeLine.setStroke(Color.web("#FF9900", 1.0));
        orangeLine.setStrokeWidth(40);
        orangeLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesO.getChildren().add(orangeLine);
        }
            
        Group linesR = new Group();
        for(int i=0;i<1;i++)
        {
        Line redLine = new Line(0, 0, 780, 0);
        redLine.setStroke(Color.web("#FF0000", 1.0));
        redLine.setStrokeWidth(40);
        redLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesR.getChildren().add(redLine);
        }
 
        
        Timeline timeline = new Timeline();
        for (Node whiteLine: linesW.getChildren()) 
        {
        timeline.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(whiteLine.translateXProperty(), -800),
        new KeyValue(whiteLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(18040), 
        new KeyValue(whiteLine.translateXProperty(), -320),
        new KeyValue(whiteLine.translateYProperty(), 0)
                )
                );
        }
        timeline.play();

        Timeline timeline1 = new Timeline();
        for (Node orangeLine: linesO.getChildren())
        {
        timeline1.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(18040), 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),        
        new KeyFrame(new Duration(18040), 
        new KeyValue(orangeLine.translateXProperty(), -320),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ), 
        
        new KeyFrame(new Duration(25550), 
        new KeyValue(orangeLine.translateXProperty(), -120),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    )
                    );
        }
        timeline1.play();

        Timeline timeline2 = new Timeline();
        for (Node redLine: linesR.getChildren())
        {
        timeline2.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(redLine.translateXProperty(), -800),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(25550),
        new KeyValue(redLine.translateXProperty(), -800),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),   
        new KeyFrame(new Duration(25550), 
        new KeyValue(redLine.translateXProperty(), -120),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),       
 
        new KeyFrame(new Duration(30000),
        new KeyValue(redLine.translateXProperty(), 0),
        new KeyValue(redLine.translateYProperty(), 0)
                    )
                    );
        }
        timeline2.play();  
        
        //Timer Lines END


GridPane grid1=new GridPane();
 grid1.setAlignment(Pos.CENTER);
 grid1.setHgap(10);
 grid1.setVgap(10);
 grid1.setPadding(new Insets(100,25,25,125));
 Text queE3=new Text("Q3. Which one is Motorola's Camera icon?");
 queE3.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
 grid1.add(queE3, 0,0);

GridPane grid2= new GridPane();
grid2.setAlignment(Pos.CENTER);
 grid2.setHgap(10);
 grid2.setVgap(10);
 grid2.setPadding(new Insets(5,5,5,5));

 
 Image cam1 = new Image("/thebr/Brainify/cam1.png");
 Image cam2 = new Image("/thebr/Brainify/cam2.png");
 
 
 grid1.add(grid2,0,1);
 TheBr obj= new TheBr();
 
 final Text actiontarget = new Text();
 actiontarget.setId("actiontarget");
 HBox act = new HBox(10);
 act.setAlignment(Pos.CENTER);
 act.getChildren().add(actiontarget);
 
 final Text actiontargetR = new Text();
 actiontargetR.setId("actiontargetR");
 act.getChildren().add(actiontargetR);
 
 grid1.add(act,0,5);
 
 ToggleButton playbtn0;
 playbtn0 = new ToggleButton("Hit Me!"); 
 HBox hbBtn0 = new HBox(10);
hbBtn0.setAlignment(Pos.CENTER);
hbBtn0.getChildren().add(playbtn0);
grid1.add(hbBtn0,0,2);

GridPane grid3= new GridPane();
grid3.setAlignment(Pos.CENTER);
grid3.setHgap(0);
grid3.setVgap(0);
grid3.setPadding(new Insets(0,0,0,0));
grid1.add(grid3,0,3);

  //Timer start, will to skip if no button pressed
            System.out.println("btn pressed before timeline = "+ btnPressed);
            Timeline autoSlide = new Timeline(new KeyFrame(
            Duration.millis(30000),
            ae-> 
            { 
                if(btnPressed==0)
                {//Time out
                System.out.println("marks time out = "+ marks);
                System.out.println("btn pressed in timeline 0 = "+ btnPressed);
                obj.Emq4(primaryStage, marks);
                }
            }     
            ));
            autoSlide.play();      
//End of auto Timer

 playbtn0.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
        if(playbtn0.isSelected()) 
        {
        ImageView cam11 = new ImageView(cam1);
        grid2.add(cam11,0,0);
        }
        else
        {
                ImageView cam12=   new ImageView(cam2);
                grid2.add(cam12,0,0);
                ToggleButton playbtn;
                Label response;
                response=new Label("");
                playbtn = new ToggleButton("Hit Me!");
                HBox hbBtn = new HBox(10);
                hbBtn.setAlignment(Pos.CENTER);
                hbBtn.getChildren().add(playbtn);
                grid1.add(hbBtn,0,2);
                
                playbtn.setOnAction(new EventHandler<ActionEvent>() {
                 public void handle(ActionEvent ae){
        if(playbtn.isSelected()) 
        {
        ImageView cam11 = new ImageView(cam1);
        grid2.add(cam11,0,0);
        Button btncam1=new Button(" Yes! This One "); 
        btncam1.setId("eq3btn");
        grid3.add(btncam1,0,0);
           btncam1.setOnAction(new EventHandler<ActionEvent>() {
           public void handle(ActionEvent ae){
           System.out.println("This is cam1");
           actiontarget.setText("OOPS!");
           btnPressed=1;
           obj.Wrong(marks);
           if(btnPressed==1)
            {
                try {       
                PauseTransition wait=new PauseTransition(Duration.seconds(1));
                wait.setOnFinished((e)->{
                System.out.println("btn pressed in timeline 1 = "+ btnPressed);
                System.out.println("Q1 marks = "+ marks);  
                obj.Emq4(primaryStage, marks);
                });
                wait.play();
                }
                catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
                autoSlide.stop();
           }      
           }
        });
        }
         else
        {   
        ImageView cam12=   new ImageView(cam2);
        grid2.add(cam12,0,0);
        Button btncam2=new Button("  No!  This One ");
        btncam2.setId("eq3btn");
        grid3.add(btncam2,0,0);
                 btncam2.setOnAction(new EventHandler<ActionEvent>() {
                 public void handle(ActionEvent ae){
                 System.out.println("This is cam2");
                 actiontargetR.setText("RIGHT!");
                 obj.Right(marks);
                 btnPressed=1;
                if(btnPressed==1)
            {
                try {       
                PauseTransition wait=new PauseTransition(Duration.seconds(1));
                wait.setOnFinished((e)->{
                System.out.println("btn pressed in timeline 1 = "+ btnPressed);
                System.out.println("marks = "+ marks);  
                obj.Emq4(primaryStage, marks);
                autoSlide.stop();
                });
                wait.play();
                }
                catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
                
           }
           }
        });
        }
    }
 });
            
        }
    }
  });
 
  //Admin control
 GridPane gridadmin = new GridPane();
 gridadmin.setAlignment(Pos.CENTER);
 gridadmin.setHgap(10);
 gridadmin.setVgap(10);
 gridadmin.setPadding(new Insets(0,0,0,0));
 gridadmin.setLayoutX(275);
 gridadmin.setLayoutY(550);
if(admin==1)
{  
 autoSlide.stop();   
 Button prevbtn =new Button("", new ImageView("/thebr/AdminControl/previous.png"));
 gridadmin.add(prevbtn,0,0);
    prevbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Emq2(primaryStage,marks);
    }
    });

 Button relbtn =new Button("", new ImageView("/thebr/AdminControl/reload.png"));
 gridadmin.add(relbtn,1,0);
    relbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Emq3(primaryStage,marks);
    }
    });
 
 Button nextbtn = new Button("", new ImageView("/thebr/AdminControl/next.png"));
 gridadmin.add(nextbtn,2,0);
     nextbtn.setOnAction(new EventHandler<ActionEvent>() {
     public void handle(ActionEvent ae){
     obj.Emq4(primaryStage,marks);
     }
     });
     
 Button levelbtn =new Button("", new ImageView("/thebr/AdminControl/level.png"));
 gridadmin.add(levelbtn,3,0);
    levelbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Page2(primaryStage,marks);
    }
    });
}
 //Admin Control Ends
 
   //Adding Score View
        Text scrLbl = new Text("Score: ");
        scrLbl.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        scrLbl.setFill( Color.web("BLACK", 0.50) );
        scrLbl.setX(5);
        scrLbl.setY(595);
        
        String myscore= Double.toString(mrk);
        Text scrView= new Text();
        scrView.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
        scrView.setFill( Color.web("WHITE", 0.50) );
        scrView.setText(myscore);
        scrView.setX(63);
        scrView.setY(595);

//Adding close button
Button btnclose = new Button("",new ImageView("/thebr/AdminControl/close.png"));
btnclose.setId("btnclose");
btnclose.setTranslateX(750);
btnclose.setTranslateY(550);
    btnclose.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
        TheBr obj = new TheBr();
        obj.Marks(primaryStage,marks);
        voice.stop();
        autoSlide.stop();
    }
    });
 
Image imgb = new Image("/thebr/background.jpg");
ImageView imgb1 = new ImageView(imgb);
root.getChildren().addAll(imgb1,linesW,linesO,linesR,grid1,gridadmin,btnclose,scrLbl,scrView);         
Scene scene = new Scene(root, 800, 600, Color.GRAY);
primaryStage.setScene(scene);
primaryStage.setResizable(false);
scene.getStylesheets().add(TheBr.class.getResource("imgb.css").toExternalForm());			
primaryStage.getIcons().add(new Image("/thebr/TheBrainifyApp.jpg"));
primaryStage.show();
    
}

//Easy Mode Q4
public void Emq4(Stage primaryStage, double marks)
{
System.out.println("Reached EMq4");
    
Group root = new Group();
FlowPane rootNode= new FlowPane();
primaryStage.setTitle("The Brainify App- Easy Mode:"); 

    //Virtual Assistant
     MediaPlayer voice = new MediaPlayer(new Media(TheBr.class.getResource("virtualAssistant/emq4.mp3").toString())); 
     voice.play();

//Timer Line       
        Group linesW = new Group();
        for(int i=0;i<1;i++)
        {
        Line whiteLine = new Line(0, 0, 780, 0);
        whiteLine.setStroke(Color.web("#4EFF00", 0.5));
        whiteLine.setStrokeWidth(40);
        whiteLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesW.getChildren().add(whiteLine);
        }
      
        Group linesO = new Group();
        for(int i=0;i<1;i++)
        {
        Line orangeLine = new Line(0, 0, 780, 0);
        orangeLine.setStroke(Color.web("#FF9900", 1.0));
        orangeLine.setStrokeWidth(40);
        orangeLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesO.getChildren().add(orangeLine);
        }
            
        Group linesR = new Group();
        for(int i=0;i<1;i++)
        {
        Line redLine = new Line(0, 0, 780, 0);
        redLine.setStroke(Color.web("#FF0000", 1.0));
        redLine.setStrokeWidth(40);
        redLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesR.getChildren().add(redLine);
        }
 
        
        Timeline timeline = new Timeline();
        for (Node whiteLine: linesW.getChildren()) 
        {
        timeline.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(whiteLine.translateXProperty(), -800),
        new KeyValue(whiteLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(18040), 
        new KeyValue(whiteLine.translateXProperty(), -320),
        new KeyValue(whiteLine.translateYProperty(), 0)
                )
                );
        }
        timeline.play();

        Timeline timeline1 = new Timeline();
        for (Node orangeLine: linesO.getChildren())
        {
        timeline1.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(18040), 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),        
        new KeyFrame(new Duration(18040), 
        new KeyValue(orangeLine.translateXProperty(), -320),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ), 
        
        new KeyFrame(new Duration(25550), 
        new KeyValue(orangeLine.translateXProperty(), -120),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    )
                    );
        }
        timeline1.play();

        Timeline timeline2 = new Timeline();
        for (Node redLine: linesR.getChildren())
        {
        timeline2.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(redLine.translateXProperty(), -800),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(25550),
        new KeyValue(redLine.translateXProperty(), -800),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),   
        new KeyFrame(new Duration(25550), 
        new KeyValue(redLine.translateXProperty(), -120),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),       
 
        new KeyFrame(new Duration(30000),
        new KeyValue(redLine.translateXProperty(), 0),
        new KeyValue(redLine.translateYProperty(), 0)
                    )
                    );
        }
        timeline2.play();  
        
        //Timer Lines END		   


GridPane grid1=new GridPane();
 grid1.setAlignment(Pos.CENTER);
 grid1.setHgap(10);
 grid1.setVgap(10);
 grid1.setPadding(new Insets(25,25,25,175));
 
  Text queE4=new Text("\nQ4. Who is the fastest man alive?");
 queE4.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
 ToggleButton revealbtn;
 revealbtn = new ToggleButton("REVEAL");
 HBox hbtBtn = new HBox(10);
hbtBtn.setAlignment(Pos.CENTER);
hbtBtn.getChildren().add(revealbtn);
 grid1.add(queE4,0,0);
 grid1.add(hbtBtn,0,1);
 

  //Timer start, will to skip if no button pressed
            System.out.println("btn pressed before timeline = "+ btnPressed);
            Timeline autoSlide = new Timeline(new KeyFrame(
            Duration.millis(30000),
            ae-> 
            { 
                if(btnPressed==0)
                {//Time out
                System.out.println("marks skipped = "+ marks);
                TheBr obj = new TheBr();
                obj.Emq5(primaryStage, marks);
                }
            }     
            ));
            autoSlide.play();      
//End of auto Timer
 

 revealbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
        if(revealbtn.isSelected()) 
        {
         HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.CENTER);
        Button btn= new Button("       ",new ImageView("/thebr/Brainify/eq4img.gif"));
        hbBtn.getChildren().add(btn);
        grid1.add(btn,0,1);
        
         //Menu view
         
        GridPane grid2=new GridPane();
        grid2.setAlignment(Pos.CENTER);
        grid2.setHgap(10);
        grid2.setVgap(10);
        grid2.setPadding(new Insets(1,1,1,1)); 
       
        
        ComboBox<String> cbFastest;
        ObservableList<String> fastestTypes =FXCollections.observableArrayList("Superman","Batman","The Flash","Bruce Lee","Mohammad Ali","Usain Bolt" );
        cbFastest = new ComboBox<String>(fastestTypes);
        cbFastest.setValue("I'm the fastest man alive & I am");
        grid2.add(cbFastest,0,0);
        grid1.add(grid2,0,2);
        
        final Text actiontargetR = new Text();
        actiontargetR.setId("actiontargetR");
        grid2.add(actiontargetR,0,1);
        
        final Text actiontarget = new Text();
        actiontarget.setId("actiontarget");
        grid2.add(actiontarget,0,1);
        TheBr obj = new TheBr();
        
        
        cbFastest.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent ae) {
            String ans="Usain Bolt";
            if(ans.equals((cbFastest.getValue())))
            {
                System.out.println("Usain Bolt");
                actiontargetR.setText("RIGHT!");
                obj.Right(marks);
             btnPressed=1;	
if(btnPressed==1)
            {
                try {       
                PauseTransition wait=new PauseTransition(Duration.seconds(1));
                wait.setOnFinished((e)->{  
                obj.Emq5(primaryStage, marks);
                autoSlide.stop();
                });
                wait.play();
                }
                catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
                
           }
  
                
               
            }
            else
            {
               System.out.println("Not Bolt"); 
               actiontarget.setText("OOPS!");
               wrongPlayer.play();
               obj.Wrong(marks);
               btnPressed=1;	
if(btnPressed==1)
            {
                try {       
                PauseTransition wait=new PauseTransition(Duration.seconds(1));
                wait.setOnFinished((e)->{  
                obj.Emq5(primaryStage, marks);
                autoSlide.stop();
                });
                wait.play();
                }
                catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
               
           }

              
            }
                
            
}
});
        
        }
        else
        {
            System.out.println("Reveal button not selected");
                }
    }
    });

  //Admin control
 GridPane gridadmin = new GridPane();
 gridadmin.setAlignment(Pos.CENTER);
 gridadmin.setHgap(10);
 gridadmin.setVgap(10);
 gridadmin.setPadding(new Insets(0,0,0,0));
 gridadmin.setLayoutX(275);
 gridadmin.setLayoutY(550);
 TheBr obj = new TheBr();
if(admin==1)
{  
 autoSlide.stop();   
 Button prevbtn =new Button("", new ImageView("/thebr/AdminControl/previous.png"));
 gridadmin.add(prevbtn,0,0);
    prevbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Emq3(primaryStage,marks);
    }
    });

 Button relbtn =new Button("", new ImageView("/thebr/AdminControl/reload.png"));
 gridadmin.add(relbtn,1,0);
    relbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Emq4(primaryStage,marks);
    }
    });
 
 Button nextbtn = new Button("", new ImageView("/thebr/AdminControl/next.png"));
 gridadmin.add(nextbtn,2,0);
     nextbtn.setOnAction(new EventHandler<ActionEvent>() {
     public void handle(ActionEvent ae){
     obj.Emq5(primaryStage,marks);
     }
     });
     
 Button levelbtn =new Button("", new ImageView("/thebr/AdminControl/level.png"));
 gridadmin.add(levelbtn,3,0);
    levelbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Page2(primaryStage,marks);
    }
    });
}
 //Admin Control Ends
 
    //Adding Score View
        Text scrLbl = new Text("Score: ");
        scrLbl.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        scrLbl.setFill( Color.web("BLACK", 0.50) );
        scrLbl.setX(5);
        scrLbl.setY(595);
        
        String myscore= Double.toString(mrk);
        Text scrView= new Text();
        scrView.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
        scrView.setFill( Color.web("WHITE", 0.50) );
        scrView.setText(myscore);
        scrView.setX(63);
        scrView.setY(595);

//Adding close button
Button btnclose = new Button("",new ImageView("/thebr/AdminControl/close.png"));
btnclose.setId("btnclose");
btnclose.setTranslateX(750);
btnclose.setTranslateY(550);
    btnclose.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
        TheBr obj = new TheBr();
        obj.Marks(primaryStage,marks);
        voice.stop();
        autoSlide.stop();
    }
    });

 
Image imgb = new Image("/thebr/background.jpg");
ImageView imgb1 = new ImageView(imgb);
root.getChildren().addAll(imgb1,linesW,linesO,linesR,grid1,gridadmin,btnclose,scrLbl,scrView);    
Scene scene = new Scene(root, 800, 600, Color.GRAY);
primaryStage.setScene(scene);
primaryStage.setResizable(false);
scene.getStylesheets().add(TheBr.class.getResource("imgb.css").toExternalForm());			
primaryStage.getIcons().add(new Image("/thebr/TheBrainifyApp.jpg"));
primaryStage.show();

}


//Easy Mode Q5
public void Emq5(Stage primaryStage, double marks)
{
System.out.println("Reached EMq5");
    
Group root = new Group();
FlowPane rootNode= new FlowPane();
primaryStage.setTitle("The Brainify App- Easy Mode:"); 

    //Virtual Assistant
     MediaPlayer voice = new MediaPlayer(new Media(TheBr.class.getResource("virtualAssistant/emq5.mp3").toString())); 
     voice.play();

//Timer Line       
        Group linesW = new Group();
        for(int i=0;i<1;i++)
        {
        Line whiteLine = new Line(0, 0, 780, 0);
        whiteLine.setStroke(Color.web("#4EFF00", 0.5));
        whiteLine.setStrokeWidth(40);
        whiteLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesW.getChildren().add(whiteLine);
        }
      
        Group linesO = new Group();
        for(int i=0;i<1;i++)
        {
        Line orangeLine = new Line(0, 0, 780, 0);
        orangeLine.setStroke(Color.web("#FF9900", 1.0));
        orangeLine.setStrokeWidth(40);
        orangeLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesO.getChildren().add(orangeLine);
        }
            
        Group linesR = new Group();
        for(int i=0;i<1;i++)
        {
        Line redLine = new Line(0, 0, 780, 0);
        redLine.setStroke(Color.web("#FF0000", 1.0));
        redLine.setStrokeWidth(40);
        redLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesR.getChildren().add(redLine);
        }
 
        
        Timeline timeline = new Timeline();
        for (Node whiteLine: linesW.getChildren()) 
        {
        timeline.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(whiteLine.translateXProperty(), -800),
        new KeyValue(whiteLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(18040), 
        new KeyValue(whiteLine.translateXProperty(), -320),
        new KeyValue(whiteLine.translateYProperty(), 0)
                )
                );
        }
        timeline.play();

        Timeline timeline1 = new Timeline();
        for (Node orangeLine: linesO.getChildren())
        {
        timeline1.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(18040), 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),        
        new KeyFrame(new Duration(18040), 
        new KeyValue(orangeLine.translateXProperty(), -320),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ), 
        
        new KeyFrame(new Duration(25550), 
        new KeyValue(orangeLine.translateXProperty(), -120),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    )
                    );
        }
        timeline1.play();

        Timeline timeline2 = new Timeline();
        for (Node redLine: linesR.getChildren())
        {
        timeline2.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(redLine.translateXProperty(), -800),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(25550),
        new KeyValue(redLine.translateXProperty(), -800),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),   
        new KeyFrame(new Duration(25550), 
        new KeyValue(redLine.translateXProperty(), -120),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),       
 
        new KeyFrame(new Duration(30000),
        new KeyValue(redLine.translateXProperty(), 0),
        new KeyValue(redLine.translateYProperty(), 0)
                    )
                    );
        }
        timeline2.play();  
        
        //Timer Lines END		   


GridPane grid1=new GridPane();
 grid1.setAlignment(Pos.CENTER);
 grid1.setHgap(10);
 grid1.setVgap(10);
 grid1.setPadding(new Insets(100,25,25,100));
 Text queE5=new Text("Q5. Are they the mirror images of each other?");
 queE5.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
 grid1.add(queE5, 0,0);
 
 GridPane grid2=new GridPane();
 grid2.setAlignment(Pos.CENTER);
 grid2.setHgap(10);
 grid2.setVgap(10);
 grid2.setPadding(new Insets(25,25,25,25));
 //orginal
 Image fit = new Image("/thebr/Brainify/Fit.png");
 ImageView fitV= new ImageView(fit);
 Image fitF= new Image("/thebr/Brainify/Fit.png");
 ImageView fitFV= new ImageView(fitF);
 grid2.add(fitV, 0,0);
 grid2.add(fitFV,2,0);
 
 //ocerlap 1
 Image fito1 = new Image("/thebr/Brainify/Fit.png");
 ImageView fito1_1= new ImageView(fito1);
 Image fitFo1= new Image("/thebr/Brainify/FitF.png");
 ImageView fitFo1_1= new ImageView(fitFo1);
 
 //Overlap 2
 Image fito2 = new Image("/thebr/Brainify/Fit.png");
 ImageView fitVo_2= new ImageView(fito2);
 Image fitFo2= new Image("/thebr/Brainify/FitF.png");
 ImageView fitFVo_2= new ImageView(fitFo2);
 
 
 ToggleButton FlipIt=new ToggleButton("FLIP");
 grid2.add(FlipIt,1,0);
 grid1.add(grid2,0,1);

 
 GridPane grid3=new GridPane();
 grid3.setAlignment(Pos.CENTER);
 grid3.setHgap(10);
 grid3.setVgap(10);
 grid3.setPadding(new Insets(5,5,5,5));
RadioButton rbYes = new RadioButton("Yes");
RadioButton rbNo = new RadioButton("No");
ToggleGroup tg = new ToggleGroup();
rbYes.setToggleGroup(tg);
rbNo.setToggleGroup(tg);
grid3.add(rbYes,0,0);
grid3.add(rbNo,1,0);
grid1.add(grid3,0,2);

GridPane grid4= new GridPane();
grid4.setAlignment(Pos.CENTER);
grid4.setHgap(10);
grid4.setVgap(10);
grid4.setPadding(new Insets(5,5,5,5));
final Text actiontargetR= new Text();
actiontargetR.setId("actiontargetR");

final Text actiontarget= new Text();
actiontarget.setId("actiontarget");

grid4.add(actiontargetR,0,0);
grid4.add(actiontarget,0,0);
grid1.add(grid4,0,3);
FlipIt.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
      try
      {if(FlipIt.isSelected()) 
        {
         grid2.add(fito1_1, 2,0);
         grid2.add(fitFo1_1,0,0);
           
        }
        else
        {
         grid2.add(fitVo_2, 0,0);
         grid2.add(fitFVo_2,2,0);
          
           }
      }
    catch(Exception e){
		System.out.println("Error...Pressed Q5 Flip Button more than 2 times.");
        }   
    }
    
});

  //Timer start, will to skip if no button pressed
            System.out.println("btn pressed before timeline = "+ btnPressed);
            Timeline autoSlide = new Timeline(new KeyFrame(
            Duration.millis(30000),
            ae-> 
            { 
                if(btnPressed==0)
                {//Time out
                System.out.println("marks skipped = "+ marks);
                TheBr obj = new TheBr();
                obj.Emq6(primaryStage, marks);
                }
            }     
            ));
            autoSlide.play();      
//End of auto Timer

TheBr obj = new TheBr();
rbYes.setOnAction(new EventHandler<ActionEvent>() {
public void handle(ActionEvent ae) {
    System.out.println("Hello");
    actiontargetR.setText("RIGHT!");
    obj.Right(marks);
    btnPressed=1;	
if(btnPressed==1)
            {
                try {       
                PauseTransition wait=new PauseTransition(Duration.seconds(1));
                wait.setOnFinished((e)->{  
                obj.Emq6(primaryStage, marks);
                autoSlide.stop();
                });
                wait.play();
                }
                catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
            }
    
}
});

rbNo.setOnAction(new EventHandler<ActionEvent>() {
public void handle(ActionEvent ae) {
    System.out.println("Hi");
    actiontarget.setText("OOPS!");
    wrongPlayer.play();
    obj.Wrong(marks);
  btnPressed=1;	
if(btnPressed==1)
            {
                try {       
                PauseTransition wait=new PauseTransition(Duration.seconds(1));
                wait.setOnFinished((e)->{  
                obj.Emq6(primaryStage, marks);
                autoSlide.stop();
                });
                wait.play();
                }
                catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
                
           }

}
});


 //Admin control
 GridPane gridadmin = new GridPane();
 gridadmin.setAlignment(Pos.CENTER);
 gridadmin.setHgap(10);
 gridadmin.setVgap(10);
 gridadmin.setPadding(new Insets(0,0,0,0));
 gridadmin.setLayoutX(275);
 gridadmin.setLayoutY(550);
if(admin==1)
{  
 autoSlide.stop();   
 Button prevbtn =new Button("", new ImageView("/thebr/AdminControl/previous.png"));
 gridadmin.add(prevbtn,0,0);
    prevbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Emq4(primaryStage,marks);
    }
    });

 Button relbtn =new Button("", new ImageView("/thebr/AdminControl/reload.png"));
 gridadmin.add(relbtn,1,0);
    relbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Emq5(primaryStage,marks);
    }
    });
 
 Button nextbtn = new Button("", new ImageView("/thebr/AdminControl/next.png"));
 gridadmin.add(nextbtn,2,0);
     nextbtn.setOnAction(new EventHandler<ActionEvent>() {
     public void handle(ActionEvent ae){
     obj.Emq6(primaryStage,marks);
     }
     });
     
 Button levelbtn =new Button("", new ImageView("/thebr/AdminControl/level.png"));
 gridadmin.add(levelbtn,3,0);
    levelbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Page2(primaryStage,marks);
    }
    });
}
 //Admin Control Ends

    //Adding Score View
        Text scrLbl = new Text("Score: ");
        scrLbl.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        scrLbl.setFill( Color.web("BLACK", 0.50) );
        scrLbl.setX(5);
        scrLbl.setY(595);
        
        String myscore= Double.toString(mrk);
        Text scrView= new Text();
        scrView.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
        scrView.setFill( Color.web("WHITE", 0.50) );
        scrView.setText(myscore);
        scrView.setX(63);
        scrView.setY(595);

//Adding close button
Button btnclose = new Button("",new ImageView("/thebr/AdminControl/close.png"));
btnclose.setId("btnclose");
btnclose.setTranslateX(750);
btnclose.setTranslateY(550);
    btnclose.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
        TheBr obj = new TheBr();
        obj.Marks(primaryStage,marks);
        voice.stop();
        autoSlide.stop();
    }
    });
 
Image imgb = new Image("/thebr/background.jpg");
ImageView imgb1 = new ImageView(imgb);
root.getChildren().addAll(imgb1,linesW,linesO,linesR,grid1,gridadmin,btnclose,scrLbl,scrView);
Scene scene = new Scene(root, 800, 600, Color.GRAY);
primaryStage.setScene(scene);
primaryStage.setResizable(false);
scene.getStylesheets().add(TheBr.class.getResource("imgb.css").toExternalForm());			
primaryStage.getIcons().add(new Image("/thebr/TheBrainifyApp.jpg"));
primaryStage.show();

}


//Easy Mode Q6
public void Emq6(Stage primaryStage, double marks)
{
System.out.println("Reached EMq5");
    
Group root = new Group();
FlowPane rootNode= new FlowPane();
primaryStage.setTitle("The Brainify App- Easy Mode:"); 

    //Virtual Assistant
     MediaPlayer voice = new MediaPlayer(new Media(TheBr.class.getResource("virtualAssistant/emq6.mp3").toString())); 
     voice.play();

//Timer Line       
        Group linesW = new Group();
        for(int i=0;i<1;i++)
        {
        Line whiteLine = new Line(0, 0, 780, 0);
        whiteLine.setStroke(Color.web("#4EFF00", 0.5));
        whiteLine.setStrokeWidth(40);
        whiteLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesW.getChildren().add(whiteLine);
        }
      
        Group linesO = new Group();
        for(int i=0;i<1;i++)
        {
        Line orangeLine = new Line(0, 0, 780, 0);
        orangeLine.setStroke(Color.web("#FF9900", 1.0));
        orangeLine.setStrokeWidth(40);
        orangeLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesO.getChildren().add(orangeLine);
        }
            
        Group linesR = new Group();
        for(int i=0;i<1;i++)
        {
        Line redLine = new Line(0, 0, 780, 0);
        redLine.setStroke(Color.web("#FF0000", 1.0));
        redLine.setStrokeWidth(40);
        redLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesR.getChildren().add(redLine);
        }
 
        
        Timeline timeline = new Timeline();
        for (Node whiteLine: linesW.getChildren()) 
        {
        timeline.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(whiteLine.translateXProperty(), -800),
        new KeyValue(whiteLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(18040), 
        new KeyValue(whiteLine.translateXProperty(), -320),
        new KeyValue(whiteLine.translateYProperty(), 0)
                )
                );
        }
        timeline.play();

        Timeline timeline1 = new Timeline();
        for (Node orangeLine: linesO.getChildren())
        {
        timeline1.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(18040), 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),        
        new KeyFrame(new Duration(18040), 
        new KeyValue(orangeLine.translateXProperty(), -320),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ), 
        
        new KeyFrame(new Duration(25550), 
        new KeyValue(orangeLine.translateXProperty(), -120),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    )
                    );
        }
        timeline1.play();

        Timeline timeline2 = new Timeline();
        for (Node redLine: linesR.getChildren())
        {
        timeline2.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(redLine.translateXProperty(), -800),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(25550),
        new KeyValue(redLine.translateXProperty(), -800),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),   
        new KeyFrame(new Duration(25550), 
        new KeyValue(redLine.translateXProperty(), -120),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),       
 
        new KeyFrame(new Duration(30000),
        new KeyValue(redLine.translateXProperty(), 0),
        new KeyValue(redLine.translateYProperty(), 0)
                    )
                    );
        }
        timeline2.play();  
        
        //Timer Lines END		   


GridPane grid1=new GridPane();
 grid1.setAlignment(Pos.CENTER);
 grid1.setHgap(10);
 grid1.setVgap(10);
 grid1.setPadding(new Insets(100,125,25,175));
 Text queE6=new Text("Q6.    How many dots do you see?\n\t (ignore the yellow one's)\n");
 queE6.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
 grid1.add(queE6, 0,0,2,1);
 Button btn= new Button("",new ImageView("/thebr/Brainify/emq6.gif"));
 HBox hbtBtn = new HBox();
 hbtBtn.setAlignment(Pos.CENTER);
 hbtBtn.getChildren().add(btn);
 grid1.add(hbtBtn,0,1);
 grid1.add(btn,0,1);
 GridPane grid2= new GridPane();
 grid2.setAlignment(Pos.CENTER);
 grid2.setHgap(10);
 grid2.setVgap(10);
 grid2.setPadding(new Insets(25,25,25,25));

 
Label eq6= new Label("How many:");
eq6.setFont(new Font("Candara Bold",20));
grid2.add(eq6,0,0);

ComboBox<String> cbFastest;
        ObservableList<String> fastestTypes =FXCollections.observableArrayList("5","6","7","8","9","10","11","12","13","14","15");
        cbFastest = new ComboBox<String>(fastestTypes);
        cbFastest.setValue("Select");
        grid2.add(cbFastest,0,1);

        Button btn1= new Button("Confirm");
        btn.setAlignment(Pos.BOTTOM_RIGHT);
        grid2.add(btn1,0,2);
        grid1.add(grid2,1,1);

        
        

        final Text actiontargetR = new Text();
        actiontargetR.setId("actiontargetR");
        grid1.add(actiontargetR,0,2,2,1);
        
        final Text actiontarget = new Text();
        actiontarget.setId("actiontarget");
        grid1.add(actiontarget,0,2,2,1);
        TheBr obj = new TheBr();
        
        HBox hb= new HBox();
        hb.setAlignment(Pos.CENTER);
        hb.getChildren().add(actiontargetR);
        hb.getChildren().add(actiontarget);
        grid1.add(hb,0,2,2,1);
        
          //Timer start, will to skip if no button pressed
            System.out.println("btn pressed before timeline = "+ btnPressed);
            Timeline autoSlide = new Timeline(new KeyFrame(
            Duration.millis(30000),
            ae-> 
            { 
                if(btnPressed==0)
                {//Time out
                System.out.println("marks skipped = "+ marks);
                obj.Emq7(primaryStage, marks);
                }
            }     
            ));
            autoSlide.play();      
//End of auto Timer
        
        btn1.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent ae) {
            String ans="10";
            if(ans.equals((cbFastest.getValue())))
            {
                System.out.println("10 is right");
                actiontargetR.setText("RIGHT!");
                obj.Right(marks);
            btnPressed=1;	
if(btnPressed==1)
            {
				autoSlide.stop();
                try {       
                PauseTransition wait=new PauseTransition(Duration.seconds(1));
                wait.setOnFinished((e)->{  
                obj.Emq7(primaryStage, marks);
				});
                wait.play();
                }
                catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
            }

                
               
            }
            else
            {
               System.out.println("Not 10"); 
               actiontarget.setText("OOPS!");
               obj.Wrong(marks);
btnPressed=1;	
if(btnPressed==1)
            {
				autoSlide.stop();
                try {       
                PauseTransition wait=new PauseTransition(Duration.seconds(1));
                wait.setOnFinished((e)->{  
                obj.Emq7(primaryStage, marks);
				});
                wait.play();
                }
                catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
            }

              
            }
                
            
}
});
        
         //Admin control
 GridPane gridadmin = new GridPane();
 gridadmin.setAlignment(Pos.CENTER);
 gridadmin.setHgap(10);
 gridadmin.setVgap(10);
 gridadmin.setPadding(new Insets(0,0,0,0));
 gridadmin.setLayoutX(275);
 gridadmin.setLayoutY(550);
if(admin==1)
{  
 autoSlide.stop();   
 Button prevbtn =new Button("", new ImageView("/thebr/AdminControl/previous.png"));
 gridadmin.add(prevbtn,0,0);
    prevbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Emq5(primaryStage,marks);
    }
    });

 Button relbtn =new Button("", new ImageView("/thebr/AdminControl/reload.png"));
 gridadmin.add(relbtn,1,0);
    relbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Emq6(primaryStage,marks);
    }
    });
 
 Button nextbtn = new Button("", new ImageView("/thebr/AdminControl/next.png"));
 gridadmin.add(nextbtn,2,0);
     nextbtn.setOnAction(new EventHandler<ActionEvent>() {
     public void handle(ActionEvent ae){
     obj.Emq7(primaryStage,marks);
     }
     });
     
 Button levelbtn =new Button("", new ImageView("/thebr/AdminControl/level.png"));
 gridadmin.add(levelbtn,3,0);
    levelbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Page2(primaryStage,marks);
    }
    });
}
 //Admin Control Ends
 
    //Adding Score View
        Text scrLbl = new Text("Score: ");
        scrLbl.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        scrLbl.setFill( Color.web("BLACK", 0.50) );
        scrLbl.setX(5);
        scrLbl.setY(595);
        
        String myscore= Double.toString(mrk);
        Text scrView= new Text();
        scrView.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
        scrView.setFill( Color.web("WHITE", 0.50) );
        scrView.setText(myscore);
        scrView.setX(63);
        scrView.setY(595);

//Adding close button
Button btnclose = new Button("",new ImageView("/thebr/AdminControl/close.png"));
btnclose.setId("btnclose");
btnclose.setTranslateX(750);
btnclose.setTranslateY(550);
    btnclose.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
        TheBr obj = new TheBr();
        obj.Marks(primaryStage,marks);
        voice.stop();
        autoSlide.stop();
    }
    });
        
Image imgb = new Image("/thebr/background.jpg");
ImageView imgb1 = new ImageView(imgb);
root.getChildren().addAll(imgb1,linesW,linesO,linesR,grid1,gridadmin,btnclose,scrLbl,scrView);
Scene scene = new Scene(root, 800, 600, Color.GRAY);
primaryStage.setScene(scene);
primaryStage.setResizable(false);
scene.getStylesheets().add(TheBr.class.getResource("imgb.css").toExternalForm());			
primaryStage.getIcons().add(new Image("/thebr/TheBrainifyApp.jpg"));
primaryStage.show();
}


//Easy Mode Q7
public void Emq7(Stage primaryStage, double marks)
{
System.out.println("Reached EMq7");
    
Group root = new Group();
FlowPane rootNode= new FlowPane();
primaryStage.setTitle("The Brainify App- Easy Mode:");

    //Virtual Assistant
     MediaPlayer voice = new MediaPlayer(new Media(TheBr.class.getResource("virtualAssistant/emq7.mp3").toString())); 
     voice.play();

//Timer Line       
        Group linesW = new Group();
        for(int i=0;i<1;i++)
        {
        Line whiteLine = new Line(0, 0, 780, 0);
        whiteLine.setStroke(Color.web("#4EFF00", 0.5));
        whiteLine.setStrokeWidth(40);
        whiteLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesW.getChildren().add(whiteLine);
        }
      
        Group linesO = new Group();
        for(int i=0;i<1;i++)
        {
        Line orangeLine = new Line(0, 0, 780, 0);
        orangeLine.setStroke(Color.web("#FF9900", 1.0));
        orangeLine.setStrokeWidth(40);
        orangeLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesO.getChildren().add(orangeLine);
        }
            
        Group linesR = new Group();
        for(int i=0;i<1;i++)
        {
        Line redLine = new Line(0, 0, 780, 0);
        redLine.setStroke(Color.web("#FF0000", 1.0));
        redLine.setStrokeWidth(40);
        redLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesR.getChildren().add(redLine);
        }
 
        
        Timeline timeline = new Timeline();
        for (Node whiteLine: linesW.getChildren()) 
        {
        timeline.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(whiteLine.translateXProperty(), -800),
        new KeyValue(whiteLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(18040), 
        new KeyValue(whiteLine.translateXProperty(), -320),
        new KeyValue(whiteLine.translateYProperty(), 0)
                )
                );
        }
        timeline.play();

        Timeline timeline1 = new Timeline();
        for (Node orangeLine: linesO.getChildren())
        {
        timeline1.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(18040), 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),        
        new KeyFrame(new Duration(18040), 
        new KeyValue(orangeLine.translateXProperty(), -320),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ), 
        
        new KeyFrame(new Duration(25550), 
        new KeyValue(orangeLine.translateXProperty(), -120),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    )
                    );
        }
        timeline1.play();

        Timeline timeline2 = new Timeline();
        for (Node redLine: linesR.getChildren())
        {
        timeline2.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(redLine.translateXProperty(), -800),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(25550),
        new KeyValue(redLine.translateXProperty(), -800),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),   
        new KeyFrame(new Duration(25550), 
        new KeyValue(redLine.translateXProperty(), -120),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),       
 
        new KeyFrame(new Duration(30000),
        new KeyValue(redLine.translateXProperty(), 0),
        new KeyValue(redLine.translateYProperty(), 0)
                    )
                    );
        }
        timeline2.play();  
        
        //Timer Lines END		   


GridPane grid1=new GridPane();
 grid1.setAlignment(Pos.CENTER);
 grid1.setHgap(10);
 grid1.setVgap(10);
 grid1.setPadding(new Insets(25,25,25,100));
 Text queE7=new Text("Q7. How many Trash Full icons do you see?"); 
 queE7.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
 grid1.add(queE7,0,0,15,1);
 

    

        for (int j=1;j<=5;j++)
        {
                 for(int i=0; i<15;i++)
                     if(i%2==0)
                  grid1.add(new ImageView("/thebr/Brainify/te.png"),i,j);
                    else
                  grid1.add(new ImageView("/thebr/Brainify/tf.png"),i,j); 
        }
        
       
       
        Line sliderLine = new Line(10, 10, 600, 10);
        // setting common properties
sliderLine.setStroke(Color.BLACK);
sliderLine.setStrokeWidth(30);
sliderLine.setStrokeLineCap(StrokeLineCap.BUTT);

// creating a dashed pattern
sliderLine.getStrokeDashArray().addAll(10d, 5d, 15d, 5d, 20d);
sliderLine.setStrokeDashOffset(0);

    Slider slider = new Slider(10, 75 , 0);
    
    // bind the stroke dash offset property
sliderLine.strokeDashOffsetProperty().bind(slider.valueProperty());
Text offsetText = new Text("10");
offsetText.setId("offsetText");

offsetText.setStroke(Color.BLACK);

GridPane grid2=new GridPane();
 grid2.setAlignment(Pos.CENTER);
 grid2.setHgap(10);
 grid2.setVgap(0);
 grid2.setPadding(new Insets(0,0,0,0));
 
 GridPane grid3=new GridPane();
 grid3.setAlignment(Pos.CENTER);
 grid3.setHgap(10);
 grid3.setVgap(0);
 grid3.setPadding(new Insets(0,0,0,0));

final Text actiontargetR = new Text();
        actiontargetR.setId("actiontargetR");
        grid3.add(actiontargetR,0,0);
        
        final Text actiontarget = new Text();
        actiontarget.setId("actiontarget");
        grid3.add(actiontarget,0,0);
        grid1.add(grid3,0,8,15,1);
        
          //Timer start, will to skip if no button pressed
            System.out.println("btn pressed before timeline = "+ btnPressed);
            Timeline autoSlide = new Timeline(new KeyFrame(
            Duration.millis(30000),
            ae-> 
            { 
                if(btnPressed==0)
                {//Time out
                System.out.println("marks skipped = "+ marks);
                TheBr obj = new TheBr();
                obj.Emq8(primaryStage, marks);
                }
            }     
            ));
            autoSlide.play();      
//End of auto Timer
// display stroke dash offset value

TheBr obj= new TheBr();
slider.valueProperty().addListener((ov, curVal, newVal) ->
{
offsetText.setText("" +(int) slider.getValue());
     int x= (int)slider.getValue();
     
         Button btn = new Button("GO!");
         grid2.add(btn,5,0);
         btn.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent ae) {
           if(x==35)
           {
                actiontargetR.setText("RIGHT!");
                rightPlayer.play();
                obj.Right(marks);
             btnPressed=1;	
if(btnPressed==1)
            {
				autoSlide.stop();
                try {       
                PauseTransition wait=new PauseTransition(Duration.seconds(1));
                wait.setOnFinished((e)->{  
                obj.Emq8(primaryStage, marks);
				});
                wait.play();
                }
                catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
            }

                
               
            }
        
    
        else
            {        
               actiontarget.setText("OOPS!");
               obj.Wrong(marks);
               btnPressed=1;	
if(btnPressed==1)
            {
				autoSlide.stop();
                try {       
                PauseTransition wait=new PauseTransition(Duration.seconds(1));
                wait.setOnFinished((e)->{  
                obj.Emq8(primaryStage, marks);
				});
                wait.play();
                }
                catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
            }

            }
     
        }                 
    });
});

grid1.add(sliderLine,0,7,15,1);
grid2.add(slider,0,1,6,1);
grid2.add(offsetText,0,0);
grid1.add(grid2,0,6,15,1);

 //Admin control
 GridPane gridadmin = new GridPane();
 gridadmin.setAlignment(Pos.CENTER);
 gridadmin.setHgap(10);
 gridadmin.setVgap(10);
 gridadmin.setPadding(new Insets(0,0,0,0));
 gridadmin.setLayoutX(275);
 gridadmin.setLayoutY(550);
if(admin==1)
{  
 autoSlide.stop();   
 Button prevbtn =new Button("", new ImageView("/thebr/AdminControl/previous.png"));
 gridadmin.add(prevbtn,0,0);
    prevbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Emq6(primaryStage,marks);
    }
    });

 Button relbtn =new Button("", new ImageView("/thebr/AdminControl/reload.png"));
 gridadmin.add(relbtn,1,0);
    relbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Emq7(primaryStage,marks);
    }
    });
 
 Button nextbtn = new Button("", new ImageView("/thebr/AdminControl/next.png"));
 gridadmin.add(nextbtn,2,0);
     nextbtn.setOnAction(new EventHandler<ActionEvent>() {
     public void handle(ActionEvent ae){
     obj.Emq8(primaryStage,marks);
     }
     });
     
 Button levelbtn =new Button("", new ImageView("/thebr/AdminControl/level.png"));
 gridadmin.add(levelbtn,3,0);
    levelbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Page2(primaryStage,marks);
    }
    });
}
 //Admin Control Ends

    //Adding Score View
        Text scrLbl = new Text("Score: ");
        scrLbl.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        scrLbl.setFill( Color.web("BLACK", 0.50) );
        scrLbl.setX(5);
        scrLbl.setY(595);
        
        String myscore= Double.toString(mrk);
        Text scrView= new Text();
        scrView.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
        scrView.setFill( Color.web("WHITE", 0.50) );
        scrView.setText(myscore);
        scrView.setX(63);
        scrView.setY(595);

//Adding close button
Button btnclose = new Button("",new ImageView("/thebr/AdminControl/close.png"));
btnclose.setId("btnclose");
btnclose.setTranslateX(750);
btnclose.setTranslateY(550);
    btnclose.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
        TheBr obj = new TheBr();
        obj.Marks(primaryStage,marks);
        voice.stop();
        autoSlide.stop();
    }
    });

Image imgb = new Image("/thebr/background.jpg");
ImageView imgb1 = new ImageView(imgb);
root.getChildren().addAll(imgb1,linesW,linesO,linesR,grid1,gridadmin,btnclose,scrLbl,scrView);
Scene scene = new Scene(root, 800, 600, Color.GRAY);
primaryStage.setScene(scene);
primaryStage.setResizable(false);
scene.getStylesheets().add(TheBr.class.getResource("imgb.css").toExternalForm());			
primaryStage.getIcons().add(new Image("/thebr/TheBrainifyApp.jpg"));
primaryStage.show();
}


//Easy Mode Q8
public void Emq8(Stage primaryStage, double marks)
{
System.out.println("Reached EMq8");
    
Group root = new Group();
FlowPane rootNode= new FlowPane();
primaryStage.setTitle("The Brainify App- Easy Mode:");

    //Virtual Assistant
     MediaPlayer voice = new MediaPlayer(new Media(TheBr.class.getResource("virtualAssistant/emq8.mp3").toString())); 
     voice.play();

//Timer Line       
        Group linesW = new Group();
        for(int i=0;i<1;i++)
        {
        Line whiteLine = new Line(0, 0, 780, 0);
        whiteLine.setStroke(Color.web("#4EFF00", 0.5));
        whiteLine.setStrokeWidth(40);
        whiteLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesW.getChildren().add(whiteLine);
        }
      
        Group linesO = new Group();
        for(int i=0;i<1;i++)
        {
        Line orangeLine = new Line(0, 0, 780, 0);
        orangeLine.setStroke(Color.web("#FF9900", 1.0));
        orangeLine.setStrokeWidth(40);
        orangeLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesO.getChildren().add(orangeLine);
        }
            
        Group linesR = new Group();
        for(int i=0;i<1;i++)
        {
        Line redLine = new Line(0, 0, 780, 0);
        redLine.setStroke(Color.web("#FF0000", 1.0));
        redLine.setStrokeWidth(40);
        redLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesR.getChildren().add(redLine);
        }
 
        
        Timeline timeline = new Timeline();
        for (Node whiteLine: linesW.getChildren()) 
        {
        timeline.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(whiteLine.translateXProperty(), -800),
        new KeyValue(whiteLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(18040), 
        new KeyValue(whiteLine.translateXProperty(), -320),
        new KeyValue(whiteLine.translateYProperty(), 0)
                )
                );
        }
        timeline.play();

        Timeline timeline1 = new Timeline();
        for (Node orangeLine: linesO.getChildren())
        {
        timeline1.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(18040), 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),        
        new KeyFrame(new Duration(18040), 
        new KeyValue(orangeLine.translateXProperty(), -320),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ), 
        
        new KeyFrame(new Duration(25550), 
        new KeyValue(orangeLine.translateXProperty(), -120),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    )
                    );
        }
        timeline1.play();

        Timeline timeline2 = new Timeline();
        for (Node redLine: linesR.getChildren())
        {
        timeline2.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(redLine.translateXProperty(), -800),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(25550),
        new KeyValue(redLine.translateXProperty(), -800),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),   
        new KeyFrame(new Duration(25550), 
        new KeyValue(redLine.translateXProperty(), -120),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),       
 
        new KeyFrame(new Duration(30000),
        new KeyValue(redLine.translateXProperty(), 0),
        new KeyValue(redLine.translateYProperty(), 0)
                    )
                    );
        }
        timeline2.play();  
        
        //Timer Lines END		   


GridPane grid0=new GridPane();
 grid0.setAlignment(Pos.CENTER);
 grid0.setHgap(10);
 grid0.setVgap(10);
 grid0.setPadding(new Insets(75,25,25,125));
 
 GridPane grid1=new GridPane();
 grid1.setAlignment(Pos.CENTER);
 grid1.setHgap(10);
 grid1.setVgap(10);
 grid1.setPadding(new Insets(25,25,25,25));
 grid0.add(grid1,0,1);
 
 
 //Adding Blanck icons
 for(int i=1;i<=2;i++)
         {
             for(int j=0;j<5;j++)
             grid1.add(new ImageView("/thebr/Brainify/eq8b.png"),j,i);
         }
 
 //Adding icons
            try {       
                PauseTransition wait=new PauseTransition(Duration.seconds(2));
                wait.setOnFinished((e)->{
                grid1.add(new ImageView("/thebr/Brainify/e8_1.png"),0,1);
                });
                wait.play();
                } 
                catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
 
 
            try {       
                PauseTransition wait=new PauseTransition(Duration.seconds(3));
                wait.setOnFinished((e)->{
                grid1.add(new ImageView("/thebr/Brainify/e8_2.png"),4,2);
                });
                wait.play();
                }
                        catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
            
            try {       
                PauseTransition wait=new PauseTransition(Duration.seconds(4));
                wait.setOnFinished((e)->{
                grid1.add(new ImageView("/thebr/Brainify/e8_3.png"),3,1);
                });
                wait.play();
                }
                        catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
            
            try {       
                PauseTransition wait=new PauseTransition(Duration.seconds(5));
                wait.setOnFinished((e)->{
                grid1.add(new ImageView("/thebr/Brainify/e8_4.png"),1,2);
                });
                wait.play();
                }
                        catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
            
            try {       
                PauseTransition wait=new PauseTransition(Duration.seconds(6));
                wait.setOnFinished((e)->{
                grid1.add(new ImageView("/thebr/Brainify/e8_5.png"),4,1);
                });
                wait.play();
                }
                        catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
            
            try {       
                PauseTransition wait=new PauseTransition(Duration.seconds(7));
                wait.setOnFinished((e)->{
                grid1.add(new ImageView("/thebr/Brainify/e8_6.png"),1,1);
                });
                wait.play();
                }
                        catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
            
            try {       
                PauseTransition wait=new PauseTransition(Duration.seconds(8));
                wait.setOnFinished((e)->{
                grid1.add(new ImageView("/thebr/Brainify/e8_7.png"),3,2);
                });
                wait.play();
                }
                        catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
            
            try {       
                PauseTransition wait=new PauseTransition(Duration.seconds(9));
                wait.setOnFinished((e)->{
                grid1.add(new ImageView("/thebr/Brainify/e8_8.png"),2,1);
                });
                wait.play();
                }
                        catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
            
            try {       
                PauseTransition wait=new PauseTransition(Duration.seconds(10));
                wait.setOnFinished((e)->{
                grid1.add(new ImageView("/thebr/Brainify/e8_9.png"),0,2);
                });
                wait.play();
                }
                        catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
            
            try {       
                PauseTransition wait=new PauseTransition(Duration.seconds(11));
                wait.setOnFinished((e)->{
                grid1.add(new ImageView("/thebr/Brainify/e8_10.png"),2,2);
                });
                wait.play();
                }
                        catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
            
            try {       
                PauseTransition wait=new PauseTransition(Duration.seconds(1));
                wait.setOnFinished((e)->{
                grid1.add(new ImageView("/thebr/Brainify/e8_2.png"),4,2);
                });
                wait.play();
                }
                        catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
            
            
              //Timer start, will to skip if no button pressed
            System.out.println("btn pressed before timeline = "+ btnPressed);
            Timeline autoSlide = new Timeline(new KeyFrame(
            Duration.millis(30000),
            ae-> 
            { 
                if(btnPressed==0)
                {//Time out
                System.out.println("marks skipped = "+ marks);
                TheBr obj = new TheBr();
                obj.Emq9(primaryStage, marks);
                }
            }     
            ));
            autoSlide.play();      
//End of auto Timer
            
            //Creating menu
            
            MenuBar mbv = new MenuBar();
            
            Menu whichOne = new Menu("Q8. Which one's appearing order is sixth?");
            Menu row1 = new Menu("1");
            Menu row2 = new Menu("2");
            
            
            whichOne.getItems().add(new SeparatorMenuItem());
            MenuItem row = new MenuItem("Row:");
            whichOne.getItems().add(new SeparatorMenuItem());
            whichOne.getItems().add(row);
            
            row1.getItems().add(new SeparatorMenuItem());
            MenuItem clmnOne = new MenuItem("Column:");
            row1.getItems().add(new SeparatorMenuItem());
            row1.getItems().add(clmnOne);
            RadioMenuItem clmn1 = new RadioMenuItem("1");
            RadioMenuItem clmn2 = new RadioMenuItem("2 ");
            RadioMenuItem clmn3 = new RadioMenuItem("3");
            RadioMenuItem clmn4 = new RadioMenuItem("4");
            RadioMenuItem clmn5 = new RadioMenuItem("5");
            ToggleGroup tg = new ToggleGroup();
            clmn1.setToggleGroup(tg);
            clmn2.setToggleGroup(tg);
            clmn3.setToggleGroup(tg);
            clmn4.setToggleGroup(tg);
            clmn5.setToggleGroup(tg);
            row1.getItems().addAll(clmn1,clmn2,clmn3,clmn4,clmn5);
 
            
            row2.getItems().add(new SeparatorMenuItem());
            MenuItem clmnTwo = new MenuItem("Column:");
            row2.getItems().add(new SeparatorMenuItem());
            row2.getItems().add(clmnTwo);
            RadioMenuItem clmn2_1 = new RadioMenuItem("1");
            RadioMenuItem clmn2_2 = new RadioMenuItem("2");
            RadioMenuItem clmn2_3 = new RadioMenuItem("3");
            RadioMenuItem clmn2_4 = new RadioMenuItem("4");
            RadioMenuItem clmn2_5 = new RadioMenuItem("5");
            ToggleGroup tg1 = new ToggleGroup();
            clmn2_1.setToggleGroup(tg1);
            clmn2_2.setToggleGroup(tg1);
            clmn2_3.setToggleGroup(tg1);
            clmn2_4.setToggleGroup(tg1);
            clmn2_5.setToggleGroup(tg1);
            row2.getItems().addAll(clmn2_1,clmn2_2,clmn2_3,clmn2_4,clmn2_5);
            
            whichOne.getItems().add(row1);
            whichOne.getItems().add(row2);
            
            GridPane grid3=new GridPane();
            grid3.setAlignment(Pos.CENTER);
            grid3.setHgap(10);
            grid3.setVgap(0);
            grid3.setPadding(new Insets(0,0,0,0));
            grid0.add(grid3,0,2);
            
            mbv.getMenus().add(whichOne);
            grid1.add(mbv,0,0,5,1);
            
            final Text actiontargetR = new Text();
            actiontargetR.setId("actiontargetR");
            grid3.add(actiontargetR,0,2);
        
            final Text actiontarget = new Text();
            actiontarget.setId("actiontarget");
            grid3.add(actiontarget,0,2);
           
            
            TheBr obj= new TheBr();
            Label response= new Label("Menu Items");
            EventHandler<ActionEvent> MEHandler = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
            String name = ((MenuItem)ae.getTarget()).getText();
            response.setText( name + " selected");
            String ans="2 ";
            if(ans.equalsIgnoreCase(name))
           {
                actiontargetR.setText("RIGHT!");
                obj.Right(marks);
             btnPressed=1;	
if(btnPressed==1)
            {
				autoSlide.stop();
                try {       
                PauseTransition wait=new PauseTransition(Duration.seconds(1));
                wait.setOnFinished((e)->{  
                obj.Emq9(primaryStage, marks);
				});
                wait.play();
                }
                catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
            }

                
               
            }
        
    
        else
            {        
               actiontarget.setText("OOPS!");
               obj.Wrong(marks);
               btnPressed=1;	
if(btnPressed==1)
            {
                autoSlide.stop();
                try {       
                PauseTransition wait=new PauseTransition(Duration.seconds(1));
                wait.setOnFinished((e)->{  
                obj.Emq9(primaryStage, marks);
				});
                wait.play();
                }
                catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
            }
  
            }
     
        }                 
            
    };
            clmn1.setOnAction(MEHandler);
            clmn2.setOnAction(MEHandler);
            clmn3.setOnAction(MEHandler);
            clmn4.setOnAction(MEHandler);
            clmn5.setOnAction(MEHandler);
            clmn2_1.setOnAction(MEHandler);
            clmn2_2.setOnAction(MEHandler);
            clmn2_3.setOnAction(MEHandler);
            clmn2_4.setOnAction(MEHandler);
            clmn2_5.setOnAction(MEHandler);
            
  //Admin control
 GridPane gridadmin = new GridPane();
 gridadmin.setAlignment(Pos.CENTER);
 gridadmin.setHgap(10);
 gridadmin.setVgap(10);
 gridadmin.setPadding(new Insets(0,0,0,0));
 gridadmin.setLayoutX(275);
 gridadmin.setLayoutY(550);
if(admin==1)
{  
 autoSlide.stop();   
 Button prevbtn =new Button("", new ImageView("/thebr/AdminControl/previous.png"));
 gridadmin.add(prevbtn,0,0);
    prevbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Emq7(primaryStage,marks);
    }
    });

 Button relbtn =new Button("", new ImageView("/thebr/AdminControl/reload.png"));
 gridadmin.add(relbtn,1,0);
    relbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Emq8(primaryStage,marks);
    }
    });
 
 Button nextbtn = new Button("", new ImageView("/thebr/AdminControl/next.png"));
 gridadmin.add(nextbtn,2,0);
     nextbtn.setOnAction(new EventHandler<ActionEvent>() {
     public void handle(ActionEvent ae){
     obj.Emq9(primaryStage,marks);
     }
     });
     
 Button levelbtn =new Button("", new ImageView("/thebr/AdminControl/level.png"));
 gridadmin.add(levelbtn,3,0);
    levelbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Page2(primaryStage,marks);
    }
    });
}
 //Admin Control Ends         
  
   //Adding Score View
        Text scrLbl = new Text("Score: ");
        scrLbl.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        scrLbl.setFill( Color.web("BLACK", 0.50) );
        scrLbl.setX(5);
        scrLbl.setY(595);
        
        String myscore= Double.toString(mrk);
        Text scrView= new Text();
        scrView.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
        scrView.setFill( Color.web("WHITE", 0.50) );
        scrView.setText(myscore);
        scrView.setX(63);
        scrView.setY(595);

//Adding close button
Button btnclose = new Button("",new ImageView("/thebr/AdminControl/close.png"));
btnclose.setId("btnclose");
btnclose.setTranslateX(750);
btnclose.setTranslateY(550);
    btnclose.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
        TheBr obj = new TheBr();
        obj.Marks(primaryStage,marks);
        voice.stop();
        autoSlide.stop();
    }
    });
    
            
//grid1.add(response,0,4); 
Image imgb = new Image("/thebr/background.jpg");
ImageView imgb1 = new ImageView(imgb);
root.getChildren().addAll(imgb1,linesW,linesO,linesR,grid0,gridadmin,btnclose,scrLbl,scrView);
Scene scene = new Scene(root, 800, 600, Color.GRAY);
primaryStage.setScene(scene);
primaryStage.setResizable(false);
scene.getStylesheets().add(TheBr.class.getResource("imgb.css").toExternalForm());			
primaryStage.getIcons().add(new Image("/thebr/TheBrainifyApp.jpg"));
primaryStage.show();

}

//Easy Mode Q9

public void Emq9(Stage primaryStage, double marks)
{
Group root = new Group();
FlowPane rootNode= new FlowPane();
primaryStage.setTitle("The Brainify App- Easy Mode:"); 

    //Virtual Assistant
     MediaPlayer voice = new MediaPlayer(new Media(TheBr.class.getResource("virtualAssistant/emq9.mp3").toString())); 
     voice.play();

//Timer Line       
        Group linesW = new Group();
        for(int i=0;i<1;i++)
        {
        Line whiteLine = new Line(0, 0, 780, 0);
        whiteLine.setStroke(Color.web("#4EFF00", 0.5));
        whiteLine.setStrokeWidth(40);
        whiteLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesW.getChildren().add(whiteLine);
        }
      
        Group linesO = new Group();
        for(int i=0;i<1;i++)
        {
        Line orangeLine = new Line(0, 0, 780, 0);
        orangeLine.setStroke(Color.web("#FF9900", 1.0));
        orangeLine.setStrokeWidth(40);
        orangeLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesO.getChildren().add(orangeLine);
        }
            
        Group linesR = new Group();
        for(int i=0;i<1;i++)
        {
        Line redLine = new Line(0, 0, 780, 0);
        redLine.setStroke(Color.web("#FF0000", 1.0));
        redLine.setStrokeWidth(40);
        redLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesR.getChildren().add(redLine);
        }
 
        
        Timeline timeline = new Timeline();
        for (Node whiteLine: linesW.getChildren()) 
        {
        timeline.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(whiteLine.translateXProperty(), -800),
        new KeyValue(whiteLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(18040), 
        new KeyValue(whiteLine.translateXProperty(), -320),
        new KeyValue(whiteLine.translateYProperty(), 0)
                )
                );
        }
        timeline.play();

        Timeline timeline1 = new Timeline();
        for (Node orangeLine: linesO.getChildren())
        {
        timeline1.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(18040), 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),        
        new KeyFrame(new Duration(18040), 
        new KeyValue(orangeLine.translateXProperty(), -320),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ), 
        
        new KeyFrame(new Duration(25550), 
        new KeyValue(orangeLine.translateXProperty(), -120),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    )
                    );
        }
        timeline1.play();

        Timeline timeline2 = new Timeline();
        for (Node redLine: linesR.getChildren())
        {
        timeline2.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(redLine.translateXProperty(), -800),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(25550),
        new KeyValue(redLine.translateXProperty(), -800),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),   
        new KeyFrame(new Duration(25550), 
        new KeyValue(redLine.translateXProperty(), -120),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),       
 
        new KeyFrame(new Duration(30000),
        new KeyValue(redLine.translateXProperty(), 0),
        new KeyValue(redLine.translateYProperty(), 0)
                    )
                    );
        }
        timeline2.play();  
        
         //Timer Lines END		   

                    
              //Timer start, will to skip if no button pressed
            System.out.println("btn pressed before timeline = "+ btnPressed);
            Timeline autoSlide = new Timeline(new KeyFrame(
            Duration.millis(30000),
            ae-> 
            { 
                if(btnPressed==0)
                {//Time out
                System.out.println("marks skipped = "+ marks);
                TheBr obj = new TheBr();
                obj.Emq10(primaryStage, marks);
                }
            }     
            ));
            autoSlide.play();      
        //End of auto Timer


Text queE9=new Text("Q9.   The day the earth stood still?"); 
queE9.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
queE9.setX(175);
queE9.setY(100);

Text text = new Text("Hint: The programmers didn't expect their programs to last until year");
text.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
text.setX(100);
text.setY(150);
        
            GridPane grid3 = new GridPane();  
            grid3.setAlignment(Pos.CENTER);
            grid3.setHgap(0);
            grid3.setVgap(0);
            grid3.setPadding(new Insets(0,0,0,0));
            grid3.setLayoutX(250);
            grid3.setLayoutY(350);
                              
            final Text actiontargetR = new Text();
            actiontargetR.setId("actiontargetR");
            grid3.add(actiontargetR,0,0);
        
            final Text actiontarget = new Text();
            actiontarget.setId("actiontarget");
            grid3.add(actiontarget,0,0);
            TheBr obj = new TheBr();
         
Label lbl = new Label();
DatePicker dp = new DatePicker();
dp.setLayoutX(300);
dp.setLayoutY(300);
dp.setOnAction(ae ->
{
LocalDate date = dp.getValue();
lbl.setText(date.toString());
System.out.println(date.toString());

        String eqs =date.toString();
        String ans = "2000-01-01";
        if(ans.equalsIgnoreCase(eqs))
        {
                actiontargetR.setText("RIGHT!");
                rightPlayer.play();
                obj.Right(marks);
        btnPressed=1;	
        if(btnPressed==1)
                    {
				autoSlide.stop();
                try {       
                PauseTransition wait=new PauseTransition(Duration.seconds(1));
                wait.setOnFinished((e)->{  
                obj.Emq10(primaryStage, marks);
				});
                wait.play();
                }
                catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
            }  
        }
        else
        {        
               actiontarget.setText("OOPS!");
               obj.Wrong(marks);
            btnPressed=1;	
            if(btnPressed==1)
            {
                autoSlide.stop();
                try {       
                PauseTransition wait=new PauseTransition(Duration.seconds(1));
                wait.setOnFinished((e)->{  
                obj.Emq10(primaryStage,marks);
				});
                wait.play();
                }
                catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
            }
        }
});
         
 //Admin control
 GridPane gridadmin = new GridPane();
 gridadmin.setAlignment(Pos.CENTER);
 gridadmin.setHgap(10);
 gridadmin.setVgap(10);
 gridadmin.setPadding(new Insets(0,0,0,0));
 gridadmin.setLayoutX(275);
 gridadmin.setLayoutY(550);
if(admin==1)
{  
 autoSlide.stop();   
 Button prevbtn =new Button("", new ImageView("/thebr/AdminControl/previous.png"));
 gridadmin.add(prevbtn,0,0);
    prevbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Emq8(primaryStage,marks);
    }
    });

 Button relbtn =new Button("", new ImageView("/thebr/AdminControl/reload.png"));
 gridadmin.add(relbtn,1,0);
    relbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Emq9(primaryStage,marks);
    }
    });
 
 Button nextbtn = new Button("", new ImageView("/thebr/AdminControl/next.png"));
 gridadmin.add(nextbtn,2,0);
     nextbtn.setOnAction(new EventHandler<ActionEvent>() {
     public void handle(ActionEvent ae){
     obj.Emq10(primaryStage,marks);
     }
     });
     
 Button levelbtn =new Button("", new ImageView("/thebr/AdminControl/level.png"));
 gridadmin.add(levelbtn,3,0);
    levelbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Page2(primaryStage,marks);
    }
    });
}
 //Admin Control Ends
 
    //Adding Score View
        Text scrLbl = new Text("Score: ");
        scrLbl.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        scrLbl.setFill( Color.web("BLACK", 0.50) );
        scrLbl.setX(5);
        scrLbl.setY(595);
        
        String myscore= Double.toString(mrk);
        Text scrView= new Text();
        scrView.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
        scrView.setFill( Color.web("WHITE", 0.50) );
        scrView.setText(myscore);
        scrView.setX(63);
        scrView.setY(595);

//Adding close button
Button btnclose = new Button("",new ImageView("/thebr/AdminControl/close.png"));
btnclose.setId("btnclose");
btnclose.setTranslateX(750);
btnclose.setTranslateY(550);
    btnclose.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
        TheBr obj = new TheBr();
        obj.Marks(primaryStage,marks);
        voice.stop();
        autoSlide.stop();
    }
    });

Image imgb = new Image("/thebr/background.jpg");
ImageView imgb1 = new ImageView(imgb);
root.getChildren().addAll(imgb1,linesW,linesO,linesR,queE9,text,grid3,dp,gridadmin,btnclose,scrLbl,scrView);
Scene scene = new Scene(root, 800, 600, Color.GRAY);
primaryStage.setScene(scene);
scene.getStylesheets().add(TheBr.class.getResource("imgb.css").toExternalForm());			
primaryStage.getIcons().add(new Image("/thebr/TheBrainifyApp.jpg"));
primaryStage.show();

}


//Q10 Easy Mode
private String s2 ="";
private static int nClicks = 0;  //for Q10 no: times clicks GUI button add to grid
public void Emq10(Stage primaryStage,double marks)
{
Group root = new Group();
FlowPane rootNode= new FlowPane();
primaryStage.setTitle("The Brainify App- Easy Mode:"); 
    //Virtual Assistant
     MediaPlayer voice = new MediaPlayer(new Media(TheBr.class.getResource("virtualAssistant/emq10.mp3").toString())); 
     voice.play();

//Timer Line       
        Group linesW = new Group();
        for(int i=0;i<1;i++)
        {
        Line whiteLine = new Line(0, 0, 780, 0);
        whiteLine.setStroke(Color.web("#4EFF00", 0.5));
        whiteLine.setStrokeWidth(40);
        whiteLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesW.getChildren().add(whiteLine);
        }
      
        Group linesO = new Group();
        for(int i=0;i<1;i++)
        {
        Line orangeLine = new Line(0, 0, 780, 0);
        orangeLine.setStroke(Color.web("#FF9900", 1.0));
        orangeLine.setStrokeWidth(40);
        orangeLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesO.getChildren().add(orangeLine);
        }
            
        Group linesR = new Group();
        for(int i=0;i<1;i++)
        {
        Line redLine = new Line(0, 0, 780, 0);
        redLine.setStroke(Color.web("#FF0000", 1.0));
        redLine.setStrokeWidth(40);
        redLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesR.getChildren().add(redLine);
        }
 
        
        Timeline timeline = new Timeline();
        for (Node whiteLine: linesW.getChildren()) 
        {
        timeline.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(whiteLine.translateXProperty(), -800),
        new KeyValue(whiteLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(18040), 
        new KeyValue(whiteLine.translateXProperty(), -320),
        new KeyValue(whiteLine.translateYProperty(), 0)
                )
                );
        }
        timeline.play();

        Timeline timeline1 = new Timeline();
        for (Node orangeLine: linesO.getChildren())
        {
        timeline1.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(18040), 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),        
        new KeyFrame(new Duration(18040), 
        new KeyValue(orangeLine.translateXProperty(), -320),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ), 
        
        new KeyFrame(new Duration(25550), 
        new KeyValue(orangeLine.translateXProperty(), -120),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    )
                    );
        }
        timeline1.play();

        Timeline timeline2 = new Timeline();
        for (Node redLine: linesR.getChildren())
        {
        timeline2.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(redLine.translateXProperty(), -800),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(25550),
        new KeyValue(redLine.translateXProperty(), -800),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),   
        new KeyFrame(new Duration(25550), 
        new KeyValue(redLine.translateXProperty(), -120),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),       
 
        new KeyFrame(new Duration(30000),
        new KeyValue(redLine.translateXProperty(), 0),
        new KeyValue(redLine.translateYProperty(), 0)
                    )
                    );
        }
        timeline2.play();  
        
        //Timer Lines END		   


GridPane grid0=new GridPane();
grid0.setAlignment(Pos.CENTER);
grid0.setHgap(10);
grid0.setVgap(10);
grid0.setPadding(new Insets(75,25,25,75));

Text queE10=new Text("Q10.   Tap the letters in order to create a word?"); 
queE10.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
grid0.add(queE10,0,0);

        String letters []= {"U", "O", "T" ,"R", "S", "T", "O","U"};
        GridPane grid1=new GridPane();
        grid1.setAlignment(Pos.CENTER);
        grid1.setHgap(10);
        grid1.setVgap(10);
        grid1.setPadding(new Insets(25,25,25,25));
                
        
                     GridPane grid2=new GridPane();
                     grid2.setAlignment(Pos.CENTER);
                     grid2.setHgap(0);
                     grid2.setVgap(0);
                     grid2.setPadding(new Insets(0,0,0,0));
                     grid0.add(grid2,0,3);
                     
                     Text actsize= new Text("");
                     actsize.setId("actiontargetR");
                     grid2.add(actsize,0,0);
                     
                     
                     GridPane grid3=new GridPane();
                     grid3.setAlignment(Pos.CENTER);
                     grid3.setHgap(0);
                     grid3.setVgap(0);
                     grid3.setPadding(new Insets(0,0,0,0));
                     grid0.add(grid3,0,4);
                     
                     final Text actiontargetR = new Text();
                     actiontargetR.setId("actiontargetR");
                    grid3.add(actiontargetR,0,0);
        
                    final Text actiontarget = new Text();
                    actiontarget.setId("actiontarget");
                    grid3.add(actiontarget,0,0);
                    
            //Timer start, will skip if no button pressed
            System.out.println("btn pressed before timeline = "+ btnPressed);
            Timeline autoSlide = new Timeline(new KeyFrame(
            Duration.millis(30000),
            ae-> 
            { 
                if(btnPressed==0)
                {//Time out
                System.out.println("marks skipped = "+ marks);
                TheBr obj = new TheBr();
                obj.Marks(primaryStage, marks);
                }
            }     
            ));
            autoSlide.play();      
            //End of auto Timer
            
    TheBr obj = new TheBr();
                    
    for(int i=0;i<8;i++)
    {
    Button btn= new Button(letters[i]);
    btn.setId("q10btn");
    Text act = new Text();

    btn.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent ae) {
            nClicks++;
            System.out.println("Clicked " + nClicks + " times.");
            act.setId("actiontargetB");
             act.setText(btn.getText());
                           
            String s1= btn.getText();
            s2=s2.concat(s1);
            System.out.println("WC "+ s2);
                   

            if(s2.equals("TORTUOUS")&&(s2.length()==8))
            {
                System.out.println("Right");
                actiontargetR.setText("RIGHT!");
                rightPlayer.play();
                obj.Right(marks);
             btnPressed=1;	
            if(btnPressed==1)
            {
				autoSlide.stop();
                try {       
                PauseTransition wait=new PauseTransition(Duration.seconds(1));
                wait.setOnFinished((e)->{  
                obj.Marks(primaryStage,marks);
				});
                wait.play();
                }
                catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
            }
            }
            else if(s2.length()==8)
                {
                System.out.println("Wrong");
                actiontarget.setText("OOPS!");
                wrongPlayer.play();
                obj.Wrong(marks);
            btnPressed=1;	
if(btnPressed==1)
            {
				autoSlide.stop();
                try {       
                PauseTransition wait=new PauseTransition(Duration.seconds(1));
                wait.setOnFinished((e)->{  
                obj.Marks(primaryStage,marks);
				});
                wait.play();
                }
                catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
            }
            }
            else{
                System.out.println("Word is:- "+s2);
            }
            
            grid2.add(act,nClicks,0);
            btn.setDisable(true); 
            
         }
        });

    grid1.add(btn,i,0);
   }
    grid0.add(grid1,0,1);
    
    
         //Admin control
 GridPane gridadmin = new GridPane();
 gridadmin.setAlignment(Pos.CENTER);
 gridadmin.setHgap(10);
 gridadmin.setVgap(10);
 gridadmin.setPadding(new Insets(0,0,0,0));
 gridadmin.setLayoutX(275);
 gridadmin.setLayoutY(550);
if(admin==1)
{  
 autoSlide.stop();   
 Button prevbtn =new Button("", new ImageView("/thebr/AdminControl/previous.png"));
 gridadmin.add(prevbtn,0,0);
    prevbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Emq9(primaryStage,marks);
    }
    });

 Button relbtn =new Button("", new ImageView("/thebr/AdminControl/reload.png"));
 gridadmin.add(relbtn,1,0);
    relbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Emq10(primaryStage,marks);
    }
    });
 
 Button nextbtn = new Button("", new ImageView("/thebr/AdminControl/next.png"));
 gridadmin.add(nextbtn,2,0);
     nextbtn.setOnAction(new EventHandler<ActionEvent>() {
     public void handle(ActionEvent ae){
     obj.Page2(primaryStage,marks);
     }
     });
     
 Button levelbtn =new Button("", new ImageView("/thebr/AdminControl/level.png"));
 gridadmin.add(levelbtn,3,0);
    levelbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Page2(primaryStage,marks);
    }
    });
}
 //Admin Control Ends
 
    //Adding Score View
        Text scrLbl = new Text("Score: ");
        scrLbl.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        scrLbl.setFill( Color.web("BLACK", 0.50) );
        scrLbl.setX(5);
        scrLbl.setY(595);
        
        String myscore= Double.toString(mrk);
        Text scrView= new Text();
        scrView.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
        scrView.setFill( Color.web("WHITE", 0.50) );
        scrView.setText(myscore);
        scrView.setX(63);
        scrView.setY(595);

//Adding close button
Button btnclose = new Button("",new ImageView("/thebr/AdminControl/close.png"));
btnclose.setId("btnclose");
btnclose.setTranslateX(750);
btnclose.setTranslateY(550);
    btnclose.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
        TheBr obj = new TheBr();
        obj.Marks(primaryStage,marks);
        voice.stop();
        autoSlide.stop();
    }
    });

Image imgb = new Image("/thebr/background.jpg");
ImageView imgb1 = new ImageView(imgb);
root.getChildren().addAll(imgb1,linesW,linesO,linesR,grid0,gridadmin,btnclose,scrLbl,scrView);    
Scene scene = new Scene(root, 800, 600, Color.GRAY);
primaryStage.setScene(scene);
primaryStage.setResizable(false);
scene.getStylesheets().add(TheBr.class.getResource("imgb.css").toExternalForm());			
primaryStage.getIcons().add(new Image("/thebr/TheBrainifyApp.jpg"));
primaryStage.show();

}

//####################################### End of Easy Mode ################################################

public void Imq1(Stage primaryStage, double marks)
{
System.out.println("Reached Imq1");
    
Group root = new Group();
FlowPane rootNode= new FlowPane();
primaryStage.setTitle("The Brainify App- Easy Mode:"); 

    //Virtual Assistant
     MediaPlayer voice = new MediaPlayer(new Media(TheBr.class.getResource("virtualAssistant/Imq1.mp3").toString())); 
     voice.play();

//Timer Line       
        Group linesW = new Group();
        for(int i=0;i<1;i++)
        {
        Line whiteLine = new Line(0, 0, 780, 0);
        whiteLine.setStroke(Color.web("#4EFF00", 0.5));
        whiteLine.setStrokeWidth(40);
        whiteLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesW.getChildren().add(whiteLine);
        }
      
        Group linesO = new Group();
        for(int i=0;i<1;i++)
        {
        Line orangeLine = new Line(0, 0, 780, 0);
        orangeLine.setStroke(Color.web("#FF9900", 1.0));
        orangeLine.setStrokeWidth(40);
        orangeLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesO.getChildren().add(orangeLine);
        }
            
        Group linesR = new Group();
        for(int i=0;i<1;i++)
        {
        Line redLine = new Line(0, 0, 780, 0);
        redLine.setStroke(Color.web("#FF0000", 1.0));
        redLine.setStrokeWidth(40);
        redLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesR.getChildren().add(redLine);
        }
 
        
        Timeline timeline = new Timeline();
        for (Node whiteLine: linesW.getChildren()) 
        {
        timeline.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(whiteLine.translateXProperty(), -800),
        new KeyValue(whiteLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(18040), 
        new KeyValue(whiteLine.translateXProperty(), -320),
        new KeyValue(whiteLine.translateYProperty(), 0)
                )
                );
        }
        timeline.play();

        Timeline timeline1 = new Timeline();
        for (Node orangeLine: linesO.getChildren())
        {
        timeline1.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(18040), 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),        
        new KeyFrame(new Duration(18040), 
        new KeyValue(orangeLine.translateXProperty(), -320),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ), 
        
        new KeyFrame(new Duration(25550), 
        new KeyValue(orangeLine.translateXProperty(), -120),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    )
                    );
        }
        timeline1.play();

        Timeline timeline2 = new Timeline();
        for (Node redLine: linesR.getChildren())
        {
        timeline2.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(redLine.translateXProperty(), -800),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(25550),
        new KeyValue(redLine.translateXProperty(), -800),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),   
        new KeyFrame(new Duration(25550), 
        new KeyValue(redLine.translateXProperty(), -120),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),       
 
        new KeyFrame(new Duration(30000),
        new KeyValue(redLine.translateXProperty(), 0),
        new KeyValue(redLine.translateYProperty(), 0)
                    )
                    );
        }
        timeline2.play();  
        
        //Timer Lines END
        
        //Timer start, will skip if no button pressed
            System.out.println("btn pressed before timeline = "+ btnPressed);
            Timeline autoSlide = new Timeline(new KeyFrame(
            Duration.millis(30000),
            ae-> 
            { 
                if(btnPressed==0)
                {//Time out
                System.out.println("marks skipped = "+ marks);
                TheBr obj = new TheBr();
                obj.Imq2(primaryStage, marks);
                }
            }     
            ));
            autoSlide.play();      
            //End of auto Timer
        
GridPane grid1=new GridPane();
grid1.setAlignment(Pos.CENTER);
grid1.setHgap(10);
grid1.setVgap(10);
grid1.setPadding(new Insets(100,25,25,75));

Text queI1=new Text("Q1. How many times the ball strikes the wall?"); 
queI1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
grid1.add(queI1,0,0);

//Ball
Image ball = new Image("/thebr/InterMode/ball.png");
ImageView ballB= new ImageView(ball);

//Ball stand
Line sliderLine = new Line(10, 65,305, 65);
sliderLine.setStroke(Color.BLACK);
sliderLine.setStrokeWidth(30);
sliderLine.setStrokeLineCap(StrokeLineCap.BUTT);
sliderLine.getStrokeDashArray().addAll(10d, 5d, 15d, 5d, 10d);
sliderLine.setStrokeDashOffset(0);

Line sliderLine2 = new Line(400, 350,800, 350);
sliderLine2.setId("ballStrike");
//sliderLine2.setStroke(Color.LIGHTGRAY);
sliderLine2.setStrokeWidth(30);
sliderLine2.setStrokeLineCap(StrokeLineCap.ROUND);
sliderLine2.setStrokeDashOffset(0);

    //Rotate Ball
    RotateTransition rt=  new RotateTransition();
    rt.setNode(ballB);
    rt.setFromAngle(0);
    rt.setToAngle(360);
    rt.setInterpolator(Interpolator.LINEAR);
    rt.setCycleCount(Timeline.INDEFINITE);
    rt.setDuration(new Duration(5900));
    
             try {       
                PauseTransition waitR=new PauseTransition(Duration.millis(5630));
                waitR.setOnFinished((e)->{  
                rt.play();
		});
                waitR.play();
                }
                catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
  

        
        //Ball strike
        Timeline btimeline = new Timeline();

        btimeline.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(ballB.translateXProperty(), 150),
        new KeyValue(ballB.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(5630), 
        new KeyValue(ballB.translateXProperty(), 150),
        new KeyValue(ballB.translateYProperty(), 0)
                ),
                
        new KeyFrame(new Duration(11260), 
        new KeyValue(ballB.translateXProperty(), 300),
        new KeyValue(ballB.translateYProperty(), 0)
                ),    
                
        new KeyFrame(new Duration(12260), 
        new KeyValue(ballB.translateXProperty(), 350),
        new KeyValue(ballB.translateYProperty(), 550)       
                ), 
        new KeyFrame(new Duration(13260), 
        new KeyValue(ballB.translateXProperty(), 400),
        new KeyValue(ballB.translateYProperty(), 365)
                ),
        new KeyFrame(new Duration(13500), 
        new KeyValue(ballB.translateXProperty(), 450),
        new KeyValue(ballB.translateYProperty(), 550)
        ),
        new KeyFrame(new Duration(13750), 
        new KeyValue(ballB.translateXProperty(), 500),
        new KeyValue(ballB.translateYProperty(), 365)
        ),
        new KeyFrame(new Duration(14000), 
        new KeyValue(ballB.translateXProperty(), 550),
        new KeyValue(ballB.translateYProperty(), 550)
        ),
        new KeyFrame(new Duration(14250), 
        new KeyValue(ballB.translateXProperty(), 600),
        new KeyValue(ballB.translateYProperty(), 365)
        ),
        new KeyFrame(new Duration(14500), 
        new KeyValue(ballB.translateXProperty(), 650),
        new KeyValue(ballB.translateYProperty(), 550)
        ),
        new KeyFrame(new Duration(14750), 
        new KeyValue(ballB.translateXProperty(), 700),
        new KeyValue(ballB.translateYProperty(), 365)
        ),
        new KeyFrame(new Duration(15000), 
        new KeyValue(ballB.translateXProperty(), 750),
        new KeyValue(ballB.translateYProperty(), 550)
        ),
        new KeyFrame(new Duration(15250), 
        new KeyValue(ballB.translateXProperty(), 800),
        new KeyValue(ballB.translateYProperty(), 365)
        ),
        new KeyFrame(new Duration(15500), 
        new KeyValue(ballB.translateXProperty(), 810),
        new KeyValue(ballB.translateYProperty(), 550)
        )
        );
        btimeline.play();
        
        
        GridPane grid2=new GridPane();
        grid2.setAlignment(Pos.CENTER);
        grid2.setHgap(10);
        grid2.setVgap(10);
        grid2.setPadding(new Insets(250,25,25,350));
        
        TextField textField = new TextField();
        Button btn= new Button("Times!");
          try {       
                PauseTransition wait=new PauseTransition(Duration.seconds(17));
                wait.setOnFinished((e)->{  
                
                grid2.add(textField,0,0);
                grid2.add(btn,0,1);
		});
                wait.play();
                }
                catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
          
        GridPane gchoice=new GridPane();
        gchoice.setAlignment(Pos.CENTER);
        gchoice.setHgap(10);
        gchoice.setVgap(10);
        gchoice.setPadding(new Insets(125,25,25,200));
          
            
          //Button Action
    btn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){ 
    btnPressed=1;
    String eqs = textField.getText();
    System.out.println("Ball hit the wall  = "+eqs);
    String ans ="4";
    if(ans.equalsIgnoreCase(eqs))
    {
    System.out.println("Right");
    ImageView choiceR= new ImageView("/thebr/InterMode/correct.png");
    gchoice.add(choiceR,5,3);
    TheBr obj= new TheBr();
    obj.Right(marks);
    btnPressed=1;	
            if(btnPressed==1)
            {
                autoSlide.stop();
                try {       
                PauseTransition wait=new PauseTransition(Duration.seconds(1));
                wait.setOnFinished((e)->{  
                obj.Imq2(primaryStage,marks);
				});
                wait.play();
                }
                catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
            }
    }
   
    else
    {
    System.out.println("Wrong");
    ImageView choiceW= new ImageView("/thebr/InterMode/wrong.png");
    gchoice.add(choiceW,5,3);
    TheBr obj= new TheBr();
    obj.Wrong(marks);
         btnPressed=1;	
            if(btnPressed==1)
            {
                autoSlide.stop();
                try {       
                PauseTransition wait=new PauseTransition(Duration.seconds(1));
                wait.setOnFinished((e)->{  
                obj.Imq2(primaryStage,marks);
				});
                wait.play();
                }
                catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
            }
    }
    }
    });
 
     //Admin control
 GridPane gridadmin = new GridPane();
 gridadmin.setAlignment(Pos.CENTER);
 gridadmin.setHgap(10);
 gridadmin.setVgap(10);
 gridadmin.setPadding(new Insets(0,0,0,0));
 gridadmin.setLayoutX(275);
 gridadmin.setLayoutY(550);
 TheBr obj = new TheBr();
if(admin==1)
{  
 autoSlide.stop();   
 Button prevbtn =new Button("", new ImageView("/thebr/AdminControl/previous.png"));
 gridadmin.add(prevbtn,0,0);
    prevbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Imq1(primaryStage,marks);
    }
    });

 Button relbtn =new Button("", new ImageView("/thebr/AdminControl/reload.png"));
 gridadmin.add(relbtn,1,0);
    relbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Imq1(primaryStage,marks);
    }
    });
 
 Button nextbtn = new Button("", new ImageView("/thebr/AdminControl/next.png"));
 gridadmin.add(nextbtn,2,0);
     nextbtn.setOnAction(new EventHandler<ActionEvent>() {
     public void handle(ActionEvent ae){
     obj.Imq2(primaryStage,marks);
     }
     });
     
 Button levelbtn =new Button("", new ImageView("/thebr/AdminControl/level.png"));
 gridadmin.add(levelbtn,3,0);
    levelbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Page2(primaryStage,marks);
    }
    });
}    
    
   //Adding Score View
        Text scrLbl = new Text("Score: ");
        scrLbl.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        scrLbl.setFill( Color.web("BLACK", 0.50) );
        scrLbl.setX(5);
        scrLbl.setY(595);
        
        String myscore= Double.toString(mrk);
        Text scrView= new Text();
        scrView.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
        scrView.setFill( Color.web("WHITE", 0.50) );
        scrView.setText(myscore);
        scrView.setX(63);
        scrView.setY(595);

//Adding close button
Button btnclose = new Button("",new ImageView("/thebr/AdminControl/close.png"));
btnclose.setId("btnclose");
btnclose.setTranslateX(750);
btnclose.setTranslateY(550);
    btnclose.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
        TheBr obj = new TheBr();
        obj.Marks(primaryStage,marks);
        voice.stop();
        autoSlide.stop();
    }
    });
        
Image imgb = new Image("/thebr/interback.jpg");
ImageView imgb1 = new ImageView(imgb);
root.getChildren().addAll(imgb1,linesW,linesO,linesR,grid1,grid2,ballB,sliderLine,sliderLine2,gridadmin,btnclose,scrLbl,scrView,gchoice);        

Scene scene = new Scene(root, 800, 600, Color.GRAY);
primaryStage.setResizable(false);
primaryStage.setScene(scene);
scene.getStylesheets().add(TheBr.class.getResource("inter.css").toExternalForm());			
primaryStage.getIcons().add(new Image("/thebr/TheBrainifyApp.jpg"));
primaryStage.show();
}


//Inetermediate mode Q2

public void Imq2(Stage primaryStage, double marks)
{
System.out.println("Reached Imq2");
    
Group root = new Group();
FlowPane rootNode= new FlowPane();
primaryStage.setTitle("The Brainify App- Intermediate Mode:"); 

    //Virtual Assistant
     MediaPlayer voice = new MediaPlayer(new Media(TheBr.class.getResource("virtualAssistant/Imq2.mp3").toString())); 
     voice.play();

//Timer Line       
        Group linesW = new Group();
        for(int i=0;i<1;i++)
        {
        Line whiteLine = new Line(0, 0, 780, 0);
        whiteLine.setStroke(Color.web("#4EFF00", 0.5));
        whiteLine.setStrokeWidth(40);
        whiteLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesW.getChildren().add(whiteLine);
        }
      
        Group linesO = new Group();
        for(int i=0;i<1;i++)
        {
        Line orangeLine = new Line(0, 0, 780, 0);
        orangeLine.setStroke(Color.web("#FF9900", 1.0));
        orangeLine.setStrokeWidth(40);
        orangeLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesO.getChildren().add(orangeLine);
        }
            
        Group linesR = new Group();
        for(int i=0;i<1;i++)
        {
        Line redLine = new Line(0, 0, 780, 0);
        redLine.setStroke(Color.web("#FF0000", 1.0));
        redLine.setStrokeWidth(40);
        redLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesR.getChildren().add(redLine);
        }
 
        
        Timeline timeline = new Timeline();
        for (Node whiteLine: linesW.getChildren()) 
        {
        timeline.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(whiteLine.translateXProperty(), -800),
        new KeyValue(whiteLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(18040), 
        new KeyValue(whiteLine.translateXProperty(), -320),
        new KeyValue(whiteLine.translateYProperty(), 0)
                )
                );
        }
        timeline.play();

        Timeline timeline1 = new Timeline();
        for (Node orangeLine: linesO.getChildren())
        {
        timeline1.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(18040), 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),        
        new KeyFrame(new Duration(18040), 
        new KeyValue(orangeLine.translateXProperty(), -320),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ), 
        
        new KeyFrame(new Duration(25550), 
        new KeyValue(orangeLine.translateXProperty(), -120),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    )
                    );
        }
        timeline1.play();

        Timeline timeline2 = new Timeline();
        for (Node redLine: linesR.getChildren())
        {
        timeline2.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(redLine.translateXProperty(), -800),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(25550),
        new KeyValue(redLine.translateXProperty(), -800),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),   
        new KeyFrame(new Duration(25550), 
        new KeyValue(redLine.translateXProperty(), -120),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),       
 
        new KeyFrame(new Duration(30000),
        new KeyValue(redLine.translateXProperty(), 0),
        new KeyValue(redLine.translateYProperty(), 0)
                    )
                    );
        }
        timeline2.play();  
        
        //Timer Lines END
        
        
               //Timer start, will skip if no button pressed
            System.out.println("btn pressed before timeline = "+ btnPressed);
            Timeline autoSlide = new Timeline(new KeyFrame(
            Duration.millis(30000),
            ae-> 
            { 
                if(btnPressed==0)
                {//Time out
                System.out.println("marks skipped = "+ marks);
                TheBr obj = new TheBr();
                obj.Imq3(primaryStage, marks);
                }
            }     
            ));
            autoSlide.play();      
            //End of auto Timer
     
GridPane grid1=new GridPane();
grid1.setAlignment(Pos.CENTER);
grid1.setHgap(10);
grid1.setVgap(10);
grid1.setPadding(new Insets(50,25,25,25));

Text queI1=new Text("\tQ2. Count the number of Flying Hearts?"); 
queI1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
grid1.add(queI1,0,0);        
        



Group hearts= new Group();
for(int i=0; i<10;i++)
{
    ImageView heartF= new ImageView("/thebr/InterMode/heartF.png");
    hearts.getChildren().add(heartF);
    
    ImageView heartFN= new ImageView("/thebr/InterMode/heartFN.png");
    hearts.getChildren().add(heartFN);
}
  
Timeline hfall= new Timeline();
for(Node heartFN: hearts.getChildren())  {
    hfall.getKeyFrames().addAll(
    new KeyFrame(Duration.ZERO,
    new KeyValue(heartFN.translateXProperty(), 350),
    new KeyValue(heartFN.translateYProperty(), 250)
    ),        
            
    new KeyFrame(new Duration(5000), 
    new KeyValue(heartFN.translateXProperty(), random()*750),
    new KeyValue(heartFN.translateYProperty(), 250)
    ),
    new KeyFrame(new Duration(15000), 
    new KeyValue(heartFN.translateXProperty(), random()*750),
    new KeyValue(heartFN.translateYProperty(), random()*550)
    ),
    new KeyFrame(new Duration(30000), 
new KeyValue(heartFN.translateXProperty(), random()*750),
new KeyValue(heartFN.translateYProperty(), random()*550)
            )
            );
    }
hfall.play();


        GridPane grid2=new GridPane();
        grid2.setAlignment(Pos.CENTER);
        grid2.setHgap(10);
        grid2.setVgap(10);
        grid2.setPadding(new Insets(250,25,25,350));
        
        TextField textField = new TextField();
        Button btn= new Button("Okay!");
          try {       
                PauseTransition wait=new PauseTransition(Duration.seconds(10));
                wait.setOnFinished((e)->{  
                
                grid2.add(textField,0,0);
                grid2.add(btn,0,1);
		});
                wait.play();
                }
                catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
          
         GridPane gchoice=new GridPane();
        gchoice.setAlignment(Pos.CENTER);
        gchoice.setHgap(10);
        gchoice.setVgap(10);
        gchoice.setPadding(new Insets(125,25,25,200));

      //Button Action
    btn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){ 
    btnPressed=1;
    String eqs = textField.getText();
    System.out.println("hearts  = "+eqs);
    String ans ="20";
    if(ans.equalsIgnoreCase(eqs))
    {
    System.out.println("Right");
    ImageView choiceR= new ImageView("/thebr/InterMode/correct.png");
    gchoice.add(choiceR,5,3);
    TheBr obj= new TheBr();
    obj.Right(marks);
    btnPressed=1;	
            if(btnPressed==1)
            {
                autoSlide.stop();
                try {       
                PauseTransition wait=new PauseTransition(Duration.seconds(1));
                wait.setOnFinished((e)->{  
                obj.Imq3(primaryStage,marks);
				});
                wait.play();
                }
                catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
            }
    }
   
    else
    {
    System.out.println("Wrong");
    ImageView choiceW= new ImageView("/thebr/InterMode/wrong.png");
    gchoice.add(choiceW,5,3);
    TheBr obj= new TheBr();
    obj.Wrong(marks);
         btnPressed=1;	
            if(btnPressed==1)
            {
                autoSlide.stop();
                try {       
                PauseTransition wait=new PauseTransition(Duration.seconds(1));
                wait.setOnFinished((e)->{  
                obj.Imq3(primaryStage,marks);
				});
                wait.play();
                }
                catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
            }
    }
    }
    });

     //Admin control
 GridPane gridadmin = new GridPane();
 gridadmin.setAlignment(Pos.CENTER);
 gridadmin.setHgap(10);
 gridadmin.setVgap(10);
 gridadmin.setPadding(new Insets(0,0,0,0));
 gridadmin.setLayoutX(275);
 gridadmin.setLayoutY(550);
 TheBr obj = new TheBr();
if(admin==1)
{  
 autoSlide.stop();   
 Button prevbtn =new Button("", new ImageView("/thebr/AdminControl/previous.png"));
 gridadmin.add(prevbtn,0,0);
    prevbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Imq1(primaryStage,marks);
    }
    });

 Button relbtn =new Button("", new ImageView("/thebr/AdminControl/reload.png"));
 gridadmin.add(relbtn,1,0);
    relbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Imq2(primaryStage,marks);
    }
    });
 
 Button nextbtn = new Button("", new ImageView("/thebr/AdminControl/next.png"));
 gridadmin.add(nextbtn,2,0);
     nextbtn.setOnAction(new EventHandler<ActionEvent>() {
     public void handle(ActionEvent ae){
     obj.Imq3(primaryStage,marks);
     }
     });
     
 Button levelbtn =new Button("", new ImageView("/thebr/AdminControl/level.png"));
 gridadmin.add(levelbtn,3,0);
    levelbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Page2(primaryStage,marks);
    }
    });
}    
        
   //Adding Score View
        Text scrLbl = new Text("Score: ");
        scrLbl.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        scrLbl.setFill( Color.web("BLACK", 0.50) );
        scrLbl.setX(5);
        scrLbl.setY(595);
        
        String myscore= Double.toString(mrk);
        Text scrView= new Text();
        scrView.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
        scrView.setFill( Color.web("WHITE", 0.50) );
        scrView.setText(myscore);
        scrView.setX(63);
        scrView.setY(595);

//Adding close button
Button btnclose = new Button("",new ImageView("/thebr/AdminControl/close.png"));
btnclose.setId("btnclose");
btnclose.setTranslateX(750);
btnclose.setTranslateY(550);
    btnclose.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
        TheBr obj = new TheBr();
        obj.Marks(primaryStage,marks);
        voice.stop();
        autoSlide.stop();
    }
    }); 

Image imgb = new Image("/thebr/interback.jpg");
ImageView imgb1 = new ImageView(imgb);
root.getChildren().addAll(imgb1,linesW,linesO,linesR,grid1,hearts,grid2,gridadmin,btnclose,scrLbl,scrView,gchoice);        

Scene scene = new Scene(root, 800, 600, Color.GRAY);
primaryStage.setResizable(false);
primaryStage.setScene(scene);
scene.getStylesheets().add(TheBr.class.getResource("inter.css").toExternalForm());			
primaryStage.getIcons().add(new Image("/thebr/TheBrainifyApp.jpg"));
primaryStage.show();
}



//Inetermediate mode Q3
private String b2 ="";
private static int bClicks = 0;
public void Imq3(Stage primaryStage, double marks)
{
System.out.println("Reached Imq3");
    
Group root = new Group();
FlowPane rootNode= new FlowPane();
primaryStage.setTitle("The Brainify App- Intermediate Mode:"); 

    //Virtual Assistant
     MediaPlayer voice = new MediaPlayer(new Media(TheBr.class.getResource("virtualAssistant/Imq3.mp3").toString())); 
     voice.play();

//Timer Line       
        Group linesW = new Group();
        for(int i=0;i<1;i++)
        {
        Line whiteLine = new Line(0, 0, 780, 0);
        whiteLine.setStroke(Color.web("#4EFF00", 0.5));
        whiteLine.setStrokeWidth(40);
        whiteLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesW.getChildren().add(whiteLine);
        }
      
        Group linesO = new Group();
        for(int i=0;i<1;i++)
        {
        Line orangeLine = new Line(0, 0, 780, 0);
        orangeLine.setStroke(Color.web("#FF9900", 1.0));
        orangeLine.setStrokeWidth(40);
        orangeLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesO.getChildren().add(orangeLine);
        }
            
        Group linesR = new Group();
        for(int i=0;i<1;i++)
        {
        Line redLine = new Line(0, 0, 780, 0);
        redLine.setStroke(Color.web("#FF0000", 1.0));
        redLine.setStrokeWidth(40);
        redLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesR.getChildren().add(redLine);
        }
 
        
        Timeline timeline = new Timeline();
        for (Node whiteLine: linesW.getChildren()) 
        {
        timeline.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(whiteLine.translateXProperty(), -800),
        new KeyValue(whiteLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(18040), 
        new KeyValue(whiteLine.translateXProperty(), -320),
        new KeyValue(whiteLine.translateYProperty(), 0)
                )
                );
        }
        timeline.play();

        Timeline timeline1 = new Timeline();
        for (Node orangeLine: linesO.getChildren())
        {
        timeline1.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(18040), 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),        
        new KeyFrame(new Duration(18040), 
        new KeyValue(orangeLine.translateXProperty(), -320),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ), 
        
        new KeyFrame(new Duration(25550), 
        new KeyValue(orangeLine.translateXProperty(), -120),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    )
                    );
        }
        timeline1.play();

        Timeline timeline2 = new Timeline();
        for (Node redLine: linesR.getChildren())
        {
        timeline2.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(redLine.translateXProperty(), -800),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(25550),
        new KeyValue(redLine.translateXProperty(), -800),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),   
        new KeyFrame(new Duration(25550), 
        new KeyValue(redLine.translateXProperty(), -120),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),       
 
        new KeyFrame(new Duration(30000),
        new KeyValue(redLine.translateXProperty(), 0),
        new KeyValue(redLine.translateYProperty(), 0)
                    )
                    );
        }
        timeline2.play();  
        
        //Timer Lines END
        
        
               //Timer start, will skip if no button pressed
            System.out.println("btn pressed before timeline = "+ btnPressed);
            Timeline autoSlide = new Timeline(new KeyFrame(
            Duration.millis(30000),
            ae-> 
            { 
                if(btnPressed==0)
                {//Time out
                System.out.println("marks skipped = "+ marks);
                TheBr obj = new TheBr();
                obj.Imq4(primaryStage, marks);
                }
            }     
            ));
            autoSlide.play();      
            //End of auto Timer
            
            
        GridPane grid0=new GridPane();
        grid0.setAlignment(Pos.CENTER);
        grid0.setHgap(10);
        grid0.setVgap(10);
        grid0.setPadding(new Insets(125,25,25,175));
            
GridPane grid1=new GridPane();
grid1.setAlignment(Pos.CENTER);
grid1.setHgap(10);
grid1.setVgap(10);
grid1.setPadding(new Insets(25,25,25,25));   

        GridPane gchoice=new GridPane();
        gchoice.setAlignment(Pos.CENTER);
        gchoice.setHgap(10);
        gchoice.setVgap(10);
        gchoice.setPadding(new Insets(150,25,25,250));
            
Text queI3=new Text("Q3. What's the binary value of 73 ?"); 
queI3.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
grid0.add(queI3,0,0);
TheBr obj = new TheBr();
String binary[]={"0","1"};


        GridPane grid2=new GridPane();
        grid2.setAlignment(Pos.CENTER);
        grid2.setHgap(10);
        grid2.setVgap(10);
        grid2.setPadding(new Insets(25,25,25,25));
        grid0.add(grid2,0,3);

for(int i=0;i<2;i++)
{
    Button btn= new Button(binary[i]);
    btn.setId("Iq3btn");
    
    btn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae) {
        bClicks++;
        Text act = new Text();
        act.setId("actiontargetB");
        act.setText(btn.getText());
        
            String s1= btn.getText();
            b2=b2.concat(s1);
            System.out.println("WC "+ b2);
            if(b2.equals("1001001")&&(b2.length()==7))
            {
                System.out.println("Right");
                ImageView choiceR= new ImageView("/thebr/InterMode/correct.png");
                gchoice.add(choiceR,0,0);
                rightPlayer.play();
                obj.Right(marks);
                btnPressed=1;	
            if(btnPressed==1)
            {
                autoSlide.stop();
                try {       
                PauseTransition wait=new PauseTransition(Duration.seconds(1));
                wait.setOnFinished((e)->{  
                obj.Imq4(primaryStage,marks);
				});
                wait.play();
                }
                catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
            }
            }
        else if(b2.length()==7)
                {
                System.out.println("Wrong");
                ImageView choiceW= new ImageView("/thebr/InterMode/wrong.png");
                gchoice.add(choiceW,0,0);
                wrongPlayer.play();
                obj.Wrong(marks);
                btnPressed=1;	
            if(btnPressed==1)
            {
                    autoSlide.stop();
                try {       
                PauseTransition wait=new PauseTransition(Duration.seconds(1));
                wait.setOnFinished((e)->{  
                obj.Imq4(primaryStage,marks);
				});
                wait.play();
                }
                catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
            }
            }
            else{
                System.out.println("Word is:- "+s2);
            }
            
            grid2.add(act,bClicks,0);
             
         }
        });

         grid1.add(btn,i,1);
        }
        grid0.add(grid1,0,2);
             
  //  grid0.setGridLinesVisible(true);
  //  grid1.setGridLinesVisible(true);
  //  grid2.setGridLinesVisible(true);
  
     //Admin control
 GridPane gridadmin = new GridPane();
 gridadmin.setAlignment(Pos.CENTER);
 gridadmin.setHgap(10);
 gridadmin.setVgap(10);
 gridadmin.setPadding(new Insets(0,0,0,0));
 gridadmin.setLayoutX(275);
 gridadmin.setLayoutY(550);
if(admin==1)
{  
 autoSlide.stop();   
 Button prevbtn =new Button("", new ImageView("/thebr/AdminControl/previous.png"));
 gridadmin.add(prevbtn,0,0);
    prevbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Imq2(primaryStage,marks);
    }
    });

 Button relbtn =new Button("", new ImageView("/thebr/AdminControl/reload.png"));
 gridadmin.add(relbtn,1,0);
    relbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Imq3(primaryStage,marks);
    }
    });
 
 Button nextbtn = new Button("", new ImageView("/thebr/AdminControl/next.png"));
 gridadmin.add(nextbtn,2,0);
     nextbtn.setOnAction(new EventHandler<ActionEvent>() {
     public void handle(ActionEvent ae){
     obj.Imq4(primaryStage,marks);
     }
     });
     
 Button levelbtn =new Button("", new ImageView("/thebr/AdminControl/level.png"));
 gridadmin.add(levelbtn,3,0);
    levelbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Page2(primaryStage,marks);
    }
    });
}      

   //Adding Score View
        Text scrLbl = new Text("Score: ");
        scrLbl.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        scrLbl.setFill( Color.web("BLACK", 0.50) );
        scrLbl.setX(5);
        scrLbl.setY(595);
        
        String myscore= Double.toString(mrk);
        Text scrView= new Text();
        scrView.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
        scrView.setFill( Color.web("WHITE", 0.50) );
        scrView.setText(myscore);
        scrView.setX(63);
        scrView.setY(595);

//Adding close button
Button btnclose = new Button("",new ImageView("/thebr/AdminControl/close.png"));
btnclose.setId("btnclose");
btnclose.setTranslateX(750);
btnclose.setTranslateY(550);
    btnclose.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
        TheBr obj = new TheBr();
        obj.Marks(primaryStage,marks);
        voice.stop();
        autoSlide.stop();
        autoSlide.stop();
    }
    });

Image imgb = new Image("/thebr/interback.jpg");
ImageView imgb1 = new ImageView(imgb);
root.getChildren().addAll(imgb1,linesW,linesO,linesR,grid0,gridadmin,btnclose,scrLbl,scrView,gchoice);        

Scene scene = new Scene(root, 800, 600, Color.GRAY);
primaryStage.setResizable(false);
primaryStage.setScene(scene);
scene.getStylesheets().add(TheBr.class.getResource("inter.css").toExternalForm());			
primaryStage.getIcons().add(new Image("/thebr/TheBrainifyApp.jpg"));
primaryStage.show();
}



//Inetermediate mode Q4
public void Imq4(Stage primaryStage, double marks)
{
System.out.println("Reached Imq1");
    
Group root = new Group();
FlowPane rootNode= new FlowPane();
primaryStage.setTitle("The Brainify App- Intermediate Mode:");

    //Virtual Assistant
     MediaPlayer voice = new MediaPlayer(new Media(TheBr.class.getResource("virtualAssistant/Imq4.mp3").toString())); 
     voice.play();

//Timer Line       
        Group linesW = new Group();
        for(int i=0;i<1;i++)
        {
        Line whiteLine = new Line(0, 0, 780, 0);
        whiteLine.setStroke(Color.web("#4EFF00", 0.5));
        whiteLine.setStrokeWidth(40);
        whiteLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesW.getChildren().add(whiteLine);
        }
      
        Group linesO = new Group();
        for(int i=0;i<1;i++)
        {
        Line orangeLine = new Line(0, 0, 780, 0);
        orangeLine.setStroke(Color.web("#FF9900", 1.0));
        orangeLine.setStrokeWidth(40);
        orangeLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesO.getChildren().add(orangeLine);
        }
            
        Group linesR = new Group();
        for(int i=0;i<1;i++)
        {
        Line redLine = new Line(0, 0, 780, 0);
        redLine.setStroke(Color.web("#FF0000", 1.0));
        redLine.setStrokeWidth(40);
        redLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesR.getChildren().add(redLine);
        }
 
        
        Timeline timeline = new Timeline();
        for (Node whiteLine: linesW.getChildren()) 
        {
        timeline.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(whiteLine.translateXProperty(), -800),
        new KeyValue(whiteLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(18040), 
        new KeyValue(whiteLine.translateXProperty(), -320),
        new KeyValue(whiteLine.translateYProperty(), 0)
                )
                );
        }
        timeline.play();

        Timeline timeline1 = new Timeline();
        for (Node orangeLine: linesO.getChildren())
        {
        timeline1.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(18040), 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),        
        new KeyFrame(new Duration(18040), 
        new KeyValue(orangeLine.translateXProperty(), -320),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ), 
        
        new KeyFrame(new Duration(25550), 
        new KeyValue(orangeLine.translateXProperty(), -120),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    )
                    );
        }
        timeline1.play();

        Timeline timeline2 = new Timeline();
        for (Node redLine: linesR.getChildren())
        {
        timeline2.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(redLine.translateXProperty(), -800),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(25550),
        new KeyValue(redLine.translateXProperty(), -800),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),   
        new KeyFrame(new Duration(25550), 
        new KeyValue(redLine.translateXProperty(), -120),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),       
 
        new KeyFrame(new Duration(30000),
        new KeyValue(redLine.translateXProperty(), 0),
        new KeyValue(redLine.translateYProperty(), 0)
                    )
                    );
        }
        timeline2.play();  
        
        //Timer Lines END
        
        
               //Timer start, will skip if no button pressed
            System.out.println("btn pressed before timeline = "+ btnPressed);
            Timeline autoSlide = new Timeline(new KeyFrame(
            Duration.millis(30000),
            ae-> 
            { 
                if(btnPressed==0)
                {//Time out
                System.out.println("marks skipped = "+ marks);
                TheBr obj = new TheBr();
                obj.Imq5(primaryStage, marks);
                }
            }     
            ));
            autoSlide.play();      
            //End of auto Timer
            
GridPane grid1=new GridPane();
grid1.setAlignment(Pos.CENTER);
grid1.setHgap(10);
grid1.setVgap(10);
grid1.setPadding(new Insets(125,25,25,225));   

        GridPane gchoice=new GridPane();
        gchoice.setAlignment(Pos.CENTER);
        gchoice.setHgap(10);
        gchoice.setVgap(10);
        gchoice.setPadding(new Insets(150,25,25,250));
            
Text queI4=new Text("Q4. Where is the ball ?"); 
queI4.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
grid1.add(queI4,0,0);
            
ImageView gbox1 = new ImageView("/thebr/InterMode/gbox.png");
ImageView gbox2 = new ImageView("/thebr/InterMode/gbox.png");
ImageView gbox3 = new ImageView("/thebr/InterMode/gbox.png");
ImageView ball = new ImageView("/thebr/InterMode/ball.png");

//Falling of Ball
Timeline bfall = new Timeline();
bfall.getKeyFrames().addAll(
    new KeyFrame(Duration.ZERO,
    new KeyValue(ball.translateXProperty(),370),
    new KeyValue(ball.translateYProperty(),-50)
                ),
    new KeyFrame(new Duration(4000),
    new KeyValue(ball.translateXProperty(),370),
    new KeyValue(ball.translateYProperty(),-50)
                ),
    new KeyFrame(new Duration(5000),
    new KeyValue(ball.translateXProperty(),370),
    new KeyValue(ball.translateYProperty(),425)
                ),
    new KeyFrame(new Duration(8000),
    new KeyValue(ball.translateXProperty(),370),
    new KeyValue(ball.translateYProperty(),425)
                ),
    new KeyFrame(new Duration(8000),
    new KeyValue(ball.translateXProperty(),370),
    new KeyValue(ball.translateYProperty(),-50)
                ),   
    new KeyFrame(new Duration(30000),
    new KeyValue(ball.translateXProperty(),370),
    new KeyValue(ball.translateYProperty(),-50)
                )
                );
                bfall.play();
                
//box 1
Timeline box1 = new Timeline();
box1.getKeyFrames().addAll(
    new KeyFrame(Duration.ZERO,
    new KeyValue(gbox1.translateXProperty(),125),
    new KeyValue(gbox1.translateYProperty(),-100)
                ),
    new KeyFrame(new Duration(7000),
    new KeyValue(gbox1.translateXProperty(),125),
    new KeyValue(gbox1.translateYProperty(),-100)
                ),
    new KeyFrame(new Duration(8000),
    new KeyValue(gbox1.translateXProperty(),125),
    new KeyValue(gbox1.translateYProperty(),400)
                )
                );
                box1.play();
                
                
 //box 2
Timeline box2 = new Timeline();
box2.getKeyFrames().addAll(
    new KeyFrame(Duration.ZERO,
    new KeyValue(gbox2.translateXProperty(),350),
    new KeyValue(gbox2.translateYProperty(),-100)
                ),
    new KeyFrame(new Duration(7000),
    new KeyValue(gbox2.translateXProperty(),350),
    new KeyValue(gbox2.translateYProperty(),-100)
                ),
    new KeyFrame(new Duration(8000),
    new KeyValue(gbox2.translateXProperty(),350),
    new KeyValue(gbox2.translateYProperty(),400)
                )
                );
                box2.play();    
                
    //box 3
    Timeline box3 = new Timeline();
    box3.getKeyFrames().addAll(
    new KeyFrame(Duration.ZERO,
    new KeyValue(gbox3.translateXProperty(),575),
    new KeyValue(gbox3.translateYProperty(),-100)
                ),
    new KeyFrame(new Duration(7000),
    new KeyValue(gbox3.translateXProperty(),575),
    new KeyValue(gbox3.translateYProperty(),-100)
                ),
    new KeyFrame(new Duration(8000),
    new KeyValue(gbox3.translateXProperty(),575),
    new KeyValue(gbox3.translateYProperty(),400)
                )
                );
                box3.play();    
                
     //For gbox1         
     PathElement[] path1=
     {
         new MoveTo(175, 450),
         new LineTo(175,450),
         new LineTo(625,450),
         new LineTo(175,450)
     };
     
     Path road1 = new Path();
     road1.setStrokeWidth(1);
     road1.getElements().addAll(path1);
        
      PathTransition anim1 = new PathTransition();
      anim1.setNode(gbox1);
      anim1.setPath(road1);
      
      //anim.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
      anim1.setInterpolator(Interpolator.LINEAR);
      anim1.setDuration(new Duration(8568));
      anim1.setCycleCount(1); 
      
      //for gbox 2
      PathElement [] path2= 
     {
         new MoveTo(400,450),
         new LineTo(625,450),
         new LineTo(175,450),
         new LineTo(400,450),
         new LineTo(175,450),
         new LineTo(625,450)
     };
     
     Path road2 = new Path();
     road2.setStrokeWidth(0);
     road2.getElements().addAll(path2);
     
      PathTransition anim2 = new PathTransition();
      anim2.setNode(gbox2);
      anim2.setPath(road2);
      
      //anim.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
      anim2.setInterpolator(Interpolator.EASE_BOTH);
      anim2.setDuration(new Duration(15000));
      anim2.setCycleCount(1); 
      
      //for gbox3
      PathElement[] path3=
      {
          new MoveTo(625,450),
          new LineTo(400,450),
          new LineTo(175,450),
          new LineTo(400,450),
       };
     Path road3 = new Path();
     road3.setStrokeWidth(0);
     road3.getElements().addAll(path3);
     
     PathTransition anim3 = new PathTransition();
     anim3.setNode(gbox3);
     anim3.setPath(road3);
     
     anim3.setInterpolator(Interpolator.EASE_BOTH);
     anim3.setDuration(new Duration (6426));
     anim3.setCycleCount(1);
     
      //Adding anim play schedule time
            try {       
                PauseTransition wait=new PauseTransition(Duration.millis(10000));
                wait.setOnFinished((e)->{
                anim2.play();
                anim3.play();
                });
                wait.play();
                } 
                catch(Exception e){
		System.out.println("Error anim play!");
                } 
            
            try {       
                PauseTransition wait=new PauseTransition(Duration.millis(12142));
                wait.setOnFinished((e)->{
                anim1.play();
                anim3.pause();
                });
                wait.play();
                } 
                catch(Exception e){
		System.out.println("Error anim play!");
                } 
            try {       
                PauseTransition wait=new PauseTransition(Duration.millis(16427));
                wait.setOnFinished((e)->{
                anim1.pause();
                anim3.play();
                });
                wait.play();
                } 
                catch(Exception e){
		System.out.println("Error anim play!");
                } 
            
            try {       
                PauseTransition wait=new PauseTransition(Duration.millis(20712));
                wait.setOnFinished((e)->{
                anim1.play();
                anim3.pause();
                });
                wait.play();
                } 
                catch(Exception e){
		System.out.println("Error anim play!");
                }
            //End of animation
            
            //Button
            
        GridPane grid2=new GridPane();
        grid2.setAlignment(Pos.CENTER);
        grid2.setHgap(10);
        grid2.setVgap(10);
        grid2.setPadding(new Insets(250,25,25,350));
        
        TextField textField = new TextField();
        Button btn= new Button("Okay!");
        Text gb1 = new Text();
        Text gb2 = new Text();
        Text gb3 = new Text();
          try {       
                PauseTransition wait=new PauseTransition(Duration.millis(25000));
                wait.setOnFinished((e)->{  
                
                
                gb1.setText("1");
                gb1.setId("actiontargetB");
                gb1.setX(150);
                gb1.setY(475);
                
                
                gb2.setText("2");
                gb2.setId("actiontargetB");
                gb2.setX(375);
                gb2.setY(475);
                
                
                gb3.setText("3");
                gb3.setId("actiontargetB");
                gb3.setX(600);
                gb3.setY(475);
                
                grid2.add(textField,0,0);
                grid2.add(btn,0,1);
		});
                wait.play();
                }
                catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
          //Button Action
    btn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){ 
    btnPressed=1;
    String eqs = textField.getText();
    String ans ="3";
    if(ans.equalsIgnoreCase(eqs))
    {
    System.out.println("Right");
    ImageView choiceR= new ImageView("/thebr/InterMode/correct.png");
    gchoice.add(choiceR,5,3);
    TheBr obj= new TheBr();
    obj.Right(marks);
    btnPressed=1;	
            if(btnPressed==1)
            {
                autoSlide.stop();
                try {       
                PauseTransition wait=new PauseTransition(Duration.seconds(1));
                wait.setOnFinished((e)->{  
                obj.Imq5(primaryStage,marks);
				});
                wait.play();
                }
                catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
            }
    }
   
    else
    {
    System.out.println("Wrong");
    ImageView choiceW= new ImageView("/thebr/InterMode/wrong.png");
    gchoice.add(choiceW,5,3);
    TheBr obj= new TheBr();
    obj.Wrong(marks);
         btnPressed=1;	
            if(btnPressed==1)
            {
                autoSlide.stop();
                try {       
                PauseTransition wait=new PauseTransition(Duration.seconds(1));
                wait.setOnFinished((e)->{  
                obj.Imq5(primaryStage,marks);
				});
                wait.play();
                }
                catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
            }
    }
    }
    });
    
    
     //Admin control
 GridPane gridadmin = new GridPane();
 gridadmin.setAlignment(Pos.CENTER);
 gridadmin.setHgap(10);
 gridadmin.setVgap(10);
 gridadmin.setPadding(new Insets(0,0,0,0));
 gridadmin.setLayoutX(275);
 gridadmin.setLayoutY(550);
 TheBr obj = new TheBr();
if(admin==1)
{  
 autoSlide.stop();   
 Button prevbtn =new Button("", new ImageView("/thebr/AdminControl/previous.png"));
 gridadmin.add(prevbtn,0,0);
    prevbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Imq3(primaryStage,marks);
    }
    });

 Button relbtn =new Button("", new ImageView("/thebr/AdminControl/reload.png"));
 gridadmin.add(relbtn,1,0);
    relbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Imq4(primaryStage,marks);
    }
    });
 
 Button nextbtn = new Button("", new ImageView("/thebr/AdminControl/next.png"));
 gridadmin.add(nextbtn,2,0);
     nextbtn.setOnAction(new EventHandler<ActionEvent>() {
     public void handle(ActionEvent ae){
     obj.Imq5(primaryStage,marks);
     }
     });
     
 Button levelbtn =new Button("", new ImageView("/thebr/AdminControl/level.png"));
 gridadmin.add(levelbtn,3,0);
    levelbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Page2(primaryStage,marks);
    }
    });
}        
   //Adding Score View
        Text scrLbl = new Text("Score: ");
        scrLbl.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        scrLbl.setFill( Color.web("BLACK", 0.50) );
        scrLbl.setX(5);
        scrLbl.setY(595);
        
        String myscore= Double.toString(mrk);
        Text scrView= new Text();
        scrView.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
        scrView.setFill( Color.web("WHITE", 0.50) );
        scrView.setText(myscore);
        scrView.setX(63);
        scrView.setY(595);

//Adding close button
Button btnclose = new Button("",new ImageView("/thebr/AdminControl/close.png"));
btnclose.setId("btnclose");
btnclose.setTranslateX(750);
btnclose.setTranslateY(550);
    btnclose.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
        TheBr obj = new TheBr();
        obj.Marks(primaryStage,marks);
        voice.stop();
        autoSlide.stop();
        autoSlide.stop();
    }
    });    
  
Image imgb = new Image("/thebr/interback.jpg");
ImageView imgb1 = new ImageView(imgb);
root.getChildren().addAll(imgb1,linesW,linesO,linesR,grid1,ball,gbox1,gbox2,gbox3,grid2,gb1,gb2,gb3,gridadmin,btnclose,scrLbl,scrView,gchoice);        

Scene scene = new Scene(root, 800, 600, Color.GRAY);
primaryStage.setResizable(false);
primaryStage.setScene(scene);
scene.getStylesheets().add(TheBr.class.getResource("inter.css").toExternalForm());			
primaryStage.getIcons().add(new Image("/thebr/TheBrainifyApp.jpg"));
primaryStage.show();
}  


//Inetermediate mode Q5
public void Imq5(Stage primaryStage, double marks)
{
System.out.println("Reached Imq1");
    
Group root = new Group();
FlowPane rootNode= new FlowPane();
primaryStage.setTitle("The Brainify App- Intermediate mode:"); 

    //Virtual Assistant
     MediaPlayer voice = new MediaPlayer(new Media(TheBr.class.getResource("virtualAssistant/Imq5.mp3").toString())); 
     voice.play();

//Timer Line       
        Group linesW = new Group();
        for(int i=0;i<1;i++)
        {
        Line whiteLine = new Line(0, 0, 780, 0);
        whiteLine.setStroke(Color.web("#4EFF00", 0.5));
        whiteLine.setStrokeWidth(40);
        whiteLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesW.getChildren().add(whiteLine);
        }
      
        Group linesO = new Group();
        for(int i=0;i<1;i++)
        {
        Line orangeLine = new Line(0, 0, 780, 0);
        orangeLine.setStroke(Color.web("#FF9900", 1.0));
        orangeLine.setStrokeWidth(40);
        orangeLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesO.getChildren().add(orangeLine);
        }
            
        Group linesR = new Group();
        for(int i=0;i<1;i++)
        {
        Line redLine = new Line(0, 0, 780, 0);
        redLine.setStroke(Color.web("#FF0000", 1.0));
        redLine.setStrokeWidth(40);
        redLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesR.getChildren().add(redLine);
        }
 
        
        Timeline timeline = new Timeline();
        for (Node whiteLine: linesW.getChildren()) 
        {
        timeline.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(whiteLine.translateXProperty(), -800),
        new KeyValue(whiteLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(18040), 
        new KeyValue(whiteLine.translateXProperty(), -320),
        new KeyValue(whiteLine.translateYProperty(), 0)
                )
                );
        }
        timeline.play();

        Timeline timeline1 = new Timeline();
        for (Node orangeLine: linesO.getChildren())
        {
        timeline1.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(18040), 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),        
        new KeyFrame(new Duration(18040), 
        new KeyValue(orangeLine.translateXProperty(), -320),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ), 
        
        new KeyFrame(new Duration(25550), 
        new KeyValue(orangeLine.translateXProperty(), -120),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    )
                    );
        }
        timeline1.play();

        Timeline timeline2 = new Timeline();
        for (Node redLine: linesR.getChildren())
        {
        timeline2.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(redLine.translateXProperty(), -800),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(25550),
        new KeyValue(redLine.translateXProperty(), -800),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),   
        new KeyFrame(new Duration(25550), 
        new KeyValue(redLine.translateXProperty(), -120),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),       
 
        new KeyFrame(new Duration(30000),
        new KeyValue(redLine.translateXProperty(), 0),
        new KeyValue(redLine.translateYProperty(), 0)
                    )
                    );
        }
        timeline2.play();  
        
        //Timer Lines END
        
        
               //Timer start, will skip if no button pressed
            System.out.println("btn pressed before timeline = "+ btnPressed);
            Timeline autoSlide = new Timeline(new KeyFrame(
            Duration.millis(30000),
            ae-> 
            { 
                if(btnPressed==0)
                {//Time out
                System.out.println("marks skipped = "+ marks);
                TheBr obj = new TheBr();
                obj.Imq6(primaryStage, marks);
                }
            }     
            ));
            autoSlide.play();      
            //End of auto Timer
            
            
Text queI5=new Text("Q5. Which one jumps higher than all?"); 
queI5.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
queI5.setX(100);
queI5.setY(100);

Line stand = new Line(100,520,700,520);
stand.setId("ballStrike");
stand.setStrokeWidth(10);
stand.setStrokeLineCap(StrokeLineCap.ROUND);
stand.setStrokeDashOffset(0);


ImageView bbase = new ImageView("/thebr/InterMode/bbase.png");
bbase.setY(-50);
ImageView bbasket = new ImageView("/thebr/InterMode/bbasket.png");
bbasket.setY(-50);
ImageView bgolf = new ImageView("/thebr/InterMode/bgolf.png");
bgolf.setY(-50);
ImageView bsoccer = new ImageView("/thebr/InterMode/bsoccer.png");
bsoccer.setY(-50);
ImageView btennis = new ImageView("/thebr/InterMode/btennis.png");
btennis.setY(-50);

PathElement [] path1=
{
    new MoveTo(133,190),
    new LineTo(133,190),
    new LineTo(133,500)
};
Path road1 = new Path();
road1.setStrokeWidth(0);
road1.getElements().addAll(path1);

PathTransition anim1= new PathTransition();
anim1.setNode(bbase);
anim1.setPath(road1);
anim1.setInterpolator(Interpolator.EASE_IN);
anim1.setAutoReverse(true);
anim1.setDelay(new Duration(1000));
anim1.setDuration(new Duration(2000));
anim1.setCycleCount(Timeline.INDEFINITE);
anim1.play();

PathElement [] path2=
{
    new MoveTo(266,210),
    new LineTo(266,210),
    new LineTo(266,500)
};
Path road2 = new Path();
road2.setStrokeWidth(0);
road2.getElements().addAll(path2);

PathTransition anim2= new PathTransition();
anim2.setNode(bbasket);
anim2.setPath(road2);
anim2.setInterpolator(Interpolator.EASE_IN);
anim2.setAutoReverse(true);
anim2.setDelay(new Duration(2000));
anim2.setDuration(new Duration(2000));
anim2.setCycleCount(Timeline.INDEFINITE);
anim2.play();

PathElement [] path3=
{
    new MoveTo(399,200),
    new LineTo(399,200),
    new LineTo(399,500)
};
Path road3 = new Path();
road3.setStrokeWidth(0);
road3.getElements().addAll(path3);

PathTransition anim3= new PathTransition();
anim3.setNode(bgolf);
anim3.setPath(road3);
anim3.setInterpolator(Interpolator.EASE_IN);
anim3.setAutoReverse(true);
anim3.setDelay(new Duration(3000));
anim3.setDuration(new Duration(2000));
anim3.setCycleCount(Timeline.INDEFINITE);
anim3.play();

PathElement [] path4=
{
    new MoveTo(532,175),
    new LineTo(532,175),
    new LineTo(532,500)
};
Path road4 = new Path();
road4.setStrokeWidth(0);
road4.getElements().addAll(path4);

PathTransition anim4= new PathTransition();
anim4.setNode(bsoccer);
anim4.setPath(road4);
anim4.setInterpolator(Interpolator.EASE_IN);
anim4.setAutoReverse(true);
anim4.setDelay(new Duration(4000));
anim4.setDuration(new Duration(2000));
anim4.setCycleCount(Timeline.INDEFINITE);
anim4.play();

PathElement [] path5=
{
    new MoveTo(665,220),
    new LineTo(665,220),
    new LineTo(665,500)
};
Path road5 = new Path();
road5.setStrokeWidth(0);
road5.getElements().addAll(path5);

PathTransition anim5= new PathTransition();
anim5.setNode(btennis);
anim5.setPath(road5);
anim5.setInterpolator(Interpolator.EASE_IN);
anim5.setAutoReverse(true);
anim5.setDelay(new Duration(5000));
anim5.setDuration(new Duration(2000));
anim5.setCycleCount(Timeline.INDEFINITE);
anim5.play();

                            //Button
            
        GridPane grid2=new GridPane();
        grid2.setAlignment(Pos.CENTER);
        grid2.setHgap(10);
        grid2.setVgap(10);
        grid2.setPadding(new Insets(250,25,25,300));
        
        TextField textField = new TextField();
        Button btn= new Button("Okay!");
        Text gb1 = new Text();
        Text gb2 = new Text();
        Text gb3 = new Text();
        Text gb4 = new Text();
        Text gb5 = new Text();

          try {       
                PauseTransition wait=new PauseTransition(Duration.millis(15000));
                wait.setOnFinished((e)->{  
                
                
                gb1.setText("a");
                gb1.setId("actiontargetT");
                gb1.setX(113);
                gb1.setY(570);
                
                
                gb2.setText("b");
                gb2.setId("actiontargetT");
                gb2.setX(246);
                gb2.setY(570);
                
                
                gb3.setText("c");
                gb3.setId("actiontargetT");
                gb3.setX(379);
                gb3.setY(570);
                
                gb4.setText("d");
                gb4.setId("actiontargetT");
                gb4.setX(512);
                gb4.setY(570);
                
                gb5.setText("e");
                gb5.setId("actiontargetT");
                gb5.setX(645);
                gb5.setY(570);
                
                grid2.add(textField,0,0);
                grid2.add(btn,0,1);
		});
                wait.play();
                }
                catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
      
        GridPane gchoice=new GridPane();
        gchoice.setAlignment(Pos.CENTER);
        gchoice.setHgap(10);
        gchoice.setVgap(10);
        gchoice.setPadding(new Insets(150,25,25,250));
                    //Button Action
    btn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){ 
    btnPressed=1;
    String eqs = textField.getText();
    String ans ="d";
    if(ans.equalsIgnoreCase(eqs))
    {
    System.out.println("Right");
    ImageView choiceR= new ImageView("/thebr/InterMode/correct.png");
    gchoice.add(choiceR,5,3);
    TheBr obj= new TheBr();
    obj.Right(marks);
    btnPressed=1;	
            if(btnPressed==1)
            {
                autoSlide.stop();
                try {       
                PauseTransition wait=new PauseTransition(Duration.seconds(1));
                wait.setOnFinished((e)->{  
                obj.Imq6(primaryStage,marks);
				});
                wait.play();
                }
                catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
            }
    }
   
    else
    {
    System.out.println("Wrong");
    ImageView choiceW= new ImageView("/thebr/InterMode/wrong.png");
    gchoice.add(choiceW,5,3);
    TheBr obj= new TheBr();
    obj.Wrong(marks);
         btnPressed=1;	
            if(btnPressed==1)
            {
                autoSlide.stop();
                try {       
                PauseTransition wait=new PauseTransition(Duration.seconds(1));
                wait.setOnFinished((e)->{  
                obj.Imq6(primaryStage,marks);
				});
                wait.play();
                }
                catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
            }
    }
    }
    });
     //Admin control
 GridPane gridadmin = new GridPane();
 gridadmin.setAlignment(Pos.CENTER);
 gridadmin.setHgap(10);
 gridadmin.setVgap(10);
 gridadmin.setPadding(new Insets(0,0,0,0));
 gridadmin.setLayoutX(275);
 gridadmin.setLayoutY(550);
 TheBr obj = new TheBr();
if(admin==1)
{  
 autoSlide.stop();   
 Button prevbtn =new Button("", new ImageView("/thebr/AdminControl/previous.png"));
 gridadmin.add(prevbtn,0,0);
    prevbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Imq4(primaryStage,marks);
    }
    });

 Button relbtn =new Button("", new ImageView("/thebr/AdminControl/reload.png"));
 gridadmin.add(relbtn,1,0);
    relbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Imq5(primaryStage,marks);
    }
    });
 
 Button nextbtn = new Button("", new ImageView("/thebr/AdminControl/next.png"));
 gridadmin.add(nextbtn,2,0);
     nextbtn.setOnAction(new EventHandler<ActionEvent>() {
     public void handle(ActionEvent ae){
     obj.Imq6(primaryStage,marks);
     }
     });
     
 Button levelbtn =new Button("", new ImageView("/thebr/AdminControl/level.png"));
 gridadmin.add(levelbtn,3,0);
    levelbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Page2(primaryStage,marks);
    }
    });
}    
   //Adding Score View
        Text scrLbl = new Text("Score: ");
        scrLbl.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        scrLbl.setFill( Color.web("BLACK", 0.50) );
        scrLbl.setX(5);
        scrLbl.setY(595);
        
        String myscore= Double.toString(mrk);
        Text scrView= new Text();
        scrView.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
        scrView.setFill( Color.web("WHITE", 0.50) );
        scrView.setText(myscore);
        scrView.setX(63);
        scrView.setY(595);

//Adding close button
Button btnclose = new Button("",new ImageView("/thebr/AdminControl/close.png"));
btnclose.setId("btnclose");
btnclose.setTranslateX(750);
btnclose.setTranslateY(550);
    btnclose.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
        TheBr obj = new TheBr();
        obj.Marks(primaryStage,marks);
        voice.stop();
        autoSlide.stop();
    }
    });

Image imgb = new Image("/thebr/interback.jpg");
ImageView imgb1 = new ImageView(imgb);
root.getChildren().addAll(imgb1,linesW,linesO,linesR,queI5,bbase,bbasket,bgolf,bsoccer,btennis,stand,gb1,gb2,gb3,gb4,gb5,grid2,gridadmin,btnclose,scrLbl,scrView,gchoice);        

Scene scene = new Scene(root, 800, 600, Color.GRAY);
primaryStage.setResizable(false);
primaryStage.setScene(scene);
scene.getStylesheets().add(TheBr.class.getResource("inter.css").toExternalForm());			
primaryStage.getIcons().add(new Image("/thebr/TheBrainifyApp.jpg"));
primaryStage.show();
}  
            
//Inetermediate mode Q6
public void Imq6(Stage primaryStage, double marks)
{
System.out.println("Reached Imq1");
    
Group root = new Group();
FlowPane rootNode= new FlowPane();
primaryStage.setTitle("The Brainify App- Intermediate mode:"); 

    //Virtual Assistant
     MediaPlayer voice = new MediaPlayer(new Media(TheBr.class.getResource("virtualAssistant/Imq6.mp3").toString())); 
     voice.play();

//Timer Line       
        Group linesW = new Group();
        for(int i=0;i<1;i++)
        {
        Line whiteLine = new Line(0, 0, 780, 0);
        whiteLine.setStroke(Color.web("#4EFF00", 0.5));
        whiteLine.setStrokeWidth(40);
        whiteLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesW.getChildren().add(whiteLine);
        }
      
        Group linesO = new Group();
        for(int i=0;i<1;i++)
        {
        Line orangeLine = new Line(0, 0, 780, 0);
        orangeLine.setStroke(Color.web("#FF9900", 1.0));
        orangeLine.setStrokeWidth(40);
        orangeLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesO.getChildren().add(orangeLine);
        }
            
        Group linesR = new Group();
        for(int i=0;i<1;i++)
        {
        Line redLine = new Line(0, 0, 780, 0);
        redLine.setStroke(Color.web("#FF0000", 1.0));
        redLine.setStrokeWidth(40);
        redLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesR.getChildren().add(redLine);
        }
 
        
        Timeline timeline = new Timeline();
        for (Node whiteLine: linesW.getChildren()) 
        {
        timeline.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(whiteLine.translateXProperty(), -800),
        new KeyValue(whiteLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(18040), 
        new KeyValue(whiteLine.translateXProperty(), -320),
        new KeyValue(whiteLine.translateYProperty(), 0)
                )
                );
        }
        timeline.play();

        Timeline timeline1 = new Timeline();
        for (Node orangeLine: linesO.getChildren())
        {
        timeline1.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(18040), 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),        
        new KeyFrame(new Duration(18040), 
        new KeyValue(orangeLine.translateXProperty(), -320),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ), 
        
        new KeyFrame(new Duration(25550), 
        new KeyValue(orangeLine.translateXProperty(), -120),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    )
                    );
        }
        timeline1.play();

        Timeline timeline2 = new Timeline();
        for (Node redLine: linesR.getChildren())
        {
        timeline2.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(redLine.translateXProperty(), -800),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(25550),
        new KeyValue(redLine.translateXProperty(), -800),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),   
        new KeyFrame(new Duration(25550), 
        new KeyValue(redLine.translateXProperty(), -120),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),       
 
        new KeyFrame(new Duration(30000),
        new KeyValue(redLine.translateXProperty(), 0),
        new KeyValue(redLine.translateYProperty(), 0)
                    )
                    );
        }
        timeline2.play();  
        
        //Timer Lines END
        
        
               //Timer start, will skip if no button pressed
            System.out.println("btn pressed before timeline = "+ btnPressed);
            Timeline autoSlide = new Timeline(new KeyFrame(
            Duration.millis(30000),
            ae-> 
            { 
                if(btnPressed==0)
                {//Time out
                System.out.println("marks skipped = "+ marks);
                TheBr obj = new TheBr();
                obj.Imq7(primaryStage, marks);
                }
            }     
            ));
            autoSlide.play();      
            //End of auto Timer
            
            
Text queI6=new Text("Q6. Which one will reach the other end earlier?"); 
queI6.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
queI6.setX(100);
queI6.setY(100);

Line way = new Line(0,400,800,400);
way.setId("ballStrike");
way.setStrokeWidth(100);
way.setStrokeLineCap(StrokeLineCap.ROUND);
way.setStrokeDashOffset(0);

Line divider = new Line(0,400,4000,400);
divider.setStroke(Color.WHITE);
divider.setStrokeWidth(5);
divider.getStrokeDashArray().addAll(10.0,10.0);

PathElement[] roadpath=
        {
            new MoveTo(0,400),
            new LineTo(0,400),
            new LineTo(-3200,400),
        };
Path roadpath1= new Path();
roadpath1.setStrokeWidth(0);
roadpath1.getElements().addAll(roadpath);

      PathTransition animroad = new PathTransition();
      animroad.setNode(divider);
      animroad.setPath(roadpath1);
      animroad.setInterpolator(Interpolator.EASE_IN);
      animroad.setAutoReverse(false);
      animroad.setCycleCount(Timeline.INDEFINITE);
      animroad.setDuration(new Duration(70000));
      animroad.setDelay(new Duration(7500));
      animroad.play();




ImageView car1= new ImageView("/thebr/InterMode/car1.png");
car1.setX(10);
car1.setY(360);
ImageView car2= new ImageView("/thebr/InterMode/car2.png");
car2.setX(10);
car2.setY(410);

PathElement [] path1= 
{
    new MoveTo(25,375),
    new LineTo(25,375),
    new LineTo(800,375)
};
Path road1= new Path();
road1.setStrokeWidth(0);
road1.getElements().addAll(path1);

      PathTransition anim1 = new PathTransition();
      anim1.setNode(car1);
      anim1.setPath(road1);
      anim1.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
      anim1.setInterpolator(Interpolator.LINEAR);
      anim1.setDuration(new Duration(25000));
      anim1.setDelay(new Duration(5000));
      anim1.play();

PathElement [] path2= 
{
    new MoveTo(25,425),
    new LineTo(25,425),
    new LineTo(800,425)
};
Path road2= new Path();
road2.setStrokeWidth(0);
road2.getElements().addAll(path2);

      PathTransition anim2 = new PathTransition();
      anim2.setNode(car2);
      anim2.setPath(road2);
      anim2.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
      anim2.setInterpolator(Interpolator.LINEAR);
      anim2.setDuration(new Duration(24800));
      anim2.setDelay(new Duration(5000));
      anim2.play();

      
      
                                 //Button
            
        GridPane grid2=new GridPane();
        grid2.setAlignment(Pos.CENTER);
        grid2.setHgap(10);
        grid2.setVgap(10);
        grid2.setPadding(new Insets(250,25,25,350));
        
        TextField textField = new TextField();
        Button btn= new Button("Okay!");
        Text gb1 = new Text();
        Text gb2 = new Text();

          try {       
                PauseTransition wait=new PauseTransition(Duration.millis(15000));
                wait.setOnFinished((e)->{  
                
                
                gb1.setText("A");
                gb1.setId("actiontargetT");
                gb1.setX(750);
                gb1.setY(395);
                
                
                gb2.setText("B");
                gb2.setId("actiontargetT");
                gb2.setX(750);
                gb2.setY(445);

                grid2.add(textField,0,0);
                grid2.add(btn,0,1);
		});
                wait.play();
                }
                catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
      
        GridPane gchoice=new GridPane();
        gchoice.setAlignment(Pos.CENTER);
        gchoice.setHgap(10);
        gchoice.setVgap(10);
        gchoice.setPadding(new Insets(150,25,25,250));
                    //Button Action
    btn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){ 
    btnPressed=1;
    String eqs = textField.getText();
    String ans ="B";
    if(ans.equalsIgnoreCase(eqs))
    {
    System.out.println("Right");
    ImageView choiceR= new ImageView("/thebr/InterMode/correct.png");
    gchoice.add(choiceR,5,3);
    TheBr obj= new TheBr();
    obj.Right(marks);
    btnPressed=1;	
            if(btnPressed==1)
            {
                autoSlide.stop();
                try {       
                PauseTransition wait=new PauseTransition(Duration.seconds(1));
                wait.setOnFinished((e)->{  
                obj.Imq7(primaryStage,marks);
				});
                wait.play();
                }
                catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
            }
    }
   
    else
    {
    System.out.println("Wrong");
    ImageView choiceW= new ImageView("/thebr/InterMode/wrong.png");
    gchoice.add(choiceW,5,3);
    TheBr obj= new TheBr();
    obj.Wrong(marks);
         btnPressed=1;	
            if(btnPressed==1)
            {
                autoSlide.stop();
                try {       
                PauseTransition wait=new PauseTransition(Duration.seconds(1));
                wait.setOnFinished((e)->{  
                obj.Imq7(primaryStage,marks);
				});
                wait.play();
                }
                catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
            }
    }
    }
    });

     //Admin control
 GridPane gridadmin = new GridPane();
 gridadmin.setAlignment(Pos.CENTER);
 gridadmin.setHgap(10);
 gridadmin.setVgap(10);
 gridadmin.setPadding(new Insets(0,0,0,0));
 gridadmin.setLayoutX(275);
 gridadmin.setLayoutY(550);
 TheBr obj = new TheBr();
if(admin==1)
{  
 autoSlide.stop();   
 Button prevbtn =new Button("", new ImageView("/thebr/AdminControl/previous.png"));
 gridadmin.add(prevbtn,0,0);
    prevbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Imq5(primaryStage,marks);
    }
    });

 Button relbtn =new Button("", new ImageView("/thebr/AdminControl/reload.png"));
 gridadmin.add(relbtn,1,0);
    relbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Imq6(primaryStage,marks);
    }
    });
 
 Button nextbtn = new Button("", new ImageView("/thebr/AdminControl/next.png"));
 gridadmin.add(nextbtn,2,0);
     nextbtn.setOnAction(new EventHandler<ActionEvent>() {
     public void handle(ActionEvent ae){
     obj.Imq7(primaryStage,marks);
     }
     });
     
 Button levelbtn =new Button("", new ImageView("/thebr/AdminControl/level.png"));
 gridadmin.add(levelbtn,3,0);
    levelbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Page2(primaryStage,marks);
    }
    });
}       

   //Adding Score View
        Text scrLbl = new Text("Score: ");
        scrLbl.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        scrLbl.setFill( Color.web("BLACK", 0.50) );
        scrLbl.setX(5);
        scrLbl.setY(595);
        
        String myscore= Double.toString(mrk);
        Text scrView= new Text();
        scrView.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
        scrView.setFill( Color.web("WHITE", 0.50) );
        scrView.setText(myscore);
        scrView.setX(63);
        scrView.setY(595);

//Adding close button
Button btnclose = new Button("",new ImageView("/thebr/AdminControl/close.png"));
btnclose.setId("btnclose");
btnclose.setTranslateX(750);
btnclose.setTranslateY(550);
    btnclose.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
        TheBr obj = new TheBr();
        obj.Marks(primaryStage,marks);
        voice.stop();
        autoSlide.stop();
    }
    });

Image imgb = new Image("/thebr/interback.jpg");
ImageView imgb1 = new ImageView(imgb);
root.getChildren().addAll(imgb1,linesW,linesO,linesR,queI6,way,divider,gb1,gb2,car1,car2,grid2,gridadmin,btnclose,scrLbl,scrView,gchoice);        

Scene scene = new Scene(root, 800, 600, Color.GRAY);
primaryStage.setResizable(false);
primaryStage.setScene(scene);
scene.getStylesheets().add(TheBr.class.getResource("inter.css").toExternalForm());			
primaryStage.getIcons().add(new Image("/thebr/TheBrainifyApp.jpg"));
primaryStage.show();
} 


//Inetermediate mode Q7
public void Imq7(Stage primaryStage, double marks)
{
Group root = new Group();
FlowPane rootNode= new FlowPane();
primaryStage.setTitle("The Brainify App- Intermediate mode:"); 

    //Virtual Assistant
     MediaPlayer voice = new MediaPlayer(new Media(TheBr.class.getResource("virtualAssistant/Imq7.mp3").toString())); 
     voice.play();

//Timer Line       
        Group linesW = new Group();
        for(int i=0;i<1;i++)
        {
        Line whiteLine = new Line(0, 0, 780, 0);
        whiteLine.setStroke(Color.web("#4EFF00", 0.5));
        whiteLine.setStrokeWidth(40);
        whiteLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesW.getChildren().add(whiteLine);
        }
      
        Group linesO = new Group();
        for(int i=0;i<1;i++)
        {
        Line orangeLine = new Line(0, 0, 780, 0);
        orangeLine.setStroke(Color.web("#FF9900", 1.0));
        orangeLine.setStrokeWidth(40);
        orangeLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesO.getChildren().add(orangeLine);
        }
            
        Group linesR = new Group();
        for(int i=0;i<1;i++)
        {
        Line redLine = new Line(0, 0, 780, 0);
        redLine.setStroke(Color.web("#FF0000", 1.0));
        redLine.setStrokeWidth(40);
        redLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesR.getChildren().add(redLine);
        }
 
        
        Timeline timeline = new Timeline();
        for (Node whiteLine: linesW.getChildren()) 
        {
        timeline.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(whiteLine.translateXProperty(), -800),
        new KeyValue(whiteLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(18040), 
        new KeyValue(whiteLine.translateXProperty(), -320),
        new KeyValue(whiteLine.translateYProperty(), 0)
                )
                );
        }
        timeline.play();

        Timeline timeline1 = new Timeline();
        for (Node orangeLine: linesO.getChildren())
        {
        timeline1.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(18040), 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),        
        new KeyFrame(new Duration(18040), 
        new KeyValue(orangeLine.translateXProperty(), -320),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ), 
        
        new KeyFrame(new Duration(25550), 
        new KeyValue(orangeLine.translateXProperty(), -120),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    )
                    );
        }
        timeline1.play();

        Timeline timeline2 = new Timeline();
        for (Node redLine: linesR.getChildren())
        {
        timeline2.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(redLine.translateXProperty(), -800),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(25550),
        new KeyValue(redLine.translateXProperty(), -800),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),   
        new KeyFrame(new Duration(25550), 
        new KeyValue(redLine.translateXProperty(), -120),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),       
 
        new KeyFrame(new Duration(30000),
        new KeyValue(redLine.translateXProperty(), 0),
        new KeyValue(redLine.translateYProperty(), 0)
                    )
                    );
        }
        timeline2.play();  
        
        //Timer Lines END
        
        
               //Timer start, will skip if no button pressed
            System.out.println("btn pressed before timeline = "+ btnPressed);
            Timeline autoSlide = new Timeline(new KeyFrame(
            Duration.millis(30000),
            ae-> 
            { 
                if(btnPressed==0)
                {//Time out
                System.out.println("marks skipped = "+ marks);
                TheBr obj = new TheBr();
                obj.Imq8(primaryStage, marks);
                }
            }     
            ));
            autoSlide.play();      
            //End of auto Timer
            
            
Text queI7=new Text("Q7. What's The number of hits before the ball stops ?"); 
queI7.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
queI7.setX(50);
queI7.setY(100);

Line l1 = new Line(100,425,100,800);
l1.setId("ballStrike");
l1.setStrokeWidth(50);
l1.setStrokeLineCap(StrokeLineCap.BUTT);
l1.setStrokeDashOffset(0);

Line l2 = new Line(300,425,300,800);
l2.setId("ballStrike");
l2.setStrokeWidth(50);
l2.setStrokeLineCap(StrokeLineCap.BUTT);
l2.setStrokeDashOffset(0);

Line l3 = new Line(500,425,500,800);
l3.setId("ballStrike");
l3.setStrokeWidth(50);
l3.setStrokeLineCap(StrokeLineCap.BUTT);
l3.setStrokeDashOffset(0);

Line l4 = new Line(700,425,700,800);
l4.setId("ballStrike");
l4.setStrokeWidth(50);
l4.setStrokeLineCap(StrokeLineCap.BUTT);
l4.setStrokeDashOffset(0);

ImageView ball = new ImageView("/thebr/InterMode/ball.png");
ball.setX(-100);

 //Rotate Ball
    RotateTransition rt=  new RotateTransition();
    rt.setNode(ball);
    rt.setFromAngle(0);
    rt.setToAngle(360);
    rt.setInterpolator(Interpolator.LINEAR);
    rt.setCycleCount(Timeline.INDEFINITE);
    rt.setDuration(new Duration(1500));

PathElement[] path =
{
    new MoveTo(-50,350),
    new ArcTo(200,400,0,-50,350,false,false),
    new ArcTo(200,400,0,100,400,false,true),
    new ArcTo(200,400,0,300,400,false,true),
    new ArcTo(200,400,0,500,400,false,true),
    new ArcTo(200,400,0,700,400,false,true),
    new ArcTo(200,400,0,800,350,false,true),
};

Path road = new Path();
road.setStrokeWidth(0);
road.getElements().addAll(path);

      PathTransition anim2 = new PathTransition();
      anim2.setNode(ball);
      anim2.setPath(road);
      anim2.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
      anim2.setInterpolator(Interpolator.LINEAR);
      anim2.setCycleCount(Timeline.INDEFINITE);
      anim2.setDuration(new Duration(4000));
      anim2.setDelay(new Duration(5000));
      anim2.play();
      rt.play();
      
      
        GridPane grid2=new GridPane();
        grid2.setAlignment(Pos.CENTER);
        grid2.setHgap(10);
        grid2.setVgap(10);
        grid2.setPadding(new Insets(250,25,25,350));
        
        TextField textField = new TextField();
        Button btn= new Button("Okay!");
                try
                {
                PauseTransition wait=new PauseTransition(Duration.seconds(20));
                wait.setOnFinished((e)->{  
                anim2.stop();
                rt.stop();
                grid2.add(textField,0,0);
                grid2.add(btn,0,1);
				});
                wait.play();
                }
                catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
                
                
        GridPane gchoice=new GridPane();
        gchoice.setAlignment(Pos.CENTER);
        gchoice.setHgap(10);
        gchoice.setVgap(10);
        gchoice.setPadding(new Insets(150,25,25,200));
                    //Button Action
    btn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){ 
    btnPressed=1;
    String eqs = textField.getText();
    String ans ="15";
    if(ans.equalsIgnoreCase(eqs))
    {
    System.out.println("Right");
    ImageView choiceR= new ImageView("/thebr/InterMode/correct.png");
    gchoice.add(choiceR,5,3);
    TheBr obj= new TheBr();
    obj.Right(marks);
    btnPressed=1;	
            if(btnPressed==1)
            {
                autoSlide.stop();
                try {       
                PauseTransition wait=new PauseTransition(Duration.seconds(1));
                wait.setOnFinished((e)->{  
                obj.Imq8(primaryStage,marks);
				});
                wait.play();
                }
                catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
            }
    }
   
    else
    {
    System.out.println("Wrong");
    ImageView choiceW= new ImageView("/thebr/InterMode/wrong.png");
    gchoice.add(choiceW,5,3);
    TheBr obj= new TheBr();
    obj.Wrong(marks);
         btnPressed=1;	
            if(btnPressed==1)
            {
                autoSlide.stop();
                try {       
                PauseTransition wait=new PauseTransition(Duration.seconds(1));
                wait.setOnFinished((e)->{  
                obj.Imq8(primaryStage,marks);
				});
                wait.play();
                }
                catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
            }
    }
    }
    });
     //Admin control
 GridPane gridadmin = new GridPane();
 gridadmin.setAlignment(Pos.CENTER);
 gridadmin.setHgap(10);
 gridadmin.setVgap(10);
 gridadmin.setPadding(new Insets(0,0,0,0));
 gridadmin.setLayoutX(275);
 gridadmin.setLayoutY(550);
 TheBr obj = new TheBr();
if(admin==1)
{  
 autoSlide.stop();   
 Button prevbtn =new Button("", new ImageView("/thebr/AdminControl/previous.png"));
 gridadmin.add(prevbtn,0,0);
    prevbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Imq6(primaryStage,marks);
    }
    });

 Button relbtn =new Button("", new ImageView("/thebr/AdminControl/reload.png"));
 gridadmin.add(relbtn,1,0);
    relbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Imq7(primaryStage,marks);
    }
    });
 
 Button nextbtn = new Button("", new ImageView("/thebr/AdminControl/next.png"));
 gridadmin.add(nextbtn,2,0);
     nextbtn.setOnAction(new EventHandler<ActionEvent>() {
     public void handle(ActionEvent ae){
     obj.Imq8(primaryStage,marks);
     }
     });
     
 Button levelbtn =new Button("", new ImageView("/thebr/AdminControl/level.png"));
 gridadmin.add(levelbtn,3,0);
    levelbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Page2(primaryStage,marks);
    }
    });
} 

   //Adding Score View
        Text scrLbl = new Text("Score: ");
        scrLbl.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        scrLbl.setFill( Color.web("BLACK", 0.50) );
        scrLbl.setX(5);
        scrLbl.setY(595);
        
        String myscore= Double.toString(mrk);
        Text scrView= new Text();
        scrView.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
        scrView.setFill( Color.web("WHITE", 0.50) );
        scrView.setText(myscore);
        scrView.setX(63);
        scrView.setY(595);

//Adding close button
Button btnclose = new Button("",new ImageView("/thebr/AdminControl/close.png"));
btnclose.setId("btnclose");
btnclose.setTranslateX(750);
btnclose.setTranslateY(550);
    btnclose.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
        TheBr obj = new TheBr();
        obj.Marks(primaryStage,marks);
        voice.stop();
        autoSlide.stop();
    }
    });

Image imgb = new Image("/thebr/interback.jpg");
ImageView imgb1 = new ImageView(imgb);
root.getChildren().addAll(imgb1,linesW,linesO,linesR,queI7,l1,l2,l3,l4,road,ball,grid2,gridadmin,btnclose,scrLbl,scrView,gchoice);        

Scene scene = new Scene(root, 800, 600, Color.GRAY);
primaryStage.setResizable(false);
primaryStage.setScene(scene);
scene.getStylesheets().add(TheBr.class.getResource("inter.css").toExternalForm());			
primaryStage.getIcons().add(new Image("/thebr/TheBrainifyApp.jpg"));
primaryStage.show();
} 

//Inetermediate mode Q8
public void Imq8(Stage primaryStage, double marks)
{
Group root = new Group();
FlowPane rootNode= new FlowPane();
primaryStage.setTitle("The Brainify App- Intermediate mode:"); 

    //Virtual Assistant
     MediaPlayer voice = new MediaPlayer(new Media(TheBr.class.getResource("virtualAssistant/Imq8.mp3").toString())); 
     voice.play();

//Timer Line       
        Group linesW = new Group();
        for(int i=0;i<1;i++)
        {
        Line whiteLine = new Line(0, 0, 780, 0);
        whiteLine.setStroke(Color.web("#4EFF00", 0.5));
        whiteLine.setStrokeWidth(40);
        whiteLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesW.getChildren().add(whiteLine);
        }
      
        Group linesO = new Group();
        for(int i=0;i<1;i++)
        {
        Line orangeLine = new Line(0, 0, 780, 0);
        orangeLine.setStroke(Color.web("#FF9900", 1.0));
        orangeLine.setStrokeWidth(40);
        orangeLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesO.getChildren().add(orangeLine);
        }
            
        Group linesR = new Group();
        for(int i=0;i<1;i++)
        {
        Line redLine = new Line(0, 0, 780, 0);
        redLine.setStroke(Color.web("#FF0000", 1.0));
        redLine.setStrokeWidth(40);
        redLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesR.getChildren().add(redLine);
        }
 
        
        Timeline timeline = new Timeline();
        for (Node whiteLine: linesW.getChildren()) 
        {
        timeline.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(whiteLine.translateXProperty(), -800),
        new KeyValue(whiteLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(18040), 
        new KeyValue(whiteLine.translateXProperty(), -320),
        new KeyValue(whiteLine.translateYProperty(), 0)
                )
                );
        }
        timeline.play();

        Timeline timeline1 = new Timeline();
        for (Node orangeLine: linesO.getChildren())
        {
        timeline1.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(18040), 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),        
        new KeyFrame(new Duration(18040), 
        new KeyValue(orangeLine.translateXProperty(), -320),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ), 
        
        new KeyFrame(new Duration(25550), 
        new KeyValue(orangeLine.translateXProperty(), -120),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    )
                    );
        }
        timeline1.play();

        Timeline timeline2 = new Timeline();
        for (Node redLine: linesR.getChildren())
        {
        timeline2.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(redLine.translateXProperty(), -800),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(25550),
        new KeyValue(redLine.translateXProperty(), -800),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),   
        new KeyFrame(new Duration(25550), 
        new KeyValue(redLine.translateXProperty(), -120),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),       
 
        new KeyFrame(new Duration(30000),
        new KeyValue(redLine.translateXProperty(), 0),
        new KeyValue(redLine.translateYProperty(), 0)
                    )
                    );
        }
        timeline2.play();  
        
        //Timer Lines END
        
        
               //Timer start, will skip if no button pressed
            System.out.println("btn pressed before timeline = "+ btnPressed);
            Timeline autoSlide = new Timeline(new KeyFrame(
            Duration.millis(30000),
            ae-> 
            { 
                if(btnPressed==0)
                {//Time out
                System.out.println("marks skipped = "+ marks);
                TheBr obj = new TheBr();
                obj.Imq9(primaryStage, marks);
                }
            }     
            ));
            autoSlide.play();      
            //End of auto Timer
            
            
Text queI8=new Text("Q8.   What's the number of laps being covered,\n\twhen the car reaches the other end ?"); 
queI8.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
queI8.setX(50);
queI8.setY(75);

ImageView speeder = new ImageView("/thebr/InterMode/speeder.png");
speeder.setX(170);
speeder.setY(382);
ImageView car = new ImageView("/thebr/InterMode/car2.png");
car.setX(25);
car.setY(487);


PathElement [] path= 
{
    new MoveTo(200,400),
    new LineTo(200,400),
    new LineTo(600,400),
    new ArcTo(200,400,0,600,400,false,false),
    new ArcTo(200,400,0,700,350,false,false),
   // new LineTo(710,300),
    new ArcTo(200,400,0,700,250,false,false),
    new ArcTo(200,400,0,600,200,false,false),
    new LineTo(599,200),
    new LineTo(200,200),
    new ArcTo(200,400,0,200,200,false,false),
    new ArcTo(200,400,0,100,250,false,false),
    //new LineTo(90,300),
    new ArcTo(200,400,0,100,350,false,false),
    new ArcTo(200,400,0,198,400,false,false),
    new ClosePath()
    
};

Path road = new Path();
road.setId("roadcircle");
road.setStrokeWidth(75);
road.getElements().addAll(path);

      Path divider = new Path();
      divider.setStroke(Color.WHITE);
      divider.setStrokeWidth(0);
      divider.getStrokeDashArray().addAll(10.0, 10.0);
      divider.getElements().addAll(path);
      
      PathTransition anim = new PathTransition();
      anim.setNode(speeder);
      anim.setPath(road);
      anim.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
      anim.setInterpolator(Interpolator.LINEAR);
      anim.setDuration(new Duration(1500));
      anim.setCycleCount(Timeline.INDEFINITE);
      anim.setDelay(new Duration(5000));
      anim.play();
      
      Line stop = new Line(250,363,250,437);
        stop.setStroke(Color.web("#FF9900", 0.5));
        stop.setStrokeWidth(5);
        stop.setStrokeLineCap(StrokeLineCap.SQUARE);
      
      
 PathElement[] path2=
 {
     new MoveTo(50,500),
     new LineTo(50,500),
     new LineTo(750,500)
 };

 Path road2 = new Path();
road2.setId("roadcircle");
road2.setStrokeWidth(75);
road2.getElements().addAll(path2);

       Path divider2 = new Path();
      divider2.setStroke(Color.WHITE);
      divider2.setStrokeWidth(2);
      divider2.getStrokeDashArray().addAll(10.0, 10.0);
      divider2.getElements().addAll(path2);
      
      PathTransition anim2 = new PathTransition();
      anim2.setNode(car);
      anim2.setPath(road2);
      anim2.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
      anim2.setInterpolator(Interpolator.LINEAR);
      anim2.setDuration(new Duration(15000));
      anim2.setDelay(new Duration(5000));
      anim2.setCycleCount(1);
      anim2.play();
      
      
       GridPane grid2=new GridPane();
        grid2.setAlignment(Pos.CENTER);
        grid2.setHgap(10);
        grid2.setVgap(10);
        grid2.setPadding(new Insets(275,25,25,325));
        
        TextField textField = new TextField();
        Button btn= new Button("Okay!");
                try
                {
                PauseTransition wait=new PauseTransition(Duration.millis(20000));
                wait.setOnFinished((e)->{  
                grid2.add(textField,0,0);
                grid2.add(btn,0,1);
				});
                wait.play();
                }
                catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
                
                
        GridPane gchoice=new GridPane();
        gchoice.setAlignment(Pos.CENTER);
        gchoice.setHgap(10);
        gchoice.setVgap(10);
        gchoice.setPadding(new Insets(150,25,25,200));
                    //Button Action
    btn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){ 
    btnPressed=1;
    String eqs = textField.getText();
    String ans ="9";
    if(ans.equalsIgnoreCase(eqs))
    {
    System.out.println("Right");
    ImageView choiceR= new ImageView("/thebr/InterMode/correct.png");
    gchoice.add(choiceR,5,3);
    TheBr obj= new TheBr();
    obj.Right(marks);
    btnPressed=1;	
            if(btnPressed==1)
            {
                autoSlide.stop();
                try {       
                PauseTransition wait=new PauseTransition(Duration.seconds(1));
                wait.setOnFinished((e)->{  
                obj.Imq9(primaryStage,marks);
				});
                wait.play();
                }
                catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
            }
    }
   
    else
    {
    System.out.println("Wrong");
    ImageView choiceW= new ImageView("/thebr/InterMode/wrong.png");
    gchoice.add(choiceW,5,3);
    TheBr obj= new TheBr();
    obj.Wrong(marks);
         btnPressed=1;	
            if(btnPressed==1)
            {
                autoSlide.stop();
                try {       
                PauseTransition wait=new PauseTransition(Duration.seconds(1));
                wait.setOnFinished((e)->{  
                obj.Imq9(primaryStage,marks);
				});
                wait.play();
                }
                catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
            }
    }
    }
    });
 
     //Admin control
 GridPane gridadmin = new GridPane();
 gridadmin.setAlignment(Pos.CENTER);
 gridadmin.setHgap(10);
 gridadmin.setVgap(10);
 gridadmin.setPadding(new Insets(0,0,0,0));
 gridadmin.setLayoutX(275);
 gridadmin.setLayoutY(550);
 TheBr obj = new TheBr();
if(admin==1)
{  
 autoSlide.stop();   
 Button prevbtn =new Button("", new ImageView("/thebr/AdminControl/previous.png"));
 gridadmin.add(prevbtn,0,0);
    prevbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Imq7(primaryStage,marks);
    }
    });

 Button relbtn =new Button("", new ImageView("/thebr/AdminControl/reload.png"));
 gridadmin.add(relbtn,1,0);
    relbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Imq8(primaryStage,marks);
    }
    });
 
 Button nextbtn = new Button("", new ImageView("/thebr/AdminControl/next.png"));
 gridadmin.add(nextbtn,2,0);
     nextbtn.setOnAction(new EventHandler<ActionEvent>() {
     public void handle(ActionEvent ae){
     obj.Imq9(primaryStage,marks);
     }
     });
     
 Button levelbtn =new Button("", new ImageView("/thebr/AdminControl/level.png"));
 gridadmin.add(levelbtn,3,0);
    levelbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Page2(primaryStage,marks);
    }
    });
} 

   //Adding Score View
        Text scrLbl = new Text("Score: ");
        scrLbl.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        scrLbl.setFill( Color.web("BLACK", 0.50) );
        scrLbl.setX(5);
        scrLbl.setY(595);
        
        String myscore= Double.toString(mrk);
        Text scrView= new Text();
        scrView.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
        scrView.setFill( Color.web("WHITE", 0.50) );
        scrView.setText(myscore);
        scrView.setX(63);
        scrView.setY(595);

//Adding close button
Button btnclose = new Button("",new ImageView("/thebr/AdminControl/close.png"));
btnclose.setId("btnclose");
btnclose.setTranslateX(750);
btnclose.setTranslateY(550);
    btnclose.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
        TheBr obj = new TheBr();
        obj.Marks(primaryStage,marks);
        voice.stop();
    }
    });

Image imgb = new Image("/thebr/interback.jpg");
ImageView imgb1 = new ImageView(imgb);
root.getChildren().addAll(imgb1,linesW,linesO,linesR,queI8,road,divider,speeder,road2,divider2,car,stop,grid2,gridadmin,btnclose,scrLbl,scrView,gchoice);        

Scene scene = new Scene(root, 800, 600, Color.GRAY);
primaryStage.setResizable(false);
primaryStage.setScene(scene);
scene.getStylesheets().add(TheBr.class.getResource("inter.css").toExternalForm());			
primaryStage.getIcons().add(new Image("/thebr/TheBrainifyApp.jpg"));
primaryStage.show();
} 


//Inetermediate mode Q9
public void Imq9(Stage primaryStage, double marks)
{
Group root = new Group();
FlowPane rootNode= new FlowPane();
primaryStage.setTitle("The Brainify App- Intermediate mode:"); 

    //Virtual Assistant
     MediaPlayer voice = new MediaPlayer(new Media(TheBr.class.getResource("virtualAssistant/Imq9.mp3").toString())); 
     voice.play();

//Timer Line       
        Group linesW = new Group();
        for(int i=0;i<1;i++)
        {
        Line whiteLine = new Line(0, 0, 780, 0);
        whiteLine.setStroke(Color.web("#4EFF00", 0.5));
        whiteLine.setStrokeWidth(40);
        whiteLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesW.getChildren().add(whiteLine);
        }
      
        Group linesO = new Group();
        for(int i=0;i<1;i++)
        {
        Line orangeLine = new Line(0, 0, 780, 0);
        orangeLine.setStroke(Color.web("#FF9900", 1.0));
        orangeLine.setStrokeWidth(40);
        orangeLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesO.getChildren().add(orangeLine);
        }
            
        Group linesR = new Group();
        for(int i=0;i<1;i++)
        {
        Line redLine = new Line(0, 0, 780, 0);
        redLine.setStroke(Color.web("#FF0000", 1.0));
        redLine.setStrokeWidth(40);
        redLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesR.getChildren().add(redLine);
        }
 
        
        Timeline timeline = new Timeline();
        for (Node whiteLine: linesW.getChildren()) 
        {
        timeline.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(whiteLine.translateXProperty(), -800),
        new KeyValue(whiteLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(18040), 
        new KeyValue(whiteLine.translateXProperty(), -320),
        new KeyValue(whiteLine.translateYProperty(), 0)
                )
                );
        }
        timeline.play();

        Timeline timeline1 = new Timeline();
        for (Node orangeLine: linesO.getChildren())
        {
        timeline1.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(18040), 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),        
        new KeyFrame(new Duration(18040), 
        new KeyValue(orangeLine.translateXProperty(), -320),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ), 
        
        new KeyFrame(new Duration(25550), 
        new KeyValue(orangeLine.translateXProperty(), -120),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    )
                    );
        }
        timeline1.play();

        Timeline timeline2 = new Timeline();
        for (Node redLine: linesR.getChildren())
        {
        timeline2.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(redLine.translateXProperty(), -800),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(25550),
        new KeyValue(redLine.translateXProperty(), -800),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),   
        new KeyFrame(new Duration(25550), 
        new KeyValue(redLine.translateXProperty(), -120),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),       
 
        new KeyFrame(new Duration(30000),
        new KeyValue(redLine.translateXProperty(), 0),
        new KeyValue(redLine.translateYProperty(), 0)
                    )
                    );
        }
        timeline2.play();  
        
        //Timer Lines END
        
        
               //Timer start, will skip if no button pressed
            System.out.println("btn pressed before timeline = "+ btnPressed);
            Timeline autoSlide = new Timeline(new KeyFrame(
            Duration.millis(30000),
            ae-> 
            { 
                if(btnPressed==0)
                {//Time out
                System.out.println("marks skipped = "+ marks);
                TheBr obj = new TheBr();
                obj.Imq10(primaryStage, marks);
                }
            }     
            ));
            autoSlide.play();      
            //End of auto Timer
            
Text queI9=new Text("Q9.   Count the number of red O's ?"); 
queI9.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
queI9.setX(150);
queI9.setY(75);
 
            
            
        Group myname= new Group();
        for(int i=0; i<25;i++)
        {
        Text mname= new Text("o");
        mname.setId("flyname");
       // myname.getChildren().add(mname);
        
        Text mname2= new Text("o");
        mname2.setId("flyname2");
       // myname.getChildren().add(mname2);
        
        Text mname3= new Text("o");
        mname3.setId("flyname3");
        
        Text mname4= new Text("o");
        myname.getChildren().addAll(mname,mname2,mname3,mname4);
        }
  
Timeline namefall= new Timeline();
for(Node mname: myname.getChildren())  {
    namefall.getKeyFrames().addAll(
    new KeyFrame(Duration.ZERO,
    new KeyValue(mname.translateXProperty(), 400),
    new KeyValue(mname.translateYProperty(), 300)
    ),        
            
    new KeyFrame(new Duration(5000), 
    new KeyValue(mname.translateXProperty(),400),
    new KeyValue(mname.translateYProperty(), 300)
    ),
    new KeyFrame(new Duration(15000), 
    new KeyValue(mname.translateXProperty(), random()*750),
    new KeyValue(mname.translateYProperty(), random()*550)
    ),
    new KeyFrame(new Duration(30000), 
new KeyValue(mname.translateXProperty(), random()*750),
new KeyValue(mname.translateYProperty(), random()*550)
            )
            );
    }
namefall.play();

        
              GridPane grid2=new GridPane();
        grid2.setAlignment(Pos.CENTER);
        grid2.setHgap(10);
        grid2.setVgap(10);
        grid2.setPadding(new Insets(275,25,25,325));
        
        TextField textField = new TextField();
        Button btn= new Button("Okay!");
                try
                {
                PauseTransition wait=new PauseTransition(Duration.millis(15000));
                wait.setOnFinished((e)->{  
                grid2.add(textField,0,0);
                grid2.add(btn,0,1);
				});
                wait.play();
                }
                catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
                
                
        GridPane gchoice=new GridPane();
        gchoice.setAlignment(Pos.CENTER);
        gchoice.setHgap(10);
        gchoice.setVgap(10);
        gchoice.setPadding(new Insets(150,25,25,200));
                    //Button Action
    btn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){ 
    btnPressed=1;
    String eqs = textField.getText();
    String ans ="25";
    if(ans.equalsIgnoreCase(eqs))
    {
    System.out.println("Right");
    ImageView choiceR= new ImageView("/thebr/InterMode/correct.png");
    gchoice.add(choiceR,5,3);
    TheBr obj= new TheBr();
    obj.Right(marks);
    btnPressed=1;	
            if(btnPressed==1)
            {
                autoSlide.stop();
                try {       
                PauseTransition wait=new PauseTransition(Duration.seconds(1));
                wait.setOnFinished((e)->{  
                obj.Imq10(primaryStage,marks);
				});
                wait.play();
                }
                catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
            }
    }
   
    else
    {
    System.out.println("Wrong");
    ImageView choiceW= new ImageView("/thebr/InterMode/wrong.png");
    gchoice.add(choiceW,5,3);
    TheBr obj= new TheBr();
    obj.Wrong(marks);
         btnPressed=1;	
            if(btnPressed==1)
            {
                autoSlide.stop();
                try {       
                PauseTransition wait=new PauseTransition(Duration.seconds(1));
                wait.setOnFinished((e)->{  
                obj.Imq10(primaryStage,marks);
				});
                wait.play();
                }
                catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
            }
    }
    }
    });
            
     //Admin control
 GridPane gridadmin = new GridPane();
 gridadmin.setAlignment(Pos.CENTER);
 gridadmin.setHgap(10);
 gridadmin.setVgap(10);
 gridadmin.setPadding(new Insets(0,0,0,0));
 gridadmin.setLayoutX(275);
 gridadmin.setLayoutY(550);
 TheBr obj = new TheBr();
if(admin==1)
{  
 autoSlide.stop();   
 Button prevbtn =new Button("", new ImageView("/thebr/AdminControl/previous.png"));
 gridadmin.add(prevbtn,0,0);
    prevbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Imq8(primaryStage,marks);
    }
    });

 Button relbtn =new Button("", new ImageView("/thebr/AdminControl/reload.png"));
 gridadmin.add(relbtn,1,0);
    relbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Imq9(primaryStage,marks);
    }
    });
 
 Button nextbtn = new Button("", new ImageView("/thebr/AdminControl/next.png"));
 gridadmin.add(nextbtn,2,0);
     nextbtn.setOnAction(new EventHandler<ActionEvent>() {
     public void handle(ActionEvent ae){
     obj.Imq10(primaryStage,marks);
     }
     });
     
 Button levelbtn =new Button("", new ImageView("/thebr/AdminControl/level.png"));
 gridadmin.add(levelbtn,3,0);
    levelbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Page2(primaryStage,marks);
    }
    });
} 
 
   //Adding Score View
        Text scrLbl = new Text("Score: ");
        scrLbl.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        scrLbl.setFill( Color.web("BLACK", 0.50) );
        scrLbl.setX(5);
        scrLbl.setY(595);
        
        String myscore= Double.toString(mrk);
        Text scrView= new Text();
        scrView.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
        scrView.setFill( Color.web("WHITE", 0.50) );
        scrView.setText(myscore);
        scrView.setX(63);
        scrView.setY(595);

//Adding close button
Button btnclose = new Button("",new ImageView("/thebr/AdminControl/close.png"));
btnclose.setId("btnclose");
btnclose.setTranslateX(750);
btnclose.setTranslateY(550);
    btnclose.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
        TheBr obj = new TheBr();
        obj.Marks(primaryStage,marks);
        voice.stop();
        autoSlide.stop();
    }
    });

Image imgb = new Image("/thebr/interback.jpg");
ImageView imgb1 = new ImageView(imgb);
root.getChildren().addAll(imgb1,linesW,linesO,linesR,queI9,myname,grid2,gridadmin,btnclose,scrLbl,scrView,gchoice);   
Scene scene = new Scene(root, 800, 600, Color.GRAY);
primaryStage.setResizable(false);
primaryStage.setScene(scene);
scene.getStylesheets().add(TheBr.class.getResource("inter.css").toExternalForm());			
primaryStage.getIcons().add(new Image("/thebr/TheBrainifyApp.jpg"));
primaryStage.show();
} 



//Inetermediate mode Q10
public void Imq10(Stage primaryStage, double marks)
{
Group root = new Group();
FlowPane rootNode= new FlowPane();
primaryStage.setTitle("The Brainify App- Intermediate mode:"); 

    //Virtual Assistant
     MediaPlayer voice = new MediaPlayer(new Media(TheBr.class.getResource("virtualAssistant/Imq10.mp3").toString())); 
     voice.play();

//Timer Line       
        Group linesW = new Group();
        for(int i=0;i<1;i++)
        {
        Line whiteLine = new Line(0, 0, 780, 0);
        whiteLine.setStroke(Color.web("#4EFF00", 0.5));
        whiteLine.setStrokeWidth(40);
        whiteLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesW.getChildren().add(whiteLine);
        }
      
        Group linesO = new Group();
        for(int i=0;i<1;i++)
        {
        Line orangeLine = new Line(0, 0, 780, 0);
        orangeLine.setStroke(Color.web("#FF9900", 1.0));
        orangeLine.setStrokeWidth(40);
        orangeLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesO.getChildren().add(orangeLine);
        }
            
        Group linesR = new Group();
        for(int i=0;i<1;i++)
        {
        Line redLine = new Line(0, 0, 780, 0);
        redLine.setStroke(Color.web("#FF0000", 1.0));
        redLine.setStrokeWidth(40);
        redLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesR.getChildren().add(redLine);
        }
 
        
        Timeline timeline = new Timeline();
        for (Node whiteLine: linesW.getChildren()) 
        {
        timeline.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(whiteLine.translateXProperty(), -800),
        new KeyValue(whiteLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(18040), 
        new KeyValue(whiteLine.translateXProperty(), -320),
        new KeyValue(whiteLine.translateYProperty(), 0)
                )
                );
        }
        timeline.play();

        Timeline timeline1 = new Timeline();
        for (Node orangeLine: linesO.getChildren())
        {
        timeline1.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(18040), 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),        
        new KeyFrame(new Duration(18040), 
        new KeyValue(orangeLine.translateXProperty(), -320),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ), 
        
        new KeyFrame(new Duration(25550), 
        new KeyValue(orangeLine.translateXProperty(), -120),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    )
                    );
        }
        timeline1.play();

        Timeline timeline2 = new Timeline();
        for (Node redLine: linesR.getChildren())
        {
        timeline2.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(redLine.translateXProperty(), -800),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(25550),
        new KeyValue(redLine.translateXProperty(), -800),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),   
        new KeyFrame(new Duration(25550), 
        new KeyValue(redLine.translateXProperty(), -120),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),       
 
        new KeyFrame(new Duration(30000),
        new KeyValue(redLine.translateXProperty(), 0),
        new KeyValue(redLine.translateYProperty(), 0)
                    )
                    );
        }
        timeline2.play();  
        
        //Timer Lines END
        
        
               //Timer start, will skip if no button pressed
            System.out.println("btn pressed before timeline = "+ btnPressed);
            Timeline autoSlide = new Timeline(new KeyFrame(
            Duration.millis(30000),
            ae-> 
            { 
                if(btnPressed==0)
                {//Time out
                System.out.println("marks skipped = "+ marks);
                TheBr obj = new TheBr();
                obj.Marks(primaryStage, marks);
                }
            }     
            ));
            autoSlide.play();      
            //End of auto Timer
Text queI10=new Text("Q10.  Don't let the locker get Unlocked!"); 
queI10.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
queI10.setFill( Color.web("white", 0.50) );
queI10.setX(150);
queI10.setY(50);   
Text hint=new Text("Stop all of them from rotating (CLICK TO STOP!)"); 
hint.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
hint.setFill( Color.web("white", 0.40) );
hint.setX(200);
hint.setY(570); 

PathElement [] path =
{
    new MoveTo(400,100),
    new ArcTo(200,200,0,400,100,true,true),
    new ArcTo(200,200,0,200,300,true,true),
    new ArcTo(200,200,0,400,500,true,true),
    new ArcTo(200,200,0,600,300,true,true),
    new ArcTo(200,200,0,400,100,true,true),
    new ClosePath()
 };

Path road = new Path();
road.setStrokeWidth(50);
road.setStrokeLineCap(StrokeLineCap.BUTT);
road.setStroke(Color.web("white", 0.16));
road.getStrokeDashArray().addAll(10d, 5d, 15d, 5d, 10d);
road.setStrokeDashOffset(0);
road.getElements().addAll(path);

    RotateTransition rt=  new RotateTransition();
    rt.setNode(road);
    rt.setFromAngle(0);
    rt.setToAngle(360);
    rt.setInterpolator(Interpolator.LINEAR);
    rt.setCycleCount(Timeline.INDEFINITE);
    rt.setDuration(new Duration(5900));
    rt.setDelay(new Duration(2000));
    rt.play();
    
//Arc 2
PathElement [] path2 =
{
    new MoveTo(400,150),
    new ArcTo(150,150,0,400,150,true,true),
    new ArcTo(150,150,0,250,300,true,true),
    new ArcTo(150,150,0,400,450,true,true),
    new ArcTo(150,150,0,550,300,true,true),
    new ArcTo(150,150,0,400,150,true,true),
    new ClosePath()
 };
Path road2 = new Path();
road2.setStrokeWidth(25);
road2.setStrokeLineCap(StrokeLineCap.BUTT);
road2.setStroke(Color.web("white", 0.25));
road2.getStrokeDashArray().addAll(4d, 2d, 6d, 2d, 4d);
road2.setStrokeDashOffset(0);
road2.getElements().addAll(path2);

    RotateTransition rt2=  new RotateTransition();
    rt2.setNode(road2);
    rt2.setFromAngle(360);
    rt2.setToAngle(0);
    rt2.setInterpolator(Interpolator.LINEAR);
    rt2.setCycleCount(Timeline.INDEFINITE);
    rt2.setDuration(new Duration(5900));
    rt2.setDelay(new Duration(3000));
    rt2.play();  
    
//Arc3

PathElement [] path3 =
{
    new MoveTo(400,200),
    new ArcTo(100,100,0,400,200,true,true),
    new ArcTo(100,100,0,300,300,true,true),
    new ArcTo(100,100,0,400,400,true,true),
    new ArcTo(100,100,0,500,300,true,true),
    new ArcTo(100,100,0,400,200,true,true),
    new ClosePath()
 };
Path road3 = new Path();
road3.setStrokeWidth(50);
road3.setStrokeLineCap(StrokeLineCap.BUTT);
road3.setStroke(Color.web("white", 0.16));
road3.getStrokeDashArray().addAll(3d, 1d, 2d, 1d, 3d);
road3.setStrokeDashOffset(0);
road3.getElements().addAll(path3);

    RotateTransition rt3=  new RotateTransition();
    rt3.setNode(road3);
    rt3.setFromAngle(0);
    rt3.setToAngle(360);
    rt3.setInterpolator(Interpolator.LINEAR);
    rt3.setCycleCount(Timeline.INDEFINITE);
    rt3.setDuration(new Duration(7900));
    rt3.setDelay(new Duration(2500));
    rt3.play(); 
    
    ImageView setg = new ImageView("/thebr/InterMode/setg.png");
    setg.setX(350);
    setg.setY(250);
     RotateTransition rt4=  new RotateTransition();
    rt4.setNode(setg);
    rt4.setFromAngle(360);
    rt4.setToAngle(0);
    rt4.setInterpolator(Interpolator.LINEAR);
    rt4.setCycleCount(Timeline.INDEFINITE);
    rt4.setDuration(new Duration(7900));
    rt4.setDelay(new Duration(2500));
    rt4.play();
//End of arc Reactor
    
//Mouse interaction for bigger circle
road.setOnMouseClicked(me ->
    {
    RotateTransition.Status status = rt.getStatus();
    if (status == RotateTransition.Status.RUNNING &&
    status != RotateTransition.Status.PAUSED)
    {
    rt.pause();
    rt3.play();
    }
    else
    rt.play();
    });

//For medium one
road2.setOnMouseClicked(me ->
    {
    RotateTransition.Status status = rt2.getStatus();
    if (status == RotateTransition.Status.RUNNING &&
    status != RotateTransition.Status.PAUSED)
    {
    rt2.pause();
    rt.play();
    }
    else
    rt2.play();
    });

//For smaller One
road3.setOnMouseClicked(me ->
    {
    RotateTransition.Status status = rt3.getStatus();
    if (status == RotateTransition.Status.RUNNING &&
    status != RotateTransition.Status.PAUSED)
    {
    rt3.pause();
    rt2.play();
    rt.play();
    }
    else
    rt3.play();
    });
        GridPane gchoice=new GridPane();
        gchoice.setAlignment(Pos.CENTER);
        gchoice.setHgap(10);
        gchoice.setVgap(10);
        gchoice.setPadding(new Insets(150,25,25,200));
//Work only after 25550 millis
                try {       
                PauseTransition wait=new PauseTransition(Duration.millis(25550));
                wait.setOnFinished((e)->{  
                        road3.setOnMouseClicked(me ->
                        {
                        RotateTransition.Status status = rt3.getStatus();
                        if (status == RotateTransition.Status.PAUSED)
                        {
                        rt.stop();
                        rt2.stop();
                        rt3.stop();
                        rt4.stop();
                            ImageView choiceR= new ImageView("/thebr/InterMode/correct.png");
                            gchoice.add(choiceR,5,3);
                            TheBr obj = new TheBr();
                            obj.Right(marks);
                            autoSlide.stop();
                            try {       
                            PauseTransition wait2=new PauseTransition(Duration.seconds(1));
                            wait2.setOnFinished((ae)->{  
                            obj.Marks(primaryStage,marks);
                            
				});
                            wait2.play();
                            }
                            catch(Exception ae){
                            System.out.println("Error....Something went wrong!!!!!!");
                        }
                            
                            
                        }
                        else
                        {
                        rt.play();
                        rt2.play();
                        rt3.play();
                            ImageView choiceW= new ImageView("/thebr/InterMode/wrong.png");
                            gchoice.add(choiceW,5,3);
                            TheBr obj = new TheBr();
                            obj.Wrong(marks);
                            autoSlide.stop();
                            
                            try {       
                            PauseTransition wait2=new PauseTransition(Duration.seconds(1));
                            wait2.setOnFinished((ae)->{  
                            obj.Marks(primaryStage,marks);
                            
				});
                            wait2.play();
                            }
                            catch(Exception ae){
                            System.out.println("Error....Something went wrong!!!!!!");
                        }   
                        }
                        });
                        });
                wait.play();
                }
                catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }

           //Stopping all animatins
                            try {       
                            PauseTransition wait2=new PauseTransition(Duration.millis(30000));
                            wait2.setOnFinished((ae)->{  
                            rt.stop();
                            rt2.stop();
                            rt3.stop();
                            rt4.stop();
				});
                            wait2.play();
                            }
                            catch(Exception ae){
                            System.out.println("Error....Something went wrong!!!!!!");
                            }
                
     //Admin control
 GridPane gridadmin = new GridPane();
 gridadmin.setAlignment(Pos.CENTER);
 gridadmin.setHgap(10);
 gridadmin.setVgap(10);
 gridadmin.setPadding(new Insets(0,0,0,0));
 gridadmin.setLayoutX(275);
 gridadmin.setLayoutY(550);
 TheBr obj = new TheBr();
if(admin==1)
{  
 autoSlide.stop();   
 Button prevbtn =new Button("", new ImageView("/thebr/AdminControl/previous.png"));
 gridadmin.add(prevbtn,0,0);
    prevbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Imq9(primaryStage,marks);
    }
    });

 Button relbtn =new Button("", new ImageView("/thebr/AdminControl/reload.png"));
 gridadmin.add(relbtn,1,0);
    relbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Imq10(primaryStage,marks);
    }
    });
 
 Button nextbtn = new Button("", new ImageView("/thebr/AdminControl/next.png"));
 gridadmin.add(nextbtn,2,0);
     nextbtn.setOnAction(new EventHandler<ActionEvent>() {
     public void handle(ActionEvent ae){
     obj.Page2(primaryStage,marks);
     }
     });
     
 Button levelbtn =new Button("", new ImageView("/thebr/AdminControl/level.png"));
 gridadmin.add(levelbtn,3,0);
    levelbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Page2(primaryStage,marks);
    }
    });
} 
 
   //Adding Score View
        Text scrLbl = new Text("Score: ");
        scrLbl.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        scrLbl.setFill( Color.web("BLACK", 0.50) );
        scrLbl.setX(5);
        scrLbl.setY(595);
        
        String myscore= Double.toString(mrk);
        Text scrView= new Text();
        scrView.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
        scrView.setFill( Color.web("WHITE", 0.50) );
        scrView.setText(myscore);
        scrView.setX(63);
        scrView.setY(595);

//Adding close button
Button btnclose = new Button("",new ImageView("/thebr/AdminControl/close.png"));
btnclose.setId("btnclose");
btnclose.setTranslateX(750);
btnclose.setTranslateY(550);
    btnclose.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
        TheBr obj = new TheBr();
        obj.Marks(primaryStage,marks);
        voice.stop();
    }
    });

Image imgb = new Image("/thebr/interback.jpg");
ImageView imgb1 = new ImageView(imgb);
root.getChildren().addAll(imgb1,linesW,linesO,linesR,queI10,road,road2,road3,hint,setg,gridadmin,btnclose,scrLbl,scrView,gchoice);   
Scene scene = new Scene(root, 800, 600, Color.GRAY);
primaryStage.setResizable(false);
primaryStage.setScene(scene);
primaryStage.getIcons().add(new Image("/thebr/TheBrainifyApp.jpg"));
scene.getStylesheets().add(TheBr.class.getResource("inter.css").toExternalForm());			
primaryStage.show();
}           
//############################################End of Intermediate Mode##################################################################


//Advance Mode Q1
int times=0;
public void Amq1(Stage primaryStage, double marks)
{
Group root = new Group();
FlowPane rootNode= new FlowPane();
primaryStage.setTitle("The Brainify App- Advance Mode:"); 

//Timer Line       
        Group linesW = new Group();
        for(int i=0;i<1;i++)
        {
        Line whiteLine = new Line(0, 0, 780, 0);
        whiteLine.setStroke(Color.web("#000000", 0.2));
        whiteLine.setStrokeWidth(40);
        whiteLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesW.getChildren().add(whiteLine);
        }
      
        Group linesO = new Group();
        for(int i=0;i<1;i++)
        {
        Line orangeLine = new Line(0, 0, 780, 0);
        orangeLine.setStroke(Color.web("#F54C0A", 0.4));
        orangeLine.setStrokeWidth(40);
        orangeLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesO.getChildren().add(orangeLine);
        }
            
        Group linesR = new Group();
        for(int i=0;i<1;i++)
        {
        Line redLine = new Line(0, 0, 780, 0);
        redLine.setStroke(Color.web("#FF0000", 0.5));
        redLine.setStrokeWidth(40);
        redLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesR.getChildren().add(redLine);
        }
 
        
        Timeline timeline = new Timeline();
        for (Node whiteLine: linesW.getChildren()) 
        {
        timeline.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(whiteLine.translateXProperty(), -800),
        new KeyValue(whiteLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(18040), 
        new KeyValue(whiteLine.translateXProperty(), -320),
        new KeyValue(whiteLine.translateYProperty(), 0)
                ),
        new KeyFrame(new Duration(18041), 
        new KeyValue(whiteLine.translateXProperty(), -800),
        new KeyValue(whiteLine.translateYProperty(), 0)
                )
                );
        }
        timeline.play();

        Timeline timeline1 = new Timeline();
        for (Node orangeLine: linesO.getChildren())
        {
        timeline1.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(18040), 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),        
        new KeyFrame(new Duration(18040), 
        new KeyValue(orangeLine.translateXProperty(), -320),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ), 
        
        new KeyFrame(new Duration(25550), 
        new KeyValue(orangeLine.translateXProperty(), -120),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),
        new KeyFrame(new Duration(25551), 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    )
                    );
        }
        timeline1.play();

        Timeline timeline2 = new Timeline();
        for (Node redLine: linesR.getChildren())
        {
        timeline2.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(redLine.translateXProperty(), -800),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(25550),
        new KeyValue(redLine.translateXProperty(), -800),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),   
        new KeyFrame(new Duration(25550), 
        new KeyValue(redLine.translateXProperty(), -120),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),       
 
        new KeyFrame(new Duration(30000),
        new KeyValue(redLine.translateXProperty(), 0),
        new KeyValue(redLine.translateYProperty(), 0)
                    )
                    );
        }
        timeline2.play();  
        
        //Timer Lines END
        GridPane gchoice=new GridPane();
        gchoice.setAlignment(Pos.CENTER);
        gchoice.setHgap(10);
        gchoice.setVgap(10);
        gchoice.setPadding(new Insets(150,25,25,200));
        
        
               //Timer start, will skip if no button pressed
            System.out.println("btn pressed before timeline = "+ btnPressed);
            Timeline autoSlide = new Timeline(new KeyFrame(
            Duration.millis(30000),
            ae-> 
            { 
                if(btnPressed==0)
                {//Time out
                System.out.println("marks skipped Adv Mode = "+ marks);
                               
                            ImageView choiceW= new ImageView("/thebr/AdvMode/wrong.png");
                            gchoice.add(choiceW,5,3);
                            TheBr obj = new TheBr();
                            obj.Wrong(marks); 
                           try {       
                            PauseTransition autowrong=new PauseTransition(Duration.seconds(1));
                            autowrong.setOnFinished((a)->{  
                            obj.Amq2(primaryStage,marks);
				});
                            autowrong.play();
                            }
                           catch(Exception a){
                            System.out.println("Error....Something wrong!");
                            }                            
            } 
            }
            ));
            autoSlide.play();      
            //End of auto Timer

Text queA1=new Text("Q1. Bounce the ball atleast 100 times?"); 
queA1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
queA1.setFill( Color.web("white", 0.50) );
queA1.setX(150);
queA1.setY(80);   

ImageView ball= new ImageView("thebr/AdvMode/ball.png");
ball.setX(375);
ball.setY(525);

  PathElement[] path=
{
    new MoveTo(400,550),
    new LineTo(400,550),
    new LineTo(400,250),
    new ClosePath()
};

Path road= new Path();
road.getElements().addAll(path);

PathTransition anim1= new PathTransition();
anim1.setNode(ball);
anim1.setPath(road);
anim1.setInterpolator(Interpolator.EASE_BOTH);
anim1.setDuration(new Duration(100));

    RotateTransition rt=  new RotateTransition();
    rt.setNode(ball);
    rt.setFromAngle(0);
    rt.setToAngle(90);
    rt.setInterpolator(Interpolator.LINEAR);
    rt.setCycleCount(1);
    rt.setDuration(new Duration(300));
    


Image imgb = new Image("/thebr/advback.jpg");
ImageView imgb1 = new ImageView(imgb);  
Scene scene = new Scene(root, 800, 600, Color.GRAY);
primaryStage.setResizable(false);
primaryStage.setScene(scene);
scene.getStylesheets().add(TheBr.class.getResource("inter.css").toExternalForm());			
primaryStage.show();

Text showtime= new Text();
showtime.setId("advtext");
showtime.setX(350);
showtime.setY(200);

scene.setOnKeyPressed(new EventHandler<KeyEvent>()
            {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.SPACE) {
                    anim1.play();
                    rt.play();
                    times++;
                    showtime.setText(Integer.toString(times));
                    if(times==100)
                    {
                            ImageView choiceR= new ImageView("/thebr/AdvMode/correct.png");
                            gchoice.add(choiceR,5,3);
                            TheBr obj = new TheBr();
                            obj.Right(marks);
                            autoSlide.stop();
                           try {       
                            PauseTransition wait=new PauseTransition(Duration.seconds(1));
                            wait.setOnFinished((ae)->{  
                            obj.Amq2(primaryStage,marks);
				});
                            wait.play();
                            }
                           catch(Exception ae){
                            System.out.println("Error....Something wrong!");
                            }
                    }
                    }
            }
            });


     //Admin control
 GridPane gridadmin = new GridPane();
 gridadmin.setAlignment(Pos.CENTER);
 gridadmin.setHgap(10);
 gridadmin.setVgap(10);
 gridadmin.setPadding(new Insets(0,0,0,0));
 gridadmin.setLayoutX(275);
 gridadmin.setLayoutY(550);
 TheBr obj = new TheBr();
if(admin==1)
{  
 autoSlide.stop();   
 Button prevbtn =new Button("", new ImageView("/thebr/AdminControl/previous.png"));
 gridadmin.add(prevbtn,0,0);
    prevbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Amq1(primaryStage,marks);
    }
    });

 Button relbtn =new Button("", new ImageView("/thebr/AdminControl/reload.png"));
 gridadmin.add(relbtn,1,0);
    relbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Amq1(primaryStage,marks);
    }
    });
 
 Button nextbtn = new Button("", new ImageView("/thebr/AdminControl/next.png"));
 gridadmin.add(nextbtn,2,0);
     nextbtn.setOnAction(new EventHandler<ActionEvent>() {
     public void handle(ActionEvent ae){
     obj.Amq2(primaryStage,marks);
     }
     });
     
 Button levelbtn =new Button("", new ImageView("/thebr/AdminControl/level.png"));
 gridadmin.add(levelbtn,3,0);
    levelbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Page2(primaryStage,marks);
    }
    });
} 
else
{
    System.out.println("Hello!");
}

    //Virtual Assistant
     MediaPlayer voice = new MediaPlayer(new Media(TheBr.class.getResource("virtualAssistant/Amq1.mp3").toString())); 
     voice.play();
     
   //Adding Score View
        Text scrLbl = new Text("Score: ");
        scrLbl.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        scrLbl.setFill( Color.web("BLACK", 0.50) );
        scrLbl.setX(5);
        scrLbl.setY(595);
        
        String myscore= Double.toString(mrk);
        Text scrView= new Text();
        scrView.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
        scrView.setFill( Color.web("WHITE", 0.50) );
        scrView.setText(myscore);
        scrView.setX(63);
        scrView.setY(595);

        /*
//Adding close button
Button btnclose = new Button("",new ImageView("/thebr/AdminControl/close.png"));
btnclose.setId("btnclose");
btnclose.setTranslateX(750);
btnclose.setTranslateY(550);
    btnclose.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
        TheBr obj = new TheBr();
        obj.MarksAdv(primaryStage,marks);
        voice.stop();
    }
    });         */  

primaryStage.getIcons().add(new Image("/thebr/TheBrainifyApp.jpg"));
root.getChildren().addAll(imgb1,linesW,linesO,linesR,queA1,ball,showtime,gchoice); 


}   

//AdvanceMode Q2

public void Amq2(Stage primaryStage, double marks)
{
Group root = new Group();
FlowPane rootNode= new FlowPane();
primaryStage.setTitle("The Brainify App- Advance Mode:"); 

Image imgb = new Image("/thebr/advback.jpg");
ImageView imgb1 = new ImageView(imgb);
root.getChildren().add(imgb1);
Scene scene = new Scene(root, 800, 600, Color.BLACK);
primaryStage.setResizable(false);
primaryStage.setScene(scene);
scene.getStylesheets().add(TheBr.class.getResource("inter.css").toExternalForm());			
primaryStage.show();

//Timer Line       
        Group linesW = new Group();
        for(int i=0;i<1;i++)
        {
        Line whiteLine = new Line(0, 0, 780, 0);
        whiteLine.setStroke(Color.web("#000000", 0.2));
        whiteLine.setStrokeWidth(40);
        whiteLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesW.getChildren().add(whiteLine);
        }
      
        Group linesO = new Group();
        for(int i=0;i<1;i++)
        {
        Line orangeLine = new Line(0, 0, 780, 0);
        orangeLine.setStroke(Color.web("#F54C0A", 0.4));
        orangeLine.setStrokeWidth(40);
        orangeLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesO.getChildren().add(orangeLine);
        }
            
        Group linesR = new Group();
        for(int i=0;i<1;i++)
        {
        Line redLine = new Line(0, 0, 780, 0);
        redLine.setStroke(Color.web("#FF0000", 0.5));
        redLine.setStrokeWidth(40);
        redLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesR.getChildren().add(redLine);
        }
 
        
        Timeline timeline = new Timeline();
        for (Node whiteLine: linesW.getChildren()) 
        {
        timeline.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(whiteLine.translateXProperty(), -800),
        new KeyValue(whiteLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(18040), 
        new KeyValue(whiteLine.translateXProperty(), -320),
        new KeyValue(whiteLine.translateYProperty(), 0)
                ),
        new KeyFrame(new Duration(18041), 
        new KeyValue(whiteLine.translateXProperty(), -800),
        new KeyValue(whiteLine.translateYProperty(), 0)
                )
                );
        }
        timeline.play();

        Timeline timeline1 = new Timeline();
        for (Node orangeLine: linesO.getChildren())
        {
        timeline1.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(18040), 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),        
        new KeyFrame(new Duration(18040), 
        new KeyValue(orangeLine.translateXProperty(), -320),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ), 
        
        new KeyFrame(new Duration(25550), 
        new KeyValue(orangeLine.translateXProperty(), -120),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),
        new KeyFrame(new Duration(25551), 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    )
                    );
        }
        timeline1.play();

        Timeline timeline2 = new Timeline();
        for (Node redLine: linesR.getChildren())
        {
        timeline2.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(redLine.translateXProperty(), -800),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(25550),
        new KeyValue(redLine.translateXProperty(), -800),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),   
        new KeyFrame(new Duration(25550), 
        new KeyValue(redLine.translateXProperty(), -120),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),       
 
        new KeyFrame(new Duration(30000),
        new KeyValue(redLine.translateXProperty(), 0),
        new KeyValue(redLine.translateYProperty(), 0)
                    )
                    );
        }
        timeline2.play();  
        
        //Timer Lines END
        GridPane gchoice=new GridPane();
        gchoice.setAlignment(Pos.CENTER);
        gchoice.setHgap(10);
        gchoice.setVgap(10);
        gchoice.setPadding(new Insets(150,25,25,200));
        
        
               //Timer start, will skip if no button pressed
            System.out.println("btn pressed before timeline = "+ btnPressed);
            Timeline autoSlide = new Timeline(new KeyFrame(
            Duration.millis(30000),
            ae-> 
            { 
                System.out.println("marks skipped Adv Mode = "+ marks);
                               
                            ImageView choiceW= new ImageView("/thebr/AdvMode/wrong.png");
                            gchoice.add(choiceW,5,3);
                            TheBr obj = new TheBr();
                            obj.Wrong(marks); 
                           try {       
                            PauseTransition autowrong=new PauseTransition(Duration.seconds(1));
                            autowrong.setOnFinished((a)->{  
                            obj.Amq3(primaryStage,marks);
				});
                            autowrong.play();
                            }
                           catch(Exception a){
                            System.out.println("Error....Something wrong!");
                            }                            
            }
            ));
            autoSlide.play();      
            //End of auto Timer

Text queA2=new Text("Q2. Help the moon in meeting the stars!"); 
queA2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
queA2.setFill( Color.web("white", 0.50) );
queA2.setX(125);
queA2.setY(75); 


        
        Canvas canvas2 = new Canvas(800,600);
        
        ArrayList<String> input = new ArrayList<String>();
        scene.setOnKeyPressed(new EventHandler<KeyEvent>()
        {
            public void handle(KeyEvent e)
            {
                String code = e.getCode().toString();
                if(!input.contains(code))
                input.add(code);
            }
        });
        
        scene.setOnKeyReleased(new EventHandler<KeyEvent>()
        {
            public void handle(KeyEvent e)
            {
                String code = e.getCode().toString();
                input.remove(code);
            }
        });
        GraphicsContext gc = canvas2.getGraphicsContext2D();
        
        Font theFont = Font.font("Helvetica", FontWeight.BOLD,24);
        gc.setFont(theFont);
        gc.setFill(Color.web("white", 0.50));
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(1);
        
                
        Sprite ball = new Sprite();
        ball.setImage(TheBr.class.getResource("/thebr/AdvMode/moonW.png").toString());
        ball.setPosition(375,275);
        
        ArrayList<Sprite> starList = new ArrayList<Sprite>();
        for(int i=0; i<20;i++)
        {
            Sprite star = new Sprite();
            star.setImage(TheBr.class.getResource("/thebr/AdvMode/starW.png").toString());
            double px = 600*Math.random()+50;
            double py = 500 * Math.random()+50;
            star.setPosition(px,py);
            starList.add(star);
        }
        
        LongValue lastNanoTime = new LongValue(System.nanoTime());
        IntValue score= new IntValue(0);
        
        new AnimationTimer()
        {
            public void handle(long currentNanoTime)
            {
          //calculate elapsed time
           double elapsedTime = (currentNanoTime - lastNanoTime.value)/1000000000.0;
           lastNanoTime.value= currentNanoTime;
           
           //Logic
            ball.setVelocity(0,0);
            if(input.contains("LEFT"))
                ball.addVelocity(-50,0);
            if(input.contains("RIGHT"))
                ball.addVelocity(50,0);
            if(input.contains("UP"))
                ball.addVelocity(0,-50);
            if(input.contains("DOWN"))
                ball.addVelocity(0,50);
            
            ball.update(elapsedTime);    
                
           //collision Detection
           
           Iterator<Sprite>starIter= starList.iterator();
           while(starIter.hasNext() )
           {
               Sprite star = starIter.next();
               if(ball.intersects(star))
               {
                   starIter.remove();
                   score.value++;
                   if(score.value++==39)
                   {
                            ImageView choiceR= new ImageView("/thebr/AdvMode/correct.png");
                            gchoice.add(choiceR,5,3);
                            TheBr obj = new TheBr();
                            obj.Right(marks);
                            autoSlide.stop();
                           try {       
                            PauseTransition wait=new PauseTransition(Duration.seconds(1));
                            wait.setOnFinished((ae)->{  
                            obj.Amq3(primaryStage,marks);
				});
                            wait.play();
                            }
                           catch(Exception ae){
                            System.out.println("Error....Something wrong!"); }
                   }
                  
               }
           }
           //render
           gc.clearRect(0,0,800,600);
           ball.render(gc);
           
           for(Sprite star: starList)
           star.render(gc);
           
           //String pointsText = "Cash: $ "+ (100*score.value);
           //gc.fillText(pointsText, 360,36);
           //gc.strokeText(pointsText,360,36);
          }
        }.start();
        
     //Admin control
 GridPane gridadmin = new GridPane();
 gridadmin.setAlignment(Pos.CENTER);
 gridadmin.setHgap(10);
 gridadmin.setVgap(10);
 gridadmin.setPadding(new Insets(0,0,0,0));
 gridadmin.setLayoutX(275);
 gridadmin.setLayoutY(550);
 TheBr obj = new TheBr();
if(admin==1)
{  
 autoSlide.stop();   
 Button prevbtn =new Button("", new ImageView("/thebr/AdminControl/previous.png"));
 gridadmin.add(prevbtn,0,0);
    prevbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Amq1(primaryStage,marks);
    }
    });

 Button relbtn =new Button("", new ImageView("/thebr/AdminControl/reload.png"));
 gridadmin.add(relbtn,1,0);
    relbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Amq2(primaryStage,marks);
    }
    });
 
 Button nextbtn = new Button("", new ImageView("/thebr/AdminControl/next.png"));
 gridadmin.add(nextbtn,2,0);
     nextbtn.setOnAction(new EventHandler<ActionEvent>() {
     public void handle(ActionEvent ae){
     obj.Amq3(primaryStage,marks);
     }
     });
     
 Button levelbtn =new Button("", new ImageView("/thebr/AdminControl/level.png"));
 gridadmin.add(levelbtn,3,0);
    levelbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Page2(primaryStage,marks);
    }
    });
}

    //Virtual Assistant
     MediaPlayer voice = new MediaPlayer(new Media(TheBr.class.getResource("virtualAssistant/Amq2.mp3").toString())); 
     voice.play();

   //Adding Score View
        Text scrLbl = new Text("Score: ");
        scrLbl.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        scrLbl.setFill( Color.web("BLACK", 0.50) );
        scrLbl.setX(5);
        scrLbl.setY(595);
        
        String myscore= Double.toString(mrk);
        Text scrView= new Text();
        scrView.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
        scrView.setFill( Color.web("WHITE", 0.50) );
        scrView.setText(myscore);
        scrView.setX(63);
        scrView.setY(595);

//Adding close button
Button btnclose = new Button("",new ImageView("/thebr/AdminControl/close.png"));
btnclose.setId("btnclose");
btnclose.setTranslateX(750);
btnclose.setTranslateY(550);
    btnclose.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
        TheBr obj = new TheBr();
        obj.MarksAdv(primaryStage,marks);
        voice.stop();
        autoSlide.stop();
    }
    });     
     
primaryStage.getIcons().add(new Image("/thebr/TheBrainifyApp.jpg"));        
root.getChildren().addAll(linesW,linesO,linesR,queA2,canvas2,gridadmin,btnclose,scrLbl,scrView,gchoice); 


}  


//AdvanceMode Q3
public void Amq3(Stage primaryStage, double marks)
{
Group root = new Group();
FlowPane rootNode= new FlowPane();
primaryStage.setTitle("The Brainify App- Advance Mode:"); 

Image imgb = new Image("/thebr/advback.jpg");
ImageView imgb1 = new ImageView(imgb);  
Scene scene = new Scene(root, 800, 600, Color.GRAY);
primaryStage.setResizable(false);
primaryStage.setScene(scene);
scene.getStylesheets().add(TheBr.class.getResource("inter.css").toExternalForm());			


//Timer Line       
        Group linesW = new Group();
        for(int i=0;i<1;i++)
        {
        Line whiteLine = new Line(0, 0, 780, 0);
        whiteLine.setStroke(Color.web("#000000", 0.2));
        whiteLine.setStrokeWidth(40);
        whiteLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesW.getChildren().add(whiteLine);
        }
      
        Group linesO = new Group();
        for(int i=0;i<1;i++)
        {
        Line orangeLine = new Line(0, 0, 780, 0);
        orangeLine.setStroke(Color.web("#F54C0A", 0.4));
        orangeLine.setStrokeWidth(40);
        orangeLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesO.getChildren().add(orangeLine);
        }
            
        Group linesR = new Group();
        for(int i=0;i<1;i++)
        {
        Line redLine = new Line(0, 0, 780, 0);
        redLine.setStroke(Color.web("#FF0000", 0.5));
        redLine.setStrokeWidth(40);
        redLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesR.getChildren().add(redLine);
        }
 
        
        Timeline timeline = new Timeline();
        for (Node whiteLine: linesW.getChildren()) 
        {
        timeline.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(whiteLine.translateXProperty(), -800),
        new KeyValue(whiteLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(18040), 
        new KeyValue(whiteLine.translateXProperty(), -320),
        new KeyValue(whiteLine.translateYProperty(), 0)
                ),
        new KeyFrame(new Duration(18041), 
        new KeyValue(whiteLine.translateXProperty(), -800),
        new KeyValue(whiteLine.translateYProperty(), 0)
                )
                );
        }
        timeline.play();

        Timeline timeline1 = new Timeline();
        for (Node orangeLine: linesO.getChildren())
        {
        timeline1.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(18040), 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),        
        new KeyFrame(new Duration(18040), 
        new KeyValue(orangeLine.translateXProperty(), -320),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ), 
        
        new KeyFrame(new Duration(25550), 
        new KeyValue(orangeLine.translateXProperty(), -120),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),
        new KeyFrame(new Duration(25551), 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    )
                    );
        }
        timeline1.play();

        Timeline timeline2 = new Timeline();
        for (Node redLine: linesR.getChildren())
        {
        timeline2.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(redLine.translateXProperty(), -800),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(25550),
        new KeyValue(redLine.translateXProperty(), -800),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),   
        new KeyFrame(new Duration(25550), 
        new KeyValue(redLine.translateXProperty(), -120),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),       
 
        new KeyFrame(new Duration(30000),
        new KeyValue(redLine.translateXProperty(), 0),
        new KeyValue(redLine.translateYProperty(), 0)
                    )
                    );
        }
        timeline2.play();  
        
        //Timer Lines END
        GridPane gchoice=new GridPane();
        gchoice.setAlignment(Pos.CENTER);
        gchoice.setHgap(10);
        gchoice.setVgap(10);
        gchoice.setPadding(new Insets(150,25,25,200));
        
        
               //Timer start, will skip if no button pressed
            System.out.println("btn pressed before timeline = "+ btnPressed);
            Timeline autoSlide = new Timeline(new KeyFrame(
            Duration.millis(30000),
            ae-> 
            { 
                System.out.println("marks skipped Adv Mode = "+ marks);
                               
                            ImageView choiceW= new ImageView("/thebr/AdvMode/wrong.png");
                            gchoice.add(choiceW,5,3);
                            TheBr obj = new TheBr();
                            obj.Wrong(marks); 
                           try {       
                            PauseTransition autowrong=new PauseTransition(Duration.seconds(1));
                            autowrong.setOnFinished((a)->{  
                            obj.Amq4(primaryStage,marks);
				});
                            autowrong.play();
                            }
                           catch(Exception a){
                            System.out.println("Error....Something wrong!");
                            }                            
            }
            ));
            autoSlide.play();      
            //End of auto Timer
           
            
            
Text queA3=new Text("Q3. Shoot the target until the shots reaches 20?"); 
queA3.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
queA3.setFill( Color.web("white", 0.50) );
queA3.setX(110);
queA3.setY( 75); 

Canvas canvas = new Canvas(800,600);

CircleT targetData= new CircleT(100,100,32);
IntValue points = new IntValue(0);

scene.setOnMouseClicked(new EventHandler<MouseEvent>()
{
    public void handle(MouseEvent e)
    {
        if(targetData.containsPoint(e.getX(),e.getY()))
        {
            double x= 50+ 750*Math.random();
            double y = 50+550 * Math.random();
            targetData.setCenter(x,y);
            points.value++;
            System.out.println(points.value);
            if(points.value==20)
            {
                            ImageView choiceR= new ImageView("/thebr/AdvMode/correct.png");
                            gchoice.add(choiceR,5,3);
                            TheBr obj = new TheBr();
                            obj.Right(marks);
                            autoSlide.stop();
                           try {       
                            PauseTransition wait=new PauseTransition(Duration.seconds(1));
                            wait.setOnFinished((ae)->{  
                            obj.Amq4(primaryStage,marks);
				});
                            wait.play();
                            }
                           catch(Exception ae){
                            System.out.println("Error....Something wrong!"); }    
            }
            
        }
        else
            points.value=points.value-2;
    }
  });

GraphicsContext gc = canvas.getGraphicsContext2D();
Text score = new Text();

Image hitme = new Image(TheBr.class.getResource("/thebr/AdvMode/hitme.png").toString());

new AnimationTimer()
{
    public void handle(long currentNanoTime)
    {
        //clear canvas
        gc.clearRect(0,0,800,600);
        gc.drawImage(hitme,
                targetData.getX()-targetData.getRadius(),
                targetData.getY()-targetData.getRadius());
        gc.setFill(Color.WHITE);
        
        String pointsText = ""+points.value;
        score.setText(pointsText);
        score.setX(375);
        score.setY(200);
        score.setId("advtext");
                
    }   
}.start();

     //Admin control
 GridPane gridadmin = new GridPane();
 gridadmin.setAlignment(Pos.CENTER);
 gridadmin.setHgap(10);
 gridadmin.setVgap(10);
 gridadmin.setPadding(new Insets(0,0,0,0));
 gridadmin.setLayoutX(275);
 gridadmin.setLayoutY(550);
 TheBr obj = new TheBr();
if(admin==1)
{  
 autoSlide.stop();   
 Button prevbtn =new Button("", new ImageView("/thebr/AdminControl/previous.png"));
 gridadmin.add(prevbtn,0,0);
    prevbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Amq2(primaryStage,marks);
    }
    });

 Button relbtn =new Button("", new ImageView("/thebr/AdminControl/reload.png"));
 gridadmin.add(relbtn,1,0);
    relbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Amq3(primaryStage,marks);
    }
    });
 
 Button nextbtn = new Button("", new ImageView("/thebr/AdminControl/next.png"));
 gridadmin.add(nextbtn,2,0);
     nextbtn.setOnAction(new EventHandler<ActionEvent>() {
     public void handle(ActionEvent ae){
     obj.Amq4(primaryStage,marks);
     }
     });
     
 Button levelbtn =new Button("", new ImageView("/thebr/AdminControl/level.png"));
 gridadmin.add(levelbtn,3,0);
    levelbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Page2(primaryStage,marks);
    }
    });
} 

    //Virtual Assistant
     MediaPlayer voice = new MediaPlayer(new Media(TheBr.class.getResource("virtualAssistant/Amq3.mp3").toString())); 
     voice.play();
     
   //Adding Score View
        Text scrLbl = new Text("Score: ");
        scrLbl.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        scrLbl.setFill( Color.web("BLACK", 0.50) );
        scrLbl.setX(5);
        scrLbl.setY(595);
        
        String myscore= Double.toString(mrk);
        Text scrView= new Text();
        scrView.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
        scrView.setFill( Color.web("WHITE", 0.50) );
        scrView.setText(myscore);
        scrView.setX(63);
        scrView.setY(595);

//Adding close button
Button btnclose = new Button("",new ImageView("/thebr/AdminControl/close.png"));
btnclose.setId("btnclose");
btnclose.setTranslateX(750);
btnclose.setTranslateY(550);
    btnclose.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
        TheBr obj = new TheBr();
        obj.MarksAdv(primaryStage,marks);
        voice.stop();
        autoSlide.stop();
    }
    });     
     
primaryStage.getIcons().add(new Image("/thebr/TheBrainifyApp.jpg"));
root.getChildren().addAll(imgb1,linesW,linesO,linesR,queA3,score,canvas,gridadmin,btnclose,scrLbl,scrView,gchoice); 
primaryStage.show();

} 



//AdvanceMode Q4
public void Amq4(Stage primaryStage, double marks)
{
Group root = new Group();
FlowPane rootNode= new FlowPane();
primaryStage.setTitle("The Brainify App- Advance Mode:"); 

Image imgb = new Image("/thebr/advback.jpg");
ImageView imgb1 = new ImageView(imgb);  
Scene scene = new Scene(root, 800, 600, Color.GRAY);
primaryStage.setResizable(false);
primaryStage.setScene(scene);
scene.getStylesheets().add(TheBr.class.getResource("inter.css").toExternalForm());			


//Timer Line       
        Group linesW = new Group();
        for(int i=0;i<1;i++)
        {
        Line whiteLine = new Line(0, 0, 780, 0);
        whiteLine.setStroke(Color.web("#000000", 0.2));
        whiteLine.setStrokeWidth(40);
        whiteLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesW.getChildren().add(whiteLine);
        }
      
        Group linesO = new Group();
        for(int i=0;i<1;i++)
        {
        Line orangeLine = new Line(0, 0, 780, 0);
        orangeLine.setStroke(Color.web("#F54C0A", 0.4));
        orangeLine.setStrokeWidth(40);
        orangeLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesO.getChildren().add(orangeLine);
        }
            
        Group linesR = new Group();
        for(int i=0;i<1;i++)
        {
        Line redLine = new Line(0, 0, 780, 0);
        redLine.setStroke(Color.web("#FF0000", 0.5));
        redLine.setStrokeWidth(40);
        redLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesR.getChildren().add(redLine);
        }
 
        
        Timeline timeline = new Timeline();
        for (Node whiteLine: linesW.getChildren()) 
        {
        timeline.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(whiteLine.translateXProperty(), -800),
        new KeyValue(whiteLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(18040), 
        new KeyValue(whiteLine.translateXProperty(), -320),
        new KeyValue(whiteLine.translateYProperty(), 0)
                ),
        new KeyFrame(new Duration(18041), 
        new KeyValue(whiteLine.translateXProperty(), -800),
        new KeyValue(whiteLine.translateYProperty(), 0)
                )
                );
        }
        timeline.play();

        Timeline timeline1 = new Timeline();
        for (Node orangeLine: linesO.getChildren())
        {
        timeline1.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(18040), 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),        
        new KeyFrame(new Duration(18040), 
        new KeyValue(orangeLine.translateXProperty(), -320),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ), 
        
        new KeyFrame(new Duration(25550), 
        new KeyValue(orangeLine.translateXProperty(), -120),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),
        new KeyFrame(new Duration(25551), 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    )
                    );
        }
        timeline1.play();

        Timeline timeline2 = new Timeline();
        for (Node redLine: linesR.getChildren())
        {
        timeline2.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(redLine.translateXProperty(), -800),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(25550),
        new KeyValue(redLine.translateXProperty(), -800),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),   
        new KeyFrame(new Duration(25550), 
        new KeyValue(redLine.translateXProperty(), -120),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),       
 
        new KeyFrame(new Duration(30000),
        new KeyValue(redLine.translateXProperty(), 0),
        new KeyValue(redLine.translateYProperty(), 0)
                    )
                    );
        }
        timeline2.play();  
        
        //Timer Lines END
        GridPane gchoice=new GridPane();
        gchoice.setAlignment(Pos.CENTER);
        gchoice.setHgap(10);
        gchoice.setVgap(10);
        gchoice.setPadding(new Insets(150,25,25,200));
        
        
               //Timer start, will skip if no button pressed
            System.out.println("btn pressed before timeline = "+ btnPressed);
            Timeline autoSlide = new Timeline(new KeyFrame(
            Duration.millis(30000),
            ae-> 
            { 
                System.out.println("marks skipped Adv Mode = "+ marks);
                               
                            ImageView choiceW= new ImageView("/thebr/AdvMode/wrong.png");
                            gchoice.add(choiceW,5,3);
                            TheBr obj = new TheBr();
                            obj.Wrong(marks); 
                           try {       
                            PauseTransition autowrong=new PauseTransition(Duration.seconds(1));
                            autowrong.setOnFinished((a)->{  
                            obj.Amq5(primaryStage,marks);
				});
                            autowrong.play();
                            }
                           catch(Exception a){
                            System.out.println("Error....Something wrong!");
                            }                            
            }
            ));
            autoSlide.play();      
            //End of auto Timer

Text queA4=new Text("\tQ4.\tI love strawberries!\n\tRaise my hunger meter to 15 !"); 
queA4.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
queA4.setFill( Color.web("white", 0.50) );
queA4.setX(150);
queA4.setY( 50); 

Text lv= new Text();
lv.setId("advtext");

        Canvas canvas2 = new Canvas(800,600);
        
        ArrayList<String> input = new ArrayList<String>();
        scene.setOnKeyPressed(new EventHandler<KeyEvent>()
        {
            public void handle(KeyEvent e)
            {
                String code = e.getCode().toString();
                if(!input.contains(code))
                input.add(code);
            }
        });
        
        scene.setOnKeyReleased(new EventHandler<KeyEvent>()
        {
            public void handle(KeyEvent e)
            {
                String code = e.getCode().toString();
                input.remove(code);
            }
        });
        GraphicsContext gc = canvas2.getGraphicsContext2D();
        
        Font theFont = Font.font("Helvetica", FontWeight.BOLD,24);
        gc.setFont(theFont);
        gc.setFill(Color.web("white", 0.50));
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(1);
        
        Sprite ball = new Sprite();
        ball.setImage(TheBr.class.getResource("/thebr/AdvMode/dotE.gif").toString());
        ball.setPosition(375,275);
        
        ArrayList<Sprite> starList = new ArrayList<Sprite>();
        for(int i=0; i<20;i++)
        {
            Sprite star = new Sprite();
            star.setImage(TheBr.class.getResource("/thebr/AdvMode/dotW.png").toString());
            double px = 600*Math.random()+50;
            double py = 500 * Math.random()+50;
            star.setPosition(px,py);
            starList.add(star);
        }
        
        ArrayList<Sprite> star2List = new ArrayList<Sprite>();        
        for(int i =0; i<20;i++)
        {
            Sprite star2 = new Sprite();
            star2.setImage(TheBr.class.getResource("/thebr/AdvMode/dotB.png").toString());
            double px = 600*Math.random()+50;
            double py = 500 * Math.random()+50;
            star2.setPosition(px+20,py+20);
            star2List.add(star2);
        }
        
        LongValue lastNanoTime = new LongValue(System.nanoTime());
        IntValue score= new IntValue(0);
        
        new AnimationTimer()
        {
            public void handle(long currentNanoTime)
            {
          //calculate elapsed time
           double elapsedTime = (currentNanoTime - lastNanoTime.value)/1000000000.0;
           lastNanoTime.value= currentNanoTime;
           
           //Logic
            ball.setVelocity(0,0);
            if(input.contains("LEFT"))
                ball.addVelocity(-100,0);
            if(input.contains("RIGHT"))
                ball.addVelocity(100,0);
            if(input.contains("UP"))
                ball.addVelocity(0,-100);
            if(input.contains("DOWN"))
                ball.addVelocity(0,100);
            
            ball.update(elapsedTime);    
                        
            //collision Detection for 1
           
           Iterator<Sprite>starIter= starList.iterator();
           while(starIter.hasNext() )
           {
               Sprite star = starIter.next();
               if(ball.intersects(star))
               {
                   starIter.remove();
                   score.value++;
                   System.out.println("Score"+score.value);
                   if(score.value==15)
                    {
                    System.out.println("We Did it");
                     ImageView choiceR= new ImageView("/thebr/AdvMode/correct.png");
                            gchoice.add(choiceR,5,3);
                            TheBr obj = new TheBr();
                            obj.Right(marks);
                            autoSlide.stop();
                           try {       
                            PauseTransition wait=new PauseTransition(Duration.seconds(1));
                            wait.setOnFinished((ae)->{  
                            obj.Amq5(primaryStage,marks);
				});
                            wait.play();
                            }
                           catch(Exception ae){
                            System.out.println("Error....Something wrong!"); }   
                    }
                   
               }
           }
           
           //collision Detection for 2    
           Iterator<Sprite>star2Iter= star2List.iterator();
           while(star2Iter.hasNext() )
           {
               Sprite star2 = star2Iter.next();
               if(ball.intersects(star2))
               {
                   star2Iter.remove();
                   score.value--;
               }
           }

           
           //render
           gc.clearRect(0,0,800,600);
           ball.render(gc);
           
           for(Sprite star: starList)
           star.render(gc);
           
           for(Sprite star2: star2List)
           star2.render(gc);
           
           String pointsText = ""+ (score.value);
           lv.setText(pointsText);
           lv.setX(350);
           lv.setY(580);
          }
        }.start();
        
     //Admin control
 GridPane gridadmin = new GridPane();
 gridadmin.setAlignment(Pos.CENTER);
 gridadmin.setHgap(10);
 gridadmin.setVgap(10);
 gridadmin.setPadding(new Insets(0,0,0,0));
 gridadmin.setLayoutX(275);
 gridadmin.setLayoutY(550);
 TheBr obj = new TheBr();
if(admin==1)
{  
 autoSlide.stop();   
 Button prevbtn =new Button("", new ImageView("/thebr/AdminControl/previous.png"));
 gridadmin.add(prevbtn,0,0);
    prevbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Amq3(primaryStage,marks);
    }
    });

 Button relbtn =new Button("", new ImageView("/thebr/AdminControl/reload.png"));
 gridadmin.add(relbtn,1,0);
    relbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Amq4(primaryStage,marks);
    }
    });
 
 Button nextbtn = new Button("", new ImageView("/thebr/AdminControl/next.png"));
 gridadmin.add(nextbtn,2,0);
     nextbtn.setOnAction(new EventHandler<ActionEvent>() {
     public void handle(ActionEvent ae){
     obj.Amq5(primaryStage,marks);
     }
     });
     
 Button levelbtn =new Button("", new ImageView("/thebr/AdminControl/level.png"));
 gridadmin.add(levelbtn,3,0);
    levelbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Page2(primaryStage,marks);
    }
    });
}         

    //Virtual Assistant
     MediaPlayer voice = new MediaPlayer(new Media(TheBr.class.getResource("virtualAssistant/Amq4.mp3").toString())); 
     voice.play();
     
   //Adding Score View
        Text scrLbl = new Text("Score: ");
        scrLbl.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        scrLbl.setFill( Color.web("BLACK", 0.50) );
        scrLbl.setX(5);
        scrLbl.setY(595);
        
        String myscore= Double.toString(mrk);
        Text scrView= new Text();
        scrView.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
        scrView.setFill( Color.web("WHITE", 0.50) );
        scrView.setText(myscore);
        scrView.setX(63);
        scrView.setY(595);

//Adding close button
Button btnclose = new Button("",new ImageView("/thebr/AdminControl/close.png"));
btnclose.setId("btnclose");
btnclose.setTranslateX(750);
btnclose.setTranslateY(550);
    btnclose.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
        TheBr obj = new TheBr();
        obj.MarksAdv(primaryStage,marks);
        voice.stop();
        autoSlide.stop();
    }
    });     

root.getChildren().addAll(imgb1,linesW,linesO,linesR,lv,canvas2,queA4,gridadmin,btnclose,scrLbl,scrView,gchoice); 
primaryStage.getIcons().add(new Image("/thebr/TheBrainifyApp.jpg"));
primaryStage.show();

}



//AdvanceMode Q5
private String ftext="";
public void Amq5(Stage primaryStage, double marks)
{
Group root = new Group();
FlowPane rootNode= new FlowPane();
primaryStage.setTitle("The Brainify App- Advance Mode:");

Image imgb = new Image("/thebr/advback.jpg");
ImageView imgb1 = new ImageView(imgb);  
Scene scene = new Scene(root, 800, 600);
primaryStage.setResizable(false);
primaryStage.setScene(scene);
scene.getStylesheets().add(TheBr.class.getResource("inter.css").toExternalForm());			


//Timer Line       
        Group linesW = new Group();
        for(int i=0;i<1;i++)
        {
        Line whiteLine = new Line(0, 0, 780, 0);
        whiteLine.setStroke(Color.web("#000000", 0.2));
        whiteLine.setStrokeWidth(40);
        whiteLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesW.getChildren().add(whiteLine);
        }
      
        Group linesO = new Group();
        for(int i=0;i<1;i++)
        {
        Line orangeLine = new Line(0, 0, 780, 0);
        orangeLine.setStroke(Color.web("#F54C0A", 0.4));
        orangeLine.setStrokeWidth(40);
        orangeLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesO.getChildren().add(orangeLine);
        }
            
        Group linesR = new Group();
        for(int i=0;i<1;i++)
        {
        Line redLine = new Line(0, 0, 780, 0);
        redLine.setStroke(Color.web("#FF0000", 0.5));
        redLine.setStrokeWidth(40);
        redLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesR.getChildren().add(redLine);
        }
 
        
        Timeline timeline = new Timeline();
        for (Node whiteLine: linesW.getChildren()) 
        {
        timeline.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(whiteLine.translateXProperty(), -800),
        new KeyValue(whiteLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(18040), 
        new KeyValue(whiteLine.translateXProperty(), -320),
        new KeyValue(whiteLine.translateYProperty(), 0)
                ),
        new KeyFrame(new Duration(18041), 
        new KeyValue(whiteLine.translateXProperty(), -800),
        new KeyValue(whiteLine.translateYProperty(), 0)
                )
                );
        }
        timeline.play();

        Timeline timeline1 = new Timeline();
        for (Node orangeLine: linesO.getChildren())
        {
        timeline1.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(18040), 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),        
        new KeyFrame(new Duration(18040), 
        new KeyValue(orangeLine.translateXProperty(), -320),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ), 
        
        new KeyFrame(new Duration(25550), 
        new KeyValue(orangeLine.translateXProperty(), -120),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),
        new KeyFrame(new Duration(25551), 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    )
                    );
        }
        timeline1.play();

        Timeline timeline2 = new Timeline();
        for (Node redLine: linesR.getChildren())
        {
        timeline2.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(redLine.translateXProperty(), -800),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(25550),
        new KeyValue(redLine.translateXProperty(), -800),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),   
        new KeyFrame(new Duration(25550), 
        new KeyValue(redLine.translateXProperty(), -120),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),       
 
        new KeyFrame(new Duration(30000),
        new KeyValue(redLine.translateXProperty(), 0),
        new KeyValue(redLine.translateYProperty(), 0)
                    )
                    );
        }
        timeline2.play();  
        
        //Timer Lines END
        GridPane gchoice=new GridPane();
        gchoice.setAlignment(Pos.CENTER);
        gchoice.setHgap(10);
        gchoice.setVgap(10);
        gchoice.setPadding(new Insets(150,25,25,200));
        
        
               //Timer start, will skip if no button pressed
            System.out.println("btn pressed before timeline = "+ btnPressed);
            Timeline autoSlide = new Timeline(new KeyFrame(
            Duration.millis(30000),
            ae-> 
            { 
                System.out.println("marks skipped Adv Mode = "+ marks);
                               
                            ImageView choiceW= new ImageView("/thebr/AdvMode/wrong.png");
                            gchoice.add(choiceW,5,3);
                            TheBr obj = new TheBr();
                            obj.Wrong(marks); 
                           try {       
                            PauseTransition autowrong=new PauseTransition(Duration.seconds(1));
                            autowrong.setOnFinished((a)->{  
                            obj.Amq6(primaryStage,marks);
				});
                            autowrong.play();
                            }
                           catch(Exception a){
                            System.out.println("Error....Something wrong!");
                            }                            
            }
            ));
            autoSlide.play();      
            //End of auto Timer
            
Text queA5=new Text("Q5. Tap the focussed letters ?"); 
queA5.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
queA5.setFill( Color.web("white", 0.50) );
queA5.setX(200);
queA5.setY( 75); 

        GridPane grid1=new GridPane();
        grid1.setAlignment(Pos.CENTER);
        grid1.setHgap(10);
        grid1.setVgap(10);
        grid1.setPadding(new Insets(400,25,25,215));
String[] keys = {"Q","W", "E","R","T","Y","U","I","O","P","A", "S", "D","F","G","H","J","K","L","@","Z","X", "C","V","B","N","M","?"};

Text textFlow = new Text();
textFlow.setText("S\t\t\t\t\tH\t\t\t\tA\t\t\tM\t\tW\t\tE\t\tE\tL");
textFlow.setId("flowtext");

ImageView mon = new ImageView("/thebr/AdvMode/mon.png");
mon.setX(350);
mon.setY(300);

ImageView alpha= new ImageView("/thebr/AdvMode/alpha.png");
alpha.setX(350);
alpha.setY(150);

    RotateTransition rt=  new RotateTransition();
    rt.setNode(alpha);
    rt.setFromAngle(0);
    rt.setToAngle(360);
    rt.setInterpolator(Interpolator.LINEAR);
    rt.setCycleCount(Timeline.INDEFINITE);
    rt.setDuration(new Duration(5900));
    rt.setDelay(new Duration(2000));
    rt.play();

PathElement[] path =
{
    new MoveTo(1600,200),
    new LineTo(1600,200),
    new LineTo(-800,200)
};

Path road= new Path();
road.getElements().addAll(path);

PathTransition anim= new PathTransition();
anim.setNode(textFlow);
anim.setPath(road);
anim.setInterpolator(Interpolator.EASE_IN);
anim.setDelay(new Duration(3000));
anim.setDuration(new Duration(30000));
anim.setCycleCount(Timeline.INDEFINITE);
anim.play();

        Text act = new Text();
        act.setId("flowtextOver");
        
for(int i=0;i<28;i++)
{
Button btn = new Button(keys[i]);
btn.setId("keyboardbtn");
if(i<=9)
grid1.add(btn, i%10, 0);   
if(i>9&&i<=19)
grid1.add(btn, i%10,1);   
if(i>19&&i<=27)
grid1.add(btn, i%19,2);  

//btn Action
        btn.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent ae) {
        act.setText(btn.getText());
        act.setX(385);
        act.setY(357);
        //concat
            String s= btn.getText();
            ftext=ftext.concat(s);
            System.out.println(ftext);
            if(ftext.equals("SHAMWEEL"))
            {
                ImageView choiceR= new ImageView("/thebr/AdvMode/correct.png");
                gchoice.add(choiceR,0,0);
                TheBr obj = new TheBr();
                obj.Right(marks);
                autoSlide.stop();
                try {       
                PauseTransition wait=new PauseTransition(Duration.seconds(1));
                wait.setOnFinished((e)->{  
                obj.Amq6(primaryStage,marks);
				});
                wait.play();
                }
                catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
            }
                
        }
        });

}
Button btnSpace= new Button("\t\t\t\t\t\t\t\t\t");
btnSpace.setId("keyboardbtn");
grid1.add(btnSpace,2,3,6,1);

     //Admin control
 GridPane gridadmin = new GridPane();
 gridadmin.setAlignment(Pos.CENTER);
 gridadmin.setHgap(10);
 gridadmin.setVgap(10);
 gridadmin.setPadding(new Insets(0,0,0,0));
 gridadmin.setLayoutX(275);
 gridadmin.setLayoutY(550);
 TheBr obj = new TheBr();
if(admin==1)
{  
 autoSlide.stop();   
 Button prevbtn =new Button("", new ImageView("/thebr/AdminControl/previous.png"));
 gridadmin.add(prevbtn,0,0);
    prevbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Amq4(primaryStage,marks);
    }
    });

 Button relbtn =new Button("", new ImageView("/thebr/AdminControl/reload.png"));
 gridadmin.add(relbtn,1,0);
    relbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Amq5(primaryStage,marks);
    }
    });
 
 Button nextbtn = new Button("", new ImageView("/thebr/AdminControl/next.png"));
 gridadmin.add(nextbtn,2,0);
     nextbtn.setOnAction(new EventHandler<ActionEvent>() {
     public void handle(ActionEvent ae){
     obj.Amq6(primaryStage,marks);
     }
     });
     
 Button levelbtn =new Button("", new ImageView("/thebr/AdminControl/level.png"));
 gridadmin.add(levelbtn,3,0);
    levelbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Page2(primaryStage,marks);
    }
    });
} 

    //Virtual Assistant
     MediaPlayer voice = new MediaPlayer(new Media(TheBr.class.getResource("virtualAssistant/Amq5.mp3").toString())); 
     voice.play();

   //Adding Score View
        Text scrLbl = new Text("Score: ");
        scrLbl.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        scrLbl.setFill( Color.web("BLACK", 0.50) );
        scrLbl.setX(5);
        scrLbl.setY(595);
        
        String myscore= Double.toString(mrk);
        Text scrView= new Text();
        scrView.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
        scrView.setFill( Color.web("WHITE", 0.50) );
        scrView.setText(myscore);
        scrView.setX(63);
        scrView.setY(595);

//Adding close button
Button btnclose = new Button("",new ImageView("/thebr/AdminControl/close.png"));
btnclose.setId("btnclose");
btnclose.setTranslateX(750);
btnclose.setTranslateY(550);
    btnclose.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
        TheBr obj = new TheBr();
        obj.MarksAdv(primaryStage,marks);
        voice.stop();
        autoSlide.stop();
    }
    });
    
root.getChildren().addAll(imgb1,linesW,linesO,linesR,queA5,grid1,textFlow,alpha,mon,act,gridadmin,btnclose,scrLbl,scrView,gchoice);
primaryStage.getIcons().add(new Image("/thebr/TheBrainifyApp.jpg"));
primaryStage.show();

}


//Advance Mode Q6
private String ftext6="";
public void Amq6(Stage primaryStage, double marks)
{
Group root = new Group();
FlowPane rootNode= new FlowPane();
primaryStage.setTitle("The Brainify App- Advance Mode:"); 

Image imgb = new Image("/thebr/advback.jpg");
ImageView imgb1 = new ImageView(imgb);  
Scene scene = new Scene(root, 800, 600);
primaryStage.setResizable(false);
primaryStage.setScene(scene);
scene.getStylesheets().add(TheBr.class.getResource("inter.css").toExternalForm());			


//Timer Line       
        Group linesW = new Group();
        for(int i=0;i<1;i++)
        {
        Line whiteLine = new Line(0, 0, 780, 0);
        whiteLine.setStroke(Color.web("#000000", 0.2));
        whiteLine.setStrokeWidth(40);
        whiteLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesW.getChildren().add(whiteLine);
        }
      
        Group linesO = new Group();
        for(int i=0;i<1;i++)
        {
        Line orangeLine = new Line(0, 0, 780, 0);
        orangeLine.setStroke(Color.web("#F54C0A", 0.4));
        orangeLine.setStrokeWidth(40);
        orangeLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesO.getChildren().add(orangeLine);
        }
            
        Group linesR = new Group();
        for(int i=0;i<1;i++)
        {
        Line redLine = new Line(0, 0, 780, 0);
        redLine.setStroke(Color.web("#FF0000", 0.5));
        redLine.setStrokeWidth(40);
        redLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesR.getChildren().add(redLine);
        }
 
        
        Timeline timeline = new Timeline();
        for (Node whiteLine: linesW.getChildren()) 
        {
        timeline.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(whiteLine.translateXProperty(), -800),
        new KeyValue(whiteLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(18040), 
        new KeyValue(whiteLine.translateXProperty(), -320),
        new KeyValue(whiteLine.translateYProperty(), 0)
                ),
        new KeyFrame(new Duration(18041), 
        new KeyValue(whiteLine.translateXProperty(), -800),
        new KeyValue(whiteLine.translateYProperty(), 0)
                )
                );
        }
        timeline.play();

        Timeline timeline1 = new Timeline();
        for (Node orangeLine: linesO.getChildren())
        {
        timeline1.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(18040), 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),        
        new KeyFrame(new Duration(18040), 
        new KeyValue(orangeLine.translateXProperty(), -320),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ), 
        
        new KeyFrame(new Duration(25550), 
        new KeyValue(orangeLine.translateXProperty(), -120),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),
        new KeyFrame(new Duration(25551), 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    )
                    );
        }
        timeline1.play();

        Timeline timeline2 = new Timeline();
        for (Node redLine: linesR.getChildren())
        {
        timeline2.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(redLine.translateXProperty(), -800),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(25550),
        new KeyValue(redLine.translateXProperty(), -800),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),   
        new KeyFrame(new Duration(25550), 
        new KeyValue(redLine.translateXProperty(), -120),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),       
 
        new KeyFrame(new Duration(30000),
        new KeyValue(redLine.translateXProperty(), 0),
        new KeyValue(redLine.translateYProperty(), 0)
                    )
                    );
        }
        timeline2.play();  
        
        //Timer Lines END
        GridPane gchoice=new GridPane();
        gchoice.setAlignment(Pos.CENTER);
        gchoice.setHgap(10);
        gchoice.setVgap(10);
        gchoice.setPadding(new Insets(150,25,25,200));
        
        
               //Timer start, will skip if no button pressed
            System.out.println("btn pressed before timeline = "+ btnPressed);
            Timeline autoSlide = new Timeline(new KeyFrame(
            Duration.millis(30000),
            ae-> 
            { 
                System.out.println("marks skipped Adv Mode = "+ marks);
                               
                            ImageView choiceW= new ImageView("/thebr/AdvMode/wrong.png");
                            gchoice.add(choiceW,5,3);
                            TheBr obj = new TheBr();
                            obj.Wrong(marks); 
                           try {       
                            PauseTransition autowrong=new PauseTransition(Duration.seconds(1));
                            autowrong.setOnFinished((a)->{  
                            obj.Amq7(primaryStage,marks);
				});
                            autowrong.play();
                            }
                           catch(Exception a){
                            System.out.println("Error....Something wrong!");
                            }                            
            }
            ));
            autoSlide.play();      
            //End of auto Timer
            
Text queA6=new Text("Q6. Unlock the locker ?"); 
queA6.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
queA6.setFill( Color.web("black", 0.50) );
queA6.setX(300);
queA6.setY( 400); 

//Inner Circle
PathElement[] path1= 
{
    new MoveTo(400,150),
    new ArcTo(50,50,0,400,150,true,true),
    new ArcTo(50,50,0,350,200,true,true),
    new ArcTo(50,50,0,400,250,true,true),
    new ArcTo(50,50,0,450,200,true,true),
    new ArcTo(50,50,0,400,150,true,true),
    new ClosePath()
};

Path road1 = new Path();
road1.setStrokeWidth(50);
road1.setStrokeLineCap(StrokeLineCap.BUTT);
road1.setStroke(Color.web("#0F1010", 0.16));
road1.getStrokeDashArray().addAll(3d, 1d, 2d, 1d, 3d);
road1.setStrokeDashOffset(0);
road1.getElements().addAll(path1);

    RotateTransition rt1=  new RotateTransition();
    rt1.setNode(road1);
    rt1.setFromAngle(0);
    rt1.setToAngle(360);
    rt1.setInterpolator(Interpolator.LINEAR);
    rt1.setCycleCount(Timeline.INDEFINITE);
    rt1.setDuration(new Duration(7900));
    rt1.setDelay(new Duration(2500));
    rt1.play();

//Medium Circle
PathElement[] path2= 
{
    new MoveTo(400,100),
    new ArcTo(100,100,0,400,100,true,true),
    new ArcTo(100,100,0,300,200,true,true),
    new ArcTo(100,100,0,400,300,true,true),
    new ArcTo(100,100,0,500,200,true,true),
    new ArcTo(100,100,0,400,100,true,true),
};

Path road2 = new Path();
road2.setStrokeWidth(25);
road2.setStrokeLineCap(StrokeLineCap.BUTT);
road2.setStroke(Color.web("#0F1010", 0.4));
road2.getStrokeDashArray().addAll(4d, 2d, 6d, 2d, 4d);
road2.setStrokeDashOffset(0);
road2.getElements().addAll(path2);

    RotateTransition rt2=  new RotateTransition();
    rt2.setNode(road2);
    rt2.setFromAngle(360);
    rt2.setToAngle(0);
    rt2.setInterpolator(Interpolator.LINEAR);
    rt2.setCycleCount(Timeline.INDEFINITE);
    rt2.setDuration(new Duration(7900));
    rt2.setDelay(new Duration(2500));
    rt2.play();
    
//Outer Circle
PathElement[] path3= 
{
    new MoveTo(400,50),
    new ArcTo(150,150,0,400,50,true,true),
    new ArcTo(150,150,0,250,200,true,true),
    new ArcTo(150,150,0,400,350,true,true),
    new ArcTo(150,150,0,550,200,true,true),
    new ArcTo(150,150,0,400,50,true,true),
};

Path road3 = new Path();
road3.setStrokeWidth(50);
road3.setStrokeLineCap(StrokeLineCap.BUTT);
road3.setStroke(Color.web("#0F1010", 0.16));
road3.getStrokeDashArray().addAll(7d, 2d, 10d, 2d, 7d);
road3.setStrokeDashOffset(0);
road3.getElements().addAll(path3);

    RotateTransition rt3=  new RotateTransition();
    rt3.setNode(road3);
    rt3.setFromAngle(0);
    rt3.setToAngle(360);
    rt3.setInterpolator(Interpolator.LINEAR);
    rt3.setCycleCount(Timeline.INDEFINITE);
    rt3.setDuration(new Duration(7900));
    rt3.setDelay(new Duration(2500));
    rt3.play();

  
//Password Hint

 Text text = new Text();
 text.setId("flowtextOverB");
 text.setText("Hint: Which word in the dictionary is spelled incorrectly?");
 text.setX(210);
 text.setY(417);
 
        Text act = new Text();
        act.setId("flowtextOverBD");

        GridPane grid1=new GridPane();
        grid1.setAlignment(Pos.CENTER);
        grid1.setHgap(10);
        grid1.setVgap(10);
        grid1.setPadding(new Insets(425,25,25,215));
String[] keys = {"Q","W", "E","R","T","Y","U","I","O","P","A", "S", "D","F","G","H","J","K","L","@","Z","X", "C","V","B","N","M","?"};

for(int i=0;i<28;i++)
{
Button btn = new Button(keys[i]);
btn.setId("keyboardbtn6");
if(i<=9)
grid1.add(btn, i%10, 0);   
if(i>9&&i<=19)
grid1.add(btn, i%10,1);   
if(i>19&&i<=27)
grid1.add(btn, i%19,2);  

//btn Action
        btn.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent ae) {
        act.setText(btn.getText());
        act.setX(387);
        act.setY(213);
        //concat
            String s= btn.getText();
            ftext6=ftext6.concat(s);
            System.out.println(ftext6);
            if(ftext6.equals("INCORRECTLY"))
            {
                rt1.stop();
                rt2.stop();
                rt3.stop();
                ImageView choiceR= new ImageView("/thebr/AdvMode/correct.png");
                gchoice.add(choiceR,0,0);
                TheBr obj = new TheBr();
                obj.Right(marks);
                autoSlide.stop();
                try {       
                PauseTransition wait=new PauseTransition(Duration.seconds(1));
                wait.setOnFinished((e)->{  
                obj.Amq7(primaryStage,marks);
				});
                wait.play();
                }
                catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
            }
                
        }
        });





}

Button btnSpace= new Button("\t\t\t\t\t\t\t\t\t");
btnSpace.setId("keyboardbtn6");
grid1.add(btnSpace,2,3,6,1);

     //Admin control
 GridPane gridadmin = new GridPane();
 gridadmin.setAlignment(Pos.CENTER);
 gridadmin.setHgap(10);
 gridadmin.setVgap(10);
 gridadmin.setPadding(new Insets(0,0,0,0));
 gridadmin.setLayoutX(275);
 gridadmin.setLayoutY(550);
 TheBr obj = new TheBr();
if(admin==1)
{  
 autoSlide.stop();   
 Button prevbtn =new Button("", new ImageView("/thebr/AdminControl/previous.png"));
 gridadmin.add(prevbtn,0,0);
    prevbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Amq5(primaryStage,marks);
    }
    });

 Button relbtn =new Button("", new ImageView("/thebr/AdminControl/reload.png"));
 gridadmin.add(relbtn,1,0);
    relbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Amq6(primaryStage,marks);
    }
    });
 
 Button nextbtn = new Button("", new ImageView("/thebr/AdminControl/next.png"));
 gridadmin.add(nextbtn,2,0);
     nextbtn.setOnAction(new EventHandler<ActionEvent>() {
     public void handle(ActionEvent ae){
     obj.Amq7(primaryStage,marks);
     }
     });
     
 Button levelbtn =new Button("", new ImageView("/thebr/AdminControl/level.png"));
 gridadmin.add(levelbtn,3,0);
    levelbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Page2(primaryStage,marks);
    }
    });
} 

    //Virtual Assistant
     MediaPlayer voice = new MediaPlayer(new Media(TheBr.class.getResource("virtualAssistant/Amq6.mp3").toString())); 
     voice.play();
 
   //Adding Score View
        Text scrLbl = new Text("Score: ");
        scrLbl.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        scrLbl.setFill( Color.web("BLACK", 0.50) );
        scrLbl.setX(5);
        scrLbl.setY(595);
        
        String myscore= Double.toString(mrk);
        Text scrView= new Text();
        scrView.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
        scrView.setFill( Color.web("WHITE", 0.50) );
        scrView.setText(myscore);
        scrView.setX(63);
        scrView.setY(595);

//Adding close button
Button btnclose = new Button("",new ImageView("/thebr/AdminControl/close.png"));
btnclose.setId("btnclose");
btnclose.setTranslateX(750);
btnclose.setTranslateY(550);
    btnclose.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
        TheBr obj = new TheBr();
        obj.MarksAdv(primaryStage,marks);
        voice.stop();
        autoSlide.stop();
    }
    });     
     
root.getChildren().addAll(imgb1,linesW,linesO,linesR,queA6,road1,road2,road3,text,act,grid1,gridadmin,btnclose,scrLbl,scrView,gchoice); 
primaryStage.getIcons().add(new Image("/thebr/TheBrainifyApp.jpg"));
primaryStage.show();

}

//Advance Mode Q7

static Image left;
static Image leftH;

static Image right;
static Image rightH;

static Image up;
static Image upH;

static Image down;
static Image downH;
static GraphicsContext graphicsContext;
static HashSet<String>currentlyActiveKeys;

int lclicks=0;
int rclicks=0;
int uclicks=0;
int dclicks=0;
public void Amq7(Stage primaryStage, double marks)
{
Group root = new Group();
FlowPane rootNode= new FlowPane();
primaryStage.setTitle("The Brainify App- Advance Mode:"); 

Image imgb = new Image("/thebr/advback.jpg");
ImageView imgb1 = new ImageView(imgb);  
Scene scene = new Scene(root, 800, 600);
primaryStage.setResizable(false);
primaryStage.setScene(scene);
scene.getStylesheets().add(TheBr.class.getResource("inter.css").toExternalForm());			


//Timer Line       
        Group linesW = new Group();
        for(int i=0;i<1;i++)
        {
        Line whiteLine = new Line(0, 0, 780, 0);
        whiteLine.setStroke(Color.web("#000000", 0.2));
        whiteLine.setStrokeWidth(40);
        whiteLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesW.getChildren().add(whiteLine);
        }
      
        Group linesO = new Group();
        for(int i=0;i<1;i++)
        {
        Line orangeLine = new Line(0, 0, 780, 0);
        orangeLine.setStroke(Color.web("#F54C0A", 0.4));
        orangeLine.setStrokeWidth(40);
        orangeLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesO.getChildren().add(orangeLine);
        }
            
        Group linesR = new Group();
        for(int i=0;i<1;i++)
        {
        Line redLine = new Line(0, 0, 780, 0);
        redLine.setStroke(Color.web("#FF0000", 0.5));
        redLine.setStrokeWidth(40);
        redLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesR.getChildren().add(redLine);
        }
 
        
        Timeline timeline = new Timeline();
        for (Node whiteLine: linesW.getChildren()) 
        {
        timeline.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(whiteLine.translateXProperty(), -800),
        new KeyValue(whiteLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(18040), 
        new KeyValue(whiteLine.translateXProperty(), -320),
        new KeyValue(whiteLine.translateYProperty(), 0)
                ),
        new KeyFrame(new Duration(18041), 
        new KeyValue(whiteLine.translateXProperty(), -800),
        new KeyValue(whiteLine.translateYProperty(), 0)
                )
                );
        }
        timeline.play();

        Timeline timeline1 = new Timeline();
        for (Node orangeLine: linesO.getChildren())
        {
        timeline1.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(18040), 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),        
        new KeyFrame(new Duration(18040), 
        new KeyValue(orangeLine.translateXProperty(), -320),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ), 
        
        new KeyFrame(new Duration(25550), 
        new KeyValue(orangeLine.translateXProperty(), -120),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),
        new KeyFrame(new Duration(25551), 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    )
                    );
        }
        timeline1.play();

        Timeline timeline2 = new Timeline();
        for (Node redLine: linesR.getChildren())
        {
        timeline2.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(redLine.translateXProperty(), -800),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(25550),
        new KeyValue(redLine.translateXProperty(), -800),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),   
        new KeyFrame(new Duration(25550), 
        new KeyValue(redLine.translateXProperty(), -120),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),       
 
        new KeyFrame(new Duration(30000),
        new KeyValue(redLine.translateXProperty(), 0),
        new KeyValue(redLine.translateYProperty(), 0)
                    )
                    );
        }
        timeline2.play();  
        
        //Timer Lines END
        GridPane gchoice=new GridPane();
        gchoice.setAlignment(Pos.CENTER);
        gchoice.setHgap(10);
        gchoice.setVgap(10);
        gchoice.setPadding(new Insets(150,25,25,200));
        
        
               //Timer start, will skip if no button pressed
            System.out.println("btn pressed before timeline = "+ btnPressed);
            Timeline autoSlide = new Timeline(new KeyFrame(
            Duration.millis(30000),
            ae-> 
            { 
                System.out.println("marks skipped Adv Mode = "+ marks);
                               
                            ImageView choiceW= new ImageView("/thebr/AdvMode/wrong.png");
                            gchoice.add(choiceW,5,3);
                            TheBr obj = new TheBr();
                            obj.Wrong(marks); 
                           try {       
                            PauseTransition autowrong=new PauseTransition(Duration.seconds(1));
                            autowrong.setOnFinished((a)->{  
                            obj.Amq8(primaryStage,marks);
				});
                            autowrong.play();
                            }
                           catch(Exception a){
                            System.out.println("Error....Something wrong!");
                            }                            
            }
            ));
            autoSlide.play();      
            //End of auto Timer
            
Text queA7=new Text("Q7.  We are under alien attack?\tSave our world!\n      Play the repel music as the pointer describes!"); 
queA7.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
queA7.setFill( Color.web("BLACK", 0.50) );
queA7.setX(175);
queA7.setY( 500); 

//Sound Alien
Media alienL = new Media(TheBr.class.getResource("sound/alienL.mp3").toString());
MediaPlayer alienLP = new MediaPlayer(alienL);

Media alienR = new Media(TheBr.class.getResource("sound/alienR.mp3").toString());
MediaPlayer alienRP = new MediaPlayer(alienR);

Media alienU = new Media(TheBr.class.getResource("sound/alienU.mp3").toString());
MediaPlayer alienUP = new MediaPlayer(alienU);

Media alienD = new Media(TheBr.class.getResource("sound/alienD.mp3").toString());
MediaPlayer alienDP = new MediaPlayer(alienD);

//Key listen
currentlyActiveKeys = new HashSet<String>();
scene.setOnKeyPressed(new EventHandler<KeyEvent>()
{
    @Override
    public void handle(KeyEvent event)
    {
        currentlyActiveKeys.add(event.getCode().toString());
         if(event.getCode().equals(KeyCode.DOWN))
           {
               dclicks++;
               //System.out.println("Down"+dclicks);
           }
         if(event.getCode().equals(KeyCode.UP))
           {
               uclicks++;
              // System.out.println("UP"+uclicks);
           }
         if(event.getCode().equals(KeyCode.LEFT))
           {
               lclicks++;
               //System.out.println("LEFT"+lclicks);
           }
         if(event.getCode().equals(KeyCode.RIGHT))
           {
               rclicks++;
               //System.out.println("RIGHT"+rclicks);
           }
              if((lclicks>=60&&lclicks<=80)&&(rclicks==75)&&(uclicks>=10&&uclicks<=30)&&(dclicks>=10&&dclicks<=30))
              {
                ImageView choiceR= new ImageView("/thebr/AdvMode/correct.png");
                gchoice.add(choiceR,0,0);
                TheBr obj = new TheBr();
                obj.Right(marks);
                autoSlide.stop();
                try {       
                PauseTransition wait=new PauseTransition(Duration.seconds(1));
                wait.setOnFinished((e)->{  
                obj.Amq8(primaryStage,marks);
				});
                wait.play();
                }
                catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
              }              
    }
});
 scene.setOnKeyReleased(new EventHandler<KeyEvent>()
 {
     @Override
     public void handle(KeyEvent event)
     {
         currentlyActiveKeys.remove(event.getCode().toString());
     }
 });
 //Controls
 Image left = new Image(TheBr.class.getResource("/thebr/AdvMode/l1.png").toString());
 Image leftH = new Image(TheBr.class.getResource("/thebr/AdvMode/l2.png").toString());
 Image right = new Image(TheBr.class.getResource("/thebr/AdvMode/r1.png").toString());
 Image rightH = new Image(TheBr.class.getResource("/thebr/AdvMode/r2.png").toString());
 Image up = new Image(TheBr.class.getResource("/thebr/AdvMode/u1.png").toString());
 Image upH = new Image(TheBr.class.getResource("/thebr/AdvMode/u2.png").toString());
 Image down = new Image(TheBr.class.getResource("/thebr/AdvMode/d1.png").toString());
 Image downH = new Image(TheBr.class.getResource("/thebr/AdvMode/d2.png").toString());
 
 //Slave
 Image left3 = new Image(TheBr.class.getResource("/thebr/AdvMode/3B.png").toString());
 Image leftH3 = new Image(TheBr.class.getResource("/thebr/AdvMode/3W.png").toString());
 Image right6 = new Image(TheBr.class.getResource("/thebr/AdvMode/6B.png").toString());
 Image rightH6 = new Image(TheBr.class.getResource("/thebr/AdvMode/6W.png").toString());
 Image up4 = new Image(TheBr.class.getResource("/thebr/AdvMode/4B.png").toString());
 Image upH4 = new Image(TheBr.class.getResource("/thebr/AdvMode/4W.png").toString());
 Image down2 = new Image(TheBr.class.getResource("/thebr/AdvMode/2B.png").toString());
 Image downH2 = new Image(TheBr.class.getResource("/thebr/AdvMode/2W.png").toString());
 
 ImageView power = new ImageView("/thebr/AdvMode/power.png");
 power.setX(350);
 power.setY(250);
    RotateTransition rt=  new RotateTransition();
    rt.setNode(power);
    rt.setFromAngle(0);
    rt.setToAngle(360);
    rt.setInterpolator(Interpolator.LINEAR);
    rt.setCycleCount(Timeline.INDEFINITE);
    rt.setDuration(new Duration(7900));
    rt.setDelay(new Duration(2500));
    rt.play();
    
        Canvas canvas = new Canvas(400, 400);
        canvas.setTranslateX(150);
        canvas.setTranslateY(50);
        graphicsContext = canvas.getGraphicsContext2D();
        
        //Starting animation
         new AnimationTimer()
        {
            public void handle(long currentNanoTime)
            {
        graphicsContext.clearRect(0, 0, 400, 400);

        if (currentlyActiveKeys.contains("LEFT"))
        {
            graphicsContext.drawImage(leftH, 150 ,200);
            graphicsContext.drawImage(leftH3, 100 ,225);
            alienLP.play();
        }
        else
        {
            graphicsContext.drawImage(left, 150 ,200);
            graphicsContext.drawImage(left3, 100 ,225);
            alienLP.stop();
        }
        
        if (currentlyActiveKeys.contains("RIGHT"))
        {
            graphicsContext.drawImage(rightH, 250,200 );
            graphicsContext.drawImage(rightH6, 350 ,225);
            alienRP.play();
        }
        else
        {
            graphicsContext.drawImage(right, 250, 200);
            graphicsContext.drawImage(right6, 350 ,225);
            alienRP.stop();
        }
        
        if (currentlyActiveKeys.contains("UP"))
        {
            graphicsContext.drawImage(upH, 200, 150);
            graphicsContext.drawImage(upH4, 225 ,100);
            alienUP.play();
        }
        else
        {
            graphicsContext.drawImage(up, 200, 150);
            graphicsContext.drawImage(up4, 225 ,100);
            alienUP.stop();
        }
        
        if (currentlyActiveKeys.contains("DOWN"))
        {
            graphicsContext.drawImage(downH, 200, 250);
            graphicsContext.drawImage(downH2, 225 ,350);           
            alienDP.play();
        }
        else
        {
            graphicsContext.drawImage(down, 200, 250);
            graphicsContext.drawImage(down2, 225 ,350);
            alienDP.stop();
        } 
            }
        }.start();

ImageView W2 = new ImageView("/thebr/AdvMode/2B.png");
W2.setX(300);
W2.setY(50);
ImageView W6 = new ImageView("/thebr/AdvMode/6B.png");
W6.setX(350);
W6.setY(50);
ImageView W4 = new ImageView("/thebr/AdvMode/4B.png");
W4.setX(400);
W4.setY(50);
ImageView W3 = new ImageView("/thebr/AdvMode/3B.png");
W3.setX(450);
W3.setY(50);

ImageView align = new ImageView("/thebr/AdvMode/align.png");
Timeline bar = new Timeline();
bar.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(align.translateXProperty(), 380),
        new KeyValue(align.translateYProperty(), 275)
                    ),
        
        new KeyFrame(new Duration(2000),
        new KeyValue(align.translateXProperty(), 380),
        new KeyValue(align.translateYProperty(), 275)
                    ),   
        new KeyFrame(new Duration(5000), 
        new KeyValue(align.translateXProperty(), 357),
        new KeyValue(align.translateYProperty(), 100)
                    ),       
 
        new KeyFrame(new Duration(7000),
        new KeyValue(align.translateXProperty(), 357),
        new KeyValue(align.translateYProperty(), 100)
                    ),
        new KeyFrame(new Duration(9000),
        new KeyValue(align.translateXProperty(), 457),
        new KeyValue(align.translateYProperty(), 100)
                    ),
        new KeyFrame(new Duration(11000),
        new KeyValue(align.translateXProperty(), 457),
        new KeyValue(align.translateYProperty(), 100)
                    ), 
        new KeyFrame(new Duration(14000),
        new KeyValue(align.translateXProperty(), 307),
        new KeyValue(align.translateYProperty(), 100)
                    ), 
        new KeyFrame(new Duration(16000),
        new KeyValue(align.translateXProperty(), 307),
        new KeyValue(align.translateYProperty(), 100)
                    ),   
        new KeyFrame(new Duration(18000),
        new KeyValue(align.translateXProperty(), 407),
        new KeyValue(align.translateYProperty(), 100)
                    ),  
        new KeyFrame(new Duration(20000),
        new KeyValue(align.translateXProperty(), 407),
        new KeyValue(align.translateYProperty(), 100)
                    ), 
        new KeyFrame(new Duration(21000),
        new KeyValue(align.translateXProperty(), 357),
        new KeyValue(align.translateYProperty(), 100)
                    ),
        new KeyFrame(new Duration(23000),
        new KeyValue(align.translateXProperty(), 357),
        new KeyValue(align.translateYProperty(), 100)
                    ),
        new KeyFrame(new Duration(24000),
        new KeyValue(align.translateXProperty(), 457),
        new KeyValue(align.translateYProperty(), 100)
                    ), 
        new KeyFrame(new Duration(26000),
        new KeyValue(align.translateXProperty(), 457),
        new KeyValue(align.translateYProperty(), 100)
                    ),
        new KeyFrame(new Duration(27000),
        new KeyValue(align.translateXProperty(), 357),
        new KeyValue(align.translateYProperty(), 100)
                    )        
                    );
        bar.play();
        
     //Admin control
 GridPane gridadmin = new GridPane();
 gridadmin.setAlignment(Pos.CENTER);
 gridadmin.setHgap(10);
 gridadmin.setVgap(10);
 gridadmin.setPadding(new Insets(0,0,0,0));
 gridadmin.setLayoutX(275);
 gridadmin.setLayoutY(550);
 TheBr obj = new TheBr();
if(admin==1)
{  
 autoSlide.stop();   
 Button prevbtn =new Button("", new ImageView("/thebr/AdminControl/previous.png"));
 gridadmin.add(prevbtn,0,0);
    prevbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Amq6(primaryStage,marks);
    }
    });

 Button relbtn =new Button("", new ImageView("/thebr/AdminControl/reload.png"));
 gridadmin.add(relbtn,1,0);
    relbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Amq7(primaryStage,marks);
    }
    });
 
 Button nextbtn = new Button("", new ImageView("/thebr/AdminControl/next.png"));
 gridadmin.add(nextbtn,2,0);
     nextbtn.setOnAction(new EventHandler<ActionEvent>() {
     public void handle(ActionEvent ae){
     obj.Amq8(primaryStage,marks);
     }
     });
     
 Button levelbtn =new Button("", new ImageView("/thebr/AdminControl/level.png"));
 gridadmin.add(levelbtn,3,0);
    levelbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Page2(primaryStage,marks);
    }
    });
} 

    //Virtual Assistant
     MediaPlayer voice = new MediaPlayer(new Media(TheBr.class.getResource("virtualAssistant/Amq7.mp3").toString())); 
     voice.play();

   //Adding Score View
        Text scrLbl = new Text("Score: ");
        scrLbl.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        scrLbl.setFill( Color.web("BLACK", 0.50) );
        scrLbl.setX(5);
        scrLbl.setY(595);
        
        String myscore= Double.toString(mrk);
        Text scrView= new Text();
        scrView.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
        scrView.setFill( Color.web("WHITE", 0.50) );
        scrView.setText(myscore);
        scrView.setX(63);
        scrView.setY(595);

//Adding close button
Button btnclose = new Button("",new ImageView("/thebr/AdminControl/close.png"));
btnclose.setId("btnclose");
btnclose.setTranslateX(750);
btnclose.setTranslateY(550);
    btnclose.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
        TheBr obj = new TheBr();
        obj.MarksAdv(primaryStage,marks);
        voice.stop();
        autoSlide.stop();
    }
    });     
     
root.getChildren().addAll(imgb1,linesW,linesO,linesR,align,canvas,power,W2,W3,W4,W6,queA7,gridadmin,btnclose,scrLbl,scrView,gchoice);
primaryStage.getIcons().add(new Image("/thebr/TheBrainifyApp.jpg"));
primaryStage.show();

}

//Advance Mode Q8
int piano=0;
public void Amq8(Stage primaryStage, double marks)
{
Group root = new Group();
FlowPane rootNode= new FlowPane();
primaryStage.setTitle("The Brainify App- Advance Mode:"); 

Image imgb = new Image("/thebr/advback.jpg");
ImageView imgb1 = new ImageView(imgb);  
Scene scene = new Scene(root, 800, 600);
primaryStage.setResizable(false);
primaryStage.setScene(scene);
scene.getStylesheets().add(TheBr.class.getResource("inter.css").toExternalForm());			


//Timer Line       
        Group linesW = new Group();
        for(int i=0;i<1;i++)
        {
        Line whiteLine = new Line(0, 0, 780, 0);
        whiteLine.setStroke(Color.web("#000000", 0.2));
        whiteLine.setStrokeWidth(40);
        whiteLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesW.getChildren().add(whiteLine);
        }
      
        Group linesO = new Group();
        for(int i=0;i<1;i++)
        {
        Line orangeLine = new Line(0, 0, 780, 0);
        orangeLine.setStroke(Color.web("#F54C0A", 0.4));
        orangeLine.setStrokeWidth(40);
        orangeLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesO.getChildren().add(orangeLine);
        }
            
        Group linesR = new Group();
        for(int i=0;i<1;i++)
        {
        Line redLine = new Line(0, 0, 780, 0);
        redLine.setStroke(Color.web("#FF0000", 0.5));
        redLine.setStrokeWidth(40);
        redLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesR.getChildren().add(redLine);
        }
 
        
        Timeline timeline = new Timeline();
        for (Node whiteLine: linesW.getChildren()) 
        {
        timeline.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(whiteLine.translateXProperty(), -800),
        new KeyValue(whiteLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(18040), 
        new KeyValue(whiteLine.translateXProperty(), -320),
        new KeyValue(whiteLine.translateYProperty(), 0)
                ),
        new KeyFrame(new Duration(18041), 
        new KeyValue(whiteLine.translateXProperty(), -800),
        new KeyValue(whiteLine.translateYProperty(), 0)
                )
                );
        }
        timeline.play();

        Timeline timeline1 = new Timeline();
        for (Node orangeLine: linesO.getChildren())
        {
        timeline1.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(18040), 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),        
        new KeyFrame(new Duration(18040), 
        new KeyValue(orangeLine.translateXProperty(), -320),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ), 
        
        new KeyFrame(new Duration(25550), 
        new KeyValue(orangeLine.translateXProperty(), -120),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),
        new KeyFrame(new Duration(25551), 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    )
                    );
        }
        timeline1.play();

        Timeline timeline2 = new Timeline();
        for (Node redLine: linesR.getChildren())
        {
        timeline2.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(redLine.translateXProperty(), -800),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(25550),
        new KeyValue(redLine.translateXProperty(), -800),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),   
        new KeyFrame(new Duration(25550), 
        new KeyValue(redLine.translateXProperty(), -120),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),       
 
        new KeyFrame(new Duration(30000),
        new KeyValue(redLine.translateXProperty(), 0),
        new KeyValue(redLine.translateYProperty(), 0)
                    )
                    );
        }
        timeline2.play();  
        
        //Timer Lines END
        GridPane gchoice=new GridPane();
        gchoice.setAlignment(Pos.CENTER);
        gchoice.setHgap(10);
        gchoice.setVgap(10);
        gchoice.setPadding(new Insets(150,25,25,200));
        
        
               //Timer start, will skip if no button pressed
            System.out.println("btn pressed before timeline = "+ btnPressed);
            Timeline autoSlide = new Timeline(new KeyFrame(
            Duration.millis(30000),
            ae-> 
            { 
                System.out.println("marks skipped Adv Mode = "+ marks);
                               
                            ImageView choiceW= new ImageView("/thebr/AdvMode/wrong.png");
                            gchoice.add(choiceW,5,3);
                            TheBr obj = new TheBr();
                            obj.Wrong(marks); 
                           try {       
                            PauseTransition autowrong=new PauseTransition(Duration.seconds(1));
                            autowrong.setOnFinished((a)->{  
                            obj.Amq9(primaryStage,marks);
				});
                            autowrong.play();
                            }
                           catch(Exception a){
                            System.out.println("Error....Something wrong!");
                            }                            
            }
            ));
            autoSlide.play();      
            //End of auto Timer
            
Text queA8=new Text("Q8.  Play the pattern?"); 
queA8.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
queA8.setFill( Color.web("BLACK", 0.50) );
queA8.setX(250);
queA8.setY(75);

Text pattern = new Text("A S D F J K L ;\t\t A S D F J K L ;\t\t A S D F J K L ;\t\tA S D F J K L ;\t\tA S D F J K L ;\t\t\t A S D F J K L ;");
pattern.setId("flowtextOverBD");
TranslateTransition p = new TranslateTransition(Duration.millis(25000), pattern);
p.setFromX(800);
p.setToX(-2200);
p.setFromY(150);
p.setToY(150);
p.setCycleCount(1);
p.setInterpolator(Interpolator.EASE_BOTH);
p.setDelay(Duration.millis(2000));
p.play();

ImageView touch = new ImageView("/thebr/AdvMode/touch.png");
touch.setX(390);
touch.setY(150);

//Embedding sound
Media n1 = new Media(TheBr.class.getResource("sound/Note1.mp3").toString());
MediaPlayer note1 = new MediaPlayer(n1);

Media n2 = new Media(TheBr.class.getResource("sound/Note2.mp3").toString());
MediaPlayer note2 = new MediaPlayer(n2);

Media n3 = new Media(TheBr.class.getResource("sound/Note3.mp3").toString());
MediaPlayer note3 = new MediaPlayer(n3);

Media n4 = new Media(TheBr.class.getResource("sound/Note4.mp3").toString());
MediaPlayer note4 = new MediaPlayer(n4);

Media n5 = new Media(TheBr.class.getResource("sound/Note5.mp3").toString());
MediaPlayer note5 = new MediaPlayer(n5);

Media n6 = new Media(TheBr.class.getResource("sound/Note6.mp3").toString());
MediaPlayer note6 = new MediaPlayer(n6);

Media n7 = new Media(TheBr.class.getResource("sound/Note7.mp3").toString());
MediaPlayer note7 = new MediaPlayer(n7);

Media n8 = new Media(TheBr.class.getResource("sound/Note8.mp3").toString());
MediaPlayer note8 = new MediaPlayer(n8);


//Line Bar
ImageView bar = new ImageView(TheBr.class.getResource("/thebr/AdvMode/bar.png").toString());
TranslateTransition t1 = new TranslateTransition(Duration.millis(100), bar);
t1.setFromX(75);
t1.setToX(75);
t1.setFromY(500);
t1.setToY(350);
t1.setCycleCount(Transition.INDEFINITE);
t1.setInterpolator(Interpolator.LINEAR);

TranslateTransition t2 = new TranslateTransition(Duration.millis(100), bar);
t2.setFromX(150);
t2.setToX(150);
t2.setFromY(500);
t2.setToY(350);
t2.setCycleCount(Transition.INDEFINITE);
t2.setInterpolator(Interpolator.LINEAR);

TranslateTransition t3 = new TranslateTransition(Duration.millis(100), bar);
t3.setFromX(225);
t3.setToX(225);
t3.setFromY(500);
t3.setToY(350);
t3.setCycleCount(Transition.INDEFINITE);
t3.setInterpolator(Interpolator.LINEAR);

TranslateTransition t4 = new TranslateTransition(Duration.millis(100), bar);
t4.setFromX(325);
t4.setToX(325);
t4.setFromY(500);
t4.setToY(350);
t4.setCycleCount(Transition.INDEFINITE);
t4.setInterpolator(Interpolator.LINEAR);

TranslateTransition t5 = new TranslateTransition(Duration.millis(100), bar);
t5.setFromX(450);
t5.setToX(450);
t5.setFromY(500);
t5.setToY(350);
t5.setCycleCount(Transition.INDEFINITE);
t5.setInterpolator(Interpolator.LINEAR);

TranslateTransition t6 = new TranslateTransition(Duration.millis(100), bar);
t6.setFromX(525);
t6.setToX(525);
t6.setFromY(500);
t6.setToY(350);
t6.setCycleCount(Transition.INDEFINITE);
t6.setInterpolator(Interpolator.LINEAR);

TranslateTransition t7 = new TranslateTransition(Duration.millis(100), bar);
t7.setFromX(600);
t7.setToX(600);
t7.setFromY(500);
t7.setToY(350);
t7.setCycleCount(Transition.INDEFINITE);
t7.setInterpolator(Interpolator.LINEAR);

TranslateTransition t8 = new TranslateTransition(Duration.millis(100), bar);
t8.setFromX(675);
t8.setToX(675);
t8.setFromY(500);
t8.setToY(350);
t8.setCycleCount(Transition.INDEFINITE);
t8.setInterpolator(Interpolator.LINEAR);

//Key listen
HashSet<String>currentlyActiveKeys1;
currentlyActiveKeys1 = new HashSet<String>();
scene.setOnKeyPressed(new EventHandler<KeyEvent>()
{
    @Override
    public void handle(KeyEvent event)
    {
        currentlyActiveKeys1.add(event.getCode().toString());
        piano++;
        if(piano==45)
              {
                ImageView choiceR= new ImageView("/thebr/AdvMode/correct.png");
                gchoice.add(choiceR,0,0);
                TheBr obj = new TheBr();
                obj.Right(marks);
                autoSlide.stop();
                try {       
                PauseTransition wait=new PauseTransition(Duration.seconds(1));
                wait.setOnFinished((e)->{  
                obj.Amq9(primaryStage,marks);
				});
                wait.play();
                }
                catch(Exception e){
		System.out.println("Error....Something went wrong!!!!!!");
                }
              }              
            }
});

 scene.setOnKeyReleased(new EventHandler<KeyEvent>()
 {
     @Override
     public void handle(KeyEvent event)
     {
         currentlyActiveKeys1.remove(event.getCode().toString());
     }
 });
 
 //Adding play button image
Image mB = new Image(TheBr.class.getResource("/thebr/AdvMode/musicW.png").toString());
Image mW = new Image(TheBr.class.getResource("/thebr/AdvMode/musicB.png").toString());

        GraphicsContext gc;
        Canvas canvas = new Canvas(800, 600);
       // canvas.setTranslateX(150);
       //canvas.setTranslateY(50);
        gc = canvas.getGraphicsContext2D();
        
        
        //Starting animation
         new AnimationTimer()
        {
            public void handle(long currentNanoTime)
            {
          gc.clearRect(0, 0, 800, 600);
          if (currentlyActiveKeys1.contains("A"))
        {
            gc.drawImage(mB, 75 ,250);
            note1.play();
            t1.play();
        }
        else
        {
            gc.drawImage(mW, 75 ,250);
            note1.stop();
            t1.playFromStart();
            t1.stop();
        }
        
          if (currentlyActiveKeys1.contains("S"))
        {
            gc.drawImage(mB, 150 ,250);
            note2.play();
            t2.play();
        }
        else
        {
            gc.drawImage(mW, 150 ,250);
            note2.stop();
            t2.playFromStart();
            t2.stop();
        }  
          if (currentlyActiveKeys1.contains("D"))
        {
            gc.drawImage(mB, 225 ,250);
            note3.play();
            t3.play();
        }
        else
        {
            gc.drawImage(mW, 225 ,250);
            note3.stop();
            t3.playFromStart();
            t3.stop();
        }   
        if (currentlyActiveKeys1.contains("F"))
        {
            gc.drawImage(mB, 300 ,250);
            note4.play();
            t4.play();
        }
        else
        {
            gc.drawImage(mW, 300 ,250);
            note4.stop();
            t4.playFromStart();
            t4.stop();
        }  
          
        
        if (currentlyActiveKeys1.contains("J"))
        {
            gc.drawImage(mB, 450 ,250);
            note5.play();
            t5.play();
        }
        else
        {
            gc.drawImage(mW, 450 ,250);
            note5.stop();
            t5.playFromStart();
            t5.stop();
        } 
        
         if (currentlyActiveKeys1.contains("K"))
        {
            gc.drawImage(mB, 525 ,250);
            note6.play();
            t6.play();
        }
        else
        {
            gc.drawImage(mW, 525 ,250);
            note6.stop();
            t6.playFromStart();
            t6.stop();
        } 
         
        if (currentlyActiveKeys1.contains("L"))
        {
            gc.drawImage(mB,600 ,250);
            note7.play();
            t7.play();
        }
        else
        {
            gc.drawImage(mW, 600 ,250);
            note7.stop();
            t7.playFromStart();
            t7.stop();
        } 
        
        if (currentlyActiveKeys1.contains("SEMICOLON"))
        {
            gc.drawImage(mB,675 ,250);
            note8.play();
            t8.play();
        }
        else
        {
            gc.drawImage(mW, 675 ,250);
            note8.stop();
            t8.playFromStart();
            t8.stop();
        } 
                
                
                    }
        }.start();

 Text noteText = new Text("A     S    D     F\t\t   J     K     L     ;");
 noteText.setId("flowtextOverBD");
 noteText.setX(87);
 noteText.setY(350);
 
 
      //Admin control
 GridPane gridadmin = new GridPane();
 gridadmin.setAlignment(Pos.CENTER);
 gridadmin.setHgap(10);
 gridadmin.setVgap(10);
 gridadmin.setPadding(new Insets(0,0,0,0));
 gridadmin.setLayoutX(275);
 gridadmin.setLayoutY(550);
 TheBr obj = new TheBr();
if(admin==1)
{  
 autoSlide.stop();   
 Button prevbtn =new Button("", new ImageView("/thebr/AdminControl/previous.png"));
 gridadmin.add(prevbtn,0,0);
    prevbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Amq7(primaryStage,marks);
    }
    });

 Button relbtn =new Button("", new ImageView("/thebr/AdminControl/reload.png"));
 gridadmin.add(relbtn,1,0);
    relbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Amq8(primaryStage,marks);
    }
    });
 
 Button nextbtn = new Button("", new ImageView("/thebr/AdminControl/next.png"));
 gridadmin.add(nextbtn,2,0);
     nextbtn.setOnAction(new EventHandler<ActionEvent>() {
     public void handle(ActionEvent ae){
     obj.Amq9(primaryStage,marks);
     }
     });
     
 Button levelbtn =new Button("", new ImageView("/thebr/AdminControl/level.png"));
 gridadmin.add(levelbtn,3,0);
    levelbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Page2(primaryStage,marks);
    }
    });
} 
    
    //Virtual Assistant
     MediaPlayer voice = new MediaPlayer(new Media(TheBr.class.getResource("virtualAssistant/Amq8.mp3").toString())); 
     voice.play();
     
   //Adding Score View
        Text scrLbl = new Text("Score: ");
        scrLbl.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        scrLbl.setFill( Color.web("BLACK", 0.50) );
        scrLbl.setX(5);
        scrLbl.setY(595);
        
        String myscore= Double.toString(mrk);
        Text scrView= new Text();
        scrView.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
        scrView.setFill( Color.web("WHITE", 0.50) );
        scrView.setText(myscore);
        scrView.setX(63);
        scrView.setY(595);

//Adding close button
Button btnclose = new Button("",new ImageView("/thebr/AdminControl/close.png"));
btnclose.setId("btnclose");
btnclose.setTranslateX(750);
btnclose.setTranslateY(550);
    btnclose.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
        TheBr obj = new TheBr();
        obj.MarksAdv(primaryStage,marks);
        voice.stop();
        autoSlide.stop();
    }
    });
     

root.getChildren().addAll(imgb1,linesW,linesO,linesR,queA8,canvas,bar,noteText,pattern,touch,gridadmin,btnclose,scrLbl,scrView,gchoice); 
primaryStage.getIcons().add(new Image("/thebr/TheBrainifyApp.jpg"));
primaryStage.show();

}



//Advance Mode Q9
int colorCube=0;
int colorCylinder=0;
public void Amq9(Stage primaryStage, double marks)
{
Group root = new Group();
FlowPane rootNode= new FlowPane();
primaryStage.setTitle("The Brainify App- Advance Mode:"); 

Image imgb = new Image("/thebr/advback.jpg");
ImageView imgb1 = new ImageView(imgb);  
Scene scene = new Scene(root, 800, 600);
//primaryStage.setResizable(false);
primaryStage.setScene(scene);
scene.getStylesheets().add(TheBr.class.getResource("inter.css").toExternalForm());			


//Timer Line       
        Group linesW = new Group();
        for(int i=0;i<1;i++)
        {
        Line whiteLine = new Line(0, 0, 780, 0);
        whiteLine.setStroke(Color.web("#000000", 0.2));
        whiteLine.setStrokeWidth(40);
        whiteLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesW.getChildren().add(whiteLine);
        }
      
        Group linesO = new Group();
        for(int i=0;i<1;i++)
        {
        Line orangeLine = new Line(0, 0, 780, 0);
        orangeLine.setStroke(Color.web("#F54C0A", 0.4));
        orangeLine.setStrokeWidth(40);
        orangeLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesO.getChildren().add(orangeLine);
        }
            
        Group linesR = new Group();
        for(int i=0;i<1;i++)
        {
        Line redLine = new Line(0, 0, 780, 0);
        redLine.setStroke(Color.web("#FF0000", 0.5));
        redLine.setStrokeWidth(40);
        redLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesR.getChildren().add(redLine);
        }
 
        
        Timeline timeline = new Timeline();
        for (Node whiteLine: linesW.getChildren()) 
        {
        timeline.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(whiteLine.translateXProperty(), -800),
        new KeyValue(whiteLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(18040), 
        new KeyValue(whiteLine.translateXProperty(), -320),
        new KeyValue(whiteLine.translateYProperty(), 0)
                ),
        new KeyFrame(new Duration(18041), 
        new KeyValue(whiteLine.translateXProperty(), -800),
        new KeyValue(whiteLine.translateYProperty(), 0)
                )
                );
        }
        timeline.play();

        Timeline timeline1 = new Timeline();
        for (Node orangeLine: linesO.getChildren())
        {
        timeline1.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(18040), 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),        
        new KeyFrame(new Duration(18040), 
        new KeyValue(orangeLine.translateXProperty(), -320),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ), 
        
        new KeyFrame(new Duration(25550), 
        new KeyValue(orangeLine.translateXProperty(), -120),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),
        new KeyFrame(new Duration(25551), 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    )
                    );
        }
        timeline1.play();

        Timeline timeline2 = new Timeline();
        for (Node redLine: linesR.getChildren())
        {
        timeline2.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(redLine.translateXProperty(), -800),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(25550),
        new KeyValue(redLine.translateXProperty(), -800),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),   
        new KeyFrame(new Duration(25550), 
        new KeyValue(redLine.translateXProperty(), -120),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),       
 
        new KeyFrame(new Duration(30000),
        new KeyValue(redLine.translateXProperty(), 0),
        new KeyValue(redLine.translateYProperty(), 0)
                    )
                    );
        }
        timeline2.play();  
        
        //Timer Lines END
        GridPane gchoice=new GridPane();
        gchoice.setAlignment(Pos.CENTER);
        gchoice.setHgap(10);
        gchoice.setVgap(10);
        gchoice.setPadding(new Insets(150,25,25,200));
        
        
               //Timer start, will skip if no button pressed
            System.out.println("btn pressed before timeline = "+ btnPressed);
            Timeline autoSlide = new Timeline(new KeyFrame(
            Duration.millis(30000),
            ae-> 
            { 
                System.out.println("marks skipped Adv Mode = "+ marks);
                               
                            ImageView choiceW= new ImageView("/thebr/AdvMode/wrong.png");
                            gchoice.add(choiceW,5,3);
                            TheBr obj = new TheBr();
                            obj.Wrong(marks); 
                           try {       
                            PauseTransition autowrong=new PauseTransition(Duration.seconds(1));
                            autowrong.setOnFinished((a)->{  
                            obj.Amq10(primaryStage,marks);
				});
                            autowrong.play();
                            }
                           catch(Exception a){
                            System.out.println("Error....Something wrong!");
                            }                            
            }
            ));
            autoSlide.play();      
            //End of auto Timer
            
Text queA9=new Text("Q9.  Color the objects in order?"); 
queA9.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
queA9.setId("3D");
queA9.setFill( Color.web("BLACK", 0.50) );
queA9.setX(200);
queA9.setY(75);

Text cubeText=new Text("Cube"); 
cubeText.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 30));
cubeText.setId("3D");
cubeText.setFill( Color.web("#4d001a", 1.0) );
cubeText.setX(175);
cubeText.setY(175);

Text cynText=new Text("Cylinder"); 
cynText.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 30));
cynText.setId("3D");
cynText.setFill( Color.web("#e6e6b3", 1.0) );
cynText.setX(525);
cynText.setY(175);
//Adding Camera
PerspectiveCamera camera = new PerspectiveCamera(true);
camera.setTranslateZ(-1000);
camera.setTranslateX(421);
camera.setTranslateY(316);
camera.setNearClip(0.1);
camera.setFarClip(2000.0);
camera.setFieldOfView(35);
scene.setCamera(camera);

ColorPicker cp = new ColorPicker();
cp.setId("colorPicker");
cp.setLayoutX(150);
cp.setLayoutY(425);

//Filling Material Box
PhongMaterial blueStuff = new PhongMaterial();

blueStuff.setSpecularColor(Color.BLUE);


Box box = new Box(100, 100, 100);
box.setMaterial(blueStuff);
box.setTranslateX(250);
box.setTranslateY(300);
box.setTranslateZ(-100);

Rotate rxBox = new Rotate(0, 0, 0, 0, Rotate.X_AXIS);
Rotate ryBox = new Rotate(0, 0, 0, 0, Rotate.Y_AXIS);
Rotate rzBox = new Rotate(0, 0, 0, 0, Rotate.Z_AXIS);
rxBox.setAngle(30);
ryBox.setAngle(50);
rzBox.setAngle(30);
box.getTransforms().addAll(rxBox, ryBox, rzBox);

RotateTransition rt1 = new RotateTransition();
rt1.setNode(box);
rt1.setDuration(Duration.millis(3000));
rt1.setAxis(Rotate.Z_AXIS);
rt1.setByAngle(360);
rt1.setCycleCount(Animation.INDEFINITE);
rt1.setInterpolator(Interpolator.LINEAR);
rt1.play();

//Cylinder
ColorPicker cp2 = new ColorPicker();
cp2.setId("colorPicker");
cp2.setLayoutX(525);
cp2.setLayoutY(425);


PhongMaterial cStuff = new PhongMaterial();
cp.setOnAction(e ->
{
blueStuff.setDiffuseColor(cp.getValue());
String hex1= Integer.toHexString(cp.getValue().hashCode()).substring(0,6).toUpperCase();
//System.out.println("cp= "+hex1);
if(hex1.equals("4D001A"))
    colorCube=1;
else
    colorCube=0;

    //cp2 color change
    cp2.setOnAction(e2 ->
    {
    cStuff.setDiffuseColor(cp2.getValue());
    String hex2= Integer.toHexString(cp2.getValue().hashCode()).substring(0,6).toUpperCase();
    //System.out.println("cp2= "+hex2);
    if(hex2.equals("FFFFCC"))
        colorCylinder=1;
    else
        colorCylinder=0;
                
                //Getting right
                if(colorCube==1 && colorCylinder==1)
                {
                ImageView choiceR= new ImageView("/thebr/AdvMode/correct.png");
                gchoice.add(choiceR,0,0);
                TheBr obj = new TheBr();
                obj.Right(marks);
                autoSlide.stop();
                try {       
                PauseTransition wait=new PauseTransition(Duration.seconds(1));
                wait.setOnFinished((ew)->{  
                obj.Amq10(primaryStage,marks);
				});
                wait.play();
                }
                catch(Exception ec){
		System.out.println("Error....Something went wrong!!!!!!");
                }   
                }


    } );

});


cStuff.setSpecularColor(Color.BLUE);

Cylinder cylinder = new Cylinder(100,50);
cylinder.setMaterial(cStuff);
cylinder.setTranslateX(625);
cylinder.setTranslateY(300);
cylinder.setTranslateZ(200);

RotateTransition rt2 = new RotateTransition();
rt2.setNode(cylinder);
rt2.setDuration(Duration.millis(3000));
rt2.setAxis(Rotate.X_AXIS);
rt2.setByAngle(360);
rt2.setCycleCount(Animation.INDEFINITE);
rt2.setInterpolator(Interpolator.LINEAR);
rt2.play();

//Light Source
PointLight light = new PointLight(Color.WHITE);
light.setTranslateX(-1000);
light.setTranslateY(100);
light.setTranslateZ(-1000);
System.out.println("ColorCube=" + colorCube+ " Cylinder= "+colorCylinder);

      //Admin control
 GridPane gridadmin = new GridPane();
 gridadmin.setAlignment(Pos.CENTER);
 gridadmin.setHgap(10);
 gridadmin.setVgap(10);
 gridadmin.setPadding(new Insets(0,0,0,0));
 gridadmin.setLayoutX(275);
 gridadmin.setLayoutY(550);
 TheBr obj = new TheBr();
if(admin==1)
{  
 autoSlide.stop();   
 Button prevbtn =new Button("", new ImageView("/thebr/AdminControl/previous.png"));
 gridadmin.add(prevbtn,0,0);
    prevbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Amq8(primaryStage,marks);
    }
    });

 Button relbtn =new Button("", new ImageView("/thebr/AdminControl/reload.png"));
 gridadmin.add(relbtn,1,0);
    relbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Amq9(primaryStage,marks);
    }
    });
 
 Button nextbtn = new Button("", new ImageView("/thebr/AdminControl/next.png"));
 gridadmin.add(nextbtn,2,0);
     nextbtn.setOnAction(new EventHandler<ActionEvent>() {
     public void handle(ActionEvent ae){
     obj.Amq10(primaryStage,marks);
     }
     });
     
 Button levelbtn =new Button("", new ImageView("/thebr/AdminControl/level.png"));
 gridadmin.add(levelbtn,3,0);
    levelbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Page2(primaryStage,marks);
    }
    });
} 

    //Virtual Assistant
     MediaPlayer voice = new MediaPlayer(new Media(TheBr.class.getResource("virtualAssistant/Amq9.mp3").toString())); 
     voice.play();

   //Adding Score View
        Text scrLbl = new Text("Score: ");
        scrLbl.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        scrLbl.setFill( Color.web("BLACK", 0.50) );
        scrLbl.setX(5);
        scrLbl.setY(595);
        
        String myscore= Double.toString(mrk);
        Text scrView= new Text();
        scrView.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
        scrView.setFill( Color.web("WHITE", 0.50) );
        scrView.setText(myscore);
        scrView.setX(63);
        scrView.setY(595);

//Adding close button
Button btnclose = new Button("",new ImageView("/thebr/AdminControl/close.png"));
btnclose.setId("btnclose");
btnclose.setTranslateX(750);
btnclose.setTranslateY(550);
    btnclose.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
        TheBr obj = new TheBr();
        obj.MarksAdv(primaryStage,marks);
        voice.stop();
        autoSlide.stop();
    }
    });


primaryStage.getIcons().add(new Image("/thebr/TheBrainifyApp.jpg"));
root.getChildren().addAll(imgb1,linesW,linesO,linesR,box,cylinder,light,cp,cp2,queA9,cubeText,cynText,btnclose,scrLbl,scrView,gridadmin,gchoice); 
primaryStage.show();

}

//Advance Mode Q10
public void Amq10(Stage primaryStage, double marks)
{
Group root = new Group();
FlowPane rootNode= new FlowPane();
primaryStage.setTitle("The Brainify App- Advance Mode:");

Image imgb = new Image("/thebr/advback.jpg");
ImageView imgb1 = new ImageView(imgb);  
Scene scene = new Scene(root, 800, 600);
//primaryStage.setResizable(false);
primaryStage.setScene(scene);
scene.getStylesheets().add(TheBr.class.getResource("inter.css").toExternalForm());			


//Timer Line       
        Group linesW = new Group();
        for(int i=0;i<1;i++)
        {
        Line whiteLine = new Line(0, 0, 780, 0);
        whiteLine.setStroke(Color.web("#000000", 0.2));
        whiteLine.setStrokeWidth(40);
        whiteLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesW.getChildren().add(whiteLine);
        }
      
        Group linesO = new Group();
        for(int i=0;i<1;i++)
        {
        Line orangeLine = new Line(0, 0, 780, 0);
        orangeLine.setStroke(Color.web("#F54C0A", 0.4));
        orangeLine.setStrokeWidth(40);
        orangeLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesO.getChildren().add(orangeLine);
        }
            
        Group linesR = new Group();
        for(int i=0;i<1;i++)
        {
        Line redLine = new Line(0, 0, 780, 0);
        redLine.setStroke(Color.web("#FF0000", 0.5));
        redLine.setStrokeWidth(40);
        redLine.setStrokeLineCap(StrokeLineCap.SQUARE);
        linesR.getChildren().add(redLine);
        }
 
        
        Timeline timeline = new Timeline();
        for (Node whiteLine: linesW.getChildren()) 
        {
        timeline.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(whiteLine.translateXProperty(), -800),
        new KeyValue(whiteLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(18040), 
        new KeyValue(whiteLine.translateXProperty(), -320),
        new KeyValue(whiteLine.translateYProperty(), 0)
                ),
        new KeyFrame(new Duration(18041), 
        new KeyValue(whiteLine.translateXProperty(), -800),
        new KeyValue(whiteLine.translateYProperty(), 0)
                )
                );
        }
        timeline.play();

        Timeline timeline1 = new Timeline();
        for (Node orangeLine: linesO.getChildren())
        {
        timeline1.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(18040), 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),        
        new KeyFrame(new Duration(18040), 
        new KeyValue(orangeLine.translateXProperty(), -320),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ), 
        
        new KeyFrame(new Duration(25550), 
        new KeyValue(orangeLine.translateXProperty(), -120),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    ),
        new KeyFrame(new Duration(25551), 
        new KeyValue(orangeLine.translateXProperty(), -800),
        new KeyValue(orangeLine.translateYProperty(), 0)
                    )
                    );
        }
        timeline1.play();

        Timeline timeline2 = new Timeline();
        for (Node redLine: linesR.getChildren())
        {
        timeline2.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
        new KeyValue(redLine.translateXProperty(), -800),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),
        
        new KeyFrame(new Duration(25550),
        new KeyValue(redLine.translateXProperty(), -800),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),   
        new KeyFrame(new Duration(25550), 
        new KeyValue(redLine.translateXProperty(), -120),
        new KeyValue(redLine.translateYProperty(), 0)
                    ),       
 
        new KeyFrame(new Duration(30000),
        new KeyValue(redLine.translateXProperty(), 0),
        new KeyValue(redLine.translateYProperty(), 0)
                    )
                    );
        }
        timeline2.play();  
        
        //Timer Lines END
        GridPane gchoice=new GridPane();
        gchoice.setAlignment(Pos.CENTER);
        gchoice.setHgap(10);
        gchoice.setVgap(10);
        gchoice.setPadding(new Insets(150,25,25,200));
        
        
               //Timer start, will skip if no button pressed
            System.out.println("btn pressed before timeline = "+ btnPressed);
            Timeline autoSlide = new Timeline(new KeyFrame(
            Duration.millis(30000),
            ae-> 
            { 
                System.out.println("marks skipped Adv Mode = "+ marks);
                               
                            ImageView choiceW= new ImageView("/thebr/AdvMode/wrong.png");
                            gchoice.add(choiceW,5,3);
                            TheBr obj = new TheBr();
                            obj.Wrong(marks); 
                           try {       
                            PauseTransition autowrong=new PauseTransition(Duration.seconds(1));
                            autowrong.setOnFinished((a)->{  
                            obj.MarksAdv(primaryStage,marks);
				});
                            autowrong.play();
                            }
                           catch(Exception a){
                            System.out.println("Error....Something wrong!");
                            }                            
            }
            ));
            autoSlide.play();      
            //End of auto Timer
            
Text queA10=new Text("Q10.  Who is the composer of this song?\n\t(Drag correct one into the frame)"); 
queA10.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
queA10.setId("3D");
queA10.setFill( Color.web("BLACK", 0.50) );
queA10.setX(100);
queA10.setY(75);

MediaPlayer mplay = new MediaPlayer(new Media(TheBr.class.getResource("AdvMode/amq10.mp4").toExternalForm()));
MediaView mview = new MediaView(mplay);
mview.setFitWidth(300);
mview.setFitHeight(250);
mplay.play();

        Line border = new Line(400,300,400,550);
        border.setStroke(Color.web("#000000", 0.2));
        border.setStrokeWidth(10);
        border.setStrokeLineCap(StrokeLineCap.SQUARE);
        
        Line base = new Line(375,560,425,560);
        base.setStroke(Color.web("#000000", 0.2));
        base.setStrokeWidth(10);
        base.setStrokeLineCap(StrokeLineCap.SQUARE);
        


        Button pbtn= new Button("",mview);
        pbtn.setLayoutX(250);
        pbtn.setLayoutY(125);

              
//Adding image as options        
Button op1 = new Button("", new ImageView("/thebr/AdvMode/a1.png"));
op1.setId("drag");
op1.setLayoutX(25);
op1.setLayoutY(325);
op1.setOnMouseDragged(e -> {
op1.setLayoutX(e.getSceneX());
System.out.println("op1x "+e.getSceneX());
op1.setLayoutY(e.getSceneY());
System.out.println("op1y "+e.getSceneY());
//Right Logic
if(e.getSceneX()==546 && (e.getSceneY()==376))
                {
                ImageView choiceR= new ImageView("/thebr/AdvMode/correct.png");
                gchoice.add(choiceR,0,0);
                TheBr obj = new TheBr();
                obj.Right(marks);
                autoSlide.stop();
                mplay.stop();
                try {       
                PauseTransition wait=new PauseTransition(Duration.seconds(1));
                wait.setOnFinished((ew)->{  
                obj.MarksAdv(primaryStage,marks);
				});
                wait.play();
                }
                catch(Exception ec){
		System.out.println("Error....Something went wrong!!!!!!");
                }   
                }


});

Button op2 = new Button("", new ImageView("/thebr/AdvMode/a2.png"));
op2.setId("drag");
op2.setLayoutX(250);
op2.setLayoutY(325);
op2.setOnMouseDragged(e -> {
op2.setLayoutX(e.getSceneX());
//System.out.println("op2x "+e.getSceneX());
op2.setLayoutY(e.getSceneY());
//System.out.println("op2Y "+e.getSceneY());
                            //Wrong Logic
                	    if(e.getSceneX()==546 && e.getSceneY()==376)
                            {       
                            ImageView choiceW= new ImageView("/thebr/AdvMode/wrong.png");
                            gchoice.add(choiceW,5,3);
                            TheBr obj = new TheBr();
                            obj.Wrong(marks);
                            autoSlide.stop();
                            mplay.stop();
		            try {       
                            PauseTransition autowrong=new PauseTransition(Duration.seconds(1));
                            autowrong.setOnFinished((a)->{  
                            obj.MarksAdv(primaryStage,marks);
							});
                            autowrong.play();
                            }
                           catch(Exception a){
                            System.out.println("Error....Something wrong!");
                            }
							}
});

Button op3 = new Button("", new ImageView("/thebr/AdvMode/a3.png"));
op3.setId("drag");
op3.setLayoutX(65);
op3.setLayoutY(400);
op3.setOnMouseDragged(e -> {
op3.setLayoutX(e.getSceneX());
//System.out.println("op3x "+e.getSceneX());
op3.setLayoutY(e.getSceneY());
//System.out.println("op3y "+e.getSceneY());
                	//Wrong Logic
                	if(e.getSceneX()==546 && e.getSceneY()==376)
			{       
			ImageView choiceW= new ImageView("/thebr/AdvMode/wrong.png");
                            gchoice.add(choiceW,5,3);
                            TheBr obj = new TheBr();
                            obj.Wrong(marks);
                            autoSlide.stop();
                            mplay.stop();
							try {       
                            PauseTransition autowrong=new PauseTransition(Duration.seconds(1));
                            autowrong.setOnFinished((a)->{  
                            obj.MarksAdv(primaryStage,marks);
							});
                            autowrong.play();
                            }
                           catch(Exception a){
                            System.out.println("Error....Something wrong!");
                            }
							}
});

Button op4 = new Button("", new ImageView("/thebr/AdvMode/a4.png"));
op4.setId("drag");
op4.setLayoutX(215);
op4.setLayoutY(400);
op4.setOnMouseDragged(e -> {
op4.setLayoutX(e.getSceneX());
//System.out.println("op4x "+e.getSceneX());
op4.setLayoutY(e.getSceneY());
//System.out.println("op4y "+e.getSceneY());
			//Wrong Logic
			if(e.getSceneX()==546 && e.getSceneY()==376)
                		{       
                            ImageView choiceW= new ImageView("/thebr/AdvMode/wrong.png");
                            gchoice.add(choiceW,5,3);
                            TheBr obj = new TheBr();
                            obj.Wrong(marks);
                            autoSlide.stop();
                            mplay.stop();
							try {       
                            PauseTransition autowrong=new PauseTransition(Duration.seconds(1));
                            autowrong.setOnFinished((a)->{  
                            obj.MarksAdv(primaryStage,marks);
							});
                            autowrong.play();
                            }
                           catch(Exception a){
                            System.out.println("Error....Something wrong!");
                            }
							}
});

Button op5 = new Button("", new ImageView("/thebr/AdvMode/a5.png"));
op5.setId("drag");
op5.setLayoutX(135);
op5.setLayoutY(450);
op5.setOnMouseDragged(e -> {
op5.setLayoutX(e.getSceneX());
//System.out.println("op5x "+e.getSceneX());
op5.setLayoutY(e.getSceneY());
//System.out.println("op5y "+e.getSceneY());
			//Wrong Logic
			if(e.getSceneX()==546 && e.getSceneY()==376)
			{       
                            ImageView choiceW= new ImageView("/thebr/AdvMode/wrong.png");
                            gchoice.add(choiceW,5,3);
                            TheBr obj = new TheBr();
                            obj.Wrong(marks); 
                            autoSlide.stop();
                            mplay.stop();
							try {       
                            PauseTransition autowrong=new PauseTransition(Duration.seconds(1));
                            autowrong.setOnFinished((a)->{  
                            obj.MarksAdv(primaryStage,marks);
							});
                            autowrong.play();
                            }
                           catch(Exception a){
                            System.out.println("Error....Something wrong!");
                            }
							}
});


Rectangle r1 = new Rectangle(120,120);
r1.setX(540);
r1.setY(370);
r1.setId("rect");
r1.setFill(Color.web("BLACK", 0.2));
r1.setStrokeWidth(10);
r1.setStroke(Color.BLACK);

      //Admin control
 GridPane gridadmin = new GridPane();
 gridadmin.setAlignment(Pos.CENTER);
 gridadmin.setHgap(10);
 gridadmin.setVgap(10);
 gridadmin.setPadding(new Insets(0,0,0,0));
 gridadmin.setLayoutX(275);
 gridadmin.setLayoutY(550);
 TheBr obj = new TheBr();
if(admin==1)
{  
 autoSlide.stop();   
 Button prevbtn =new Button("", new ImageView("/thebr/AdminControl/previous.png"));
 gridadmin.add(prevbtn,0,0);
    prevbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Amq9(primaryStage,marks);
    }
    });

 Button relbtn =new Button("", new ImageView("/thebr/AdminControl/reload.png"));
 gridadmin.add(relbtn,1,0);
    relbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Amq10(primaryStage,marks);
    }
    });
 
 Button nextbtn = new Button("", new ImageView("/thebr/AdminControl/next.png"));
 gridadmin.add(nextbtn,2,0);
     nextbtn.setOnAction(new EventHandler<ActionEvent>() {
     public void handle(ActionEvent ae){
     obj.Amq10(primaryStage,marks);
     }
     });
     
 Button levelbtn =new Button("", new ImageView("/thebr/AdminControl/level.png"));
 gridadmin.add(levelbtn,3,0);
    levelbtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
    obj.Page2(primaryStage,marks);
    }
    });
} 

   //Adding Score View
        Text scrLbl = new Text("Score: ");
        scrLbl.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        scrLbl.setFill( Color.web("BLACK", 0.50) );
        scrLbl.setX(5);
        scrLbl.setY(595);
        
        String myscore= Double.toString(mrk);
        Text scrView= new Text();
        scrView.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
        scrView.setFill( Color.web("WHITE", 0.50) );
        scrView.setText(myscore);
        scrView.setX(63);
        scrView.setY(595);

//Adding close button
Button btnclose = new Button("",new ImageView("/thebr/AdminControl/close.png"));
btnclose.setId("btnclose");
btnclose.setTranslateX(750);
btnclose.setTranslateY(550);
    btnclose.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
        TheBr obj = new TheBr();
        obj.MarksAdv(primaryStage,marks);
        //voice.stop();
        autoSlide.stop();
    }
    });

root.getChildren().addAll(imgb1,linesW,linesO,linesR,queA10,border,base,pbtn,r1,op1,op2,op3,op4,op5,gridadmin,btnclose,scrLbl,scrView,gchoice); 
primaryStage.show();
}

//Show Marks

public void ShowMarks(Stage primaryStage, double marks)
{
Group root = new Group();
FlowPane rootNode= new FlowPane();
primaryStage.setTitle("The Brainify App- Result:"); 

        GridPane grid0=new GridPane();
        grid0.setAlignment(Pos.CENTER);
        grid0.setHgap(10);
        grid0.setVgap(10);
        grid0.setPadding(new Insets(25,25,25,25));
        grid0.setId("gridm");
    
        GridPane grid1=new GridPane();
        grid1.setAlignment(Pos.CENTER);
        grid1.setHgap(5);
        grid1.setVgap(5);
        grid1.setPadding(new Insets(25,25,25,25));
        grid1.setLayoutX(125);
        grid1.setLayoutY(125);
        grid1.setId("gridm");
        grid0.add(grid1,0,0);
        
        
        GridPane gridmm=new GridPane();
        gridmm.setAlignment(Pos.CENTER);
        gridmm.setHgap(10);
        gridmm.setVgap(10);
        gridmm.setPadding(new Insets(25,25,25,25));
        gridmm.setTranslateX(175);
        gridmm.setTranslateY(0);
        gridmm.setId("gridlevel");
        
        Text top = new Text("High Score: ");
        top.setFont(Font.font("Tahoma", FontWeight.NORMAL, 50));
        top.setId("3D");
        top.setFill( Color.web("BLACK", 0.50) );
        gridmm.add(top,0,0);
        
   /*     Text yscore= new Text("Your Score");
        yscore.setId("yrscr");
        grid1.add(yscore,0,1,2,1); */
        
        Text serialH= new Text();
        serialH.setId("head");
        serialH.setText("Rank:\t");
        grid1.add(serialH,0,3);
               
        Text nameH= new Text();
        nameH.setId("head");
        nameH.setText("Name:\t");
        grid1.add(nameH,1,3);
        
        Text timeH= new Text();
        timeH.setId("head");
        timeH.setText("Time:\t");
        grid1.add(timeH,2,3);
        
        Text mrkH= new Text();
        mrkH.setText("Score:\t");
        mrkH.setId("head");
        grid1.add(mrkH,4,3);
               
    //Stroring score data
    try(DataOutputStream dout = new DataOutputStream(new FileOutputStream("details.txt",true)))
    {
       
        dout.writeDouble(mrk);
        dout.close();
    }
    catch(IOException e)
    {
        System.out.println("I/O Error Occured");
    }

        
        int len=0;
        try(DataInputStream din = new DataInputStream(new FileInputStream("details.txt")))
        {    
        for(int i=3;;i++)
        {
        String name= din.readLine();
        String mob= din.readLine();
        String email= din.readLine();
        String logdate= din.readLine();
        double score= din.readDouble();
       
        if(len<i)
        {
        len=i-2;
        }
        }
        }
        catch(IOException e)
        {
        System.out.println("I/O Error Occured");
        }
             
        
        //Reading player details from file:-
        String[] lname=new String[len];
        String[] lmob= new String[len];
        String[] lemail= new String[len];
        String[] ldate= new String[len];
        double[] lmrk = new double[len];
        double []stlmrk= new double[len];
        
        try(DataInputStream din = new DataInputStream(new FileInputStream("details.txt")))
        {
        for(int i=0;i<len;i++)
            
        {
        String name1= din.readLine();
        String mob1= din.readLine();
        String email1= din.readLine();
        String logdate1= din.readLine();
        double score1= din.readDouble();
        
        lname[i]=name1;
        lmob[i]=mob1;
        lemail[i]=email1;
        ldate[i]=logdate1;
        lmrk[i]=score1;
        stlmrk[i]=lmrk[i];
        }
        }
        catch(IOException e)
        {
        System.out.println("I/O Error Occured");
        }  
       
    /*    //Present player details
        System.out.println(" "+lname[len-1]);
        System.out.println(" "+lmob[len-1]); 
        System.out.println(" "+lemail[len-1]); 
        System.out.println(" "+ldate[len-1]); 
        System.out.println(" "+lmrk[len-1]); 
        
        Text myname= new Text();
        myname.setId("pplayer");
        myname.setText(lname[len-1]);
        grid1.add(myname,1,2);
        
        Text mytime= new Text();
        mytime.setId("pplayer");
        mytime.setText(ldate[len-1]);
        grid1.add(mytime,2,2);
                
        String mmyscore= Double.toString(lmrk[len-1]);
        Text myscore= new Text();
        myscore.setId("pplayer");
        myscore.setText(mmyscore);
        grid1.add(myscore,3,2);
       */  
        
 
        //Sorted player by score
        double temp;
        String tempname;
        String tempmob;
        String tempemail;
        String tempdate;
           
        for(int i=0;i<len-1;i++)
        {
        for(int j=0;j<len-i-1;j++)
        {            
            if(lmrk[j]>lmrk[j+1])
            {
             temp=lmrk[j];
             lmrk[j]=lmrk[j+1];
             lmrk[j+1]=temp;
             
             tempname=lname[j];
             lname[j]=lname[j+1];
             lname[j+1]=tempname;
             
             tempmob=lmob[j];
             lmob[j]=lmob[j+1];
             lmob[j+1]=tempmob;
             
             tempemail=lemail[j];
             lemail[j]=lemail[j+1];
             lemail[j+1]=tempemail;
             
             tempdate= ldate[j];
             ldate[j]=ldate[j+1];
             ldate[j+1]=tempdate;
             } 
          }
        }
         System.out.println("\n\n");
         for(int z=len-1; z>=0;z--)
        {
        System.out.print(" "+lname[z]);
        System.out.print(" "+lmob[z]); 
        System.out.print(" "+lemail[z]); 
        System.out.print(" "+ldate[z]); 
        System.out.print(" \n"+lmrk[z]); 
        }
         
        String highScore = Double.toString(lmrk[len-1]);
        Text scoreH = new Text();
        scoreH.setFont(Font.font("Tahoma", FontWeight.NORMAL, 50));
        scoreH.setId("3D");
        scoreH.setFill( Color.web("WHITE", 0.50) );
        scoreH.setText(highScore);
        gridmm.add(scoreH,1,0); 
        
        System.out.println("Length is = "+len);
        int align=4;
        int notmorethan10=1;
        for(int n=len-1;n>=0;n--)
        {
        align++;
        
        Text pname= new Text();
        pname.setId("plylist");
        pname.setText(lname[n]);
        grid1.add(pname,1,align);
                
        Text plogtime= new Text();
        plogtime.setId("plylist");
        plogtime.setText(ldate[n]);
        grid1.add(plogtime,2,align);
        
        String scoreV= Double.toString(lmrk[n]);
        Text pscore= new Text();
        pscore.setId("plylist");
        pscore.setText(scoreV);
        grid1.add(pscore,4,align);
        
        notmorethan10++;
        if(notmorethan10>10)
        break;
        }
        
        //Applying Serial No:
        String serialValue[]=new String [10];
        for(int j=0;j<10;j++)
        {
        serialValue[j]=Integer.toString(j+1);  
        }
        for(int serial=0; serial<10;serial++)
        {
            Text serialText=new Text();
            serialText.setId("head");
            serialText.setText(serialValue[serial]);
            grid1.add(serialText,0,serial+5);
        }
        
      //  grid1.setGridLinesVisible(true);
        
        //Fitting Button
        GridPane gridx=new GridPane();
        gridx.setAlignment(Pos.CENTER);
        gridx.setHgap(5);
        gridx.setVgap(5);
        gridx.setPadding(new Insets(0,0,0,0));
        
       Button lvl = new Button("LEVEL!");
        lvl.setId("btnscore");
        Button home= new Button("HOME");
        home.setId("btnscore");
        home.setTranslateX(350);
        home.setTranslateY(525);
        
   /*     lvl.setOnAction(new EventHandler<ActionEvent>() {
             public void handle(ActionEvent ae){  
             TheBr obj= new TheBr();
             obj.LevelSelect(primaryStage, marks);
             }
             });*/
        
         home.setOnAction(new EventHandler<ActionEvent>() {
             public void handle(ActionEvent ae){  
             TheBr obj= new TheBr();
             obj.Info(primaryStage,marks);
             }
             });
         //home.setLayoutX(100);
        // home.setLayoutY(100);

        
        // gridx.add(lvl,1,0);
         grid1.add(gridx,0,15,4,1);
      
Image imgb = new Image("/thebr/interback.jpg");
ImageView imgb1 = new ImageView(imgb);    
root.getChildren().addAll(imgb1,home,gridmm,grid1);       
Scene scene = new Scene(root, 800, 600, Color.GRAY);
primaryStage.setScene(scene);
primaryStage.setResizable(false);
scene.getStylesheets().add(TheBr.class.getResource("imgb.css").toExternalForm());			
primaryStage.getIcons().add(new Image("/thebr/TheBrainifyApp.jpg"));
primaryStage.show();
}

public void Marks(Stage primaryStage, double marks)
{
Group root = new Group();
FlowPane rootNode= new FlowPane();
primaryStage.setTitle("The Brainify App- Result:"); 

        GridPane grid0=new GridPane();
        grid0.setAlignment(Pos.CENTER);
        grid0.setHgap(10);
        grid0.setVgap(10);
        grid0.setPadding(new Insets(25,25,25,25));
        grid0.setTranslateX(125);
        grid0.setTranslateY(175);
        grid0.setId("gridlevel");

        Text top = new Text("Your Score: ");
        top.setFont(Font.font("Tahoma", FontWeight.NORMAL, 70));
        top.setId("3D");
        top.setFill( Color.web("BLACK", 0.50) );
        //top.setId("Hscore");
        
        String mmyscore= Double.toString(mrk);
        Text myscore= new Text();
        myscore.setFont(Font.font("Tahoma", FontWeight.NORMAL, 70));
        myscore.setId("3D");
        myscore.setFill( Color.web("WHITE", 0.50) );
        //myscore.setId("pplayer");
        myscore.setText(mmyscore);
        
        grid0.add(top,0,0);
        grid0.add(myscore,1,0);
        
        Button lbtn = new Button("Go");
        lbtn.setTranslateX(350);
        lbtn.setTranslateY(375);
        lbtn.setId("Iq3btn");
             lbtn.setOnAction(new EventHandler<ActionEvent>() {
             public void handle(ActionEvent ae){  
             TheBr obj= new TheBr();
             obj.LevelSelect(primaryStage,marks);
             }
             });
        

Image imgb = new Image("/thebr/interback.jpg");
ImageView imgb1 = new ImageView(imgb);    
root.getChildren().addAll(imgb1,grid0,lbtn);       
Scene scene = new Scene(root, 800, 600, Color.GRAY);
primaryStage.setScene(scene);
primaryStage.setResizable(false);
scene.getStylesheets().add(TheBr.class.getResource("inter.css").toExternalForm());			
primaryStage.getIcons().add(new Image("/thebr/TheBrainifyApp.jpg"));
primaryStage.show();
}        

public void MarksAdv(Stage primaryStage, double marks)
{
Group root = new Group();
FlowPane rootNode= new FlowPane();
primaryStage.setTitle("The Brainify App- Result:"); 

        GridPane grid0=new GridPane();
        grid0.setAlignment(Pos.CENTER);
        grid0.setHgap(10);
        grid0.setVgap(10);
        grid0.setPadding(new Insets(25,25,25,25));
        grid0.setTranslateX(125);
        grid0.setTranslateY(175);
        grid0.setId("gridlevel");

        Text top = new Text("Your Score: ");
        top.setFont(Font.font("Tahoma", FontWeight.NORMAL, 70));
        top.setId("3D");
        top.setFill( Color.web("BLACK", 0.50) );
        //top.setId("Hscore");
        
        String mmyscore= Double.toString(mrk);
        Text myscore= new Text();
        myscore.setFont(Font.font("Tahoma", FontWeight.NORMAL, 70));
        myscore.setId("3D");
        myscore.setFill( Color.web("WHITE", 0.50) );
        //myscore.setId("pplayer");
        myscore.setText(mmyscore);
        
        grid0.add(top,0,0);
        grid0.add(myscore,1,0);
        
        Button lbtn = new Button("Go");
        lbtn.setTranslateX(350);
        lbtn.setTranslateY(375);
        lbtn.setId("Iq3btn");
             lbtn.setOnAction(new EventHandler<ActionEvent>() {
             public void handle(ActionEvent ae){  
             TheBr obj= new TheBr();
             obj.ShowMarks(primaryStage,marks);
             }
             });
        
mrk = 0.0;

Image imgb = new Image("/thebr/interback.jpg");
ImageView imgb1 = new ImageView(imgb);    
root.getChildren().addAll(imgb1,grid0,lbtn);       
Scene scene = new Scene(root, 800, 600, Color.GRAY);
primaryStage.setScene(scene);
primaryStage.setResizable(false);
scene.getStylesheets().add(TheBr.class.getResource("inter.css").toExternalForm());			
primaryStage.getIcons().add(new Image("/thebr/TheBrainifyApp.jpg"));
primaryStage.show();
}        

        
//Chose option Right
public void Right(double marks)
{
   // double mrk = marks;
   marks=marks+1;
   rightPlayer.play();
   
    mrk  = mrk+1;
   System.out.println("Marks in right method: "+mrk); 
  // int nright=0;
   System.out.println("Entered in right == "+ ++nright);
  
}

//Chose option Wrong
public void Wrong(double marks)
{
    wrongPlayer.play();
    marks -= 0.5;
    mrk = mrk-0.5;
    System.out.println("Marks in wrong method: "+ mrk);
    System.out.println("Entered in wrong == "+ ++nwrong);
  
}

}