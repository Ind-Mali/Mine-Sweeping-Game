# Mine Sweeping Game

I create MineSweep class and make this game.
This Class includes prepareGame(), run(), check(),print() methods.

## preparaGame() 
* This method decide the mine in the board.
* If there is not mine at the determined area, it create.

## run()

* This method includes all the game attributes.
* If you give the number and this number does not appear on the board, the app will say you should not enter out of the range.
* If you decide the spot and there is the mine, you will lose this game.
* If you do not select any mine, you will win.

## chech()

* This method is looking the mine.
* If you do not select the mine and there are the mine around the your selection, this app return the count of the mines.
* I looked the area which were topleft, topright, bottom left, bottom right. However, I did not make any solution. If you look my code you will see.
