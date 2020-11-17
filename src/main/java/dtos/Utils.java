package dtos;

public class Utils {
    public static String getRandomString(int n)
    {
        String alphabet = "abcdefghijklmnzpqrstuvwxyz0123456789";
        String str = "";
        for (int i=0; i < n;  i++)
        {
            int r = (int) (Math.random() * (alphabet.length() - 1));
            str = str + alphabet.substring(r,r+1);
        }
        return str.toUpperCase();
    }
}
