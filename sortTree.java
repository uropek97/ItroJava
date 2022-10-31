import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class sortTree {

    private Map<Integer, ArrayList<String>> treeMap = new TreeMap<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer key1, Integer key2) {
            return Integer.compare(key2, key1);
        }
    });

    public void sort(Map<String, ArrayList<String>> map){
        for(var item : map.entrySet()){
            Integer frequency = item.getValue().size(); //берём длину AL и смотрим есть ли такая длина уже в нашем дереве
            if(treeMap.containsKey(frequency)){
                String str = getNames(item.getValue());
                ArrayList<String> list = treeMap.get(frequency);
                list.add(str);
            }
            else {
                String str = getNames(item.getValue());
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                treeMap.put(frequency, list);
            }
        }
    }

    private String getNames(ArrayList<String> names){
        StringBuilder SB = new StringBuilder();
        for(String name : names)
            SB.append(name).append(" ");
        return SB.toString();
    }

    @Override
    public String toString(){
        return treeMap.toString();
    }
}
