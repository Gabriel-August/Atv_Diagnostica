// Função para adicionar um novo aluno
function cadastrobtn() {
    // 1. Obter os valores dos campos
    const nomeAluno = document.getElementById('cadastroA').value;
    const emailAluno = document.getElementById('email').value;
    const cpfAluno = document.getElementById('cpfAluno').value;

    // 2. Validação simples
    if (!nomeAluno || !emailAluno || !cpfAluno) {
        alert("Por favor, preencha todos os campos do aluno!");
        return; // Interrompe a função se algum campo estiver vazio
    }

    // Você pode adicionar validações mais complexas aqui, como:
    // - Verificar formato de e-mail (usando regex, por exemplo)
    // - Validar CPF (há algoritmos específicos para isso)

    // 3. Adicionar o novo aluno à lista na página
    const listaAlunos = document.getElementById('listaAlunos');
    const novoAlunoItem = document.createElement('li'); // Cria um novo item de lista (<li>)

    // Define o conteúdo do item de lista
    novoAlunoItem.textContent = `Nome: ${nomeAluno} | Email: ${emailAluno} | CPF: ${cpfAluno}`;

    // Adiciona o novo item à lista de alunos
    listaAlunos.appendChild(novoAlunoItem);

    // 4. Limpar os campos do formulário após o cadastro
    document.getElementById('cadastroA').value = '';
    document.getElementById('email').value = '';
    document.getElementById('cpfAluno').value = '';
}

// 5. Adicionar um "listener" de evento ao botão depois que o HTML é carregado
// Isso é crucial para garantir que o elemento HTML já exista antes de tentarmos acessá-lo.
document.addEventListener('DOMContentLoaded', () => {
    const botaoCadastrar = document.getElementById('cadastrarAlunoBtn');

    // Verifica se o botão foi encontrado antes de adicionar o evento
    if (botaoCadastrar) {
        botaoCadastrar.addEventListener('click', cadastrobtn);
    } else {
        console.error("Botão 'cadastrarAlunoBtn' não encontrado no DOM.");
    }
});