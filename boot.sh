docker build -t what-next .
docker-compose up db
docker exec -it db psql -U postgres -c "CREATE DATABASE WHAT_NEXT;"
docker-compose up app