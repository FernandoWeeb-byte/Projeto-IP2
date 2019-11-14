package negocio.beans;

import java.util.HashMap;

public class Habilidade {
	
	/// Atributos
	private String nome;
	private String tipo;
	private String categoria;
	private String requisito;
	private int mana;
	private int dificuldade;
	private String descricao;
	
	
	/// Construtores
	public Habilidade(String nome, String tipo, String categoria, String requisito,
					int mana, int dificuldade, String descricao)
	{
		this.nome = nome;
		this.tipo = tipo;
		this.categoria = categoria;
		this.requisito = requisito;
		this.mana = mana;
		this.dificuldade = dificuldade;
		this.descricao = descricao;
	}
	
	
	/// Métodos
	public String toString()
	{
		String str = String.format("%s\n"
								   + "Habilidade ",
								   this.nome);
		
		if(categoria != null)
		{
			str += String.format("(%s) ", this.categoria);
		}

		str += String.format("- %s\n", this.tipo);
		
		if(requisito != null)
		{
			str += String.format("Requisito: %s\n", this.requisito);
		}
		
		if(mana >= 0)
		{
			if(mana == 0)
			{
				str += "Mana: Varia\n";
			}
			else
			{
				str += String.format("Mana: %d\n", this.mana);	
			}
		}
		
		if(dificuldade >= 0)
		{
			str += String.format("Dificuldade da Magia: %d\n", this.dificuldade);
		}
		
		str += String.format("Descricao: %s", this.descricao);
		
		return str;
	}
	
	public static HashMap<String, Habilidade> habilidadesExtrasHumano()
	{
		HashMap<String, Habilidade> ret = new HashMap<String, Habilidade>();
		
		ret.put(ASSUNTOS_DIVERSOS.getNome(), ASSUNTOS_DIVERSOS);
		ret.put(AUDACIA.getNome(), AUDACIA);
		ret.put(BARGANHA.getNome(), BARGANHA);
		ret.put(DIVERSIDADE.getNome(), DIVERSIDADE);
		ret.put(O_DOBRO_OU_NADA.getNome(), O_DOBRO_OU_NADA);
		ret.put(GREGARIO.getNome(), GREGARIO);
		ret.put(SORTE.getNome(), SORTE);
		
		return ret;
	}
	
	public static HashMap<String, Habilidade> habilidadesBasicasGuerreiro()
	{
		HashMap<String, Habilidade> ret = new HashMap<String, Habilidade>();
		
		ret.put(ANULAR_GOLPE.getNome(), ANULAR_GOLPE);
		ret.put(ATAQUE_DO_BUFALO.getNome(), ATAQUE_DO_BUFALO);
		ret.put(ATAQUE_GIRATORIO.getNome(), ATAQUE_GIRATORIO);
		ret.put(ATAQUE_SIMULTANEO.getNome(), ATAQUE_SIMULTANEO);
		ret.put(BRIGAO.getNome(), BRIGAO);
		ret.put(COMBATE_EM_GRUPO.getNome(), COMBATE_EM_GRUPO);
		ret.put(COMBATE_COM_DUAS_ARMAS_1.getNome(), COMBATE_COM_DUAS_ARMAS_1);
		ret.put(COMBATE_PESADO.getNome(), COMBATE_PESADO);
		
		ret.put(COMBATE_TATICO.getNome(), COMBATE_TATICO);
		ret.put(DEFESA_AGRESSIVA.getNome(), DEFESA_AGRESSIVA);
		ret.put(DEFLETOR.getNome(), DEFLETOR);
		ret.put(ESTABILIDADE.getNome(), ESTABILIDADE);
		ret.put(GOLPE_DEVASTADOR_1.getNome(), GOLPE_DEVASTADOR_1);
		ret.put(GOLPE_COM_ESCUDO.getNome(), GOLPE_COM_ESCUDO);
		ret.put(GRITO_DE_GUERRA_1.getNome(), GRITO_DE_GUERRA_1);
		ret.put(GUERREIRO_DE_AÇO_1.getNome(), GUERREIRO_DE_AÇO_1);
		ret.put(INVESTIDA_MORTAL.getNome(), INVESTIDA_MORTAL);

		ret.put(NOCAUTEAR.getNome(), NOCAUTEAR);
		ret.put(PAREDE_DE_ESCUDOS.getNome(), PAREDE_DE_ESCUDOS);
		ret.put(SEM_ESCAPATORIA.getNome(), SEM_ESCAPATORIA);
		ret.put(TRANSPOR.getNome(), TRANSPOR);
		
		return ret;
	}
	
