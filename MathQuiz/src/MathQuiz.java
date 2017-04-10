
public class MathQuiz {
	public static void main(String[] args) {
	      System.out.print("What's your name? ");
	      String name = TextIO.getln();
	      System.out.println("Pleased to meet you, " + name);
	      AdditionProblem addprob = new AdditionProblem();
	      System.out.print(addprob.getProblem() + " = ");
	      int ans = TextIO.getlnInt();
	      if (ans == addprob.getAnswer()) {
	    	  System.out.println("Correct!");
	      } else {
	    	  do{
	    		  System.out.println("Sorry, that is incorrect. Try again.");
	    		  System.out.print(addprob.getProblem() + " = ");
		    	  ans = TextIO.getlnInt();
	    	  } while (ans != addprob.getAnswer());
	    	  System.out.println("Correct!");
	      }
	}
}
