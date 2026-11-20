# Projeto: Sistema de Gestão de Academia (FitControl)

## a) Lista de Classes, Atributos e Métodos

1. **Interface `Autenticavel`**
   * Métodos: `boolean autenticar(String senha)`

2. **Classe Abstrata `Pessoa`**
   * Atributos: `String nome`, `String cpf`, `String email`
   * Métodos: `String getNome()`, `void atualizarPerfil()`

3. **Classe `Aluno` (Herda de `Pessoa`, Implementa `Autenticavel`)**
   * Atributos: `String matricula`, `Plano plano`
   * Métodos: `boolean verificarMatricula()`, `boolean autenticar(String senha)`

4. **Classe `Plano` (Composição com Aluno)**
   * Atributos: `String nomePlano`, `double valorMensal`, `int duracaoMeses`
   * Métodos: `double calcularDesconto()`, `void exibirDetalhes()`

5. **Classe `Catraca`**
   * Atributos: `boolean liberada`
   * Métodos: `boolean liberarAcesso(Aluno aluno)`

---

## b) Diagrama Mermaid

```mermaid
classDiagram
    class Autenticavel {
        <<interface>>
        +boolean autenticar(String senha)
    }

    class Pessoa {
        <<abstract>>
        #String nome
        #String cpf
        +String getNome()
    }

    class Aluno {
        -String matricula
        +boolean autenticar(String senha)
        +boolean verificarMatricula()
    }

    class Plano {
        -String nomePlano
        -double valorMensal
        +double calcularDesconto()
    }

    class Catraca {
        +boolean liberarAcesso(Aluno aluno)
    }

    Pessoa <|-- Aluno : Herda
    Autenticavel <|.. Aluno : Implementa
    Aluno "1" o-- "1" Plano : Possui (Composição)
    Catraca ..> Aluno : Usa

    /**
 * Verifica se a senha informada confere com o cadastro do usuário.
 * 
 * @param senha A senha em texto plano digitada pelo usuário no terminal ou interface.
 * @return true se a autenticação for bem-sucedida, false caso contrário.
 */
boolean autenticar(String senha);

/**
 * Valida se o aluno possui plano ativo e libera a entrada na catraca da academia.
 * 
 * @OParam aluno O objeto Aluno que está tentando passar pela catraca.
 * @return true se o acesso for autorizado, lançando exceção ou retornando false se negado.
 * @throws IllegalArgumentException se o aluno for nulo.
 */
boolean liberarAcesso(Aluno aluno);

/**
 * Calcula o valor proporcional ou com descontos promocionais da mensalidade do plano.
 * 
 * @return O valor final double com o desconto aplicado.
 */
double calcularDesconto();