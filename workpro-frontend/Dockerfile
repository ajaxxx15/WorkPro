FROM node:carbon

WORKDIR /app

COPY . .

RUN npm install 

RUN npm install -g http-server  

RUN npm run build

WORKDIR /app/dist/workpro-frontend

CMD ["http-server", "-c1", "-p", "8000"]


