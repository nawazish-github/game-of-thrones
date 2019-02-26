[![HitCount](http://hits.dwyl.io/nawazish-github/game-of-thrones.svg)](http://hits.dwyl.io/nawazish-github/game-of-thrones)

#System Requirements
- Maven 3.5.2
- Java 8 (preferably v161)

#Installation
- Go to the root directory, namely, game-of-thrones
- Execute mvn clean to clean the project
- Execute mvn install to install maven dependencies and run unit tests

#How to play
- Go to the following directory: $HOME/game-of-empire/target
- There are two command line flags with respect to the two problems
    - --agoldencrown
    - --breakerofchains
- Execute the following command: java -jar game-or-empire.jar --agoldencrown. This allows to play Problem1 where
  King Shan sends random messages to other Kingdoms in Southeros and if he gets 3 positive votes he becomes the ruler of
  Southeros
- Execute the following command: java -jar game-or-empire.jar --breakerofchains. This allows to play Problem2 where
  multiple Kingdoms can participate in the voting process to become ruler of Southeros. High priest then, at random, 
  selects 6 messages and hands over to the recepient Kingdoms, the campaigning Kingdom with maximum positive votes
  is declared the ruler of Southeros by the High Priest
- By default, problem 1 would be executed. That is, if no command line flag is provided problem 1 is executed
- The game expects the user to adhere to the command line input standards as defined in the problem statements

# game-of-thrones
Game Of Thrones: Help the universe of Southeros elect its next emperor. 

There is no ruler in the universe of Southeros and pandemonium reigns. Shan, the gorilla king of the Space kingdom
wants to rule all Six Kingdoms in the universe of Southeros. He needs the support of 3 more kingdoms to be the ruler.

Each kingdom has an animal emblem and Shan needs to send a message with the animal in the message to win them over.
LAND emblem - Panda, WATER emblem - Octopus, ICE emblem - Mammoth, AIR emblem - Owl, FIRE emblem - Dragon.

Your coding challenge is to have King Shan send secret message to each kingdom and win them over.
Once he wins 3 more kingdoms, he is the ruler! The secret message needs to contain the letters of the animal in their
emblem. For example, secret message to the Land kingdom (emblem: Panda) needs to have the letter 'p','n','d' atleast
once and 'a' at-least twice. If he sends "a1d22n333a4444p" to the Land kingdom, he will win them over.

problem 1- sample input output
==============================
Who is the ruler of Southeros?
Ouput: None
Allies of Ruler?
Output: None
Input Messages to kingdoms from King Shan:
Input: Air, “oaaawaala”
Input: Land, “a1d22n333a4444p”
Input: Ice, “zmzmzmzaztzozh”
Who is the ruler of Southeros?
Output: King Shan
Allies of Ruler?
Output: Air, Land, Ice

Who is the ruler of Southeros?
Output: None
Allies of King Shan?
Output: None
Input Messages to kingdoms from King Shan:
Input: Air, “Let’s swing the sword together”
Input: Land, “Die or play the tame of thrones”
Input: Ice, “Ahoy! Fight for me with men and money”
Input: Water, “Summer is coming”
Input: Fire, “Drag on Martin!”
Who is the ruler of Southeros?
Output: King Shan
Allies of King Shan?
Output: Air, Land, Ice, Fire


problem 2: Breaker of Chains
============================

The other kingdoms in the Universe also yearn to be the ruler of Southeros and war is imminent! The High Priest of Southeros
intervenes and is trying hard to avoid a war and he suggests a ballot system to decide the ruler.
Your coding challenge is to help the High Priest choose the ruler of Southeros through the ballot system.
Rules of the Ballot system
1. Any kingdom can compete to be the ruler.
2. They should send a message to all other kingdoms asking for allegiance.
3. This message will be put in a ballot from which the High Priest will pick 6 random messages.
4. The High Priest then hands over the 6 messages to the respective receiving kingdoms.
5. The kingdom that receives the highest number of allegiance is the ruler.

Rules to decide allegiance by a kingdom
1. The receiving kingdom has to give allegiance to the sending kingdom if the message contains the letters of the animal in their
emblem (same as problem 1).
2. If the receiving kingdom is competing to be the ruler, they will not give their allegiance even if the message they received is correct.
3. A kingdom cannot give their allegiance twice. If they have given their allegiance once, they will not give their allegiance again even
if they get a second message and the message is correct.
In case there is a tie
1. If there is a tie, the whole ballot process is repeated but only with the tied kingdoms till there is a winner.
Sending messages
The format of the message dropped in the ballot should contain :
• The Sender kingdom
• The Receiver kingdom
• The Message (should be selected randomly from the messages provided in the table below)

table with messages
===================
Summer is coming
a1d22n333a4444p
oaaawaala
zmzmzmzaztzozh
Go risk it all
Let's swing the sword together
Die or play the tame of thrones
Ahoy! Fight for me with men and money
Drag on Martin!
When you play the tame of thrones you win or you die.
What could we say to the Lord of Death? Game on?
Turn us away and we will burn you first
Death is so terribly final while life is full of possibilities.
You Win or You Die
His watch is Ended
Sphinx of black quartz judge my dozen vows
Fear cuts deeper than swords My Lord.
Different roads sometimes lead to the same castle.
A DRAGON IS NOT A SLAVE.
Do not waste paper
Go ring all the bells
Crazy Fredrick bought many very exquisite pearl emerald and diamond jewels.
The quick brown fox jumps over a lazy dog multiple times.
We promptly judged antique ivory buckles for the next prize.
Walar Morghulis: All men must die.

problem 2- sample input output
==============================

Who is the ruler of Southeros?
Output: None
Allies of Ruler?
Output: None
Enter the kingdoms competing to be the ruler:
Input: Ice Space Air
Results after round one ballot count
Output: Allies for Ice : 2
Output: Allies for Space: 1
Output: Allies for Air: 0
Who is the ruler of Southeros?
Output: Ice
Allies of Ruler?
Output: Land Fire

Who is the ruler of Southeros?
Output: None
Allies of Ruler?
Output: None
Enter the kingdoms competing to be the ruler:
Input: Land Air
Results after round one ballot count
Output: Allies for Land : 1
Output: Allies for Air: 1
Results after round two ballot count
Output: Allies for Land : 1
Output: Allies for Air: 2
Who is the ruler of Southeros?
Output: Air
Allies of Ruler?
Output: Fire Space

Who is the ruler of Southeros?
Output: None
Allies of Ruler?
Output: None
Enter the kingdoms competing to be the ruler:
Input: Fire Space
Results after round one ballot count
Output: Allies for Fire : 0
Output: Allies for Space: 0
Results after round two ballot count
Output: Allies for Fire : 1
Output: Allies for Space: 2
Who is the ruler of Southeros?
Output: Space
Allies of Ruler?
Output: Land Ice

