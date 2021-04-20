package sk.stu.fiit.systemBase;

public interface Sys {
    public void start();
    public boolean verifyUser(String name);
    public boolean verifyUser(int pwd);
    public void turnOffSystem();
}
