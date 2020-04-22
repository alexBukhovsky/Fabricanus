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
    public String getDescription(){
        return this.description;
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

    public void addStaffToGroup(Staff stafchik){
        staffs.add(stafchik);
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

    public int priceAllStaffs(){
        int res=0;
        for(int i = 0; i < staffs.size(); i++) {
            res += staffs.get(i).getPrice()*staffs.get(i).getCount();
        }
        return res;
    }


    public String getInfo(){
        String allStaffs = "";
        int priceallSt = 0;
        for(int i = 0; i < staffs.size(); i++) {
            allStaffs += staffs.get(i).getInfoForSt();
            priceallSt += staffs.get(i).getPrice()*staffs.get(i).getCount();
        }
        return "Group: " + name + " (" +description + ") Price all Staffs: " + priceallSt +"\n" + allStaffs +"\n"+"\n" ;
    }

    public String getId(){
        String allStaffs = "";
        for(int i = 0; i < staffs.size(); i++) {
            allStaffs += staffs.get(i).getId();
        }
        return name + "<*end*>"+description+"<*endGroup*>" + allStaffs +"<*group*>";
    }

}
