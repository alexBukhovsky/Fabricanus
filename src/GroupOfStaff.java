import java.util.ArrayList;

public class GroupOfStaff {
    private String name;
    private String description;

    ArrayList<Staff> staffs = new ArrayList<>();
    Staff tmp;

    public GroupOfStaff(String name, String description) {
        this.name = name;
        this.description = description;
        tmp = null;
    }

    public String getName(){
        return this.name;
    }

    private void deleteStaff(String name) {
        for(int i = 0; i < staffs.size(); i++) {
            if(staffs.get(i).getName().equals(name)) {
                staffs.remove(i);
                return;
            }
        }
    }

    @Override
    public String toString(){
        return name;
    }

    public void addStaffToGroup(String name, String description, String producer, int count, int price){
        staffs.add(new Staff(name,description,producer, count, price));
    }

    public ArrayList<Staff> getStaffCollection() {
        return this.staffs;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId(){
        String allStaffs = "";
        for(int i = 0; i < staffs.size(); i++) {
            allStaffs += staffs.get(i).getId();
        }
        return name + "<*end*>"+description+"<*endGroup*>" + allStaffs +"<*group*>";
    }

}
