-- Estrutura da tabela agenda

CREATE TABLE `agenda` (
  `idAgenda` int(11) NOT NULL,
  `Cliente` varchar(200) NOT NULL,
  `Veiculo` varchar(200) NOT NULL,
  `Contato` varchar(15) NOT NULL,
  `Data` varchar(15) NOT NULL,
  `Hora` varchar(15) NOT NULL,
  `Responsavel` varchar(20) NOT NULL,
  `Solicitacao` varchar(250) NOT NULL,
  `Obs` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;


-- Índices para tabela `agenda`
--
ALTER TABLE `agenda`
  ADD PRIMARY KEY (`idAgenda`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `agenda`
--
ALTER TABLE `agenda`
  MODIFY `idAgenda` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
