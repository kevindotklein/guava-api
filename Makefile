build:
	@go build -o bin/guava-api

run: build
	@./bin/guava-api

test:
	@go test -v ./...