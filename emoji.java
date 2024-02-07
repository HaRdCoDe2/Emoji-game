import java.util.Scanner;//Header files
import java.util.Random;

class emoji
{	
	private static String emojiss[] = {"😂️" ,"😀️","😁️","🤣️","😃️","😄️","😅️","😆️","😉️","😊️","😋️","😎️",  //array initialization of emojis
									   	"😍️","😘️","😗️","☺️","🙂️","🤗️","🤩️","🤔️","🤨️","😐️","😑️","😶️",
									   	"🙄️","😏️","😥️","😮️","🤐️","😯️","😪️","😫️","🤯️","🤑️","😨️","🤪️"}; 

	private static StringBuffer emojiss_add =new StringBuffer();  //StringBuffer to add emojis which have been displayed once 
	Random rand = new Random();  //To display random emojis
	private static int randomint ;  // initialize random int to this variable
	private static int rounds;  // initialize number of emojis to this variable 
	private String input ;  //take input y/n 
	private int points =0;  // Increase points in every correct answer 
	private static boolean game_over = false;  // bool for game loop
	Scanner scanner = new Scanner(System.in); //scanner for sring 
	Scanner scanner1 = new Scanner(System.in);  //scanner for int , created 2 beacuse got some RunTime errors :)

	public static void main(String[] args) {

		emoji Emoji = new emoji();   // To access functions of the main claa
		while(true)
		{

		System.out.print("Enter from how many emojis to play( 1 to 37): ");  // take number of emojis to play with 
		rounds= Emoji.scanner1.nextInt();
		if(rounds>=1 && rounds <=37) // loop for a wrong input 
		{
			break;
		}
		else 
		{
			System.out.println("WRONG INPUT , TRY AGAIN !!");
		}
		}

		while(true)
		{
			System.out.print("\033[H\033[2J");  // clear screen (not really :/)
			System.out.flush(); 
			 randomint = Emoji.rand.nextInt(rounds); //initialize random number between the nuber of emoji given
			Emoji.decision();
			if(game_over==true)

			{	System.out.println("YOU LOSE!!");
				break;
			}

		}
		Emoji.scanner.close();
		Emoji.scanner1.close();

	}

	
		
		void decision() //take input and state whether right or wrong 
		{	
			System.out.println("Points: "+points);
		while(true)
		{
			System.out.println("Have you seen this emoji: "+emojiss[randomint]);
			System.out.println("y/n:");
			input = scanner.nextLine();
			
			if( input.equals("y"))
			{
				if(check() == 0)
				{
					System.out.println("Right answer ");
					points++;
					break;
				}
				else
				{
					System.out.println("Wrong answer ");
					game_over=true;
					break;
				}
				

			}


			else if( input.equals("n"))
			{
				if(check() == 1)
				{
					System.out.println("Right answer ");
					points++;
					break;
				}
				else
				{
					System.out.println("Wrong answer ");
					game_over=true;

					break;
				}

			}
			else
			{
				System.out.println("WRONG INPUT");
			}
		}


		}


int check() // check whether input is right or wrong and retuen value , also adds the displayed emoji inside the stringbuffer 
  {

    StringBuffer newStringBuffer = new StringBuffer(emojiss[randomint]);

    if (emojiss_add.toString().contains(newStringBuffer.toString())) {
        return 0; // Match found
    } else {
        emojiss_add.append(newStringBuffer);
        return 1; // No match found
    }
}




}
