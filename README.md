# integration-Oracle

## How to Upload Code Files (Including Folders) from Your Local Machine

Follow these steps to upload your local code files and folders to this GitHub repository.

---

### Prerequisites

- [Git](https://git-scm.com/downloads) installed on your local machine
- A [GitHub account](https://github.com/) with access to this repository

---

### Option 1: Using Git Command Line (Recommended)

#### Step 1 — Clone the repository to your local machine

```bash
git clone https://github.com/MUSTAQ-AHAMMAD/integration-Oracle.git
cd integration-Oracle
```

#### Step 2 — Copy your files and folders

Copy or move your local code files and folders into the cloned `integration-Oracle` directory.

#### Step 3 — Stage all files for commit

```bash
git add .
```

This stages all new files and folders recursively.

#### Step 4 — Commit the changes

```bash
git commit -m "Add project files"
```

#### Step 5 — Push to GitHub

```bash
git push origin main
```

> **Note:** Replace `main` with your target branch name if it is different (e.g., `master`).

---

### Option 2: Uploading via the GitHub Web Interface

1. Open this repository on GitHub: [https://github.com/MUSTAQ-AHAMMAD/integration-Oracle](https://github.com/MUSTAQ-AHAMMAD/integration-Oracle)
2. Click the **"Add file"** button and select **"Upload files"**.
3. Drag and drop your files/folders into the upload area, or click **"choose your files"** to browse.
4. Scroll down, add a commit message, and click **"Commit changes"**.

> **Note:** The GitHub web UI has a file size limit of **25 MB per file** and works best for smaller uploads. For larger projects or entire folder structures, the Git command line approach (Option 1) is strongly recommended.

---

### Option 3: Initialize a New Local Repository and Push

If you have not cloned this repository and want to push an existing local project:

```bash
cd /path/to/your/local/project

# Initialize git (if not already a git repo)
git init

# Add the remote repository
git remote add origin https://github.com/MUSTAQ-AHAMMAD/integration-Oracle.git

# Stage all files
git add .

# Commit
git commit -m "Initial commit"

# Push to GitHub
git push -u origin main
```

---

### Helpful Tips

- Use `git status` at any time to see which files are staged or unstaged.
- Use `git log --oneline` to review your commit history.
- If you get a rejection on push because the remote has changes you don't have locally, run `git pull --rebase origin main` first, then push again.
