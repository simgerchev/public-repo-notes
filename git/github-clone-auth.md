
# Cloning a Private GitHub Repository

When cloning a private repository from GitHub over HTTPS, you may be prompted for a username and password. GitHub no longer allows using your account password for this purpose. Here are two ways to authenticate:

---

## ✅ Option 1: Use a Personal Access Token (PAT)

1. Go to [GitHub Settings → Developer settings → Personal access tokens](https://github.com/settings/tokens).
2. Click **"Generate new token (classic)"**.
3. Select scopes (at least **repo** if you want full repository access).
4. Copy the token (you’ll only see it once!).

Then run:

```bash
git clone https://<YOUR_USERNAME>:<YOUR_TOKEN>@github.com/pelasg0/private-notes.git
```

> ⚠️ Do **not** share or commit this URL/token. It's as powerful as a password.

---

## ✅ Option 2: Use SSH Instead of HTTPS (Recommended)

1. Generate an SSH key (if you don’t have one already):

```bash
ssh-keygen -t ed25519 -C "your_email@example.com"
```

2. Add your SSH public key to GitHub:
   - Go to [GitHub → Settings → SSH and GPG keys](https://github.com/settings/keys)
   - Click **New SSH key**, and paste the contents of `~/.ssh/id_ed25519.pub`

3. Then clone the repository via SSH:

```bash
git clone git@github.com:pelasg0/private-notes.git
```

---

## Need Help?

If you're unsure which option to use, SSH is usually better for long-term use. Let me know if you'd like help setting it up.
