// A função que será executada quando o botão for clicado
function adicionarCurso() {
    const nomeCurso = document.getElementById('nome').value;
    const materias = document.getElementById('materia').value;
    const cargaHoraria = document.getElementById('cargaHoraria').value;

    if (!nomeCurso || !materias || !cargaHoraria) {
        alert("Por favor, preencha todos os campos!");
        return;
    }

    const listaCursos = document.getElementById('listaCursos');
    const novoCursoItem = document.createElement('li');
    novoCursoItem.textContent = `Curso: ${nomeCurso} | Matérias: ${materias} | Carga Horária: ${cargaHoraria}h`;

    listaCursos.appendChild(novoCursoItem);

    // Limpa os campos do formulário
    document.getElementById('nome').value = '';
    document.getElementById('materia').value = '';
    document.getElementById('cargaHoraria').value = '';
}

// Adiciona um "listener" de evento ao botão depois que o HTML é carregado
// Isso é mais recomendado do que usar 'onclick' diretamente no HTML
document.addEventListener('DOMContentLoaded', () => {
    const botaoAdicionar = document.getElementById('addCursoBtn');
    if (botaoAdicionar) { // Verifica se o botão existe antes de adicionar o listener
        botaoAdicionar.addEventListener('click', adicionarCurso);
    }
});