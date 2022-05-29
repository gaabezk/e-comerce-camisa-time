package br.com.serratec.ecomercecamisatime.services;

import br.com.serratec.ecomercecamisatime.exceptions.IdNotFoundException;
import br.com.serratec.ecomercecamisatime.models.Produto;
import br.com.serratec.ecomercecamisatime.restClient.RestViaCep;
import br.com.serratec.ecomercecamisatime.models.Endereco;
import br.com.serratec.ecomercecamisatime.modelsDTO.ViaCepDTO;
import br.com.serratec.ecomercecamisatime.repositorios.EnderecoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    EnderecoRepositorio enderecoRepositorio;

    @Autowired
    RestViaCep restViaCep;

    public List<Endereco> findAll(){
        return enderecoRepositorio.findAll();
    }
    public Endereco findById(Integer id) throws IdNotFoundException {
        Optional<Endereco> optional = enderecoRepositorio.findById(id);
        if (optional.isEmpty()){
            throw new IdNotFoundException();
        }
        return optional.get();
    }
    public Endereco create(Endereco enderecoDTO){
        ViaCepDTO enderecoNovo = restViaCep.getViaCep(enderecoDTO.getCep());
        Endereco endereco = new Endereco();

        endereco.setRua(enderecoNovo.getLogradouro());
        endereco.setCidade(enderecoNovo.getLocalidade());
        endereco.setCep(enderecoNovo.getCep());
        endereco.setBairro(enderecoNovo.getBairro());
        endereco.setNumero(enderecoDTO.getNumero());
        endereco.setComplemento(enderecoDTO.getComplemento());

        return  enderecoRepositorio.save(endereco);
    }

}
