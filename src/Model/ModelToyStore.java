package Model;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class ModelToyStore {
    static ArrayList<ModelToy> toyArrayList = new ArrayList<>();
    static LinkedList<ModelToy> winningLinkedList = new LinkedList<>();

    public void setToyArrayList(ModelToy modelToy) {
        toyArrayList.add(modelToy);
    }

    public static ArrayList<ModelToy> getToyArrayList() {
        if (toyArrayList.isEmpty()) {
            System.out.println("Я не дед Мороз! Игрушек нет!\n");
        }
        return toyArrayList;
    }

    public static LinkedList<ModelToy> getWinningLinkedList() {
        return winningLinkedList;
    }

    public static void addWinningLinkedList(ModelToy modelToy) {
        winningLinkedList.add(modelToy);
    }

    public LinkedList<ModelToy> getLottery() {
        Random random = new Random();
        /*Рандомно выбирается тип (название) разыгрываемой игрушки*/
        int randomTypeToy = random.nextInt(toyArrayList.size());

        /*Если количество игрушек этого типа не равно нулю, то разыгрываем лотерею*/
        if (toyArrayList.get(randomTypeToy).getQuantity() != 0) {
            System.out.println("Разыгрывается игрушка: " + toyArrayList.get(randomTypeToy).getName() +
                    ". Вероятность выйгрыша составляет: " + toyArrayList.get(randomTypeToy).getWeight() + " %.");
            int randomNum = (int) Math.floor(Math.random() * 100) + 1;
            int[] list = new int[100];
            int countWeight = toyArrayList.get(randomTypeToy).getWeight();


            for (int i = 0; i < list.length; i++) {
                for (int j = 0; j < countWeight; j++) {
                    list[j] = 777;
                }
                list[i] = i;
            }

            if (list[randomNum] == 777) {
                System.out.println("Вы выйграли! Можете забрать игрушку!\n");
                addWinningLinkedList(toyArrayList.get(randomTypeToy));
                /*Уменьшение количества игрушек*/
                toyArrayList.get(randomTypeToy).setQuantity(toyArrayList.get(randomTypeToy).getQuantity() - 1);
            } else {
                System.out.println("Очень жаль, но фортуна оказалась не на вашей стороне!\n" +
                        "Попробуйте еще раз!\n");
            }
        } else {
            System.out.println("Игрушки закончились!\n");
        }
        return getWinningLinkedList();
    }

    public void givingToy(LinkedList<ModelToy> modelToys) {
        String text = String.valueOf(getWinningLinkedList().pop());
        System.out.println(text + "\nИгрушка выдана\n");
        try (FileWriter writer = new FileWriter("Toys.txt", true)) {
            writer.write(text);
            writer.append('\n');
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}