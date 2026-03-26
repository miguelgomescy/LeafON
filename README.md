# LeafON KMP

Projeto Kotlin Multiplatform com Compose Multiplatform, organizado para compartilhar a maior parte da UI e da logica entre Android, Desktop (JVM) e Web.

## Estrutura atual do projeto

```text
LeafON-KMP/
|-- composeApp/
|   |-- build.gradle.kts
|   `-- src/
|       |-- commonMain/
|       |   |-- composeResources/
|       |   `-- kotlin/kmp/edu/leafon_kmp/
|       |       |-- App.kt
|       |       |-- Platform.kt
|       |       `-- presentation/
|       |           |-- navigation/
|       |           |-- home/
|       |           |-- login/
|       |           |-- register/
|       |           `-- profile/
|       |-- commonTest/
|       |   `-- kotlin/
|       |-- androidMain/
|       |   |-- kotlin/kmp/edu/leafon_kmp/
|       |   |   |-- MainActivity.kt
|       |   |   `-- Platform.android.kt
|       |   `-- res/
|       |-- jvmMain/
|       |   `-- kotlin/kmp/edu/leafon_kmp/
|       |       |-- main.kt
|       |       `-- Platform.jvm.kt
|       |-- jsMain/
|       |   `-- kotlin/kmp/edu/leafon_kmp/
|       |       `-- Platform.js.kt
|       |-- wasmJsMain/
|       |   `-- kotlin/kmp/edu/leafon_kmp/
|       |       `-- Platform.wasmJs.kt
|       `-- webMain/
|           |-- kotlin/kmp/edu/leafon_kmp/
|           |   `-- main.kt
|           `-- resources/
|               |-- index.html
|               `-- styles.css
|-- gradle/
|   |-- libs.versions.toml
|   `-- wrapper/
|-- build.gradle.kts
|-- settings.gradle.kts
|-- gradle.properties
|-- gradlew
`-- gradlew.bat
```

### Resumo das pastas principais

- `composeApp/`: modulo principal da aplicacao e onde estao os targets multiplataforma.
- `composeApp/src/commonMain/`: codigo compartilhado entre Android, Desktop e Web.
- `composeApp/src/androidMain/`: implementacoes especificas do Android.
- `composeApp/src/jvmMain/`: entrada e codigo especifico da versao Desktop.
- `composeApp/src/jsMain/`: adaptacoes do target JavaScript.
- `composeApp/src/wasmJsMain/`: adaptacoes do target WebAssembly.
- `composeApp/src/webMain/`: ponto de entrada web e recursos estaticos.
- `gradle/`: configuracoes do Gradle Wrapper e catalogo de dependencias.

## Requisitos

Antes de executar o projeto, tenha no ambiente:

- JDK 11 ou superior.
- Android Studio para rodar a versao Android.
- SDK do Android configurado localmente.
- Um navegador moderno para a versao Web.

## Como rodar o projeto

Os comandos abaixo usam o Gradle Wrapper do repositorio.

### Android

Para gerar o build de desenvolvimento:

- Windows

```powershell
.\gradlew.bat :composeApp:assembleDebug
```

- macOS/Linux

```bash
./gradlew :composeApp:assembleDebug
```

Para executar no dispositivo ou emulador, a forma mais pratica e abrir o projeto no Android Studio e rodar a configuracao do modulo Android.

### Desktop (JVM)

Executa a aplicacao desktop localmente:

- Windows

```powershell
.\gradlew.bat :composeApp:run
```

- macOS/Linux

```bash
./gradlew :composeApp:run
```

Se precisar gerar instaladores nativos, o modulo tambem esta configurado para distribuir `Dmg`, `Msi` e `Deb`.

### Web

O projeto possui dois targets web:

- `wasmJs`: versao WebAssembly, preferencial para navegadores modernos.
- `js`: versao JavaScript, util para compatibilidade adicional.

#### Web com Wasm

- Windows

```powershell
.\gradlew.bat :composeApp:wasmJsBrowserDevelopmentRun
```

- macOS/Linux

```bash
./gradlew :composeApp:wasmJsBrowserDevelopmentRun
```

#### Web com JavaScript

- Windows

```powershell
.\gradlew.bat :composeApp:jsBrowserDevelopmentRun
```

- macOS/Linux

```bash
./gradlew :composeApp:jsBrowserDevelopmentRun
```

## Observacoes

- A entrada da versao Android fica em `composeApp/src/androidMain/kotlin/kmp/edu/leafon_kmp/MainActivity.kt`.
- A entrada da versao Desktop fica em `composeApp/src/jvmMain/kotlin/kmp/edu/leafon_kmp/main.kt`.
- A entrada da versao Web fica em `composeApp/src/webMain/kotlin/kmp/edu/leafon_kmp/main.kt`.
- Os estilos e recursos HTML/CSS da Web ficam em `composeApp/src/webMain/resources/`.

## Observacao sobre validacao

Os comandos foram documentados com base na configuracao atual do Gradle do projeto. Neste ambiente eu nao consegui executar o wrapper ate o fim porque o download da distribuicao do Gradle depende de rede, que esta bloqueada no sandbox.
