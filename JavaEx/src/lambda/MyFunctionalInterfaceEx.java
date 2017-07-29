package lambda;

public class MyFunctionalInterfaceEx {
   public static void main(String[] args) {
      MyFunctionalInterface fi;
      
      /*fi = () -> {
         String str = "method calll";
         System.out.println(str);
      };
      fi.method();

      fi = () -> { System.out.println("method call2"); };
      fi.method();

      fi = () -> System.out.println("method call3");
      fi.method();*/
      
      fi = (x) -> {
    	  int result = x*5;
    	  System.out.println(result);
      };
      fi.method(2);
      
      fi = (x) -> { System.out.println(x*5); };
      fi.method(2);
      
      fi = x -> System.out.println(x*5);
      fi.method(2);
   }
}