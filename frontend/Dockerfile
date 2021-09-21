FROM node:15.8.0-alpine

WORKDIR /usr/src/app

COPY package.json yarn.lock ./

RUN yarn install

COPY . .

USER node

CMD yarn serve