	public static HashMap<String, Habilidade> habilidadesAvancadasGuerreiro()
	{
		HashMap<String, Habilidade> ret = new HashMap<String, Habilidade>();
		
		ret.put(COMBATE_COM_DUAS_ARMAS_2.getNome(), COMBATE_COM_DUAS_ARMAS_2);
		ret.put(FORCA_DE_EXPLOSAO.getNome(), FORCA_DE_EXPLOSAO);
		ret.put(GOLPE_DEVASTADOR_2.getNome(), GOLPE_DEVASTADOR_2);
		ret.put(GRITO_DE_GUERRA_2.getNome(), GRITO_DE_GUERRA_2);

		ret.put(GRITO_DE_INTIMIDACAO.getNome(), GRITO_DE_INTIMIDACAO);
		ret.put(GUERREIRO_DE_ACO_2.getNome(), GUERREIRO_DE_ACO_2);
		ret.put(IMPLACAVEL.getNome(), IMPLACAVEL);
		ret.put(INVESTIDA_FORTE.getNome(), INVESTIDA_FORTE);
		ret.put(MESTRE_DE_ARMAS_2.getNome(), MESTRE_DE_ARMAS_2);
		ret.put(VALOR_DA_VITORIA.getNome(), VALOR_DA_VITORIA);
		
		return ret;
	}
	
	/// Gets e sets
	public String getNome()
	{
		return this.nome;
	}

	
	/// Instancias estáticas
	/// Raças
	// Humano
	// Habilidade Automática
	public final static Habilidade ADAPTABILIDADE = new Habilidade("Adaptabilidade", "Suporte", "Característica", null, -1, -1,
														"Você se adaptou ao ambiente em que cresceu ou à atividade que "
														+ "escolheu - ou precisou - desempenhar. Você tem +1 em qualquer "
														+ "um dos seus Atributos a sua escolha.");
	
	// Habilidades Extras
	// Habilidades Extras
	public final static Habilidade ASSUNTOS_DIVERSOS = new Habilidade("Assuntos Diversos", "Ação", "Característica", null, 30, -1,
														"Você estudou e praticou um pouco de tudo ao longo de sua vida. Você "
														+ "pode rolar +1d6 em um teste à sua escolha");
	public final static Habilidade AUDACIA = new Habilidade("Audácia", "Suporte", "Característica", null, -1, -1,
														"Você enfrenta ameaças e situações de perigo com entusiasmo. Sempre que "
														+ "estiver frente à uma situação de risco eminente - saltar entre duas "
														+ "bordas de um precipício, equilibrar-se em uma corda sobre um rio de "
														+ "lava, entrar em um combate ou qualquer situaão em que você possa "
														+ "potencialmente perder a vida (ou pelo menos se ferir seriamente), "
														+ "você recupera imediatamente 10 Pontos de Vida ou 10 Pontos de Mana, à "
														+ "sua escolha.\n"
														+ "\tEssa Habilidade só pode ser usada uma vez para cada situação de risco, "
														+ "e apenas quando o risco se apresentar - não depois da sua primeira "
														+ "ação em um combate ou depois de cair, por exemplo.");
	public final static Habilidade BARGANHA = new Habilidade("Barganha", "Suporte", "Característica", null, -1, -1,
														"Você é um praticante das artes da negocição, oratória, retórica, e "
														+ "sofisma. Você pode rolar +1d6 em todos os seus testes que envolvam "
														+ "comércio e outras negociações.");
	public final static Habilidade DIVERSIDADE = new Habilidade("Diversidade", "Suporte", "Característica", null, -1, -1,
														"Você focou seus esforços e interesse em uma ampla gama de atividades. "
														+ "Escolha um Atributo diferente do que escolheu para Adaptabilidade. "
														+ "Você tem +1 nesse Atributo.");
	public final static Habilidade O_DOBRO_OU_NADA = new Habilidade("O Dobro ou Nada", "Reação", "Característica", "Sorte",
														20, -1,
														"Você está acostumado à dar chance para sua sorte - às vezes, além do "
														+ "que seria considerado saudável. Quando falhar em um teste, você pode "
														+ "fazer o teste novamente, ignorando completamente o primeiro resultado. "
														+ "No cso de sucesso, além de passar no teste, qualquer efeito numérico "
														+ "proveniente do sucesso (dano causado por um ataque, duração de uma "
														+ "magia, PVs curados com uso de primeiros socorros, etc.) é dobrado. "
														+ "Mas se o teste for uma falha, ela deve ser considerada como uma falha "
														+ "crítica, com todos os seus possíveis efeitos numéricos dobrados. No "
														+ "caso de uma falha crítica nesse teste, o Mestre deve considerar que o "
														+ "fracasso foi uma falha crítica particularmente desastrosa - com efeitos "
														+ "limitados apenas pela sua imaginação sádica.\n"
														+ "\tVocê só pode usar essa Habilidade uma vez por turno.");
	public final static Habilidade GREGARIO = new Habilidade("Gregário", "Suporte", "Característica", null, -1, -1,
														"Você consegue compreender muito rapidamente as estruturas sociais de uma "
														+ "cultura e seus indivíduos e é capaz de fazer amigos em qualquer lugar. "
														+ "Depois de cinco minutos de conversa, a pessoa com quem você estaja "
														+ "interagindo - e que não seja obviamente hostil a você, como um captor "
														+ "ou um inimigo jurado - torna-se propensa a ajudá-lo. Essa Habilidade "
														+ "geralmente serve para colher informações gerais (apesar de segredos "
														+ "não serem possíveis de conseguir) ou pequenos favores - como ser "
														+ "apresentado a alguém ou conseguir uma cerveja de graça. Você também "
														+ "recebe +2 em testes de seduzir, mentir, detectar mentiras ou qualquer "
														+ "outra interação social.");
	public final static Habilidade SORTE = new Habilidade("Sorte", "Reação", "Característica", null, 10, -1,
														"Você está acostumado a contar com a sorte - e ela costuma lhe sorrir. "
														+ "Você pode rolar novamente um dado cujo resultado seja 1. Você só "
														+ "");
	
	
	/// Classes
	// Guerreiro
	
