import java.io.*;
import java.util.ArrayList;

public class Storage {
    Storage() {
        groups = new ArrayList<>();
        tmp = null;
        test.fileStorage = new File("tmp2.txt");
    }
    Storage (File file) throws IOException {
        groups = new ArrayList<>();
        tmp = null;
        buildStorage(file);
    }

    private void buildStorage(File file) throws IOException {
        BufferedReader rd;
        FileReader fr = new FileReader(file);
        rd = new BufferedReader(fr);
        rd.readLine();
        String str="";
        String getted ="";
        do {
            getted = rd.readLine();
            if(getted!=null) str = str + getted;
        } while (getted!=null);
        System.out.println(str);

        String[] groups = str.split("<\\*group\\*>");
        for(String s: groups) {
            System.out.println(s);
        }
        for(int i = 0; i < groups.length;i++){
            String[] groupAndListOfStaff = groups[i].split("<\\*endGroup\\*>");
            String[] nameAndDesc = groupAndListOfStaff[0].split("<\\*end\\*>");
            String nameGroup = nameAndDesc[0];
            String descGroup = nameAndDesc[1];
            Storage.groups.add(new GroupOfStaff(nameGroup,descGroup));

            String[] staffs = groupAndListOfStaff[1].split("<\\*endStaff\\*>");
            for(int j = 0; j < staffs.length; j++) {
                String[] chr = staffs[j].split("<\\*end\\*>");
                Storage.groups.get(i).addStaffToGroup(chr[0],chr[1],chr[2],Integer.parseInt(chr[3]),Integer.parseInt(chr[4]));
            }

            fr.close();
        }

    }
    static boolean checkIsStorage(File file) throws IOException {
        BufferedReader rd;
        FileReader fr = new FileReader(file);
        rd = new BufferedReader(fr);
        String check = rd.readLine();
        fr.close();
        if(check.equals("<*STORAGE*>")) return true;
        return false;
    }

    static ArrayList<GroupOfStaff> groups;
    static GroupOfStaff tmp;

    public void addStaff(String name, String description, String producer, int count, int price){
        checkIsStaffUnique(name);
        if (tmp != null) {
            tmp.addStaffToGroup(name, description, producer, count, price);
        }
    }

    public void addGroup(String name, String description){
      if (checkIsGroupUnique(name))groups.add(new GroupOfStaff(name, description));
    }

    public static Staff SearchStaffByName(String name) {
        for(int i = 0; i < groups.size(); i++){
            for(int j = 0; j < groups.get(i).getStaffCollection().size(); j++){
                if (groups.get(i).getStaffCollection().get(j).getName().equals(name))
                    return groups.get(i).getStaffCollection().get(j);
            }
        }
        return null;
    }

    private void editGroup(String name, String description) {
        if(!name.equals(tmp.getName())) {
            if (checkIsGroupUnique(name)) {
                tmp.setName(name);
                tmp.setDescription(description);
            }
            else ;
            //JDialog that group with this name already exist
        }
        else tmp.setDescription(description);
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

    public static File makeSave() throws IOException {
        File file = new File("tmp1.txt");
        FileWriter fr = new FileWriter(file);
        fr.append(getId());
        fr.close();
        return file;
    }

    private static String getId(){
        String allGrops = "<*STORAGE*>\n";
        for(int i = 0; i < groups.size(); i++) {
            allGrops += groups.get(i).getId();
        }
        return  allGrops ;
        }


    public static String getInfo(){
        String res = "";
        int PRICE = 0;

            for(int i = 0; i < groups.size(); i++) {
                res += groups.get(i).getInfo();
                PRICE += groups.get(i).priceAllStaffs();
            }

        return res +"\n"+"\n" + "Price all staffs on storage:" + PRICE;
    }


/*

Matcher mA = Pattern.compile(" +").matcher(allRules);
			String ar = mA.replaceAll("");
			String[] pidstanovka = ar.split(";");
 */


}
