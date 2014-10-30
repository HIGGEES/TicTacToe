### Status
[![Build Status](https://travis-ci.org/HIGGEES/TicTacToe.svg)](https://travis-ci.org/HIGGEES/TicTacToe)

TicTacToe
=========
Developement Manual

The following programs are needed to run this program

	Git
	Java JDK 7
	Gradle
	Putty

Setting up the environment

1. Install and set up Git: for instructions go to https://help.github.com/articles/set-up-git

2. Install and set up Java: for instructions go to http://www.java.com/en/download/help/windows_manual_download.xml

3. Install Gradle: for instructions go to http://www.gradle.org/help-and-support

	3.1. Add the following software: software-properties-common
		sudo apt-get install software-properties-common
		If you have issues run:
		sudo apt-get install python-software-properties

	3.2. Add the following apt-repo: ppa:cwchien/gradle
		sudo add-apt-repository ppa:cwchien/gradle

	3.3. Update sources:
		sudo apt-get update

	3.4. Install new Gradle version:
		sudo apt-get install gradle

4. Install Travis:

	sudo apt-get install -y make ruby1.9.1-dev
	sudo gem1.9.1 install travis

5. Install Heroku

		wget -qO- https://toolbelt.heroku.com/install-ubuntu.sh | sh



Running the project

Clone this project to your computer, run this command:

git clone git@github.com:HIGGEES/TicTacToe.git

To run the application run the following commands from the root of the project:
        bin/package
        bin/run
Go to ................ to play the game.