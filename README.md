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


What does the csv file have to look like ? 

[timestamp],[name], [game name], [round], [result], [link to the game], [game report]

timestamp: google forms always adds this
name: text field on the form
game name: this is a multiple choice (radiobutton) box on my form where I copy paste the pairings in before the game. It looks like 'Mr White vs Mr Black' for instance. 
round: a drop down box with a single value (the round number)
result: I use a drop down box with the values 1-0, 0-1 or 1/2-1/2 but you can use what you want.
link to the game: we use a lichess link, it makes the games clickable. But not mandatory.
Game report: text box where people can write their game report.
