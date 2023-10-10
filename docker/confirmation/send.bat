SET message=message.json
call docker cp %message% camunda_kafka:/%message%
call docker exec -it camunda_kafka /bin/bash -c "cat %message% | tr -d '\r\n' | kafka-console-producer.sh --broker-list localhost:9092 --topic brokerage-provider-agreement-confirmation"