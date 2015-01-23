This file should at least attempt to explain the plan and how to set things up!

////Getting Started////
In order to work on this project you will need a few things.


///GIT///

INSTALL GIT
- install git which can be done here: http://git-scm.com/book/en/v2/Getting-Started-Installing-Git#Installing-on-Mac
- Make sure it is working by opening terminal and typing git
- git allows you to pull repositories from places like git hub, creating a local repository, and push that local one back to the remote one

IMPORTANT COMMANDS - these commands are tun in terminal
- git clone <uri> : this clones the repository from the uri locally so you can modify it and later push it back up
- git add <FileName> : this adds the file that 
- git commit : this will open a vim window (see VIM) that you can write the message of the commit and when completed the changed files that were added in "git add" will be commited
- git push : this will push the git file to the remote repository, note that this should not be done after a commit as there is an intermidiate step involving arcanist
- git branch : this allows you to create a new branch, list the branches and delete branches.  This should be used when working on different features as if something goes wrong, it will remain solely on the branch
- git checkout <BranchName> : this allows you to switch between branches

SETUP REPOSITORY
- After installing git, use terminal to navigate to a directory that you wish to contain your local repiratory
- Type git clone and then the uri, which is currently "https://github.com/Luner/Game-Engine"
- This will copy the things from online into that directory


///ECLIPSE///

INSTALL ECLIPSE
- download eclipse from https://eclipse.org/downloads/

SETUP EGIT
- Open Eclipse and go to Help -> Install new software.
- Follow your instructions and use: http://download.eclipse.org/egit/updates
- Check everything then continue

CONNECT TO REPOSITORY
- Create a new workspace, preferably in an entirely different location than the local git repository
- Then Import -> Projects from Git -> Existing Local Repository and locate the local repository that you cloned earlier
- This should do it

///ARCANIST///

INSTALL ARCANIST
- Follow the instructions on : https://secure.phabricator.com/book/phabricator/article/arcanist/
- Test to make sure that arcanist was installed correctly by typing "arc help" into the terminal command line

IMPORTANT COMMANDS
- arc diff : after commiting things in git, use this to send the differencials to phabricator
  - the first time you use this it will ask you to run "arc install-certificate"  follow the instructions after this, you will be asked to copy and paste a token authenticating you permissions

///PHABRICATOR///

USING PHABRICATOR
- Phabricator is used to manage projects, allowing code that is uploaded using arc diff to be reviewed by different people. This is done so that people who are working on the project can give their feedback and understand what is being added
- You can also create tasks and manage their importance which is a good was of managing and keeping track of bugs and getting things done

///PUSHING TO REMOTE REPOSITORY///
