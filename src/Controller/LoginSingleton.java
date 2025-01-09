package Controller;


public class LoginSingleton {
    private static LoginSingleton instance;
    private int userID;

    public static LoginSingleton getInstance() {
        if (instance == null) {
            synchronized (LoginSingleton.class) {
                if (instance == null) {
                    instance = new LoginSingleton();
                }
            }
        }
        return instance;
    }

    public void setID(int id) {
        this.userID = id;
    }

    public int getID() {
        return userID;
    }
}