# Install and configure java JDK v11.0.11

[ROOT HELP](../HELP.md)

> **Documentation:** https://www.vivaolinux.com.br/dica/Instalacao-e-configuracao-do-Java-e-do-PATH

## Create and go to folder

```bash
sudo mkdir /opt/java && cd /opt/java
```

## In folder /opt/java, download version 11.0.11

```bash
sudo wget http://venzel.com.br/jdk-11.0.11_linux-x64_bin.tar.gz
```

## Untar file

```bash
sudo tar -xzvf jdk-11.0.11_linux-x64_bin.tar.gz
```

## Create sybolic link

```bash
sudo ln -s jdk-11.0.11 jdk
```

## Edit file /etc/profile

```bash
sudo nano /etc/profile
```

# Add lines bellow

export JAVA_HOME="/opt/java/jdk"
export CLASSPATH="$JAVA_HOME/lib":$CLASSPATH
export PATH="$JAVA_HOME/bin":$PATH
export MANPATH="$JAVA_HOME/man":$MANPATH

# Create symbolic links

sudo ln -s /opt/java/jdk/bin/java /usr/local/bin/
sudo ln -s /opt/java/jdk/bin/javac /usr/local/bin/

# All ready

java -version
javac -version
