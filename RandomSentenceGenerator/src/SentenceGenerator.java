import java.util.Random;

/**
 * This program generates random sentences using the sentence structure provided by the Instructor.
 * Sentences consist of a noun phrase and a verb phrase, and may repeat to create longer sentences.
 * 
 * @author Natalia
 *
 */

public class SentenceGenerator {

	 static final String[] conjunction = {"and","or","but","because"};
	 static final String[] proper_nouns = {"Fred","Jane","Richard Nixon","Miss America"};
	 static final String[] common_nouns = {"man","woman","fish","elephant","unicorn"};
	 static final String[] determiner = {"a","the","every","some"};
	 static final String[] adjective = {"big","tiny","pretty","bad"};
	 static final String[] intransitive_verb = {"runs","jumps","talks","sleeps"};
	 static final String[] transitive_verb = {"loves","hates","sees","knows","looks for","finds"};

	 /**
	  * Creates and prints random sentences. Selects whether the sentence will be simple or have multiple clauses.
	  * Calls on simpleSentence() and on itself if there are multiple clauses.
	  *  
	  * @param ss a randomly generated boolean which will decide if the sentence will be simple
	  */
	 static void createSentence(boolean ss){
		 Random ms = new Random(); //random generator to decide if there will be more than 2 clauses
		 boolean multiples; //stores the boolean dictating multiple clauses
		 
		 //if ss is true, the sentence will have more than one clause; if it's false, a simple sentence is printed.
		 if (ss == true){
			 int c = (int)(Math.random()*conjunction.length); //selects a random conjunction
			 System.out.print(simpleSentence()+" "+conjunction[c]+" ");
			 multiples = ms.nextBoolean(); //
			 createSentence(multiples);
		 } else {System.out.print(simpleSentence());}
	 }
	 
	 /**
	  * Returns a simple sentence made of just a noun phrase and a verb phrase.
	  * Calls on nounPhrase() and verbPhrase() to return.
	  * @return simple sentence as a string
	  */
	 
	 static String simpleSentence(){
		 //calls on subroutines
		 return (nounPhrase()+" "+verbPhrase());
	 }
	 
	 /**
	  * Returns a noun phrase which may include a proper noun or a determiner and a common noun with varying degrees of 
	  * descriptiveness. The level of descriptiveness is determined at random.
	  * Calls on verbPhrase() when describing common nouns.
	  * @return a noun phrase as a string
	  */
	 static String nounPhrase(){
		 //declaring random integers
		 int pn = (int)(Math.random()*proper_nouns.length);//random proper noun selector
		 int d = (int)(Math.random()*determiner.length);//random determiner selector
		 int a = (int)(Math.random()*adjective.length);//random adjective selector
		 int cn = (int)(Math.random()*common_nouns.length);//random common noun selector
		 
		 //creation of random objects to choose between options
		 Random porc = new Random(); //proper or common nouns?
		 boolean proper = porc.nextBoolean();//selects the boolean which selects whether it is a proper noun or not
		 Random desc = new Random(); //descriptive?
		 boolean descript = desc.nextBoolean();//selects the boolean which selects whether the noun phrase will be descriptive
		 //if proper is true, generator will call on a proper noun; if it is false, but the descript is true then a descriptive
		 //common noun is used. Otherwise a simple common noun will be used
		 if (proper == true) {
			 return(proper_nouns[pn]);
		 } else if(descript == true){
			 return (determiner[d]+" "+adjective[a]+" "+common_nouns[cn]+" who "+verbPhrase());
		 }else {return (determiner[d]+" "+common_nouns[cn]);}
	 }
	 
	 /**
	  * Creates a verb phrase made of an intransitive verb, a transitive verb and a noun phrase, an adjective, or a simple 
	  * sentence indicating a belief. All verbs and adjectives are selected at random. The type of verb phrase is also selected
	  * at random.
	  * Calls on nounPhrase() and simpleSentence() as necessary. 
	  * @return a verb phrase as a string
	  */
	 static String verbPhrase(){
		 int type = (int)(Math.random()*4); //random number selects which type of verb phrase will be used
		 switch (type){
		 case 0: {
			 int iv = (int)(Math.random()*intransitive_verb.length);//randomly selects intransitive verb
			 return(intransitive_verb[iv]);
		 }
		 case 1: {
			 int tv = (int)(Math.random()*transitive_verb.length);//randomly selects a transitive verb
			 return (transitive_verb[tv]+" "+nounPhrase());//calls nounPhrase to go with the transitive verb
		 }
		 case 2: {
			 int a = (int)(Math.random()*adjective.length);//randomly selects an adjective
			 return ("is "+adjective[a]);
		 }
		 default: {
			 return("believes that "+simpleSentence());//calls simpleSentence to create a sentence about a belief
		 }
		 }
	 }
	 
	 /**
	  * This program randomly selects a number of sentences to print and creates the sentences using createSentence().
	  * @param args
	  */
	 public static void main(String[] args) {
		 //initializing variables
		 int numbofsent = (int)(Integer.MAX_VALUE*Math.random());//number of sentences to print 
		 Random ss = new Random();//random boolean generator
		 
		 //for loop creates sentences for however many number of sentences numbofsent indicates
		 for (int i=0;i<=numbofsent;i++){
			 boolean simples = ss.nextBoolean();//determines if the sentence will be simple or not
			 //creates and prints sentence
			 createSentence(simples);
			 System.out.println(".\n\n");
			 try {
				 Thread.sleep(3000);
			 }
			 catch (InterruptedException e) {
			 }
		 }
	 }
	
}