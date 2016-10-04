package iu;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

<<<<<<< Updated upstream
import modelo.Carta;
=======
import modelo.Duelista;
>>>>>>> Stashed changes
import modelo.ExcecaoBaralhoCheio;
import modelo.ExcecaoCampoCheio;
import modelo.ExcecaoCampoVazio;
import modelo.ExcecaoCartaNaoExiste;
import modelo.ExcecaoJogadorJaExiste;
import modelo.ExcecaoJogadorNaoExiste;
import modelo.ExcecaoSenhaErrada;
import modelo.Moeda;
import modelo.RepositorioCartas;
import modelo.Tabuleiro;
import modelo.Usuario;

public class Menu {
	public static void main(String[] args) {
		Connection bd = null;
		Tabuleiro tabuleiro;
		boolean logando = true;
		boolean dentro = true;
<<<<<<< Updated upstream
		boolean noTabuleiro = true;
		Jogador jogador = null;
		Mao maoJogador = null;
		String login;
		String senha;
		Integer opcao;
		bd = inicializaBancoDeDados(bd);
	      
		while (true) {
			dentro = true;
		while (logando) {
			opcao = Integer
					.parseInt(JOptionPane
							.showInputDialog("Digite 1 para realizar um login ou 2 para criar um jogador"));
			switch (opcao) {
			case 1:
				login = JOptionPane
						.showInputDialog("Digite o Login do jogador");
				senha = JOptionPane
						.showInputDialog("Digite a senha do jogador");
				try {
					Statement consulta = bd.createStatement();
					ResultSet retornoBD = consulta.executeQuery( "SELECT * FROM JOGADOR WHERE LOGIN = " + "'" + login + "';");
					retornoBD.next();
					jogador = new Jogador(retornoBD.getString("login"), retornoBD.getString("senha"), 0);
					logando = false;
					consulta.close();
					retornoBD.close();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null,
							"Login ou Senha Errados!");
				} 
				break;
			case 2:
				login = JOptionPane
						.showInputDialog("Digite o Login do jogador");
				senha = JOptionPane
						.showInputDialog("Digite a senha do jogador");
				try {
					Statement criacao = bd.createStatement();
					criacao.executeUpdate("INSERT INTO JOGADOR (LOGIN,SENHA)" + " VALUES ('" + login +"','"+ senha + "');");
					criacao.close();	
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Login ja existe!");
				}
				break;
			default:
				JOptionPane.showMessageDialog(null, "Comando Invalido!");
				break;
			}
		}
		while (dentro) {
			opcao = Integer
					.parseInt(JOptionPane
							.showInputDialog("Digite 1 ver seu baralho;\n"
									+ "Digite 2 para adicionar cartas no seu baralho;\n"
									+ "Digite 3 para entrar no tabuleiro;\n"
									+ "Digite 4 para sair."));
			String texto = "";
			switch (opcao) {
			case 1:
				if (jogador.getBaralho().getBaralho().isEmpty()) {
					texto = "Seu Baralho n�o possui cartas";
				} else {
					for (int i = 0; i < jogador.getBaralho().getBaralho()
							.size(); i++) {
						texto += jogador.getBaralho().getBaralho().get(i)
								.getId();
						texto += " "
								+ jogador.getBaralho().getBaralho().get(i)
										.getNome();
						texto += " "
								+ jogador.getBaralho().getBaralho().get(i)
										.getAtaque();
						texto += " "
								+ jogador.getBaralho().getBaralho().get(i)
										.getDefesa();
						texto += " "
								+ jogador.getBaralho().getBaralho().get(i)
										.getElemento();
						texto += "\n";
=======
		boolean noTabuleiro = false;
		Usuario jogador = null;
		Duelista duelista = null;
		String login;
		String senha;
		Integer opcao;
		RepositorioCartas.geraCartas();

		while (true) {
			logando = true;
			dentro = true;
			noTabuleiro = false;

			while (logando) {
				opcao = Integer
						.parseInt(JOptionPane
								.showInputDialog("Digite 1 para realizar um login ou 2 para criar um jogador"));
				switch (opcao) {
				case 1:
					login = JOptionPane
							.showInputDialog("Digite o Login do jogador");
					senha = JOptionPane
							.showInputDialog("Digite a senha do jogador");
					try {
						jogador = RepositorioJogadores.entrar(login, senha);
						logando = false;
					} catch (ExcecaoJogadorNaoExiste | ExcecaoSenhaErrada e) {
						JOptionPane.showMessageDialog(null,
								"Login ou Senha Errados!");
					}
					break;
				case 2:
					login = JOptionPane
							.showInputDialog("Digite o Login do jogador");
					senha = JOptionPane
							.showInputDialog("Digite a Senha do jogador");
					try {
						RepositorioJogadores.criaJogador(login, senha);
					} catch (ExcecaoJogadorJaExiste e) {
						JOptionPane.showMessageDialog(null, "Login ja existe!");
>>>>>>> Stashed changes
					}
					break;
				default:
					JOptionPane.showMessageDialog(null, "Comando Invalido!");
					break;
				}
<<<<<<< Updated upstream
				JOptionPane.showMessageDialog(null, jogador.getBaralho()
						.tamanhoDoBaralho()
						+ " Cartas em seu baralho:\n"
						+ texto);
				break;
			case 2:
				boolean alterando = true;

				while (alterando) {
					if(texto.isEmpty()) {
						try {
							Statement consulta = bd.createStatement();
							ResultSet retornoBD = consulta.executeQuery( "SELECT * FROM CARTAS ORDER BY id;");
							while (retornoBD.next()) {
								texto += retornoBD.getString("id") + " " + retornoBD.getString("nome")
								+ " " + retornoBD.getInt("ataque") + " " + retornoBD.getInt("defesa") 
								+ " " + retornoBD.getString("elemento") +"\n";
							}
							consulta.close();
							retornoBD.close();
						} catch (SQLException e) {
							e.printStackTrace();
=======
			}
			while (dentro) {
				opcao = Integer
						.parseInt(JOptionPane
								.showInputDialog("Digite 1 ver seu baralho;\n"
										+ "Digite 2 para adicionar cartas no seu baralho;\n"
										+ "Digite 3 para entrar no tabuleiro;\n"
										+ "Digite 4 para deslogar."));
				String texto = "";
				switch (opcao) {
				case 1:
					if (jogador.getBaralho().getBaralho().isEmpty()) {
						texto = "Seu Baralho n�o possui cartas";
					} else {
						for (int i = 0; i < jogador.getBaralho().getBaralho()
								.size(); i++) {
							texto += jogador.getBaralho().getBaralho().get(i)
									.getId();
							texto += " "
									+ jogador.getBaralho().getBaralho().get(i)
											.getNome();
							texto += " "
									+ jogador.getBaralho().getBaralho().get(i)
											.getAtaque();
							texto += " "
									+ jogador.getBaralho().getBaralho().get(i)
											.getDefesa();
							texto += " "
									+ jogador.getBaralho().getBaralho().get(i)
											.getElemento().name();
							texto += "\n";
>>>>>>> Stashed changes
						}
					}
					JOptionPane.showMessageDialog(null, jogador.getBaralho()
							.tamanhoDoBaralho()
							+ " Cartas em seu baralho: \n"
							+ texto);
					break;
				case 2:
					boolean alterando = true;

<<<<<<< Updated upstream
					switch (opcao2) {
					case 50:
						alterando = false;
						break;
					default:
						try {
							Statement consulta = bd.createStatement();
							ResultSet retornoBD = consulta.executeQuery( "SELECT * FROM CARTAS WHERE ID = '" + opcao2 + "';");
							retornoBD.next();
								jogador.adicionaCartaNoBaralho(new Carta(retornoBD.getString("nome"),
										retornoBD.getInt("ataque"), retornoBD.getInt("defesa"),
										retornoBD.getInt("id"), retornoBD.getString("elemento")));
							JOptionPane.showMessageDialog(null,
									"Carta adicionada!");
							consulta.close();
							retornoBD.close();
						} catch (ExcecaoCartaNaoExiste e) {
							JOptionPane.showMessageDialog(null,
									"Carta n�o existe!");
						} catch (ExcecaoBaralhoCheio e) {
							JOptionPane.showMessageDialog(null,
									"Baralho atingiu n�mero limite de cartas.");
=======
					while (alterando) {
						texto = "";
						for (int i = 0; i < QUANTIDADETOTALCARTAS; i++) {
							try {
								texto += RepositorioCartas.getCarta(i).getId();
								texto += " "
										+ RepositorioCartas.getCarta(i)
												.getNome();
								texto += " "
										+ RepositorioCartas.getCarta(i)
												.getAtaque();
								texto += " "
										+ RepositorioCartas.getCarta(i)
												.getDefesa();
								texto += " "
										+ RepositorioCartas.getCarta(i)
												.getElemento().name();
								texto += "\n";
							} catch (ExcecaoCartaNaoExiste e) {
								JOptionPane.showMessageDialog(null,
										"Carta nao existe.");
							}
						}
						Integer opcao2 = Integer
								.parseInt(JOptionPane
										.showInputDialog("Digite o Id da carta a ser inserida no baralho.\n"
												+ "Digite 50 para sair. \n"
												+ texto));

						switch (opcao2) {
						case 50:
							alterando = false;
							break;
						default:
							try {
								for (int i = 0; i < 21; i++)
									jogador.adicionaCartaNoBaralho(opcao2);
								JOptionPane.showMessageDialog(null,
										"Carta adicionada!");
							} catch (ExcecaoCartaNaoExiste e) {
								JOptionPane.showMessageDialog(null,
										"Carta n�o existe!");
							} catch (ExcecaoBaralhoCheio e) {
								JOptionPane
										.showMessageDialog(null,
												"Baralho atingiu n�mero limite de cartas.");
								break;
							}
>>>>>>> Stashed changes
							break;
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
					break;
				case 3:
					JOptionPane.showMessageDialog(null,
							"Entrando no tabuleiro...\n" + "Iniciando mao...");
					if (jogador.getBaralho().baralhoEstaCompleto()) {
						duelista = new Duelista(jogador);
						JOptionPane.showMessageDialog(null, "Mao iniciada!");
						noTabuleiro = true;
					} else {
						JOptionPane.showMessageDialog(null,
								"Seu baralho esta incompleto.");
						break;
					}
					dentro = false;
					break;
				case 4:
					JOptionPane.showMessageDialog(null, "Sess�o Finalizada.");
					dentro = false;
					break;
				default:
					JOptionPane.showMessageDialog(null, "Comando Invalido!");
					break;
				}
<<<<<<< Updated upstream
				dentro = false;
				break;
			case 4:
				JOptionPane.showMessageDialog(null, "Sess�o Finalizada.");
				dentro = false;
				logando = true;
				break;
			default:
				JOptionPane.showMessageDialog(null, "Comando Invalido!");
				break;
=======
>>>>>>> Stashed changes
			}
			tabuleiro = new Tabuleiro(duelista);
			Integer ladoMoeda = Integer
					.parseInt(JOptionPane
							.showInputDialog("Digite 0 para selecionar cara ou 1 para coroa"));
			if (ladoMoeda == 0)
				tabuleiro.decideLado(Moeda.Cara);
			else
				tabuleiro.decideLado(Moeda.Coroa);
			while (noTabuleiro) {
				String campo = "";
				String mao = "";
				opcao = Integer.parseInt(JOptionPane
						.showInputDialog("Digite 1 para ver sua mao;\n"
								+ "Digite 2 para ver seu campo;\n"
								+ "Digite 3 para inserir carta no seu campo;\n"
								+ "Digite 4 para retirar carta de campo;\n"
								+ "Digite qualquer outro valor para sair."));
				switch (opcao) {
				case 1:
					mao = duelista.mostraMao();

					JOptionPane.showMessageDialog(null, mao);
					break;
				case 2:
					try {
						for (int i = 0; i < tabuleiro.getCampo().size(); i++) {
							campo += i;
							campo += " "
									+ tabuleiro.getCampo().get(i).getNome();
							campo += " "
									+ tabuleiro.getCampo().get(i).getAtaque();
							campo += " "
									+ tabuleiro.getCampo().get(i).getDefesa();
							campo += " "
									+ tabuleiro.getCampo().get(i).getElemento();
							campo += "\n";
						}
						JOptionPane.showMessageDialog(null, campo);
					} catch (ExcecaoCampoVazio e) {
						JOptionPane.showMessageDialog(null, "Campo vazio");
					}
					break;
				case 3:

					Integer opcaoAddCartaCampo;
					mao = duelista.mostraMao();
					opcaoAddCartaCampo = Integer
							.parseInt(JOptionPane
									.showInputDialog("Digite a carta a ser inserida: \n\n"
											+ mao
											+ "\n\n"
											+ "Digite qualquer outro valor para sair."));

					if (!(opcaoAddCartaCampo >= duelista.getTamanhoDaMao() || opcaoAddCartaCampo < 0)) {
						try {
							tabuleiro.colocaEmCampo(opcaoAddCartaCampo);
						} catch (ExcecaoCampoCheio e) {
							JOptionPane.showMessageDialog(null, "Campo cheio.");
							break;
						}
					}
					break;
				case 4:
					campo = "";
					Integer opcaoRemCartaCampo;
					try {
						for (int i = 0; i < tabuleiro.getCampo().size(); i++) {
							campo += i;
							campo += " "
									+ tabuleiro.getCampo().get(i).getNome();
							campo += " "
									+ tabuleiro.getCampo().get(i).getAtaque();
							campo += " "
									+ tabuleiro.getCampo().get(i).getDefesa();
							campo += " "
									+ tabuleiro.getCampo().get(i).getElemento();
							campo += "\n";
						}
					} catch (ExcecaoCampoVazio e) {
					}
					opcaoRemCartaCampo = Integer
							.parseInt(JOptionPane
									.showInputDialog("Digite a carta a ser removida: \n\n"
											+ campo
											+ "\n\n"
											+ "Digite qualquer outro valor para sair."));

					if (!(opcaoRemCartaCampo >= tabuleiro.getTamanhoDoCampo() || opcaoRemCartaCampo < 0)) {
						try {
							tabuleiro.retiraDoCampo(opcaoRemCartaCampo);
						} catch (ExcecaoCampoVazio e) {
							JOptionPane.showMessageDialog(null,
									"Campo vazio, tente outra vez.");
							break;
						}
					}
					break;
				default:
					noTabuleiro = false;
					break;
				}
			}
		}
	}
}

	private static Connection inicializaBancoDeDados(Connection bd) {
		try {
	          Class.forName("org.postgresql.Driver");
	          bd = DriverManager
	             .getConnection("jdbc:postgresql://localhost:5432/cards&magic",
	             "postgres", "10203040");
	       } catch (Exception e) {
	          e.printStackTrace();
	          System.err.println(e.getClass().getName()+": "+e.getMessage());
	          System.exit(0);
	       }
		return bd;
	}
}
