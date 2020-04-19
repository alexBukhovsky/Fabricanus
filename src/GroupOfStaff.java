import java.util.ArrayList;

public class GroupOfStaff {
    private String name;
    private String description;
    private ArrayList<Staff> staff = new ArrayList<>();

    public GroupOfStaff(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName(){
        return this.name;
    }

    private void deleteStaff(String name) {
        for(int i = 0; i < staff.size(); i++) {
            if(staff.get(i).getName().equals(name)) {
                staff.remove(i);
                return;
            }
        }
    }

    @Override
    public String toString(){
        return name;
    }

    public void addStaffToGroup(String name, String description, String producer, int count, int price){
        staff.add(new Staff(name,description,producer, count, price));
    }

    public ArrayList<Staff> getStaffCollection() {
        return this.staff;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
