// ANTES: lista
// private List<ItemAcervo> acervo = new ArrayList<>();
//
// private ItemAcervo buscarPorCodigo(String codigo) {
//     for (ItemAcervo item : acervo) {
//         if (item.getCodigo().equals(codigo)) {
//             return item;
//         }
//     }
//     return null;
// }

// DEPOIS: Map no lugar da lista
private Map<String, ItemAcervo> acervo = new HashMap<>();

public void adicionarItem(ItemAcervo item) {
    acervo.put(item.getCodigo(), item);
}

private ItemAcervo buscarPorCodigo(String codigo) {
    return acervo.get(codigo);
}

// Busca por título parcial
public List<ItemAcervo> buscarPorTitulo(String texto) {
    List<ItemAcervo> achados = new ArrayList<>();
    for (ItemAcervo item : acervo.values()) {
        if (item.getTitulo().toLowerCase().contains(texto.toLowerCase())) {
            achados.add(item);
        }
    }
    return achados;
}

// Relatório de itens em atraso
public List<Emprestimo> relatorioAtrasados() {
    List<Emprestimo> atrasados = new ArrayList<>();
    for (Emprestimo e : emprestimos) {
        boolean naoDevolvido = e.getDataDevolucao() == null;
        if (naoDevolvido && LocalDate.now().isAfter(e.getDataPrevista())) {
            atrasados.add(e);
        }
    }
    return atrasados;
}