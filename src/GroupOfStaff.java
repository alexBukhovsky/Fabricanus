import java.util.ArrayList;

public class GroupOfStaff {
    private String name;
    private String description;
    private ArrayList<Staff> staff = new ArrayList<>();

    public GroupOfStaff(String name, String description) {
        checkIsUnique(name);
        this.name = name;
        this.description = description;
    }

    public String getName(){
        return this.name;
    }


    private void editGroup(String name, String description) {
        if(checkIsUnique(name)) {
            this.name = name;
            this.description = description;
        }
        else ; //JDialog that group with this name already exist
    }

    private void deleteStaff(String name) {
        for(int i = 0; i < staff.size(); i++) {
            if(staff.get(i).getName().equals(name)) {
                staff.remove(i);
                return;
            }
        }
    }

    public void addStaffToGroup(String name, String description, String producer, int count, int price){
        staff.add(new Staff(name,description,producer, count, price));
    }

    private boolean checkIsUnique(String name) {
        // if unique then true
        return true;
        //else false
    }
}
