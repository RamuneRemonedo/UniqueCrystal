package tokyo.ramune.unique_crystal;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class UniqueCrystalApp extends GameApplication {

    private Entity player;

    @Override
    protected void initSettings(GameSettings settings) {
        settings.setFullScreenAllowed(true);
        settings.setFullScreenFromStart(true);
        settings.setTitle("Unique Crystal");
        settings.setVersion("1.0-Dev");
    }

    @Override
    protected void initGame() {
        player = FXGL.entityBuilder()
                .at(FXGL.getAppCenter().getX(), FXGL.getAppCenter().getY())
                .view(new Rectangle(25, 25, Color.BLUE))
                .buildAndAttach();
    }

    @Override
    protected void initInput() {
        FXGL.onKey(KeyCode.D, () -> {
            player.translateX(5); // move right 5 pixels
        });

        FXGL.onKey(KeyCode.A, () -> {
            player.translateX(-5); // move left 5 pixels
        });

        FXGL.onKey(KeyCode.W, () -> {
            player.translateY(-5); // move up 5 pixels
        });

        FXGL.onKey(KeyCode.S, () -> {
            player.translateY(5); // move down 5 pixels
        });
    }

    @Override
    protected void initUI() {
        Text textPixels = new Text("Hello World!");
        textPixels.setTranslateX(FXGL.getAppCenter().getX()); // x = 50
        textPixels.setTranslateY(FXGL.getAppCenter().getY()); // y = 100

        FXGL.getGameScene().addUINode(textPixels); // add to the scene graph
    }

    public static void main(String[] args) {
        launch(args);
    }
}
