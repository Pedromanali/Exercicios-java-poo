package model;

public class Livro {
    private String titulo;
    private boolean disponivel;

    public Livro(String titulo, boolean disponivel) {
        this.titulo = titulo;
        this.disponivel = disponivel;
    }

    public String getTitulo() { return titulo; }
    public boolean isDisponivel() { return disponivel; }
    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }
}
package service;

import model.Livro;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaService {
    private List<Livro> catalogo = new ArrayList<>();
    private int emprestimosAtuais = 0;
    private final int LIMITE_MAXIMO = 3;

    public void adicionarLivro(Livro livro) {
        catalogo.add(livro);
    }

    public List<Livro> getCatalogo() {
        return catalogo;
    }

    public void emprestar(String tituloBusca) throws Exception {
        if (emprestimosAtuais >= LIMITE_MAXIMO) {
            throw new IllegalStateException("Limite máximo de 3 empréstimos atingido!");
        }

        Livro livroEncontrado = null;
        for (Livro l : catalogo) {
            if (l.getTitulo().equalsIgnoreCase(tituloBusca)) {
                livroEncontrado = l;
                break;
            }
        }

        if (livroEncontrado == null) {
            throw new IllegalArgumentException("O livro '" + tituloBusca + "' não existe no acervo.");
        }

        if (!livroEncontrado.isDisponivel()) {
            throw new IllegalStateException("O livro '" + livroEncontrado.getTitulo() + "' já está emprestado.");
        }

        livroEncontrado.setDisponivel(false);
        emprestimosAtuais++;
    }
}