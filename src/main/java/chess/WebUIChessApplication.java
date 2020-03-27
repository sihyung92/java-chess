package chess;

import chess.controller.Controller;
import chess.controller.ControllerFactory;

public class WebUIChessApplication {
    public static void main(String[] args) {
        ControllerFactory controllerFactory = ControllerFactory.getInstance();
        Controller controller = controllerFactory.createController(ControllerFactory.CONSOLE);
        controller.run();
    }

}
