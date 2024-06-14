1- O projeto visa registrar doações de apoio a uma instituição fictícia de caridade voltada para crianças em situação de vulnerabilidade. Os usuários podem contribuir com dinheiro, roupas, insumos, brinquedos e remédios, ajustando a quantidade de cada item a ser doada. Eles têm controle total sobre suas doações e podem visualizar o total doado para a instituição. 

2- Os requisitos funcionais identificados pela IA foram:

Receber Doações: O sistema deve permitir que o usuário informe seu nome, selecione o tipo de doação (dinheiro, alimentos, roupas, etc.), insira a quantidade da doação e a data no formato DD/MM/AAAA. 

Registrar Doações: Após o usuário preencher os dados necessários, ele pode enviar a doação, que será registrada no sistema. 

Calcular Total de Doações: O sistema deve calcular e exibir o total doado pelo usuário para cada tipo de doação (dinheiro, alimentos, roupas, etc.) e o total geral de todas as doações. 

Armazenar Informações de Doações: Todas as doações devem ser armazenadas em um arquivo de log (doacoes.txt) para posterior consulta e análise. 

Exibir Estatísticas de Doações: O sistema deve apresentar estatísticas detalhadas, como a quantidade total doada por tipo de item. 

Interface Gráfica: Uma interface gráfica intuitiva deve ser desenvolvida para facilitar a interação do usuário, incluindo campos de entrada para dados e botões para enviar doações, calcular totais e exibir estatísticas. 

3-  Ao relatar o modelo do sistema proposto pelo professor, foi recomendado o uso do SQLite para armazenar as doações em um banco de dados, com foco na utilização do JDBC (Java Database Connectivity) para conexão e operações. Foram apresentadas principais funções para criar a estrutura da base de dados, registrar doações, calcular e exibir informações.
No entanto, as abordagens sugeridas pela IA não se alinharam completamente com o método de ensino do professor. A IA importou diversas classes e utilizou SQL, baseando-se em funcionalidades de banco de dados de outros programas além do Java, e incluiu a criação de tabelas diretamente no algoritmo, o que complicou o desenvolvimento conforme solicitado. Ao solicitar uma implementação sem SQL, a IA criou uma estrutura baseada em listas por IDs, com classes pré-definidas para seleção após a compilação do código. Embora funcional, não incluiu opções para escolha de tipos de doação ou quantidades, o que não atendeu às expectativas do professor.

4- Propriedades: 
totalDoacoes: Inteiro para o total geral de doações.
Contadores específicos para tipos de doação: dinheiroDoacao, insumosDoacao, roupasDoacao, brinquedosDoacao, remediosDoacao
nomeArquivo: Nome do arquivo para armazenar doações. 
nomeUsuario: Nome do doador atual.
Métodos: 
visual(): Inicializa a interface gráfica do sistema.
adicionarDoacao(int quantidade, String tipo): Registra uma nova doação e atualiza os contadores.
salvarDoacoes(String tipo, String data, int quantidade): Armazena as doações em um arquivo de texto. 
carregarDoacoes(): Carrega doações previamente registradas do arquivo.

5- Ao perceber que a IA sugeriu abordagens além do que foi proposto pelo professor, decidi pesquisar mais a fundo para encontrar uma solução alinhada com as diretrizes do trabalho. Optei por desenvolver uma GUI usando JFrame, uma ferramenta que me permitiu abordar todos os requisitos solicitados de forma visualmente compreensível. Com a ajuda de recursos como a IA, fóruns e vídeos, consegui aprender os comandos necessários para implementar minha ideia no projeto de maneira eficaz.
