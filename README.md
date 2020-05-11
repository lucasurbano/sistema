
# Sistema de Login - MVP

Sistema de cadastro de login

## Ferramentas 

    - #### Eclipse 

## Tecnologias

    - #### Java 8 
    - #### PostgreSQL 12
    - #### Apache Tomcat 9

## Deploy
   
Há a  integração entre o Git e Heroku oferecidas. 

#### GitHub

Integrado repositório ao Heroku

![](https://miro.medium.com/max/511/1*uTTnZVEnZcXO8mIaOGIjtg.jpeg)

*Deploy manual* -  Após o codigo encontrar no GitHub é possivel realizar deploy. 

Porém  será necessário adicionar o trecho abaixo no pom.xml : 

```xml
	<build>
		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.5.1</version>
				<configuration>
					<source>1.8</source>
					<target>1.8</target>
				</configuration>
			</plugin>
			<!-- Webapp Runner -->
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-dependency-plugin</artifactId>
				<executions>
					<execution>
						<phase>package</phase>
						<goals>
							<goal>copy</goal>
						</goals>
						<configuration>
							<artifactItems>
								<artifactItem>
									<groupId>com.heroku</groupId>
									<artifactId>webapp-runner</artifactId>
									<version>9.0.30.0</version>
									<destFileName>webapp-runner.jar</destFileName>
								</artifactItem>
							</artifactItems>
						</configuration>
					</execution>
				</executions>
			</plugin>
		</plugins>
	</build>
	
```

E criação do arquivo Procfile na raiz do projeto com o seguinte comando

```bash
web: java $JAVA_OPTS -jar target/dependency/webapp-runner.jar --port $PORT target/*.war
```


## Feature Future

*Usuario* -  Adicionar mais que um telfone ao cadastro.
