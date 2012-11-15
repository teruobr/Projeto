<%-- 
    Document   : AreaAtuacaoPublico
    Created on : Nov 6, 2012, 1:19:57 PM
    Author     : Administrator
--%>

<%@page import="bean.AreaAtuacao"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Áreas de Atuação</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <div id ="alinhaTexto" >
            <h1>Programação</h1>

            <h4>Desenvolvedor, Programador:</h4> Expert em ferramentas de desenvolvimento de aplicações. Desenvolve programas e sistemas de vários tipos e portes. Conhece linguagens de programação e técnicas de programação avançadas;</br>
            <h4>Web Designer:</h4> É responsável por desenvolver as telas de sistemas para internet, de forma que sejam fáceis de usar, bonitas e intuitivas. Este profissional deve, além de programação, conhecer ferramentas de editoração de imagens;</br>
            <h4>Homologador, Testador:</h4> Profissional responsável por validar o desenvolvimento do sistema, efetuando testes exaustivos em telas, arquivos de entrada, saída e verificando se o comportamento de um sistema desenvolvido é o esperado pela empresa.</br></br>


            <h1>Análise</h1>

            <h4>Analista de Sistemas: </h4>Profissional responsável por confeccionar documentos que planejam e especificam o desenvolvimento do software. Este profissional é responsável por projetar o software do ponto de vista dos requisitos, gerando uma documentação consumida pelos programadores;</br>
            <h4>Analista de Negócios:</h4> Responsável por fazer a ponte entre a equipe de desenvolvimento/análise e o cliente. É um profissional muito experiente no domínio para o qual o software será desenvolvido. Tem um conhecimento tanto técnico como do negócio e consegue traduzir os desejos do cliente em requisitos para os analistas de sistemas;</br>
            <h4>Analista de Testes:</h4> Para que um sistema desenvolvido tenha qualidade é necessária uma bateria de testes a serem efetuados, dos mais diversos tipos. O Analista de Testes é responsáver por planejar estes testes, de forma que atendam os requisitos do cliente. Estes testes serão executados e reportados pelo Testador;</br>
            <h4>Arquiteto de Software:</h4> Profissional com muita experiência em programação e análise, que consegue planejar a arquitetura de tecnologias usadas para o desenvolvimento de um sistema. Responsável por planejamento das tecnologias, desempenho, uso de recursos, etc.</br></br>

            <h1>Redes</h1>

            <h4>Suporte Técnico:</h4> Conhecimento em Hardware para manutenção em computadores. Conhecimento de aplicações de automação de escritório (office). Conhecimento de sistema operacional desktop;</br>
            <h4>Projetista de Rede:</h4> Elaborar projetos de infraestrutura rede para suportar os diversos serviços de rede, especificar equipamentos de redes, configuração de equipamentos de redes. Conhecimento de protocolos;</br>
            <h4>Administrador de Redes:</h4> Responsável pela configuração de sistemas operacionais de rede e desktop. Elaborar políticas de segurança. Configurar e manter o funcionamento de serviços de rede como: Arquivos e impressão, Autenticação, DNS, Web, Firewall básico, Implantação de telefonia IP, etc.;</br>
            <h4>Gerente de Rede:</h4> É responsável por manter a rede de computadores de uma organização funcionando de forma adequada e eficiente. Como tarefas também deve cuidar da segurança desta rede, evitando ataques de hackers, crackers, etc.</br></br>

            <h1>Gerência</h1>

            <h4>Gerente de Projetos:</h4> É o profissional que responde pelo andamento de um projeto de T.I., seja ele de desenvolvimento de software até implantação de sistemas de terceiros. Deve ter muita experiência de negócio como técnica.</br>
            <h4>Gerente de T.I.:</h4> Profissional responsábel por toda a T.I. de uma organização, ou por setores bem definidos. Abaixo dele, encontram-se os gerentes de rede, analistas, programadores, etc. É responsável pelo desenvolvimento dos projetos e também por aquisição de aplicativos, bem como pelo parque de máquinas;</br>
            <h4>C.I.O.:</h4> Do inglês Chief Information Officer, representa o Diretor de Informática de uma empresa, responsável por toda a T.I.. Este profissional deve ter muita habilidade de comunicação interpessoal.</br></br>

            <h1>Docência e Pesquisa</h1>

            <h4>Professor:</h4> Um profissional de T.I. tem todo o know-how para ser incluído no corpo docente de escolas/faculdades/institutos para ministrar aulas sobre T.I.. Estas disciplinas vão desde Informática Básica até assuntos muito especializados, dependendo da formação de Pós-graduação do professor. Para atuar em Faculdades, Centros Universitários e Universidades, a titulação mínima exigida (em geral) é a de Mestre.
            Muitas instituições exigem Doutorado;</br>
            <h4>Instrutor:</h4> Profissional muito experiente em alguma tecnologia, podendo ministrar cursos extremamente especializados sobre ela. Em geral, as empresas fabricantes destas tecnologias emitem certificados indicando que o profissional é um especialista;</br>
            <h4>Pesquisador:</h4> O curso de B.S.I. também dá a base de formação para o profissinal que desejar seguir carreira acadêmica, fazendo Pós-graduação stricto sensu (Mestrado e Doutorado). Este profissional, com titulação adequada, poderá ingressar como docente em uma Universidade e efetuar pesquisa científica de ponta, publicando artigos, participando ativamente de congressos, etc.</br></br>

            <h1>Empresário</h1>

            <h4>Consultor:</h4> Profissional com grande experiência em várias áreas e que pode atuar como integrador, planejador de soluções, etc.;</br>
            <h4>Empresário:</h4> Empreendedor, dono de uma empresa em algum ramo de T.I. (desenvolvimento, suporte, redes, consultoria, etc).</br>
            <br>


            <%
                List<AreaAtuacao> areasAtuacao = (List<AreaAtuacao>) request.getSession().getAttribute("areasAtuacao");
                if (areasAtuacao != null) {
                    for (int i = 0; i < areasAtuacao.size(); i++) {
            %>
            <h1><%=areasAtuacao.get(i).getNome()%></h1>
            <br>
            <%       }
                }%>
        </div>
    </body>    
</html>
