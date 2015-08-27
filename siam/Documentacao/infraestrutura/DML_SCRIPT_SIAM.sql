-- phpMyAdmin SQL Dump
-- version 4.0.10.9
-- http://www.phpmyadmin.net
--
-- Máquina: 127.13.35.130:3306
-- Data de Criação: 28-Mar-2015 às 17:49
-- Versão do servidor: 5.5.41
-- versão do PHP: 5.3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de Dados: `siam`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `consulta`
--

CREATE TABLE IF NOT EXISTS `consulta` (
  `idconsulta` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_consulta` date DEFAULT NULL,
  `tipo_consulta` bigint(20) DEFAULT NULL,
  `fk_medico` bigint(20) DEFAULT NULL,
  `fk_paciente` bigint(20) DEFAULT NULL,
  `fk_resumo` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`idconsulta`),
  KEY `FKDE2881F55568A1B3` (`fk_resumo`),
  KEY `FKDE2881F51F1BFAE7` (`fk_paciente`),
  KEY `FKDE2881F5444A2BD7` (`fk_medico`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `consulta`
--

INSERT INTO `consulta` (`idconsulta`, `data_consulta`, `tipo_consulta`, `fk_medico`, `fk_paciente`, `fk_resumo`) VALUES
(1, '2009-10-29', 0, 1, 1, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `consultorio`
--

CREATE TABLE IF NOT EXISTS `consultorio` (
  `idconsultorio` bigint(20) NOT NULL AUTO_INCREMENT,
  `endereco` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idconsultorio`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `consultorio`
--

INSERT INTO `consultorio` (`idconsultorio`, `endereco`, `nome`) VALUES
(1, 'Rua Padre eustáquio 879', 'Crer cendo');

-- --------------------------------------------------------

--
-- Estrutura da tabela `convenio`
--

CREATE TABLE IF NOT EXISTS `convenio` (
  `idconvenio` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `perc_cobertura` int(11) DEFAULT NULL,
  PRIMARY KEY (`idconvenio`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `convenio`
--

INSERT INTO `convenio` (`idconvenio`, `nome`, `perc_cobertura`) VALUES
(1, 'Bradesco Saude', 50);

-- --------------------------------------------------------

--
-- Estrutura da tabela `hist_fator_risco`
--

CREATE TABLE IF NOT EXISTS `hist_fator_risco` (
  `idhist_fator_risco` bigint(20) NOT NULL AUTO_INCREMENT,
  `auto_avaliacao` varchar(255) DEFAULT NULL,
  `colesterol` int(11) DEFAULT NULL,
  `dt_coleta` date DEFAULT NULL,
  `diabetes` tinyint(1) DEFAULT NULL,
  `gramas_alcool_dia` int(11) DEFAULT NULL,
  `gramas_fruta_dia` int(11) DEFAULT NULL,
  `hipertensao` tinyint(1) DEFAULT NULL,
  `imc` int(11) DEFAULT NULL,
  `minutos_ativ_fisica` int(11) DEFAULT NULL,
  `tabagista` tinyint(1) DEFAULT NULL,
  `ant_concep_oral` tinyint(1) DEFAULT NULL,
  `fk_paciente` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`idhist_fator_risco`),
  KEY `FK36E025A81F1BFAE7` (`fk_paciente`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `hist_fator_risco`
--

INSERT INTO `hist_fator_risco` (`idhist_fator_risco`, `auto_avaliacao`, `colesterol`, `dt_coleta`, `diabetes`, `gramas_alcool_dia`, `gramas_fruta_dia`, `hipertensao`, `imc`, `minutos_ativ_fisica`, `tabagista`, `ant_concep_oral`, `fk_paciente`) VALUES
(1, 'Bem', 100, '2014-10-05', 1, 0, 50, 1, 100, 50, 0, 0, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `medico`
--

CREATE TABLE IF NOT EXISTS `medico` (
  `especialidade` varchar(255) DEFAULT NULL,
  `idpessoa` bigint(20) NOT NULL,
  `fk_consultorio` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`idpessoa`),
  KEY `FKBFBE8D49740DC4B4` (`idpessoa`),
  KEY `FKBFBE8D49435A9A45` (`fk_consultorio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `medico`
--

INSERT INTO `medico` (`especialidade`, `idpessoa`, `fk_consultorio`) VALUES
('Clinico Geral', 1, 1),
('Geriatra', 2, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `paciente`
--

CREATE TABLE IF NOT EXISTS `paciente` (
  `altura` int(11) DEFAULT NULL,
  `nome_mae` varchar(255) DEFAULT NULL,
  `nome_pai` varchar(255) DEFAULT NULL,
  `idpessoa` bigint(20) NOT NULL,
  `fk_convenio` bigint(20) DEFAULT NULL,
  `fk_hist_risco` bigint(20) DEFAULT NULL,
  `fk_medico` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`idpessoa`),
  KEY `FK2CA713718264E58B` (`fk_convenio`),
  KEY `FK2CA713717082B348` (`fk_hist_risco`),
  KEY `FK2CA71371740DC4B4` (`idpessoa`),
  KEY `FK2CA71371444A2BD7` (`fk_medico`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `paciente`
--

INSERT INTO `paciente` (`altura`, `nome_mae`, `nome_pai`, `idpessoa`, `fk_convenio`, `fk_hist_risco`, `fk_medico`) VALUES
(180, 'Claricelia', 'Jose', 1, 1, 1, 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `peso`
--

CREATE TABLE IF NOT EXISTS `peso` (
  `idpeso` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_peso` datetime DEFAULT NULL,
  `valor` int(11) DEFAULT NULL,
  `fk_hist_risco` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`idpeso`),
  KEY `FK3473117082B348` (`fk_hist_risco`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- Extraindo dados da tabela `peso`
--

INSERT INTO `peso` (`idpeso`, `data_peso`, `valor`, `fk_hist_risco`) VALUES
(1, '2009-05-10 00:00:00', 50, 1),
(2, '2009-09-10 00:00:00', 56, 1),
(3, '2010-05-05 00:00:00', 67, 1),
(4, '2011-04-15 00:00:00', 72, 1),
(5, '2012-11-21 00:00:00', 70, 1),
(6, '2013-04-14 00:00:00', 66, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoa`
--

CREATE TABLE IF NOT EXISTS `pessoa` (
  `idpessoa` bigint(20) NOT NULL AUTO_INCREMENT,
  `bairro` varchar(255) DEFAULT NULL,
  `cep` varchar(255) DEFAULT NULL,
  `cpf` bigint(20) DEFAULT NULL,
  `idade` int(11) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `rua` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  `sexo` varchar(255) DEFAULT NULL,
  `telefone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idpessoa`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Extraindo dados da tabela `pessoa`
--

INSERT INTO `pessoa` (`idpessoa`, `bairro`, `cep`, `cpf`, `idade`, `nome`, `rua`, `senha`, `sexo`, `telefone`) VALUES
(1, 'Carlos Prates', '30710550', 9101060618, 28, 'Bruno Serqueira', 'Cambuquira 870', '123', 'Masculino', '32672202'),
(2, 'Padre Eustáquio', '30750100', 19809211029, 57, 'Marcos Silva', 'Rua Itororo 30', '123', 'Masculino', '32871111'),
(3, 'Padre Eustáquio', '30750300', 19809211029, 57, 'Silvio Luiz', 'Rua tramis 330', '123', 'Masculino', '33132211'),
(4, 'Dom Bosco', '30333100', 98777881922, 76, 'Firmino cardoso', 'Avenida 103', '123', 'Masculino', '32871111');

-- --------------------------------------------------------

--
-- Estrutura da tabela `pressao`
--

CREATE TABLE IF NOT EXISTS `pressao` (
  `idpressao` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_pressao` datetime DEFAULT NULL,
  `valor_diastolica` int(11) DEFAULT NULL,
  `valor_sistolica` int(11) DEFAULT NULL,
  `fk_hist_risco` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`idpressao`),
  KEY `FKED07ABB17082B348` (`fk_hist_risco`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- Extraindo dados da tabela `pressao`
--

INSERT INTO `pressao` (`idpressao`, `data_pressao`, `valor_diastolica`, `valor_sistolica`, `fk_hist_risco`) VALUES
(1, '2010-04-10 00:00:00', 10, 11, 1),
(2, '2011-04-10 00:00:00', 12, 11, 1),
(3, '2012-05-10 00:00:00', 13, 11, 1),
(4, '2013-04-10 00:00:00', 12, 11, 1),
(5, '2014-05-10 00:00:00', 14, 12, 1),
(6, '2014-09-25 00:00:00', 14, 12, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `resumo`
--

CREATE TABLE IF NOT EXISTS `resumo` (
  `idresumo` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_resumo` datetime DEFAULT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `id_consulta` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`idresumo`),
  KEY `FKC84DC83792CAD859` (`id_consulta`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `resumo`
--

INSERT INTO `resumo` (`idresumo`, `data_resumo`, `descricao`, `id_consulta`) VALUES
(1, '2014-10-23 00:00:00', 'paciente apresenta melhora', 1);

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `consulta`
--
ALTER TABLE `consulta`
  ADD CONSTRAINT `FKDE2881F51F1BFAE7` FOREIGN KEY (`fk_paciente`) REFERENCES `paciente` (`idpessoa`),
  ADD CONSTRAINT `FKDE2881F5444A2BD7` FOREIGN KEY (`fk_medico`) REFERENCES `medico` (`idpessoa`),
  ADD CONSTRAINT `FKDE2881F55568A1B3` FOREIGN KEY (`fk_resumo`) REFERENCES `resumo` (`idresumo`);

--
-- Limitadores para a tabela `hist_fator_risco`
--
ALTER TABLE `hist_fator_risco`
  ADD CONSTRAINT `FK36E025A81F1BFAE7` FOREIGN KEY (`fk_paciente`) REFERENCES `paciente` (`idpessoa`);

--
-- Limitadores para a tabela `medico`
--
ALTER TABLE `medico`
  ADD CONSTRAINT `FKBFBE8D49435A9A45` FOREIGN KEY (`fk_consultorio`) REFERENCES `consultorio` (`idconsultorio`),
  ADD CONSTRAINT `FKBFBE8D49740DC4B4` FOREIGN KEY (`idpessoa`) REFERENCES `pessoa` (`idpessoa`);

--
-- Limitadores para a tabela `paciente`
--
ALTER TABLE `paciente`
  ADD CONSTRAINT `FK2CA71371444A2BD7` FOREIGN KEY (`fk_medico`) REFERENCES `medico` (`idpessoa`),
  ADD CONSTRAINT `FK2CA713717082B348` FOREIGN KEY (`fk_hist_risco`) REFERENCES `hist_fator_risco` (`idhist_fator_risco`),
  ADD CONSTRAINT `FK2CA71371740DC4B4` FOREIGN KEY (`idpessoa`) REFERENCES `pessoa` (`idpessoa`),
  ADD CONSTRAINT `FK2CA713718264E58B` FOREIGN KEY (`fk_convenio`) REFERENCES `convenio` (`idconvenio`);

--
-- Limitadores para a tabela `peso`
--
ALTER TABLE `peso`
  ADD CONSTRAINT `FK3473117082B348` FOREIGN KEY (`fk_hist_risco`) REFERENCES `hist_fator_risco` (`idhist_fator_risco`);

--
-- Limitadores para a tabela `pressao`
--
ALTER TABLE `pressao`
  ADD CONSTRAINT `FKED07ABB17082B348` FOREIGN KEY (`fk_hist_risco`) REFERENCES `hist_fator_risco` (`idhist_fator_risco`);

--
-- Limitadores para a tabela `resumo`
--
ALTER TABLE `resumo`
  ADD CONSTRAINT `FKC84DC83792CAD859` FOREIGN KEY (`id_consulta`) REFERENCES `consulta` (`idconsulta`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
