/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

/**
 *
 * @author Acer
 */
public class UserStorage {
    private static String User;
    private static int level;

    public static String getUser() {
        return User;
    }

    public static void setUser(String User) {
        UserStorage.User = User;
    }

    public static int getLevel() {
        return level;
    }

    public static void setLevel(int level) {
        UserStorage.level = level;
    }
    
}
