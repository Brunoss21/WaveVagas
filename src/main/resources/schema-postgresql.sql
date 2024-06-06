CREATE TABLE IF NOT EXISTS vaga (
     id serial PRIMARY KEY,
     titulo  varchar(50),
     descricao   text,
     dataPublic  date,
     salario decimal(10, 2)
);
