public class Main {
    public static void main(String[] args) {
        IDandPasswords IdPass = new IDandPasswords();
        LoginPage loginpage = new LoginPage(IdPass.getLoginInfo());
    }
}
