docker-build: build
	docker build . -t report-creator:latest	

docker-run: docker-build
	docker run -v $(HOME)/data/in:/input -v $(HOME)/data/out:/output report-creator:latest

build:
	mvn clean install -Dmaven.test.skip=false
