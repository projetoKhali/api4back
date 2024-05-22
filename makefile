start-db:
	docker-compose up -d

stop-db:
	docker-compose down

create-db:
	docker exec -it api4back-khali-1 psql -U postgres -d postgres -f db/postgres_version.sql
	docker exec -it api4back-khali-1 psql -U postgres -d postgres -f db/postgres_seeds.sql
	docker exec -it api4back-khali-1 psql -U postgres -d postgres -f db/postgres_views.sql