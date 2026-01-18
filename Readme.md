# Git Commands Reference Guide

## Initial Setup

### Connect to GitHub Account
```bash
git config --global user.name "{github_username}"
git config --global user.email "{github_linked_email}"
```

## Repository Management

### Create an Empty Repository
```bash
git init
```

## Add files to .gitignore to ignore them from version control
### To add files to .gitignore via commands
You can add single file or directory or multiple of them.
1. **To add multiple files**
   ```bash
      Add-Content .gitignore @"
       node_modules/
       .env
       dist/
      "@
   ```
2. **To add a single file or directory**
   ```bash
      #To add a file to .gitignore
      Add-Content .gitignore "filename.type"
   
      #To add a directory to .gitignore
      Add-Content .gitignore "folder_name/"
   ```

### Fetch from Existing Repository
If a repo already exists, fetch that branch from GitHub:
```bash
git fetch origin
# and then push normally
```

### Connect Local Repository to Remote
```bash
git remote add origin {url}
```

### Delete Repository (PowerShell)
```bash
# Delete .git folder (removes version control)
Remove-Item -Recurse -Force .git

#Short or alias form
rm -r -fo .git

# Delete entire project folder
Remove-Item -Recurse -Force <folder-name>

# Remove remote connection only
git remote remove origin
```

## Staging and Committing

### Add Files to Staging
```bash
# Add specific file
git add filename.type

# Add all files
git add .
```

### Commit Changes
```bash
# Standard commit
git commit -m "Commit message"

# Amend previous commit (add files or change message)
git commit -m "new commit name" --amend
```

## Branch Management

### Rename Branch from Master to Main
```bash
git branch -M main
```

### Push to Remote
```bash
# Standard push
git push -u origin main

# Force push (!!use with caution) Will Override previous files. 
git push -u origin main --force
```

### List Remote Branches
```bash
git branch -r
```

### Delete Branch
```bash
# Delete local branch
git branch -d <branch-name>

# Delete remote branch
git push origin --delete master
```

## Viewing History

### View Commit Log
```bash
# Basic log
git log

# All branches
git log --all

# Graphical representation
git log --graph

# Compact view
git log --oneline
```

## Merging and Syncing

### Checkout Previous Version
```bash
git checkout {commit id}
```

### Merge Branches
```bash
git checkout main
git merge origin/master --allow-unrelated-histories
git commit -m "merging message"
git push -u origin main
# Then delete the other branch in cloud if needed
```

### Pull and Resolve Conflicts
If you updated something in GitHub and not in local:
```bash
# Pull changes first
git pull origin main

# If there are conflicts, edit them manually and keep what you want
git add filename.type
git commit -m "commit message"
git push -u origin main
```

## Vim Editor Commands (for Merge Messages)

When Git opens Vim for merge commit messages:

```bash
# Save and exit with default message
:wq

# Or simply
:x

# Or press
ZZ  # (Shift + Z + Z)

# To add custom message:
# 1. Press 'i' for INSERT mode
# 2. Type your message
# 3. Press 'Esc'
# 4. Type ':wq' and press Enter

# Abort without saving
:q!
```

## Deleting or Removing
You can delete files locally, in cloud or both

1. **To remove in both locally & cloud**
   ```bash
     #Remove in both local & cloud
      git rm filename.type 
   
     #Remove only in cloud (keep in local)
      git rm --cached filename.type
   
     #Then add to .gitignore
      Add-Content .gitignore "filename.type"
   
    #Commit and push the changes
      git commit -m "commit message"
      git push -u origin main
   ```
2. **To remove a directory**
   ```bash
      #Remove in both local & cloud
      git rm -r folder_name/
   
     #Remove only in cloud (keep in local)
      git rm -r --cached folder_name/
     
     #Then add to .gitignore
      Add-Content .gitignore "filename.type/"
   
     #Commit and push the changes
      git commit -m "commit message"
      git push -u origin main
   ```
3. **If you deleted by mistake** 
   ```bash
      #To restore all
      git restore .
   
     #For a specific file
      git restore filename.type
   ```

## Common Workflow

1. **Start a new project:**
   ```bash
   git init
   git add .
   git commit -m "Initial commit"
   git remote add origin {url}
   git branch -M main
   git push -u origin main
   ```

2. **Daily workflow:**
   ```bash
   git pull origin main --allow-unrelated-histories
   # Make your changes
   git add .
   git commit -m "Description of changes"
   git push -u origin main
   ```

3. **Fix merge conflicts:**
   ```bash
   git pull origin main
   # Resolve conflicts in files
   git add .
   git commit -m "Resolved merge conflicts"
   git push -u origin main
   ```
