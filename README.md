<h1>Gerenciador de Incidentes</h1>

<i>Diego Kremer</i>
<br>
<i>Marcelo Fritz</i>
<br>
<br>
<br>
<b>Introdução</b>
<br>
O projeto tem como objetivo desenvolver um sistema web de gerenciamento de atividades
provenientes de incidentes registrados.
<br><br>
<b>Problema</b>
<br>
A área de gerenciamento de incidentes de uma empresa de TI costuma registrar suas atividades em
uma planilha de Excel e gostaria de ter um sistema específico para isso que fosse customizado para
sua realidade diária. Atualmente a equipe tem dificuldades em compartilhar a planilha e vários
analistas utilizá‐la simultaneamente, assim como o registro de atividades realizadas fica pouco
intuitivo para consulta de histórico de informações.
<br><br>
<b>Objetivo</b>
<br>
Desenvolver um sistema de registro de atividades que atenda as necessidades da área simplificando
as atividades da equipe e possibilitando que tenham fácil acesso às informações de histórico.
<br><br>
<b>Solução</b>
<br>
A solução será um sistema web dividido em três módulos básicos:
<br><br>
<b><i>Incidentes:</i></b>
O principal módulo é o de incidentes e será destinado à todas as informações relacionadas ao
incidente de TI que está sendo tratado pela equipe. Nele terá um número de registro único daquele
atendimento (gerado automaticamente), um número de registro de referência de outro sistema,
localidade impactada, a pessoa que reportou o incidente, a data em que foi reportado e descrição do
incidente.

<b><i>Atividades:</i></b>
O módulo de atividades será uma linha do tempo de atividades registradas referente à um
determinado incidente. Cada atividade será ligada à um analista e um incidente e conterá uma
descrição, equipe técnica envolvida e data e hora da atividade realizada.

<b><i>Usuários:</i></b>
O módulo de usuários é onde ficará registrado as pessoas envolvidas nas atividades e reporte de
incidentes da área de TI. Cada pessoa cadastrada terá um nome, cargo, e‐mail, telefone e tipo de
usuário (colaborador, usuário ou administrador).

<b><i>Grupos Técnicos:</i></b>
Os grupos técnicos serão uma entidade destinada a cadastro das equipes técnicas da companhia
responsáveis pelas tratativas dos problemas da área de TI. O grupo terá um nome, endereço de
e‐mail, telefone e usuários membros. Um grupo técnico poderá conter vários analistas e estará
diretamente ligado a entidade de Atividade onde cada atividade deverá ter um grupo técnico
responsável.
