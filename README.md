# MeuEsporte
Exercício de criação de aplicativo java.

**Atividade 1: Futebol**
Você deve criar, na ferramenta Netbeans, um projeto chamado MeuEsporte, construindo as seguintes classes, conforme os exemplos que seguem.

**Jogador.java**
```java
// atributos
int codigo;
String nome;
String posicao; 

// metodos setter e getters
```

**Time.java**
```java
// atributos
int codigo;
String nome;
String tecnico;
Jogador jogadores []; 

// metodos setter e getters
```
Na classe principal do projeto, dentro do método main, é preciso desenvolver um menu de interação para permitir a criação de times, o cadastro de jogadores e a vinculação de jogadores aos times. Você também deve utilizar a classe Entrada.java para montar o menu.

O menu de opções do projeto será algo parecido com o seguinte:
 - [1] - Cadastrar jogador;
 - [2] - Cadastrar time;
 - [3] - Listar jogadores cadastrados;
 - [4] - Listar times cadastrados - sem os jogadores;
 - [5] - Vincular jogador a um time;
 - [6] - Listar dados completos de um time;
 - [7] - Sair.
