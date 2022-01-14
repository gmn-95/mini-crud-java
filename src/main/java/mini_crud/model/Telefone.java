package mini_crud.model;

/**
 *
 * @author gustavo
 */
public class Telefone {
    private Long id;
    private String numero;
    private String descricao;
    private Long id_usuario;

    public Telefone(String numero, String descricao, Long id_usuario) {
            this.numero = numero;
            this.descricao = descricao;
            this.id_usuario = id_usuario;
    }
    
    public Telefone(String numero, String descricao) {
            this.numero = numero;
            this.descricao = descricao;
    }
    

    public Telefone() {
    }

    public Long getId() {
            return id;
    }

    public void setId(Long id) {
            this.id = id;
    }

    public String getNumero() {
            return numero;
    }

    public void setNumero(String numero) {
            this.numero = numero;
    }

    public String getDescricao() {
            return descricao;
    }

    public void setDescricao(String descricao) {
            this.descricao = descricao;
    }

    public Long getId_usuario() {
            return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
            this.id_usuario = id_usuario;
    }
}
