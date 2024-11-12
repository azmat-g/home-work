import java.util.ArrayList;

public class Cycles {
    public static void main(String[] args) {

        int[] intArray = {1, 2, 3, 4, 5, 6, 7};

        for(int i = 0; i < intArray.length; i++){
            if(intArray[i] != 5){
                System.out.println(intArray[i]);
            }
            else {
                break;
            }
        }

        int xyzPop = 10_000_000;

        for(int year = 1; year <= 10; year++){
            int born = xyzPop / 1000 * (14 - 8);
            xyzPop = xyzPop + born;
        }

        System.out.println(xyzPop);

        ArrayList<String> strArray = new ArrayList<>();

        String[] phrase = {"Съешь", "ещё", "этих", "мягких", "французских", "булок,", "да", "выпей", "чаю", "!"};

        for(int i = 0; i <= 9; i++){
            strArray.add(phrase[i]);
        }

        for(String word : strArray){
            System.out.println(word);
        }
    }
}