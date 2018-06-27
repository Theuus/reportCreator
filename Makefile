docker-build: build
	docker build . -t report-creator:latest	

docker-run: docker-build
	docker run -v /tmp/input:/input -v /tmp/output:/output report-creator:latest

build:
	mvn clean install -Dmaven.test.skip=true
