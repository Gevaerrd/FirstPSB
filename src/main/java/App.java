
// import jakarta.persistence.EntityManager;
// import jakarta.persistence.EntityManagerFactory;
// import jakarta.persistence.Persistence;

// code . -> abre o vscode na pasta

// # git clone SSH -> Clona o github
// # git log -> Vê todos os commmits, eles são salvos por códigos
// # git checkout SSHDOCOMMIT -> Leva o vscode aquela tal versão, git checkout
// main volta pro principal

// git config --global user.name "usuario" # Configura o nome de usuário
// globalmente para o Git
// git config --global user.email "email" # Configura o e-mail globalmente para
// o Git

// git init # Inicializa o repositório Git na pasta atual

// git add . # Adiciona todos os arquivos na pasta ao Git (prepara os arquivos
// para commit) | Se quiser um especifico troca o .

// git commit -m "Alteração" # Cria um commit com a mensagem explicando as
// alterações feitas | PRIMEIRA VEZ |

// git branch -M main # Renomeia a branch atual para "main" (ou o nome
// especificado) | PRIMEIRA VEZ |

// git remote add origin git@github.com:Gevaerrd/aulagithub.git # Associa o
// repositório local ao GitHub (usando SSH) | PRIMEIRA VEZ |

// git push -u origin main # Envia as alterações para o repositório remoto no
// GitHub (na branch "main") | PRIMEIRA VEZ |

// git push

// Entidades representam o modelo de dados
// Repository fazem as entidades conversarem com o banco de dados
// Resourcers lidam com requisições usando as entidades e Repository
// Services fazem o filtro dos repository antes de chamar se for necessarios e
// chama o repository
// para atender os resourcers