	// Habilidade Automática
	public final static Habilidade MESTRE_DE_ARMAS_1 = new Habilidade("Mestre de Armas 1", "Suporte", "Técnica", null, -1, -1,
														"Você é particulamente eficiente no uso de armas brancas. Sempre que "
														+ "realizar um ataque corporal bem sucedido, adicione 3 ao dano do ataque.");
	// Habilidades Básicas
	
	// Habilidades Básicas
	public final static Habilidade ANULAR_GOLPE = new Habilidade("Anular Golpe", "Reação", "Técnica", "Defesa Agressiva", 0, -1,
														"Você se especializou em perceber e evitar os ataques mais complexos dos "
														+ "seus adversários. Sempre que um oponente utilizar uma Habilidade de "
														+ "Aão do tipo Técnica, você pode evitar totalmente seus efeitos "
														+ "(incluindo o dano). O custo dessa Habilidade é o mesmo da Técnica a "
														+ "ser evitada.\n"
														+ "\tVocê só pode utilizar essa Habilidade 1 vez por turno.");
	public final static Habilidade ATAQUE_DO_BUFALO = new Habilidade("Ataque do Búfalo", "Ação", "Técnica", null, 10, -1,
														"Faça uma manobra de encontrão. Se acertar o ataque, além de causar o dano "
														+ "normal pelo encontrão, o alvo precisa vencer um teste de Força "
														+ "(Dificuldade igual à sua Determinação mais a FN da arma que estiver "
														+ "usando) ou será derruvado. Alvos com o dobro do seu peso não são afetados.");
	public final static Habilidade ATAQUE_GIRATORIO = new Habilidade("Ataque Giratório", "Ação", "Técnica", null, 10, -1,
														"Você realiza um ataque amplo, girando sua arma para atingir todos os "
														+ "oponentes próximos. Faça um ataque corporal contra cada alvo dentro do "
														+ "seu alcance corporal.");
	public final static Habilidade ATAQUE_SIMULTANEO = new Habilidade("Ataque Simultâneo", "Ação", "Técnica", "Combate em Grupo", 20, -1,
														"Você está acostumado a lutar em grupo e sabe como abrir a guarda de um "
														+ "adversário para que seus aliados possam atingi-lo. Faça um ataque corporal "
														+ "contra um oponente. Se acertar, todos aliados que estiverem adjacentes ao "
														+ "mesmo oponente poderão fazer um ataque corporal normal contra ele "
														+ "imediatamente.");
	public final static Habilidade BRIGAO = new Habilidade("Brigão", "Suporte", "Característica", null, -1, -1,
														"Você está acostumado à combater desarmado. Você rola +1 em seus ataques "
														+ "desarmados e adiciona +2 nos danos desses ataques.");
	public final static Habilidade COMBATE_EM_GRUPO = new Habilidade("Combate em Grupo", "Reação", "Técnica", null, -1, -1,
														"Você ganha +1 nos testes de ataques corporais para cada aliado que "
														+ "estaja em combate corporal com o alvo");
	public final static Habilidade COMBATE_COM_DUAS_ARMAS_1 = new Habilidade("Combate com Duas Armas 1", "Suporte", "Técnica", null, -1, -1,
														"Você treinou para usar duas armas em combate de forma eficiente. Você pode fazer "
														+ "um ataque para cada arma que estiver segurando, desde que pelo menos uma delas "
														+ "tenha uma FN igual à metade (ou menos) do que a Força do personagem.\n"
														+ "\tEspecial: Se você utilizar uma Habilidade de Ação, seus efeitos se aplicam a "
														+ "apenas um dos seus ataques - mas você ainda pode fazer um ataque normal com a "
														+ "outra arma no mesmo turno, antes ou depois de utilizar a Habilidade de Ação.");
	public final static Habilidade COMBATE_PESADO = new Habilidade("Combate Pesado", "Reação", "Técnica", "Combate Tático", 10, -1,
														"Sempre que você fizer uma manobra de encontrão ou um ataque corporal "
														+ "enquanto estiver portando uma arma de duas mãos ou um escudo, você pode "
														+ "rolar novamente 1 dos dados em seus testes de ataque.\n"
														+ "\tVocê pode escolher com qual dos resultados vai ficar.\n"
														+ "\tVocê só pode usar esta Habilidade 1 vez por turno.");
	public final static Habilidade COMBATE_TATICO = new Habilidade("Combate Tático", "Reação", "Técnica", null, -1, -1,
														"Se você derrotar um oponente com um ataque corporal, você pode "
														+ "imediatamente realizar outro ataque corporal normal.");
	public final static Habilidade DEFESA_AGRESSIVA = new Habilidade("Defesa Agressiva", "Suporte", "Técnica", "Defletor", -1, -1,
														"Você entende que a melhor defesa é uma ataque eficiente. Quando estiver "
														+ "empunhando uma arma corporal de duas mãos, duas armas corporais ou "
														+ "um escudo, você recebe +1 em seus testes de ataque corporal e +1 na "
														+ "sua Defesa.\n"
														+ "\tEsse bônus de Defesa é considerado um bônus de Bloqueio.");
	public final static Habilidade DEFLETOR = new Habilidade("Defletor", "Suporte", "Técnica", null, -1, -1,
														"Você está acostumado a se defender de projéteis. Enquanto estiver "
														+ "empunhando uma arma corporal de duas mãos, duas armas corporais ou "
														+ "um escudo, você receber +2 no seu bônus de Bloqueio contra ataques à "
														+ "distância.\n"
														+ "\tEsse bônus de Defesa é considerado um bônus de Bloqueio.");
	public final static Habilidade ESTABILIDADE = new Habilidade("Estabilidade", "Suporte", "Característica", null, -1, -1,
														"Você gosta de ter os dois pés solidamente plantados no chão - e faz isso "
														+ "muito bem! Você sempre rola +1d6 em todos os seus testes de evitar "
														+ "quedas e manter o equilíbrio.");
	public final static Habilidade GOLPE_DEVASTADOR_1 = new Habilidade("Golpe Devastador 1", "Ação", "Técnica", "Nocautear", 30, -1,
														"Você pode fazer um ataque corporal que causa o dobro de dano, e se "
														+ "acertar, o alvo precisa vencer um confronto de Força (adicione a FN "
														+ "da arma que estiver usando no seu teste) contra você ou ficará Paralisado "
														+ "(veja Condições na página 169) por um turno.");
	public final static Habilidade GOLPE_COM_ESCUDO = new Habilidade("Golpe com Escudo", "Ação", "Técnica", null, 5, -1,
														"Se você estiver portando um escudo e errar um ataque corporal com sua "
														+ "arma, você poder imediatamente fazer um ataque corporal normal contra "
														+ "o mesmo alvo com seu escudo. Um ataque com um escudo causa dano igual "
														+ "à Força + FN do escudo/Contusão.");
	public final static Habilidade GRITO_DE_GUERRA_1 = new Habilidade("Grito de Guerra 1", "Ação", null, null, 10, -1,
														"Você pode dar um grito fervoroso que motiva todos seus aliados que "
														+ "estiverem em um raio de 5 metros recebem +1 em todas as rolagens "
														+ "até o final da batalha. Além disso, remova todos os efeitos de Medo "
														+ "de todos os aliados dentro da área dessa Habilidade.\n"
														+ "\tVocê não pode usar esta Habilidade se estiver sob qualquer "
														+ "efeito de medo.");
	public final static Habilidade GUERREIRO_DE_AÇO_1 = new Habilidade("Guerreiro de Aço 1", "Suporte", "Característica", null, -1, -1,
														"Você estáa acostumado a usar armaduras pesadas. Você considera a FN de "
														+ "qualuqer armadura com a Característica Pesada com tendo FN-1 para "
														+ "todos os propósitos.");
	public final static Habilidade INVESTIDA_MORTAL = new Habilidade("Investida Mortal", "Ação", "Técnica", null, 10, -1,
														"Faça uma manobra de encontrão contra um alvo. Se acertar, esse ataque "
														+ "causa +10 de dano e deia o alvo Atordoado (veja Condições na página "
														+ "169) por 1 turno.");
	public final static Habilidade NOCAUTEAR = new Habilidade("Nocautear", "Ação", "Técnica", null, 10, -1,
														"Façã um ataque corporal que causa dano por Contusão. Se acertar, além de sofrer o dano normal "
														+ "do ataque, o alvo fica Paralisado (veja Condições na página 169) por 1 turno.");
	public final static Habilidade PAREDE_DE_ESCUDOS = new Habilidade("Parede de Escudos", "Suporte", "Técnica", null, -1, -1,
														"Você está acostumado a lutar em grupo e usar seu escudo para proteger seus aliados. Enquanto "
														+ "você estiver usando um escudo, todos os aliados adjacentes a você recebem um bônus de +1 "
														+ "na Defesa.\n"
														+ "\tEste é um bônus de Bloqueio.");
	public final static Habilidade SEM_ESCAPATORIA = new Habilidade("Sem Escapatória", "Reação", "Técnica", "Combate Tático", -1, -1,
														"Se um oponente que está adjacente a você tentar se afastar ou se levantar, você pode "
														+ "imediatamente fazer um ataque corporal normal contra ele. Se acertar, além de sofrer o dano "
														+ "normal pelo ataque, o oponente não poderá se movimentar neste turno.");
	public final static Habilidade TRANSPOR = new Habilidade("Transpor", "Suporte", "Técnica", "Defesa Agressiva", -1, -1,
														"Você sabe encontrar os espaços deiados pelo escudo do adversário. Ignore sempre o bônus "
														+ "de Bloqueio da Defesa do oponente.");
	
