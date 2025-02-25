package easy;

public class ToLower {
    public String toLowerCase(String s) {
        StringBuilder ans  = new StringBuilder();
      for(char c : s.toCharArray()){
          if(c >= 'A' && c <= 'Z'){
              c += 32;
          }
       ans.append(c);
      }
        return ans.toString();
    }

    public static void main(String[] args) {
        ToLower toLower = new ToLower();
        System.out.println(toLower.toLowerCase("Hello"));
    }

}

