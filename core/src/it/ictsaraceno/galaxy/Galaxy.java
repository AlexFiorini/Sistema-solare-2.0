package it.ictsaraceno.galaxy;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import it.ictsaraceno.galaxy.movement.BouncingRectangle;

public class Galaxy extends ApplicationAdapter {

    private Texture planetImage;
    private BouncingRectangle planet;

    private static final int PLANET_WIDTH = 64;
    private static final int PLANET_HEIGHT = 64;
    private static final int SCREEN_WIDTH = 800;
    private static final int SCREEN_HEIGHT = 480;
    private OrthographicCamera camera;
    private SpriteBatch batch;

    @Override
    public void create() {
        // init planet and center it
        planetImage = new Texture("planet-64.png");

        planet = new BouncingRectangle(SCREEN_WIDTH, SCREEN_HEIGHT);
        planet.width = PLANET_WIDTH;
        planet.height = PLANET_HEIGHT;
        planet.x = SCREEN_WIDTH / 2 - PLANET_WIDTH / 2;
        planet.y = SCREEN_HEIGHT / 2 - PLANET_HEIGHT / 2;

        // camera
        camera = new OrthographicCamera();
        camera.setToOrtho(false, SCREEN_WIDTH, SCREEN_HEIGHT);

        batch = new SpriteBatch();
    }

    @Override
    public void render() {
        ScreenUtils.clear(0, 0, 0, 1);

        // tell the camera to update its matrices.
        camera.update();

        // tell the SpriteBatch to render in the
        // coordinate system specified by the camera.
        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        batch.draw(planetImage, planet.x, planet.y);
        batch.end();

        updatePlanetCoordinates();

    }

    private void updatePlanetCoordinates() {
        planet.update(Gdx.graphics.getDeltaTime());
    }

    @Override
    public void dispose() {
        planetImage.dispose();
    }

}
