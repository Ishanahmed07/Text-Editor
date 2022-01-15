import java.util.*;

public class IDandPasswords {
    HashMap<String, String> loginInfo = new HashMap<String, String>();

    IDandPasswords() {
        loginInfo.put("Admin", "Admin@123");
    }

    public void AddNewUser(){
        Scanner sc = new Scanner(System.in);
        IDandPasswords newUserDetails = new IDandPasswords();
        newUserDetails.loginInfo.put(sc.nextLine(), sc.nextLine());
    }

    protected HashMap getLoginInfo() {
        return loginInfo;
    }
}
