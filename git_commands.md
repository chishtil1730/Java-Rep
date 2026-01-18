# Connect to GitHub account
```
git config --global user.name "{github_username}"
git config --global user.email "{github_linked_email}"
```
# create an empty repo:
```
git init
```


# if a repo already exists, we fetch that branch from GitHub.

```
git fetch origin
```

## and then push normally

## To add
```
git add filename.type
```
# (to add all files)
```
git add .
```

# to commit
```
git commit -m"Commit message"
```
# if you want to add extra files to same commit or want to change the commit message:
```
git commit -m"new commit name" --amend
```

# Create a repo in GitHub.

## connect the repo to local
```
git remote add origin {url}
```

# change the name of the branch from master to main
```
git branch -M main
git push -u origin main
```
## or
```
git push -u origin main --force
```

# to view the log
```
git log
```
## (or)
```
git log --all
```
## (or)
```
git log --graph
```
## (or)
```
git log --oneline
```

# To checkout previous version:
```
git checkout {commit id}

```

# To get branches in the repo :
```
git branch -r
```
## to merge them we use :
```
git checkout main
git merge origin/master --allow-unrelated-histories
git commit -m"merging message"
git push -u origin main
```
## (delete the other branch in cloud)
```
git branch -d <branch-name>
git push origin --delete master
```
#  If you updated something in GitHub and not in local, 
- pull the changes to your local machine first.
- If there is a conflict, edit them manually and keep what you want.
```
git pull origin main
git add filename.type
git commit -m"commit message"
git push -u origin main
```