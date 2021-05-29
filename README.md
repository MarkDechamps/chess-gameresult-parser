# chess-gameresult-parser
This project Transforms a google form to interactive html for your website


Your playing a chess competition. After each game you want players to fill out an online form with their results
and also perhaps a sall report of the game.

You do this with a predefined google form.

Then, download the csv file from the Google form and use this project to generate an html file from it.
Easy peasy.

The program builds a jar called csvparser. See the example command line below:

"C:/Program Files/Java/jdk-11.0.5/bin/java" -jar csvparser-1.0-SNAPSHOT.jar ./"OKS2 Resultaten B-reeks".csv 4

here OKS2 Resultaten B-reeks is the name of the file, and the 4 is the round I want to generate the html for.
