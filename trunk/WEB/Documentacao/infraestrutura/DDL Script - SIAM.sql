SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `siam` DEFAULT CHARACTER SET latin1 ;
USE `siam` ;

-- -----------------------------------------------------
-- Table `siam`.`consultorio`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `siam`.`consultorio` (
  `idconsultorio` INT(11) NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(45) NULL DEFAULT NULL ,
  `endereco` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`idconsultorio`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `siam`.`medico`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `siam`.`medico` (
  `idpessoa` INT(11) NOT NULL AUTO_INCREMENT ,
  `especialidade` VARCHAR(45) NULL DEFAULT NULL ,
  `fk_consultorio` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`idpessoa`) ,
  INDEX `fk_consultorio_medico` (`fk_consultorio` ASC) ,
  CONSTRAINT `fk_consultorio_medico`
    FOREIGN KEY (`fk_consultorio` )
    REFERENCES `siam`.`consultorio` (`idconsultorio` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `siam`.`convenio`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `siam`.`convenio` (
  `idconvenio` INT(11) NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(45) NULL DEFAULT NULL ,
  `perc_cobertura` FLOAT NULL DEFAULT NULL ,
  PRIMARY KEY (`idconvenio`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `siam`.`paciente`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `siam`.`paciente` (
  `idpessoa` INT(11) NOT NULL AUTO_INCREMENT COMMENT '	' ,
  `nome_pai` VARCHAR(45) NULL DEFAULT NULL ,
  `nome_mae` VARCHAR(45) NULL DEFAULT NULL ,
  `altura` FLOAT NULL DEFAULT NULL ,
  `fk_convenio` INT(11) NULL DEFAULT NULL ,
  `fk_hist_risco` INT(11) NULL DEFAULT NULL ,
  `fk_medico` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`idpessoa`) ,
  INDEX `fk_medico` (`fk_medico` ASC) ,
  INDEX `fk_convenio` (`fk_convenio` ASC) ,
  CONSTRAINT `fk_convenio`
    FOREIGN KEY (`fk_convenio` )
    REFERENCES `siam`.`convenio` (`idconvenio` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `siam`.`consulta`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `siam`.`consulta` (
  `idconsulta` INT(11) NOT NULL AUTO_INCREMENT ,
  `tipo_consulta` INT(11) NULL DEFAULT NULL ,
  `data_consulta` DATETIME NULL DEFAULT NULL ,
  `fk_medico` INT(11) NULL DEFAULT NULL ,
  `fk_paciente` INT(11) NULL DEFAULT NULL COMMENT '		' ,
  `fk_receita` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`idconsulta`) ,
  INDEX `fk_paciente` (`fk_paciente` ASC) ,
  INDEX `fk_medico` (`fk_medico` ASC) ,
  CONSTRAINT `fk_medico`
    FOREIGN KEY (`fk_medico` )
    REFERENCES `siam`.`medico` (`idpessoa` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_paciente`
    FOREIGN KEY (`fk_paciente` )
    REFERENCES `siam`.`paciente` (`idpessoa` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `siam`.`hist_fator_risco`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `siam`.`hist_fator_risco` (
  `idhist_fator_risco` INT(11) NOT NULL AUTO_INCREMENT ,
  `tabagista` BIT(1) NULL DEFAULT NULL ,
  `gramas_alcool_dia` INT(11) NULL DEFAULT NULL ,
  `gramas_fruta_dia` INT(11) NULL DEFAULT NULL ,
  `minutos_ativ_fisica` INT(11) NULL DEFAULT NULL ,
  `colesterol` INT(11) NULL DEFAULT NULL ,
  `ant_concep_oral` INT(11) NULL DEFAULT NULL ,
  `hipertensao` BIT(1) NULL DEFAULT NULL ,
  `diabetes` INT(11) NULL DEFAULT NULL ,
  `imc` INT(11) NULL DEFAULT NULL ,
  `dt_coleta` DATETIME NULL DEFAULT NULL ,
  PRIMARY KEY (`idhist_fator_risco`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `siam`.`peso`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `siam`.`peso` (
  `idpeso` INT(11) NOT NULL AUTO_INCREMENT ,
  `valor` FLOAT NULL DEFAULT NULL ,
  `data` DATETIME NULL DEFAULT NULL ,
  `fk_hist_risco` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`idpeso`) ,
  INDEX `fk_hist_risco` (`fk_hist_risco` ASC) ,
  CONSTRAINT `fk_hist_risco`
    FOREIGN KEY (`fk_hist_risco` )
    REFERENCES `siam`.`hist_fator_risco` (`idhist_fator_risco` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `siam`.`pessoa`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `siam`.`pessoa` (
  `idpessoa` INT(11) NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(45) NULL DEFAULT NULL ,
  `cpf` BIGINT(20) NULL DEFAULT NULL ,
  `bairro` VARCHAR(45) NULL DEFAULT NULL ,
  `rua` VARCHAR(45) NULL DEFAULT NULL ,
  `telefone` VARCHAR(45) NULL DEFAULT NULL ,
  `cep` VARCHAR(45) NULL DEFAULT NULL ,
  `senha` VARCHAR(45) NULL DEFAULT NULL ,
  `id` DECIMAL(19,0) NOT NULL ,
  PRIMARY KEY (`idpessoa`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `siam`.`pressao`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `siam`.`pressao` (
  `idpressao` INT(11) NOT NULL AUTO_INCREMENT ,
  `valor_sistolica` FLOAT NULL DEFAULT NULL ,
  `valor_diastolico` FLOAT NULL DEFAULT NULL ,
  `data_pressao` DATETIME NULL DEFAULT NULL ,
  `fk_hist_risco` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`idpressao`) ,
  INDEX `fk_hist_risco_pressao` (`fk_hist_risco` ASC) ,
  CONSTRAINT `fk_hist_risco_pressao`
    FOREIGN KEY (`fk_hist_risco` )
    REFERENCES `siam`.`hist_fator_risco` (`idhist_fator_risco` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `siam`.`resumo`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `siam`.`resumo` (
  `idresumo` INT(11) NOT NULL AUTO_INCREMENT ,
  `descricao` VARCHAR(200) NULL DEFAULT NULL ,
  `data_resumo` DATETIME NULL DEFAULT NULL ,
  `fk_consulta` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`idresumo`) ,
  INDEX `fk_consulta_resumo` (`fk_consulta` ASC) ,
  CONSTRAINT `fk_consulta_resumo`
    FOREIGN KEY (`fk_consulta` )
    REFERENCES `siam`.`consulta` (`idconsulta` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
