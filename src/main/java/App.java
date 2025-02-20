
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

// code . -> abre o vscode na pasta

// # git clone SSH  -> Clona o github
// # git log -> Vê todos os commmits, eles são salvos por códigos
// # git checkout SSHDOCOMMIT -> Leva o vscode aquela tal versão, git checkout main volta pro principal

// git config --global user.name "usuario"  # Configura o nome de usuário globalmente para o Git
// git config --global user.email "email"  # Configura o e-mail globalmente para o Git

// git init  # Inicializa o repositório Git na pasta atual

// git add .  # Adiciona todos os arquivos na pasta ao Git (prepara os arquivos para commit) | Se quiser um especifico troca o .

// git commit -m "Alteração"  # Cria um commit com a mensagem explicando as alterações feitas | PRIMEIRA VEZ |

// git branch -M main  # Renomeia a branch atual para "main" (ou o nome especificado) | PRIMEIRA VEZ |

// git remote add origin git@github.com:Gevaerrd/aulagithub.git  # Associa o repositório local ao GitHub (usando SSH) | PRIMEIRA VEZ | 

// git push -u origin main  # Envia as alterações para o repositório remoto no GitHub (na branch "main") | PRIMEIRA VEZ |

// git push

public class App {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("example-jpa");
        EntityManager em = emf.createEntityManager();

        em.close();
        emf.close();
    }

}
