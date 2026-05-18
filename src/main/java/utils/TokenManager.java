package utils;

public class TokenManager {

    private static String token;
    private static String workspacePath;


    public static void setToken(String newToken) {
        token = newToken;
    }

    public static String getToken() {
        return token;
    }
    
     public static void setWorkspacePath(String path) {
        workspacePath = path;
    }

    public static String getWorkspacePath() {
        return workspacePath;
    }
}
