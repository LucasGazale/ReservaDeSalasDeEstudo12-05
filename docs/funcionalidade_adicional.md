# Implementação do Padrão Proxy
A nova funcionalidade implementa uma camada de segurança e controle de acesso no sistema de reservas. O objetivo é garantir que apenas
usuários com papéis específicos (como professores) possam reservar salas classificadas como laboratórios (LabClassroom). Caso um estudante
tente realizar essa reserva, o sistema intercepta a solicitação e nega o acesso, protegendo recursos críticos do campus.
