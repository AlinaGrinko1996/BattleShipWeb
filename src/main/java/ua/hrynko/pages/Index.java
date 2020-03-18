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
import ua.hrynko.services.pages.GameService;

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

    @Inject
    private GameService gameService;

    /**
     * Handler of successful (after validation) request from login form
     * @return page to move on
     */
    Object onSuccessFromLogin() {
        Game game = gameService.initializeGameWithPlayers(name1, name2);
        gamePage.setGame(game);
        return gamePage;
    }

    /**
     * In case if login form validation failed
     */
    void onFailureFromLogin() {
        logger.warn("Login error!");
        alertManager.error("Try again)");
    }
}
