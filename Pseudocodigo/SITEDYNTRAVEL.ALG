Algoritmo "SiteDynTravel"

Var
   nome:vetor[1..2] de caractere
   cpf:vetor[1..2] de caractere
   destino:vetor[1..3] de caractere
   hoteis:vetor[1..3] de caractere
   destinoSel:caractere
   hoteisSel:caractere
   i:inteiro
   opcao:inteiro

Inicio
   destino[1]<- "Curitiba-PR"
   destino[2]<- "Jericoacoara-CE"
   destino[3]<- "Salvador-BA"

   hoteis[1]<- "Master Curitiba Hotel"
   hoteis[2]<- "Mini Hotel Dunas"
   hoteis[3]<- "Rede Andrade Riviera Premium"


   enquanto verdadeiro faca
      escreval("Digite 1 para cadastro")
      escreval("Digite 2 para passagens aéreas")
      escreval("Digite 3 para hospedagem")
      escreval("Digite 4 para consultar reservas")
      escreval(" Aperte ESC para sair ")
      leia(opcao)
      limpatela
      se opcao = 1 entao
         escreval ("Você digitou a opção Cadastro")
         para i de 1 ate 2 faca
            escreval("Digite o nome da",i,"a pessoa")
            leia(nome[i])
            escreval("Digite o CPF da",i,"a pessoa")
            leia (cpf[i])

         fimpara
         limpatela

         escreval("Cadastro realizado")

      senao
         se opcao = 2 entao
            escreval ("Você digitou a opção Passagens Aéreas ")
            escreval ("Escolha o seu destino")
            para i de 1 ate 3 faca
               escreval (destino[i])
            fimpara
            leia (destinoSel)
            limpatela
            escreval ("O Destino selecionado foi ",destinoSel)
         senao
            se opcao = 3 entao
               escreval ("Você digitou a opção Hospedagem ")
               escreval ("Escolha o seu Hotel")
               para i de 1 ate 3 faca
                  escreval (hoteis[i])
               fimpara
               leia (hoteisSel)
               limpatela
               escreval ("O Hotel selecionado foi ",hoteisSel)

            senao
               se opcao = 4 entao
                  para i de 1 ate 2 faca
                     escreval (nome[i]," de CPF número ", cpf[i], " Sua reserva foi concuida")
                  fimpara
                  escreval ("O destino selecionado foi ", destinoSel, " E vocês ficarão hospedados no hotél : ", hoteisSel)
               senao
                  escreval ("Opção inválida")

               fimse
            fimse
         fimse
      fimse

   fimenquanto


Fimalgoritmo