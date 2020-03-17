package ua.hrynko.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.ioc.annotations.Inject;
import ua.hrynko.BL.Game;
import ua.hrynko.exceptions.WrongCoordinateException;

public class Index {
    private static final Logger logger = LogManager.getLogger(Index.class);

    @Inject
    private AlertManager alertManager;

    @InjectComponent
    private Form login;

    @Property
    private String name1;

    @Property
    private String name2;

    @InjectPage
    private GamePage gamePage;

    Object onSuccessFromLogin() throws WrongCoordinateException {
        Game game = new Game();
        game.initialize(name1, name2);
        gamePage.setGame(game);
        return  gamePage;
    }

    void onFailureFromLogin() {
        logger.warn("Login error!");
        alertManager.error("I'm sorry but I can't log you in!");
    }
}
