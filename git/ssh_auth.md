
#  GitHub SSH Authentication Guide

This guide walks you through setting up SSH login for GitHub — no more typing your username and password every time you push!

---

##  1. Generate an SSH Key

If you don't already have an SSH key, generate one:

```bash
ssh-keygen -t ed25519 -C "your-email@example.com"
```

- Press **Enter** to accept the default location: `~/.ssh/id_ed25519`
- Set a passphrase (or just press Enter to skip)

---

##  2. Start the SSH Agent and Add Your Key

Start the `ssh-agent`:

```bash
eval "$(ssh-agent -s)"
```

Add your SSH key to the agent:

```bash
ssh-add ~/.ssh/id_ed25519
```

_If you named your key something else, replace with the correct file, e.g.:_

```bash
ssh-add ~/.ssh/githubssh
```

---

##  3. Add the SSH Key to Your GitHub Account

Display your public key:

```bash
cat ~/.ssh/id_ed25519.pub
```

Copy the entire output, then:

1. Go to [https://github.com/settings/keys](https://github.com/settings/keys)
2. Click **"New SSH key"**
3. Paste the public key
4. Give it a name like `"My Laptop SSH Key"`
5. Click **Add SSH key**

---

##  4. Configure Git to Use SSH

Update your Git remote to use the SSH format:

```bash
git remote set-url origin git@github.com:your-username/your-repo.git
```

Check it:

```bash
git remote -v
```

Should output:

```
origin  git@github.com:your-username/your-repo.git (fetch)
origin  git@github.com:your-username/your-repo.git (push)
```

---

##  5. Test Your SSH Authentication

Run this command:

```bash
ssh -T git@github.com
```

Expected output (after typing `yes` if prompted):

```
Hi your-username! You've successfully authenticated, but GitHub does not provide shell access.
```

 Success

---

##  Optional: Set Permissions Properly

If you get a permissions error when adding your key:

```bash
chmod 600 ~/.ssh/id_ed25519
chmod 700 ~/.ssh
```

---

##  Now You Can Use Git Normally

Examples:

```bash
git add .
git commit -m "Add SSH support"
git push origin main
```

SSH will handle authentication behind the scenes.

---
