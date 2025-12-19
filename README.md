# 🐍 Classic Snake Game (Java)

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Status](https://img.shields.io/badge/Status-Completed-success?style=for-the-badge)

Um clone robusto do clássico jogo da cobrinha (Snake), desenvolvido em **Java Puro** (sem engines externas), focado em lógica de matrizes, manipulação de threads (Game Loop) e renderização gráfica com AWT/Swing.

## ✨ Funcionalidades

* **Movimentação em Grade (Grid-based):** A cobra se move respeitando blocos de 20x20 pixels, garantindo alinhamento perfeito.
* **Input Buffer:** Sistema de fila de comandos para corrigir o bug clássico de "suicídio" quando o jogador aperta duas teclas muito rápido.
* **Colisão Precisa:** Detecção de colisão com as bordas da tela e com o próprio corpo.
* **Spawn Inteligente:** A maçã nunca nasce em cima do corpo da cobra.
* **Game Loop:** Controle de FPS manual para ajustar a velocidade do jogo.
* **Restart Rápido:** Tela de Game Over com opção de reinício imediato.

## 🛠️ Tecnologias Utilizadas

* **Java (JDK 8+)**
* **Java Swing (JPanel, JFrame):** Para gerenciamento da janela.
* **Java AWT (Graphics, Rectangle):** Para renderização e lógica de colisão.
* **Estruturas de Dados:** Uso de `ArrayList` para gerenciar os nós do corpo da cobra e o buffer de teclado.

## 🚀 Como Jogar

### Opção 1: Baixando o Executável (Fácil)
1. Vá até a aba [Releases](https://github.com/r1cardo360/GameSnake/releases/tag/Version1.0) deste repositório.
2. Baixe o arquivo `SnakeGame.jar`.
3. Dê dois cliques para abrir (ou execute via terminal).

### Opção 2: Rodando o Código Fonte (Devs)
Certifique-se de ter o **Java Development Kit (JDK)** instalado.

# Clone este repositório
git clone [https://github.com/SEU_USUARIO/NOME_DO_REPO.git](https://github.com/r1cardo360/GameSnake.git)

# Compile e rode (exemplo via terminal, ou abra na sua IDE favorita)
javac -d bin src/*.java
java -cp bin Main
