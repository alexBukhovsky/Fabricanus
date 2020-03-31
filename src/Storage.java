import java.util.ArrayList;

public class Storage {
    private ArrayList<GroupOfStaff> groups = new ArrayList<>();

    private void deleteGroup(String name) {
        for(int i = 0; i < groups.size(); i++) {
            if(groups.get(i).getName().equals(name)) {
                groups.remove(i);
                return;
            }
        }
    }
}
