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
import ua.hrynko.exceptions.WrongCoordinateException;
import ua.hrynko.wrappers.CellRow;

import java.time.ZonedDateTime;
import java.util.ArrayList;
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

    public Game getGame() {
        return game;
    }

    public String getVisualClass(Cell cell, boolean isMyBoard) {
        if (cell.isHit()) {
            if (cell.isBusy()) {
                return "ship-broken";
            } else {
                return "hit";
            }
        } else {
            if (cell.isBusy()) {
                return  isMyBoard ? "selected" : "none";
            }
        }
        return "none";
    }


//    public void addSelected(Cell cell) {
//        selected.add(cell);
//        cell.setBusy(true);
//    }

    @OnEvent("toggleChosen")
    public void toggleChosen (int cellId) {
        Cell cellActive = game.getCurrentPlayer().getBoard().getCellById(cellId);
        cellActive.toggleBusy();
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

    @OnEvent("hit")
    public void hit (int cellId) {
        Player targetPlayer = game.isPlayerACurrent() ? game.getPlayerB() : game.getPlayerA();
        Cell cellActive = targetPlayer.getBoard().getCellById(cellId);
        cellActive.setHit(true);
        String cellClass = getVisualClass(cellActive, false);
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
        ajaxResponseRenderer.addRender("middlezone", blockB) .addCallback(new JavaScriptCallback() {
            @Override
            public void run(JavaScriptSupport javascriptSupport) {
                javascriptSupport.require("app/game-page").invoke("init");
            }
        });
    }

    public ZonedDateTime getCurrentTime() {
        return ZonedDateTime.now();
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
