import java.util.ArrayList;

public class Storage {
    private ArrayList<GroupOfStaff> groups = new ArrayList<>();

    private GroupOfStaff tmp =null;

    public void addStaff(String name, String description, String producer, int count, int price){

        if (tmp!=null){
            tmp.addStaffToGroup(name,description,producer, count, price);
        }

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
