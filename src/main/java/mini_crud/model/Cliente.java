package mini_crud.model;

/**
 *
 * @author gustavo
 */
public class Cliente extends Pessoa{
    
    private Long id;

    public Cliente(String nome, int idade, String cpf, String email) {
            super(nome, idade, cpf, email);
    }

    public Long getId() {
            return id;
    }

    public void setId(Long id) {
            this.id = id;
    }
    
}
