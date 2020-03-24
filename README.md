# Bookshelf

## Instalação
### Requisitos backend

1. Java - 1.8.x
2. Maven - 3.x.x
3. Mysql - 5.x.x

### Etapas para a instalação

**1. Clonar a aplicação**

```bash
git clone https://github.com/meloafc/bookshelf.git
```

**2. Configurar o Mysql**
```bash
create database bookshelf
```

**3. Configurar usuário e senha do Mysql**

+ Abrir `/backend/src/main/resources/application.properties`

+ Trocar `spring.datasource.url`, `spring.datasource.username` e `spring.datasource.password` por sua configuração.

**4. Executar o backend**

```bash
cd bookshelf/backend
mvn spring-boot:run
```

O backend começará a ser executado em <http://localhost:8080>.

### Requisitos frontend

1. Nodejs - 8.x.x
2. NPM - 5.x.x
3. Angular cli - 9.x.x

**1. Instalar as dependências do frontend**
```bash
cd ../frontend
npm install
```

**2. Configurar usuário e senha do Mysql**

+ Abrir `/frontend/src/environments/environment.ts`

+ Trocar `apiUrl` por sua configuração.

**3. Executar o frontend**
```bash
ng serve
```

O frontend começará a ser executado em http://localhost:4200.