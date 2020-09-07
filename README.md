# smic-zipkin

Sample Spring boot services via Zipkin&Sleuth to trace rest-calls and identifying
how much time any service calls and see whether there is a problem or not.

### How to Start

``
docker-compose up
``

### How to Stop

``
docker-compose down
``

## Endpoints

- `curl http://localhost:8081/zipkin`
- `curl http://localhost:8082/zipkin2`
- `curl http://localhost:8083/zipkin3`
- `curl http://localhost:8084/zipkin4`

## License

This project is available as open source under the terms of the [MIT License](http://opensource.org/licenses/MIT).