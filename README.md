# Projeto-de-Software


 #### Branchs:
 
 ###### main - Primeira versão
 ###### poo  - Segunda versão (conceitos de orientação a objeto)
 ###### exceptions - Terceira versão (aplicando exceptions)
 ###### padrões - Quarta versão (Padrões de projeto)
 
 # CODE SMELLS
 
 identificando smells no código:
 
 #### 1 - Duplicate Code
  Solução: Conceitos de herança. Com a finalidade de evitar repetição de código em classes subjacentes surgiu a classe abstrata Usuario, pois assim facilita o manuseio com as subclasses: professor, estudante, profissional, pesquisador e tecnico. Todas essas herdam as características de Usuario.
  
 #### 2 - Long Method
    Solução: Com a finalidade de reduzir o tamanho de linhas dos métodos, alguns deles foram movidos para os objetos que são referentes a eles próprios.
    
    
 ## Padrões inseridos: 
 
 ### Builder
 
 Builder é um padrão de design criacional que permite construir objetos complexos passo a passo. O padrão permite produzir diferentes tipos e representações de um objeto usando o mesmo código de construção. Um problema que existia era em Atividade, pois para criar o objeto o construtor estava muito extenso, sendo assim o padrão builder veio para ajudar. Além disso, permite que facilite a compreensão dos atributos que formam o objeto.
 
 ##### Anteriormente:
 ![image](https://user-images.githubusercontent.com/83170114/206161077-a076da1d-293b-4a0d-b2aa-d78afe471fe4.png)


 #### Atualmente:
 ![image](https://user-images.githubusercontent.com/83170114/206161485-439d7177-57b9-4820-93f8-5aa4384b5cb2.png)
  ![image](https://user-images.githubusercontent.com/83170114/206162045-97511d40-8eaf-4fce-9448-febc94209e5c.png)

### Inversion of control

Inversion of control consiste em retirar da classe a responsabilidade de instânciar suas dependências. No meu projeto existe um desconto para alunos que recebem uma bolsa maior que 400 reais, caso buscasse mudar a taxa teria que realizar várias mudanças incluindo na classe que instância ela. Portando, Inversion OF Control retira a responsabilidade da classe Pagamento instânciar a taxa para os estudantes. A maneira utilizada de aplicar a inversão de controle foi por meio da injeção de dependência, ela é uma forma de inver~sao de controle: um componente externo instancia a dependência, que é injetada no objeto "pai".

##### Classe taxaParaEstudantes:
![image](https://user-images.githubusercontent.com/83170114/206165090-687184c0-7bb7-4e3a-97a6-cb534549a74d.png)

#### Interface taxas:

![image](https://user-images.githubusercontent.com/83170114/206165485-76f03b07-e345-49c8-ade6-b90b5483c475.png)

#### Classe Pagamentos:
![image](https://user-images.githubusercontent.com/83170114/206166036-aea0bdf6-d886-4891-b6f6-882c8ae52c25.png)
###### observe que em pagamentos eu não preciso instanciar taxaParaEstudantes, pois isso já acontece na hora de fazer o pagamento em projeto:
![image](https://user-images.githubusercontent.com/83170114/206166923-ca86f151-fddd-4e57-9ad1-d716d167e2ed.png)

## Boas práticas:
Além dos padrões inseridos, foi aplicado algumas outras práticas para facilitar uma possível manutenção no futuro, entre eles:
###### Uso da nomeclatura Uppercase em todas as classes;
###### Correção de warnings que poderiam a dar algum erro;





