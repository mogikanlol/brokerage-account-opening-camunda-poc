SET message=message.json
call docker cp %message% kafka:/%message%
call docker exec -it kafka /bin/bash -c "cat %message% | tr -d '\r\n' | kafka-console-producer.sh --broker-list localhost:9092 --topic deposit-provider-agreement-confirmation"