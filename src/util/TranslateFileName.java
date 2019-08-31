package util;

/**
 * jh
 * 2019年08月31日  15：40
 */
public class TranslateFileName {
    public static void main(String[] args) {
        System.out.println(translate("populating-next-right-pointers-in-each-node"));
    }

    public static String translate(String s){
        if(s == null || s.length() == 0){
            return null;
        }

        char[] chars = s.toCharArray();
        chars[0] = Character.toUpperCase(chars[0]);
        for(int i = 1;i<chars.length-1;i++){
            if(chars[i] == '-'){
                chars[i+1] = Character.toUpperCase(chars[i+1]);
            }
        }
        String result = String.valueOf(chars);

        return  result.replace("-","");
    }
}