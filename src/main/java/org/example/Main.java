package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.enums.CategoriaVeiculo;
import org.example.enums.StatusAluguel;
import org.example.enums.StatusVeiculo;
import org.example.model.Aluguel;
import org.example.model.Cliente;
import org.example.model.Funcionario;
import org.example.model.Veiculo;
import org.example.service.*;
import org.example.vo.RelatorioAlugueisVo;
import org.example.vo.RelatorioFinanceiroVo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static EntityManager em;

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PostgresPU");
        em = emf.createEntityManager();

        AluguelService aluguelService = new AluguelService(em);
        ClienteService clienteService = new ClienteService(em);
        FuncionarioService funcionarioService = new FuncionarioService(em);
        VeiculoService veiculoService = new VeiculoService(em);
        RelatorioService relatorioService = new RelatorioService(em);

        boolean continuar = true;

        while (continuar) {
            System.out.println("----- MENU -----");
            System.out.println("1. Cliente");
            System.out.println("2. Funcionario");
            System.out.println("3. Veiculo");
            System.out.println("4. Aluguel");
            System.out.println("5. Relatorio");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int op = scanner.nextInt();
            scanner.nextLine();

            switch (op) {
                case 1 -> {
                    System.out.println("----- MENU CLIENTE -----");
                    System.out.println("1. Cadastrar Cliente");
                    System.out.println("2. Alterar Cliente");
                    System.out.println("3. Excluir Cliente");
                    System.out.println("4. Consultar Cliente por ID");
                    System.out.println("5. Listar todos os Clientes");
                    System.out.print("Escolha uma opção: ");
                    int clienteOp = scanner.nextInt();
                    scanner.nextLine();

                    switch (clienteOp) {
                        case 1 -> cadastrarCliente(clienteService);
                        case 2 -> alterarCliente(clienteService);
                        case 3 -> excluirCliente(clienteService);
                        case 4 -> consultarClientePorId(clienteService);
                        case 5 -> listarClientes(clienteService);
                        default -> System.out.println("Opção inválida! Tente novamente.");
                    }
                }

                case 2 -> {
                    System.out.println("----- MENU FUNCIONARIO -----");
                    System.out.println("1. Cadastrar Funcionario");
                    System.out.println("2. Alterar Funcionario");
                    System.out.println("3. Excluir Funcionario");
                    System.out.println("4. Consultar Funcionario por ID");
                    System.out.println("5. Listar todos os Funcionarios");
                    System.out.print("Escolha uma opção: ");
                    int funcionarioOp = scanner.nextInt();
                    scanner.nextLine();

                    switch (funcionarioOp) {
                        case 1 -> cadastrarFuncionario(funcionarioService);
                        case 2 -> alterarFuncionario(funcionarioService);
                        case 3 -> excluirFuncionario(funcionarioService);
                        case 4 -> consultarFuncionarioPorId(funcionarioService);
                        case 5 -> listarFuncionarios(funcionarioService);
                        default -> System.out.println("Opção inválida! Tente novamente.");
                    }
                }

                case 3 -> {
                    System.out.println("----- MENU VEICULO -----");
                    System.out.println("1. Cadastrar Veiculo");
                    System.out.println("2. Alterar Veiculo");
                    System.out.println("3. Excluir Veiculo");
                    System.out.println("4. Consultar Veiculo por ID");
                    System.out.println("5. Consultar Veiculo por Modelo");
                    System.out.println("6. Consultar Veiculo por Categoria");
                    System.out.println("7. Consultar Veiculo por Status");
                    System.out.println("8. Listar todos os Veiculos");
                    System.out.print("Escolha uma opção: ");
                    int veiculoOp = scanner.nextInt();
                    scanner.nextLine();

                    switch (veiculoOp) {
                        case 1 -> cadastrarVeiculo(veiculoService);
                        case 2 -> alterarVeiculo(veiculoService);
                        case 3 -> excluirVeiculo(veiculoService);
                        case 4 -> consultarVeiculoPorId(veiculoService);
                        case 5 -> buscarVeiculoModelo(veiculoService);
                        case 6 -> buscarVeiculoPorCategoria(veiculoService);
                        case 7 -> buscarVeiculoPorStatus(veiculoService);
                        case 8 -> listarVeiculos(veiculoService);
                        default -> System.out.println("Opção inválida! Tente novamente.");
                    }
                }

                case 4 -> {
                    System.out.println("----- MENU ALUGUEL -----");
                    System.out.println("1. Cadastrar Aluguel");
                    System.out.println("2. Alterar Aluguel");
                    System.out.println("3. Excluir Aluguel");
                    System.out.println("4. Consultar Aluguel por ID");
                    System.out.println("5. Consultar Aluguel por Periodo");
                    System.out.println("6. Consultar Aluguel de um Cliente");
                    System.out.println("7. Consultar Aluguel de um Funcionario");
                    System.out.println("8. Consultar Aluguel de um Veiculo");
                    System.out.println("9. Listar todos os Alugueis");
                    System.out.print("Escolha uma opção: ");
                    int aluguelOp = scanner.nextInt();
                    scanner.nextLine();

                    switch (aluguelOp) {
                        case 1 -> cadastrarAluguel(aluguelService);
                        case 2 -> alterarAluguel(aluguelService);
                        case 3 -> excluirAluguel(aluguelService);
                        case 4 -> consultarAlguelPorId(aluguelService);
                        case 5 -> consultarAluguelPorPeriodo(aluguelService);
                        case 6 -> consultarAluguelDeCliente(aluguelService);
                        case 7 -> consultarAluguelDeFuncionario(aluguelService);
                        case 8 -> consultarAluguelDeVeiculo(aluguelService);
                        case 9 -> listarAluguel(aluguelService);
                        default -> System.out.println("Opção inválida! Tente novamente.");
                    }
                }

                case 5 -> {
                    System.out.println("----- MENU RELATORIO -----");
                    System.out.println("1. Consultar Valor Total de vendas Por Periodo");
                    System.out.println("2. Consultar Total de Cliente atendidos Por Periodo");
                    System.out.println("3. Consultar Valor Total de Venda Por Cliente");
                    System.out.println("4. Relatorio Aluguel");
                    System.out.println("5. Relatorio Financeiro");
                    System.out.print("Escolha uma opção: ");
                    int relatorioOp = scanner.nextInt();
                    scanner.nextLine();

                    switch (relatorioOp) {
                        case 1 -> consultarVendasTotalPorPeriodo(relatorioService);
                        case 2 -> consultarClietesAtendidosPorPeriodo(relatorioService);
                        case 3 -> consultarVendasTotalPorCliente(relatorioService);
                        case 4 -> consultarRelatorioAlugueis(relatorioService);
                        case 5 -> consultaRelatorioFinanceiro(relatorioService);
                        default -> System.out.println("Opção inválida! Tente novamente.");
                    }
                }

                case 0 -> {
                    System.out.println("Saindo do sistema...");
                    continuar = false;
                }

                default -> System.out.println("Opção inválida! Tente novamente.");
            }
        }

    }

    private static void cadastrarCliente(ClienteService clienteService) {
        System.out.println("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.println("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();
        System.out.println("Digite o CNH do cliente: ");
        String cnh = scanner.nextLine();
        System.out.println("Digite o Email do cliente: ");
        String email = scanner.nextLine();
        System.out.println("Digite o Telefone do cliente: ");
        String telefone = scanner.nextLine();
        System.out.println("Digite o Endereco do cliente: ");
        String endereco = scanner.nextLine();

        Cliente cliente = new Cliente(cpf, cnh, nome, email, telefone, endereco);
        clienteService.inserir(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    private static void alterarCliente(ClienteService clienteService) {
        System.out.print("Digite o ID do cliente para ser alterado: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        Cliente cliente = clienteService.buscarClientePorId(id);
        if (cliente != null) {
            System.out.println("Digite o novo nome do Cliente: ");
            cliente.setNome(scanner.nextLine());
            clienteService.alterar(cliente);
            System.out.println("Cliente alterado com sucesso!");
        }else{
            System.out.println("Cliente nao encontrada.");
        }
    }

    private static void excluirCliente(ClienteService clienteService) {
        System.out.println("Digite o ID do cliente a ser excluido: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        Cliente cliente = clienteService.buscarClientePorId(id);
        if(cliente != null){
            clienteService.excluir(cliente);
            System.out.println("Cliente excluido com sucesso!");
        }else{
            System.out.println("Cliente nao encontrado.");
        }
    }

    private static void consultarClientePorId(ClienteService clienteService) {
        System.out.print("Digite o ID do cliente: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        Cliente cliente = clienteService.buscarClientePorId(id);
        System.out.println(cliente != null ? cliente.toString() : "Cliente nao encontrado.");
    }

    private static void listarClientes(ClienteService clienteService) {
        List<Cliente> clientes = clienteService.buscarTodosCliente();
        clientes.forEach(System.out::println);
    }



    private static void cadastrarFuncionario(FuncionarioService funcionarioService) {
        System.out.println("Digite o nome do funcionario: ");
        String nome = scanner.nextLine();
        System.out.println("Digite o salario do funcionario: ");
        double salario = scanner.nextDouble();
        Funcionario funcionario = new Funcionario(nome, salario);
        funcionarioService.inserir(funcionario);
        System.out.println("Funcionario cadastrado com sucesso!");
    }

    private static void alterarFuncionario(FuncionarioService funcionarioService) {
        System.out.print("Digite o ID do funcionario para ser alterado: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        Funcionario funcionario = funcionarioService.buscarFuncionarioPorId(id);
        if (funcionario != null) {
            System.out.println("Digite o novo nome do Funcionario: ");
            funcionario.setNome(scanner.nextLine());
            funcionarioService.alterar(funcionario);
            System.out.println("Funcionario alterado com sucesso!");
        }else{
            System.out.println("Funcionario nao encontrada.");
        }
    }

    private static void excluirFuncionario(FuncionarioService funcionarioService) {
        System.out.println("Digite o ID do funcionario a ser excluido: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        Funcionario funcionario = funcionarioService.buscarFuncionarioPorId(id);
        if(funcionario != null){
            funcionarioService.excluir(funcionario);
            System.out.println("Funcionario excluido com sucesso!");
        }else{
            System.out.println("Funcionario nao encontrado.");
        }
    }

    private static void consultarFuncionarioPorId(FuncionarioService funcionarioService) {
        System.out.print("Digite o ID do funcionario: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        Funcionario funcionario = funcionarioService.buscarFuncionarioPorId(id);
        System.out.println(funcionario != null ? funcionario.toString() : "Funcionario nao encontrado.");
    }

    private static void listarFuncionarios(FuncionarioService funcionarioService) {
        List<Funcionario> funcionarios = funcionarioService.buscarTodosFuncionarios();
        funcionarios.forEach(System.out::println);
    }

    private static void cadastrarVeiculo(VeiculoService veiculoService) {
        System.out.println("Digite o modelo do veiculo: ");
        String modelo = scanner.nextLine();
        System.out.println("Digite a marca do veiculo: ");
        String marca = scanner.nextLine();
        System.out.println("Digite a placa do veiculo: ");
        String placa = scanner.nextLine();
        System.out.println("Digite a cor do veiculo: ");
        String cor = scanner.nextLine();
        System.out.println("Digite o ano do veiculo: ");
        int ano = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Selecione a categoria do veículo:");
        for (int i = 0; i < CategoriaVeiculo.values().length; i++) {
            System.out.println(i + " - " + CategoriaVeiculo.values()[i]);
        }
        int categoriaIndex = Integer.parseInt(scanner.nextLine());
        CategoriaVeiculo categoria = CategoriaVeiculo.values()[categoriaIndex];

        System.out.println("Selecione o status do veículo:");
        for (int i = 0; i < StatusVeiculo.values().length; i++) {
            System.out.println(i + " - " + StatusVeiculo.values()[i]);
        }
        int statusIndex = Integer.parseInt(scanner.nextLine());
        StatusVeiculo status = StatusVeiculo.values()[statusIndex];

        Veiculo veiculo = new Veiculo(placa, marca, modelo, cor, ano, status, categoria);
        veiculoService.inserir(veiculo);

        System.out.println("Veiculo cadastrado com sucesso!");
    }

    private static void alterarVeiculo(VeiculoService veiculoService) {
        System.out.print("Digite o ID do veiuclo para ser alterado: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        Veiculo veiculo = veiculoService.buscarVeiculoPorID(id);
        if (veiculo != null) {
            System.out.println("Digite o novo modelo do Veiculo: ");
            veiculo.setModelo(scanner.nextLine());
            veiculoService.alterar(veiculo);
            System.out.println("Veiculo alterado com sucesso!");
        }else{
            System.out.println("Veiculo nao encontrado.");
        }
    }

    private static void excluirVeiculo(VeiculoService veiculoService) {
        System.out.println("Digite o ID do veiculo: ");
        Long id = scanner.nextLong();
        Veiculo veiculo = veiculoService.buscarVeiculoPorID(id);
        if(veiculo != null){
            veiculoService.excluir(veiculo);
            System.out.println("Veiculo excluido com sucesso!");
        }else {
            System.out.println("Veiculo nao encontrado.");
        }

    }

    private static void consultarVeiculoPorId(VeiculoService veiculoService) {
        System.out.print("Digite o ID do veiculo: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        Veiculo veiculo = veiculoService.buscarVeiculoPorID(id);
        System.out.println(veiculo != null ? veiculo.toString() : "Veiculo nao encontrado.");
    }

    private static void listarVeiculos(VeiculoService veiculoService) {
        List<Veiculo> veiculos = veiculoService.buscarTodosVeiculos();
        veiculos.forEach(System.out::println);
    }

    private static void buscarVeiculoModelo(VeiculoService veiculoService) {
        System.out.println("Digite o modelo do veiculo: ");
        String modelo = scanner.nextLine();
        List<Veiculo> veiculos = veiculoService.buscarVeiculoPorNome(modelo);

        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo encontrado com o modelo informado.");
        } else {
            veiculos.forEach(System.out::println);
        }
    }

    private static void buscarVeiculoPorStatus(VeiculoService veiculoService) {
        System.out.println("Selecione o status do veiculo:");
        for (int i = 0; i < StatusVeiculo.values().length; i++) {
            System.out.println(i + " - " + StatusVeiculo.values()[i]);
        }
        int statusIndex = Integer.parseInt(scanner.nextLine());
        StatusVeiculo status = StatusVeiculo.values()[statusIndex];
        List<Veiculo> veiculos = veiculoService.buscaVeiculoPorStatus(status);
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo encontrado com o status informado.");
        } else {
            veiculos.forEach(System.out::println);
        }
    }

    private static void buscarVeiculoPorCategoria(VeiculoService veiculoService) {
        System.out.println("Selecione a categoria do veiculo:");
        for (int i = 0; i < CategoriaVeiculo.values().length; i++) {
            System.out.println(i + " - " + CategoriaVeiculo.values()[i]);
        }
        int categoriaIndex = Integer.parseInt(scanner.nextLine());
        CategoriaVeiculo categoria = CategoriaVeiculo.values()[categoriaIndex];
        List<Veiculo> veiculos = veiculoService.buscaVeiculoPorCategoria(categoria);
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo encontrado com a categoria informada.");
        } else {
            veiculos.forEach(System.out::println);
        }
    }

    private static void cadastrarAluguel(AluguelService aluguelService) {
        try {
            System.out.println("Digite o ID do cliente: ");
            Long idCliente = scanner.nextLong();
            scanner.nextLine();
            Cliente cliente = em.find(Cliente.class, idCliente);
            if (cliente == null) {
                System.out.println("Cliente não encontrado.");
                return;
            }

            System.out.println("Digite o ID do funcionario: ");
            Long idFuncionario = scanner.nextLong();
            Funcionario funcionario = em.find(Funcionario.class, idFuncionario);
            if (funcionario == null) {
                System.out.println("Funcionario não encontrado.");
                return;
            }

            System.out.println("Digite o ID do veiculo: ");
            Long idVeiculo = scanner.nextLong();
            Veiculo veiculo = em.find(Veiculo.class, idVeiculo);
            if (veiculo == null) {
                System.out.println("Veiculo não encontrado.");
                return;
            }

            scanner.nextLine();
            System.out.println("Digite a Data do Inicio do aluguel (yyyy-MM-dd): ");
            LocalDate dataIni = LocalDate.parse(scanner.nextLine());
            System.out.println("Digite a Data do Fim do aluguel (yyyy-MM-dd): ");
            LocalDate dataFim = LocalDate.parse(scanner.nextLine());

            long diasAlugados = java.time.temporal.ChronoUnit.DAYS.between(dataIni, dataFim);

            double tarifaDiaria;
            switch (veiculo.getCategoria()) {
                    case SUV:
                        tarifaDiaria = 150.0;
                        break;
                    case SEDAN:
                    tarifaDiaria = 100.0;
                    break;
                case HATCH:
                    tarifaDiaria = 80.0;
                    break;
                case PICKUP:
                    tarifaDiaria = 120.0;
                    break;
                case UTILITARIO:
                    tarifaDiaria = 60.0;
                    break;
                default:
                    tarifaDiaria = 0.0;
                    break;
            }

            double valorTotal = tarifaDiaria * diasAlugados;

            System.out.println("Digite o Km Inicial do veiculo: ");
            double kmIni = scanner.nextDouble();
            System.out.println("Digite o Km Final do veiculo: ");
            double kmFinal = scanner.nextDouble();

            scanner.nextLine();
            System.out.println("Selecione o status do aluguel:");
            for (int i = 0; i < StatusAluguel.values().length; i++) {
                System.out.println(i + " - " + StatusAluguel.values()[i]);
            }
            int statusIndex = Integer.parseInt(scanner.nextLine());
            StatusAluguel status = StatusAluguel.values()[statusIndex];

            Aluguel aluguel = new Aluguel(dataIni, dataFim, kmIni, kmFinal, valorTotal, status, cliente, funcionario, veiculo);
            aluguelService.inserir(aluguel);

            System.out.println("Aluguel cadastrado com sucesso!");
            System.out.println("Valor total do aluguel: R$ " + valorTotal);
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar aluguel: " + e.getMessage());
        }
    }

    private static void alterarAluguel(AluguelService aluguelService) {
        try {
            System.out.println("Informe o ID do aluguel que deseja alterar: ");
            Long idAluguel = scanner.nextLong();
            scanner.nextLine();

            Aluguel aluguel = aluguelService.buscarAluguelPorId(idAluguel);
            if (aluguel == null) {
                System.out.println("Aluguel não encontrado.");
                return;
            }

            System.out.println("Informe o que deseja alterar:");
            System.out.println("1 - Alterar cliente");
            System.out.println("2 - Alterar funcionário");
            System.out.println("3 - Alterar veículo");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o ID do novo cliente: ");
                    Long idCliente = scanner.nextLong();
                    scanner.nextLine();
                    Cliente novoCliente = em.find(Cliente.class, idCliente);
                    if (novoCliente == null) {
                        System.out.println("Cliente não encontrado.");
                    } else {
                        aluguel.setCliente(novoCliente);
                        aluguelService.alterar(aluguel);
                        System.out.println("Cliente alterado com sucesso!");
                    }
                    break;

                case 2:
                    System.out.println("Digite o ID do novo funcionário: ");
                    Long idFuncionario = scanner.nextLong();
                    scanner.nextLine();
                    Funcionario novoFuncionario = em.find(Funcionario.class, idFuncionario);
                    if (novoFuncionario == null) {
                        System.out.println("Funcionário não encontrado.");
                    } else {
                        aluguel.setFuncionario(novoFuncionario);
                        aluguelService.alterar(aluguel);
                        System.out.println("Funcionário alterado com sucesso!");
                    }
                    break;

                case 3:
                    System.out.println("Digite o ID do novo veículo: ");
                    Long idVeiculo = scanner.nextLong();
                    scanner.nextLine();
                    Veiculo novoVeiculo = em.find(Veiculo.class, idVeiculo);
                    if (novoVeiculo == null) {
                        System.out.println("Veículo não encontrado.");
                    } else {
                        aluguel.setVeiculo(novoVeiculo);
                        aluguelService.alterar(aluguel);
                        System.out.println("Veículo alterado com sucesso!");
                    }
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } catch (Exception e) {
            System.out.println("Erro ao alterar aluguel: " + e.getMessage());
        }
    }

    private static void excluirAluguel(AluguelService aluguelService) {
        System.out.println("Digite o ID do alguel: ");
        Long id = scanner.nextLong();
        Aluguel aluguel = aluguelService.buscarAluguelPorId(id);
        if(aluguel != null){
            aluguelService.excluir(aluguel);
            System.out.println("Aluguel excluido com sucesso!");
        }else {
            System.out.println("Aluguel nao encontrado.");
        }

    }

    private static void consultarAlguelPorId(AluguelService aluguelService) {
        System.out.print("Digite o ID do aluguel: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        Aluguel aluguel = aluguelService.buscarAluguelPorId(id);
        System.out.println(aluguel != null ? aluguel.toString() : "Aluguel nao encontrado.");
    }

    private static void listarAluguel(AluguelService aluguelService) {
        List<Aluguel> aluguel = aluguelService.buscarTodosAluguel();
        aluguel.forEach(System.out::println);
    }

    private static void consultarAluguelPorPeriodo(AluguelService aluguelService) {
        System.out.print("Digite a data de início (yyyy-MM-dd): ");
        LocalDate dataInicio = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.print("Digite a data de fim (yyyy-MM-dd): ");
        LocalDate dataFim = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ISO_LOCAL_DATE);

        List<Aluguel> aluguel = aluguelService.buscarAlguelPorPeriodo(dataInicio, dataFim);
        if (!aluguel.isEmpty()) {
            System.out.println("alugueis no período selecionado:");
            aluguel.forEach(System.out::println);
        } else {
            System.out.println("Nenhum aluguel encontrado no período informado.");
        }
    }

    private static void consultarAluguelDeCliente(AluguelService aluguelService) {
        System.out.print("Digite o ID do cliente: ");
        Long clienteId = scanner.nextLong();
        scanner.nextLine();

        List<Aluguel> aluguel = aluguelService.buscarAluguelDeUmCliente(clienteId);
        if (!aluguel.isEmpty()) {
            System.out.println("alugueis do cliente selecionado:");
            aluguel.forEach(System.out::println);
        } else {
            System.out.println("Nenhum aluguel encontrado do cliente informado.");
        }
    }

    private static void consultarAluguelDeFuncionario(AluguelService aluguelService) {
        System.out.print("Digite o ID do funcionario: ");
        Long funcionarioId = scanner.nextLong();
        scanner.nextLine();

        List<Aluguel> aluguel = aluguelService.buscarAluguelDeUmFuncionario(funcionarioId);
        if (!aluguel.isEmpty()) {
            System.out.println("alugueis do funcionario selecionado:");
            aluguel.forEach(System.out::println);
        } else {
            System.out.println("Nenhum aluguel encontrado do funcionario informado.");
        }
    }
    private static void consultarAluguelDeVeiculo(AluguelService aluguelService) {
        System.out.print("Digite o ID do veiculo: ");
        Long veiucloId = scanner.nextLong();
        scanner.nextLine();

        List<Aluguel> aluguel = aluguelService.buscarAluguelDeUmVeiculo(veiucloId);
        if (!aluguel.isEmpty()) {
            System.out.println("alugueis do veiculo selecionado:");
            aluguel.forEach(System.out::println);
        } else {
            System.out.println("Nenhum aluguel encontrado do veiculo informado.");
        }
    }

    private static void consultarVendasTotalPorPeriodo(RelatorioService relatorioService) {
        System.out.println("Informe a data de Inicio(yyyy-MM-dd): ");
        LocalDate dataInicio = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println("Informe a data de Fim(yyyy-MM-dd): ");
        LocalDate dataFim = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ISO_LOCAL_DATE);
        Double total = relatorioService.relatorioValorTotalAlugadoPorPediodo(dataInicio, dataFim);
        if(total != null) {
            System.out.println("Total de vendas no periodo: " + total);
        }else {
            System.out.println("Nenhum venda encontrado do pedido informado.");
        }
    }

    private static void consultarVendasTotalPorCliente(RelatorioService relatorioService){
        System.out.println("Informe o id do Cliente: ");
        Long id = scanner.nextLong();
        Double total = relatorioService.relatorioValorTotalPorCliente(id);
        if(total != null) {
            System.out.println("Total de vendas Por Cliente: " + total);
        }else {
            System.out.println("Nenhum venda encontrado do cliente informado.");
        }
    }

    private static void consultarClietesAtendidosPorPeriodo(RelatorioService relatorioService) {
        System.out.println("Informe a data de Inicio(yyyy-MM-dd): ");
        LocalDate dataInicio = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println("Informe a data de Fim(yyyy-MM-dd): ");
        LocalDate dataFim = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ISO_LOCAL_DATE);
        long total = relatorioService.relatoriaTotalClienteAtendidoPorPediodo(dataInicio, dataFim);
        if (total != 0) {
            System.out.println("Total de clientes atendidos no periodo: " + total);
        } else {
            System.out.println("Nenhum cliente encontrado no periodo informado.");
        }
    }

    private static void consultarRelatorioAlugueis(RelatorioService relatorioService) {
        List<RelatorioAlugueisVo> relatorioAlugueisVo = relatorioService.retornarRelatorioAlugueis();
        System.out.println("Relatorios de Algueis: ");
        System.out.println(relatorioAlugueisVo);
    }

    private static void consultaRelatorioFinanceiro(RelatorioService relatorioService){
        List<RelatorioFinanceiroVo> relatorioFinanceiroVo = relatorioService.retornarRelatorioFinanceiro();
        System.out.println("Relatorios do Financeiro: ");
        System.out.println(relatorioFinanceiroVo);
    }
}