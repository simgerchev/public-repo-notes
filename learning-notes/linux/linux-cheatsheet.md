# 🐧 Linux Command Cheat Sheet

## 📁 File and Directory Management

| Command               | Description                     |
|-----------------------|---------------------------------|
| `ls`                  | List directory contents         |
| `ls -l`               | Long listing format             |
| `ls -a`               | Show hidden files               |
| `cd [dir]`            | Change directory                |
| `pwd`                 | Print working directory         |
| `mkdir [dir]`         | Create new directory            |
| `rmdir [dir]`         | Remove empty directory          |
| `rm -r [dir]`         | Remove directory and contents   |
| `cp [src] [dest]`     | Copy file or directory          |
| `mv [src] [dest]`     | Move or rename file/directory   |
| `rm [file]`           | Delete file                     |
| `touch [file]`        | Create empty file               |
| `cat [file]`          | View file contents              |
| `less [file]` / `more [file]` | View large files page-by-page |

---

## 🔍 Search and Find

| Command                              | Description                |
|--------------------------------------|----------------------------|
| `find [dir] -name "[pattern]"`       | Search for files           |
| `grep "[pattern]" [file]`            | Search inside files        |
| `grep -r "[pattern]" [dir]`          | Recursive search           |
| `locate [file]`                      | Find files by name         |

---

## 🔐 File Permissions and Ownership

| Command                      | Description                  |
|------------------------------|------------------------------|
| `chmod [mode] [file]`        | Change file permissions      |
| `chown [user]:[group] [file]`| Change ownership             |
| `ls -l`                      | View permissions             |
| `chmod +x [file]`            | Make a file executable       |

---

## 🧠 Process Management

| Command          | Description                   |
|------------------|-------------------------------|
| `ps`             | Show current processes        |
| `ps aux`         | Detailed process list         |
| `top` / `htop`   | Real-time process monitor     |
| `kill [PID]`     | Kill process by ID            |
| `killall [name]` | Kill by name                  |
| `nice` / `renice`| Set process priority          |

---

## 🌐 Networking

| Command                          | Description                     |
|----------------------------------|---------------------------------|
| `ping [host]`                    | Test connectivity               |
| `ifconfig` or `ip a`             | Show network interfaces         |
| `netstat -tuln`                  | List open ports                 |
| `ss -tuln`                       | Modern netstat replacement      |
| `scp [file] user@host:/path`     | Secure copy over SSH            |
| `wget [url]`                     | Download file from web          |
| `curl [url]`                     | Transfer data from/to URL       |

---

## 📦 Package Management

### Debian/Ubuntu (`apt`)

| Command                     | Description               |
|-----------------------------|---------------------------|
| `sudo apt update`           | Update package list       |
| `sudo apt upgrade`          | Upgrade packages          |
| `sudo apt install [pkg]`    | Install package           |
| `sudo apt remove [pkg]`     | Remove package            |

### Red Hat/CentOS (`yum`, `dnf`)

| Command                     | Description               |
|-----------------------------|---------------------------|
| `sudo yum install [pkg]`    | Install package           |
| `sudo dnf upgrade`          | Upgrade packages          |

---

## 💾 Disk Usage

| Command           | Description                         |
|-------------------|-------------------------------------|
| `df -h`           | Show disk usage (human-readable)    |
| `du -sh [dir]`    | Show size of directory              |
| `lsblk`           | Show block devices                  |
| `mount` / `umount`| Mount/unmount drives                |

---

## 👤 User Management

| Command                            | Description                  |
|------------------------------------|------------------------------|
| `adduser [name]`                   | Add user                     |
| `passwd [name]`                    | Change password              |
| `deluser [name]`                   | Remove user                  |
| `usermod -aG [group] [user]`       | Add user to group            |

---

## ⚙️ System Information

| Command          | Description                   |
|------------------|-------------------------------|
| `uname -a`       | Kernel info                   |
| `uptime`         | System uptime                 |
| `whoami`         | Current user                  |
| `id`             | User ID and groups            |
| `free -h`        | RAM usage                     |
| `hostname`       | System hostname               |

