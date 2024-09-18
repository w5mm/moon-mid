package easy;

public class toLower {
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
        toLower toLower = new toLower();
        System.out.println(toLower.toLowerCase("Hello"));
    }
    
}

