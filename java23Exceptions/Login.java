package java23Exceptions;

public class Login {
    private String inputMail;
    private String inputPassword;

    public Login(String mail, String password) {
        this.inputMail = mail;
        this.inputPassword = password;
    }

    public void checkUserTestNPE(String userMail, String userPassword) {
            if (userMail.equals(inputMail) && userPassword.equals(inputPassword)){
                System.out.println("You have been logged successfully!");
            }
            else {
                System.out.println("Your email or password is incorrect...");
            }
        }

    public void checkUser(String userMail, String userPassword) {
        try {
            if (userMail.equals(inputMail) && userPassword.equals(inputPassword)){
                System.out.println("You have been logged successfully!");
            }
            else {
                System.out.println("Your email or password is incorrect...");
            }
    } catch (NullPointerException e) {
            System.out.println("The field of mail or password is empty.");
        }
    }

    public static void main(String[] args) {
        Login user1 = new Login("jimm.kerry@google.com", "kerry123");
        user1.checkUserTestNPE("jimm.kerry@google.com", null);
        user1.checkUser("jimm.kerry@google.com", null);

    }
}
