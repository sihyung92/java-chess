package chess.controller;

public class ControllerFactory {
    private static final ControllerFactory CONTROLLER_FACTORY = new ControllerFactory();
    public static final int WEB = 0;
    public static final int CONSOLE = 1;

    private ControllerFactory(){}

    public static ControllerFactory getInstance() {
        return CONTROLLER_FACTORY;
    }

    public Controller createController(int kindOfController){
        switch (kindOfController){
            case WEB :
                return CreateWebController();
            case CONSOLE :
                return CreateConsoleController();
        }
        throw new IllegalArgumentException("존재하지 않는 컨트롤러입니다.");
    }

    private ConsoleController CreateConsoleController() {
        return new ConsoleController();
    }

    private WebController CreateWebController() {
        return new WebController();
    }
}
