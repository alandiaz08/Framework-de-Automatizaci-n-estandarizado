# Framework de Automatización estandarizado

## Description

Framework de Automatización estandarizado es una demostración de e2e (extremo a extremo). Fue desarrollado utilizando Java, Maven y Selenium.

## Inicio Rapido

Asumiendo que Google Chrome y Git están instalados:

```bash
# Para Mac
# instalar java 11 (saltar si ya está instalado)
brew tap AdoptOpenJDK/openjdk
brew cask install adoptopenjdk11

# instalar chromedriver (saltar si ya está instalado)
brew cask install chromedriver

# clonar el proyecto y lanzar las pruebas
git clone https://github.com/alandiaz08/Framework-de-Automatizaci-n-estandarizado.git
cd e2e-web-framework

# Para Windows
# instalar java 11
choco install adoptopenjdk11

# instalar chromedriver (saltar si ya está instalado)
choco install chromedriver

# clonar el proyecto y lanzar las pruebas
git clone https://github.com/alandiaz08/Framework-de-Automatizaci-n-estandarizado.git
cd Framework-de-Automatización-estandarizado
```

Esto ejecutará todas las pruebas utilizando tu navegador Chrome local.


## Instalación para Desarrolladores

Para instalar las dependencias usamos brew para Mac. Puedes instalarlo desde aquí: <https://brew.sh/>

Para instalar las dependencias usamos chocolatey para Windows. Puedes instalarlo desde aquí: <https://chocolatey.org/>

### 1. Instalar git

```bash
# Para Mac
brew install git

# Para Windows
choco install git
```

### 2. Instalar Java 11 SDK

```bash
# Para Mac
brew tap AdoptOpenJDK/openjdk
brew cask install adoptopenjdk11

# Para Windows
choco install AdoptOpenJDK/openjdk
choco install adoptopenjdk11
```

Comprueba que Java 11 esté correctamente instalado con

```bash
java -version
```

Si se instaló correctamente deberías ver algo como

 ```bash
openjdk version "11.0.6" 2020-01-14
OpenJDK Runtime Environment AdoptOpenJDK (build 11.0.6+10)
OpenJDK 64-Bit Server VM AdoptOpenJDK (build 11.0.6+10, mixed mode)
```

### 3. Install Maven

```bash
# Para Mac
brew install maven

# Para Windows
choco install maven
```

### 4. Instalar IntelliJ IDEA CE

IntelliJ IDEA CE se puede instalar desde el sitio web de jetbrains: <https://www.jetbrains.com/idea/download/#section=mac>  
También se puede instalar usando brew:

```bash
# Para Mac
brew cask install intellij-idea-ce

# Para Windows
choco install intellij-idea-ce
```

### 5. Instalar chromedriver

```bash
# Para Mac
brew cask install chromedriver

# Para Windows
choco install chromedriver
```
