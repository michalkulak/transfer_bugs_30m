## Recruitment Tasks
This project is a collection of recruitment tasks to use during technical interview or to send to candidate to resolve at home.

Every task should be kept on separate, properly named, branch. You can fetch the repository on your local machine and let the candidate work on it.

### How to use this repository

:warning: **Candidate's solution should be never merged to a task branch!**

:warning: **The task branch itself should always be protected from merging unapproved PRs**

The desired way of work is to create a child branch from the task branch, name it properly (e.g. `Candidate_John_Smith_task_1`) and create a PR to a task branch after the task is resolved.

This approach will allow us to achieve the following goals:

1. Conduct technical interview live coding part in a well-organized manner, using the most up-to-date task version
2. Allow every recruitment team member to review the candidate's solution easily
3. Share the long recruitment task (to resolve at home) with candidate by forking proper branch and give him proper access to the new repository
4. Check how the candidate is working with repositories
5. Share thoughts and proposals of tasks change within the recruitment team
6. Build durable and growing base of solutions that may help us to make recruitment tasks better

### Adding new task
To add new task create a new child branch from `master`. Then do the following steps:

#### Naming task branch
Task branch should be named in according to the following template:
```
task_name_30m
```
where `30m` is roughly estimated time the candidate should resolve task (to indicate whether the task is long or short)

For example branch for _Implement Fibonacci series using recursion_ task could be named `fibonacci_recursion_20m`and a branch for _Design and implement POC of money transfer system_ task could be named `money_transfer_poc_1d`.

#### Task branch content
New branch should always contain `readme` file with a detailed description of the task

* What are the requirements
* What is the desired output
* What is the input
* What is the minimal acceptable solution and how can we extend and upgrade the solution (if we can)

Due to the task type the branch can contain also some initial packages, sources, tests, interfaces etc

#### Task branch protection rules
After the task branch is created you should create a proper protection rule to protect the branch from merging unapproved PR into it. To make this you need to be a member of **recruitment** team - ask Service Desk or another person with such privilige to add you to the group.

To set proper protection rules go to the **settings -> branches -> branch protection rules -> add rule**, provide the task branch name and set proper options. At least options **Require pull request reviews before merging** (required reviews should be **2**) and **Require review from Code Owners** should be checked.

To get more information about branch protection rules you can take a look here:

* [GitHub documentation](https://docs.github.com/en/free-pro-team@latest/github/administering-a-repository/configuring-protected-branches)
* [DevOps documentation and leads for WorldRemit repositories](https://github.com/Worldremit/devops-documentation/blob/master/howtos/github/repositories-setup.md#repository---branch-protection)

### Provide task to the candidate

#### Onsite interview
Fetch the `recruitment-tasks` repository to the computer the candidate will work on. Create a child branch from chosen task branch and name it in according to the following template:
```
CandidateName_CandidateSurname_task_name      // you can ommit the estimated task time part
```
Let the candidate to work with this branch however he or she wants. Do not put any protection policies because we may want to see how he or she is create PRs, what is the commiting manner etc. 

After the task is done you can create PR to the task branch to have a summary of the solution and review the code. In case of any doubts you can let know the rest of recruitment team that they can take a look at the solution and provide their Code Reviews.

:warning: **Do not merge the PR!** We don't want to merge solution to the task branch

After the candidate enrollment process is finished please remember to remove the PR and branch (they will stay in the repository history anyway)

#### Sharing task remotely
This section must be discussed with out DevOps team to not breach any security policy and provide standard to follow. The idea is to just fork the task branch and provide forked repository to the candidate but we need to create a procedure how to do this.
