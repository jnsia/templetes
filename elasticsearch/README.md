
```
docker run --name elasticsearch \
-p 9200:9200 -p 9300:9300 \
-e ELASTIC_USERNAME=localuser \
-e ELASTIC_PASSWORD=password \
-e node.name=es-node \
-e cluster.name=search-cluster \
-e discovery.type=single-node \
-e xpack.security.enabled=false \
-e xpack.security.http.ssl.enabled=false \
-e xpack.security.transport.ssl.enabled=false \
elasticsearch:8.15.5
```