// Função para adicionar um novo professor
function btnProfessor() {
    // Obter os valores dos campos
    const nomeProf = document.getElementById('nomeProf').value;
    const emailProf = document.getElementById('emailProf').value;
    const cpfProf = document.getElementById('cpfProf').value;
    const especialidadeProf = document.getElementById('especialidadeProf').value;

    // Validação simples
    if (!nomeProf || !emailProf || !cpfProf || !especialidadeProf) {
        alert("Por favor, preencha todos os campos do professor!");
        return; // Interrompe a função se algum campo estiver vazio
    }

    // Você pode adicionar validações mais específicas aqui, como:
    // - Verificar formato de e-mail (regex)
    // - Verificar se o CPF tem exatamente 11 dígitos e é numérico

    // Adicionar o novo professor à lista na página
    const listaProfessores = document.getElementById('listaProfessores');
    const novoProfessorItem = document.createElement('li'); // Cria um novo item de lista (<li>)

    // Define o conteúdo do item de lista
    novoProfessorItem.textContent = `Nome: ${nomeProf} | Email: ${emailProf} | CPF: ${cpfProf} | Área: ${especialidadeProf}`;

    // Adiciona o novo item à lista de professores
    listaProfessores.appendChild(novoProfessorItem);

    // Limpar os campos do formulário após o cadastro
    document.getElementById('nomeProf').value = '';
    document.getElementById('emailProf').value = '';
    document.getElementById('cpfProf').value = '';
    document.getElementById('especialidadeProf').value = '';
}

// Adicionar um "listener" de evento ao botão depois que o HTML é carregado
document.addEventListener('DOMContentLoaded', () => {
    const botaoFinalizar = document.getElementById('finalizarCadastroProfBtn');

    if (botaoFinalizar) {
        botaoFinalizar.addEventListener('click', btnProfessor);
    } else {
        console.error("Botão 'finalizarCadastroProfBtn' não encontrado no DOM.");
    }
});