package ua.hrynko.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tapestry5.Block;
import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.Request;
import org.apache.tapestry5.services.ajax.AjaxResponseRenderer;
import org.apache.tapestry5.services.ajax.JavaScriptCallback;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;
import ua.hrynko.BL.*;
import ua.hrynko.services.pages.GameService;

import java.util.List;

/**
 * Start page of application BattleShip.
 */
@Import(module = {"app/game-page"})
public class GamePage {
    private static final Logger logger = LogManager.getLogger(GamePage.class);
    @Persist
    private Game game;

    @Persist
    private List<Cell> selected;

    @Property
    Cell[] cellSet;

    @Property
    Cell cell;

    @Inject
    private AjaxResponseRenderer ajaxResponseRenderer;

    @Inject
    private Request request;

    @Inject
    private Block blockA;

    @Inject
    private Block blockB;

    @Inject
    private GameService gameService;

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    /**
     * Needs to have public access for binding
     * @param cell
     * @param isMyBoard
     * @return
     */
    public String getVisualClass(Cell cell, boolean isMyBoard) {
        return gameService.getClassForCell(cell, isMyBoard);
    }


    @OnEvent("toggleChosen")
    public void toggleChosen(int cellId) {
        gameService.chooseCellOnMainBoard(cellId, game);
        if (request.isXHR()) {
            ajaxResponseRenderer.addCallback(new JavaScriptCallback() {
                @Override
                public void run(JavaScriptSupport javascriptSupport) {
                    javascriptSupport
                            .require("app/game-page")
                            .invoke("toggleClass")
                            .with(cellId);
                }
            });
        }
    }

    @OnEvent("fire")
    public void fire(int cellId) {
        String cellClass = gameService.shootAtOpponent(cellId, game);
        if (request.isXHR()) {
            ajaxResponseRenderer.addCallback(new JavaScriptCallback() {
                @Override
                public void run(JavaScriptSupport javascriptSupport) {
                    javascriptSupport
                            .require("app/game-page")
                            .invoke("hit")
                            .with(cellClass, cellId);
                }
            });
        }
    }

    @Log
    void onAjaxA() {
        game.setPlayerACurrent(true);
        ajaxResponseRenderer.addRender("middlezone", blockA)
                .addCallback(new JavaScriptCallback() {
                    @Override
                    public void run(JavaScriptSupport javascriptSupport) {
                        javascriptSupport.require("app/game-page").invoke("init");
                    }
                });
    }

    void onAjaxB() {
        game.setPlayerACurrent(false);
        ajaxResponseRenderer.addRender("middlezone", blockB)
                .addCallback(new JavaScriptCallback() {
                    @Override
                    public void run(JavaScriptSupport javascriptSupport) {
                        javascriptSupport.require("app/game-page").invoke("init");
                    }
                });
    }
}
