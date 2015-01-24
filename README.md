This file should at least attempt to explain the plan and how to set things up!!!

////Getting Started////
In order to work on this project you will need a few things.


///GIT///

INSTALL GIT
- install git which can be done here: http://git-scm.com/book/en/v2/Getting-Started-Installing-Git#Installing-on-Mac
- Make sure it is working by opening terminal and typing git
- git allows you to pull repositories from places like git hub, creating a local repository, and push that local one back to the remote one

IMPORTANT COMMANDS - these commands are used in terminal
- git clone <uri> : this clones the repository from the uri locally so you can modify it and later push it back up
- git add <FilePath> : this adds the file that specified so its included when commited
- git commit : this will open a vim window (see VIM) that you can write the message of the commit and when completed the changed files that were added in "git add" will be commited
- git push : this will push the git file to the remote repository. *If pushing with arcanist is done properly this should not be needed
- git branch : this allows you to create a new branch, list the branches and delete branches.  This should be used when working on different features as if something goes wrong, it will remain solely on the branch
- git branch -D <BranchName> : this deletes the branch
- git checkout <BranchName> : this allows you to switch between branches
- git checkout -b <BranchName> : this creates a new branch 
- git log : displays a log of all of the past commits with the commit id, the writer, the date, and the commit message.  This is useful when needed to revert to a previous commit
- git status : lists all of the files that were modified or added so you can keep track of what is going to be commited

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
- arc land : this is what can be used instead to replace git push. The difference is that it will only let you push if you were approved by a revisor.  *I havent gotten this working yet and will be worked on


///PHABRICATOR///

USING PHABRICATOR
- Phabricator is used to manage projects, allowing code that is uploaded using arc diff to be reviewed by different people. This is done so that people who are working on the project can give their feedback and understand what is being added
- You can also create tasks and manage their importance which is a good was of managing and keeping track of bugs and getting things done


///VIM///
- VIM is an editor that is often used inside of terminal

USING VIM
- There are a only a few things to know about VIM in this context
  - To start typing you will have to press "i"
  - When you are done, press escape to exit the insert mode and then type ":wq" which will write and quit


///COMMITING AND PUSHING TO REMOTE REPOSITORY///
- First you want to make sure that you are on a different branch than master
  - to do this type "git branch". The branch that appears green indicates that you are on that branch
  - if you are on the master branch, either switch to a feature branch or create a new feature branch.  This is done by using either "git checkout <BranchName>" to switch to an existing branch and "git checkout -b <BranchName>" to create a new branch and switch to it"
- Then you want to commit the changes that were important to your patch
  - type "git status" to list the files that were changed or modified
  - add all of these files that you want to commit by typing "git add <FilePath>" git status lists the filepaths as well which helps when you need to type it out. *DO NOT add the file .classpath as this is what eclipse uses to path to jar files such as lwjgl and on different computers this file is likely to be located in a different location.
  - initiate the commit by typing "git commit" which by default should open VIM.  Type in your commit message and then save and quit
- Instead of pushing it immidiatly, you would want to use arcanist and phabricator
  - type "arc diff". This should remind you that you have files that arent staged and ask if you would want to stage them.  Press N for no which should bring up another editor.
  - This will ask for a summary, reviewers, subscribers, and testing plan: Summary is where you can sum up the changes in greater detail. Reviewers is where you list the reviewers separated with commas. Subcribers is where you list subscribers separated by commas. And testing plan is where you write the testing plan, most often just write "Manual"
- Wait for the rewiewer(s) to approve of the Differencial and then you can push the commit to the remote repository
  - This should be done using the "arc land" command which will merge your feature branch onto the master branch and then push that master branch to the remote repository.  *This will not work if you did not create a different branch for your additions
