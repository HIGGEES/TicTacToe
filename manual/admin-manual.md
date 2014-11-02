TicTacToe
=========
#### Administration Manual

The following programs are needed to run this program

    Git
    Java JDK 7 
    Gradle


Install and setup Git: go to https://help.github.com/articles/set-up-git for instructions

Install and setup Java: go to http://www.java.com/en/download/help/windows_manual_download.xml for instructions

Install and setup Gradle: go to http://www.gradle.org/docs/current/userguide/installation.html/ for instructions

Install and setup Travis

            sudo apt-get install -y make ruby1.9.1-dev
            sudo gem1.9.1 install travis

Install and setup Heroku

            wget -qO- https://toolbelt.heroku.com/install-ubuntu.sh | sh

Clone the project to your computer by running this command:

        git clone git@github.com:[Your_Username]/[ProjectName].git

Go to https://travis-ci.org/ and create an account
Go to https://www.heroku.com/ and create an account

Deploy and Maintain

To set the heroku key for travis run the following commands

            travis setup heroku
            travis encrypt HEROKU_API_KEY= --add
            
Connect your Travis account with Github then use Heroku toolbelt to create an app

    heroku create --remote staging [your_stage_app_name]
    heroku create --remote production [your_production_app_name]
    
Create an app as staging server:

    git push staging master
    
Create an app as production server:

    git push production master

Change the .travis.yml file according to the heroku apps you just created

            app: "ghastly-monster-9605"
            repo: HIGGEES/TicTacToe  --> repo: [yourRepository]
            export STAGING_SERVER=http://higgees-stage.herokuapp.com/  
            --> - export STAGING_SERVER=http://[your_stage_app_name].herokuapp.com/
            export PRODUCTION_SERVER=http://higgees.herokuapp.com/
            --> - export PRODUCTION_SERVER=http://higgees.herokuapp.com/
    
    
Now everything should be up and running and you will be able to make changes to the program and push them on to github as well on your staging server 
Now you can make some changes to the repository and push them to github and after the project has passed all test it should be up and running on your heroku apps at http://[yourHerokuAppName].herokuapp.com/