	// Habilidade Avançadas
	// Habilidades Avançadas
	public final static Habilidade COMBATE_COM_DUAS_ARMAS_2 = new Habilidade("Combate com Duas Armas 2", "Suporte", "Técnica", "Nível 5, Combater com Duas Armas 1", -1, -1,
														"Como em Combate com Duas Armas 1, mas você pode usar duas armas com a mesma FN.\n"
														+ "\tEspecial: Se você utilizar uma Habilidade de Ação, seus efeitos se aplicam a apenas "
														+ "um dos seus ataques - mas você ainda pode fazer um ataque normal com a outra arma no mesmos "
														+ "turno, antes ou depois de utilizar a Habilidade de Ação");
	public final static Habilidade FORCA_DE_EXPLOSAO = new Habilidade("Força de Explosão", "Suporte", "Característica", "Nível 5, Ataque do Búfalo", -1, -1,
														"Quando fizer ataques que têm chance de derrubar o oponente você pode afetar alvos até 10 vezes "
														+ "mais pesados do que você (a maioria dos ataques que derrubam oponentes só afetam alvos com até "
														+ "o dobro do seu peso).\n"
														+ "\tAlém disso, se você usar qualquer Habilidade que derrube o oponente, a dificuldade para "
														+ "resistir ao efeito é aumentada em +2.");
	public final static Habilidade GOLPE_DEVASTADOR_2 = new Habilidade("Golpe Devastador 2", "Ação", "Técnica", "Nível 5, Golpe Devastador 1", 60, -1,
														"Faça um ataque corporal contra o alvo. Se acertar, o ataque causa o triplo do dano normal e o "
														+ "alvo precisa vencer um confronto de Força (adicione a FN da arma que estiver usando no seu "
														+ "teste) contra você ou ficará Paralisado (veja Condições na página 169) por um turno.");
	public final static Habilidade GRITO_DE_GUERRA_2 = new Habilidade("Grito de Guerra 2", "Ação", null, "Nível 5, Grito de Guerra 1", 15, -1,
														"Você pode dar um grito fervoroso que motiva todos seus aliados. Você e todos os seus aliados em "
														+ "um raio de 10 metros recebem +2 em todas as rolagens até o final da batalha. Além disso, "
														+ "remova todos os efeitos de Medo de todos os aliados dentro da área dessa Habilidade.\n"
														+ "\tVocê não pode usar esta Habilidade se estiver sob qualquer efeito de Medo.");
	public final static Habilidade GRITO_DE_INTIMIDACAO = new Habilidade("Grito de Intimidação", "Ação", null, "Nível 5, Grito de Guerra 1", 35, -1,
														"Você pode dar um grito para intimidar seus inimigos. Todos os oponentes que estiverem a até "
														+ "10 metros à sua frente que tiverem uma Determinação menor do que a sua ficam Paralisados "
														+ "(veja Condições na página 169) por 2 turnos.\n"
														+ "\tEsse é um efeito de Medo.");
	public final static Habilidade GUERREIRO_DE_ACO_2 = new Habilidade("Guerreiro de Aço 2", "Suporte", "Característica", "Nível 5, Guerreiro de Aço 1", -1, -1,
														"Você está extremamente acostumado a usar armaduras pesadas e se sente confortável quando verga uma. "
														+ "Você considera a FN de Qualquer armadura com a Característica Pesada como tendo FN-1 para todos os "
														+ "propósitos.\n"
														+ "\tEssa redução se acumula com a redução fornecida por Guerreiro de Aço 1.");
	public final static Habilidade IMPLACAVEL = new Habilidade("Implacável", "Suporte", "Característica", "Nível 5, Sem Escapatória", -1, -1,
														"Sempre que errar um ataque corporal, você causa metade do dano normal do ataque (arredondando "
														+ "para baixo).");
	public final static Habilidade INVESTIDA_FORTE = new Habilidade("Investida Forte", "Suporte", null, "Nível 5, Golpe com Escudo", -1, -1,
														"Sempre que acertar uma manobra de encontrão usando um esudo, o alvo precisa vencer um teste de "
														+ "Resistência (Dificuldade igual à sua Determinação + a FN do escudo que você estiver usando) "
														+ "ou será derrubado. Alvos com o dobro do seu peso não são afetados. Um ataque com um escudo "
														+ "causa dano igual à Força + FN do escudo/Contusão.");
	public final static Habilidade MESTRE_DE_ARMAS_2 = new Habilidade("Mestre de Armas 2", "Suporte", "Técnica", "Nível 5", -1, -1,
														"Você é extremamente eficaz no uso de armas brancas. Sempre que acertar um ataque corporal "
														+ "adicione 3 ao dano do ataque.\n"
														+ "\tEsse bônus de dano se acumula com o bônus fornecido por Mestre das Armas 1.");
	public final static Habilidade VALOR_DA_VITORIA = new Habilidade("Valor da Vitória", "Reação", "Característica", "Nível 5", -1, -1,
														"Cada vez que você derrota um oponente (isso inclui se ele se render ou fugir após a batalha) "
														+ "você recupera 5 pontos de vida e 5 pontos de mana.");
	
	// Habilidade Final
	// Habilidade Final
	public final static Habilidade MESTRE_DE_ARMAS_3 = new Habilidade("Mestre em Armas 3", "Ação", "Técnica", "Nível 10, Mestre de Armas 2", 50, -1,
														"Faça um ataque corporal contra uma criatura. Se o ataque acertar o alvo, ao invés do dano normal "
														+ "da arma, os Pontos de Vida atuais dele são reduzidos à metade. No caso de um sucesso crítico "
														+ "no ataque, o oponente é morto instantaneamente.");
}
