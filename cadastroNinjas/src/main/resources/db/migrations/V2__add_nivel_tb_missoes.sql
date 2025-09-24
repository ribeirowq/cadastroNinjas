-- V2: migration para adicionar a coluna nivel na tabela de missoes

ALTER TABLE tb_missoes
ADD COLUMN nivel VARCHAR(1);