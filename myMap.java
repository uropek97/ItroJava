import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class myMap {

    //Чтобы всё не переписывать сделал map публичным
    public Map<String, ArrayList<String>> map = new HashMap<>();

    public void add(String fullName){
        var a = fullName.split(" ");
        var name = a[0];
        if(map.containsKey(name)){
            ArrayList<String> list = map.get(name);
            list.add(fullName);
        }
        else {
            ArrayList<String> list = new ArrayList<>();
            list.add(fullName);
            map.put(name, list);
        }
    }


    @Override
    public String toString(){
        return map.toString();
    }
}