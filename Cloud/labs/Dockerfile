FROM tiangolo/uwsgi-nginx-flask:python3.6  
USER root

COPY ./conf/nginx.conf /etc/nginx/conf.d/nginx.conf

COPY ./conf/entrypoint.sh /entrypoint.sh

#Write the following 2 lines if you are using windows
RUN apt-get update && apt-get install -y dos2unix
RUN dos2unix /entrypoint.sh && dos2unix /etc/nginx/conf.d/nginx.conf && apt-get --purge remove -y dos2unix 


RUN chmod 777 /uwsgi-nginx-entrypoint.sh && chmod 777 /entrypoint.sh && chmod 777 /etc/nginx/nginx.conf

RUN mkdir -p /usr/src/app

COPY ./data/* /usr/src/app/ 
COPY ./conf/* /usr/src/app/ 
COPY ./src/* /usr/src/app/

WORKDIR /usr/src/app

RUN pip3 install -r /usr/src/app/requirements.txt

CMD ["python","/usr/src/app/rest_api_example.py"]

expose 5000