FROM ubuntu:focal
ENV DEBIAN_FRONTEND=noninteractive
RUN apt update && \
	apt -y install wget \
	gcc \
	g++ \
	make \
	git \
	vim

WORKDIR /root

COPY ./mecab-0.996.tar.gz ./
COPY ./mecab-ipadic-2.7.0-20070801.tar.gz ./

RUN tar zxvf mecab-0.996.tar.gz
WORKDIR /root/mecab-0.996

RUN ./configure --with-charset=utf8 && \
make && \
make install && \
ldconfig

WORKDIR /root

RUN tar zxvf mecab-ipadic-2.7.0-20070801.tar.gz

WORKDIR /root/mecab-ipadic-2.7.0-20070801
RUN ./configure --with-charset=utf8 && \
make && \
make install

ENV DEBIAN_FRONTEND=newt

CMD tail -f /dev/null
