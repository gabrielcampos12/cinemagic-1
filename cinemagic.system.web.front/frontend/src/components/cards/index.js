import React from 'react';
import card from '../../assets/cadastro.jpg';
import './styles.css';
import {
  Card, Button, CardImg, CardTitle, CardText, CardGroup,
  CardSubtitle, CardBody
} from 'reactstrap';
const Example = (props) => {
  return (
    <CardGroup className="grupocards">
      <Card className="card">
        <CardImg top width="100%" src={card} alt="Card image cap" />
        <CardBody>
          <CardTitle tag="h5">Alegrete-RS</CardTitle>
          <CardSubtitle tag="h6" className="mb-2 text-muted">Cinemas aberto</CardSubtitle>
          <CardText>Filmes inéditos em cartaz confira!</CardText>
          <Button>Compre agora</Button>
        </CardBody>
      </Card>
      <Card className="card">
        <CardImg top width="100%" src={card} alt="Card image cap" />
        <CardBody>
          <CardTitle tag="h5">Florianópolis-SC</CardTitle>
          <CardSubtitle tag="h6" className="mb-2 text-muted">Filmes saindo de cartaz, não perca</CardSubtitle>
          <CardText>Vingadores, Harry</CardText>
          <Button>Confira o cartaz</Button>
        </CardBody>
      </Card>
      <Card className="card">
        <CardImg top width="100%" src={card} alt="Card image cap" />
        <CardBody>
          <CardTitle tag="h5">Porto Alegre-RS</CardTitle>
          <CardSubtitle tag="h6" className="mb-2 text-muted">Promoção Fidelidade</CardSubtitle>
          <CardText>Traga sua família e veja os melhores filmes com pontos de fidelidade</CardText>
          <Button>Resgatar pontos</Button>
        </CardBody>
      </Card>
    </CardGroup>
  );
};

export default Example;
