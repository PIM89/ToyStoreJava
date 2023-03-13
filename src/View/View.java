package View;

import Model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
    Scanner scanner = new Scanner(System.in);
    public void showMenu() {
        System.out.println("Для добавления новой игрушки выберите -> 1");
        System.out.println("Для просмотра списка игрушек выберите -> 2");
        System.out.println("Для участия в розыгрыше игрушек выберите -> 3");
        System.out.println("Для того, чтобы забрать игрушку выберите -> 4");
        System.out.println("Для окончания работы программы выберите -> 5");
    }
    public int setChoose() {
        System.out.println("Выбор операции: ");
        return scanner.nextInt();
    }
    public int setIntQuantity() {
        System.out.println("Введите количество игрушек: ");
        return scanner.nextInt();
    }
    public int setIntWeight() {
        System.out.println("Введите вероятность выпадания игрушки (целое число от 0 до 100): ");
        return scanner.nextInt();
    }
    public String setName() {
        System.out.println("Введите название игрушки: ");
        return scanner.next();
    }
    public void getToys(ArrayList<ModelToy> arrayList) {
        for (ModelToy toy : arrayList) {
            System.out.println(toy);
        }
    }
}
