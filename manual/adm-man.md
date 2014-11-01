TicTacToe
=========
#### Administration Manual

The following programs are needed to run this program

    Git
    Java JDK 7 
    Gradle

###### Setting up the environment

Install Git: go to https://help.github.com/articles/set-up-git for instructions

Install Java: go to http://www.java.com/en/download/help/windows_manual_download.xml for instructions

Install Gradle: go to http://www.gradle.org/docs/current/userguide/installation.html/ for instructions

Install Travis

            sudo apt-get install -y make ruby1.9.1-dev
            sudo gem1.9.1 install travis

Install Heroku

            wget -qO- https://toolbelt.heroku.com/install-ubuntu.sh | sh

Fork this repository
Clone the project to your computer, run this command:

        git clone git@github.com:[Your_Username]/[ProjectName].git

Go to https://travis-ci.org/ and create an account
Go to https://www.heroku.com/ and create an account

Deploy and Maintain

To set the heroku key for travis run the following commands

            travis setup heroku
            travis encrypt HEROKU_API_KEY= --add
            
Connect your Travis account with Github
Use Heroku toolbelt to create an app
heroku create
Create on app as staging server and one app as production server
You will need to change the .travis.yml file according to the heroku apps you just created
            app: 
            repo: HIGGEES/TicTacToe  --> repo: [yourRepository]
            - export STAGING_SERVER=http://HIGGEES.herokuapp.com/  --> - export STAGING_SERVER=http://[yourAppName].herokuapp.com/
Now you can make some changes to the repository and push them to github and after the project has passed all test it should be up and running on your heroku apps at http://[yourHerokuAppName].herokuapp.com/
