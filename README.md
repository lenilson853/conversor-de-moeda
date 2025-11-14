# 🪙 Conversor de Moedas

Este é um projeto de conversor de moedas em Java que funciona no console. O programa liga-se a uma API de câmbio em tempo real para obter as taxas de conversão.

Projeto desenvolvido como parte do desafio da Alura.

---

## ✨ Funcionalidades

* Converte valores entre 6 pares de moedas:
    * Dólar (USD) <=> Peso Argentino (ARS)
    * Dólar (USD) <=> Real Brasileiro (BRL)
    * Dólar (USD) <=> Peso Colombiano (COP)
* Menu interativo no console para uma utilização fácil.
* Utiliza a [ExchangeRate-API](https://www.exchangerate-api.com/) para obter dados em tempo real.

---

## 🛠️ Tecnologias Utilizadas

* **Java** (JDK 11+)
* **Maven** (para gestão de dependências)
* **Gson** (para processar a resposta JSON da API)
* **Java HTTP Client** (para fazer as chamadas à API)

---

## 🚀 Como Executar o Projeto

1.  **Clonar o repositório:**
    ```bash
    git clone [https://github.com/TEU-USUARIO/converso-de-moeda.git](https://github.com/TEU-USUARIO/converso-de-moeda.git)
    ```

2.  **Obter Chave da API:**
    * É necessário ter uma chave de API da [ExchangeRate-API](https://www.exchangerate-api.com/).
    * Após criar a conta, copia a tua chave.

3.  **Configurar a Chave:**
    * Abre o projeto no IntelliJ (ou outra IDE).
    * Vai ao ficheiro `ApiConnector.java`.
    * Substitui `"SUA_API_KEY_AQUI"` pela tua chave pessoal na linha:
        ```java
        private static final String API_KEY = "SUA_API_KEY_AQUI";
        ```

4.  **Executar:**
    * O IntelliJ irá carregar as dependências do Maven (Gson) automaticamente.
    * Executa o método `main` no ficheiro `Main.java`.
