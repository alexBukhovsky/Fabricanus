import java.util.ArrayList;

public class Storage {

    Storage () {
        groups = new ArrayList<>();
        tmp = null;
    }

    private ArrayList<GroupOfStaff> groups;
    private GroupOfStaff tmp;

    public void addStaff(String name, String description, String producer, int count, int price){
        checkIsStaffUnique(name);
        if (tmp != null) {
            tmp.addStaffToGroup(name, description, producer, count, price);
        }
    }

    public void addGroup(String name, String description){
      if (checkIsGroupUnique(name))groups.add(new GroupOfStaff(name, description));
    }

    private Staff SearchStaffByName(String name) {
        for(int i = 0; i < groups.size(); i++){
            for(int j = 0; j < groups.get(i).getStaffCollection().size(); j++){
                if (groups.get(i).getStaffCollection().get(j).getName().equals(name))
                    return groups.get(i).getStaffCollection().get(j);
            }
        }
    return null;
    }

    private boolean checkIsStaffUnique(String name) {
        for(int i = 0; i < groups.size(); i++){
            for(int j = 0; j < groups.get(i).getStaffCollection().size(); j++){
                if (groups.get(i).getStaffCollection().get(j).getName().equals(name))
                    return false;
            }
        }
        return true;
    }

    private boolean checkIsGroupUnique(String name) {
    for (int i = 0; i < groups.size(); i++){
        if (groups.get(i).getName().equals(name))return false;
    }
        return true;
    }

    private void deleteGroup(String name) {
        for(int i = 0; i < groups.size(); i++) {
            if(groups.get(i).getName().equals(name)) {
                groups.remove(i);
                return;
            }
        }
    }
}
