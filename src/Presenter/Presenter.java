package Presenter;

import View.*;
import Model.*;

public class Presenter {
    View view;
    ModelToy modelToy;
    ModelToyStore modelToyStore;

    public Presenter(View view, ModelToy modelToy, ModelToyStore modelToyStore) {
        this.view = view;
        this.modelToy = modelToy;
        this.modelToyStore = modelToyStore;
    }

    public void buttonClick() throws ClassNotFoundException {
        view.showMenu();
        int choose = view.setChoose();
        if (choose == 5) {
            System.exit(0);
        }
        switch (choose) {
            case 1: {
                modelToyStore.setToyArrayList(new ModelToy(view.setName(), view.setIntQuantity(), view.setIntWeight()));

                buttonClick();
            }
            case 2: {
                view.getToys(modelToyStore.getToyArrayList());
                buttonClick();
            }
            case 3: {
                modelToyStore.getLottery();
                buttonClick();
            }
            case 4: {
                modelToyStore.givingToy(modelToyStore.getWinningLinkedList());
                buttonClick();
            }
        }
    }
}
