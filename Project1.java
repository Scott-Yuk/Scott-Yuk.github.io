import java.awt.Color;

public class Project1 {

	public static void main(String[] args) {
		boolean ya = true; // This code is used to control the while loop so I can choose when I want to
							// end the loop.
		EZ.initialize(1200, 900); // Makes the Background Screen
		EZ.setBackgroundColor(new Color(200, 200, 200)); // Changes the Color of the Background to purple
		EZImage RopeToyPicture = EZ.addImage("RopeToy.png", 1100, 760); // Makes the variable of the picture and added
																		// to picture to the set location.
		RopeToyPicture.scaleTo(0.6); // Scales the image to make it smaller
		EZImage BonePicture = EZ.addImage("Bone.png", 90, 250);
		BonePicture.scaleTo(0.7);
		EZImage SteakPicture = EZ.addImage("Steak.png", 1100, 190);
		SteakPicture.scaleTo(0.4);
		EZImage LeashPicture = EZ.addImage("Leash.png", 1000, 700);
		LeashPicture.scaleTo(1.0);
		EZImage LightingBoltPicture = EZ.addImage("LightingBolt.png", 300, 75);
		LightingBoltPicture.scaleTo(0.6);
		EZImage MegaPhonePicture = EZ.addImage("MegaPhone.png", 150, 650);
		MegaPhonePicture.scaleTo(0.6);
		EZImage PersonPicture = EZ.addImage("Person.png", 55, 750);
		PersonPicture.scaleTo(0.5);
		EZImage TennisBallPicture = EZ.addImage("TennisBall.png", 250, 30);
		TennisBallPicture.scaleTo(0.12);
		EZImage VacuumPicture = EZ.addImage("Vacuum.png", 1000, 200);
		VacuumPicture.scaleTo(0.6);
		EZImage CorgiPicture = EZ.addImage("Corgi.png", 500, 350);
		EZImage CatPicture = EZ.addImage("Cat.png", 1200, 900);
		EZ.addImage("Whitebox.png", 80, 0);
		int fontsize = 50; // Changes the font size to of the different text that will appear on the screen
		int font = 48;
		int LFont = 70;
		EZSound Woosh = EZ.addSound("Woosh-Mark_DiAngelo-4778593.wav"); // Adds the sound effects when Yip collects or
																		// collides with certain items.
		EZSound CatScream = EZ.addSound("CatScream.wav");
		EZSound MegaPhone = EZ.addSound("MegaPhone.wav");
		EZSound Thunder = EZ.addSound("Thunder.wav");
		EZSound VacuumSuck = EZ.addSound("VacuumSuction.wav");
		EZSound BallSqueak = EZ.addSound("BallSqueak.wav");
		EZSound BoneCol = EZ.addSound("BoneCol.wav");
		EZSound Ending = EZ.addSound("Ending.wav");
		EZSound PersonCol = EZ.addSound("PersonCol.wav");
		EZSound RopeCol = EZ.addSound("RopeCol.wav");
		EZSound Steak = EZ.addSound("SteakCol.wav");
		EZText text = EZ.addText(650, 50, "GET YIPS STUFF", new Color(255, 100, 255), fontsize); // Adds t
		//text.setFont("8-BIT WONDER.TTF"); // The type of font style

		int posX = 1200; // Has the X position of the Cat
		int posY = 900; // Has the Y position of the Cat
		int directionX = 7; // The X Direction of movement of the Cat
		int directionY = 7; // The Y Direction of movement of the Cat
		int rotationAngle = 0; // Use to store the rotation angle of the Cat

		int ropeX = 1100; // Holds the X position of the rope
		int ropeY = 760; // Holds the Y position of the rope

		int steakX = 1100;
		int steakY = 190;

		int personX = 55;
		int personY = 750;

		int boneX = 90;
		int boneY = 250;

		int tennisballX = 250;
		int tennisballY = 30;

		int counter = 0; // They way for the computer to keep count of how many things the player
							// collected

		while (ya) {
			CatPicture.translateTo(posX, posY); // Set the position of the Cat

			CatPicture.rotateTo(rotationAngle); // Set the rotation angle of the Cat

			posX = posX + directionX; // Makes the Cat move in the X direction
			posY = posY + directionY;// Makes the Cat move in the Y direction
			rotationAngle++; // Makes the Cats rotate more

			if (posX > 1200) { // Keeps the Cat in bounds of the initialized dimensions from going to the right
				directionX = -directionX;
			}
			if (posX < 0) { // Keeps the Cat in bounds of the initialized dimensions from going to the left
				directionX = -directionX;
			}
			if (posY > 900) { // Keeps the Cat in bounds of the initialized dimensions from going down
				directionY = -directionY;
			}
			if (posY < 0) { // Keeps the Cat in bounds of the initialized dimensions from doing up
				directionY = -directionY;
			}

			int pos = CorgiPicture.getXCenter(); // Keeps the Corgis X location
			int poss = CorgiPicture.getYCenter(); // Keeps the Corgis Y location
			CorgiPicture.pullToFront();

			if (pos > 1200) {
				pos = 1200;
				CorgiPicture.translateTo(1200, poss);
			}
			if (pos < 0) {
				pos = 0;
				CorgiPicture.translateTo(0, poss);
			}
			if (poss > 900) {
				poss = 900;
				CorgiPicture.translateTo(pos, 900);
			}
			if (poss < 0) {
				poss = 0;
				CorgiPicture.translateTo(pos, 0);
			}

			if (CorgiPicture.isPointInElement(ropeX, ropeY)) { // If the Corgi reaches this location he has collected
																// the item
				RopeToyPicture.scaleTo(0.2);
				RopeToyPicture.pullToFront(); // Makes the item appear infront of a given image
				RopeToyPicture.translateTo(18, 20); // Moves the image to the given location on the screen
				RopeCol.play(); // Plays the sound when the item is collected
				ropeX = -100; // Moves the item off screen
				ropeY = -100;
				counter++; // Increase the amount of things the player collected by 1
			}

			if (CorgiPicture.isPointInElement(steakX, steakY)) {
				SteakPicture.scaleTo(0.2);
				SteakPicture.pullToFront();
				SteakPicture.translateTo(35, 55);
				Steak.play();
				steakX = -100;
				steakY = -100;
				counter++;
			}

			if (CorgiPicture.isPointInElement(personX, personY)) {
				PersonPicture.scaleTo(0.2);
				PersonPicture.pullToFront();
				PersonPicture.translateTo(75, 20);
				PersonCol.play();
				personX = -100;
				personY = -100;
				counter++;
			}

			if (CorgiPicture.isPointInElement(boneX, boneY)) {
				BonePicture.scaleTo(0.4);
				BonePicture.pullToFront();
				BonePicture.translateTo(110, 55);
				BoneCol.play();
				boneX = -100;
				boneY = -100;
				counter++;
			}

			if (CorgiPicture.isPointInElement(tennisballX, tennisballY)) {
				TennisBallPicture.scaleTo(0.1);
				TennisBallPicture.pullToFront();
				TennisBallPicture.translateTo(130, 20);
				BallSqueak.play();
				tennisballX = -100;
				tennisballY = -100;
				counter++;
			}

			if (CorgiPicture.isPointInElement(1000, 700)) { // If the Corgi reaches this location something will happen
				ya = false;// Makes the while loop condition false
				Woosh.play(); // Plays the noise when the Corgi hits a certain item
				EZ.addText(600, 450, "YIP GOT TAKEN AWAY", new Color(255, 0, 0), LFont); // Text appears when the Corgi
																							// hits the image, telling
																							// the player what happened
																							// to Yip
			}

			if (CorgiPicture.isPointInElement(280, 75)) {
				ya = false;
				Thunder.play();
				EZ.addText(600, 450, "YIP GOT SHOCKED", new Color(255, 0, 0), LFont);
			}

			if (CorgiPicture.isPointInElement(150, 650)) {
				ya = false;
				MegaPhone.play();
				EZ.addText(600, 450, "YIP GOT SCARED", new Color(255, 0, 0), LFont);
			}

			if (CorgiPicture.isPointInElement(1000, 200)) {
				ya = false;
				VacuumSuck.play();
				EZ.addText(600, 450, "YIP GOT SUCKED UP", new Color(255, 0, 0), LFont);
			}

			if (EZInteraction.isKeyDown('d')) { // Checks if you pressed the 'd' Key
				CorgiPicture.turnRight(7); // Turns right 7 degrees
			} else if (EZInteraction.isKeyDown('a')) { // Checks if you pressed the 'a' Key
				CorgiPicture.turnLeft(7); // Turns left 7 degrees
			} else if (EZInteraction.isKeyDown('w')) { // Checks if you pressed the 'w' Key
				CorgiPicture.moveForward(10); // Move your Corgi forward 10 pixels
			} else if (EZInteraction.isKeyDown('s')) { // Checks if you pressed the 's' Key
				CorgiPicture.moveForward(-10); // Move your Corgi backward 10 pixels
			}

			if (CorgiPicture.isPointInElement(posX, posY)) { // If the Corgi reaches a certain location the if statement
																// will go
				ya = false;
				CatScream.play();
				EZ.addText(600, 450, "YIP GOT CAUGHT", new Color(255, 0, 0), LFont);
			}
			if (counter == 5) { // If the counter reaches 5 the if statement will go
				ya = false;
				EZ.addText(600, 450, "Yay YIP GOT EVERYTHING BACK", new Color(0, 255, 0), font);
				Ending.play();
			}

			EZ.refreshScreen(); // Makes the screen constantly refresh the screen.
		}

	}
}