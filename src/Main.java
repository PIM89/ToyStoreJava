import Presenter.Presenter;
import View.View;
import Model.*;
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Presenter presenter = new Presenter(new View(), new ModelToy(), new ModelToyStore());
        presenter.buttonClick();
    }
}
