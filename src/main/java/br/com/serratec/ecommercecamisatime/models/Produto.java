package br.com.serratec.ecommercecamisatime.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Size(max = 60)
    @Column(name = "nome")
    private String nome;
    @NotNull
    @Size(max = 80)
    @Column(name = "descricao")
    private String descricao;
    @NotNull
    @Size(max = 80)
    @Column(name = "tamanho")
    private String tamanho;
    @NotNull
    @Size(max = 80)
    @Column(name = "genero")
    private String genero;
    @NotNull
    @Column(name = "quantidade")
    private Integer quantidade;
    @NotNull
    @Column(name = "dataCadastro")
    private LocalDateTime dataCadastro;
    @NotNull
    @Column(name = "valor")
    private Double valor;
    /*
    @NotNull
    @Column(name = "imagem")
    private Double imagem;
    */

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
    
    public Produto() {
    }
    public Produto(Integer id, String nome, String descricao, String tamanho, String genero, Integer quantidade, Double valor, Pedido pedido) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.tamanho = tamanho;
        this.genero = genero;
        this.quantidade = quantidade;
        this.valor = valor;
        this.pedido = pedido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Pedido getPedido() {
        return pedido;
    }
    public void setPedido(Pedido pedido){
        this.pedido = pedido;
    }
}
