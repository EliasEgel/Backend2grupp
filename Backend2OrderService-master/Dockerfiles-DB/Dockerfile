FROM mysql:8

ENV MYSQL_DATABASE ordersdb
ENV MYSQL_RANDOM_ROOT_PASSWORD yes
ENV MYSQL_USER springuser
ENV MYSQL_PASSWORD ThePassword

COPY ../sql /docker-entrypoint-initdb.d/
EXPOSE 3306