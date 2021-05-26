FROM alpine:latest
RUN apk update && \
	apk upgrade && \
	apk add --no-cache --update \
	wget \
	gcc \
	g++ \
	make \
	git \
	openjdk11-jdk \
	vim \
	tmux \
	bash

ENV JAVA_HOME=/usr/lib/jvm/java-11-openjdk
ENV PATH="$JAVA_HOME/bin:${PATH}"

WORKDIR /root

COPY ./.vimrc ./
COPY ./mecab-0.996.tar.gz ./
COPY ./mecab-ipadic-2.7.0-20070801.tar.gz ./

RUN tar zxvf mecab-0.996.tar.gz
WORKDIR /root/mecab-0.996

RUN ./configure --with-charset=utf8 && \
make && \
make install

WORKDIR /root

RUN tar zxvf mecab-ipadic-2.7.0-20070801.tar.gz

WORKDIR /root/mecab-ipadic-2.7.0-20070801
RUN ./configure --with-charset=utf8 && \
make && \
make install

WORKDIR /root

RUN git clone https://github.com/Rashoru-Infinity/advanced_1a_nlp.git

CMD tail -f /dev/null
