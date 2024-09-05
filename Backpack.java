/**
 * Backpack
 * @author Anderson R. P. Sprenger
 * @author Vinicius P. Dias
 */

import java.util.LinkedList;
import java.util.List;

public class Backpack {
    class Element {
        int value;
        int weight;

        public int getValue() {
            return value;
        }

        public int getWeight() {
            return weight;
        }
    }

    List<Element> best = new LinkedList<Element>();

    public List<Element> backpackRec(List<Element> list, int weight) {
        if (weight == 0) {
            return new LinkedList<Element>();
        }

        for (Element e : list) {
            List<Element> remainingList = new LinkedList<Element>(list);
            remainingList.remove(e);
            int remainingWeight = weight - e.weight;

            List<Element> search = backpackRec(remainingList, remainingWeight);

            if (search.stream().mapToInt(Element::getValue).sum() > best.stream().mapToInt(Element::getValue).sum()) {
                best = search;
            }
        }

        return best;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}