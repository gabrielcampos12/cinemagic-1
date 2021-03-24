import React, { useState, useEffect } from 'react';      
import { Jumbotron, Button} from 'reactstrap';
import api from '../../services/api';
import { useHistory } from 'react-router-dom';

const Example = (props) => {
  const history = useHistory();
    const [sessao, setSessao] = useState([]);
    const token = localStorage.getItem('token');
    const [id,setId] = useState('');
  
    async function encaminhaCompraSessao(){
     
      try{
         
        const resposta = await api.get('sessoes');
          
          localStorage.setItem('sessaoAtual', JSON.stringify(resposta.data));

      
            
          

         alert(resposta.data);
          history.push('/Compra');
      }catch(err){
        alert(err);
    }}
  
  
    async function getApi() {
        try {
            const res = await api.get("sessoes")
            setSessao(res.data)
            
        } catch (ex) {
            alert(ex)
        }
      }


    useEffect(() => {
        getApi()
    }, [token])

 
  return (
   
   <div>
        <ul>
             {sessao.map(ses => (
                    <li key={ses.id}>
                            
                                 <Jumbotron>
        <h1 className="display-3">Alegrete-RS</h1>
        <p className="lead">Confira as sessões disponíveis</p>
                                    
                                    <strong>Filme: </strong>
                                    <p className = "test">{ses.filme.titulo}</p>
                                    <strong>Id : </strong>
                                    <p className = "test">{ses.id}</p>
                                    <strong>Data : </strong>
                                    <p className = "test">{ses.data}</p>
                                    <strong>Hora : </strong>
                                    <p className = "test">{ses.hora}</p>
                                   <strong> Valor inteira: </strong>
                                    <p>{Intl.NumberFormat('pt-BR', { style: 'currency', currency: 'BRL' }).format(ses.valorInteira)}</p>
                                    <strong> Valor Meia: </strong>
                                    <p>{Intl.NumberFormat('pt-BR', { style: 'currency', currency: 'BRL' }).format(ses.valorMeia)}</p>

                                    <strong>Filme: </strong>
                                    <p className = "test">{ses.filme.titulo}</p>
                                    <strong>Duração: </strong>
                                    <p className = "test">{ses.filme.duracao}</p>
                                    <strong>Gênero: </strong>
                                    <p className = "test">{ses.filme.genero.descricao}</p>
                                    <strong>Sala: </strong>
                                    <p className = "test">{ses.sala.numero}</p>
                                    <strong>Capacidade: </strong>
                                    <p className = "test">{ses.sala.capacidade}</p>
                                   


                                    
                                    <Button color="danger" onClick={encaminhaCompraSessao}>Comprar</Button>
        
        </Jumbotron>



                                </li>

                            ))}

                        </ul>

    
     

                

    </div>
  );
};

export default Example;